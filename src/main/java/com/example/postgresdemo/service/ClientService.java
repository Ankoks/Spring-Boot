package com.example.postgresdemo.service;

import com.example.postgresdemo.model.auth.Client;

/**
 * User: ankoks
 * Date: 14/05/2019
 */
public interface ClientService {

    Client save(Client client);

    Client getClientById(Long clientId);

    Client getClientByLogin(String login);

    void deleteById(Long clientId);
}
