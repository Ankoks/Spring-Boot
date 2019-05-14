package com.example.postgresdemo.controller.auth;

import com.example.postgresdemo.model.auth.Client;
import com.example.postgresdemo.model.auth.ClientRole;
import com.example.postgresdemo.model.auth.dto.ClientDTO;
import com.example.postgresdemo.model.auth.dto.ClientRoleDTO;
import com.example.postgresdemo.service.ClientService;
import com.example.postgresdemo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * User: ankoks
 * Date: 14/05/2019
 */
@RestController
@RequestMapping(value = "/client")
public class AuthController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private RoleService roleService;

    @PostMapping(value = "/sign-up", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> createOrUpdateUser(@RequestBody ClientDTO clientDTO) {

        if (clientDTO.getId() != null) {
            Client clientById = clientService.getClientById(clientDTO.getId());

            ResponseEntity.ok(clientById);
        }

        Client client = new Client();

        client.setLogin(clientDTO.getLogin());
        client.setEmail(clientDTO.getEmail());
        client.setFirstName(clientDTO.getFirstName());
        client.setLastName(clientDTO.getLastName());
        client.setMiddleName(clientDTO.getMiddleName());
        client.setAge(clientDTO.getAge());

        List<String> allRoles = getAllRoles();

        Set<ClientRole> clientRoles = new HashSet<>();
        for (ClientRoleDTO role : clientDTO.getRoles()) {
            ClientRole newRole = new ClientRole();
            if (!allRoles.contains(role.getName())) {
                newRole.setRoleName(role.getName());
                roleService.save(newRole);
            }
            newRole.setRoleName(role.getName());
            clientRoles.add(newRole);
        }

        client.setRoles(clientRoles);

        clientService.save(client);

        return ResponseEntity.ok(client);
    }

    private List<String> getAllRoles() {
        return roleService.getAllRoles().stream().map(ClientRole::getRoleName).collect(Collectors.toList());
    }
}
