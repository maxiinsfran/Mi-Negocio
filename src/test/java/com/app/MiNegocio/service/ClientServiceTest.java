package com.app.MiNegocio.service;

import com.app.MiNegocio.dto.ClientInputDTO;
import com.app.MiNegocio.persistence.entity.Client;
import com.app.MiNegocio.persistence.repository.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ClientServiceTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientService clientService;

    @Mock
    private ClientInputDTO clientInputDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void createClient() {
        Client client1 = new Client();
        client1.setIdentificationType("DNI");
        client1.setIdentificationNumber(1234L);
        client1.setName("Maximiliano Insfran");
        client1.setEmail("maxiinsfran@gmail.com");
        client1.setCellphone(3704042);

        when(clientRepository.save(Mockito.any())).thenReturn(client1);

        Client result = new Client();
        result.setIdentificationType("DNI");
        result.setIdentificationNumber(1234L);
        result.setName("Maximiliano Insfran");
        result.setEmail("maxiinsfran@gmail.com");
        result.setCellphone(3704042);

        assertEquals(result,client1);

    }

    @Test
    void findClientByIdentificationNumber() {
        Client client1 = new Client();
        client1.setIdentificationNumber(1234L);

        when(clientRepository.findClientByIdentificationNumber(Mockito.any())).thenReturn(client1);

        Client result = new Client();
        result.setIdentificationNumber(1234L);

        assertEquals(result, client1);

    }



}
