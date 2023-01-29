package com.oburnett127.jobsearch.service;

import com.oburnett127.jobsearch.repository.JobRepository;
import com.oburnett127.jobsearch.model.Job;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.apache.commons.*;
import org.springframework.util.StringUtils;

@Service
@Slf4j
public class JobService {
    @Autowired
    private final JobRepository jobRepository;
    @Autowired
    private final JobValidator jobValidator;

    public List<Job> listAll() {
        return this.JobRepository.getAll();
    }

    @SneakyThrows
    public Job getJob(final int id) {
        final var job = JobRepository.getJob(id);
        return job;
    }

    public void createJob(Job job) {
        this.JobRepository.create(job);
    }

    @SneakyThrows
    public Job editJob(int id, String title, int employerId, String desc, Date postDate) {
        final var job = JobRepository.getJob(id);

        if(title.isBlank() || title == null || !title.matches("^(?=.*[a-zA-Z])(?=.*[0-9])[A-Za-z0-9]+$")
            || desc.isBlank() || desc == null) {
            throw new InvalidEditException();
        }

        JobRepository.save(job);
        return job;
    }
}
