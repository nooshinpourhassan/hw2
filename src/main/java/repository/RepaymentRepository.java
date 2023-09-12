package repository;

import base.repository.BaseRepository;
import entity.Repayment;

import java.time.Month;
import java.util.List;
import java.util.Optional;

public interface RepaymentRepository extends BaseRepository<Repayment,Long> {
    Optional<Repayment> findUnpaidInstalment(String username);
    Optional<Repayment> findPaidInstalment(String username);
    Optional<Repayment> findInstalment(String username , Month month);
}
