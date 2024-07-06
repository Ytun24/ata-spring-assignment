package com.ata.it.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
@Table(name="salary_survey")
public class SalarySurvey {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "date_time")
    private String dateTime;

    private String employer;

    private String location;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "year_at_employer")
    private String yearAtEmployer;

    @Column(name = "year_of_experience")
    private String yearOfExperience;

    private String salary;

    @Column(name = "signing_bonus")
    private String signingBonus;

    @Column(name = "annual_bonus")
    private String annualBonus;

    @Column(name = "annual_stock")
    private String annualStock;

    private String gender;

    private String comments;

}
