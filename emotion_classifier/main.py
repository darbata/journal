from fastapi import FastAPI
from pydantic import BaseModel
from transformers import pipeline

classifier = pipeline("text-classification", model="./models/emotion-english-distilroberta-base/", top_k=None)

class JournalEntry(BaseModel):
    content: str

class EmotionScore(BaseModel):
    label: str
    score: float

class ClassificationResult(BaseModel):
    emotions: list[EmotionScore]

def classify(entry: str) -> ClassificationResult:
    return classifier(entry)

app = FastAPI()

@app.post("/api/classify")
async def classify_journal_entry(entry : JournalEntry):
    return classify(entry.content)
