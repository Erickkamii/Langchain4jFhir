package com.erickkamii.medication.model;

import lombok.Data;

@Data
public class ValueQuantity {
    private Double value;
    private String unit;
    private String system;
    private String code;
}
