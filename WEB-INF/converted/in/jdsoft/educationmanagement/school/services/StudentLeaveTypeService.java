/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.model.StudentLeaveType;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface StudentLeaveTypeService {
    public static final Logger log = LogManager.getLogger((String)StudentLeaveTypeService.class.getName());

    public Long createStudentLeaveType(StudentLeaveType var1);

    public void deleteStudentLeaveType(Long var1);

    public List<StudentLeaveType> studentLeaveTypeList();

    public StudentLeaveType studentLeaveTypeById(Long var1);

    public StudentLeaveType studentLeaveTypeByIdEager(Long var1);

    public void updateStudentLeaveType(StudentLeaveType var1);
}
