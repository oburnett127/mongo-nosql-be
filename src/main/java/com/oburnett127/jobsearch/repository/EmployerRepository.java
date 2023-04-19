package com.oburnett127.jobsearch.repository;

import com.oburnett127.jobsearch.model.Employer;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerRepository extends JpaRepository<Employer, Integer> {
    Optional<Employer> findByName(String name);
}
