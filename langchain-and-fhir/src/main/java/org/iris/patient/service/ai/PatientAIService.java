package org.iris.patient.service.ai;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService
public interface PatientAIService {
    @SystemMessage("Answer concisely.")
    @UserMessage("{{question}}")
    String answerQuestion(@V("question") String question);
}
