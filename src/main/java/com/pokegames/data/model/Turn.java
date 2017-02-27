package com.pokegames.data.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by jeffreypthomas on 2/21/17.
 */
@Entity
public class Turn {

    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(Turn.class);

    private long turnId;

    private Player player;

    private MovieObject selectedMovieObject;

    @Id
    @GeneratedValue
    private long id;

    public Turn() {
//
    }

    public Turn(long turnId, Player player, MovieObject selectedMovieObject) {

        this.turnId = turnId;
        this.player = player;
        this.selectedMovieObject = selectedMovieObject;
    }


    public Player getPlayer() {

        return player;
    }

    public MovieObject getSelectedMovieObject() {

        return selectedMovieObject;
    }

    public long getTurnId() {

        return turnId;
    }

    public long getId() {

        return id;
    }

    public void setId(long id) {

        this.id = id;
    }

    public void setTurnId(long turnId) {

        this.turnId = turnId;
    }

    public void setPlayer(Player player) {

        this.player = player;
    }

    public void setSelectedMovieObject(MovieObject selectedMovieObject) {

        this.selectedMovieObject = selectedMovieObject;
    }
}
