package com.oburnett127.jobsearch.model;

import lombok.Data;

@Data
public class CreateRequest {
    private String title;
    private int employerId;
    private String desc;
}
