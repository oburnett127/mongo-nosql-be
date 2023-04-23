package com.oburnett127.jobsearch.controller;

import com.oburnett127.jobsearch.model.*;
import com.oburnett127.jobsearch.repository.EmployerRepository;
import com.oburnett127.jobsearch.service.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/job")
public class JobController {
    private final JobService service;
    private final EmployerRepository employerRepository;

    public JobController(JobService service, EmployerRepository employerRepository) {
        this.service = service;
        this.employerRepository = employerRepository;
    }

    @GetMapping("/list")
    public ResponseEntity<JobDto[]> view() {
        List<Job> jobs = service.listAll();

        var result = jobs.stream()
                .map(job -> new JobDto(job.getId(), job.getTitle(), job.getDescription(),
                        job.getPostDate(), job.getEmployer().getName()))
                .collect(Collectors.toList());

        JobDto[] jobArray = result.toArray(new JobDto[0]);

        return new ResponseEntity<>(jobArray, HttpStatus.OK);
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
        
        int empId = jobCreateRequest.getEmployerId();
        System.out.println("employer ID is: " + empId);

        Optional<Employer> emp = employerRepository.findById(empId);
        Employer employer = emp.get();

        // if(emp.getName() == null) {
        //     System.out.println("name of employer is null &&&&&&&&&&");
        //     emp.setName("");
        // }
        
        final var job = new Job(jobCreateRequest.getTitle(), employer, jobCreateRequest.getDescription(), LocalDate.now().toString()); 
        System.out.println("after building job");
        service.createJob(job);
        System.out.println("after calling createJob");
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