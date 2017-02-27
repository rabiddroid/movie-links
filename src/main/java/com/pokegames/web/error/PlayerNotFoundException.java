package com.pokegames.web.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by jeffreypthomas on 2/25/17.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PlayerNotFoundException extends RuntimeException {

    private static final Logger LOG = LoggerFactory.getLogger(PlayerNotFoundException.class);

    public PlayerNotFoundException(String playerIdentifier) {

        super("player with identifier " + playerIdentifier + "does not exist.");
    }
}
