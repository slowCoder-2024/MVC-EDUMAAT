/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.model.StudentLeaveRequisition;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface StudentLeaveRequisitionService {
    public static final Logger log = LogManager.getLogger((String)StudentLeaveRequisitionService.class.getName());

    public Long createStudentLeaveRequisition(StudentLeaveRequisition var1);

    public void deleteStudentLeaveRequisition(Long var1);

    public List<StudentLeaveRequisition> studentLeaveRequisitionList();

    public List<StudentLeaveRequisition> studentLeaveRequisitionListByStudentEmail(String var1);

    public StudentLeaveRequisition studentLeaveRequisitionById(Long var1);

    public StudentLeaveRequisition studentLeaveRequisitionByIdEager(Long var1);

    public void updateStudentLeaveRequisition(StudentLeaveRequisition var1);

    public void cancelStudentLeaveRequisition(StudentLeaveRequisition var1);
}
