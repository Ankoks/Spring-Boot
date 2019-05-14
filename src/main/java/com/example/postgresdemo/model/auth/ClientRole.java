package com.example.postgresdemo.model.auth;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * User: ankoks
 * Date: 14/05/2019
 */
@Entity
@Table(name = "authority")
public class ClientRole implements Serializable {
    private static final long serialVersionUID = 6086047853882772453L;

    @NotNull
    @Size(max = 50)
    @Id
    @Column(name = "name", length = 50)
    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
