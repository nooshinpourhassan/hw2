package repository.impl;

import base.repository.BaseRepositoryImpl;
import entity.Information;
import repository.InformationRepository;
import repository.StudentRepository;

import javax.persistence.EntityManager;

public class InformationRepositoryImpl extends BaseRepositoryImpl<Information,Long> implements InformationRepository {
    public InformationRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Information> getEntityClass() {
        return Information.class;
    }
}
