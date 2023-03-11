package com.oburnett127.jobsearch.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;

@Data
@AllArgsConstructor
public class JobDto {
        private int id;
        private String title;
        private String description;
        private String postDate;
        private String employerName;
}