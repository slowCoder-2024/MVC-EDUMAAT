/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Repository
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.TermExam;
import java.io.Serializable;
import org.springframework.stereotype.Repository;

@Repository
public class TermExamDAO
extends GenericDAO<TermExam> {
    public TermExamDAO() {
        super(TermExam.class);
    }

    public TermExam getTermExamById(Long id) {
        TermExam instance = (TermExam)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.TermExam", (Serializable)id);
        return instance;
    }
}
