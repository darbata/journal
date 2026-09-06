package io.darbata.journal.controllers;

import io.darbata.journal.dto.CreateEntryRequest;
import io.darbata.journal.dto.EntryContentDTO;
import io.darbata.journal.dto.EntryDTO;
import io.darbata.journal.dto.UpdateEntryRequest;
import io.darbata.journal.services.EntryService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/entries")
class JournalController {

    private final EntryService entryService;

    public JournalController(EntryService entryService) {
        this.entryService = entryService;
    }

    @GetMapping("")
    public ResponseEntity<List<EntryDTO>> findAllEntriesByUserId(
            @AuthenticationPrincipal Jwt jwt
    ) {
        List<EntryDTO> dto = entryService.findAllByUserId(jwt.getSubject());
        return ResponseEntity.ok(dto);
    }

    // TODO: move to SQS
    // to be used by internal services e.g. emotion classification
    @GetMapping("/{id}/internal")
    public ResponseEntity<EntryContentDTO> getEntryContentById (
            @PathVariable UUID id
    ) {
        EntryContentDTO dto = entryService.getEntryContentById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{entryId}")
    public ResponseEntity<EntryDTO> findById(
            @AuthenticationPrincipal Jwt jwt,
            @PathVariable UUID entryId
    ) {
        EntryDTO dto = entryService.findById(jwt.getSubject(), entryId);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("")
    public ResponseEntity<EntryDTO> createEntry(
            @AuthenticationPrincipal Jwt jwt,
            @Valid @NotBlank @RequestBody CreateEntryRequest request
    ) {
        EntryDTO dto = entryService.create(jwt.getSubject(), request.title(), request.content());
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @DeleteMapping("/{entryId}")
    public ResponseEntity<?> deleteById(
            @AuthenticationPrincipal Jwt jwt,
            @PathVariable UUID entryId
    ) {
        entryService.delete(jwt.getSubject(), entryId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/entries/{entryId}")
    public ResponseEntity<?> updateById(
            @AuthenticationPrincipal Jwt jwt,
            @PathVariable UUID entryId,
            @Valid @NotBlank @RequestBody UpdateEntryRequest request
    ) {
        return ResponseEntity.ok(entryService.updateById(jwt.getSubject(), entryId, request.title(), request.content()));
    }
}