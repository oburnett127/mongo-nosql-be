package com.oburnett127.jobsearch.controller;

import com.oburnett127.jobsearch.model.*;
import com.oburnett127.jobsearch.service.JobService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/job")
@Slf4j
public class JobController {
    private final JobService service;

    public JobController(JobService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Job>> view() {
        final var result = service.listAll();
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/get")
    public ResponseEntity<Job> getJob(@Validated @RequestBody GetRequest jobRequest) {
        final var job = service.getJob(jobRequest.getId());
        return ResponseEntity.ok().body(job);
    }

    @PostMapping("/create")
    public ResponseEntity<Job> createJob(@Validated @RequestBody CreateRequest createJobRequest) throws IOException {
        final var job = Job.builder()
                .title(createJobRequest.getTitle())
                .employerId(createJobRequest.getEmployerId())
                .desc(createJobRequest.getDesc())
                .postDate(LocalDate.now().toString())
                .build();
        service.createJob(job);
        return ResponseEntity.ok(job);
    }

    @PostMapping("/update")
    public ResponseEntity<Job> editJob(@Validated @RequestBody EditRequest editRequest) throws IOException {
        final var id = editRequest.getId();
        final var title = editRequest.getTitle();
        final var employerId = editRequest.getEmployerId();
        final var desc = editRequest.getDesc();
        final var postDate = editRequest.getPostDate();
        final var result = service.editJob(id, title, employerId, desc, postDate);
        return ResponseEntity.ok().body(result);
    }

    @PostMapping("/delete")
    public ResponseEntity<Job> deleteJob(@Validated @RequestBody DeleteRequest deleteRequest) throws IOException {
        final var id = deleteRequest.getId();
        service.deleteJob(id);
        return ResponseEntity.ok().body(null);
    }
}