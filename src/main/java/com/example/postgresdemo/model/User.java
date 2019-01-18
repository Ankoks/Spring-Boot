package com.example.postgresdemo.model;

import com.example.postgresdemo.view.View;
import com.fasterxml.jackson.annotation.JsonView;

/**
 * User: ankoks
 * Date: 18/01/2019
 */
public class User {
    @JsonView(View.UI.class)
    private String email;

    @JsonView(View.UI.class)
    private boolean enabled;

    @JsonView(View.REST.class)
    private String password;

    public User(String email, boolean enabled, String password) {
        this.email = email;
        this.enabled = enabled;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
