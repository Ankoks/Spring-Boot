package com.example.postgresdemo.model.graphs;

import com.example.postgresdemo.view.View;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * User: ankoks
 * Date: 18/04/2019
 */
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subject;

    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER)
    private List<Comment> comments = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private UserEntity user;

    public Long getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public List<Comment> getComments() {
        return comments;
    }
}

/**
 * Post  ->  user:User
 *       ->  comments:List<Comment>
 *             comments[0]:Comment -> user:User
 *             comments[1]:Comment -> user:User
 */
