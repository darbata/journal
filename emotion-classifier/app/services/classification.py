from fastapi import Depends

from app.config import settings
from app.main import ml_models
from app.schemas.classification_event import ClassificationEvent
from app.schemas.entry import Entry
from app.schemas.entry_created_event import EntryCreatedEvent
from app.services.amqp_publisher import AmqpPublisher
from app.services.http_client import JournalApiClient

MODEL_PATH = settings.model_path

class ClassificationService:

    def classify(self, content: str) -> dict[str, float]:
        result: list[dict[str, float]] = ml_models["emotion_classifier"](content)
        return result[0]

    def handle_created_entry(
            self,
            event: EntryCreatedEvent,
            client: JournalApiClient = Depends(),
            publisher: AmqpPublisher = Depends()
    ) -> None:
        entry: Entry = client.getEntryById(event.entryId)
        scores: list[dict[str, float]] = ml_models["emotion_classifier"](entry.content)
        event = ClassificationEvent(entryId=entry.id, scores=scores)
        publisher.publish_event(event, "entries.classifications")