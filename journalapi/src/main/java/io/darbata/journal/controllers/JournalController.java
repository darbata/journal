package io.darbata.journal.controllers;

import io.darbata.journal.dto.CreateEntryRequest;
import io.darbata.journal.dto.EntryContentDTO;
import io.darbata.journal.dto.EntryDTO;
import io.darbata.journal.services.EntryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/entries")
@CrossOrigin("http://localhost:5173/")
class JournalController {

    private final EntryService entryService;

    public JournalController(EntryService entryService) {
        this.entryService = entryService;
    }

    @GetMapping("")
    public ResponseEntity<List<EntryDTO>> findAllEntriesByUserId(
            @RequestHeader("X-User") String userId
    ) {
        List<EntryDTO> dto = entryService.findAllByUserId(userId);
        return ResponseEntity.ok(dto);
    }

    // to be used by internal services e.g. emotion classification
    @GetMapping("/{id}/internal")
    public ResponseEntity<EntryContentDTO> getEntryContentById (
            @PathVariable UUID id
    ) {
        EntryContentDTO dto = entryService.getEntryContentById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntryDTO> findById(
            @RequestHeader("X-User") String userId,
            @PathVariable UUID id
    ) {
        EntryDTO dto = entryService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("")
    public ResponseEntity<EntryDTO> createEntry(
            @RequestHeader("X-User") String authorId,
            @RequestBody CreateEntryRequest request
    ) {
        EntryDTO dto = entryService.create(authorId, request.title(), request.content());
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(
            @RequestHeader("X-User") String userId,
            @PathVariable UUID id
    ) {
        entryService.delete(id);
        return ResponseEntity.noContent().build();
    }



}