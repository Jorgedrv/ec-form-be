package com.esperanzachurch.be.ecformbe.application.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "EC_FORM")
public class Form implements Serializable {

    private static final long serialVersionUID = 5926427583005150709L;
    @Id
    @Column(name = "ECF_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ECF_NAME")
    private String name;

    @Column(name = "ECF_LAST_NAME")
    private String lastName;

    @Column(name = "ECF_EMAIL")
    private String email;

    @Column(name = "ECF_PHONE")
    private String phone;

    @Column(name = "ECF_STREET")
    private String street;

    @Column(name = "ECF_CITY")
    private String city;

    @Column(name = "ECF_STATE")
    private String state;

    @Column(name = "ECF_POSTAL_CODE")
    private String postalCode;

    @Column(name = "ECF_BIRTHDAY")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    @Column(name = "ECF_SPOUSE_NAME")
    private String spouseName;

    @Column(name = "ECF_SPOUSE_WITH_ME")
    private int spouseWithMe;

    @Column(name = "ECF_HERE_AS")
    private String hereAs;

    @Column(name = "ECF_MORE_INFORMATION")
    private String moreInformation;

    @Column(name = "ECF_READY_TO")
    private String readyTo;

    @Column(name = "ECF_COMMENTS")
    private String comments;
}
