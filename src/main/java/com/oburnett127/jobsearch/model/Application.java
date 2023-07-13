package com.oburnett127.jobsearch.model;

import lombok.*;
import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "application")
public class Application {
        @Id
        @GeneratedValue(strategy =  GenerationType.IDENTITY)
        private int id;
        @Basic(optional = false)
        private int jobId;
        @Basic(optional = false)
        private int applicantId;

        public Application(int jobId, int applicantId) {
                this.jobId = jobId;
                this.applicantId = applicantId;
        }
}