package com.oburnett127.jobsearch.repository;

import com.oburnett127.jobsearch.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job,Integer> {
}
