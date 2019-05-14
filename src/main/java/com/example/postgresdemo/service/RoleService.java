package com.example.postgresdemo.service;

import com.example.postgresdemo.model.auth.ClientRole;

import java.util.List;

/**
 * User: ankoks
 * Date: 14/05/2019
 */
public interface RoleService {

    List<ClientRole> getAllRoles();

    ClientRole save(ClientRole role);
}
