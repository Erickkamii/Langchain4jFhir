package org.iris.patient.repository;


import java.util.List;
import java.util.stream.Collectors;

import org.iris.patient.model.Patient;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class PatientRepository implements PanacheRepository<Patient> {

    @Inject
    EntityManager em;

    @Inject
    ObjectMapper mapper;

    public String findNameByKey(String key) {
        Patient patient = find("key", key).firstResult();
        return patient != null ? patient.name : null;
    }
    
    @SuppressWarnings("unchecked")
    public List<String> findMedicationTextByPatient(String patientKey) {
        List<String> resourceJsonList = em.createNativeQuery("""
                SELECT ResourceString
                FROM HSFHIR_X0001_R.Rsrc
                WHERE Key IN (
                    SELECT Key 
                    FROM HSFHIR_X0001_S.MedicationRequest 
                    WHERE patient = :patientKey
                )
            """)
            .setParameter("patientKey", patientKey)
            .getResultList();

        return resourceJsonList.stream()
            .map(this::extractMedicationText)
            .filter(text -> text != null && !text.isBlank())
            .distinct()
            .toList();
    }

    private String extractMedicationText(String json) {
        try {
            JsonNode node = mapper.readTree(json);
            return node.at("/medicationCodeableConcept/text").asText();
        } catch (Exception e) {
            return null;
        }
    }


}