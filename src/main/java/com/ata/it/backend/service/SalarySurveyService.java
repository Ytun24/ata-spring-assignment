package com.ata.it.backend.service;

import com.ata.it.backend.enums.SortOrderType;
import com.ata.it.backend.model.SalarySurvey;

import java.util.List;

public interface SalarySurveyService {

    List<SalarySurvey> sortSalarySurveyBy(String column, SortOrderType direction);

}
