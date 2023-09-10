package repository;

import base.repository.BaseRepository;
import entity.Loan;
import entity.enums.LoanEnum;

import java.util.List;
import java.util.Optional;

public interface LoanRepository extends BaseRepository<Loan,Long> {
    Optional<Loan> getLoanById(Long id , LoanEnum loanEnum);
}
