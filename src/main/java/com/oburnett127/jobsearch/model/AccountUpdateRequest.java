package com.oburnett127.jobsearch.model;

import lombok.Data;

@Data
public class AccountUpdateRequest {
    private int id;
    private String email;
    private String password;
}
