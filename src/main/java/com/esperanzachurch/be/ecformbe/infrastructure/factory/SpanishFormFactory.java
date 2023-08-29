package com.esperanzachurch.be.ecformbe.infrastructure.factory;

import com.esperanzachurch.be.ecformbe.application.domain.business.SpanishFormRequest;
import com.esperanzachurch.be.ecformbe.application.domain.entity.SpanishForm;

public class SpanishFormFactory {

    public static SpanishForm formConverter(final SpanishFormRequest spanishFormRequest) {
        return SpanishForm.builder()
                .age(spanishFormRequest.getAge())
                .city(spanishFormRequest.getCity())
                .countryOfBirth(spanishFormRequest.getCountryOfBirth())
                .email(spanishFormRequest.getEmail())
                .spanishLevel(spanishFormRequest.getSpanishLevel())
                .lastName(spanishFormRequest.getLastName())
                .phone(spanishFormRequest.getPhone())
                .name(spanishFormRequest.getName())
                .postalCode(spanishFormRequest.getPostalCode())
                .street(spanishFormRequest.getStreet())
                .build();
    }
}
