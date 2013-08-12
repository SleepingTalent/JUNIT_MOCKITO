package com.fs.humanResources.model.common.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public abstract class BaseDAO<T> {

    @PersistenceContext
    protected EntityManager entityManager;

    private Class<T> entityClass;

    public BaseDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public long countAll() {
        final StringBuffer queryString = new StringBuffer(
                "SELECT count(o) from ");

        queryString.append(entityClass.getSimpleName()).append(" o ");

        final Query query = entityManager.createQuery(queryString.toString());

        return (Long) query.getSingleResult();
    }

    public T create(final T entity) {
        entityManager.persist(entity);
        return entity;
    }

    public void delete(final T entity) {
        entityManager.remove(entityManager.merge(entity));
    }

    public T findById(final Object id) {
        return (T) entityManager.find(entityClass, id);
    }

    public T update(final T entity) {
        return entityManager.merge(entity);
    }
}
