package com.oburnett127.jobsearch.service;

import com.oburnett127.jobsearch.model.Employer;
import com.oburnett127.jobsearch.model.EmployerUpdateRequest;
import com.oburnett127.jobsearch.repository.EmployerRepository;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerService {
    private final EmployerRepository employerRepository;

    public EmployerService(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }

    public List<Employer> listAll() {
        return this.employerRepository.findAll();
    }

    @SneakyThrows
    public Employer getEmployer(int id) {
        final var employer = this.employerRepository.getReferenceById(id);
        return employer;
    }

    public void createEmployer(Employer employer) {
        this.employerRepository.save(employer);
    }

    @SneakyThrows
    public Employer updateEmployer(EmployerUpdateRequest employerUpdateRequest) {
        final var id = employerUpdateRequest.getId();
        final var name = employerUpdateRequest.getName();

        final var employer = this.employerRepository.getReferenceById(id);

        if(name.isBlank() || name == null || !name.matches("^[a-zA-Z0-9 ]*$")) {
            throw new RuntimeException("The employer name cannot be blank nor contain non-alphanumeric characters.");
        }

        employer.setName(name);
        this.employerRepository.save(employer);
        return employer;
    }

    public void deleteEmployer(int id) { this.employerRepository.deleteById(id); }
}