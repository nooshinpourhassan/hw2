package base.service;

import base.entity.BaseEntity;
import base.repository.BaseRepository;
import lombok.AllArgsConstructor;

import javax.persistence.EntityManager;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
public abstract class BaseServiceImpl<T extends BaseEntity<ID>, ID extends Number, R extends BaseRepository<T, ID>>
        implements BaseService<T, ID> {

    protected final R repository;
    private final Validator validator;
    protected EntityManager em;

    @Override
    public T saveOrUpdate(T entity) {
        beginTransaction();
        try {
            T entity1 = repository.saveOrUpdate(entity);
            commitTransaction();
            return entity1;
        } catch (IllegalArgumentException e) {
            rollBack();
            System.out.println(e.getMessage());
        }
        return null;
    }


    @Override
    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public void deleteById(ID id) {
        beginTransaction();
        try {
            repository.deleteById(id);
            commitTransaction();
        }catch (IllegalArgumentException e){
            rollBack();
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Collection<T> findAll() {
        return repository.findAll();
    }

    @Override
    public long getCount() {
        return repository.getCount();
    }

    @Override
    public void saveAll(Collection<T> entityCollection) {
        beginTransaction();
        try {
            Collection<T> collection = repository.saveAll(entityCollection);
            commitTransaction();
        }catch (IllegalArgumentException e){
            rollBack();
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void beginTransaction() {
        if (!em.getTransaction().isActive())
            em.getTransaction().begin();
    }

    @Override
    public void commitTransaction() {
        if (em.getTransaction().isActive()) {
            em.getTransaction().commit();
        }
    }

    @Override
    public void rollBack() {
        if (em.getTransaction().isActive())
            em.getTransaction().rollback();
    }

    @Override
    public boolean isValid(T entity) {
        Set<ConstraintViolation<T>> violations = validator.validate(entity);
        if (!violations.isEmpty()) {
            for (ConstraintViolation<T> p : violations)
                System.out.println(p.getMessage());
            return false;
        }
        return true;
    }

    public abstract Class<T> getEntityClass();

}
