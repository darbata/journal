# Emotion Classifier
Service responsible for assigning emotion classification floats to journal entries.

## How to run

### Docker
The Dockerfile at this stage handles importing the model weights, subject to change as I incorporate this service among other services likely via some shared volume etc. For now, all the required steps to build and run the application are below.

1. `docker build -t emotion_classifier:latest .`
2. `docker run -p 8000:8000 emotion_classifier:latest`

### Local Development
To run the application locally, you must install the HuggingFace model directly. Please view their documentation for the various ways you can do so, I recommend using their CLI tool. The remaining steps are described below.

1. Ensure [model](https://huggingface.co/j-hartmann/emotion-english-distilroberta-base) is downloaded locally
2. The application uses the environment variable `MODEL_PATH` please point it to local model weights
3. Ensure python environment includes all dependencies found in `requirements.txt`
4. In root run `fastapi dev`

## Model Licensing
I did **NOT** train the emotion classification model. The weights used can be found [here](https://huggingface.co/j-hartmann/emotion-english-distilroberta-base).

My usage of the model is for educational and non-commercial purposes only.

 > Jochen Hartmann, "Emotion English DistilRoBERTa-base", https://huggingface.co/j-hartmann/emotion-english-distilroberta-base/, 2022.
