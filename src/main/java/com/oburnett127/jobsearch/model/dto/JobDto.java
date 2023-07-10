package com.oburnett127.jobsearch.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
public class JobDto {
        private int id;
        private String title;
        private String description;
        private String postDate;
        private int employerId;
        private String employerName;
}