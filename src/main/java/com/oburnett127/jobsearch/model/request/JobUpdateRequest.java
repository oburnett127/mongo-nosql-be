package com.oburnett127.jobsearch.model.request;

import lombok.Data;

@Data
public class JobUpdateRequest {
    private int id;
    private String title;
    private int employerId;
    private String description;
    private String postDate;
}
