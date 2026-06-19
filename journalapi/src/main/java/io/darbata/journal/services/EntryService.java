package io.darbata.journal.services;

import io.darbata.journal.dto.EntryDTO;
import io.darbata.journal.models.Entry;
import io.darbata.journal.models.UserID;
import io.darbata.journal.repositories.EntryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EntryService {

    private final EntryRepository entryRepository;

    public EntryService(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }

    public List<EntryDTO> findAllByUserId(String userId) {

        System.out.println("In service");

        UserID user = UserID.of(userId);

        List<Entry> entries = entryRepository.findAllByUserID(user);

        return entries.stream()
                .map((e) -> new EntryDTO(e.getId(), e.getAuthorId().getId(), e.getTitle(), e.getContent(),
                                e.getCreatedAt(), e.getUpdatedAt())
                )
                .toList();

    }

}
