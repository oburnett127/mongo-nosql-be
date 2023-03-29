package com.oburnett127.jobsearch.repository;

import com.oburnett127.jobsearch.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AccountRepository extends JpaRepository<Account, Integer> {
}
