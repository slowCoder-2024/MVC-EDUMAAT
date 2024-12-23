/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Repository
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.StudentReceiptFine;
import java.io.Serializable;
import org.springframework.stereotype.Repository;

@Repository
public class StudentReceiptFineDAO
extends GenericDAO<StudentReceiptFine> {
    public StudentReceiptFineDAO() {
        super(StudentReceiptFine.class);
    }

    public StudentReceiptFine getStudentReceiptFineById(Long id) {
        StudentReceiptFine instance = (StudentReceiptFine)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.StudentReceiptFine", (Serializable)id);
        return instance;
    }
}
