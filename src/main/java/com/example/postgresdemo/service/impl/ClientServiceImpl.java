package com.example.postgresdemo.service.impl;

import com.example.postgresdemo.model.auth.Client;
import com.example.postgresdemo.repository.auth.ClientRepository;
import com.example.postgresdemo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * User: ankoks
 * Date: 14/05/2019
 */
@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client getClientById(Long clientId) {
        Optional<Client> optionalUserEntity = clientRepository.findById(clientId);
        return optionalUserEntity.orElse(null);
    }

    @Override
    public Client getClientByLogin(String login) {
        return clientRepository.findByLogin(login).orElse(null);
    }

    @Override
    public void deleteById(Long clientId) {
        clientRepository.deleteById(clientId);
    }

}
