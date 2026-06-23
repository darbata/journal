from fastapi import APIRouter, Depends

from app.config.ml_models import ml_models
from app.schemas.journal_entry import JournalEntry
from app.services.classification import ClassificationService

router = APIRouter(prefix="/api/classification")

@router.post("")
async def classify_journal_entry(
        entry: JournalEntry,
        service: ClassificationService = Depends()
):
    return service.classify(entry.content)

@router.get("/health", status_code=200)
async def health_check():
    ready = "emotion_classifier" in ml_models
    return {"status": "UP" if ready else "DOWN"}
