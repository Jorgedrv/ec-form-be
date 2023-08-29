package com.esperanzachurch.be.ecformbe.infrastructure.factory;

import com.esperanzachurch.be.ecformbe.application.domain.business.VisitedFormRequest;
import com.esperanzachurch.be.ecformbe.application.domain.entity.VisitedForm;

public class FormFactory {

    public static VisitedForm formConverter(final VisitedFormRequest visitedFormRequest) {
        return VisitedForm.builder()
                .birthday(visitedFormRequest.getBirthday())
                .city(visitedFormRequest.getCity())
                .comments(visitedFormRequest.getComments())
                .email(visitedFormRequest.getEmail())
                .hereAs(visitedFormRequest.getHereAs())
                .lastName(visitedFormRequest.getLastName())
                .phone(visitedFormRequest.getPhone())
                .moreInformation(visitedFormRequest.getMoreInformation())
                .name(visitedFormRequest.getName())
                .postalCode(visitedFormRequest.getPostalCode())
                .readyTo(visitedFormRequest.getReadyTo())
                .spouseName(visitedFormRequest.getSpouseName())
                .spouseWithMe(visitedFormRequest.getSpouseWithMe())
                .state(visitedFormRequest.getState())
                .street(visitedFormRequest.getStreet())
                .build();
    }
}
