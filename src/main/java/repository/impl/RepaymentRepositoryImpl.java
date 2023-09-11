package repository.impl;

import base.repository.BaseRepositoryImpl;
import entity.Repayment;
import repository.RepaymentRepository;

import javax.persistence.EntityManager;

public class RepaymentRepositoryImpl extends BaseRepositoryImpl<Repayment,Long> implements RepaymentRepository {
    public RepaymentRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Repayment> getEntityClass() {
        return Repayment.class;
    }
}
