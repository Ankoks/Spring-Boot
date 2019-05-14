package com.example.postgresdemo.repository.auth;

import com.example.postgresdemo.model.auth.ClientRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * User: ankoks
 * Date: 14/05/2019
 */
@Repository
public interface RoleRepository extends JpaRepository<ClientRole, String> {
}
