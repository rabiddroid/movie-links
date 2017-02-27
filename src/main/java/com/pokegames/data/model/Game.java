package com.pokegames.data.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jeffreypthomas on 2/21/17.
 */
@Entity
public class Game {

    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(Game.class);

    @Id
    @GeneratedValue
    private Long id;

    private String gameId;

    private List<Player> allPlayers;

    private List<Player> currentPlayers;

    private LinkedList<Turn> turns;

    private int currentPlayerIndex = 0;

    private boolean isGameCompleted;

    public Game() {
        //for JPA
    }

    public static Game newInstance(String gameId) {

        final Game game = new Game();
        game.setGameId(gameId);

        return game;

    }

    public void setGameId(String gameId) {

        this.gameId = gameId;
    }

    /*public Game(long id, String gameId, List<Player> allPlayers) {

        this.id = id;
        this.gameId = gameId;
        this.allPlayers = allPlayers;
        this.turns = new LinkedList<>();
        this.currentPlayers = new LinkedList<>(allPlayers);
    }

    public boolean isGameCompleted() {

        return isGameCompleted;
    }

    public TurnResult addTurn(Turn currentTurn) {

        if (isGameCompleted()) {
            throw new OperationNotSupported("Cannot add a turn for completed game");
        }

        final Turn prevTurn = turns.getLast();
        final TurnResult result = new TurnResult(prevTurn, currentTurn);

        turns.addLast(currentTurn);
        completeRound(result);

        return result;
    }

    private void completeRound(TurnResult result) {

        if (result != null) {

            if (!currentPlayers.isEmpty() && currentPlayers.size() > 1) {

                final Optional<Player> losingPlayer = result.getLoser();

                if (losingPlayer.isPresent()) {
                    currentPlayers.remove(losingPlayer.get());
                } else {
                    currentPlayerIndex++;
                }
            } else {
                isGameCompleted = true;
            }
        }

    }

    public Player getCurrentPlayer() {

        int playerIndex = currentPlayerIndex >= currentPlayers.size() ? 0 : currentPlayerIndex;

        return currentPlayers.get(playerIndex);

    }
*/
}
