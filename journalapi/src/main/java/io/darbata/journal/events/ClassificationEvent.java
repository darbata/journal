package io.darbata.journal.events;

import io.darbata.journal.models.Emotion;

import java.util.Map;
import java.util.UUID;

public record ClassificationEvent (
        UUID entryId,
        Map<Emotion, Double> scores
) { }
