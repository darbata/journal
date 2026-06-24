package io.darbata.journal.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Emotion {
    @JsonProperty("none") NONE,
    @JsonProperty("anger") ANGER,
    @JsonProperty("disgust") DISGUST,
    @JsonProperty("fear") FEAR,
    @JsonProperty("joy") JOY,
    @JsonProperty("neutral") NEUTRAL,
    @JsonProperty("sadness") SADNESS,
    @JsonProperty("surprise") SURPRISE
}

