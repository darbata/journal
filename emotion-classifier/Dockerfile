FROM python:3.13-slim

WORKDIR /src

RUN ["mkdir", "-p", "/src/model"]

RUN ["pip", "install", "--no-cache-dir", "huggingface_hub[cli]"]

RUN ["hf", "download", "j-hartmann/emotion-english-distilroberta-base", "--local-dir", "/src/model"]

COPY app/ ./app/

COPY requirements.txt .

RUN ["pip", "install", "--no-cache-dir", "-r", "requirements.txt"]

ENV MODEL_PATH=model/

EXPOSE 8000

CMD ["fastapi", "run", "app/main.py", "--host", "0.0.0.0", "--port", "8000"]
