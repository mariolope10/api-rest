package com.svlada.entity;

/**
 * Enumerated {@link User} roles.
 * 
 * @author vladimir.stankovic
 *
 * Aug 16, 2016
 */
public enum Role {
    ADMIN, MEMBER, USER;
    
    public String authority() {
        return "ROLE_" + this.name();
    }
}
