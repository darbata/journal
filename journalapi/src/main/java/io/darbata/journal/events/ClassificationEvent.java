package io.darbata.journal.events;

import io.darbata.journal.models.EmotionClassificationResult;

import java.util.Map;
import java.util.UUID;

public record ClassificationEvent (
        UUID entryId,
        Map<EmotionClassificationResult.Emotion, Double> scores
) { }
