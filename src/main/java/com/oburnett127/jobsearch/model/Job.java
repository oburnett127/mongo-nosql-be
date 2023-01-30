package com.oburnett127.jobsearch.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "job")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Job {
        @Id
        @GeneratedValue(strategy =  GenerationType.IDENTITY)
        private int id;
        private String title;
        @Column(name = "employer_id")
        private int employerId;
        private String description;
        @Column(name = "post_date")
        private String postDate;
}