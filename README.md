# Langchain4j and Fhir

## Introduction

Emergency rooms operate in high-pressure environments, where patients may be unconscious or unable to communicate accurately about their medical history. This can lead to critical mistakes, especially involving allergies or prescribed medications.

To address this, our solution integrates with the IRIS database to automatically analyze a patient's anamnesis and generate a natural language summary. This helps reduce medical errors by quickly surfacing important information such as:

- Pre-existing conditions
- Known allergies (e.g. risk of anaphylactic shock)
- Current medications (e.g. risk of overdose or drug interactions)

With this system, healthcare providers can focus on delivering fast and accurate care, minimizing risks and complications.

## Summary

This is a Quarkus-based backend that uses LangChain4j and LLaMA 3.2 (1B) via Ollama to process and summarize patient data stored in the IRIS SQL database.

The system fetches the patient’s anamnesis using `PatientRepository`, parses the relevant fields (allergies, medications, and medical conditions), and sends them to `PatientAIService`. The AI then generates a natural language summary — clear and readable for non-technical users — without exposing raw JSON.

## Features

All endpoints use the LLM to process and respond based on the patient’s medical history.

- `/analyze-medication-risk`: Summarizes the patient’s medication history and recommends safe treatment paths.
- `/ask`: Lets the user ask questions about the patient’s medical profile (conditions, allergies) and suggests possible care strategies.
- `/condition-history`: Summarizes known medical conditions and offers tailored recommendations.
- `/receive-patient-data`: Ingests patient anamnesis for analysis.

All endpoints are testable via Swagger UI.

![alt text](/img/endpoints.png)

## Prerequisites

- Docker Desktop
- Java JDK 17

## Installation

```bash
git clone https://github.com/Erickkamii/Langchain4jFhir.git
cd Langchain4jFhir
docker-compose up -d
```

Then, in a new terminal:

```bash
cd langchain-and-fhir
./mvnw clean
./mvnw install:install-file -Dfile="src/main/resources/lib/intersystems-jdbc-3.7.1.jar" \
  -DgroupId="com.intersystems" -DartifactId="intersystems-jdbc" \
  -Dversion="3.7.1" -Dpackaging=jar
./mvnw quarkus:dev
```

## Patient Data

The system loads 22 sample patients from /iris/data during Docker build, so you can test the system out of the box.

## Dockerfile

The docker-compose setup launches:

IRIS database

Ollama with LLaMA 3.2 1B model

Open Web UI for chatting with the LLM locally

## Thanks
