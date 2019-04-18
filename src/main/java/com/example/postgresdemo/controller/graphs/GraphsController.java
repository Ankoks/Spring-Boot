package com.example.postgresdemo.controller.graphs;

import com.example.postgresdemo.model.graphs.Post;
import com.example.postgresdemo.repository.graphs.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * User: ankoks
 * Date: 18/04/2019
 */
@RestController
public class GraphsController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping(value = "/post", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Post>> getAllPosts() {
        return ResponseEntity.ok(postRepository.findAll());
    }
}
