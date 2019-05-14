package com.example.postgresdemo.service.impl;

import com.example.postgresdemo.model.auth.ClientRole;
import com.example.postgresdemo.repository.auth.RoleRepository;
import com.example.postgresdemo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: ankoks
 * Date: 14/05/2019
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<ClientRole> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public ClientRole save(ClientRole role) {
        return roleRepository.save(role);
    }
}
