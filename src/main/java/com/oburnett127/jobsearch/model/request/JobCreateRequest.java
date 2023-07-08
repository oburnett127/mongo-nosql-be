package com.oburnett127.jobsearch.model.request;

import lombok.Data;

@Data
public class JobCreateRequest {
    private String title;
    private int employerId;
    private String description;
}
