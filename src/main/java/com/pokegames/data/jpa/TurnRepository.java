package com.pokegames.data.jpa;

import com.pokegames.data.model.Turn;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jeffreypthomas on 2/20/17.
 */
public interface TurnRepository extends JpaRepository<Turn,Long>{

}
