/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.SessionFactory
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.dao.DataIntegrityViolationException
 *  org.springframework.stereotype.Repository
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.dao.GenericDAOInterface;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

@Repository
public class GenericDAO<T>
implements GenericDAOInterface<T> {
    protected SessionFactory sessionFactory;
    private Class<T> entity;

    public GenericDAO(Class<T> entity) {
        this.entity = entity;
    }

    public GenericDAO() {
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }

    @Override
    public void persist(T transientInstance) {
        this.sessionFactory.getCurrentSession().persist(transientInstance);
    }

    public T save(T transientInstance) {
        this.sessionFactory.getCurrentSession().save(transientInstance);
        return transientInstance;
    }

    @Override
    public void delete(T persistentInstance) throws DataIntegrityViolationException {
        this.sessionFactory.getCurrentSession().delete(persistentInstance);
    }

    @Override
    public List<T> getList() {
        List results = this.sessionFactory.getCurrentSession().createCriteria(this.entity).list();
        return results;
    }

    @Override
    public void update(T transientInstance) throws DataIntegrityViolationException {
        this.sessionFactory.getCurrentSession().update(transientInstance);
    }

    @Override
    public void saveOrUpdate(T instance) throws DataIntegrityViolationException {
        this.sessionFactory.getCurrentSession().saveOrUpdate(instance);
    }

    @Override
    public void merge(T entity) {
        this.sessionFactory.getCurrentSession().merge(entity);
    }
}
