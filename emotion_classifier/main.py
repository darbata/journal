from fastapi import FastAPI
from pydantic import BaseModel

class JournalEntry(BaseModel):
    content: str


app = FastAPI()

@app.get("/api/classify")
async def classify_journal_entry(entry : JournalEntry):
