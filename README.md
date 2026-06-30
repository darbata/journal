# Journal Application

A web application designed for no friction journaling. The user experience involves a minimal writing experience, analysis of entries is done in the background asynchronously using an ML (non-LLM) model.

<img width="1666" height="649" alt="Screenshot from 2026-06-30 14-03-29" src="https://github.com/user-attachments/assets/fdbd68be-cb43-40fb-b6cb-cfcdca2cee4c" />

## Why did I build this?
- To learn how to deploy an ML model -> used hugging face model, installed weights and wrapped model behind endpoints using FastAPI, then containerised both FastAPI application and weights.
    - This led to a heavy ~1Gb image, will look into if this can be downsized or not.
- Interesting Kubernetes deployment scenario, where ML model pods should sit on worker nodes that have access to a GPU.
- I believe it's a genuinely useful application.
- Want to avoid costs associated with LLM API's while still being able to achieve comparable application features.

## Current features
- User can write entries - CRUD via Spring Boot.
- User can view past entries grouped by days - CRUD via Spring Boot.
- User entries are asynchronously analysed for 'emotion scores' - RabbitMQ Worker Queue Pattern + FastAPI wrapped Hugging Face model.

## Future features - and potential technical solutions
- User can view the trends associated with their entries and emotions - SQL Queries.
- User can view entries that are semantically and emotionally similar to a given entry - Vector Database + Vector Query (`pg_vector`).
- User can dictate their entries - Frontend microphone access, transcription service in backend likely.
