package com.oburnett127.jobsearch.service;

import com.oburnett127.jobsearch.model.Account;
import com.oburnett127.jobsearch.model.AccountCreateRequest;
import com.oburnett127.jobsearch.model.AccountUpdateRequest;
import com.oburnett127.jobsearch.repository.AccountRepository;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(final AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    
    public List<Account> listAll() {
        return this.accountRepository.findAll();
    }
    
    @SneakyThrows
    public Account getAccount(final int id) {
        final var account = accountRepository.getReferenceById(id);
        return account;
    }
    
    public Account createAccount(AccountCreateRequest accountCreateRequest) {
        final var account = Account.builder()
                .id(accountCreateRequest.getId())
                .email(accountCreateRequest.getEmail())
                .password(accountCreateRequest.getPassword())
                .isAdmin(accountCreateRequest.getIsAdmin())
                .isEmployer(accountCreateRequest.getIsEmployer())
                .build();
        this.accountRepository.save(account);
        return account;
    }
    
    @SneakyThrows
    public Account updateAccount(AccountUpdateRequest accountUpdateRequest) {
        final var account = accountRepository.getReferenceById(accountUpdateRequest.getId());
        account.setEmail(accountUpdateRequest.getEmail());
        account.setPassword(accountUpdateRequest.getPassword());
        this.accountRepository.save(account);
        return account;
    }

    public void deleteAccount(int id) {
        this.accountRepository.deleteById(id);
    }
}
