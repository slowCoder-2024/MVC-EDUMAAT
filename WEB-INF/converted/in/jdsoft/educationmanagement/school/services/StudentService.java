/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 *  org.springframework.web.multipart.MultipartFile
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.exceptions.StudentException;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.Admission;
import in.jdsoft.educationmanagement.school.model.Class;
import in.jdsoft.educationmanagement.school.model.Document;
import in.jdsoft.educationmanagement.school.model.Section;
import in.jdsoft.educationmanagement.school.model.Student;
import in.jdsoft.educationmanagement.school.model.StudentLeaveRequisition;
import in.jdsoft.educationmanagement.school.model.StudentMovementRequisition;
import in.jdsoft.educationmanagement.school.model.User;
import in.jdsoft.educationmanagement.school.reports.model.SevenFieldReports;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Transactional(rollbackFor={StudentException.class})
public interface StudentService {
    public static final Logger log = LogManager.getLogger((String)StudentService.class.getName());

    public void createStudent(Student var1, User var2, User var3) throws StudentException;

    public void deleteStudent(Long var1);

    public void deleteListOfStudents(Long[] var1);

    public List<Student> studentList();

    public List<Student> studentList(Long var1) throws StudentException;

    public List<Student> studentListEager(Long var1) throws StudentException;

    public List<Student> studentListEager() throws StudentException;

    public Student studentById(Long var1);

    public Student studentByIdEager(Long var1);

    public void updateStudent(Student var1, User var2, User var3);

    public void updateStudentProfile(Student var1, User var2);

    public List<Student> studentListByClassAndSection(Long var1, Long var2) throws StudentException;

    public List<Student> studentListByClassAndSectionEager(Long var1, Long var2) throws StudentException;

    public Student studentListByClassAndSectionAndAdmissionNoEager(Long var1, Long var2, String var3) throws StudentException;

    public Student studentByEmailEager(String var1);

    public Student studentByParentEmailEager(String var1);

    public List<Student> activeStudentListByClassSectionModuleId(Long var1);

    public List<Student> activeStudentListByClassAndSectionId(Long var1, Long var2);

    public Student activeStudentByAdmissionNoWithoutInvoiceGenerated(String var1) throws StudentException;

    public List<Student> activeStudentsInAllClassWithoutInvoiceGenerated(Long var1);

    public List<Student> activeStudentsFromAllClassBySpecialCategoryWithoutInvoiceGenerated(Long var1, Long var2);

    public List<Student> activeStudentsInClassAndSectionWithoutInvoiceGenerated(Long var1, Long var2);

    public List<Student> activeStudentsInClassSectionAndSpecialCategoryWithoutInvoiceGenerated(Long var1, Long var2, Long var3);

    public Student studentByAdmissionNo(String var1) throws StudentException;

    public List<Student> studentsByClassSectionAndSpecialCategory(Long var1, Long var2, Long var3);

    public List<Student> studentsByStatus(Long var1, Long var2);

    public List<Student> studentsBySpecialCategory(Long var1, Long var2);

    public Student studentByAdmissionNoEager(String var1) throws StudentException;

    public List<Student> studentsByClassSectionAndSpecialCategoryEager(Long var1, Long var2, Long var3);

    public List<Student> studentsByStatusEager(Long var1, Long var2);

    public List<Student> studentsBySpecialCategoryEager(Long var1, Long var2);

    public Integer studentBulkUpdate(MultipartFile var1, Long var2, String var3) throws StudentException;

    public Integer studentBulkUpload(MultipartFile var1, Long var2, String var3) throws StudentException;

    public List<Student> studentListByClassAndSectionAndAttendanceMonthEager(Class var1, Section var2, Date var3) throws StudentException;

    public List<Student> studenListByClassAndSectionAndAttendanceFromDateAndToDateEager(Class var1, Section var2, Date var3, Date var4) throws StudentException, Exception;

    public List<Student> activeStudentListByClassSectionModuleIdAndAttendanceFromDateAndToDateEager(Long var1, Date var2, Date var3) throws StudentException, Exception;

    public List<Student> activeStudentListByClassSectionModuleAndAttendanceMonthEager(Long var1, Date var2) throws StudentException;

    public void createStudentWithAdmission(Student var1, User var2, User var3, Admission var4) throws StudentException;

    public List<SevenFieldReports> studentListByAcademicYearAndClassAndSection(Class var1, Section var2, AcademicYear var3) throws StudentException;

    public List<Student> activeStudentListByClassAndSectionAndInstitution(Long var1, Long var2, Long var3) throws StudentException;

    public List<Student> studentListByClassAndSectionAndStudentStatusEager(Long var1, Long var2, Long var3) throws StudentException;

    public Student studentListByClassAndSectionAndAdmissionNoAndStudentStatusEager(Long var1, Long var2, String var3, Long var4) throws StudentException;

    public List<Student> studentsByClassSectionAndSpecialCategoryAndStudentStatus(Long var1, Long var2, Long var3, Long var4);

    public void promoteListOfStudents(Long[] var1, Class var2, Section var3);

    public Set<StudentLeaveRequisition> studentLeaveRequests(String var1) throws StudentException;

    public Set<StudentLeaveRequisition> studentLeaveRequestApprovedAndRejectedLists(String var1) throws StudentException;

    public Set<StudentLeaveRequisition> studentLeaveApprovals(String var1) throws StudentException;

    public Set<StudentMovementRequisition> studentMovementRequests(String var1) throws StudentException;

    public Set<StudentMovementRequisition> studentMovementRequestApprovedAndRejectedLists(String var1) throws StudentException;

    public Set<StudentMovementRequisition> studentMovementApprovals(String var1) throws StudentException;

    public List<Student> activeStudentsInAllClassWithoutInvoiceGeneratedFromAllInstituions();

    public List<Student> activeStudentsFromAllClassBySpecialCategoryWithoutInvoiceGenerated(Long var1);

    public List<Student> studentsBySpecialCategoryEager(Long var1);

    public void createStudentAndDocuments(Student var1, User var2, User var3, Set<Document> var4) throws StudentException;

    public void createStudentWithAdmissionAndDocuments(Student var1, User var2, User var3, Admission var4, Set<Document> var5) throws StudentException;

    public void updateStudentProfileAndDocuments(Student var1, User var2, Set<Document> var3) throws Exception;

    public void updateStudent(Student var1, User var2, User var3, Set<Document> var4) throws Exception;
}
