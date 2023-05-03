package com.oburnett127.jobsearch.model;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Hibernate;
import com.oburnett127.jobsearch.user.User;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "job")
public class Job {
        @Id
        @GeneratedValue(strategy =  GenerationType.IDENTITY)
        private int id;
        @Basic(optional = false)
        private String title;
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "employer_id")
        private Employer employer;
        @Basic(optional = false)
        private String description;
        @Basic(optional = false)
        private String postDate;
        @ManyToMany(mappedBy = "jobs")
        private Set<User> applicants = new HashSet<>();

        public Job(String title, Employer employer, String description, String postDate) {
                this.title = title;
                this.employer = employer;
                this.description = description;
                this.postDate = postDate;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o != null) {
                        Hibernate.getClass(this);
                        Hibernate.getClass(o);
                }
                return false;
        }

        @Override
        public int hashCode() {
                return getClass().hashCode();
        }
}