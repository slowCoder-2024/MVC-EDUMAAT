/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Repository
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.InstitutionConfigDetails;
import java.io.Serializable;
import org.springframework.stereotype.Repository;

@Repository
public class InstitutionConfigDetailsDAO
extends GenericDAO<InstitutionConfigDetails> {
    public InstitutionConfigDetailsDAO() {
        super(InstitutionConfigDetails.class);
    }

    public InstitutionConfigDetails getInstitutionConfigDetailsById(Long id) {
        InstitutionConfigDetails instance = (InstitutionConfigDetails)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.InstitutionConfigDetails", (Serializable)id);
        return instance;
    }
}
