package com.esperanzachurch.be.ecformbe.application.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "EC_USER")
public class User implements Serializable {

    private static final long serialVersionUID = 8926427583505150902L;
    @Id
    @Column(name = "ECU_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ECU_USERNAME")
    private String username;

    @Column(name = "ECU_PASSWORD")
    private String password;

    @Column(name = "ECU_ROLE")
    private String role;
}
