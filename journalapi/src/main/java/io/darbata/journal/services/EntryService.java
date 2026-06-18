package io.darbata.journal.services;

import io.darbata.journal.repositories.EntryRepository;
import org.springframework.stereotype.Service;

@Service
public class EntryService {

    private final EntryRepository entryRepository;

    public EntryService(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }


}
