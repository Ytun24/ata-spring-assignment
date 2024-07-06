package com.ata.it.backend.service;

import com.ata.it.backend.enums.SortOrderType;
import com.ata.it.backend.model.SalarySurvey;
import com.ata.it.backend.model.SalarySurveySearchCriteria;
import com.ata.it.backend.repository.SalarySurveyRepository;
import com.ata.it.backend.service.impl.SalarySurveyServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SalarySurveyServiceTest {

    @Mock
    SalarySurveyRepository salarySurveyRepository;

    @InjectMocks
    SalarySurveyServiceImpl salarySurveyService;

    @Test
    void findAll_sortData_withValidColumnNameAndDescOrder() {
        Sort expectedSort = Sort.by("salary").descending();
        SalarySurveySearchCriteria filter = SalarySurveySearchCriteria.builder().sort("salary").sortType(SortOrderType.DESC).build();

        salarySurveyService.findAll(filter);

        verify(salarySurveyRepository, times(1)).findAll((Specification<SalarySurvey>) any(), eq(expectedSort));
    }

    @Test
    void findAll_sortData_withValidGivenColumnNameAndAscOrder() {
        Sort expectedSort = Sort.by("jobTitle").ascending();
        SalarySurveySearchCriteria filter = SalarySurveySearchCriteria.builder().sort("job_title").sortType(SortOrderType.ASC).build();

        salarySurveyService.findAll(filter);

        verify(salarySurveyRepository, times(1)).findAll((Specification<SalarySurvey>) any(), eq(expectedSort));
    }

    @Test
    void findAll_sortData_withInvalidColumnName() {
        SalarySurveySearchCriteria filter = SalarySurveySearchCriteria.builder().sort("invalid_name").build();

        salarySurveyService.findAll(filter);

        verify(salarySurveyRepository, times(1)).findAll((Specification<SalarySurvey>) any());

    }
}
