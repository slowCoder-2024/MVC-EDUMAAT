/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Repository
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.AdmissionProcessStatus;
import java.io.Serializable;
import org.springframework.stereotype.Repository;

@Repository
public class AdmissionProcessStatusDAO
extends GenericDAO<AdmissionProcessStatus> {
    public AdmissionProcessStatusDAO() {
        super(AdmissionProcessStatus.class);
    }

    public AdmissionProcessStatus getAdmissionProcessStatusById(Long id) {
        AdmissionProcessStatus instance = (AdmissionProcessStatus)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.AdmissionProcessStatus", (Serializable)id);
        return instance;
    }
}
