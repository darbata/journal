package io.darbata.journal.repositories;

import io.darbata.journal.models.Emotion;
import io.darbata.journal.models.Entry;
import io.darbata.journal.models.UserID;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface EntryRepository {
    void create(Entry entry);
    Optional<Entry> findById(UUID id);
    List<Entry> findAllByUserID(UserID userID, Instant from, int limit);
    void update(Entry entry);
    void updateEmotionsById(UUID id, Map<Emotion, Double> emotions);
    void delete(UUID id);
}