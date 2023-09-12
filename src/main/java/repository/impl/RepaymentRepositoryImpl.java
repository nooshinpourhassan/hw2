package repository.impl;

import base.repository.BaseRepositoryImpl;
import entity.Repayment;
import entity.Student;
import repository.RepaymentRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.time.Month;
import java.util.Optional;

public class RepaymentRepositoryImpl extends BaseRepositoryImpl<Repayment,Long> implements RepaymentRepository {
    public RepaymentRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Repayment> getEntityClass() {
        return Repayment.class;
    }
    @Override
    public Optional<Repayment> findUnpaidInstalment(String username) {
        TypedQuery<Repayment> query = em.createQuery("SELECT f.number,f.repaymentDate,f.instalment FROM Repayment f JOIN FETCH f.loan l JOIN FETCH l.student s WHERE s.nationalCode = :username AND f.paid = false", Repayment.class);
        query.setParameter("username", username);
        try {
            return query.getResultStream().findAny();
        } catch (NoResultException ex) {
            return Optional.empty();
        }
        }


    @Override
    public Optional<Repayment> findPaidInstalment(String username) {
        String jpql = "SELECT r.number , r.repaymentDate FROM Repayment r JOIN FETCH r.loan l JOIN FETCH l.student s WHERE s.nationalCode = :username AND r.paid = true";
        TypedQuery<Repayment> query = em.createQuery(jpql, Repayment.class);
        query.setParameter("username", username);
        try {
            return query.getResultList().stream().findFirst();
        } catch (NoResultException ex) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Repayment> findInstalment(String username, Month month) {
        String jpql = "SELECT r FROM Repayment r JOIN FETCH r.loan l JOIN FETCH l.student s WHERE s.nationalCode = :username AND r.paid = false AND FUNCTION('MONTH', r.repaymentDate) = :month";
        TypedQuery<Repayment> query = em.createQuery(jpql, Repayment.class);
        query.setParameter("username", username);
        query.setParameter("month", month.getValue());
        try {
            return query.getResultList().stream().findFirst();
        } catch (NoResultException ex) {
            return Optional.empty();
        }
    }
}
