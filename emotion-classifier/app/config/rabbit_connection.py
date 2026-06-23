import json

from aio_pika import Message, connect_robust
from aio_pika.abc import AbstractRobustConnection, AbstractRobustChannel

from app.config.settings import settings


class RabbitConnection():

    connection: AbstractRobustConnection | None = None
    channel: AbstractRobustChannel | None = None

    def status(self) -> bool:
        if self.connection is None:
            return False

        if self.connection.is_closed or self.channel.is_closed:
            return False
        return True

    async def _clear(self) -> None:
        if not self.connection.is_closed:
            await self.connection.close()
        if not self.channel.is_closed:
            await self.channel.close()

        self.connection = None
        self.channel = None

    async def connect(self) -> None:
        try:
            self.connection = await connect_robust(settings.broker_url)
            self.channel = await self.connection.channel(publisher_confirms=False)
        except Exception as e:
            await self._clear()

    async def disconnect(self) -> None:
        await self._clear()

    async def publish_event(
            self,
            event,
            routing_key: str
    ) -> None:
        if not self.channel:
            raise RuntimeError("no connection")

        async with self.channel.transaction():
            message = Message(body=event.model_dump_json().encode())
            await self.channel.default_exchange.publish(message, routing_key=routing_key)

rabbit_connection = RabbitConnection()