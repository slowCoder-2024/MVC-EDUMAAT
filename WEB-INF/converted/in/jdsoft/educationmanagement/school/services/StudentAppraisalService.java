/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.model.StudentAppraisal;
import java.util.List;
import java.util.Set;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface StudentAppraisalService {
    public static final Logger log = LogManager.getLogger((String)StudentAppraisalService.class.getName());

    public List<StudentAppraisal> studentAppraisalList();

    public StudentAppraisal studentAppraisalById(Long var1);

    public void createStudentAppraisal(StudentAppraisal var1) throws Exception;

    public void updateStudentAppraisal(StudentAppraisal var1);

    public void deleteStudentAppraisal(Long var1);

    public Set<StudentAppraisal> studentAppraisalListByStudentAdmissionNumber(String var1);

    public List<StudentAppraisal> studentAppraisalListByClassAndSection(Long var1, Long var2);

    public List<StudentAppraisal> studentAppraisalListByAcademicYearAndEmail(Long var1, String var2);
}
