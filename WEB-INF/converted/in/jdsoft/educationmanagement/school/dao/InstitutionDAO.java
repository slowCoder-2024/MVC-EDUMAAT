/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Repository
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.Institution;
import java.io.Serializable;
import org.springframework.stereotype.Repository;

@Repository
public class InstitutionDAO
extends GenericDAO<Institution> {
    public InstitutionDAO() {
        super(Institution.class);
    }

    public Institution getInstitutionById(Long id) {
        Institution instance = (Institution)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.Institution", (Serializable)id);
        return instance;
    }
}
