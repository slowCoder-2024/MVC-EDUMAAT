/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Repository
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.TaxClass;
import java.io.Serializable;
import org.springframework.stereotype.Repository;

@Repository
public class TaxClassDAO
extends GenericDAO<TaxClass> {
    public TaxClassDAO() {
        super(TaxClass.class);
    }

    public TaxClass getTaxClassById(Long id) {
        TaxClass instance = (TaxClass)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.TaxClass", (Serializable)id);
        return instance;
    }
}
