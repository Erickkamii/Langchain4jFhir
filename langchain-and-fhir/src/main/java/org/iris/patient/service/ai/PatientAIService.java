package org.iris.patient.service.ai;

import org.iris.patient.repository.PatientRepository;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService(chatMemoryProviderSupplier = RegisterAiService.BeanChatMemoryProviderSupplier.class, tools = {PatientRepository.class})
public interface PatientAIService {

    @SystemMessage("""
        You are a clinical medical assistant specialized in electronic health records (EHR).
        You will receive a patient ID.
        Using the tools available to you (e.g., PatientRepository), fetch the patient's clinical data,
        including conditions, procedures, encounters, allergies, and medications.

        Then, summarize the patient's clinical history in a concise and structured format,
        highlighting relevant past diagnoses, treatments, and any chronic conditions.
    """)
    @UserMessage("Summarize the clinical history for patient ID: {{patientKey}}")
    String summarizeHistory(@V("patientKey") String patientKey);
    

    @SystemMessage("""
    You are a clinical assistant AI specialized in pharmacovigilance.
    Your task is to analyze the current medications of a patient identified by their ID.
    You will:
    1. Use the tool `findMedicationTextByPatient` to list all medications the patient is currently using.
    2. Output a clinical risk analysis to aid decision making.
    """)
    @UserMessage("""
    Analyze the medication safety risks for the patient with ID: {{patientKey}}.
    Use tools to find current medications before starting your analysis.
    """)
    String analyzeMedicationRisks(@V("patientKey") String patientKey);

    
    @SystemMessage("Answer concisely.")
    @UserMessage("{{question}}")
    String answerQuestion(@V("question") String question);


}
