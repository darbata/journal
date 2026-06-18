from app.schemas.classification_result import ClassificationResult
from transformers import pipeline
from app.config import settings

MODEL_PATH = settings.model_path

classifier = pipeline("text-classification", model=MODEL_PATH, top_k=None)

class ClassificationService:
    def classify(self, content: str) -> ClassificationResult:
        return classifier(content)
