/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Repository
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.EducationLevelSubject;
import java.io.Serializable;
import org.springframework.stereotype.Repository;

@Repository
public class EducationLevelSubjectDAO
extends GenericDAO<EducationLevelSubject> {
    public EducationLevelSubjectDAO() {
        super(EducationLevelSubject.class);
    }

    public EducationLevelSubject getEducationLevelSubjectById(Long id) {
        EducationLevelSubject instance = (EducationLevelSubject)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.EducationLevelSubject", (Serializable)id);
        return instance;
    }
}
