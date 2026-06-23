from app.config.rabbit_connection import rabbit_connection
from app.schemas.entry_created_event import EntryCreatedEvent
from app.services.classification import ClassificationService

class AmqpListener:

    def __init__(self) -> None:
        self.service = ClassificationService()

    async def handle_new_entries(self) -> None:

        queue = await rabbit_connection.channel.declare_queue("entries.created", durable=True)
        async with queue.iterator() as i:
            async for message in i:
                async with message.process():
                    event: EntryCreatedEvent = EntryCreatedEvent.model_validate_json(message.body)
                    await self.service.handle_created_entry(event)

amqp_listener = AmqpListener()