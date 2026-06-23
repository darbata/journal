from pydantic import BaseModel

class JournalEntry(BaseModel):
    content: str