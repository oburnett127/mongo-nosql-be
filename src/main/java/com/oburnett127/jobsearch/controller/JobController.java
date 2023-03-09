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
    public ResponseEntity<Job> getJob(@Validated @PathVariable String id) {
        System.out.println("inside getJob() $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ --------------------");
        final var job = service.getJob(Integer.parseInt(id));
        return ResponseEntity.ok().body(job);
    }

    @PostMapping("/create")
    public ResponseEntity<Job> createJob(@Validated @RequestBody JobCreateRequest createJobRequest) throws IOException {
        System.out.println("inside createJob() $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ --------------------");
        final var job = Job.builder()
                .title(createJobRequest.getTitle())
                .employerId(createJobRequest.getEmployerId())
                .description(createJobRequest.getDescription())
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