package com.esperanzachurch.be.ecformbe.infrastructure.factory;

import com.esperanzachurch.be.ecformbe.application.domain.business.EnglishFormRequest;
import com.esperanzachurch.be.ecformbe.application.domain.entity.EnglishForm;

public class EnglishFormFactory {

    public static EnglishForm formConverter(final EnglishFormRequest englishFormRequest) {
        return EnglishForm.builder()
                .age(englishFormRequest.getAge())
                .city(englishFormRequest.getCity())
                .countryOfBirth(englishFormRequest.getCountryOfBirth())
                .education(englishFormRequest.getEducation())
                .email(englishFormRequest.getEmail())
                .englishLevel(englishFormRequest.getEnglishLevel())
                .lastName(englishFormRequest.getLastName())
                .phone(englishFormRequest.getPhone())
                .name(englishFormRequest.getName())
                .postalCode(englishFormRequest.getPostalCode())
                .street(englishFormRequest.getStreet())
                .build();
    }
}
