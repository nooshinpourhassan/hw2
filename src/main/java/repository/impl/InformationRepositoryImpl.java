package repository.impl;

import base.repository.BaseRepositoryImpl;
import entity.Information;
import entity.enums.GradeEnum;
import repository.InformationRepository;
import repository.StudentRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class InformationRepositoryImpl extends BaseRepositoryImpl<Information,Long> implements InformationRepository {
    public InformationRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Information> getEntityClass() {
        return Information.class;
    }


    @Override
    public boolean isInformationExistsByUsername(String nationalCode) {
        TypedQuery<Long> query = em.createQuery("select count( u ) from " + getEntityClass().getSimpleName() + " u where u.student.nationalCode= :nationalCode", Long.class);
        query.setParameter("nationalCode", nationalCode);
        Long count = query.getSingleResult();
        return count > 0;
    }
}
