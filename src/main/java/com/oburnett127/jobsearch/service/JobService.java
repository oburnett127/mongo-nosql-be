package com.oburnett127.jobsearch.service;

import com.oburnett127.jobsearch.exception.InvalidEditException;
import com.oburnett127.jobsearch.repository.JobRepository;
import com.oburnett127.jobsearch.model.Job;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class JobService {
    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public List<Job> listAll() {
        return this.jobRepository.findAll();
    }

    @SneakyThrows
    public Job getJob(final int id) {
        final var job = this.jobRepository.getById(id);
        return job;
    }

    public void createJob(Job job) {
        this.jobRepository.save(job);
    }

    @SneakyThrows
    public Job editJob(int id, String title, int employerId, String desc, String postDate) {
        final var job = this.jobRepository.getById(id);

        if(title.isBlank() || title == null || !title.matches("^(?=.*[a-zA-Z])(?=.*[0-9])[A-Za-z0-9]+$")
            || desc.isBlank() || desc == null) {
            throw new InvalidEditException();
        }

        job.setTitle(title);
        job.setDesc(desc);
        this.jobRepository.save(job);
        return job;
    }

    public void deleteJob(int id) { this.jobRepository.deleteById(id); }
}