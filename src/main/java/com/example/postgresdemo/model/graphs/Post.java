package com.example.postgresdemo.model.graphs;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * User: ankoks
 * Date: 18/04/2019
 */
@Entity
@NamedEntityGraphs({
        @NamedEntityGraph(
                name = Post.POST_ALL_COLLECTION_ENTITY_GRAPH,
                attributeNodes = {
                        @NamedAttributeNode("subject"),
//                        @NamedAttributeNode("user"),
                        @NamedAttributeNode(value = "comments", subgraph = "comments-subgraph"),
                },
                subgraphs = {
                        @NamedSubgraph(
                                name = "comments-subgraph",
                                attributeNodes = {
                                        @NamedAttributeNode("user")
                                }
                        )
                }
        )
})
public class Post {
    public static final String POST_ALL_COLLECTION_ENTITY_GRAPH =
            "Post[subject,user,comments]";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subject;

    @OneToMany(mappedBy = "post")
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

    public UserEntity getUser() {
        return user;
    }
}

/*
 * Post  ->  user:User
 *       ->  comments:List<Comment>
 *             comments[0]:Comment -> user:User
 *             comments[1]:Comment -> user:User
 */

/*
@OneToMany, @ManyToMany and @ElementCollection - default for FetchType.LAZY
@Basic, @ManyToOne, and @OneToOne - default for FetchType.EAGER
 */