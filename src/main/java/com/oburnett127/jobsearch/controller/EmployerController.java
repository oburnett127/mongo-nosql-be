package com.oburnett127.jobsearch.controller;

import com.oburnett127.jobsearch.model.Employer;
import com.oburnett127.jobsearch.model.EmployerCreateRequest;
import com.oburnett127.jobsearch.model.EmployerUpdateRequest;
import com.oburnett127.jobsearch.service.EmployerService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/employer")
public class EmployerController {
    private final EmployerService service;

    public EmployerController(EmployerService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Employer>> view() {
        final var result = service.listAll();
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Employer> getEmployer(@Validated @PathVariable String id) {
        System.out.println("inside getEmployer() $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ --------------------");
        final var employer = service.getEmployer(Integer.parseInt(id));
        return ResponseEntity.ok().body(employer);
    }

    @PostMapping("/create")
    public ResponseEntity<Employer> createEmployer(@Validated @RequestBody EmployerCreateRequest employerCreateRequest) throws IOException {
        System.out.println("inside createEmployer() $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ --------------------");
        final var employer = Employer.builder()
                .name(employerCreateRequest.getName())
                .build();
        service.createEmployer(employer);
        return ResponseEntity.ok(employer);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Employer> updateEmployer(@Validated @PathVariable int id, @RequestBody EmployerUpdateRequest employerUpdateRequest) throws IOException {
        System.out.println("inside updateEmployer() $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ --------------------");
        employerUpdateRequest.setId(id);
        final var result = service.updateEmployer(employerUpdateRequest);
        return ResponseEntity.ok().body(result);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<Employer> deleteEmployer(@Validated @PathVariable int id) throws IOException {
        System.out.println("inside deleteEmployer() $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ --------------------");
        service.deleteEmployer(id);
        return ResponseEntity.ok().body(null);
    }
}