package com.esperanzachurch.be.ecformbe.application.domain.business;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FormRequest implements Serializable {

    private static final long serialVersionUID = 5926468583005150809L;

    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String lastName;

    private String email;

    private String mobilePhone;

    private String street;

    private String city;

    private String state;

    private String postalCode;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate birthday;

    private String spouseName;

    private int spouseWithMe;

    private String hereAs;

    private String moreInformation;

    private String readyTo;

    private String comments;
}
