package com.erickkamii.patient.resource;

import com.erickkamii.patient.model.PatientRecommendationDto;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("patients")
public class PatientResource {
    @GET
    @Path("{patientId}/recomendations")
    public PatientRecommendationDto getRecomendedMedication(@PathParam("patientId") Long id){
        return medicationRecommendationService.getRecomendation(id);
    }
}
