package com.oburnett127.jobsearch.service;

import com.oburnett127.jobsearch.repository.ApplicationRepository;
import com.oburnett127.jobsearch.model.Application;
import com.oburnett127.jobsearch.model.request.ApplicationCreateRequest;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService {
    private final ApplicationRepository applicationRepository;

    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @SneakyThrows
    public Application getOneApplication(int jobId, int applicantId) {
        final Optional<Application> application = applicationRepository.findByJobIdAndApplicantId(jobId, applicantId);
        if(application.isPresent()) return application.get();
        else return null;
    }

    @SneakyThrows
    public List<Application> getApplicationsByJobId(int id) {
        return applicationRepository.findByJobId(id);
    }

    @SneakyThrows
    public List<Application> getApplicationsByApplicantId(int id) {
        return applicationRepository.findByApplicantId(id);
    }

    @SneakyThrows
    public void createApplication(ApplicationCreateRequest applicationCreateRequest) {
        final int jobId = Integer.parseInt(applicationCreateRequest.getJobId());
        final int applicantId = Integer.parseInt(applicationCreateRequest.getApplicantId());
        // System.out.println("jobId: " + jobId);
        // System.out.println("applicantId: " + applicantId);
        Application application = new Application(jobId, applicantId);
        applicationRepository.save(application);   
    }
}