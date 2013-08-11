package com.fs.humanResources.model.common.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

public abstract class BaseDAO<T> {

    @PersistenceContext
    protected EntityManager em;

    private Class<T> type;

    public BaseDAO() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }

    public long countAll(final Map<String, Object> params) {

        final StringBuffer queryString = new StringBuffer(
                "SELECT count(o) from ");

        queryString.append(type.getSimpleName()).append(" o ");
        final Query query = this.em.createQuery(queryString.toString());

        return (Long) query.getSingleResult();
    }

    public T create(final T t) {
        this.em.persist(t);
        return t;
    }

    public void delete(final Object id) {
        this.em.remove(this.em.getReference(type, id));
    }

    public T find(final Object id) {
        return (T) this.em.find(type, id);
    }

    public T update(final T t) {
        return this.em.merge(t);
    }
}
