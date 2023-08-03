package com.esperanzachurch.be.ecformbe.infrastructure.factory;

import com.esperanzachurch.be.ecformbe.application.domain.business.FormRequest;
import com.esperanzachurch.be.ecformbe.application.domain.entity.Form;

public class FormFactory {

    public static Form formConverter(final FormRequest formRequest) {
        return Form.builder()
                .birthday(formRequest.getBirthday())
                .city(formRequest.getCity())
                .comments(formRequest.getComments())
                .email(formRequest.getEmail())
                .hereAs(formRequest.getHereAs())
                .lastName(formRequest.getLastName())
                .mobilePhone(formRequest.getMobilePhone())
                .moreInformation(formRequest.getMoreInformation())
                .name(formRequest.getName())
                .postalCode(formRequest.getPostalCode())
                .readyTo(formRequest.getReadyTo())
                .spouseName(formRequest.getSpouseName())
                .spouseWithMe(formRequest.getSpouseWithMe())
                .state(formRequest.getState())
                .street(formRequest.getStreet())
                .build();
    }
}
