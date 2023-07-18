package com.oburnett127.socialmedia.service;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import com.oburnett127.socialmedia.model.Friend;
import com.oburnett127.socialmedia.model.request.EmployerUpdateRequest;
import com.oburnett127.socialmedia.repository.FriendRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployerService {
    private final FriendRepository employerRepository;

    public EmployerService(FriendRepository employerRepository) {
        this.employerRepository = employerRepository;
    }

    @SneakyThrows
    public List<Friend> listAll() {
        return this.employerRepository.findAll();
    }

    @SneakyThrows
    public Friend getEmployerById(int id) {
        return this.employerRepository.getReferenceById(id);
    }

    @SneakyThrows
    public Optional<Friend> getEmployerByName(String employerName) {
        return employerRepository.findByName(employerName);
    }

    @SneakyThrows
    public void createEmployer(Friend employer) {
        this.employerRepository.save(employer);
    }

    @SneakyThrows
    public Friend updateEmployer(EmployerUpdateRequest employerUpdateRequest) {
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

    @SneakyThrows
    public void deleteEmployer(int id) { this.employerRepository.deleteById(id); }

    @SneakyThrows
    public int getMaxEmployerId() {
       return employerRepository.getMaxEmployerId();
    }
}