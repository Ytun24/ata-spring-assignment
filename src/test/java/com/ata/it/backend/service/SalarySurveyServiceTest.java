package com.ata.it.backend.service;

import com.ata.it.backend.enums.SortOrderType;
import com.ata.it.backend.repository.SalarySurveyRepository;
import com.ata.it.backend.service.impl.SalarySurveyServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SalarySurveyServiceTest {

    @Mock
    SalarySurveyRepository salarySurveyRepository;

    @InjectMocks
    SalarySurveyServiceImpl salarySurveyService;

    @Test
    void sortData_withGivenColumnAndDescOrder() {
        Sort expectedSort = Sort.by("salary").descending();

        salarySurveyService.sortSalarySurveyBy("salary", SortOrderType.DESC);

        verify(salarySurveyRepository, times(1)).findAll(expectedSort);
    }

    @Test
    void sortData_withGivenColumnAndAscOrder() {
        Sort expectedSort = Sort.by("gender").ascending();

        salarySurveyService.sortSalarySurveyBy("gender", SortOrderType.ASC);

        verify(salarySurveyRepository, times(1)).findAll(expectedSort);
    }
}
