package com.example.postgresdemo.repository;

import com.example.postgresdemo.model.TableUser;
import org.springframework.data.repository.CrudRepository;

/**
 * User: ankoks
 * Date: 21/01/2019
 */
public interface UserRepository extends CrudRepository<TableUser, Long> {

    TableUser findByUserName(String userName);
}
