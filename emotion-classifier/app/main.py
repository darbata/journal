import asyncio
from contextlib import asynccontextmanager

from fastapi import FastAPI
from transformers import pipeline

from app.config.ml_models import ml_models
from app.config.rabbit_connection import rabbit_connection
from app.routers import classification
from app.services.amqp_listener import amqp_listener
from app.config.settings import settings

@asynccontextmanager
async def lifespan(app: FastAPI):
    ml_models["emotion_classifier"] = pipeline("text-classification", model=settings.model_path, top_k=None)
    await rabbit_connection.connect()
    task = asyncio.create_task(amqp_listener.handle_new_entries())

    def _log_if_died(t: asyncio.Task):
        if t.cancelled():
            return
        exc = t.exception()
        if exc:
            import logging
            logging.getLogger("amqp").exception("listener task died", exc_info=exc)

    task.add_done_callback(_log_if_died)
    app.state.listener_task = task   # hold a reference so it isn't GC'd
    yield
    task.cancel()

app = FastAPI(lifespan=lifespan)

app.include_router(classification.router)