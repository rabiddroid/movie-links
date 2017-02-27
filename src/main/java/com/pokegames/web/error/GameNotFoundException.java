package com.pokegames.web.error;

/**
 * Created by jeffreypthomas on 2/25/17.
 */
public class GameNotFoundException extends RuntimeException {

    public GameNotFoundException(String gameId) {

        super("Cannot find game = " + gameId);

    }
}
