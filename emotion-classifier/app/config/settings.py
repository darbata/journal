from pydantic_settings import BaseSettings

class Settings(BaseSettings):
    model_path: str # /home/dev/Developer/journal/emotion-classifier/model
    broker_url: str # amqp://guest:guest@localhost/
    journal_api_url: str

settings = Settings()
