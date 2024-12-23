/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Repository
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.VisitorIDCardGeneration;
import java.io.Serializable;
import org.springframework.stereotype.Repository;

@Repository
public class VisitorIDCardGenerationDAO
extends GenericDAO<VisitorIDCardGeneration> {
    public VisitorIDCardGenerationDAO() {
        super(VisitorIDCardGeneration.class);
    }

    public VisitorIDCardGeneration getVisitorIDCardGenerationById(Long id) {
        VisitorIDCardGeneration instance = (VisitorIDCardGeneration)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.VisitorIDCardGeneration", (Serializable)id);
        return instance;
    }
}
