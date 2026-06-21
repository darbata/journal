package io.darbata.journal.services;

import io.darbata.journal.dto.EntryDTO;
import io.darbata.journal.exceptions.EntryNotFoundException;
import io.darbata.journal.messaging.JournalEventSender;
import io.darbata.journal.models.EmotionClassificationResult;
import io.darbata.journal.models.Entry;
import io.darbata.journal.models.UserID;
import io.darbata.journal.repositories.EntryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
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
 Entry entry = Entry.create(UserID.of(authorId), title, content);

        this.entryRepository.create(entry);

        // journalEventSender.sendEntryCreatedEvent(EntryCreatedEvent.from(entry.getId()));

        return entryModelToDTO(entry);
    }

    public EntryDTO findById(UUID id) {
        Entry entry = this.entryRepository.findById(id)
                .orElseThrow(() -> new EntryNotFoundException("Entry of id " + id + " was not found"));

        return entryModelToDTO(entry);
    }

    public List<EntryDTO> findAllByUserId(String userId) {
        // TODO: time based pagination
        int paginationLimit = 50;
        UserID user = UserID.of(userId);
        List<Entry> entries = entryRepository.findAllByUserID(user, Instant.now(), paginationLimit);
        return entries.stream()
                .map(this::entryModelToDTO)
                .toList();
    }

    public EntryDTO updateById(UUID id, String updatedTitle, String updatedContent) {
        Entry entry = this.entryRepository.findById(id)
                .orElseThrow(() -> new EntryNotFoundException("Entry of id " + id + " was not found"));

        entry.setTitle(updatedTitle);
        entry.setContent(updatedContent);
        entry.setUpdatedAt(Instant.now());

        this.entryRepository.update(entry);

        return entryModelToDTO(entry);
    }

    @Transactional
    public EntryDTO assignEmotionsById(UUID id, EmotionClassificationResult emotions) {
        entryRepository.updateEmotionsById(id, emotions);

        Entry entry = entryRepository.findById(id).orElseThrow(
                () -> new EntryNotFoundException("Entry of id " + id + " was not found"));

        return entryModelToDTO(entry);

    }

    public void delete(UUID id) {
        this.entryRepository.delete(id);
    }

    private EntryDTO entryModelToDTO (Entry e) {
        return new EntryDTO(e.getId(), e.getAuthorId().getId(), e.getTitle(), e.getContent(), e.getEmotions(), e.getCreatedAt(),
                e.getUpdatedAt());
    }

}
