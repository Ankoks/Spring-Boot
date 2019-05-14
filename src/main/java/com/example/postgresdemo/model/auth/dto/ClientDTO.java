package com.example.postgresdemo.model.auth.dto;

import java.util.List;

/**
 * User: ankoks
 * Date: 14/05/2019
 */
public class ClientDTO {
    private Long id;
    private String login;
    private String email;
    private String firstName;
    private String lastName;
    private String middleName;
    private Integer age;
    private List<ClientRoleDTO> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<ClientRoleDTO> getRoles() {
        return roles;
    }

    public void setRoles(List<ClientRoleDTO> roles) {
        this.roles = roles;
    }
}
