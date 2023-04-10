package com.oburnett127.jobsearch.model;

import lombok.Data;

@Data
public class AccountCreateRequest {
    private int id;
    private String email;
    private String password;
    private Boolean isAdmin;
    private Boolean isEmployer;
}
