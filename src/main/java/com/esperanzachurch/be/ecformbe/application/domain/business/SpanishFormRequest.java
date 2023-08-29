package com.esperanzachurch.be.ecformbe.application.domain.business;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SpanishFormRequest implements Serializable {

    private static final long serialVersionUID = 5234615234075151803L;

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
    private String spanishLevel;
}
