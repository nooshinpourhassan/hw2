package service.impl;

import base.service.BaseServiceImpl;
import entity.Loan;
import repository.LoanRepository;
import service.LoanService;

import javax.persistence.EntityManager;
import javax.validation.Validator;

public class LoanServiceImpl extends BaseServiceImpl<Loan,Long, LoanRepository> implements LoanService {
    public LoanServiceImpl(LoanRepository repository, Validator validator, EntityManager em) {
        super(repository, validator, em);
    }

    @Override
    public Class<Loan> getEntityClass() {
        return Loan.class;
    }
}
