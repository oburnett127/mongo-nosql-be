package com.oburnett127.jobsearch.model;

import lombok.Data;

@Data
public class EditRequest {
    private int id;
    private String title;
    private int employerId;
    private String description;
    private String postDate;
}
