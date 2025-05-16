package com.erickkamii.model;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@RegisterForReflection
@Data
public class MedicationRecommendationDto {
    private String medicationId;
    private String dosage;
    private List<RecommendationDto> recommendations = new ArrayList<>();
}
