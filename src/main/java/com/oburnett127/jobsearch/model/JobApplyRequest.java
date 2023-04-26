package com.oburnett127.jobsearch.model;

import lombok.Data;

@Data
public class JobApplyRequest {
    private int userId;
    private int jobId;
}
