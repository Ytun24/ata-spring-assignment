package com.ata.it.backend.service.impl;

import com.ata.it.backend.enums.SortOrderType;
import com.ata.it.backend.model.SalarySurvey;
import com.ata.it.backend.dto.SalarySurveySearchCriteria;
import com.ata.it.backend.model.SalarySurvey_;
import com.ata.it.backend.service.SalarySurveyService;
import jakarta.persistence.*;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


import java.util.*;


@Service public class SalarySurveyServiceImpl implements SalarySurveyService {

    @PersistenceContext private EntityManager entityManager;

    private static final Map<String, String> sortColumn;
    private static final Map<String, String> columnKeyName;

    static {
        sortColumn = new HashMap();
        sortColumn.put("job_title", "jobTitle");
        sortColumn.put("salary", "salary");
        sortColumn.put("gender", "gender");

        columnKeyName = new HashMap();
        columnKeyName.put("job_title", "jobTitle");
        columnKeyName.put("year_at_employer", "yearAtEmployer");
        columnKeyName.put("year_of_experience", "yearOfExperience");
        columnKeyName.put("signing_bonus", "signingBonus");
        columnKeyName.put("annual_bonus", "annualBonus");
        columnKeyName.put("annual_stock", "annualStock");
        columnKeyName.put("date_time", "dateTime");
        columnKeyName.put("id", "id");
        columnKeyName.put("employer", "employer");
        columnKeyName.put("location", "location");
        columnKeyName.put("salary", "salary");
        columnKeyName.put("gender", "gender");
        columnKeyName.put("comments", "comments");
    }

    public List<SalarySurvey> findAll(SalarySurveySearchCriteria filter) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> tupleCriteria = builder.createQuery(Tuple.class);
        Root<SalarySurvey> tupleRoot = tupleCriteria.from(SalarySurvey.class);

        List<Selection> columnList = generateSelectColumn(tupleRoot, filter.getFields());

        if (!columnList.isEmpty()) {
            return findWithSelectColumn(builder, tupleCriteria, tupleRoot, filter, columnList);
        } else {
            return findWithAllColumn(builder, filter);
        }
    }

    public List<SalarySurvey> findWithAllColumn(CriteriaBuilder builder, SalarySurveySearchCriteria filter) {
        CriteriaQuery<SalarySurvey> criteria = builder.createQuery(SalarySurvey.class);
        Root<SalarySurvey> root = criteria.from(SalarySurvey.class);

        criteria.select(root);

        Predicate[] predicates = generateWherePredicates(root, builder, filter);
        criteria.where(predicates);

        Order order = generateOrder(root, builder, filter);
        if (order != null) {
            criteria.orderBy(order);
        }

        List<SalarySurvey> salarySurveys = entityManager.createQuery(criteria).getResultList();
        return salarySurveys;
    }

    public List<SalarySurvey> findWithSelectColumn(CriteriaBuilder builder, CriteriaQuery<Tuple> tupleCriteria, Root<SalarySurvey> tupleRoot, SalarySurveySearchCriteria filter, List columnList) {
        tupleCriteria.multiselect(columnList);

        Predicate[] predicates = generateWherePredicates(tupleRoot, builder, filter);
        tupleCriteria.where(predicates);

        Order order = generateOrder(tupleRoot, builder, filter);
        if (order != null) {
            tupleCriteria.orderBy(order);
        }

        List<Tuple> tuplesResult = entityManager.createQuery(tupleCriteria).getResultList();
        return mappingSalarySurveyTuple(tupleRoot, tuplesResult, filter.getFields());
    }

    private <T> List<Selection> generateSelectColumn(Root<T> root, List<String> fields) {
        List<Selection> columnList = new ArrayList<>();
        for (String field : fields) {
            if (columnKeyName.containsKey(field)) {
                columnList.add(root.get(columnKeyName.get(field)));
            }
        }
        return columnList;
    }

    private List<SalarySurvey> mappingSalarySurveyTuple(Root<SalarySurvey> root, List<Tuple> tuplesResult, List<String> columnList) {
        List<SalarySurvey> salarySurveyList = new ArrayList<>();

        for (Tuple tuple : tuplesResult) {
            SalarySurvey survey = new SalarySurvey();

            if (columnList.contains("id")) {
                survey.setId(tuple.get(root.get(SalarySurvey_.id)));
            }
            if (columnList.contains("salary")) {
                survey.setSalary(tuple.get(root.get(SalarySurvey_.salary)));
            }
            if (columnList.contains("job_title")) {
                survey.setJobTitle(tuple.get(root.get(SalarySurvey_.jobTitle)));
            }
            if (columnList.contains("employer")) {
                survey.setJobTitle(tuple.get(root.get(SalarySurvey_.employer)));
            }
            if (columnList.contains("location")) {
                survey.setJobTitle(tuple.get(root.get(SalarySurvey_.location)));
            }
            if (columnList.contains("gender")) {
                survey.setGender(tuple.get(root.get(SalarySurvey_.gender)));
            }

            salarySurveyList.add(survey);
        }

        return salarySurveyList;
    }

    private Predicate[] generateWherePredicates(Root<SalarySurvey> root, CriteriaBuilder builder, SalarySurveySearchCriteria filter) {
        List<Predicate> predicates = new ArrayList<>();
        if (filter.getSalaryComparable() != null) {
            if (filter.getSalaryComparable().containsKey("gte")) {
                predicates.add(builder.greaterThanOrEqualTo(root.get("salary"), filter.getSalaryComparable().get("gte")));
            }
            if (filter.getSalaryComparable().containsKey("gt")) {
                predicates.add(builder.greaterThan(root.get("salary"), filter.getSalaryComparable().get("gt")));
            }
            if (filter.getSalaryComparable().containsKey("lte")) {
                predicates.add(builder.lessThanOrEqualTo(root.get("salary"), filter.getSalaryComparable().get("lte")));
            }
            if (filter.getSalaryComparable().containsKey("lt")) {
                predicates.add(builder.lessThan(root.get("salary"), filter.getSalaryComparable().get("lt")));
            }
            if (filter.getSalaryComparable().containsKey("ne")) {
                predicates.add(builder.notEqual(root.get("salary"), filter.getSalaryComparable().get("ne")));
            }
            if (filter.getSalaryComparable().containsKey("e")) {
                predicates.add(builder.equal(root.get("salary"), filter.getSalaryComparable().get("e")));
            }
        }
        if (!StringUtils.isEmpty(filter.getGender())) {
            predicates.add(builder.equal(builder.lower(root.get("gender")), filter.getGender().toLowerCase()));
        }
        if (!StringUtils.isEmpty(filter.getJobTitle())) {
            predicates.add(builder.equal(builder.lower(root.get("job_title")), filter.getJobTitle().toLowerCase()));
        }

        return predicates.toArray(new Predicate[predicates.size()]);
    }

    private Order generateOrder(Root root, CriteriaBuilder builder, SalarySurveySearchCriteria filter) {
        SortOrderType direction = filter.getSortType();
        String column = filter.getSort();
        if (sortColumn.containsKey(column)) {
            String columnKey = sortColumn.get(column);
            if (direction.equals(SortOrderType.DESC)) {
                return builder.desc(root.get(columnKey));
            } else {
                return builder.asc(root.get(columnKey));
            }
        } else {
            return null;
        }
    }

}
