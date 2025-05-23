package org.iris.patient.service;

import org.iris.patient.repository.PatientRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class PatientService {
    @Inject
    PatientRepository patientRepository;

    public Object patientGetInfo(String patientKey) {
        return patientRepository.findAllergyByPatient(patientKey);
    }
}
