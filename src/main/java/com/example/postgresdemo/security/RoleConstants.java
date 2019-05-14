package com.example.postgresdemo.security;

/**
 * User: ankoks
 * Date: 14/05/2019
 */
public interface RoleConstants {
    String ROLE_ADMIN = "ROLE_ADMIN";
    String ROLE_USER = "ROLE_USER";
    String ROLE_OPERATOR = "ROLE_OPERATOR";

    String HAS_AUTHORITY_ADMIN = "hasAuthority('" + ROLE_ADMIN + "')";
    String HAS_AUTHORITY_USER = "hasAuthority('" + ROLE_USER + "')";
    String HAS_AUTHORITY_OPERATOR = "hasAuthority('" + ROLE_OPERATOR + "')";
}
