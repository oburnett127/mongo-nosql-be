package com.oburnett127.jobsearch.model;

import lombok.Data;

@Data
public class CreateRequest {
    private String title;
    private long employerId;
    private String desc;
}
