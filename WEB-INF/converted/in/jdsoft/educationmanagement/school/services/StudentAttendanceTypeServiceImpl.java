/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.StudentAttendanceTypeDAO;
import in.jdsoft.educationmanagement.school.model.StudentAttendanceType;
import in.jdsoft.educationmanagement.school.services.StudentAttendanceTypeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentAttendanceTypeServiceImpl
implements StudentAttendanceTypeService {
    @Autowired
    StudentAttendanceTypeDAO studentAttendanceTypeDAO;

    @Override
    public List<StudentAttendanceType> studentAttendanceTypeList() {
        try {
            List<StudentAttendanceType> studentAttendanceTypeList = this.studentAttendanceTypeDAO.getList();
            Integer studentAttendanceTypeListSize = studentAttendanceTypeList.size();
            if (studentAttendanceTypeListSize > 0) {
                log.info((Object)(studentAttendanceTypeListSize + " student attendance type records where reterived"));
            } else {
                log.info((Object)"No student attendance type list available");
            }
            return studentAttendanceTypeList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving student attendance type  list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public StudentAttendanceType studentAttendanceTypeById(Long studentAttendanceTypeId) {
        try {
            StudentAttendanceType studentAttendanceType = this.studentAttendanceTypeDAO.getStudentAttendanceTypeById(studentAttendanceTypeId);
            if (studentAttendanceType != null) {
                log.info((Object)("Student Attendance Type with id=" + studentAttendanceTypeId + " has been reterived"));
                return studentAttendanceType;
            }
            log.info((Object)("No Student Attendance Type  with  id=" + studentAttendanceTypeId + " is available"));
            return studentAttendanceType;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving staff type by id=" + studentAttendanceTypeId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }
}
