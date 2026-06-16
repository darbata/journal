from fastapi import FastAPI
from pydantic import BaseModel
from transformers import pipeline

classifier = pipeline("text-classification", model="./models/emotion-english-distilroberta-base/", top_k=None)

class JournalEntry(BaseModel):
    content: str

def classify(entry: str):
    return classifier(entry)

app = FastAPI()

@app.post("/api/classify")
async def classify_journal_entry(entry : JournalEntry):
    return classify(entry)
