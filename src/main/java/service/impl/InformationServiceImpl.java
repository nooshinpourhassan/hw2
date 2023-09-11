package service.impl;

import base.service.BaseServiceImpl;
import entity.Information;
import repository.InformationRepository;
import service.InformationService;

import javax.persistence.EntityManager;
import javax.validation.Validator;
import java.util.Optional;

public class InformationServiceImpl extends BaseServiceImpl<Information,Long, InformationRepository> implements InformationService {
    public InformationServiceImpl(InformationRepository repository, Validator validator, EntityManager em) {
        super(repository, validator, em);
    }

    @Override
    public Class<Information> getEntityClass() {
        return Information.class;
    }



    @Override
    public Information saveOrUpdate(Information entity) {
        if (!isValid(entity))
            return null;
       else return super.saveOrUpdate(entity);
    }

    @Override
    public boolean isInformationExistsByUsername(String nationalCode) {
        return repository.isInformationExistsByUsername(nationalCode);
    }

    @Override
    public Optional<Information> getInformationByStudentId(Long id) {
        return repository.getInformationByStudentId(id);
    }
}
