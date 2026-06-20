package io.darbata.journal.models;

import java.util.Map;

public record EmotionClassificationResult (
        Map<Emotion, Double> scores
) {
    public enum Emotion {
        ANGER,
        DISGUST,
        FEAR,
        JOY,
        NEUTRAL,
        SADNESS,
        SURPRISE
    }
}

