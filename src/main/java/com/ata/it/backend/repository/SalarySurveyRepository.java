package com.ata.it.backend.repository;

import com.ata.it.backend.model.SalarySurvey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface SalarySurveyRepository extends JpaRepository<SalarySurvey, Integer>, JpaSpecificationExecutor<SalarySurvey> {
}
