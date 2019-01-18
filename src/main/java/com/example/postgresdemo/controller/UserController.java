package com.example.postgresdemo.controller;

import com.example.postgresdemo.model.User;
import com.example.postgresdemo.view.View;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * User: ankoks
 * Date: 18/01/2019
 */
@RestController
public class UserController {

    @JsonView(View.UI.class)
    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> get() {
        List<User> users = new ArrayList<>();
        users.add(new User("123@mail.ru", true, "123"));
        users.add(new User("456@mail.ru", false, "456"));
        users.add(new User("789@mail.ru", true, "789"));
        return users;
    }
}
