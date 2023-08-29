package com.esperanzachurch.be.ecformbe.application.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "EC_SPANISH_FORM")
public class SpanishForm implements Serializable {

    private static final long serialVersionUID = 7126427283703150815L;

    @Id
    @Column(name = "ECS_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ECS_NAME")
    private String name;

    @Column(name = "ECS_LAST_NAME")
    private String lastName;

    @Column(name = "ECS_STREET")
    private String street;

    @Column(name = "ECS_CITY")
    private String city;

    @Column(name = "ECS_POSTAL_CODE")
    private Integer postalCode;

    @Column(name = "ECS_PHONE")
    private String phone;

    @Column(name = "ECS_EMAIL")
    private String email;

    @Column(name = "ECS_COUNTRY_OF_BIRTH")
    private String countryOfBirth;

    @Column(name = "ECS_AGE")
    private Integer age;

    @Column(name = "ECS_SPANISH_LEVEL")
    private String spanishLevel;
}
