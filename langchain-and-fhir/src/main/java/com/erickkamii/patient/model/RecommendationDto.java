package com.erickkamii.patient.model;

import lombok.Data;

@Data
public class RecommendationDto {
    private int durationInDays;
    private String reason;
    private String detectedIssue;
}
