package com.app.MiNegocio.persistence.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
public class ClientAdress {

    @Id
    @GeneratedValue
    private Long id;
    private String mainProvince;
    private String mainCity;
    private String mainAdress;

}
