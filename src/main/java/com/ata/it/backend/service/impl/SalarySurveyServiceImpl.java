package com.ata.it.backend.service.impl;

import com.ata.it.backend.enums.SortOrderType;
import com.ata.it.backend.model.SalarySurvey;
import com.ata.it.backend.repository.SalarySurveyRepository;
import com.ata.it.backend.service.SalarySurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalarySurveyServiceImpl implements SalarySurveyService {

    @Autowired
    private SalarySurveyRepository salarySurveyRepository;

    public List<SalarySurvey> sortSalarySurveyBy(String column, SortOrderType Direction) {
        Sort sorting = Direction.equals(SortOrderType.DESC) ? Sort.by(column).descending() : Sort.by(column).ascending();
        List<SalarySurvey> salarySurveys = salarySurveyRepository.findAll(sorting);
        return salarySurveys;
    }
}
