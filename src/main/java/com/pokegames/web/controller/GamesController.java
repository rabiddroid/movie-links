package com.pokegames.web.controller;

import com.pokegames.data.jpa.AccountRepository;
import com.pokegames.data.jpa.GameRepository;
import com.pokegames.data.jpa.PlayerRepository;
import com.pokegames.data.jpa.TurnRepository;
import com.pokegames.data.model.Account;
import com.pokegames.data.model.Game;
import com.pokegames.data.model.Player;
import com.pokegames.data.model.Turn;
import com.pokegames.service.Turns;
import com.pokegames.web.error.AccountNotFoundException;
import com.pokegames.web.error.GameNotFoundException;
import com.pokegames.web.model.request.TurnRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

/**
 * Created by jeffreypthomas on 2/24/17.
 */
@RestController
@RequestMapping("/games")
public class GamesController {

    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(GamesController.class);

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private Turns turns;

    @Autowired
    private TurnRepository turnRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PlayerRepository playerRepository;



    /**
     * Find game and add turn information.
     * Throws exception if game or player not found
     *
     * @param gameId
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/{gameId}/turn")
    public ResponseEntity<?> addTurn(@PathVariable("gameId") String gameId, @RequestBody TurnRequest request) {


        //find the game and add turn information
        final Optional<Game> gameResult = gameRepository.findByGameId(gameId);

        final Turn newTurn = turns.createFrom(gameId, request);

        turnRepository.save(newTurn);

        return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/new")
    public ResponseEntity<Game> createNew() {

        Game newGame = Game.newInstance(UUID.randomUUID().toString());

        return ResponseEntity.ok(gameRepository.save(newGame));

    }

    /**
     * Find the game and add player.
     * Throws exception if game/player not found.
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/{gameId}/player/{playerId}")
    public ResponseEntity<?> addPlayer(@PathVariable("gameId") String gameId, @PathVariable("playerId") String playerId) {


        final Optional<Account> account = accountRepository.findByUsername(playerId);
        final Optional<Game> game = gameRepository.findByGameId(gameId);
        final Player newPlayer =
            new Player(account.orElseThrow(() -> new AccountNotFoundException(playerId)), game.orElseThrow(() ->
                new GameNotFoundException(gameId)));

        playerRepository.save(newPlayer);

        return ResponseEntity.ok().build();

    }

}
