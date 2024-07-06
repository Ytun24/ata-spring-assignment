package com.ata.it.backend.repository;

import com.ata.it.backend.model.SalarySurvey;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalarySurveyRepository extends JpaRepository<SalarySurvey, Integer>, JpaSpecificationExecutor<SalarySurvey> {
    List<SalarySurvey> findByGender(String gender);

    List<SalarySurvey> findAll(Specification<SalarySurvey> specification);

    List<SalarySurvey> findAll(Specification<SalarySurvey> specification, Sort sorting);
}
