package com.example.postgresdemo.repository.graphs;

import com.example.postgresdemo.model.graphs.Post;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * User: ankoks
 * Date: 18/04/2019
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @EntityGraph(value = Post.POST_ALL_COLLECTION_ENTITY_GRAPH, type = EntityGraph.EntityGraphType.LOAD)
    List<Post> findAll();

    @EntityGraph(value = Post.POST_ALL_COLLECTION_ENTITY_GRAPH, type = EntityGraph.EntityGraphType.FETCH)
    Optional<Post> findWithCollectionById(Long postId);
}
