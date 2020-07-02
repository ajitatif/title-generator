package tech.turkisi.titlegen.data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class BaseJpaRepository<T, ID> {

    @PersistenceContext
    protected EntityManager entityManager;

    private Class<T> managedEntityClass;

    protected BaseJpaRepository(Class<T> managedEntityClass) {
        this.managedEntityClass = managedEntityClass;
    }

    public T save(T entity) {
        entityManager.persist(entity);
        return entity;
    }

    public void update(T entity) {
        entityManager.merge(entity);
    }

    public void delete(T entity) {
        entityManager.remove(entity);
    }

    public T findById(ID id) {
        return entityManager.find(managedEntityClass, id);
    }

    public List<T> findAll() {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<T> query = criteriaBuilder.createQuery(managedEntityClass);
        final Root<T> root = query.from(managedEntityClass);
        query.select(root);
        return entityManager.createQuery(query).getResultList();
    }
}
