package io.darbata.journal.services;

import io.darbata.journal.models.EmotionClassificationResult;

import java.util.Map;
import java.util.UUID;

public record EntryEmotionsClassified (
        UUID entryId,
        Map<EmotionClassificationResult.Emotion, Double> scores
) { }