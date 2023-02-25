package com.app.MiNegocio.mapper;

import com.app.MiNegocio.dto.ClientInputDTO;
import com.app.MiNegocio.persistence.entity.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientInputDTOToClient implements IMapper<ClientInputDTO, Client>{

    @Override
    public Client map(ClientInputDTO in) {

        Client client = new Client();

        client.setIdentificationType(in.getIdentificationType());
        client.setIdentificationNumber(in.getIdentificationNumber());
        client.setName(in.getName());
        client.setEmail(in.getEmail());
        client.setCellphone(in.getCellphone());

        return client;

    }

}
