from pydantic import BaseModel
from app.schemas.emotion_score import EmotionScore

class ClassificationResult(BaseModel):
    emotions: list[EmotionScore]
