package com.pokegames.web.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by jeffreypthomas on 2/20/17.
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class AccountAlreadyExistsException extends RuntimeException {

    public AccountAlreadyExistsException(String username) {

        super("account with username: " + username + "already exists.");

    }
}
