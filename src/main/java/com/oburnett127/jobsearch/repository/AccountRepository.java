package com.oburnett127.jobsearch.repository;

import com.oburnett127.jobsearch.model.Account;
import com.oburnett127.jobsearch.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
}
