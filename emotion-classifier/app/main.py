from contextlib import asynccontextmanager

from fastapi import FastAPI
from transformers import pipeline

from app.routers import classification
from config import settings

ml_models = {}

@asynccontextmanager
async def lifespan(app: FastAPI):
    ml_models["emotion_classifier"] = pipeline("text-classification", model=settings.model_path, top_k=None)
    yield

app = FastAPI(lifespan=lifespan)

app.include_router(classification.router)