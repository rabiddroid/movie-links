package com.pokegames.service;

import com.pokegames.data.jpa.AccountRepository;
import com.pokegames.data.jpa.GameRepository;
import com.pokegames.data.model.*;
import com.pokegames.web.error.GameNotFoundException;
import com.pokegames.web.error.PlayerNotFoundException;
import com.pokegames.web.model.request.MovieEntity;
import com.pokegames.web.model.request.TurnRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by jeffreypthomas on 2/24/17.
 */
@Service
public class Turns {

    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(Turns.class);

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private GameRepository gameRepository;

    public Turn createFrom(String gameId, TurnRequest request) {

        return new Turn(request.getTurnId(), getPlayer(gameId, request), getMovieObject(request.getMovieEntity()));

    }

    private MovieObject getMovieObject(MovieEntity movieEntity) {

        MovieObject movieObject = null;
        switch (movieEntity.getType()) {

            case MOVIE:
                movieObject = new Movie(movieEntity.getName());
                break;
            case ACTOR:
                movieObject = new Actor(movieEntity.getName());
                break;
        }

        return movieObject;
    }

    private Player getPlayer(String gameId, TurnRequest request) {


        final Optional<Account> account = accountRepository.findByUsername(request.getPlayerIdentifier());
        final Optional<Game> game = gameRepository.findByGameId(gameId);
        return new Player(account.orElseThrow(() -> new PlayerNotFoundException(request.getPlayerIdentifier())), game.orElseThrow(()
            -> new GameNotFoundException(gameId)));


    }


}
