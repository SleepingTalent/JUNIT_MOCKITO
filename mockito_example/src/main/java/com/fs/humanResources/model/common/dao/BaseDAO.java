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
        final Query query = this.entityManager.createQuery(queryString.toString());

        return (Long) query.getSingleResult();
    }

    public T create(final T t) {
        this.entityManager.persist(t);
        return t;
    }

    public void delete(final Object id) {
        this.entityManager.remove(this.entityManager.getReference(entityClass, id));
    }

    public T find(final Object id) {
        return (T) this.entityManager.find(entityClass, id);
    }

    public T update(final T t) {
        return this.entityManager.merge(t);
    }
}
