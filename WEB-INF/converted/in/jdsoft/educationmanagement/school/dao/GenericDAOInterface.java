/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.exception.ConstraintViolationException
 *  org.springframework.dao.DataIntegrityViolationException
 *  org.springframework.stereotype.Repository
 */
package in.jdsoft.educationmanagement.school.dao;

import java.util.List;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

@Repository
public interface GenericDAOInterface<T> {
    public void persist(T var1) throws ConstraintViolationException;

    public void delete(T var1) throws DataIntegrityViolationException;

    public List<T> getList();

    public void update(T var1) throws DataIntegrityViolationException;

    public void saveOrUpdate(T var1) throws DataIntegrityViolationException;

    public void merge(T var1);
}
