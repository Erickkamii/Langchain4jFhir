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

![alt text](/img/summary.png)

## Features

All endpoints use the LLM to process and respond based on the patient’s medical history.

- `/patiant/ia/analyze-medication`: Summarizes the patient’s medication history and recommends safe treatment paths.
- `/patient/ia/answer-question`: Lets the user ask questions about the patient’s medical profile (conditions, allergies) and suggests possible care strategies.
- `/patient/ia/conditions-history`: Summarizes known medical conditions and offers tailored recommendations.
- `/patient/info`: Ingests patient anamnesis for analysis.

All endpoints are testable via Swagger UI.

![alt text](/img/endpoints.png)

## Example response

endpoint:
`/patient/ia/answer-question`

Patient/3
Can a patient donate blood?

Response:

"Based on the patient's clinical data, a patient with Patient ID: Patient/3 cannot donate blood. The patient is currently taking Amoxicillin 250 MG / Clavulanate 125 MG Oral Tablet and has a history of viral sinusitis, acute viral pharyngitis, and streptococcal sore throat.

Therefore, I cannot advise the patient to donate blood at this time due to the potential risks associated with their current medications and medical conditions. It is essential for the patient to consult their doctor before donating blood to discuss any concerns or modifications to their treatment plan."

## Important Links

[SQL IRIS PORTAL.]
http://localhost:52774/csp/sys/exp/%CSP.UI.Portal.SQL.Home.zen?$NAMESPACE=FHIRSERVER

[LLM ollama]
http://localhost:11434/

[ollama web ui chat]
http://localhost:3000/

[swagger-ui]
http://localhost:8080/q/swagger-ui/

## Application

[Video Application](https://www.youtube.com/watch?v=jEz9Utib5Wk)

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

[Erick Murakami](http://www.linkedin.com/in/erick-murakami)

[Erick Murakami - Intersystem Community link](https://community.intersystems.com/user/erick-hideki-murakami)

[Davi Muta](https://www.linkedin.com/in/davi-massaru-teixeira-muta-003284191/)

[Davi Muta - Intersystem Community link](https://community.intersystems.com/user/davi-massaru-teixeira-muta)
