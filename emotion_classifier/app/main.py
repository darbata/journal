from fastapi import FastAPI
from pydantic import BaseModel
from app.routers import classification

app = FastAPI()

app.include_router(classification.router)
