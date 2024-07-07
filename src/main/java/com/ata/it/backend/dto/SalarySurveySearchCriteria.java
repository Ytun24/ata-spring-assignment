package com.ata.it.backend.dto;

import com.ata.it.backend.enums.SortOrderType;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
@Builder
public class SalarySurveySearchCriteria {
    private List<String> fields;
    private Map<String, String> salaryComparable;
    private String jobTitle;
    private String gender;
    private String sort;
    private SortOrderType sortType;
}
