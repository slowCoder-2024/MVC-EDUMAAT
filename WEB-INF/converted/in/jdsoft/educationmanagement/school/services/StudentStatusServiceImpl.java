/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.StudentStatusDAO;
import in.jdsoft.educationmanagement.school.model.StudentStatus;
import in.jdsoft.educationmanagement.school.services.StudentStatusService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="studentStatusService")
public class StudentStatusServiceImpl
implements StudentStatusService {
    @Autowired
    StudentStatusDAO studentStatusDAO;

    @Override
    public List<StudentStatus> studentStatusList() {
        try {
            List<StudentStatus> studentStatusList = this.studentStatusDAO.getList();
            Integer studentStatusSize = studentStatusList.size();
            if (studentStatusSize > 0) {
                log.info((Object)(studentStatusSize + " StudentStatus records where reterived"));
            } else {
                log.info((Object)"No StudentStatus(s) available");
            }
            return studentStatusList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving StudentStatus list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public StudentStatus studentStatusById(Long studentStatusId) {
        try {
            StudentStatus studentStatus = this.studentStatusDAO.getStudentStatusById(studentStatusId);
            if (studentStatus != null) {
                log.info((Object)("StudentStatus with id=" + studentStatusId + " has been reterived"));
                return studentStatus;
            }
            log.info((Object)("No StudentStatus with  id=" + studentStatusId + " is available"));
            return studentStatus;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving StudentStatus by id=" + studentStatusId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }
}
