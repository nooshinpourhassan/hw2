package base.service;

import base.entity.BaseEntity;

import java.util.Collection;
import java.util.Optional;

public interface BaseService <T extends BaseEntity<ID>,ID extends Number> {

    T saveOrUpdate(T entity);

    Optional<T> findById(ID id);

    void deleteById(ID id);

    Collection<T> findAll();

    long getCount();

    void saveAll(Collection<T> entityCollection);

    void beginTransaction();

    void commitTransaction();

    void rollBack();

    public boolean isValid(T entity);


}
