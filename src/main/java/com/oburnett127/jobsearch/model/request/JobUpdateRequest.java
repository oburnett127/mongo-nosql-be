package com.oburnett127.jobsearch.model.request;

import com.oburnett127.jobsearch.model.Employer;

import lombok.Data;

@Data
public class JobUpdateRequest {
    private int id;
    private String title;
    private Employer employer;
    private String description;
    private String postDate;
}
