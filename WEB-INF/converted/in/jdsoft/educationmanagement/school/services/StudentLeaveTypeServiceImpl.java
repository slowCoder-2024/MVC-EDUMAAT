/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.Hibernate
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.InstitutionDAO;
import in.jdsoft.educationmanagement.school.dao.StudentLeaveTypeDAO;
import in.jdsoft.educationmanagement.school.model.StudentLeaveType;
import in.jdsoft.educationmanagement.school.services.StudentLeaveTypeService;
import java.util.List;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="studentLeaveTypeService")
public class StudentLeaveTypeServiceImpl
implements StudentLeaveTypeService {
    @Autowired
    StudentLeaveTypeDAO studentLeaveTypeDAO;
    @Autowired
    InstitutionDAO institutionDAO;

    @Override
    public Long createStudentLeaveType(StudentLeaveType studentLeaveType) {
        try {
            StudentLeaveType persistedStudentLeaveType = this.studentLeaveTypeDAO.save(studentLeaveType);
            Long studentLeaveTypeId = persistedStudentLeaveType.getStudentLeaveTypeId();
            log.info((Object)("Student LeaveType created with the id=" + studentLeaveTypeId));
            return studentLeaveTypeId;
        }
        catch (Exception e) {
            log.error((Object)"Exception in Creating Student LeaveType", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteStudentLeaveType(Long studentLeaveTypeId) {
        try {
            StudentLeaveType studentLeaveType = this.studentLeaveTypeDAO.getStudentLeaveTypeById(studentLeaveTypeId);
            if (studentLeaveType != null) {
                this.studentLeaveTypeDAO.delete(studentLeaveType);
                log.info((Object)("Student LeaveType with id=" + studentLeaveTypeId + " has been deleted successfully"));
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in deleting Student LeaveType", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<StudentLeaveType> studentLeaveTypeList() {
        try {
            List<StudentLeaveType> studentLeaveTypeList = this.studentLeaveTypeDAO.getList();
            Integer studentLeaveTypeListSize = studentLeaveTypeList.size();
            if (studentLeaveTypeListSize > 0) {
                log.info((Object)(studentLeaveTypeListSize + " student LeaveType records where reterived"));
            } else {
                log.info((Object)"No student LeaveType list available");
            }
            return studentLeaveTypeList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving student LeaveType list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public StudentLeaveType studentLeaveTypeById(Long studentLeaveTypeId) {
        try {
            StudentLeaveType studentLeaveType = this.studentLeaveTypeDAO.getStudentLeaveTypeById(studentLeaveTypeId);
            if (studentLeaveType != null) {
                log.info((Object)("Student LeaveType with id=" + studentLeaveTypeId + " has been reterived"));
                return studentLeaveType;
            }
            log.info((Object)("No Student LeaveType with  id=" + studentLeaveTypeId + " is available"));
            return studentLeaveType;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving student LeaveType by id=" + studentLeaveTypeId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateStudentLeaveType(StudentLeaveType studentLeaveType) {
        try {
            this.studentLeaveTypeDAO.saveOrUpdate(studentLeaveType);
            Long studentLeaveTypeId = studentLeaveType.getStudentLeaveTypeId();
            if (studentLeaveTypeId != null) {
                log.info((Object)("Student LeaveType with id=" + studentLeaveTypeId + " has been updated"));
            } else {
                log.info((Object)"New Student LeaveType has been added, because no student LeaveType found for update");
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in updating Student LeaveType", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public StudentLeaveType studentLeaveTypeByIdEager(Long studentLeaveTypeId) {
        try {
            StudentLeaveType studentLeaveType = this.studentLeaveTypeDAO.getStudentLeaveTypeById(studentLeaveTypeId);
            if (studentLeaveType != null) {
                log.info((Object)("Student LeaveType with id=" + studentLeaveTypeId + " has been reterived"));
                Hibernate.initialize(studentLeaveType.getStudentLeaveRequisitions());
                return studentLeaveType;
            }
            log.info((Object)("No Student LeaveType with  id=" + studentLeaveTypeId + " is available"));
            return studentLeaveType;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving student LeaveType by id=" + studentLeaveTypeId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }
}
