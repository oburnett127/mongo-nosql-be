package com.oburnett127.jobsearch.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import com.oburnett127.jobsearch.model.Job;

@CrossOrigin
@RestController
@RequestMapping("/job")
@Slf4j
public class JobController {

    @Autowired
    private final JobService service;

    @GetMapping("/list")
    public ResponseEntity<List<Job>> view() {
        final var result = service.listAll();
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/get")
    public ResponseEntity<Job> getJob(@Validated @RequestBody JobRequest jobRequest) {
        final var job = service.getJob(jobRequest.getId());
        return ResponseEntity.ok().body(job);
    }

    @PostMapping("/create")
    public ResponseEntity<Job> createJob(@Validated @RequestBody CreateJobRequest createJobRequest) throws IOException {
        final var job = Job.builder()
                .title(createJobRequest.getTitle())
                .employerId(createJobRequest.getEmployerId())
                .desc(createJobRequest.getDesc())
                .postDate(createJobRequest.getPostDate())
                .build();
        service.createJob(job);
        return ResponseEntity.ok(job);
    }

    @PostMapping("/update")
    public ResponseEntity<Job> makeEdit(@Validated @RequestBody EditRequest editRequest) throws IOException {
        final var title = editRequest.getTitle();
        final var employerId = editRequest.getEmployerId();
        final var desc = editRequest.getDesc();
        final var postDate = editRequest.getPostDate();
        final var result = service.edit(title, employerId, desc, postDate);
        return ResponseEntity.ok().body(result);
    }
}