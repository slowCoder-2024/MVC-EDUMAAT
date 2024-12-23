/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Repository
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.AdmissionStatus;
import java.io.Serializable;
import org.springframework.stereotype.Repository;

@Repository
public class AdmissionStatusDAO
extends GenericDAO<AdmissionStatus> {
    public AdmissionStatusDAO() {
        super(AdmissionStatus.class);
    }

    public AdmissionStatus getAdmissionStatusById(Long id) {
        AdmissionStatus instance = (AdmissionStatus)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.AdmissionStatus", (Serializable)id);
        return instance;
    }
}
