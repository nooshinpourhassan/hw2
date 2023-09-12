package service.impl;

import base.service.BaseServiceImpl;
import entity.Repayment;
import repository.RepaymentRepository;
import service.RepaymentService;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.validation.Validator;
import java.time.Month;
import java.util.List;
import java.util.Optional;

public class RepaymentServiceImpl extends BaseServiceImpl<Repayment,Long, RepaymentRepository> implements RepaymentService {
    public RepaymentServiceImpl(RepaymentRepository repository, Validator validator, EntityManager em) {
        super(repository, validator, em);
    }

    @Override
    public Class<Repayment> getEntityClass() {
        return Repayment.class;
    }


    @Override
    public Optional<Repayment> findUnpaidInstalment(String username) {
        Optional<Repayment> unpaidInstalment = null;
        try {
            unpaidInstalment = repository.findUnpaidInstalment(username);
        }catch (Exception e ){
            System.out.println(e.getMessage());
        }
        return unpaidInstalment;
    }

    @Override
    public Optional<Repayment> findPaidInstalment(String username) {
        Optional<Repayment> paidInstalment = null;
        try {
            paidInstalment = repository.findPaidInstalment(username);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return paidInstalment;
    }

    @Override
    public Optional<Repayment> findInstalment(String username, Month month) {
        Optional<Repayment> unpaidinstalment = null;
        try {
            unpaidinstalment =repository.findInstalment(username , month);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return unpaidinstalment;

    }
}
