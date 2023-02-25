package com.app.MiNegocio.controller;

import com.app.MiNegocio.dto.ClientInputDTO;
import com.app.MiNegocio.persistence.entity.Client;
import com.app.MiNegocio.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/client")
public class ClientController {

    @Autowired
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/createclient")
    public Client createClient(@RequestBody ClientInputDTO clientInputDTO) {
        return this.clientService.createClient(clientInputDTO);
    }

    @GetMapping("/findclientbyidentificationnumber")
    public Client findClientByIdentificationNumber(@RequestBody Long identificationNumber) {
        return this.clientService.findClientByIdentificationNumber(identificationNumber);
    }

    @DeleteMapping("/deleteclient/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        this.clientService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/updateclientdata")
    public Client updateClientData(@RequestBody Client client) {
        return this.clientService.updateClientData(client);
    }

}
