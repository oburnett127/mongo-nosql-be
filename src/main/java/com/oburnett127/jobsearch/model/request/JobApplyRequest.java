package com.oburnett127.jobsearch.model.request;

import lombok.Data;

@Data
public class JobApplyRequest {
    private int userId;
    private int jobId;
}
