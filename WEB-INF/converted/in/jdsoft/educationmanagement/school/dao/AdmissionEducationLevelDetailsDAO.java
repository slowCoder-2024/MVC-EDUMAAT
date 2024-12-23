/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Repository
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.AdmissionEducationLevelDetails;
import java.io.Serializable;
import org.springframework.stereotype.Repository;

@Repository
public class AdmissionEducationLevelDetailsDAO
extends GenericDAO<AdmissionEducationLevelDetails> {
    public AdmissionEducationLevelDetailsDAO() {
        super(AdmissionEducationLevelDetails.class);
    }

    public AdmissionEducationLevelDetails getAdmissionAcademicsDetailsById(Long id) {
        AdmissionEducationLevelDetails instance = (AdmissionEducationLevelDetails)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.AdmissionEducationLevelDetails", (Serializable)id);
        return instance;
    }
}
