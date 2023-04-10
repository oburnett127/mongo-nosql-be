package com.oburnett127.jobsearch.controller;

import com.oburnett127.jobsearch.model.Account;
import com.oburnett127.jobsearch.model.AccountCreateRequest;
import com.oburnett127.jobsearch.model.AccountUpdateRequest;
import com.oburnett127.jobsearch.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService service;

    public AccountController(final AccountService service){
        this.service = service;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Account>> view() {
        final var result = service.listAll();
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Account> getAccount(@Validated @PathVariable String id) {
        final var account = service.getAccount(Integer.parseInt(id));
        return ResponseEntity.ok().body(account);
    }

    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@Validated @RequestBody AccountCreateRequest accountCreateRequest) throws IOException {
        final var account = service.createAccount(accountCreateRequest);
        return ResponseEntity.ok(account);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Account> updateAccount(@Validated @RequestBody AccountUpdateRequest accountUpdateRequest) throws IOException {
        final var account = service.updateAccount(accountUpdateRequest);
        return ResponseEntity.ok().body(account);
    }

    @PostMapping("/delete/{id}")
    public void deleteAccount(@PathVariable String id) {
        service.deleteAccount(Integer.parseInt(id));
    }
}