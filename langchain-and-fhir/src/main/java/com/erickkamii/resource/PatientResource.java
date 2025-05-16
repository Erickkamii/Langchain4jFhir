package com.erickkamii.resource;

import com.erickkamii.model.MedicationRecommendationDto;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("patients")
public class PatientResource {
    @GET
    @Path("{patientId}/recomendations")
    public MedicationRecommendationDto getRecomendedMedication(@PathParam("patientId") Long id){
        return medicationRecomMendationService.getRecomendation(id);
    }
}
