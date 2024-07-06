package com.ata.it.backend.controller;

import com.ata.it.backend.enums.SortOrderType;
import com.ata.it.backend.model.SalarySurvey;
import com.ata.it.backend.model.SalarySurveySearchCriteria;
import com.ata.it.backend.repository.SalarySurveyRepository;
import com.ata.it.backend.service.impl.SalarySurveyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/job_data")
public class SalarySurveyController {

    private SalarySurveyServiceImpl salarySurveyService;

    @Autowired
    public SalarySurveyController(SalarySurveyServiceImpl salarySurveyService) {
        this.salarySurveyService = salarySurveyService;
    }

    @GetMapping("")
    public List<SalarySurvey> getJobData(
            @RequestParam(required = false) String gender,
            @RequestParam(required = false) String salary,
            @RequestParam(required = false) String jobTitle,
            @RequestParam(required = false, defaultValue = "") List<String> fields,
            @RequestParam(required = false) String sort,
            @RequestParam(required = false, name = "sort_type", defaultValue = "ASC") SortOrderType sortType) {
        SalarySurveySearchCriteria filter = SalarySurveySearchCriteria.builder()
                .salary(salary).gender(gender).jobTitle(jobTitle).sort(sort).sortType(sortType).build();
        List<SalarySurvey> result = this.salarySurveyService.findAll(filter);
        return result;
    }
}
