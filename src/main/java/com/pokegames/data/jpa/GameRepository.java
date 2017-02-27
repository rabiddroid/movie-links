package com.pokegames.data.jpa;

import com.pokegames.data.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by jeffreypthomas on 2/24/17.
 */
public interface GameRepository extends JpaRepository<Game,Long> {

   Optional<Game> findByGameId(String gameId);
}
