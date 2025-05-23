package org.iris.ollama.service;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.iris.ollama.client.OllamaAi;

import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.infrastructure.Infrastructure;

@Path("/ollama")
public class OllamaService {

    @Inject
    OllamaAi ollamaAi;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> getOllama() {
        return Uni.createFrom()
                .item(() -> ollamaAi.answerQuestion("Count 10000000 pi numbers"))
                .runSubscriptionOn(Infrastructure.getDefaultWorkerPool());
    }
}
