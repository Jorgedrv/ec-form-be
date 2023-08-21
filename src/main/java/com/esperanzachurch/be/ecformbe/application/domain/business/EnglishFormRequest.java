package com.esperanzachurch.be.ecformbe.application.domain.business;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnglishFormRequest implements Serializable {

    private static final long serialVersionUID = 5926468583005150809L;

    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String lastName;

    @NotNull
    private String street;

    @NotNull
    private String city;

    @NotNull
    private Integer postalCode;

    @NotNull
    private String phone;

    @NotNull
    private String email;

    @NotNull
    private String countryOfBirth;

    @NotNull
    private Integer age;

    @NotNull
    private String education;

    @NotNull
    private String englishLevel;
}
