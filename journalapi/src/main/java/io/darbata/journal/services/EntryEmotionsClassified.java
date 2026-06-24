package io.darbata.journal.services;


import io.darbata.journal.models.Emotion;

import java.util.Map;
import java.util.UUID;

public record EntryEmotionsClassified (
        UUID entryId,
        Map<Emotion, Double> scores
) { }