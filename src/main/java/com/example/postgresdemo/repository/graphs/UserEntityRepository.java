package com.example.postgresdemo.repository.graphs;

import com.example.postgresdemo.model.graphs.Comment;
import com.example.postgresdemo.model.graphs.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * User: ankoks
 * Date: 18/04/2019
 */
@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {
}
