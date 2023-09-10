package service;

import base.service.BaseService;
import entity.Loan;
import entity.enums.LoanEnum;

import java.util.List;
import java.util.Optional;

public interface LoanService extends BaseService<Loan,Long> {
    Optional<Loan> getLoanById(Long id , LoanEnum loanEnum);
}
