package com.app.MiNegocio.dto;

import lombok.Data;

@Data
public class ClientInputDTO {

    private String identificationType;
    private Long identificationNumber;
    private String name;
    private String email;
    private int cellphone;

}
