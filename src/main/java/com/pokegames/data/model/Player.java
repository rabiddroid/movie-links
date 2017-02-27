package com.pokegames.data.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by jeffreypthomas on 2/21/17.
 */
@Entity
public class Player {

    @Id
    @GeneratedValue
    private Long id;

    private Account account;

    private Game game;

    public Player() {

    }

    public Player(Account account, Game game) {

        this.account = account;

        this.game = game;
    }

    public Account getAccount() {

        return account;
    }

    public Game getGame() {

        return game;
    }
}
