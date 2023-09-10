package repository.impl;

import base.repository.BaseRepositoryImpl;
import entity.Loan;
import entity.enums.LoanEnum;
import repository.LoanRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class LoanRepositoryImpl extends BaseRepositoryImpl<Loan,Long> implements LoanRepository {
    public LoanRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Loan> getEntityClass() {
        return Loan.class;
    }

    @Override
    public Optional<Loan> getLoanById(Long id, LoanEnum loanEnum) {
        TypedQuery<Loan> query= em.createQuery("SELECT l FROM  Loan l where l.student.id=:id and l.loanEnum=:loanEnum" ,
                Loan.class);
        query.setParameter("id",id);
        query.setParameter("loanEnum",loanEnum);
        try {
         return query.getResultList().stream().findAny();
        }catch (NoResultException e){
            return Optional.empty();
        }
    }
}