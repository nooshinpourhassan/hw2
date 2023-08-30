package base.repository;


import base.entity.BaseEntity;
import lombok.AllArgsConstructor;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


@AllArgsConstructor
public abstract class BaseRepositoryImpl
        <T extends BaseEntity<ID>, ID extends Number> implements BaseRepository<T, ID> {

    protected  EntityManager em;

    @Override
    public T saveOrUpdate(T entity) {
        entity = saveWithoutTransaction(entity);
        return entity;
    }

    public T saveWithoutTransaction(T entity) {
        if (entity.getId() == null)
            em.persist(entity);
         else
            entity = em.merge(entity);

        return entity;
    }

    @Override
    public Optional<T> findById(ID id) {
        return Optional.ofNullable( em.find(getEntityClass(),id));
    }

    @Override
    public void deleteById(ID id) {
        T t = findById(id).get();
        em.remove(t);
    }

    @Override
    public Collection<T> findAll() {
        return em.createQuery("from "+ getEntityClass().getSimpleName(),getEntityClass()).getResultList();
    }

    @Override
    public long getCount() {
        return
                em.createQuery("select count( e ) from "+getEntityClass().getSimpleName()+" e ",Long.class)
                        .getSingleResult();
    }

    @Override
    public Collection<T> saveAll(Collection<T> entityCollection) {
        List<T> savedEntity=new ArrayList<>();
        entityCollection.forEach(e->savedEntity.add(saveWithoutTransaction(e)));
        return savedEntity;
    }



    public abstract Class<T> getEntityClass();
}
