package com.pokegames.data.model;

import java.util.Optional;

/**
 * Created by jeffreypthomas on 2/21/17.
 */
public class TurnResult {

    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(TurnResult.class);

    private final Turn currTurn;

    private final Turn prevTurn;

    public TurnResult(Turn prevTurn, Turn currTurn) {

        this.prevTurn = prevTurn;
        this.currTurn = currTurn;

    }

    public Optional<Player> getLoser() {


        if (!isVeryFirstTurn() && !isTurnSelectionsEqual()) {
            return Optional.of(currTurn.getPlayer());
        } else {
            return Optional.empty();
        }

    }

    public Optional<Player> getWinner() {

        if (!isVeryFirstTurn() && !isTurnSelectionsEqual()) {
            return Optional.of(prevTurn.getPlayer());
        } else {
            return Optional.empty();
        }

    }

    private boolean isVeryFirstTurn() {

        return prevTurn == null;
    }

    private boolean isTurnSelectionsEqual() {

        return currTurn.getSelectedMovieObject().equals(prevTurn.getSelectedMovieObject());
    }
}
