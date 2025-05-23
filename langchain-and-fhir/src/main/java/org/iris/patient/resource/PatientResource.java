package org.iris.patient.resource;

import java.util.List;

import org.iris.patient.repository.PatientRepository;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/patient")
public class PatientResource {

    @Inject
    PatientRepository patientRepository;
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public List<String> getPatientNameByKey(@QueryParam("key") String key) {
        return patientRepository.findMedicationTextByPatient(key);
    }
}
