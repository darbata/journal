import os

from pydantic_settings import BaseSettings

class Settings(BaseSettings):
    model_path: str

settings = Settings()
