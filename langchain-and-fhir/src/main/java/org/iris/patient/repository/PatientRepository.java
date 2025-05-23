package org.iris.patient.repository;


import java.util.List;

import org.iris.patient.model.Patient;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class PatientRepository implements PanacheRepository<Patient> {

    @Inject
    EntityManager em;
    
    public String findNameByKey(String key) {
        Patient patient = find("key", key).firstResult();
        return patient != null ? patient.name : null;
    }
    
    public List<String[]> findMedicationRequestData(String key) {
        List<Object[]> result = em.createNativeQuery("""
                SELECT ID1, Key 
                FROM HSFHIR_X0001_S.MedicationRequest 
                WHERE Key = :key
            """)
            .setParameter("key", key)
            .getResultList();

        List<String[]> converted = result.stream()
            .map(row -> new String[] { row[0].toString(), row[1].toString() })
            .toList();

        return converted;
    }


}