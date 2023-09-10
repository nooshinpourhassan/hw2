package service.impl;

import base.service.BaseServiceImpl;
import entity.Information;
import repository.InformationRepository;
import service.InformationService;

import javax.persistence.EntityManager;
import javax.validation.Validator;

public class InformationServiceImpl extends BaseServiceImpl<Information,Long, InformationRepository> implements InformationService {
    public InformationServiceImpl(InformationRepository repository, Validator validator, EntityManager em) {
        super(repository, validator, em);
    }

    @Override
    public Class<Information> getEntityClass() {
        return Information.class;
    }
}
