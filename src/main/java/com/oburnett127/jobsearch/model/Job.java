package com.oburnett127.jobsearch.model;

import lombok.*;
import org.hibernate.Hibernate;
import javax.persistence.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "job")
public class Job {
        @Id
        @GeneratedValue(strategy =  GenerationType.IDENTITY)
        private int id;
        @Basic(optional = false)
        private String title;
        @Basic(optional = false)
        private int employerId;
        @Basic(optional = false)
        private String description;
        @Basic(optional = false)
        private String postDate;

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