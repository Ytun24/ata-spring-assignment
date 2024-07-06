package com.ata.it.backend.service.impl;

import com.ata.it.backend.enums.SortOrderType;
import com.ata.it.backend.model.SalarySurvey;
import com.ata.it.backend.model.SalarySurveySearchCriteria;
import com.ata.it.backend.repository.SalarySurveyRepository;
import com.ata.it.backend.repository.SalarySurveySpecs;
import com.ata.it.backend.service.SalarySurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class SalarySurveyServiceImpl implements SalarySurveyService {

    @Autowired
    private SalarySurveyRepository salarySurveyRepository;

    private static final Map<String, String> sortColumn;

    static {
        sortColumn = new HashMap();
        sortColumn.put("job_title", "jobTitle");
        sortColumn.put("salary", "salary");
        sortColumn.put("gender", "gender");
    }

    public List<SalarySurvey> findSalarySurveyByGender(String gender) {
        List<SalarySurvey> salarySurveys = salarySurveyRepository.findByGender(gender);
        return salarySurveys;
    }

    public List<SalarySurvey> findAll(SalarySurveySearchCriteria filter) {
        Sort sorting = this.getSorting(filter.getSort(), filter.getSortType());
        if (sorting != null) {
            return salarySurveyRepository.findAll(SalarySurveySpecs.getSalarySurveySpecification(filter), sorting);
        } else {
            return salarySurveyRepository.findAll(SalarySurveySpecs.getSalarySurveySpecification(filter));
        }
    }

    private Sort getSorting(String column, SortOrderType direction) {
        if (sortColumn.containsKey(column)) {
            String columnKey = sortColumn.get(column);
            Sort sorting = direction.equals(SortOrderType.DESC) ? Sort.by(columnKey).descending() : Sort.by(columnKey).ascending();
            return sorting;
        } else {
            return null;
        }
    }
}
