package com.oburnett127.jobsearch.repository;

import com.oburnett127.jobsearch.model.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, Integer> {
}
