/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Repository
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.AdmissionEducationLevelSubjects;
import java.io.Serializable;
import org.springframework.stereotype.Repository;

@Repository
public class AdmissionEducationLevelSubjectsDAO
extends GenericDAO<AdmissionEducationLevelSubjects> {
    public AdmissionEducationLevelSubjectsDAO() {
        super(AdmissionEducationLevelSubjects.class);
    }

    public AdmissionEducationLevelSubjects getAdmissionEducationLevelSubjectById(Long id) {
        AdmissionEducationLevelSubjects instance = (AdmissionEducationLevelSubjects)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.AdmissionEducationLevelSubjects", (Serializable)id);
        return instance;
    }
}
