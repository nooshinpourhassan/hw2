package repository.impl;

import base.repository.BaseRepositoryImpl;
import entity.Student;
import entity.University;
import repository.UniversityRepository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class UniversityRepositoryImpl extends BaseRepositoryImpl<University,Long> implements UniversityRepository {
    public UniversityRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<University> getEntityClass() {
        return University.class;
    }

    @Override
    public List<University> findUniversity(String title) {
        CriteriaBuilder criteriaBuilder=em.getCriteriaBuilder();
        CriteriaQuery<University> criteriaQuery=criteriaBuilder.createQuery(University.class);
        Root<University> from = criteriaQuery.from(University.class);
        Predicate name = criteriaBuilder.like(from.get("name"), "%" + title + "%");
        Predicate universityEnum = criteriaBuilder.like(from.get("universityEnum"), "%" + title.toUpperCase() + "%");
        Predicate finalPredicate    = criteriaBuilder.or(name,universityEnum);
        criteriaQuery.select(from).where(finalPredicate);
        return em.createQuery(criteriaQuery).getResultList();
    }
}
