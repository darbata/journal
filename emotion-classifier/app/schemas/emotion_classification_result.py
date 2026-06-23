from enum import Enum

class Emotion(str, Enum):
    anger = "anger"
    disgust = "disgust"
    fear = "fear"
    joy = "joy"
    neutral = "neutral"
    sadness = "sadness"
    surprise = "surprise"