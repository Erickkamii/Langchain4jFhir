package org.iris.patient.resource;

import java.util.List;

import org.iris.patient.repository.PatientRepository;
import org.iris.patient.service.ai.PatientAIService;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/patient")
public class PatientResource {

    @Inject
    PatientAIService patientAIService;

    @GET
    @Path("/ia/analyze-medication")
    @Produces(MediaType.TEXT_PLAIN)
    public String analyzeMedicationRisks(@QueryParam("key") String key) {

        return patientAIService.analyzeMedicationRisks(key);
    }
}
