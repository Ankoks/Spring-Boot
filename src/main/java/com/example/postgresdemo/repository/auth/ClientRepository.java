package com.example.postgresdemo.repository.auth;

import com.example.postgresdemo.model.auth.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * User: ankoks
 * Date: 14/05/2019
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByLogin(String login);
}
