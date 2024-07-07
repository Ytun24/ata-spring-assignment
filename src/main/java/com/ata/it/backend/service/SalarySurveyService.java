package com.ata.it.backend.service;

import com.ata.it.backend.model.SalarySurvey;
import com.ata.it.backend.model.SalarySurveySearchCriteria;

import java.util.List;

public interface SalarySurveyService {
    List<SalarySurvey> findAll(SalarySurveySearchCriteria filter);
}
