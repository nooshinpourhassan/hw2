package repository.impl;

import base.repository.BaseRepositoryImpl;
import entity.Information;
import entity.Student;
import entity.enums.GradeEnum;
import repository.InformationRepository;
import repository.StudentRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.Optional;

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

    @Override
    public Optional<Information> getInformationByStudentId(Long id) {
        TypedQuery<Information> query =
                em.createQuery("from " + getEntityClass().getSimpleName() + " u where u.student.id= :id ", Information.class);

        query.setParameter("id", id);
        try {
            Information information = query.getSingleResult();
            return Optional.ofNullable(information);
        } catch (NoResultException ex) {
            return Optional.empty();
        }
    }
}
