package com.example.postgresdemo.controller;

import com.example.postgresdemo.model.User;
import com.example.postgresdemo.view.View;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.parsing.Problem;
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
@Api(value = "/users", description = "Операции с пользователем")
@RestController
public class UserController {

    @ApiOperation(
            value = "Список пользователей",
            notes = "Список пользователей",
            response = User.class
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "Список пользователей получен", response = User.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = Problem.class),
            @ApiResponse(code = 403, message = "Forbidden", response = Problem.class),
            @ApiResponse(code = 404, message = "Not Found", response = Problem.class)
    })
    @JsonView(View.UI.class)
    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> get() {
        List<User> users = new ArrayList<>();
        users.add(new User("123@mail.ru", true, "123", "some text 1"));
        users.add(new User("456@mail.ru", false, "456", "some text 2"));
        users.add(new User("789@mail.ru", true, "789", "some text 3"));
        return users;
    }
}
