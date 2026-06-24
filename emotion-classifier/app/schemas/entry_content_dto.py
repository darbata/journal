from datetime import datetime
from pydantic import BaseModel, ConfigDict
from pydantic.alias_generators import to_camel

from app.schemas.emotion_classification_result import Emotion

class Entry(BaseModel):
    model_config = ConfigDict(alias_generator=to_camel, populate_by_name=True)

    id: str
    authorId: str
    title: str
    content: str
    emotions: dict[Emotion, float] | None = None
    created_at: datetime
    updated_at: datetime