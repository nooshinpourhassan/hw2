package base.repository;


import base.entity.BaseEntity;

import java.util.Collection;
import java.util.Optional;

public interface BaseRepository<T extends BaseEntity<ID>,ID extends Number> {

    T saveOrUpdate(T entity);

    Optional<T> findById(ID id);

    void deleteById(ID id);

    Collection<T> findAll();

    long getCount();

    Collection<T> saveAll(Collection<T> entityCollection);





}
