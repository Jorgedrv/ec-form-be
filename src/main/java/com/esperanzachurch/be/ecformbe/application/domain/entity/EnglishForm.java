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
@Table(name = "EC_ENGLISH_FORM")
public class EnglishForm implements Serializable {

    private static final long serialVersionUID = 7926427583703150812L;

    @Id
    @Column(name = "ECE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ECE_NAME")
    private String name;

    @Column(name = "ECE_LAST_NAME")
    private String lastName;

    @Column(name = "ECE_STREET")
    private String street;

    @Column(name = "ECE_CITY")
    private String city;

    @Column(name = "ECE_POSTAL_CODE")
    private Integer postalCode;

    @Column(name = "ECE_PHONE")
    private String phone;

    @Column(name = "ECE_EMAIL")
    private String email;

    @Column(name = "ECE_COUNTRY_OF_BIRTH")
    private String countryOfBirth;

    @Column(name = "ECE_AGE")
    private Integer age;

    @Column(name = "ECE_EDUCATION")
    private String education;

    @Column(name = "ECE_ENGLISH_LEVEL")
    private String englishLevel;
}
