package service.impl;

import base.service.BaseServiceImpl;
import entity.Loan;
import entity.enums.LoanEnum;
import repository.LoanRepository;
import service.LoanService;

import javax.persistence.EntityManager;
import javax.validation.Validator;
import java.util.List;
import java.util.Optional;

public class LoanServiceImpl extends BaseServiceImpl<Loan,Long, LoanRepository> implements LoanService {
    public LoanServiceImpl(LoanRepository repository, Validator validator, EntityManager em) {
        super(repository, validator, em);
    }

    @Override
    public Class<Loan> getEntityClass() {
        return Loan.class;
    }

    @Override
    public Optional<Loan> getLoanById(Long id, LoanEnum loanEnum) {
        return repository.getLoanById(id, loanEnum);
    }

    @Override
    public Loan saveOrUpdate(Loan entity) {
        if (!isValid(entity))
            return null;
        return super.saveOrUpdate(entity);
    }
}
