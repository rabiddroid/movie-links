package com.pokegames.data.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by jeffreypthomas on 2/20/17.
 */
@Entity
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    String password;

    public String getUsername() {

        return username;
    }

    public String getPassword() {

        return password;
    }
}
