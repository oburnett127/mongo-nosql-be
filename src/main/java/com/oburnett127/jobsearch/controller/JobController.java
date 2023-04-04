package com.oburnett127.jobsearch.controller;

import com.oburnett127.jobsearch.model.*;
import com.oburnett127.jobsearch.service.JobService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/job")
public class JobController {
    private final JobService service;

    public JobController(JobService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public ResponseEntity<JobDto[]> view() {
        List<Job> jobs = service.listAll();

        var result = jobs.stream()
                .map(job -> new JobDto(job.getId(), job.getTitle(), job.getDescription(),
                        job.getPostDate(), job.getEmployer().getName()))
                .collect(Collectors.toList());

        JobDto[] jobArray = result.toArray(new JobDto[0]);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        headers.add("Access-Control-Allow-Headers", "Content-Type, Authorization");

        return new ResponseEntity<>(jobArray, headers, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<JobDto> getJob(@Validated @PathVariable String id) {
        System.out.println("inside getJob() $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ --------------------");
        final var job = service.getJob(Integer.parseInt(id));

        var result = new JobDto(job.getId(), job.getTitle(), job.getDescription(),
                        job.getPostDate(), job.getEmployer().getName());

        return ResponseEntity.ok().body(result);
    }

    @PostMapping("/create")
    public ResponseEntity<Job> createJob(@Validated @RequestBody JobCreateRequest jobCreateRequest) throws IOException {
        System.out.println("inside createJob() $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ --------------------");
        final var job = Job.builder()
                .title(jobCreateRequest.getTitle())
                .employer(jobCreateRequest.getEmployer())
                .description(jobCreateRequest.getDescription())
                .postDate(LocalDate.now().toString())
                .build();
        service.createJob(job);
        return ResponseEntity.ok(job);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Job> updateJob(@Validated @PathVariable int id, @RequestBody JobUpdateRequest jobUpdateRequest) throws IOException {
        System.out.println("inside updateJob() $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ --------------------");
        jobUpdateRequest.setId(id);
        final var result = service.updateJob(jobUpdateRequest);
        return ResponseEntity.ok().body(result);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<Job> deleteJob(@Validated @PathVariable int id) throws IOException {
        System.out.println("inside deleteJob() $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ --------------------");
        service.deleteJob(id);
        return ResponseEntity.ok().body(null);
    }
}