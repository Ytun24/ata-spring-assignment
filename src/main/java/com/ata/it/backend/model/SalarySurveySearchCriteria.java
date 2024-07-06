package com.ata.it.backend.model;

import com.ata.it.backend.enums.SortOrderType;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SalarySurveySearchCriteria {
    private String salary;
    private String jobTitle;
    private String gender;
    private String sort;
    private SortOrderType sortType;
}
