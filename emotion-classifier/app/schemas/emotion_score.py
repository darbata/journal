from pydantic import BaseModel

class EmotionScore(BaseModel):
    label: str
    score: float

