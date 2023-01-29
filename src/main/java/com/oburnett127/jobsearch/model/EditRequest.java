package com.oburnett127.jobsearch.model;

import lombok.Data;

@Data
public class EditRequest {
    private long id;
    private String title;
    private long employerId;
    private String desc;
    private String postDate;
}
