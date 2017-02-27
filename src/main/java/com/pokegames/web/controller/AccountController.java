package com.pokegames.web.controller;

import com.pokegames.data.jpa.AccountRepository;
import com.pokegames.data.model.Account;
import com.pokegames.web.error.AccountAlreadyExistsException;
import com.pokegames.web.error.AccountNotFoundException;
import com.pokegames.web.error.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Created by jeffreypthomas on 2/20/17.
 */

@RestController
@RequestMapping("/account")
public class AccountController {

    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private AccountRepository accountRepository;

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<?> add(@RequestBody Account input) {

        LOG.debug("add request:{}", input);

        validate(input);

        final Optional<Account> account = accountRepository.findByUsername(input.getUsername());
        if (account.isPresent()) {
            throw new AccountAlreadyExistsException(input.getUsername());
        }

        accountRepository.save(input);

        return ResponseEntity.ok().build();

    }

    private void validate(Account input) {

        if (input == null) {
            throw new BadRequestException("account information required");
        }

        if (StringUtils.isEmpty(input.getUsername()) || StringUtils.isEmpty(input.getPassword())) {
            throw new BadRequestException("missing username or password");
        }

    }


    @RequestMapping(method = RequestMethod.GET, value = "/{username}")
    Account get(@PathVariable String username) {

        LOG.debug("get request:{}", username);

        final Optional<Account> account = accountRepository.findByUsername(username);

        return account.orElseThrow(() -> new AccountNotFoundException(username));

    }


}
