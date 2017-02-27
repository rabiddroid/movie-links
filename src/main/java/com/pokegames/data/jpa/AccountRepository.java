package com.pokegames.data.jpa;

import com.pokegames.data.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by jeffreypthomas on 2/20/17.
 */
public interface AccountRepository extends JpaRepository<Account,Long>{

    Optional<Account> findByUsername(String username);
}
