package com.oburnett127.jobsearch.repository;

import com.oburnett127.jobsearch.model.Employer;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployerRepository extends JpaRepository<Employer, Integer> {
    Optional<Employer> findByName(String name);

    @Query(value = "SELECT COALESCE(MAX(id), 0) FROM Employer")
    int getMaxEmployerId();
}
