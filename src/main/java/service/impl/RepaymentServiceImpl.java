package service.impl;

import base.service.BaseServiceImpl;
import entity.Repayment;
import repository.RepaymentRepository;
import service.RepaymentService;

import javax.persistence.EntityManager;
import javax.validation.Validator;

public class RepaymentServiceImpl extends BaseServiceImpl<Repayment,Long, RepaymentRepository> implements RepaymentService {
    public RepaymentServiceImpl(RepaymentRepository repository, Validator validator, EntityManager em) {
        super(repository, validator, em);
    }

    @Override
    public Class<Repayment> getEntityClass() {
        return Repayment.class;
    }


}
