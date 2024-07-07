package com.ata.it.backend.model;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(SalarySurvey.class)
public class SalarySurvey_ {

    public static SingularAttribute<SalarySurvey, Integer> id;

    public static SingularAttribute<SalarySurvey, String> dateTime;

    public static SingularAttribute<SalarySurvey, String> employer;

    public static SingularAttribute<SalarySurvey, String> location;

    public static SingularAttribute<SalarySurvey, String> jobTitle;

    public static SingularAttribute<SalarySurvey, String> yearAtEmployer;

    public static SingularAttribute<SalarySurvey, String> yearOfExperience;

    public static SingularAttribute<SalarySurvey, String> salary;

    public static SingularAttribute<SalarySurvey, String> signingBonus;

    public static SingularAttribute<SalarySurvey, String> annualBonus;

    public static SingularAttribute<SalarySurvey, String> annualStock;

    public static SingularAttribute<SalarySurvey, String> gender;

    public static SingularAttribute<SalarySurvey, String> comments;
}
