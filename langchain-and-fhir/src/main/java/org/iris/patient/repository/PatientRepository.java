package org.iris.patient.repository;


import org.iris.patient.model.Patient;
import jakarta.enterprise.context.ApplicationScoped;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class PatientRepository implements PanacheRepository<Patient> {

    public String findNameByKey(String key) {
        Patient patient = find("key", key).firstResult();
        return patient != null ? patient.name : null;
    }
}