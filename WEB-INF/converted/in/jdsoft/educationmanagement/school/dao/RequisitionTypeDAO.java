/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Repository
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.RequisitionType;
import java.io.Serializable;
import org.springframework.stereotype.Repository;

@Repository
public class RequisitionTypeDAO
extends GenericDAO<RequisitionType> {
    public RequisitionTypeDAO() {
        super(RequisitionType.class);
    }

    public RequisitionType getRequisitionTypeById(Long id) {
        RequisitionType instance = (RequisitionType)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.RequisitionType", (Serializable)id);
        return instance;
    }
}
