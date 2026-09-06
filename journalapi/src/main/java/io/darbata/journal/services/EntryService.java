package io.darbata.journal.services;

import io.darbata.journal.dto.EntryContentDTO;
import io.darbata.journal.dto.EntryDTO;
import io.darbata.journal.events.EntryCreatedEvent;
import io.darbata.journal.exceptions.EntryNotFoundException;
import io.darbata.journal.amqp.JournalEventSender;
import io.darbata.journal.exceptions.UnauthorisedAccessException;
import io.darbata.journal.models.Emotion;
import io.darbata.journal.models.Entry;
import io.darbata.journal.models.UserID;
import io.darbata.journal.repositories.EntryRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class EntryService {

    private final EntryRepository entryRepository;
    private final JournalEventSender journalEventSender;

    public EntryService(EntryRepository entryRepository, JournalEventSender journalEventSender) {
        this.entryRepository = entryRepository;
        this.journalEventSender = journalEventSender;
    }

    public EntryDTO create(String authorId, String title, String content) {
 Entry entry = Entry.create(new UserID(authorId), title, content);

        this.entryRepository.create(entry);

        journalEventSender.sendEntryCreatedEvent(EntryCreatedEvent.from(entry.getId()));

        return entryModelToDTO(entry);
    }

    public EntryDTO findById(String userId, UUID id) {
        UserID user = new UserID(userId);

        Entry entry = this.entryRepository.findById(id)
                .orElseThrow(() -> new EntryNotFoundException("Entry of id " + id + " was not found"));

        if (!user.equals(entry.getAuthorId())) {
            throw new UnauthorisedAccessException("User may not view this entry");
        }
        return entryModelToDTO(entry);
    }

    public List<EntryDTO> findAllByUserId(String userId) {
        // TODO: time based pagination
        int paginationLimit = 50;
        UserID user = new UserID(userId);
        List<Entry> entries = entryRepository.findAllByUserID(user, Instant.now(), paginationLimit);
        return entries.stream()
                .map(this::entryModelToDTO)
                .toList();
    }

    public EntryDTO updateById(String id, UUID entryId, String updatedTitle, String updatedContent) {
        UserID userId = new UserID(id);

        Entry entry = this.entryRepository.findById(entryId)
                .orElseThrow(() -> new EntryNotFoundException("Entry of id " + id + " was not found"));

        if (userId.equals(entry.getAuthorId())) {
            throw new UnauthorisedAccessException("User may not access this entry");
        }

        entry.setTitle(updatedTitle);
        entry.setContent(updatedContent);
        entry.setUpdatedAt(Instant.now());

        this.entryRepository.update(entry);

        return entryModelToDTO(entry);
    }

    public void assignEmotionsById(UUID id, Map<Emotion, Double> emotions) {

        Entry entry = entryRepository.findById(id)
                .orElseThrow(() -> new EntryNotFoundException("Entry of id " + id + " was not found"));

        entry.setEmotions(emotions);

        this.entryRepository.update(entry);
    }

    public void delete(String id, UUID entryId) {
        UserID userId = new UserID(id);

        Entry entry = this.entryRepository.findById(entryId)
                .orElseThrow(() -> new EntryNotFoundException("Entry of id " + entryId + " was not found"));

        if (userId.equals(entry.getAuthorId())) {
            throw new UnauthorisedAccessException("User may not access this entry");
        }
        this.entryRepository.delete(entryId);
    }

    private EntryDTO entryModelToDTO (Entry e) {
        return new EntryDTO(e.getId(), e.getAuthorId().value(), e.getTitle(), e.getContent(), e.getDominant(),
                e.getEmotions(), e.isAnalysed(), e.getCreatedAt(), e.getUpdatedAt());
    }

    public EntryContentDTO getEntryContentById(UUID id) {
        Entry entry = entryRepository.findById(id)
                .orElseThrow(() -> new EntryNotFoundException("Entry of id " + id + " was not found"));

        return new EntryContentDTO(
                id,
                entry.getContent()
        );
    }
}
