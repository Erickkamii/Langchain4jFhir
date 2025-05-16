package com.erickkamii.patient.service;

import com.erickkamii.patient.model.Observation;
import com.erickkamii.patient.model.Patient;
import dev.langchain4j.agent.tool.Tool;
import io.quarkus.arc.Unremovable;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Unremovable
@ApplicationScoped
@Slf4j
public class PatientRepository {
    @Tool("Get anamnesis information for a given patient id")
    public Patient getAnamnesis(Long patientId) {
        log.info("getAnamnesis called with id "+ patientId);
        Patient patient = Patient.findById(patientId);
        return patient;
    }

    @Tool("Get the last clinical results for a certain patient id")
    public List<Observation> getObservations(Long patientId){
        log.info("getObservations called with id "+ patientId);
        Patient patient = Patient.findById(patientId);
        return patient.getObservationsList();
    }
}
