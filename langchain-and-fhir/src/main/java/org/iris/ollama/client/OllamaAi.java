package org.iris.ollama.client;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService
public interface OllamaAi {
    
    @SystemMessage("Answer concisely.")
    @UserMessage("{{question}}")
    String answerQuestion(@V("question") String question);
}
