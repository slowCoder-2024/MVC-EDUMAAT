/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.poi.hssf.usermodel.HSSFRow
 *  org.apache.poi.hssf.usermodel.HSSFSheet
 *  org.apache.poi.hssf.usermodel.HSSFWorkbook
 *  org.apache.poi.ss.usermodel.Cell
 *  org.apache.poi.ss.usermodel.DataFormatter
 *  org.hibernate.Hibernate
 *  org.hibernate.exception.ConstraintViolationException
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 *  org.springframework.web.multipart.MultipartFile
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.components.HashGenerator;
import in.jdsoft.educationmanagement.school.dao.AcademicYearDAO;
import in.jdsoft.educationmanagement.school.dao.AdmissionDAO;
import in.jdsoft.educationmanagement.school.dao.BloodGroupDAO;
import in.jdsoft.educationmanagement.school.dao.CategoryDAO;
import in.jdsoft.educationmanagement.school.dao.ClassDAO;
import in.jdsoft.educationmanagement.school.dao.ClassSectionModuleDAO;
import in.jdsoft.educationmanagement.school.dao.DocumentDAO;
import in.jdsoft.educationmanagement.school.dao.GeographicalLocationDAO;
import in.jdsoft.educationmanagement.school.dao.HousesDAO;
import in.jdsoft.educationmanagement.school.dao.InstitutionDAO;
import in.jdsoft.educationmanagement.school.dao.SectionDAO;
import in.jdsoft.educationmanagement.school.dao.SpecialCategoryDAO;
import in.jdsoft.educationmanagement.school.dao.StudentDAO;
import in.jdsoft.educationmanagement.school.dao.StudentStatusDAO;
import in.jdsoft.educationmanagement.school.dao.UserDAO;
import in.jdsoft.educationmanagement.school.dao.UserRoleDAO;
import in.jdsoft.educationmanagement.school.exceptions.StudentException;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.Admission;
import in.jdsoft.educationmanagement.school.model.BloodGroup;
import in.jdsoft.educationmanagement.school.model.Category;
import in.jdsoft.educationmanagement.school.model.Class;
import in.jdsoft.educationmanagement.school.model.ClassSection;
import in.jdsoft.educationmanagement.school.model.ClassSectionModule;
import in.jdsoft.educationmanagement.school.model.Document;
import in.jdsoft.educationmanagement.school.model.GeographicalLocation;
import in.jdsoft.educationmanagement.school.model.Houses;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.Section;
import in.jdsoft.educationmanagement.school.model.SpecialCategory;
import in.jdsoft.educationmanagement.school.model.StaffModuleAttendance;
import in.jdsoft.educationmanagement.school.model.Student;
import in.jdsoft.educationmanagement.school.model.StudentAttendance;
import in.jdsoft.educationmanagement.school.model.StudentInvoice;
import in.jdsoft.educationmanagement.school.model.StudentLeaveRequisition;
import in.jdsoft.educationmanagement.school.model.StudentMovementRequisition;
import in.jdsoft.educationmanagement.school.model.StudentStatus;
import in.jdsoft.educationmanagement.school.model.User;
import in.jdsoft.educationmanagement.school.model.UserRole;
import in.jdsoft.educationmanagement.school.reports.model.SevenFieldReports;
import in.jdsoft.educationmanagement.school.services.StudentService;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.hibernate.Hibernate;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service(value="studentService")
public class StudentServiceImpl
implements StudentService {
    @Autowired
    private StudentDAO studentDAO;
    @Autowired
    private ClassDAO classDAO;
    @Autowired
    private SectionDAO sectionDAO;
    @Autowired
    private InstitutionDAO institutionDAO;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private ClassSectionModuleDAO classSectionModuleDAO;
    @Autowired
    private StudentStatusDAO studentStatusDAO;
    @Autowired
    private SpecialCategoryDAO specialCategoryDAO;
    @Autowired
    private CategoryDAO categoryDAO;
    @Autowired
    private BloodGroupDAO bloodGroupDAO;
    @Autowired
    private GeographicalLocationDAO geographicalLocationDAO;
    @Autowired
    private AcademicYearDAO academicYearDAO;
    @Autowired
    private HashGenerator hashGenerator;
    @Autowired
    private UserRoleDAO userRoleDAO;
    @Autowired
    private AdmissionDAO admissionDAO;
    @Autowired
    private HousesDAO houseDAO;
    @Autowired
    private DocumentDAO documentDAO;

    @Override
    public void createStudent(Student student, User user, User parentUser) throws StudentException {
        try {
            User persisteduser = this.userDAO.save(user);
            User persistedParentUser = this.userDAO.save(parentUser);
            student.setUser(persisteduser);
            student.setParentUser(persistedParentUser);
            Student persistedstudent = this.studentDAO.save(student);
            Long studentId = persistedstudent.getStudentId();
            log.info((Object)("Student is created with the id=" + studentId));
        }
        catch (Exception e) {
            e.printStackTrace();
            if (e.getClass().equals(ConstraintViolationException.class)) {
                ConstraintViolationException cve = (ConstraintViolationException)e;
                if (cve.getConstraintName().equals("email")) {
                    throw new StudentException(new Message("failure", "Student Cannot Be Created!! Duplicate Email Id "));
                }
            }
            log.error((Object)"Exception in Creating student", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void createStudentAndDocuments(Student student, User user, User parentUser, Set<Document> documents) throws StudentException {
        try {
            User persisteduser = this.userDAO.save(user);
            User persistedParentUser = this.userDAO.save(parentUser);
            student.setUser(persisteduser);
            student.setParentUser(persistedParentUser);
            Student persistedstudent = this.studentDAO.save(student);
            for (Document document : documents) {
                if (this.documentDAO.getDocumentByDocumentTypeAndStudent(document.getDocumentType(), persistedstudent) == null) {
                    document.setStudent(persistedstudent);
                    this.documentDAO.save(document);
                    continue;
                }
                throw new StudentException(new Message("failure", "Cannot Upload Duplicate Document Type"));
            }
            Long studentId = persistedstudent.getStudentId();
            log.info((Object)("Student is created with the id=" + studentId));
        }
        catch (Exception e) {
            e.printStackTrace();
            if (e.getClass().equals(ConstraintViolationException.class)) {
                ConstraintViolationException cve = (ConstraintViolationException)e;
                if (cve.getConstraintName().equals("email")) {
                    throw new StudentException(new Message("failure", "Student Cannot Be Created!! Duplicate Email Id "));
                }
            }
            log.error((Object)"Exception in Creating student", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void createStudentWithAdmissionAndDocuments(Student student, User user, User parentUser, Admission admission, Set<Document> documents) throws StudentException {
        try {
            User persistedParentUser = this.userDAO.save(parentUser);
            student.setUser(user);
            student.setParentUser(persistedParentUser);
            Student persistedstudent = this.studentDAO.save(student);
            user.setCommunicationFeedBackAndOthers(null);
            user.setCommunicationFeedBackAndOthersArchives(null);
            user.setCommunicationFeedBackAndOthersHistory(null);
            user.setCommunicationNotificationArchives(null);
            user.setCommunicationNotifications(null);
            user.setPortalMessages(null);
            user.setPortalNotifications(null);
            user.setPortalReplyMessages(null);
            user.setPortalTasks(null);
            this.userDAO.update(user);
            admission.setUser(null);
            this.admissionDAO.update(admission);
            for (Document document : documents) {
                if (this.documentDAO.getDocumentByDocumentTypeAndStudent(document.getDocumentType(), persistedstudent) == null) {
                    document.setStudent(persistedstudent);
                    this.documentDAO.save(document);
                    continue;
                }
                throw new StudentException(new Message("failure", "Cannot Upload Duplicate Document Type"));
            }
            Long studentId = persistedstudent.getStudentId();
            log.info((Object)("Student is created with the id=" + studentId));
        }
        catch (Exception e) {
            if (e.getClass().equals(ConstraintViolationException.class)) {
                ConstraintViolationException cve = (ConstraintViolationException)e;
                if (cve.getConstraintName().equals("email")) {
                    throw new StudentException(new Message("failure", "Student Cannot Be Created!! Duplicate Email Id "));
                }
            }
            log.error((Object)"Exception in Creating student", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteStudent(Long studentId) {
        try {
            Student student = this.studentDAO.getStudentById(studentId);
            if (student != null) {
                this.studentDAO.delete(student);
                log.info((Object)("Student with id=" + studentId + " has been deleted successfully"));
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in deleting Student", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Student> studentList() {
        try {
            List<Student> studentList = this.studentDAO.getList();
            Integer studentListSize = studentList.size();
            if (studentListSize > 0) {
                log.info((Object)(studentListSize + "Student records where reterived"));
            } else {
                log.info((Object)"No Student(s) available");
            }
            return studentList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving student list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Student> studentList(Long institutionId) throws StudentException {
        try {
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            if (institution != null) {
                List<Student> students = this.studentDAO.getStudentsByInstitution(institution);
                Integer studentRecordSize = students.size();
                if (studentRecordSize > 0) {
                    log.info((Object)(studentRecordSize + " Student records of institution " + institution.getInstitutionAliasName() + " where reterived"));
                } else {
                    log.info((Object)("No Student Records found for institution " + institution.getInstitutionAliasName()));
                }
                return students;
            }
            throw new NullPointerException("Invalid Institution Id");
        }
        catch (Exception e) {
            if (e.getClass().equals(NullPointerException.class)) {
                log.error((Object)"NullPointerException", e.getCause());
                throw new StudentException(new Message("nullpointer", e.getMessage()));
            }
            log.error((Object)"Exception in reteriving students of Institution", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Student> studentListEager(Long institutionId) throws StudentException {
        try {
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            if (institution != null) {
                List<Student> students = this.studentDAO.getStudentsByInstitution(institution);
                Integer studentRecordSize = students.size();
                if (studentRecordSize > 0) {
                    for (Student student : students) {
                        Hibernate.initialize((Object)student.getBloodGroup());
                        Hibernate.initialize((Object)student.getJoinedAcademicYear());
                        Hibernate.initialize((Object)student.getJoinedClass());
                        Hibernate.initialize((Object)student.getSection());
                        Hibernate.initialize(student.getSpecialCategories());
                        Hibernate.initialize((Object)student.getUser().getProfilePicturePath());
                        Hibernate.initialize(student.getUser().getUserRoles());
                        Hibernate.initialize((Object)student.getInstitution());
                        Hibernate.initialize((Object)student.getCategory());
                        Hibernate.initialize((Object)student.getStudentClass());
                        Hibernate.initialize((Object)student.getStudentStatus());
                        Hibernate.initialize((Object)student.getParentUser());
                        Hibernate.initialize(student.getParentUser().getUserRoles());
                        Hibernate.initialize((Object)student.getHouses());
                        Hibernate.initialize(student.getStudentLeaveRequistions());
                        Hibernate.initialize(student.getStudentMovementRequisitions());
                    }
                    log.info((Object)(studentRecordSize + " Student records of institution " + institution.getInstitutionAliasName() + " with childs  where reterived"));
                } else {
                    log.info((Object)("No Student Records found for institution " + institution.getInstitutionAliasName()));
                }
                return students;
            }
            throw new NullPointerException("Invalid Institution Id");
        }
        catch (Exception e) {
            if (e.getClass().equals(NullPointerException.class)) {
                log.error((Object)"NullPointerException", e.getCause());
                throw new StudentException(new Message("nullpointer", e.getMessage()));
            }
            log.error((Object)"Exception in reteriving students with childs of Institution", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Student studentById(Long studentId) {
        try {
            Student student = this.studentDAO.getStudentById(studentId);
            if (student != null) {
                log.info((Object)("Student with id=" + studentId + " has been reterived"));
                return student;
            }
            log.info((Object)("No Student with  id=" + studentId + " is available"));
            return student;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving student by id=" + studentId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateStudent(Student student, User user, User parentUser) {
        try {
            this.userDAO.saveOrUpdate(user);
            this.userDAO.saveOrUpdate(parentUser);
            this.studentDAO.saveOrUpdate(student);
            Long studentId = student.getStudentId();
            if (studentId != null) {
                log.info((Object)("Student with id=" + studentId + " has been updated"));
            } else {
                log.info((Object)"New Student has been added, because no Student found for update");
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in updating student", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Student studentByIdEager(Long studentId) {
        try {
            Student student = this.studentDAO.getStudentById(studentId);
            if (student != null) {
                Hibernate.initialize((Object)student.getBloodGroup());
                Hibernate.initialize((Object)student.getCategory());
                Hibernate.initialize((Object)student.getInstitution());
                Hibernate.initialize((Object)student.getJoinedAcademicYear());
                Hibernate.initialize((Object)student.getJoinedClass());
                Hibernate.initialize((Object)student.getSection());
                Hibernate.initialize(student.getSpecialCategories());
                Hibernate.initialize((Object)student.getStudentClass());
                Hibernate.initialize((Object)student.getStudentStatus());
                Hibernate.initialize((Object)student.getUser());
                Hibernate.initialize(student.getUser().getUserRoles());
                Hibernate.initialize((Object)student.getParentUser());
                Hibernate.initialize(student.getParentUser().getUserRoles());
                Hibernate.initialize((Object)student.getHouses());
                Hibernate.initialize(student.getStudentLeaveRequistions());
                Hibernate.initialize(student.getStudentMovementRequisitions());
                Hibernate.initialize(student.getDocuments());
                for (Document document : student.getDocuments()) {
                    Hibernate.initialize((Object)document.getDocumentType());
                }
                log.info((Object)("Student with id=" + studentId + " has been reterived"));
                return student;
            }
            log.info((Object)("No Student with  id=" + studentId + " is available"));
            return student;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving student by id=" + studentId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Student> studentListByClassAndSection(Long classId, Long sectionId) throws StudentException {
        try {
            Class classs = this.classDAO.getClassById(classId);
            Section section = this.sectionDAO.getSectionById(sectionId);
            List<Student> students = this.studentDAO.getStudentsByClassAndSection(classs, section);
            Integer studentRecordSize = students.size();
            if (studentRecordSize > 0) {
                for (Student student : students) {
                    Hibernate.initialize((Object)student.getBloodGroup());
                    Hibernate.initialize((Object)student.getJoinedAcademicYear());
                    Hibernate.initialize((Object)student.getJoinedClass());
                    Hibernate.initialize((Object)student.getSection());
                    Hibernate.initialize(student.getSpecialCategories());
                    Hibernate.initialize((Object)student.getUser().getProfilePicturePath());
                    Hibernate.initialize(student.getUser().getUserRoles());
                    Hibernate.initialize((Object)student.getInstitution());
                    Hibernate.initialize((Object)student.getCategory());
                    Hibernate.initialize((Object)student.getStudentClass());
                    Hibernate.initialize((Object)student.getStudentStatus());
                    Hibernate.initialize((Object)student.getParentUser());
                    Hibernate.initialize(student.getParentUser().getUserRoles());
                    Hibernate.initialize((Object)student.getHouses());
                    Hibernate.initialize(student.getStudentLeaveRequistions());
                    Hibernate.initialize(student.getStudentMovementRequisitions());
                }
                log.info((Object)(studentRecordSize + " Student records of class " + classs.getClassName() + " and section" + section.getSectionName() + " with childs  where retrieved"));
            } else {
                log.info((Object)("No Student Records found for class " + classs.getClassName() + " and section" + section.getSectionName()));
            }
            return students;
        }
        catch (Exception e) {
            if (e.getClass().equals(NullPointerException.class)) {
                log.error((Object)"NullPointerException", e.getCause());
                throw new StudentException(new Message("nullpointer", e.getMessage()));
            }
            log.error((Object)"Exception in reteriving students", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Student studentByEmailEager(String studentEmail) {
        try {
            Student student = this.studentDAO.getStudentByEmail(studentEmail);
            if (student != null) {
                Hibernate.initialize((Object)student.getBloodGroup());
                Hibernate.initialize((Object)student.getCategory());
                Hibernate.initialize((Object)student.getInstitution());
                Hibernate.initialize((Object)student.getJoinedAcademicYear());
                Hibernate.initialize((Object)student.getJoinedClass());
                Hibernate.initialize((Object)student.getSection());
                Hibernate.initialize(student.getSpecialCategories());
                Hibernate.initialize((Object)student.getStudentClass());
                Hibernate.initialize((Object)student.getStudentStatus());
                Hibernate.initialize((Object)student.getUser());
                Hibernate.initialize(student.getUser().getUserRoles());
                Hibernate.initialize((Object)student.getParentUser());
                Hibernate.initialize(student.getParentUser().getUserRoles());
                Hibernate.initialize((Object)student.getHouses());
                Hibernate.initialize(student.getStudentLeaveRequistions());
                Hibernate.initialize(student.getStudentMovementRequisitions());
                log.info((Object)("Student with Email=" + studentEmail + " has been reterived"));
                return student;
            }
            log.info((Object)("No Student with  Email=" + studentEmail + " is available"));
            return student;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving student by Email=" + studentEmail), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Student> activeStudentListByClassSectionModuleId(Long classSectionModuleId) {
        try {
            ClassSectionModule classSectionModule = this.classSectionModuleDAO.getClassSectionModuleById(classSectionModuleId);
            Section section = classSectionModule.getClassSection().getSectionClass();
            Class clazz = classSectionModule.getClassSection().getClassSection();
            StudentStatus status = this.studentStatusDAO.getStudentStatusById(1L);
            List<Student> students = this.studentDAO.getStudentsByClassSectionAndStatus(clazz, section, status);
            for (Student student : students) {
                Hibernate.initialize((Object)student.getBloodGroup());
                Hibernate.initialize((Object)student.getJoinedAcademicYear());
                Hibernate.initialize((Object)student.getJoinedClass());
                Hibernate.initialize((Object)student.getSection());
                Hibernate.initialize(student.getSpecialCategories());
                Hibernate.initialize((Object)student.getUser().getProfilePicturePath());
                Hibernate.initialize(student.getUser().getUserRoles());
                Hibernate.initialize((Object)student.getInstitution());
                Hibernate.initialize((Object)student.getCategory());
                Hibernate.initialize((Object)student.getStudentClass());
                Hibernate.initialize((Object)student.getStudentStatus());
                Hibernate.initialize((Object)student.getParentUser());
                Hibernate.initialize(student.getParentUser().getUserRoles());
                Hibernate.initialize((Object)student.getHouses());
                Hibernate.initialize(student.getStudentLeaveRequistions());
                Hibernate.initialize(student.getStudentMovementRequisitions());
            }
            log.info((Object)("Students list  with class section module id=" + classSectionModuleId + " has been reterived"));
            return students;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving students by class section module id=" + classSectionModuleId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateStudentProfile(Student student, User user) {
        try {
            this.userDAO.saveOrUpdate(user);
            this.studentDAO.saveOrUpdate(student);
            Long studentId = student.getStudentId();
            if (studentId != null) {
                log.info((Object)("Student with id=" + studentId + " has been updated"));
            } else {
                log.info((Object)"New Student has been added, because no Student found for update");
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in updating student", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Student> activeStudentListByClassAndSectionId(Long classId, Long sectionId) {
        List<Student> students = null;
        try {
            Class clazz = this.classDAO.getClassById(classId);
            Section section = this.sectionDAO.getSectionById(sectionId);
            StudentStatus status = this.studentStatusDAO.getStudentStatusById(1L);
            students = this.studentDAO.getStudentsByClassSectionAndStatus(clazz, section, status);
            return students;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving active students by class and section id", e.getCause());
            e.printStackTrace();
            return students;
        }
    }

    @Override
    public Student activeStudentByAdmissionNoWithoutInvoiceGenerated(String admissionNo) throws StudentException {
        Student student = null;
        try {
            StudentStatus studentStatus = this.studentStatusDAO.getStudentStatusById(1L);
            student = this.studentDAO.getStudentByAdmissionNoAndStatus(admissionNo, studentStatus);
            if (student == null) {
                throw new StudentException(new Message("failure", "Invalid Student Admission No"));
            }
            Hibernate.initialize((Object)student.getStudentClass());
            Hibernate.initialize((Object)student.getSection());
            return student;
        }
        catch (Exception e) {
            if (e.getClass().equals(StudentException.class)) {
                StudentException se = (StudentException)e;
                throw se;
            }
            log.error((Object)"Exception in reteriving active students by admissionNo without invoice generated", e.getCause());
            e.printStackTrace();
            return student;
        }
    }

    @Override
    public List<Student> activeStudentsInAllClassWithoutInvoiceGenerated(Long institutionId) {
        ArrayList<Student> students = new ArrayList<Student>();
        try {
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            Set<Class> classes = institution.getClasses();
            for (Class clazz : classes) {
                Set<ClassSection> classSections = clazz.getClassSections();
                for (ClassSection classSection : classSections) {
                    ArrayList students1 = (ArrayList)this.studentDAO.getStudentsByClassAndSection(clazz, classSection.getSectionClass());
                    Iterator iterator = students1.iterator();
                    while (iterator.hasNext()) {
                        Student student = (Student)iterator.next();
                        if (student.getStudentStatus().getStudentStatusId() != 1L) {
                            iterator.remove();
                            continue;
                        }
                        students.add(student);
                    }
                }
            }
            return students;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving active students by all class without invoice generated", e.getCause());
            e.printStackTrace();
            return students;
        }
    }

    public boolean checkForStudentInvoiceGenerated(Student student) {
        boolean invoiceGenerated = false;
        if (student != null) {
            Hibernate.initialize(student.getInvoices());
            Hibernate.initialize((Object)student.getInstitution());
            Set<StudentInvoice> studentInvoices = student.getInvoices();
            Institution institution = student.getInstitution();
            Hibernate.initialize(institution.getAcademicYears());
            List institutionAcademicYears = this.academicYearDAO.getList();
            Iterator iterator = institutionAcademicYears.iterator();
            AcademicYear academicYear = null;
            while (iterator.hasNext()) {
                academicYear = (AcademicYear)iterator.next();
                if (academicYear.getAcademicYearStatus() == 1) break;
                academicYear = null;
            }
            for (StudentInvoice studentInvoice : studentInvoices) {
                if (studentInvoice.getAcademicYear().getAcademicYearId() != academicYear.getAcademicYearId()) continue;
                invoiceGenerated = true;
                break;
            }
            return invoiceGenerated;
        }
        return invoiceGenerated;
    }

    @Override
    public List<Student> activeStudentsFromAllClassBySpecialCategoryWithoutInvoiceGenerated(Long instituteId, Long specialCategoryId) {
        ArrayList<Student> students = null;
        try {
            Institution institution = this.institutionDAO.getInstitutionById(instituteId);
            SpecialCategory specialCategory = this.specialCategoryDAO.getSpecialCategoryById(specialCategoryId);
            StudentStatus studentStatus = this.studentStatusDAO.getStudentStatusById(1L);
            students = new ArrayList<Student>(institution.getStudents());
            Iterator studentIterator = students.iterator();
            while (studentIterator.hasNext()) {
                Student student = (Student)studentIterator.next();
                if (student.getStudentStatus().equals(studentStatus)) {
                    if (!student.getSpecialCategories().contains(specialCategory)) {
                        studentIterator.remove();
                        continue;
                    }
                    Hibernate.initialize((Object)student.getStudentClass());
                    Hibernate.initialize((Object)student.getSection());
                    continue;
                }
                studentIterator.remove();
            }
            return students;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving active students without invoice generated by all class and specific special category ", e.getCause());
            e.printStackTrace();
            return students;
        }
    }

    @Override
    public List<Student> activeStudentsInClassAndSectionWithoutInvoiceGenerated(Long classId, Long sectionId) {
        List<Student> students = null;
        try {
            Class clazz = this.classDAO.getClassById(classId);
            Section section = this.sectionDAO.getSectionById(sectionId);
            StudentStatus studentStatus = this.studentStatusDAO.getStudentStatusById(1L);
            students = this.studentDAO.getStudentsByClassSectionAndStatus(clazz, section, studentStatus);
            for (Student student : students) {
            }
            return students;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving active students without invoice generated in a given class and section", e.getCause());
            e.printStackTrace();
            return students;
        }
    }

    @Override
    public List<Student> activeStudentsInClassSectionAndSpecialCategoryWithoutInvoiceGenerated(Long classId, Long sectionId, Long specialCategoryId) {
        List<Student> students = null;
        try {
            Class clazz = this.classDAO.getClassById(classId);
            Section section = this.sectionDAO.getSectionById(sectionId);
            StudentStatus studentStatus = this.studentStatusDAO.getStudentStatusById(1L);
            SpecialCategory specialCategory = this.specialCategoryDAO.getSpecialCategoryById(specialCategoryId);
            students = this.studentDAO.getStudentsByClassSectionAndSpecialCategoryAndStatus(clazz, section, specialCategory, studentStatus);
            return students;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving active students without invoice generated in a given class, section and special category", e.getCause());
            e.printStackTrace();
            return students;
        }
    }

    @Override
    public List<Student> studentListEager() throws StudentException {
        try {
            List<Student> students = this.studentDAO.getList();
            Integer studentRecordSize = students.size();
            if (studentRecordSize > 0) {
                for (Student student : students) {
                    Hibernate.initialize((Object)student.getBloodGroup());
                    Hibernate.initialize((Object)student.getJoinedAcademicYear());
                    Hibernate.initialize((Object)student.getJoinedClass());
                    Hibernate.initialize((Object)student.getSection());
                    Hibernate.initialize(student.getSpecialCategories());
                    Hibernate.initialize((Object)student.getUser());
                    Hibernate.initialize(student.getUser().getUserRoles());
                    Hibernate.initialize((Object)student.getInstitution());
                    Hibernate.initialize((Object)student.getCategory());
                    Hibernate.initialize((Object)student.getStudentClass());
                    Hibernate.initialize((Object)student.getStudentStatus());
                    Hibernate.initialize((Object)student.getParentUser());
                    Hibernate.initialize(student.getParentUser().getUserRoles());
                    Hibernate.initialize((Object)student.getHouses());
                    Hibernate.initialize(student.getStudentLeaveRequistions());
                    Hibernate.initialize(student.getStudentMovementRequisitions());
                }
                log.info((Object)(studentRecordSize + " Student records where reterived"));
            } else {
                log.info((Object)"No Student Records found");
            }
            return students;
        }
        catch (Exception e) {
            if (e.getClass().equals(NullPointerException.class)) {
                log.error((Object)"NullPointerException", e.getCause());
                throw new StudentException(new Message("nullpointer", e.getMessage()));
            }
            log.error((Object)"Exception in reteriving students", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Student> studentListByClassAndSectionEager(Long classId, Long sectionId) throws StudentException {
        try {
            Class classs = this.classDAO.getClassById(classId);
            Section section = this.sectionDAO.getSectionById(sectionId);
            List<Student> students = this.studentDAO.getStudentsByClassAndSection(classs, section);
            Integer studentRecordSize = students.size();
            if (studentRecordSize > 0) {
                for (Student student : students) {
                    Hibernate.initialize((Object)student.getBloodGroup());
                    Hibernate.initialize((Object)student.getJoinedAcademicYear());
                    Hibernate.initialize((Object)student.getJoinedClass());
                    Hibernate.initialize((Object)student.getSection());
                    Hibernate.initialize(student.getSpecialCategories());
                    Hibernate.initialize((Object)student.getUser());
                    Hibernate.initialize(student.getUser().getUserRoles());
                    Hibernate.initialize((Object)student.getInstitution());
                    Hibernate.initialize((Object)student.getCategory());
                    Hibernate.initialize((Object)student.getStudentClass());
                    Hibernate.initialize((Object)student.getStudentStatus());
                    Hibernate.initialize((Object)student.getParentUser());
                    Hibernate.initialize(student.getParentUser().getUserRoles());
                    Hibernate.initialize((Object)student.getHouses());
                    Hibernate.initialize(student.getStudentLeaveRequistions());
                    Hibernate.initialize(student.getStudentMovementRequisitions());
                }
                log.info((Object)(studentRecordSize + " Student records of class " + classs.getClassName() + " and section" + section.getSectionName() + " with childs  where retrieved"));
            } else {
                log.info((Object)("No Student Records found for class " + classs.getClassName() + " and section" + section.getSectionName()));
            }
            return students;
        }
        catch (Exception e) {
            if (e.getClass().equals(NullPointerException.class)) {
                log.error((Object)"NullPointerException", e.getCause());
                throw new StudentException(new Message("nullpointer", e.getMessage()));
            }
            log.error((Object)"Exception in reteriving students with childs ", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Student studentByAdmissionNo(String admissionNo) throws StudentException {
        Student student = null;
        try {
            student = this.studentDAO.getStudentByAdmissionNo(admissionNo);
            if (student == null) {
                throw new StudentException(new Message("failure", "Invalid Student Admission No"));
            }
            Hibernate.initialize((Object)student.getBloodGroup());
            Hibernate.initialize((Object)student.getJoinedAcademicYear());
            Hibernate.initialize((Object)student.getJoinedClass());
            Hibernate.initialize((Object)student.getSection());
            Hibernate.initialize(student.getSpecialCategories());
            Hibernate.initialize((Object)student.getUser());
            Hibernate.initialize(student.getUser().getUserRoles());
            Hibernate.initialize((Object)student.getInstitution());
            Hibernate.initialize((Object)student.getCategory());
            Hibernate.initialize((Object)student.getStudentClass());
            Hibernate.initialize((Object)student.getStudentStatus());
            Hibernate.initialize((Object)student.getParentUser());
            Hibernate.initialize(student.getParentUser().getUserRoles());
            Hibernate.initialize((Object)student.getHouses());
            Hibernate.initialize(student.getStudentLeaveRequistions());
            Hibernate.initialize(student.getStudentMovementRequisitions());
            return student;
        }
        catch (Exception e) {
            if (e.getClass().equals(StudentException.class)) {
                StudentException se = (StudentException)e;
                throw se;
            }
            log.error((Object)"Exception in reteriving  student by admission no", e.getCause());
            e.printStackTrace();
            return student;
        }
    }

    @Override
    public List<Student> studentsByClassSectionAndSpecialCategory(Long classId, Long sectionId, Long specialCategoryId) {
        List<Student> studentList = null;
        try {
            Class clazz = this.classDAO.getClassById(classId);
            Section section = this.sectionDAO.getSectionById(sectionId);
            SpecialCategory specialCategory = this.specialCategoryDAO.getSpecialCategoryById(specialCategoryId);
            studentList = this.studentDAO.getStudentsByClassSectionAndSpecialCategory(clazz, section, specialCategory);
            return studentList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving  students by class section and special category", e.getCause());
            e.printStackTrace();
            return studentList;
        }
    }

    @Override
    public List<Student> studentsByStatus(Long institutionId, Long studentStatusId) {
        List<Student> studentList = null;
        try {
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            StudentStatus studentStatus = this.studentStatusDAO.getStudentStatusById(studentStatusId);
            studentList = this.studentDAO.getStudentsByStatus(institution, studentStatus);
            return studentList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving  students by institution and studentstatus", e.getCause());
            e.printStackTrace();
            return studentList;
        }
    }

    @Override
    public List<Student> studentsBySpecialCategory(Long institutionId, Long specialCategoryId) {
        List<Student> studentList = null;
        try {
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            SpecialCategory specialCategory = this.specialCategoryDAO.getSpecialCategoryById(specialCategoryId);
            studentList = this.studentDAO.getStudentsBySpecialCategory(institution, specialCategory);
            return studentList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving  students by special category and institution", e.getCause());
            e.printStackTrace();
            return studentList;
        }
    }

    @Override
    public Student studentByAdmissionNoEager(String admissionNo) throws StudentException {
        Student student = null;
        try {
            student = this.studentDAO.getStudentByAdmissionNo(admissionNo);
            if (student == null) {
                throw new StudentException(new Message("failure", "Invalid Student Admission No"));
            }
            Hibernate.initialize((Object)student.getJoinedAcademicYear());
            Hibernate.initialize((Object)student.getCategory());
            Hibernate.initialize((Object)student.getStudentStatus());
            Hibernate.initialize((Object)student.getBloodGroup());
            Hibernate.initialize((Object)student.getUser());
            Hibernate.initialize((Object)student.getParentUser());
            Hibernate.initialize((Object)student.getInstitution());
            Hibernate.initialize((Object)student.getStudentClass());
            Hibernate.initialize((Object)student.getJoinedClass());
            Hibernate.initialize((Object)student.getSection());
            Hibernate.initialize(student.getSpecialCategories());
            Hibernate.initialize(student.getStaffModuleAttendances());
            Hibernate.initialize(student.getInvoices());
            Hibernate.initialize(student.getStudentReceipts());
            Hibernate.initialize((Object)student.getHouses());
            Hibernate.initialize(student.getStudentLeaveRequistions());
            Hibernate.initialize(student.getStudentMovementRequisitions());
            return student;
        }
        catch (Exception e) {
            if (e.getClass().equals(StudentException.class)) {
                StudentException se = (StudentException)e;
                throw se;
            }
            log.error((Object)"Exception in reteriving  students with childs by admission no", e.getCause());
            e.printStackTrace();
            return student;
        }
    }

    @Override
    public List<Student> studentsByClassSectionAndSpecialCategoryEager(Long classId, Long sectionId, Long specialCategoryId) {
        List<Student> studentList = null;
        try {
            Class clazz = this.classDAO.getClassById(classId);
            Section section = this.sectionDAO.getSectionById(sectionId);
            SpecialCategory specialCategory = this.specialCategoryDAO.getSpecialCategoryById(specialCategoryId);
            studentList = this.studentDAO.getStudentsByClassSectionAndSpecialCategory(clazz, section, specialCategory);
            for (Student student : studentList) {
                Hibernate.initialize((Object)student.getJoinedAcademicYear());
                Hibernate.initialize((Object)student.getCategory());
                Hibernate.initialize((Object)student.getStudentStatus());
                Hibernate.initialize((Object)student.getBloodGroup());
                Hibernate.initialize((Object)student.getUser());
                Hibernate.initialize((Object)student.getParentUser());
                Hibernate.initialize((Object)student.getInstitution());
                Hibernate.initialize((Object)student.getStudentClass());
                Hibernate.initialize((Object)student.getJoinedClass());
                Hibernate.initialize((Object)student.getSection());
                Hibernate.initialize(student.getSpecialCategories());
                Hibernate.initialize(student.getStaffModuleAttendances());
                Hibernate.initialize(student.getInvoices());
                Hibernate.initialize(student.getStudentReceipts());
                Hibernate.initialize((Object)student.getHouses());
                Hibernate.initialize(student.getStudentLeaveRequistions());
                Hibernate.initialize(student.getStudentMovementRequisitions());
            }
            return studentList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving  students with childs by class section and special category", e.getCause());
            e.printStackTrace();
            return studentList;
        }
    }

    @Override
    public List<Student> studentsByStatusEager(Long institutionId, Long studentStatusId) {
        List<Student> studentList = null;
        try {
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            StudentStatus studentStatus = this.studentStatusDAO.getStudentStatusById(studentStatusId);
            studentList = this.studentDAO.getStudentsByStatus(institution, studentStatus);
            for (Student student : studentList) {
                Hibernate.initialize((Object)student.getJoinedAcademicYear());
                Hibernate.initialize((Object)student.getCategory());
                Hibernate.initialize((Object)student.getStudentStatus());
                Hibernate.initialize((Object)student.getBloodGroup());
                Hibernate.initialize((Object)student.getUser());
                Hibernate.initialize((Object)student.getParentUser());
                Hibernate.initialize((Object)student.getInstitution());
                Hibernate.initialize((Object)student.getStudentClass());
                Hibernate.initialize((Object)student.getJoinedClass());
                Hibernate.initialize((Object)student.getSection());
                Hibernate.initialize(student.getSpecialCategories());
                Hibernate.initialize(student.getStaffModuleAttendances());
                Hibernate.initialize(student.getInvoices());
                Hibernate.initialize(student.getStudentReceipts());
                Hibernate.initialize((Object)student.getHouses());
                Hibernate.initialize(student.getStudentLeaveRequistions());
                Hibernate.initialize(student.getStudentMovementRequisitions());
            }
            return studentList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving  students with childs by institution and student status", e.getCause());
            e.printStackTrace();
            return studentList;
        }
    }

    @Override
    public List<Student> studentsBySpecialCategoryEager(Long institutionId, Long specialCategoryId) {
        List<Student> studentList = null;
        try {
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            SpecialCategory specialCategory = this.specialCategoryDAO.getSpecialCategoryById(specialCategoryId);
            studentList = this.studentDAO.getStudentsBySpecialCategory(institution, specialCategory);
            for (Student student : studentList) {
                Hibernate.initialize((Object)student.getJoinedAcademicYear());
                Hibernate.initialize((Object)student.getCategory());
                Hibernate.initialize((Object)student.getStudentStatus());
                Hibernate.initialize((Object)student.getBloodGroup());
                Hibernate.initialize((Object)student.getUser());
                Hibernate.initialize((Object)student.getParentUser());
                Hibernate.initialize((Object)student.getInstitution());
                Hibernate.initialize((Object)student.getStudentClass());
                Hibernate.initialize((Object)student.getJoinedClass());
                Hibernate.initialize((Object)student.getSection());
                Hibernate.initialize(student.getSpecialCategories());
                Hibernate.initialize(student.getStaffModuleAttendances());
                Hibernate.initialize(student.getInvoices());
                Hibernate.initialize(student.getStudentReceipts());
                Hibernate.initialize((Object)student.getHouses());
                Hibernate.initialize(student.getStudentLeaveRequistions());
                Hibernate.initialize(student.getStudentMovementRequisitions());
            }
            return studentList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving  students with childs by special category and institution", e.getCause());
            e.printStackTrace();
            return studentList;
        }
    }

    @Override
    public Student studentByParentEmailEager(String parentEmail) {
        try {
            Student student = this.studentDAO.getStudentByParentEmail(parentEmail);
            if (student != null) {
                Hibernate.initialize((Object)student.getBloodGroup());
                Hibernate.initialize((Object)student.getCategory());
                Hibernate.initialize((Object)student.getInstitution());
                Hibernate.initialize((Object)student.getJoinedAcademicYear());
                Hibernate.initialize((Object)student.getJoinedClass());
                Hibernate.initialize((Object)student.getSection());
                Hibernate.initialize(student.getSpecialCategories());
                Hibernate.initialize((Object)student.getStudentClass());
                Hibernate.initialize((Object)student.getStudentStatus());
                Hibernate.initialize((Object)student.getUser());
                Hibernate.initialize(student.getUser().getUserRoles());
                Hibernate.initialize((Object)student.getParentUser());
                Hibernate.initialize(student.getParentUser().getUserRoles());
                Hibernate.initialize((Object)student.getHouses());
                Hibernate.initialize(student.getStudentLeaveRequistions());
                Hibernate.initialize(student.getStudentMovementRequisitions());
                log.info((Object)("Student with Email=" + parentEmail + " has been reterived"));
                return student;
            }
            log.info((Object)("No Student with  Email=" + parentEmail + " is available"));
            return student;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving student by Email=" + parentEmail), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Student studentListByClassAndSectionAndAdmissionNoEager(Long classId, Long sectionId, String admissionNo) throws StudentException {
        try {
            Class classs = this.classDAO.getClassById(classId);
            Section section = this.sectionDAO.getSectionById(sectionId);
            Student student = this.studentDAO.getStudentsByClassAndSectionAndAdmissionNo(classs, section, admissionNo);
            if (student != null) {
                Hibernate.initialize((Object)student.getBloodGroup());
                Hibernate.initialize((Object)student.getJoinedAcademicYear());
                Hibernate.initialize((Object)student.getJoinedClass());
                Hibernate.initialize((Object)student.getSection());
                Hibernate.initialize(student.getSpecialCategories());
                Hibernate.initialize((Object)student.getUser());
                Hibernate.initialize(student.getUser().getUserRoles());
                Hibernate.initialize((Object)student.getInstitution());
                Hibernate.initialize((Object)student.getCategory());
                Hibernate.initialize((Object)student.getStudentClass());
                Hibernate.initialize((Object)student.getStudentStatus());
                Hibernate.initialize((Object)student.getParentUser());
                Hibernate.initialize(student.getParentUser().getUserRoles());
                Hibernate.initialize((Object)student.getHouses());
                Hibernate.initialize(student.getStudentLeaveRequistions());
                Hibernate.initialize(student.getStudentMovementRequisitions());
                log.info((Object)("Student with Class=" + classs.getClassName() + " and Section=" + section.getSectionName() + " AdmissionNo=" + admissionNo + " has been reterived"));
            } else {
                log.info((Object)("No Student with Class=" + classs.getClassName() + " and Section=" + section.getSectionName() + " AdmissionNo=" + admissionNo + " is available"));
            }
            return student;
        }
        catch (Exception e) {
            if (e.getClass().equals(NullPointerException.class)) {
                log.error((Object)"NullPointerException", e.getCause());
                throw new StudentException(new Message("nullpointer", e.getMessage()));
            }
            log.error((Object)"Exception in reteriving students with childs ", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public Integer studentBulkUpdate(MultipartFile studentExcelFile, Long institutionId, String createdBy) throws StudentException {
        int i = 1;
        try {
            ArrayList<Student> students = new ArrayList<Student>();
            DataFormatter formatter = new DataFormatter();
            HSSFWorkbook workbook = new HSSFWorkbook(studentExcelFile.getInputStream());
            HSSFSheet worksheet = workbook.getSheetAt(0);
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            while (i <= worksheet.getLastRowNum()) {
                HSSFRow row = worksheet.getRow(i++);
                Long studentId = null;
                Student student = null;
                if (formatter.formatCellValue((Cell)row.getCell(0)).isEmpty()) throw new StudentException(new Message("invalidStudentId", "Invalid Student Id Found On Row" + i));
                if (formatter.formatCellValue((Cell)row.getCell(0)).isEmpty()) {
                    throw new StudentException(new Message("studentIdNotFound", "Upload Failed : You have to mention Student Id in row " + i));
                }
                studentId = Long.parseLong(formatter.formatCellValue((Cell)row.getCell(0)).trim());
                student = this.studentDAO.getStudentById(studentId);
                if (student == null) throw new StudentException(new Message("invalidStudentId", "No Student Id Found On Row" + i));
                String admissionNo = null;
                if (formatter.formatCellValue((Cell)row.getCell(1)).isEmpty()) {
                    throw new StudentException(new Message("admissionNumberNotFound", "Upload Failed : You have to mention Admission Number in row " + i));
                }
                admissionNo = formatter.formatCellValue((Cell)row.getCell(1)).trim();
                student.setAdmissionNo(admissionNo);
                if (formatter.formatCellValue((Cell)row.getCell(2)).isEmpty()) {
                    throw new StudentException(new Message("firstNameNotFound", "Upload Failed : You have to mention First Name in row " + i));
                }
                student.setFirstName(formatter.formatCellValue((Cell)row.getCell(2)).trim());
                if (!formatter.formatCellValue((Cell)row.getCell(3)).isEmpty()) {
                    student.setLastName(formatter.formatCellValue((Cell)row.getCell(3)).trim());
                }
                Class studentClass = null;
                if (formatter.formatCellValue((Cell)row.getCell(4)).isEmpty()) throw new StudentException(new Message("classNotFound", "Upload Failed : You have to mention Current Class in row " + i));
                studentClass = this.classDAO.getClassByClassNameAndInstitution(formatter.formatCellValue((Cell)row.getCell(4)).trim(), institution);
                if (studentClass == null) {
                    throw new StudentException(new Message("classNotFound", "Upload Failed : Invalid Current Class in row " + i));
                }
                student.setStudentClass(studentClass);
                Section section = null;
                if (formatter.formatCellValue((Cell)row.getCell(5)).isEmpty()) throw new StudentException(new Message("sectionNotFound", "Upload Failed : You have to mention Section for row " + i));
                Section sectionReceived = this.sectionDAO.getSectionBySectionNameAndInstitution(formatter.formatCellValue((Cell)row.getCell(5)).trim(), institution);
                if (sectionReceived == null) {
                    throw new StudentException(new Message("sectionNotFound", "Upload Failed : Invalid Section in row " + i));
                }
                Hibernate.initialize((Object)studentClass);
                Hibernate.initialize(studentClass.getClassSections());
                boolean booleanSection = false;
                for (ClassSection classSection : studentClass.getClassSections()) {
                    Hibernate.initialize((Object)classSection.getSectionClass());
                    if (!classSection.getSectionClass().getSectionName().equals(sectionReceived.getSectionName())) continue;
                    booleanSection = true;
                }
                if (!booleanSection) {
                    throw new StudentException(new Message("sectionNotFound", "Upload Failed : No Such Section for a class in row " + i));
                }
                section = sectionReceived;
                student.setSection(section);
                LinkedHashSet<SpecialCategory> specialCategory = new LinkedHashSet<SpecialCategory>();
                if (formatter.formatCellValue((Cell)row.getCell(6)).isEmpty()) throw new StudentException(new Message("specialCategoryNameNotFound", "Upload Failed : You have to mention Special Category in row " + i));
                String currentSpecialCategory = formatter.formatCellValue((Cell)row.getCell(6)).trim();
                String[] curSpeacialCategory = currentSpecialCategory.split(",");
                curSpeacialCategory = (String[])Arrays.stream(curSpeacialCategory).filter(s -> s != null && s.length() > 0).toArray(String[]::new);
                int j = 0;
                while (j < curSpeacialCategory.length) {
                    if (this.specialCategoryDAO.getSpecialCategoryByNameAndInstitution(curSpeacialCategory[j].toString(), institution) == null) {
                        throw new StudentException(new Message("specialCategoryNameNotFound", "Upload Failed : Invalid Special Category in row " + i));
                    }
                    specialCategory.add(this.specialCategoryDAO.getSpecialCategoryByNameAndInstitution(curSpeacialCategory[j].toString(), institution));
                    ++j;
                }
                student.setSpecialCategories(specialCategory);
                StudentStatus studentStatus = null;
                if (formatter.formatCellValue((Cell)row.getCell(7)).isEmpty()) throw new StudentException(new Message("studentStatusNotFound", "Upload Failed : You have to mention Student Status in row " + i));
                studentStatus = this.studentStatusDAO.getStudentStatusByName(formatter.formatCellValue((Cell)row.getCell(7)).trim());
                if (studentStatus == null) {
                    throw new StudentException(new Message("studentStatusNotFound", "Upload Failed : Invalid Student Status in row " + i));
                }
                student.setStudentStatus(studentStatus);
                if (!formatter.formatCellValue((Cell)row.getCell(8)).isEmpty()) {
                    student.setRollNo(formatter.formatCellValue((Cell)row.getCell(8)).trim());
                }
                if (formatter.formatCellValue((Cell)row.getCell(9)).isEmpty()) throw new StudentException(new Message("genderNotFound", "Upload Failed : You have to mention Gender in row " + i));
                String gender = formatter.formatCellValue((Cell)row.getCell(9)).trim();
                if (!(gender.equals("Male") || gender.equals("Female") || gender.equals("Others"))) {
                    throw new StudentException(new Message("genderNotFound", "Upload Failed : Gender can be Male/Female/Others in row " + i));
                }
                student.setSex(gender);
                if (formatter.formatCellValue((Cell)row.getCell(10)).isEmpty()) {
                    throw new StudentException(new Message("invalidDateFormat", "Upload Failed : Invalid Birth Date Format in row " + i + " correct format [eg:dd/mm/yyyy]"));
                }
                student.setBirthDate(new Date(formatter.formatCellValue((Cell)row.getCell(10)).trim()));
                Category category = null;
                if (formatter.formatCellValue((Cell)row.getCell(11)).isEmpty()) throw new StudentException(new Message("categoryNotFound", "Upload Failed : You have to mention Category in row " + i));
                category = this.categoryDAO.getCategoryByCategoryName(formatter.formatCellValue((Cell)row.getCell(11)).trim());
                if (category == null) {
                    throw new StudentException(new Message("categoryNotFound", "Upload Failed : Invalid Category in row " + i));
                }
                student.setCategory(category);
                BloodGroup bloodGroup = null;
                if (!formatter.formatCellValue((Cell)row.getCell(12)).isEmpty()) {
                    bloodGroup = this.bloodGroupDAO.getBloodGroupByName(formatter.formatCellValue((Cell)row.getCell(12)).trim());
                    if (bloodGroup == null) {
                        bloodGroup = null;
                    } else {
                        student.setBloodGroup(bloodGroup);
                    }
                }
                AcademicYear joinedAcademicYear = null;
                if (formatter.formatCellValue((Cell)row.getCell(13)).isEmpty()) throw new StudentException(new Message("academicYearNotFound", "Upload Failed : Invalid Academic Year in row " + i));
                joinedAcademicYear = this.academicYearDAO.getAcademiYearByAcademicYearTitle(formatter.formatCellValue((Cell)row.getCell(13)).trim());
                if (joinedAcademicYear == null) {
                    throw new StudentException(new Message("academicyearNotFound", "Upload Failed : Invalid Academic Year in row " + i));
                }
                student.setJoinedAcademicYear(joinedAcademicYear);
                Class joinedClass = null;
                if (formatter.formatCellValue((Cell)row.getCell(14)).isEmpty()) throw new StudentException(new Message("joinedClassNotFound", "Upload Failed : You have to mention Joined Class in row " + i));
                joinedClass = this.classDAO.getClassByClassNameAndInstitution(formatter.formatCellValue((Cell)row.getCell(14)).trim(), institution);
                if (joinedClass == null) {
                    throw new StudentException(new Message("joinedClassNotFound", "Upload Failed : Invalid Joined Class in row " + i));
                }
                student.setJoinedClass(joinedClass);
                if (formatter.formatCellValue((Cell)row.getCell(15)).isEmpty()) {
                    throw new StudentException(new Message("parentOrGuardianFirstNameNotFound", "Upload Failed : You have to mention ParentOrGuardianFirstName in row " + i));
                }
                student.setParentGuardianFirstName(formatter.formatCellValue((Cell)row.getCell(15)).trim());
                if (!formatter.formatCellValue((Cell)row.getCell(16)).isEmpty()) {
                    student.setParentGuardianLastName(formatter.formatCellValue((Cell)row.getCell(16)).trim());
                }
                if (formatter.formatCellValue((Cell)row.getCell(17)).isEmpty()) {
                    throw new StudentException(new Message("parentOrGuardianEmailNotFound", "Upload Failed : You have to mention ParentOrGuardian Email in row " + i));
                }
                student.setParentGuardianEmail(formatter.formatCellValue((Cell)row.getCell(17)).trim());
                if (formatter.formatCellValue((Cell)row.getCell(18)).isEmpty()) {
                    throw new StudentException(new Message("addressLine1NotFound", "Upload Failed : You have to mention AddressLine1 in row " + i));
                }
                student.setAddressLine1(formatter.formatCellValue((Cell)row.getCell(18)).trim());
                if (formatter.formatCellValue((Cell)row.getCell(19)).isEmpty()) {
                    throw new StudentException(new Message("addressLine2NotFound", "Upload Failed : You have to mention AddressLine2 in row " + i));
                }
                student.setAddressLine2(formatter.formatCellValue((Cell)row.getCell(19)).trim());
                if (formatter.formatCellValue((Cell)row.getCell(20)).isEmpty()) {
                    throw new StudentException(new Message("postCodeNotFound", "Upload Failed : You have to mention PostCode in row " + i));
                }
                student.setPostcode(formatter.formatCellValue((Cell)row.getCell(20)).trim());
                if (formatter.formatCellValue((Cell)row.getCell(21)).isEmpty()) {
                    throw new StudentException(new Message("studentEmailNotFound", "Upload Failed : You have to mention Student Email in row " + i));
                }
                student.setEmail(formatter.formatCellValue((Cell)row.getCell(21)).trim());
                if (formatter.formatCellValue((Cell)row.getCell(22)).isEmpty()) {
                    throw new StudentException(new Message("studentContactNotFound", "Upload Failed : You have to mention Student Contact in row " + i));
                }
                student.setContact(formatter.formatCellValue((Cell)row.getCell(22)).trim());
                if (formatter.formatCellValue((Cell)row.getCell(23)).isEmpty()) {
                    throw new StudentException(new Message("parentContactNotFound", "Upload Failed : You have to mention Parent Contact in row " + i));
                }
                student.setParentContact(formatter.formatCellValue((Cell)row.getCell(23)).trim());
                if (!formatter.formatCellValue((Cell)row.getCell(25)).isEmpty()) {
                    student.setFathersIncome(Double.parseDouble(formatter.formatCellValue((Cell)row.getCell(25)).trim()));
                }
                if (!formatter.formatCellValue((Cell)row.getCell(26)).isEmpty()) {
                    student.setMothersIncome(Double.parseDouble(formatter.formatCellValue((Cell)row.getCell(26)).trim()));
                }
                if (!formatter.formatCellValue((Cell)row.getCell(27)).isEmpty()) {
                    student.setAccessNo(formatter.formatCellValue((Cell)row.getCell(27)).trim());
                }
                if (!formatter.formatCellValue((Cell)row.getCell(28)).isEmpty()) {
                    student.setPassportNumber(formatter.formatCellValue((Cell)row.getCell(28)).trim());
                }
                Houses house = null;
                if (formatter.formatCellValue((Cell)row.getCell(29)).isEmpty()) throw new StudentException(new Message("houseNotFound", "Upload Failed : You have to mention House in row " + i));
                house = this.houseDAO.getHousesByNameAndInstitution(formatter.formatCellValue((Cell)row.getCell(29)).trim(), institution);
                if (house == null) {
                    throw new StudentException(new Message("houseNotFound", "Upload Failed : Invalid House in row " + i));
                }
                student.setHouses(house);
                if (!formatter.formatCellValue((Cell)row.getCell(30)).isEmpty()) {
                    student.setAadharCardNumber(Long.parseLong(formatter.formatCellValue((Cell)row.getCell(30)).trim()));
                }
                students.add(student);
            }
            for (Student student : students) {
                this.studentDAO.update(student);
            }
            return i;
        }
        catch (IOException | ConstraintViolationException e) {
            if (e.getClass().equals(IOException.class)) {
                e.printStackTrace();
                throw new StudentException(new Message("fileError", "Excel File Not Found"));
            }
            if (e.getClass().equals(NullPointerException.class)) {
                e.printStackTrace();
                throw new StudentException(new Message("Null Value", "Fields Cannot be Blank"));
            }
            e.printStackTrace();
            return 0;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public Integer studentBulkUpload(MultipartFile studentExcelFile, Long institutionId, String createdBy) throws StudentException {
        int i = 1;
        try {
            ArrayList<Student> students = new ArrayList<Student>();
            DataFormatter formatter = new DataFormatter();
            HSSFWorkbook workbook = new HSSFWorkbook(studentExcelFile.getInputStream());
            HSSFSheet worksheet = workbook.getSheetAt(0);
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            while (i <= worksheet.getLastRowNum()) {
                Date date;
                HSSFRow row = worksheet.getRow(i++);
                String admissionNo = null;
                if (formatter.formatCellValue((Cell)row.getCell(0)).isEmpty()) {
                    throw new StudentException(new Message("admissionNumberNotFound", "Upload Failed : You have to mention Admission Number in row " + i));
                }
                admissionNo = formatter.formatCellValue((Cell)row.getCell(0)).trim();
                String firstName = null;
                if (formatter.formatCellValue((Cell)row.getCell(1)).isEmpty()) {
                    throw new StudentException(new Message("firstNameNotFound", "Upload Failed : You have to mention First Name in row " + i));
                }
                firstName = formatter.formatCellValue((Cell)row.getCell(1)).trim();
                String lastName = "";
                if (!formatter.formatCellValue((Cell)row.getCell(2)).isEmpty()) {
                    lastName = formatter.formatCellValue((Cell)row.getCell(2)).trim();
                }
                Class studentClass = null;
                if (formatter.formatCellValue((Cell)row.getCell(3)).isEmpty()) throw new StudentException(new Message("classNotFound", "Upload Failed : You have to mention Current Class in row " + i));
                studentClass = this.classDAO.getClassByClassNameAndInstitution(formatter.formatCellValue((Cell)row.getCell(3)).trim(), institution);
                if (studentClass == null) {
                    throw new StudentException(new Message("classNotFound", "Upload Failed : Invalid Current Class in row " + i));
                }
                Section section = null;
                if (formatter.formatCellValue((Cell)row.getCell(4)).isEmpty()) throw new StudentException(new Message("sectionNotFound", "Upload Failed : You have to mention section for row " + i));
                Section sectionReceived = this.sectionDAO.getSectionBySectionNameAndInstitution(formatter.formatCellValue((Cell)row.getCell(4)).trim(), institution);
                if (sectionReceived == null) {
                    throw new StudentException(new Message("sectionNotFound", "Upload Failed : Invalid Section in row " + i));
                }
                Hibernate.initialize((Object)studentClass);
                Hibernate.initialize(studentClass.getClassSections());
                boolean booleanSection = false;
                for (ClassSection classSection : studentClass.getClassSections()) {
                    Hibernate.initialize((Object)classSection.getSectionClass());
                    if (!classSection.getSectionClass().getSectionName().equals(sectionReceived.getSectionName())) continue;
                    booleanSection = true;
                }
                if (!booleanSection) {
                    throw new StudentException(new Message("sectionNotFound", "Upload Failed : No Such Section for a class in row " + i));
                }
                section = sectionReceived;
                LinkedHashSet<SpecialCategory> specialCategory = new LinkedHashSet<SpecialCategory>();
                if (formatter.formatCellValue((Cell)row.getCell(5)).isEmpty()) throw new StudentException(new Message("specialCategoryNameNotFound", "Upload Failed : You have to mention Special Category in row " + i));
                String currentSpecialCategory = formatter.formatCellValue((Cell)row.getCell(5)).trim();
                String[] curSpeacialCategory = currentSpecialCategory.split(",");
                curSpeacialCategory = (String[])Arrays.stream(curSpeacialCategory).filter(s -> s != null && s.length() > 0).toArray(String[]::new);
                int j = 0;
                while (j < curSpeacialCategory.length) {
                    if (this.specialCategoryDAO.getSpecialCategoryByNameAndInstitution(curSpeacialCategory[j].toString(), institution) == null) {
                        throw new StudentException(new Message("specialCategoryNameNotFound", "Upload Failed : Invalid Special Category in row " + i));
                    }
                    specialCategory.add(this.specialCategoryDAO.getSpecialCategoryByNameAndInstitution(curSpeacialCategory[j].toString(), institution));
                    ++j;
                }
                StudentStatus studentStatus = null;
                if (formatter.formatCellValue((Cell)row.getCell(6)).isEmpty()) throw new StudentException(new Message("studentStatusNotFound", "Upload Failed : You have to mention Student Status in row " + i));
                studentStatus = this.studentStatusDAO.getStudentStatusByName(formatter.formatCellValue((Cell)row.getCell(6)).trim());
                if (studentStatus == null) {
                    throw new StudentException(new Message("studentStatusNotFound", "Upload Failed : Invalid Student Status in row " + i));
                }
                String rollNo = null;
                if (!formatter.formatCellValue((Cell)row.getCell(7)).isEmpty()) {
                    rollNo = formatter.formatCellValue((Cell)row.getCell(7)).trim();
                }
                String sex = null;
                if (formatter.formatCellValue((Cell)row.getCell(8)).isEmpty()) throw new StudentException(new Message("genderNotFound", "Upload Failed : You have to mention Gender in row " + i));
                String gender = formatter.formatCellValue((Cell)row.getCell(8)).trim();
                if (!(gender.equals("Male") || gender.equals("Female") || gender.equals("Others"))) {
                    throw new StudentException(new Message("genderNotFound", "Upload Failed : Gender can be Male/Female/Others in row " + i));
                }
                sex = gender;
                Date birthDate = null;
                if (formatter.formatCellValue((Cell)row.getCell(9)).isEmpty()) {
                    throw new StudentException(new Message("invalidDateFormat", "Upload Failed : Invalid Birth Date Format in row " + i + " correct format [eg:dd/MM/yyyy]"));
                }
                birthDate = date = new Date(formatter.formatCellValue((Cell)row.getCell(9)).trim());
                Category category = null;
                if (formatter.formatCellValue((Cell)row.getCell(10)).isEmpty()) throw new StudentException(new Message("categoryNotFound", "Upload Failed : Invalid Category in row " + i));
                category = this.categoryDAO.getCategoryByCategoryName(formatter.formatCellValue((Cell)row.getCell(10)).trim());
                if (category == null) {
                    throw new StudentException(new Message("categorynotfound", "Upload Failed : Invalid Category in row " + i));
                }
                BloodGroup bloodGroup = null;
                if (!formatter.formatCellValue((Cell)row.getCell(11)).isEmpty() && (bloodGroup = this.bloodGroupDAO.getBloodGroupByName(formatter.formatCellValue((Cell)row.getCell(11)).trim())) == null) {
                    bloodGroup = null;
                }
                AcademicYear joinedAcademicYear = null;
                if (formatter.formatCellValue((Cell)row.getCell(12)).isEmpty()) throw new StudentException(new Message("academicYearNotFound", "Upload Failed : Invalid Academic Year in row " + i));
                joinedAcademicYear = this.academicYearDAO.getAcademiYearByAcademicYearTitle(formatter.formatCellValue((Cell)row.getCell(12)).trim());
                if (joinedAcademicYear == null) {
                    throw new StudentException(new Message("academicyearNotFound", "Upload Failed : Invalid Academic Year in row " + i));
                }
                Class joinedClass = null;
                if (formatter.formatCellValue((Cell)row.getCell(13)).isEmpty()) throw new StudentException(new Message("joinedClassNotFound", "Upload Failed : You have to mention Joined Class in row " + i));
                joinedClass = this.classDAO.getClassByClassNameAndInstitution(formatter.formatCellValue((Cell)row.getCell(13)).trim(), institution);
                if (joinedClass == null) {
                    throw new StudentException(new Message("joinedClassNotFound", "Upload Failed : Invalid Joined Class in row " + i));
                }
                String parentGuardianFirstName = null;
                if (formatter.formatCellValue((Cell)row.getCell(14)).isEmpty()) {
                    throw new StudentException(new Message("parentOrGuardianFirstNameNotFound", "Upload Failed : You have to mention Parent or Guardian First Name in row " + i));
                }
                parentGuardianFirstName = formatter.formatCellValue((Cell)row.getCell(14)).trim();
                String parentGuardianLastName = "";
                if (!formatter.formatCellValue((Cell)row.getCell(15)).isEmpty()) {
                    parentGuardianLastName = formatter.formatCellValue((Cell)row.getCell(15)).trim();
                }
                String parentGuardianEmail = null;
                if (formatter.formatCellValue((Cell)row.getCell(16)).isEmpty()) {
                    throw new StudentException(new Message("parentEmailNotFound", "Upload Failed : You have to mention Parent or Guardian Email in row " + i));
                }
                parentGuardianEmail = formatter.formatCellValue((Cell)row.getCell(16)).trim();
                String addressLine1 = null;
                if (formatter.formatCellValue((Cell)row.getCell(17)).isEmpty()) {
                    throw new StudentException(new Message("addressLine1NotFound", "Upload Failed : You have to mention AddressLine1 in row " + i));
                }
                addressLine1 = formatter.formatCellValue((Cell)row.getCell(17)).trim();
                String addressLine2 = null;
                if (formatter.formatCellValue((Cell)row.getCell(18)).isEmpty()) {
                    throw new StudentException(new Message("addressLine2NotFound", "Upload Failed : You have to mention AddressLine2 in row " + i));
                }
                addressLine2 = formatter.formatCellValue((Cell)row.getCell(18)).trim();
                Long countryId = null;
                String country = null;
                if (!formatter.formatCellValue((Cell)row.getCell(19)).isEmpty()) {
                    GeographicalLocation geoGraphicalLocation = this.geographicalLocationDAO.getGeographicalLocationByName(formatter.formatCellValue((Cell)row.getCell(19)).trim());
                    if (geoGraphicalLocation == null) throw new StudentException(new Message("countryNotFound", "Upload Failed : Invalid Country in row " + i));
                    if (geoGraphicalLocation.getGeographicalLocationType() != 0) throw new StudentException(new Message("countryNotFound", "Upload Failed :" + formatter.formatCellValue((Cell)row.getCell(19)) + " is not a country in row " + i));
                    countryId = geoGraphicalLocation.getGeographicalLocationId();
                    country = geoGraphicalLocation.getName();
                }
                Long stateId = null;
                String state = null;
                if (!formatter.formatCellValue((Cell)row.getCell(20)).isEmpty()) {
                    GeographicalLocation geoGraphicalLocation = this.geographicalLocationDAO.getGeographicalLocationByName(formatter.formatCellValue((Cell)row.getCell(20)).trim());
                    if (geoGraphicalLocation == null) throw new StudentException(new Message("stateNotFound", "Upload Failed : Invalid State in row " + i));
                    if (geoGraphicalLocation.getGeographicalLocationType() != 1) throw new StudentException(new Message("stateNotFound", "Upload Failed :" + formatter.formatCellValue((Cell)row.getCell(20)) + " is not a state in row " + i));
                    if ((long)geoGraphicalLocation.getParentId() != countryId) throw new StudentException(new Message("stateNotFound", "Upload Failed :No such state for given country in row " + i));
                    stateId = geoGraphicalLocation.getGeographicalLocationId();
                    state = geoGraphicalLocation.getName();
                }
                String city = null;
                if (!formatter.formatCellValue((Cell)row.getCell(21)).isEmpty()) {
                    GeographicalLocation geoGraphicalLocation = this.geographicalLocationDAO.getGeographicalLocationByName(formatter.formatCellValue((Cell)row.getCell(21)).trim());
                    if (geoGraphicalLocation == null) throw new StudentException(new Message("stateNotFound", "Upload Failed : Invalid city in row " + i));
                    if (geoGraphicalLocation.getGeographicalLocationType() != 2) throw new StudentException(new Message("stateNotFound", "Upload Failed :" + formatter.formatCellValue((Cell)row.getCell(21)) + " is not a city in row " + i));
                    if ((long)geoGraphicalLocation.getParentId() != stateId) throw new StudentException(new Message("stateNotFound", "Upload Failed :No such city for given state in row " + i));
                    city = geoGraphicalLocation.getName();
                }
                String postcode = null;
                if (formatter.formatCellValue((Cell)row.getCell(22)).isEmpty()) {
                    throw new StudentException(new Message("postCodeNotFound", "Upload Failed : You have to mention PostCode in row " + i));
                }
                postcode = formatter.formatCellValue((Cell)row.getCell(22)).trim();
                String email = null;
                if (formatter.formatCellValue((Cell)row.getCell(23)).isEmpty()) {
                    throw new StudentException(new Message("studentEmailNotFound", "Upload Failed : You have to mention Student Email in row " + i));
                }
                email = formatter.formatCellValue((Cell)row.getCell(23)).trim();
                String contact = null;
                if (formatter.formatCellValue((Cell)row.getCell(24)).isEmpty()) {
                    throw new StudentException(new Message("studentContactNumberNotFound", "Upload Failed : You have to mention Student Contact Number in row " + i));
                }
                contact = formatter.formatCellValue((Cell)row.getCell(24)).trim();
                String parentContact = null;
                if (formatter.formatCellValue((Cell)row.getCell(25)).isEmpty()) {
                    throw new StudentException(new Message("parentContactNumberNotFound", "Upload Failed : You have to mention Parent Contact Number in row " + i));
                }
                parentContact = formatter.formatCellValue((Cell)row.getCell(25)).trim();
                Date joinedDate = null;
                if (formatter.formatCellValue((Cell)row.getCell(26)).isEmpty()) {
                    throw new StudentException(new Message("invalidDateFormat", "Upload Failed : Invalid Joined Date Format in row " + i + " correct format [eg:dd/MM/yyyy]"));
                }
                joinedDate = new Date(formatter.formatCellValue((Cell)row.getCell(26)).trim());
                Double fathersIncome = null;
                if (!formatter.formatCellValue((Cell)row.getCell(27)).isEmpty()) {
                    fathersIncome = Double.parseDouble(formatter.formatCellValue((Cell)row.getCell(27)).trim());
                }
                Double mothersIncome = null;
                if (!formatter.formatCellValue((Cell)row.getCell(28)).isEmpty()) {
                    mothersIncome = Double.parseDouble(formatter.formatCellValue((Cell)row.getCell(28)).trim());
                }
                String accessNo = null;
                if (!formatter.formatCellValue((Cell)row.getCell(29)).isEmpty()) {
                    accessNo = formatter.formatCellValue((Cell)row.getCell(29)).trim();
                }
                String passportNumber = null;
                if (!formatter.formatCellValue((Cell)row.getCell(30)).isEmpty()) {
                    passportNumber = formatter.formatCellValue((Cell)row.getCell(30)).trim();
                }
                Houses house = null;
                if (formatter.formatCellValue((Cell)row.getCell(31)).isEmpty()) throw new StudentException(new Message("houseNotFound", "Upload Failed : You have to mention House in row " + i));
                house = this.houseDAO.getHousesByNameAndInstitution(formatter.formatCellValue((Cell)row.getCell(31)).trim(), institution);
                if (house == null) {
                    throw new StudentException(new Message("houseNotFound", "Upload Failed : Invalid House in row " + i));
                }
                Long aadharCardNumber = null;
                if (!formatter.formatCellValue((Cell)row.getCell(32)).isEmpty()) {
                    aadharCardNumber = Long.parseLong(formatter.formatCellValue((Cell)row.getCell(32)).trim());
                }
                String photoPath = "/resources/themes/images/profile-pic/a.png";
                String scannedSignature = "/resources/themes/images/profile-pic/a.png";
                Student student = new Student(house, joinedAcademicYear, studentClass, section, joinedClass, category, specialCategory, studentStatus, firstName, lastName, parentGuardianFirstName, parentGuardianLastName, parentGuardianEmail, sex, birthDate, fathersIncome, mothersIncome, addressLine1, addressLine2, city, state, country, postcode, email, contact, passportNumber, joinedDate, scannedSignature, bloodGroup, accessNo, admissionNo, rollNo, parentContact, institution, createdBy, createdBy, aadharCardNumber);
                HashSet<UserRole> userRoles = new HashSet<UserRole>();
                userRoles.add(this.userRoleDAO.getUserRoleByTargetTypeAndInstitution(institution, "student"));
                String defaultPssword = "student";
                String hash = this.hashGenerator.encoder(defaultPssword);
                User user = new User(userRoles, String.valueOf(firstName) + " " + lastName, email, defaultPssword, createdBy, 1, hash, photoPath, institution);
                String parentProfilePath = "";
                parentProfilePath = "/resources/themes/images/profile-pic/a.png";
                String defaultParentPssword = "parent";
                HashSet<UserRole> parentUserRoles = new HashSet<UserRole>();
                parentUserRoles.add(this.userRoleDAO.getUserRoleByTargetTypeAndInstitution(institution, "parent"));
                String parentHash = this.hashGenerator.encoder(defaultPssword);
                User parentUser = new User(parentUserRoles, String.valueOf(parentGuardianFirstName) + " " + parentGuardianLastName, parentGuardianEmail, defaultParentPssword, createdBy, 1, parentHash, parentProfilePath, institution);
                student.setUser(user);
                student.setParentUser(parentUser);
                students.add(student);
            }
            for (Student student : students) {
                this.studentDAO.persist(student);
                this.userDAO.persist(student.getUser());
                this.userDAO.persist(student.getParentUser());
            }
            return i;
        }
        catch (IOException | ConstraintViolationException e) {
            if (e.getClass().equals(IOException.class)) {
                e.printStackTrace();
                throw new StudentException(new Message("fileError", "Excel File Not Found"));
            }
            if (e.getClass().equals(NullPointerException.class)) {
                e.printStackTrace();
                throw new StudentException(new Message("Null Value", "Fields Cannot be Blank"));
            }
            if (e.getClass().equals(ConstraintViolationException.class)) {
                e.printStackTrace();
                throw new StudentException(new Message("duplicateException", "Upload Failed: Check for Duplicates in Admission No, Roll No in same Class and Section or in email-id in the Excel"));
            }
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public void deleteListOfStudents(Long[] studentIds) {
        try {
            Long[] longArray = studentIds;
            int n = studentIds.length;
            int n2 = 0;
            while (n2 < n) {
                Long studentId = longArray[n2];
                Student student = this.studentDAO.getStudentById(studentId);
                if (student != null) {
                    this.studentDAO.delete(student);
                    log.info((Object)("Student with id=" + studentId + " has been deleted successfully"));
                }
                ++n2;
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in deleting Student", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Student> studentListByClassAndSectionAndAttendanceMonthEager(Class classs, Section section, Date attendanceMonth) throws StudentException {
        try {
            Date monthStartDate = new Date(attendanceMonth.getYear(), attendanceMonth.getMonth(), 1);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
            String startDate = formatter.format(monthStartDate);
            StudentStatus status = this.studentStatusDAO.getStudentStatusById(1L);
            List<Student> students = this.studentDAO.getStudentsByClassSectionAndStatus(classs, section, status);
            Integer studentsRecordSize = students.size();
            if (studentsRecordSize > 0) {
                for (Student student : students) {
                    LinkedHashSet<StudentAttendance> studentAttendances = new LinkedHashSet<StudentAttendance>();
                    Hibernate.initialize(student.getStudentAttendances());
                    for (StudentAttendance studentAttendance : student.getStudentAttendances()) {
                        Hibernate.initialize((Object)studentAttendance.getStudentAttendanceType());
                        formatter = new SimpleDateFormat("yyyy-MM-dd");
                        if (!formatter.format(studentAttendance.getStudentAttendanceDate()).contains(startDate)) continue;
                        studentAttendances.add(studentAttendance);
                    }
                    student.setStudentAttendances(studentAttendances);
                }
                log.info((Object)(studentsRecordSize + " student records reterived"));
            } else {
                log.info((Object)"No student Records found for given Class,Section,AttendanceMonth ");
            }
            return students;
        }
        catch (Exception e) {
            if (e.getClass().equals(NullPointerException.class)) {
                log.error((Object)"NullPointerException", e.getCause());
                throw new StudentException(new Message("nullpointer", e.getMessage()));
            }
            log.error((Object)("Exception in reteriving Student given Class=" + classs + ",Section=" + section + ",AttendanceMonth=" + attendanceMonth), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Student> studenListByClassAndSectionAndAttendanceFromDateAndToDateEager(Class classs, Section section, Date attendanceFromDate, Date attendanceToDate) throws StudentException, Exception {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            ArrayList<Date> dates = new ArrayList<Date>();
            LinkedHashSet<String> dates1 = new LinkedHashSet<String>();
            long interval = 86400000L;
            long endTime = attendanceToDate.getTime();
            long curTime = attendanceFromDate.getTime();
            while (curTime <= endTime) {
                dates.add(new Date(curTime));
                curTime += interval;
            }
            int i = 0;
            while (i < dates.size()) {
                Date lDate = (Date)dates.get(i);
                formatter = new SimpleDateFormat("yyyy-MM-dd");
                String ds = formatter.format(lDate);
                dates1.add(ds);
                ++i;
            }
            StudentStatus status = this.studentStatusDAO.getStudentStatusById(1L);
            List<Student> students = this.studentDAO.getStudentsByClassSectionAndStatus(classs, section, status);
            Integer studentsRecordSize = students.size();
            if (studentsRecordSize > 0) {
                for (Student student : students) {
                    LinkedHashSet<StudentAttendance> studentAttendances = new LinkedHashSet<StudentAttendance>();
                    Hibernate.initialize(student.getStudentAttendances());
                    for (StudentAttendance studentAttendance : student.getStudentAttendances()) {
                        Hibernate.initialize((Object)studentAttendance.getStudentAttendanceType());
                        if (!dates1.contains(formatter.format(studentAttendance.getStudentAttendanceDate()))) continue;
                        studentAttendances.add(studentAttendance);
                    }
                    student.setStudentAttendances(studentAttendances);
                }
                log.info((Object)(studentsRecordSize + " student records reterived"));
            } else {
                log.info((Object)"No student Records found for given Class,Section,AttendanceStartDate,AttendanceEndDate ");
            }
            return students;
        }
        catch (Exception e) {
            if (e.getClass().equals(NullPointerException.class)) {
                log.error((Object)"NullPointerException", e.getCause());
                throw new StudentException(new Message("nullpointer", e.getMessage()));
            }
            log.error((Object)("Exception in reteriving Student given Class=" + classs + ",Section=" + section + ",AttendanceStartDate=" + attendanceFromDate + ",AttendanceEndDate=" + attendanceToDate), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Student> activeStudentListByClassSectionModuleIdAndAttendanceFromDateAndToDateEager(Long classSectionModuleId, Date attendanceFromDate, Date attendanceToDate) throws StudentException, Exception {
        try {
            StudentStatus status;
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            ArrayList<Date> dates = new ArrayList<Date>();
            LinkedHashSet<String> dates1 = new LinkedHashSet<String>();
            long interval = 86400000L;
            long endTime = attendanceToDate.getTime();
            long curTime = attendanceFromDate.getTime();
            while (curTime <= endTime) {
                dates.add(new Date(curTime));
                curTime += interval;
            }
            int i = 0;
            while (i < dates.size()) {
                Date lDate = (Date)dates.get(i);
                formatter = new SimpleDateFormat("yyyy-MM-dd");
                String ds = formatter.format(lDate);
                dates1.add(ds);
                ++i;
            }
            ClassSectionModule classSectionModule = this.classSectionModuleDAO.getClassSectionModuleById(classSectionModuleId);
            Section section = classSectionModule.getClassSection().getSectionClass();
            Class clazz = classSectionModule.getClassSection().getClassSection();
            List<Student> students = this.studentDAO.getStudentsByClassSectionAndStatus(clazz, section, status = this.studentStatusDAO.getStudentStatusById(1L));
            Integer studentsRecordSize = students.size();
            if (studentsRecordSize > 0) {
                for (Student student : students) {
                    LinkedHashSet<StaffModuleAttendance> staffModuleAttendances = new LinkedHashSet<StaffModuleAttendance>();
                    Hibernate.initialize(student.getStaffModuleAttendances());
                    for (StaffModuleAttendance staffModuleAttendance : student.getStaffModuleAttendances()) {
                        Hibernate.initialize((Object)staffModuleAttendance.getStudentAttendanceType());
                        Hibernate.initialize((Object)staffModuleAttendance.getAcdemicYear());
                        if (!dates1.contains(formatter.format(staffModuleAttendance.getAttendanceDate()))) continue;
                        staffModuleAttendances.add(staffModuleAttendance);
                    }
                    student.setStaffModuleAttendances(staffModuleAttendances);
                }
                log.info((Object)(studentsRecordSize + " student records reterived"));
            } else {
                log.info((Object)"No student Records found for given Class,Section,AttendanceStartDate,AttendanceEndDate ");
            }
            return students;
        }
        catch (Exception e) {
            if (e.getClass().equals(NullPointerException.class)) {
                log.error((Object)"NullPointerException", e.getCause());
                throw new StudentException(new Message("nullpointer", e.getMessage()));
            }
            log.error((Object)("Exception in reteriving Student given ClassSectionModuleId=" + classSectionModuleId + ",AttendanceStartDate=" + attendanceFromDate + ",AttendanceEndDate=" + attendanceToDate), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Student> activeStudentListByClassSectionModuleAndAttendanceMonthEager(Long classSectionModuleId, Date attendanceMonth) throws StudentException {
        try {
            ClassSectionModule classSectionModule = this.classSectionModuleDAO.getClassSectionModuleById(classSectionModuleId);
            Section section = classSectionModule.getClassSection().getSectionClass();
            Class clazz = classSectionModule.getClassSection().getClassSection();
            StudentStatus status = this.studentStatusDAO.getStudentStatusById(1L);
            List<Student> students = this.studentDAO.getStudentsByClassSectionAndStatus(clazz, section, status);
            Date monthStartDate = new Date(attendanceMonth.getYear(), attendanceMonth.getMonth(), 1);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
            String startDate = formatter.format(monthStartDate);
            Integer studentsRecordSize = students.size();
            if (studentsRecordSize > 0) {
                for (Student student : students) {
                    LinkedHashSet<StaffModuleAttendance> staffModuleAttendances = new LinkedHashSet<StaffModuleAttendance>();
                    Hibernate.initialize(student.getStaffModuleAttendances());
                    for (StaffModuleAttendance staffModuleAttendance : student.getStaffModuleAttendances()) {
                        Hibernate.initialize((Object)staffModuleAttendance.getStudentAttendanceType());
                        Hibernate.initialize((Object)staffModuleAttendance.getAcdemicYear());
                        formatter = new SimpleDateFormat("yyyy-MM-dd");
                        if (!formatter.format(staffModuleAttendance.getAttendanceDate()).contains(startDate)) continue;
                        staffModuleAttendances.add(staffModuleAttendance);
                    }
                    student.setStaffModuleAttendances(staffModuleAttendances);
                }
                log.info((Object)(studentsRecordSize + " student records reterived"));
            } else {
                log.info((Object)"No student Records found for given ClassSectionModule,AttendanceMonth ");
            }
            return students;
        }
        catch (Exception e) {
            if (e.getClass().equals(NullPointerException.class)) {
                log.error((Object)"NullPointerException", e.getCause());
                throw new StudentException(new Message("nullpointer", e.getMessage()));
            }
            log.error((Object)("Exception in reteriving Student given ClassSectionModuleId=" + classSectionModuleId + ",AttendanceMonth=" + attendanceMonth), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void createStudentWithAdmission(Student student, User user, User parentUser, Admission admission) throws StudentException {
        try {
            User persistedParentUser = this.userDAO.save(parentUser);
            student.setUser(user);
            student.setParentUser(persistedParentUser);
            Student persistedstudent = this.studentDAO.save(student);
            user.setCommunicationFeedBackAndOthers(null);
            user.setCommunicationFeedBackAndOthersArchives(null);
            user.setCommunicationFeedBackAndOthersHistory(null);
            user.setCommunicationNotificationArchives(null);
            user.setCommunicationNotifications(null);
            user.setPortalMessages(null);
            user.setPortalNotifications(null);
            user.setPortalReplyMessages(null);
            user.setPortalTasks(null);
            this.userDAO.update(user);
            admission.setUser(null);
            this.admissionDAO.update(admission);
            Long studentId = persistedstudent.getStudentId();
            log.info((Object)("Student is created with the id=" + studentId));
        }
        catch (Exception e) {
            if (e.getClass().equals(ConstraintViolationException.class)) {
                ConstraintViolationException cve = (ConstraintViolationException)((Object)e);
                if (cve.getConstraintName().equals("email")) {
                    throw new StudentException(new Message("failure", "Student Cannot Be Created!! Duplicate Email Id "));
                }
            }
            log.error((Object)"Exception in Creating student", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<SevenFieldReports> studentListByAcademicYearAndClassAndSection(Class classes, Section section, AcademicYear academicYear) throws StudentException {
        try {
            ArrayList<SevenFieldReports> sevenFieldReports = new ArrayList<SevenFieldReports>();
            List<Object> students = new ArrayList();
            students = this.studentDAO.getStudentsByClassAndSection(classes, section);
            Integer studentsRecordSize = students.size();
            Long totalWorkingDays = academicYear.getTotalWorkingDays();
            DecimalFormat df = new DecimalFormat("#.##");
            if (studentsRecordSize > 0) {
                for (Student student : students) {
                    String admissionNumber = "";
                    String name = "";
                    Double precentCount = 0.0;
                    Integer absentCount = 0;
                    Integer ondutyCount = 0;
                    String percentageWithSymbol = "0%";
                    name = student.getLastName() != null ? String.valueOf(student.getFirstName()) + " " + student.getLastName() : student.getFirstName();
                    admissionNumber = student.getAdmissionNo();
                    LinkedHashSet<StudentAttendance> studentAttendances = new LinkedHashSet<StudentAttendance>();
                    Hibernate.initialize(student.getStudentAttendances());
                    for (StudentAttendance studentAttendance : student.getStudentAttendances()) {
                        Hibernate.initialize((Object)studentAttendance.getStudentClass());
                        Hibernate.initialize((Object)studentAttendance.getAcademicYear());
                        Hibernate.initialize((Object)studentAttendance.getSection());
                        if (studentAttendance.getAcademicYear().getAcademicYearId() != academicYear.getAcademicYearId() || studentAttendance.getStudentClass().getClassId() != classes.getClassId() || studentAttendance.getSection().getSectionId() != section.getSectionId()) continue;
                        Hibernate.initialize((Object)studentAttendance.getStudentAttendanceType());
                        studentAttendances.add(studentAttendance);
                        if (studentAttendance.getStudentAttendanceType().getStudentAttendaceTypeId() == 1L) {
                            if (studentAttendance.getDayAttendanceType().equals("HalfDay")) {
                                precentCount = precentCount + 0.5;
                                continue;
                            }
                            if (!studentAttendance.getDayAttendanceType().equals("FullDay")) continue;
                            precentCount = precentCount + 1.0;
                            continue;
                        }
                        if (studentAttendance.getStudentAttendanceType().getStudentAttendaceTypeId() == 2L) {
                            absentCount = absentCount + 1;
                            continue;
                        }
                        if (studentAttendance.getStudentAttendanceType().getStudentAttendaceTypeId() != 3L) continue;
                        ondutyCount = ondutyCount + 1;
                    }
                    student.setStudentAttendances(studentAttendances);
                    Double percentile = (precentCount + (double)ondutyCount.intValue()) / (double)totalWorkingDays.longValue();
                    Double percentage = percentile * 100.0;
                    if (!percentage.isNaN()) {
                        percentageWithSymbol = df.format(percentage).concat("%");
                    }
                    sevenFieldReports.add(new SevenFieldReports(admissionNumber, name, precentCount, absentCount, ondutyCount, totalWorkingDays, percentageWithSymbol));
                }
                log.info((Object)(studentsRecordSize + " student records reterived"));
            } else {
                log.info((Object)"No student Records found for given Class,Section,AcademicYear ");
            }
            return sevenFieldReports;
        }
        catch (Exception e) {
            if (e.getClass().equals(NullPointerException.class)) {
                log.error((Object)"NullPointerException", e.getCause());
                throw new StudentException(new Message("nullpointer", e.getMessage()));
            }
            log.error((Object)("Exception in reteriving Student given Class=" + classes + ",Section=" + section + ",AcademicYear=" + academicYear), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Student> activeStudentListByClassAndSectionAndInstitution(Long classId, Long sectionId, Long institutionId) throws StudentException {
        List<Student> students = new ArrayList<Student>();
        try {
            Class clazz = this.classDAO.getClassById(classId);
            Section section = this.sectionDAO.getSectionById(sectionId);
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            StudentStatus studentStatus = this.studentStatusDAO.getStudentStatusById(1L);
            students = this.studentDAO.getStudentsByStatusAndClassAndSectionAndInstitution(institution, studentStatus, clazz, section);
            Integer studentRecordSize = students.size();
            if (studentRecordSize > 0) {
                for (Student student : students) {
                    Hibernate.initialize((Object)student.getBloodGroup());
                    Hibernate.initialize((Object)student.getJoinedAcademicYear());
                    Hibernate.initialize((Object)student.getJoinedClass());
                    Hibernate.initialize((Object)student.getSection());
                    Hibernate.initialize(student.getSpecialCategories());
                    Hibernate.initialize((Object)student.getUser());
                    Hibernate.initialize(student.getUser().getUserRoles());
                    Hibernate.initialize((Object)student.getInstitution());
                    Hibernate.initialize((Object)student.getCategory());
                    Hibernate.initialize((Object)student.getStudentClass());
                    Hibernate.initialize((Object)student.getStudentStatus());
                    Hibernate.initialize((Object)student.getParentUser());
                    Hibernate.initialize(student.getParentUser().getUserRoles());
                    Hibernate.initialize((Object)student.getHouses());
                    Hibernate.initialize(student.getStudentLeaveRequistions());
                    Hibernate.initialize(student.getStudentMovementRequisitions());
                }
                log.info((Object)(studentRecordSize + " Student records where reterived"));
            } else {
                log.info((Object)"No Student Records found");
            }
            return students;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving active students by class and section and institution id", e.getCause());
            e.printStackTrace();
            return students;
        }
    }

    @Override
    public List<Student> studentListByClassAndSectionAndStudentStatusEager(Long classId, Long sectionId, Long studentStatusId) throws StudentException {
        try {
            Class classs = this.classDAO.getClassById(classId);
            Section section = this.sectionDAO.getSectionById(sectionId);
            StudentStatus studentStatus = this.studentStatusDAO.getStudentStatusById(studentStatusId);
            List<Student> students = this.studentDAO.getStudentsByClassAndSectionAndStatus(classs, section, studentStatus);
            Integer studentRecordSize = students.size();
            if (studentRecordSize > 0) {
                for (Student student : students) {
                    Hibernate.initialize((Object)student.getBloodGroup());
                    Hibernate.initialize((Object)student.getJoinedAcademicYear());
                    Hibernate.initialize((Object)student.getJoinedClass());
                    Hibernate.initialize((Object)student.getSection());
                    Hibernate.initialize(student.getSpecialCategories());
                    Hibernate.initialize((Object)student.getUser());
                    Hibernate.initialize(student.getUser().getUserRoles());
                    Hibernate.initialize((Object)student.getInstitution());
                    Hibernate.initialize((Object)student.getCategory());
                    Hibernate.initialize((Object)student.getStudentClass());
                    Hibernate.initialize((Object)student.getStudentStatus());
                    Hibernate.initialize((Object)student.getParentUser());
                    Hibernate.initialize(student.getParentUser().getUserRoles());
                    Hibernate.initialize((Object)student.getHouses());
                    Hibernate.initialize(student.getStudentLeaveRequistions());
                    Hibernate.initialize(student.getStudentMovementRequisitions());
                }
                log.info((Object)(studentRecordSize + " Student records of class " + classs.getClassName() + " and section" + section.getSectionName() + " with childs  where retrieved"));
            } else {
                log.info((Object)("No Student Records found for class " + classs.getClassName() + " and section" + section.getSectionName()));
            }
            return students;
        }
        catch (Exception e) {
            if (e.getClass().equals(NullPointerException.class)) {
                log.error((Object)"NullPointerException", e.getCause());
                throw new StudentException(new Message("nullpointer", e.getMessage()));
            }
            log.error((Object)"Exception in reteriving students with childs ", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Student studentListByClassAndSectionAndAdmissionNoAndStudentStatusEager(Long classId, Long sectionId, String admissionNo, Long studentStatusId) throws StudentException {
        try {
            Class classs = this.classDAO.getClassById(classId);
            Section section = this.sectionDAO.getSectionById(sectionId);
            StudentStatus studentStatus = this.studentStatusDAO.getStudentStatusById(studentStatusId);
            Student student = this.studentDAO.getStudentsByClassAndSectionAndAdmissionNoAndStatus(classs, section, admissionNo, studentStatus);
            if (student != null) {
                Hibernate.initialize((Object)student.getBloodGroup());
                Hibernate.initialize((Object)student.getJoinedAcademicYear());
                Hibernate.initialize((Object)student.getJoinedClass());
                Hibernate.initialize((Object)student.getSection());
                Hibernate.initialize(student.getSpecialCategories());
                Hibernate.initialize((Object)student.getUser());
                Hibernate.initialize(student.getUser().getUserRoles());
                Hibernate.initialize((Object)student.getInstitution());
                Hibernate.initialize((Object)student.getCategory());
                Hibernate.initialize((Object)student.getStudentClass());
                Hibernate.initialize((Object)student.getStudentStatus());
                Hibernate.initialize((Object)student.getParentUser());
                Hibernate.initialize(student.getParentUser().getUserRoles());
                Hibernate.initialize((Object)student.getHouses());
                Hibernate.initialize(student.getStudentLeaveRequistions());
                Hibernate.initialize(student.getStudentMovementRequisitions());
                log.info((Object)("Student with Class=" + classs.getClassName() + " and Section=" + section.getSectionName() + " AdmissionNo=" + admissionNo + " has been reterived"));
            } else {
                log.info((Object)("No Student with Class=" + classs.getClassName() + " and Section=" + section.getSectionName() + " AdmissionNo=" + admissionNo + " is available"));
            }
            return student;
        }
        catch (Exception e) {
            if (e.getClass().equals(NullPointerException.class)) {
                log.error((Object)"NullPointerException", e.getCause());
                throw new StudentException(new Message("nullpointer", e.getMessage()));
            }
            log.error((Object)"Exception in reteriving students with childs ", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Student> studentsByClassSectionAndSpecialCategoryAndStudentStatus(Long classId, Long sectionId, Long specialCategoryId, Long studentStatusId) {
        List<Student> studentList = null;
        try {
            Class clazz = this.classDAO.getClassById(classId);
            Section section = this.sectionDAO.getSectionById(sectionId);
            StudentStatus studentStatus = this.studentStatusDAO.getStudentStatusById(studentStatusId);
            SpecialCategory specialCategory = this.specialCategoryDAO.getSpecialCategoryById(specialCategoryId);
            studentList = this.studentDAO.getStudentsByClassSectionAndSpecialCategoryAndStatus(clazz, section, specialCategory, studentStatus);
            return studentList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving  students by class section and special category", e.getCause());
            e.printStackTrace();
            return studentList;
        }
    }

    @Override
    public void promoteListOfStudents(Long[] studentIds, Class classes, Section section) {
        try {
            Long[] longArray = studentIds;
            int n = studentIds.length;
            int n2 = 0;
            while (n2 < n) {
                Long studentId = longArray[n2];
                Student student = this.studentDAO.getStudentById(studentId);
                if (student != null) {
                    student.setStudentClass(classes);
                    student.setSection(section);
                    student.setInstitution(classes.getInstitution());
                    this.studentDAO.update(student);
                    log.info((Object)("Student with id=" + studentId + " has been promoted successfully"));
                }
                ++n2;
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in update Student Class And Section", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Set<StudentLeaveRequisition> studentLeaveRequests(String studentEMail) throws StudentException {
        User user = this.userDAO.getUserByEmail(studentEMail);
        Hibernate.initialize(user.getStudent().getStudentLeaveRequistions());
        Set<StudentLeaveRequisition> studentLeaveRequests = user.getStudent().getStudentLeaveRequistions();
        Iterator<StudentLeaveRequisition> studentLeaveRequisitions = studentLeaveRequests.iterator();
        while (studentLeaveRequisitions.hasNext()) {
            StudentLeaveRequisition studentLeaveRequisition = studentLeaveRequisitions.next();
            if (studentLeaveRequisition.getApprovalStatus().equals("Pending")) {
                Hibernate.initialize((Object)studentLeaveRequisition.getStudentLeaveType());
                Hibernate.initialize((Object)studentLeaveRequisition.getRequisitionType());
                continue;
            }
            studentLeaveRequisitions.remove();
        }
        return studentLeaveRequests;
    }

    @Override
    public Set<StudentLeaveRequisition> studentLeaveRequestApprovedAndRejectedLists(String studentEMail) throws StudentException {
        User user = this.userDAO.getUserByEmail(studentEMail);
        Hibernate.initialize(user.getStudent().getStudentLeaveRequistions());
        Set<StudentLeaveRequisition> studentLeaveRequests = user.getStudent().getStudentLeaveRequistions();
        LinkedHashSet<StudentLeaveRequisition> addstudentLeaveRequests = new LinkedHashSet<StudentLeaveRequisition>();
        for (StudentLeaveRequisition studentLeaveRequisition : studentLeaveRequests) {
            if (!studentLeaveRequisition.getApprovalStatus().equals("Approved") && !studentLeaveRequisition.getApprovalStatus().equals("Rejected")) continue;
            Hibernate.initialize((Object)studentLeaveRequisition.getStudentLeaveType());
            addstudentLeaveRequests.add(studentLeaveRequisition);
            Hibernate.initialize((Object)studentLeaveRequisition.getRequisitionType());
        }
        return addstudentLeaveRequests;
    }

    @Override
    public Set<StudentLeaveRequisition> studentLeaveApprovals(String studentEMail) throws StudentException {
        try {
            User user = this.userDAO.getUserByEmail(studentEMail);
            Hibernate.initialize(user.getStaffLeaveRequistions());
            Set<StudentLeaveRequisition> studentLeaveRequisitions = user.getStudentLeaveRequistions();
            Iterator<StudentLeaveRequisition> approvals = studentLeaveRequisitions.iterator();
            while (approvals.hasNext()) {
                StudentLeaveRequisition studentLeaveRequisition = approvals.next();
                if (studentLeaveRequisition.getApprovalStatus().equals("Pending")) {
                    Hibernate.initialize((Object)studentLeaveRequisition.getStudentLeaveType());
                    Hibernate.initialize((Object)studentLeaveRequisition.getStudent());
                    Hibernate.initialize((Object)studentLeaveRequisition.getRequisitionType());
                    continue;
                }
                approvals.remove();
            }
            return studentLeaveRequisitions;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Set<StudentMovementRequisition> studentMovementRequests(String studentEMail) throws StudentException {
        User user = this.userDAO.getUserByEmail(studentEMail);
        Hibernate.initialize(user.getStudent().getStudentMovementRequisitions());
        Set<StudentMovementRequisition> studentMovementRequests = user.getStudent().getStudentMovementRequisitions();
        Iterator<StudentMovementRequisition> studentMovementRequisitions = studentMovementRequests.iterator();
        while (studentMovementRequisitions.hasNext()) {
            StudentMovementRequisition studentMovementRequisition = studentMovementRequisitions.next();
            if (studentMovementRequisition.getApprovalStatus().equals("Pending")) {
                Hibernate.initialize((Object)studentMovementRequisition.getRequisitionType());
                continue;
            }
            studentMovementRequisitions.remove();
        }
        return studentMovementRequests;
    }

    @Override
    public Set<StudentMovementRequisition> studentMovementRequestApprovedAndRejectedLists(String studentEMail) throws StudentException {
        User user = this.userDAO.getUserByEmail(studentEMail);
        Hibernate.initialize(user.getStudent().getStudentMovementRequisitions());
        Set<StudentMovementRequisition> studentMovementRequests = user.getStudent().getStudentMovementRequisitions();
        LinkedHashSet<StudentMovementRequisition> addstudentMovementRequests = new LinkedHashSet<StudentMovementRequisition>();
        for (StudentMovementRequisition studentMovementRequisition : studentMovementRequests) {
            if (!studentMovementRequisition.getApprovalStatus().equals("Approved") && !studentMovementRequisition.getApprovalStatus().equals("Rejected")) continue;
            addstudentMovementRequests.add(studentMovementRequisition);
            Hibernate.initialize((Object)studentMovementRequisition.getRequisitionType());
        }
        return addstudentMovementRequests;
    }

    @Override
    public Set<StudentMovementRequisition> studentMovementApprovals(String studentEMail) throws StudentException {
        try {
            User user = this.userDAO.getUserByEmail(studentEMail);
            Hibernate.initialize(user.getStudentMovementRequisitions());
            Set<StudentMovementRequisition> studentMovementRequisitions = user.getStudentMovementRequisitions();
            Iterator<StudentMovementRequisition> approvals = studentMovementRequisitions.iterator();
            while (approvals.hasNext()) {
                StudentMovementRequisition studentMovementRequisition = approvals.next();
                if (studentMovementRequisition.getApprovalStatus().equals("Pending")) {
                    Hibernate.initialize((Object)studentMovementRequisition.getStudent());
                    Hibernate.initialize((Object)studentMovementRequisition.getRequisitionType());
                    continue;
                }
                approvals.remove();
            }
            return studentMovementRequisitions;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Student> activeStudentsInAllClassWithoutInvoiceGeneratedFromAllInstituions() {
        ArrayList<Student> students = new ArrayList<Student>();
        try {
            List classes = this.classDAO.getList();
            for (Class clazz : classes) {
                Set<ClassSection> classSections = clazz.getClassSections();
                for (ClassSection classSection : classSections) {
                    ArrayList students1 = (ArrayList)this.studentDAO.getStudentsByClassAndSection(clazz, classSection.getSectionClass());
                    Iterator iterator = students1.iterator();
                    while (iterator.hasNext()) {
                        Student student = (Student)iterator.next();
                        if (student.getStudentStatus().getStudentStatusId() != 1L) {
                            iterator.remove();
                            continue;
                        }
                        students.add(student);
                    }
                }
            }
            return students;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving active students by all class without invoice generated", e.getCause());
            e.printStackTrace();
            return students;
        }
    }

    @Override
    public List<Student> activeStudentsFromAllClassBySpecialCategoryWithoutInvoiceGenerated(Long specialCategoryId) {
        ArrayList<Student> students = null;
        try {
            SpecialCategory specialCategory = this.specialCategoryDAO.getSpecialCategoryById(specialCategoryId);
            StudentStatus studentStatus = this.studentStatusDAO.getStudentStatusById(1L);
            students = new ArrayList<Student>(this.studentDAO.getStudentsBySpecialCategoryAndStatus(specialCategory, studentStatus));
            for (Student student : students) {
                Hibernate.initialize((Object)student.getStudentClass());
                Hibernate.initialize((Object)student.getSection());
            }
            return students;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving active students without invoice generated by all class and specific special category ", e.getCause());
            e.printStackTrace();
            return students;
        }
    }

    @Override
    public List<Student> studentsBySpecialCategoryEager(Long specialCategoryId) {
        List<Student> studentList = null;
        try {
            SpecialCategory specialCategory = this.specialCategoryDAO.getSpecialCategoryById(specialCategoryId);
            studentList = this.studentDAO.getStudentsBySpecialCategory(specialCategory);
            for (Student student : studentList) {
                Hibernate.initialize((Object)student.getJoinedAcademicYear());
                Hibernate.initialize((Object)student.getCategory());
                Hibernate.initialize((Object)student.getStudentStatus());
                Hibernate.initialize((Object)student.getBloodGroup());
                Hibernate.initialize((Object)student.getUser());
                Hibernate.initialize((Object)student.getParentUser());
                Hibernate.initialize((Object)student.getInstitution());
                Hibernate.initialize((Object)student.getStudentClass());
                Hibernate.initialize((Object)student.getJoinedClass());
                Hibernate.initialize((Object)student.getSection());
                Hibernate.initialize(student.getSpecialCategories());
                Hibernate.initialize(student.getStaffModuleAttendances());
                Hibernate.initialize(student.getInvoices());
                Hibernate.initialize(student.getStudentReceipts());
                Hibernate.initialize((Object)student.getHouses());
                Hibernate.initialize(student.getStudentLeaveRequistions());
                Hibernate.initialize(student.getStudentMovementRequisitions());
            }
            return studentList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving  students with childs by special category", e.getCause());
            e.printStackTrace();
            return studentList;
        }
    }

    @Override
    public void updateStudentProfileAndDocuments(Student student, User user, Set<Document> documents) throws Exception {
        try {
            for (Document document : student.getDocuments()) {
                this.documentDAO.delete(document);
            }
            this.userDAO.saveOrUpdate(user);
            student.setDocuments(null);
            this.studentDAO.saveOrUpdate(student);
            for (Document document : documents) {
                if (this.documentDAO.getDocumentByDocumentTypeAndStudent(document.getDocumentType(), student) == null) {
                    document.setStudent(student);
                    this.documentDAO.save(document);
                    continue;
                }
                throw new StudentException(new Message("failure", "Cannot Upload Duplicate Document Type"));
            }
            Long studentId = student.getStudentId();
            if (studentId != null) {
                log.info((Object)("Student with id=" + studentId + " has been updated"));
            } else {
                log.info((Object)"New Student has been added, because no Student found for update");
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in updating student", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateStudent(Student student, User user, User parentUser, Set<Document> documents) throws Exception {
        try {
            for (Document document : student.getDocuments()) {
                this.documentDAO.delete(document);
            }
            this.userDAO.saveOrUpdate(user);
            student.setDocuments(null);
            this.studentDAO.saveOrUpdate(student);
            for (Document document : documents) {
                if (this.documentDAO.getDocumentByDocumentTypeAndStudent(document.getDocumentType(), student) == null) {
                    document.setStudent(student);
                    this.documentDAO.save(document);
                    continue;
                }
                throw new StudentException(new Message("failure", "Cannot Upload Duplicate Document Type"));
            }
            Long studentId = student.getStudentId();
            if (studentId != null) {
                log.info((Object)("Student with id=" + studentId + " has been updated"));
            } else {
                log.info((Object)"New Student has been added, because no Student found for update");
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in updating student", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }
}
