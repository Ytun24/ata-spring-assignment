package com.ata.it.backend.repository;

import com.ata.it.backend.model.SalarySurvey;
import com.ata.it.backend.model.SalarySurveySearchCriteria;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;


public class SalarySurveySpecs {
    public static Specification<SalarySurvey> getSalarySurveySpecification(SalarySurveySearchCriteria filter) {
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (filter.getSalary() != null) {
                predicates.add(builder.equal(root.get("salary"), filter.getSalary()));
            }
            if (!StringUtils.isEmpty(filter.getGender())) {
                predicates.add(builder.equal(builder.lower(root.get("gender")),
                        filter.getGender().toLowerCase()));
            }
            if (!StringUtils.isEmpty(filter.getJobTitle())) {
                predicates.add(builder.like(builder.lower(root.get("job_title")),
                        "%" + filter.getJobTitle().toLowerCase() + "%"));
            }
            return builder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }
}
