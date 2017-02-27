package com.pokegames.web.model.request;

/**
 * Created by jeffreypthomas on 2/24/17.
 */
public class TurnRequest {


    private long turnId;
    private String playerIdentifier;
    private MovieEntity movieEntity;
    private boolean result;

    public long getTurnId() {

        return turnId;
    }

    public void setTurnId(long turnId) {

        this.turnId = turnId;
    }

    public String getPlayerIdentifier() {

        return playerIdentifier;
    }

    public void setPlayerIdentifier(String playerIdentifier) {

        this.playerIdentifier = playerIdentifier;
    }

    public MovieEntity getMovieEntity() {

        return movieEntity;
    }

    public void setMovieEntity(MovieEntity movieEntity) {

        this.movieEntity = movieEntity;
    }

    public boolean isResult() {

        return result;
    }

    public void setResult(boolean result) {

        this.result = result;
    }
}
