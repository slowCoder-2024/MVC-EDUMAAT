/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Repository
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.AssesmentType;
import java.io.Serializable;
import org.springframework.stereotype.Repository;

@Repository
public class AssesmentTypeDAO
extends GenericDAO<AssesmentType> {
    public AssesmentTypeDAO() {
        super(AssesmentType.class);
    }

    public AssesmentType getAssesmentTypeById(Long id) {
        AssesmentType instance = (AssesmentType)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.AssesmentType", (Serializable)id);
        return instance;
    }
}
