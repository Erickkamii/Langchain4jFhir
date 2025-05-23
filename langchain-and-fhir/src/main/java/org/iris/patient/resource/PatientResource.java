package org.iris.patient.resource;

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
    public String getPatientNameByKey(@QueryParam("key") String key) {
        return patientRepository.findNameByKey(key);
    }
}
