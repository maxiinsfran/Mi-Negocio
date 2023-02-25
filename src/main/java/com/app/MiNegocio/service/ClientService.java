package com.app.MiNegocio.service;

import com.app.MiNegocio.dto.ClientInputDTO;
import com.app.MiNegocio.exceptions.ToDoExceptions;
import com.app.MiNegocio.mapper.ClientInputDTOToClient;
import com.app.MiNegocio.persistence.entity.Client;
import com.app.MiNegocio.persistence.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private final ClientRepository clientRepository;

    @Autowired
    private final ClientInputDTOToClient mapper;

    public ClientService(ClientRepository clientRepository, ClientInputDTOToClient mapper) {
        this.clientRepository = clientRepository;
        this.mapper = mapper;
    }

    public Client createClient(ClientInputDTO clientInputDTO) {
        Client client = mapper.map(clientInputDTO);
        return this.clientRepository.save(client);
    }

    public Client findClientByIdentificationNumber(Long client) {
        return clientRepository.findClientByIdentificationNumber(client);
    }

    public void deleteById(Long id) {
        Optional<Client> optionalClient = this.clientRepository.findById(id);
        if( optionalClient.isEmpty() ) {
            throw new ToDoExceptions("Client not found", HttpStatus.NOT_FOUND);
        }

        this.clientRepository.deleteById(id);
    }

    @Transactional
    public Client updateClientData(@RequestBody Client client) {
        Optional<Client> optionalClient = Optional.ofNullable(this.clientRepository.updateClientData(client));
        if( optionalClient.isEmpty() ) {
            throw new ToDoExceptions("Client not found", HttpStatus.NOT_FOUND);
        }

        return this.clientRepository.updateClientData(client);
    }
}
