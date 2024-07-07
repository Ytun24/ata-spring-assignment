package com.ata.it.backend.controller;

import com.ata.it.backend.enums.SortOrderType;
import com.ata.it.backend.model.SalarySurvey;
import com.ata.it.backend.dto.SalarySurveyComparableParam;
import com.ata.it.backend.dto.SalarySurveySearchCriteria;
import com.ata.it.backend.service.impl.SalarySurveyServiceImpl;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/job_data")
public class SalarySurveyController {

    private SalarySurveyServiceImpl salarySurveyService;

    public SalarySurveyController(SalarySurveyServiceImpl salarySurveyService) {
        this.salarySurveyService = salarySurveyService;
    }

    @GetMapping("")
    public List<SalarySurvey> getJobData(
            @RequestParam(required = false) String gender,
            @RequestParam(required = false) String jobTitle,
            @Schema(allowableValues = "id, job_title, salary, employer, location, gender", types = "array") @RequestParam(required = false, defaultValue = "") List<String> fields,
            @RequestParam(required = false) String sort,
            @RequestParam(required = false, name = "sort_type", defaultValue = "ASC") SortOrderType sortType,
            SalarySurveyComparableParam comparableParam) {
        SalarySurveySearchCriteria filter = SalarySurveySearchCriteria.builder()
                .salaryComparable(comparableParam.getSalary())
                .gender(gender)
                .jobTitle(jobTitle)
                .sort(sort)
                .sortType(sortType)
                .fields(fields)
                .build();
        List<SalarySurvey> result = this.salarySurveyService.findAll(filter);
        return result;
    }


}
