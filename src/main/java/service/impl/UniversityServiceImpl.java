package service.impl;

import base.service.BaseServiceImpl;
import entity.University;
import repository.UniversityRepository;
import service.UniversityService;

import javax.persistence.EntityManager;
import javax.validation.Validator;
import java.util.List;

public class UniversityServiceImpl extends BaseServiceImpl<University,Long, UniversityRepository> implements UniversityService {
    public UniversityServiceImpl(UniversityRepository repository, Validator validator, EntityManager em) {
        super(repository, validator, em);
    }

    @Override
    public Class<University> getEntityClass() {
        return University.class;
    }

    @Override
    public List<University> findUniversity(String title) {
        return repository.findUniversity(title);
    }

    @Override
    public University saveOrUpdate(University entity) {
        if (!isValid(entity))
            return null;
        return super.saveOrUpdate(entity);
    }
}
