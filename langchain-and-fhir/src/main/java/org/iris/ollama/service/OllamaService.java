package org.iris.ollama.service;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.iris.ollama.client.OllamaAi;

@Path("/ollama")
public class OllamaService {
    
    @Inject
    OllamaAi ollamaAi;
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getOllama() {
        return ollamaAi.answerQuestion("Describe Quine-McCluskey algorithm.");
    }
    
}
