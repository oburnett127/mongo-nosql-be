package com.oburnett127.jobsearch.repository;

import com.oburnett127.jobsearch.model.Application;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {
    Optional<Application> findByJobIdAndApplicantId(int jobId, int applicantId);
    List<Application> findByJobId(int id);
    List<Application> findByApplicantId(int id);
}
