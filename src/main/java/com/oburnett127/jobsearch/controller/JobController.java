package com.oburnett127.jobsearch.controller;

import com.oburnett127.jobsearch.model.*;
import com.oburnett127.jobsearch.service.JobService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "*")
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

    @GetMapping("/get/{id}")
    public ResponseEntity<Job> getJob(@Validated @PathVariable String id, final HttpServletResponse response) {
        System.out.println("inside getJob() $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ --------------------");
        final var job = service.getJob(Integer.parseInt(id));
        response.setHeader("Access-Control-Allow-Origin", "*");
        return ResponseEntity.ok().body(job);
    }

    @PostMapping("/create")
    public ResponseEntity<Job> createJob(@Validated @RequestBody CreateRequest createJobRequest) throws IOException {
        final var job = Job.builder()
                .title(createJobRequest.getTitle())
                .employerId(createJobRequest.getEmployerId())
                .description(createJobRequest.getDescription())
                .postDate(LocalDate.now().toString())
                .build();
        service.createJob(job);
        return ResponseEntity.ok(job);
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<Job> editJob(@Validated @PathVariable int id, @RequestBody EditRequest editRequest) throws IOException {
        final var title = editRequest.getTitle();
        final var employerId = editRequest.getEmployerId();
        final var description = editRequest.getDescription();
        final var postDate = editRequest.getPostDate();
        final var result = service.editJob(id, title, employerId, description, postDate);
        return ResponseEntity.ok().body(result);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<Job> deleteJob(@Validated @PathVariable int id) throws IOException {
        service.deleteJob(id);
        return ResponseEntity.ok().body(null);
    }
}