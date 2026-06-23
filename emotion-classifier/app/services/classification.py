import asyncio

from app.config.ml_models import ml_models
from app.config.rabbit_connection import rabbit_connection
from app.schemas.classification_event import ClassificationEvent
from app.schemas.emotion_classification_result import Emotion
from app.schemas.entry import Entry
from app.schemas.entry_created_event import EntryCreatedEvent
from app.services.http_client import journal_api_client

class ClassificationService:

    def classify(self, content: str) -> dict[Emotion, float]:
        result = ml_models["emotion_classifier"](content)  # list[list[dict]]
        return {Emotion(r["label"]): r["score"] for r in result[0]}

    async def handle_created_entry(self,event: EntryCreatedEvent,) -> None:
        entry: Entry = await journal_api_client.get_entry_by_id(event.entryId)
        scores = await asyncio.to_thread(self.classify, entry.content)
        classification = ClassificationEvent(entryId=entry.id, scores=scores)
        await rabbit_connection.publish_event(classification, "entries.classifications")