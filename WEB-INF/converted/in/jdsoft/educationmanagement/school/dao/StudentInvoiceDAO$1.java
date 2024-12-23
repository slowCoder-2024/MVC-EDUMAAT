/*
 * Decompiled with CFR 0.152.
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.model.StudentInvoice;
import java.util.Comparator;

class StudentInvoiceDAO.1
implements Comparator<StudentInvoice> {
    StudentInvoiceDAO.1() {
    }

    @Override
    public int compare(StudentInvoice o1, StudentInvoice o2) {
        return o1.getStudentInvoiceId().compareTo(o2.getStudentInvoiceId());
    }
}
