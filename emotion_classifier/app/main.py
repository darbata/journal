from fastapi import FastAPI
from app.routers import classification

app = FastAPI()

app.include_router(classification.router)
