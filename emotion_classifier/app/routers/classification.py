from fastapi import APIRouter, Depends
from app.schemas.classification_result import ClassificationResult
from app.schemas.journal_entry import JournalEntry
from app.services.classification import ClassificationService

router = APIRouter(prefix="/api/classification")

@router.post("")
async def classify_journal_entry(
        entry: JournalEntry,
        service: ClassificationService = Depends()
):
    return service.classify(entry.content)
