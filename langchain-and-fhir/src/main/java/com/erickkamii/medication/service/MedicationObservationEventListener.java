package com.erickkamii.medication.service;

import com.erickkamii.medication.model.MedicationObservation;
import com.erickkamii.patient.service.PatientService;
import io.vertx.core.eventbus.EventBus;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;

import java.util.concurrent.CompletionStage;

@ApplicationScoped
public class MedicationObservationEventListener {
    @Inject
    PatientService patientService;

    @Inject
    EventBus eventBus;


    @Transactional
    @Incoming("medication_request")
    public CompletionStage<Void> onIncomingMessage(Message<MedicationObservation> medicationObservationMessage){
        var medicationObservation
    }
}
