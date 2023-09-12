package service;

import base.service.BaseService;
import entity.Repayment;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

public interface RepaymentService extends BaseService<Repayment,Long> {
    Optional<Repayment> findUnpaidInstalment(String username);
    Optional<Repayment> findPaidInstalment(String username);
    Optional<Repayment> findInstalment(String username , Month month);
}
