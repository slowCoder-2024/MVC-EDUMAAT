/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Controller
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RequestMethod
 *  org.springframework.web.bind.annotation.ResponseBody
 */
package in.jdsoft.educationmanagement.school.controller;

import in.jdsoft.educationmanagement.school.model.StudentAttendanceType;
import in.jdsoft.educationmanagement.school.services.StudentAttendanceTypeService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller(value="studentAttendanceTypeController")
@RequestMapping(value={"/studentattendance/type"})
public class StudentAttendanceTypeController {
    private Logger log = LogManager.getLogger((String)StudentAttendanceTypeController.class.getName());
    @Autowired
    StudentAttendanceTypeService studentAttendanceTypeService;

    @RequestMapping(method={RequestMethod.GET})
    @ResponseBody
    public List<StudentAttendanceType> getStudentAttendanceTypeList(HttpServletRequest request) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has retrived the student attendance type list"));
            return this.studentAttendanceTypeService.studentAttendanceTypeList();
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            throw e;
        }
    }
}
