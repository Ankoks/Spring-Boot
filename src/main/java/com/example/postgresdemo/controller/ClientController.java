package com.example.postgresdemo.controller;

import com.example.postgresdemo.model.auth.Client;
import com.example.postgresdemo.security.RoleConstants;
import com.example.postgresdemo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: ankoks
 * Date: 14/05/2019
 */
@RestController
@RequestMapping(value = "/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping(value = "/{clientId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize(value = RoleConstants.HAS_AUTHORITY_ADMIN)
    public ResponseEntity<Client> getForAdmin(@PathVariable("clientId") Long clientId) {
        Client clientById = clientService.getClientById(clientId);

        return ResponseEntity.ok(clientById);
    }

    @DeleteMapping(value = "/{clientId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> deleteClient(@PathVariable("clientId") Long clientId) {
        clientService.deleteById(clientId);

        return ResponseEntity.ok(clientId);
    }
}
