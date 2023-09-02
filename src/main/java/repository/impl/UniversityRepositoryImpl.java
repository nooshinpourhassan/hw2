package repository.impl;

import base.repository.BaseRepositoryImpl;
import entity.University;
import repository.UniversityRepository;

import javax.persistence.EntityManager;

public class UniversityRepositoryImpl extends BaseRepositoryImpl<University,Long> implements UniversityRepository {
    public UniversityRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<University> getEntityClass() {
        return University.class;
    }
}
