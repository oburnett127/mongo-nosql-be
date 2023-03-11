package com.oburnett127.jobsearch.model;

import lombok.Data;

@Data
public class JobCreateRequest {
    private String title;
    private Employer employer;
    private String description;
}
