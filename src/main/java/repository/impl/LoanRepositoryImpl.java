package repository.impl;

import base.repository.BaseRepositoryImpl;
import entity.Loan;
import repository.LoanRepository;

import javax.persistence.EntityManager;

public class LoanRepositoryImpl extends BaseRepositoryImpl<Loan,Long> implements LoanRepository {
    public LoanRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Loan> getEntityClass() {
        return Loan.class;
    }
}
