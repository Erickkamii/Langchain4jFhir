package com.erickkamii.patient.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = {"id"}, callSuper = true)
public class Patient extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String reference;
    private boolean smokes;
    private boolean drinks;
    private Integer physicalActivitiesPerWeek;
    private String bloodPressure;
    private Double weight;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Observation> observationsList = new ArrayList<>();
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Medication> medicationList = new ArrayList<>();
}
