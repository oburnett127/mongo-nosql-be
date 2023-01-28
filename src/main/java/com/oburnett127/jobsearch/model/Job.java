package com.oburnett127.jobsearch.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "job")
public class Job {
        @Id
        @GeneratedValue(strategy =  GenerationType.IDENTITY)
        private long title;
        private final String employerId;
        private final String desc;
        private final String postDate;
}
