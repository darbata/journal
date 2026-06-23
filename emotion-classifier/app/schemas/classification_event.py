from uuid import UUID

from pydantic import BaseModel

from app.schemas.emotion_classification_result import Emotion

class ClassificationEvent(BaseModel):
    entryId: UUID
    scores: dict[Emotion, float]