package repository.impl;

import base.repository.BaseRepositoryImpl;
import entity.Student;
import repository.StudentRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.Optional;

public class StudentRepositoryImpl extends BaseRepositoryImpl<Student,Long> implements StudentRepository {
    public StudentRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Student> getEntityClass() {
        return Student.class;
    }

    @Override
    public boolean isStudentExistsByUsername(String username) {
        TypedQuery<Long> query = em.createQuery("select count( u ) from " + getEntityClass().getSimpleName() + " u where u.username= :username", Long.class);
        query.setParameter("username", username);
        Long count = query.getSingleResult();
        return count > 0;
    }

    @Override
    public Optional<Student> getUserByUsername(String username) {
        TypedQuery<Student> query =
                em.createQuery("from " + getEntityClass().getSimpleName() + " u where u.username= :username ", Student.class);

        query.setParameter("username", username);
        try {
            Student student = query.getSingleResult();
            return Optional.ofNullable(student);
        } catch (NoResultException ex) {
            return Optional.empty();
        }
    }
}
