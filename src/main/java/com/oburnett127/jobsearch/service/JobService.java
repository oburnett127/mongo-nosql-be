package com.oburnett127.jobsearch.service;

import com.oburnett127.jobsearch.model.JobUpdateRequest;
import com.oburnett127.jobsearch.repository.JobRepository;
import com.oburnett127.jobsearch.model.Job;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import java.util.List;

@Service
public class JobService {
    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public List<Job> listAll() {
        return this.jobRepository.findAll();
    }

    public List<Job> findJobsWithSorting(String field){
        return jobRepository.findAll(Sort.by(Sort.Direction.ASC, field));
    }

    public Page<Job> findJobsWithPagination(int offset, int pageSize){
        Page<Job> jobs = jobRepository.findAll(PageRequest.of(offset, pageSize));
        return jobs;
    }

    public Page<Job> findJobsWithPaginationAndSorting(int offset, int pageSize, String field){
        Page<Job> jobs = jobRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
        return jobs;
    }

    @SneakyThrows
    public Job getJob(int id) {
        final var job = this.jobRepository.getReferenceById(id);
        return job;
    }

    public void createJob(Job job) {
        this.jobRepository.save(job);
    }

    @SneakyThrows
    public Job updateJob(JobUpdateRequest jobUpdateRequest) {
        final var id = jobUpdateRequest.getId();
        final var title = jobUpdateRequest.getTitle();
        final var description = jobUpdateRequest.getDescription();

        final var job = this.jobRepository.getReferenceById(id);

        if(title.isBlank() || title == null || !title.matches("^[a-zA-Z0-9 ]*$")
            || description.isBlank() || description == null) {
            throw new RuntimeException("The title cannot be blank nor contain non-alphanumeric characters. The description cannot be blank.");
        }

        job.setTitle(title);
        job.setDescription(description);
        this.jobRepository.save(job);
        return job;
    }

    public void deleteJob(int id) { this.jobRepository.deleteById(id); }
}