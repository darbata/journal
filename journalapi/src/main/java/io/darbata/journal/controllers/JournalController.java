package io.darbata.journal.controllers;

import io.darbata.journal.dto.EntryDTO;
import io.darbata.journal.services.EntryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/entries")
class JournalController {

    private static final Logger log = LoggerFactory.getLogger(JournalController.class);
    private final EntryService entryService;

    public JournalController(EntryService entryService) {
        this.entryService = entryService;
    }

    @GetMapping("")
    public ResponseEntity<List<EntryDTO>> findAllEntriesByUserId(
            @RequestHeader("X-User") String userId
    ) {
        List<EntryDTO> dto = entryService.findAllByUserId(userId);
        log.trace("findAllEntriesByUserId({})", userId);
        return ResponseEntity.ok(dto);
    }

}