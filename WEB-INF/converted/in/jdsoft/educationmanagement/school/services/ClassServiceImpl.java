/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.Hibernate
 *  org.hibernate.exception.ConstraintViolationException
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.components.ExceptionComparator;
import in.jdsoft.educationmanagement.school.dao.ClassDAO;
import in.jdsoft.educationmanagement.school.dao.ClassSectionAssesmentTypeDAO;
import in.jdsoft.educationmanagement.school.dao.ClassSectionCoScholasticActivityDAO;
import in.jdsoft.educationmanagement.school.dao.ClassSectionCoScholasticAreaDAO;
import in.jdsoft.educationmanagement.school.dao.ClassSectionDAO;
import in.jdsoft.educationmanagement.school.dao.ClassSectionModuleDAO;
import in.jdsoft.educationmanagement.school.dao.ClassSectionModuleSkillDAO;
import in.jdsoft.educationmanagement.school.dao.ClassSectionModuleStaffDAO;
import in.jdsoft.educationmanagement.school.dao.ClassSectionTermDAO;
import in.jdsoft.educationmanagement.school.dao.ClassSectionTermExamDAO;
import in.jdsoft.educationmanagement.school.dao.InstitutionDAO;
import in.jdsoft.educationmanagement.school.dao.StudentDAO;
import in.jdsoft.educationmanagement.school.exceptions.ClassAndSectionException;
import in.jdsoft.educationmanagement.school.exceptions.ClassException;
import in.jdsoft.educationmanagement.school.model.AdmissionConfig;
import in.jdsoft.educationmanagement.school.model.Class;
import in.jdsoft.educationmanagement.school.model.ClassSection;
import in.jdsoft.educationmanagement.school.model.ClassSectionAssesmentType;
import in.jdsoft.educationmanagement.school.model.ClassSectionCoScholasticActivity;
import in.jdsoft.educationmanagement.school.model.ClassSectionCoScholasticArea;
import in.jdsoft.educationmanagement.school.model.ClassSectionModule;
import in.jdsoft.educationmanagement.school.model.ClassSectionModuleSkill;
import in.jdsoft.educationmanagement.school.model.ClassSectionModuleStaff;
import in.jdsoft.educationmanagement.school.model.ClassSectionTerm;
import in.jdsoft.educationmanagement.school.model.ClassSectionTermExam;
import in.jdsoft.educationmanagement.school.model.ExamTemplate;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.Section;
import in.jdsoft.educationmanagement.school.model.Staff;
import in.jdsoft.educationmanagement.school.model.Term;
import in.jdsoft.educationmanagement.school.model.TermExam;
import in.jdsoft.educationmanagement.school.reports.model.FourFieldReport;
import in.jdsoft.educationmanagement.school.reports.model.ThreeFieldReports;
import in.jdsoft.educationmanagement.school.services.ClassService;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Hibernate;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="classService")
public class ClassServiceImpl
implements ClassService {
    @Autowired
    private ClassDAO classDAO;
    @Autowired
    private InstitutionDAO institutionDAO;
    @Autowired
    private ClassSectionDAO classSectionDAO;
    @Autowired
    private ClassSectionTermDAO classSectionTermDAO;
    @Autowired
    private ClassSectionAssesmentTypeDAO classSectionAssesmentTypeDAO;
    @Autowired
    private ClassSectionTermExamDAO classSectionTermExamDAO;
    @Autowired
    private ClassSectionModuleDAO classSectionModuleDAO;
    @Autowired
    private ClassSectionCoScholasticActivityDAO ClassSectionCoScholasticActivityDAO;
    @Autowired
    private ClassSectionCoScholasticAreaDAO classSectionCoScholasticAreaDAO;
    @Autowired
    private ClassSectionModuleSkillDAO classSectionModuleSkillDAO;
    @Autowired
    private ClassSectionModuleStaffDAO classSectionModuleStaffDAO;
    @Autowired
    private StudentDAO studentDAO;
    @Autowired
    ExceptionComparator exceptionComparator;

    @Override
    public Long createClass(Class className) throws ClassException {
        try {
            Class persistedclass = this.classDAO.save(className);
            Long classId = persistedclass.getClassId();
            log.info((Object)("Class is created with the id=" + classId));
            return classId;
        }
        catch (Exception e) {
            if (e.getClass().equals(ConstraintViolationException.class)) {
                String valid = this.exceptionComparator.containsWord(e.getMessage());
                if (valid != null) {
                    throw new ClassException(new Message("duplicate", "Cannot Create Duplicate Class"));
                }
                throw e;
            }
            throw e;
        }
    }

    @Override
    public void deleteClass(Long classId) {
        try {
            Class clazz = this.classDAO.getClassById(classId);
            if (clazz != null) {
                this.classDAO.delete(clazz);
                log.info((Object)("Class with id=" + classId + " has been deleted successfully"));
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in deleting Class", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Class> classList() {
        try {
            List<Class> classList = this.classDAO.getList();
            Integer classListSize = classList.size();
            if (classListSize > 0) {
                for (Class clazz : classList) {
                    Hibernate.initialize((Object)clazz.getInstitution().getInstitutionCode());
                }
                log.info((Object)(classListSize + "class records where reterived"));
            } else {
                log.info((Object)"No class(s) available");
            }
            return classList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving class list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Class> classList(Long institutionId) throws ClassException {
        try {
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            if (institution != null) {
                List<Class> classs = this.classDAO.getClasssByInstitution(institution);
                for (Class clazz : classs) {
                    Hibernate.initialize(clazz.getClassSections());
                }
                Integer classRecordSize = classs.size();
                if (classRecordSize > 0) {
                    log.info((Object)(classRecordSize + " class records of institution " + institution.getInstitutionAliasName() + " where reterived"));
                } else {
                    log.info((Object)("No class Records found for institution " + institution.getInstitutionAliasName()));
                }
                return classs;
            }
            throw new NullPointerException("Invalid Institution Id");
        }
        catch (Exception e) {
            if (e.getClass().equals(NullPointerException.class)) {
                log.error((Object)"NullPointerException", e.getCause());
                throw new ClassException(new Message("nullpointer", e.getMessage()));
            }
            log.error((Object)"Exception in reteriving class's of Institution", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Class> classListEager(Long institutionId) throws ClassException {
        try {
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            if (institution != null) {
                List<Class> clazzz = this.classDAO.getClasssByInstitution(institution);
                Integer classRecordSize = clazzz.size();
                if (classRecordSize > 0) {
                    for (Class clazz : clazzz) {
                        Hibernate.initialize(clazz.getClassSections());
                        Hibernate.initialize(clazz.getJoinedStudents());
                        Hibernate.initialize(clazz.getStudents());
                        Hibernate.initialize((Object)clazz.getClassName());
                        Hibernate.initialize((Object)clazz.getInstitution());
                    }
                    log.info((Object)(classRecordSize + " class records of institution " + institution.getInstitutionAliasName() + " with childs  where reterived"));
                } else {
                    log.info((Object)("No class Records found for institution " + institution.getInstitutionAliasName()));
                }
                return clazzz;
            }
            throw new NullPointerException("Invalid Institution Id");
        }
        catch (Exception e) {
            if (e.getClass().equals(NullPointerException.class)) {
                log.error((Object)"NullPointerException", e.getCause());
                throw new ClassException(new Message("nullpointer", e.getMessage()));
            }
            log.error((Object)"Exception in reteriving class's with childs of Institution", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Class classById(Long classId) {
        try {
            Class clazz = this.classDAO.getClassById(classId);
            if (clazz != null) {
                Hibernate.initialize(clazz.getClassSections());
                for (ClassSection classsections : clazz.getClassSections()) {
                    Hibernate.initialize((Object)classsections.getClassStaff());
                }
                log.info((Object)("class with id=" + classId + " has been reterived"));
                return clazz;
            }
            log.info((Object)("No class with  id=" + classId + " is available"));
            return clazz;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving class by id=" + classId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void update(Class clazz) {
        try {
            this.classDAO.saveOrUpdate(clazz);
            Long clazzId = clazz.getClassId();
            if (clazzId != null) {
                log.info((Object)("class with id=" + clazzId + " has been updated"));
            } else {
                log.info((Object)"New class has been added, because no class found for update");
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in updating class", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Class> classzByExamConfigStatusEager(Long institutionId, Integer classExamConfigStatus) throws ClassException {
        try {
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            if (institution != null) {
                List<Class> classLists = this.classDAO.getClasszByExamConfigStatus(institution, classExamConfigStatus);
                Integer classRecordSize = classLists.size();
                if (classRecordSize > 0) {
                    for (Class clazz : classLists) {
                        for (ClassSection sections : clazz.getClassSections()) {
                            Hibernate.initialize((Object)sections.getSectionClass().getSectionName());
                        }
                        Hibernate.initialize(clazz.getJoinedStudents());
                        Hibernate.initialize(clazz.getStudents());
                        Hibernate.initialize((Object)clazz.getClassName());
                        Hibernate.initialize((Object)clazz.getInstitution());
                    }
                }
                return classLists;
            }
            throw new NullPointerException("Institution Id Not Found");
        }
        catch (Exception e) {
            if (e.getClass().equals(NullPointerException.class)) {
                log.error((Object)"NullPointerException", e.getCause());
                throw new ClassException(new Message("nullpointer", e.getMessage()));
            }
            log.error((Object)"Exception in reteriving class's with childs of Institution and Exam Config Status", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Set<AdmissionConfig> getAdmissionConfigByClassId(Long classId) {
        LinkedHashSet<AdmissionConfig> addAdmissionConfig = new LinkedHashSet<AdmissionConfig>();
        Class classz = this.classDAO.getClassById(classId);
        Hibernate.initialize(classz.getAdmissionConfigs());
        for (AdmissionConfig admissionConfig : classz.getAdmissionConfigs()) {
            Hibernate.initialize((Object)admissionConfig);
            addAdmissionConfig.add(admissionConfig);
        }
        return addAdmissionConfig;
    }

    @Override
    public Long configureClassWithAssessmentType(Class clazz, Section section, ExamTemplate examTemplate, Staff classStaff, Set<ClassSectionAssesmentType> classSectionAssesmentTypes, Set<ClassSectionModule> classSectionModules, Set<ClassSectionCoScholasticActivity> classSectionCoScholasticActivitys, Set<ClassSectionCoScholasticArea> classSectionCoScholasticAreas, Set<ClassSectionModule> classSectionModuleWithSkills) throws Exception {
        try {
            ClassSection classSection = this.classSectionDAO.save(new ClassSection(clazz, section, classStaff, 1));
            LinkedHashSet<Term> terms = new LinkedHashSet<Term>(examTemplate.getTerms());
            for (Term term : terms) {
                String termName = term.getTermName();
                ClassSectionTerm classSectionTerm = new ClassSectionTerm(classSection, termName);
                this.classSectionTermDAO.persist(classSectionTerm);
                LinkedHashSet<TermExam> termExams = new LinkedHashSet<TermExam>(term.getTermExams());
                for (TermExam termExam : termExams) {
                    Double classSectionTermExamPercentage = termExam.getTermPercentege();
                    String classSectionTermExamName = termExam.getTermExamName();
                    ClassSectionTermExam classSectionTermExam = new ClassSectionTermExam(classSectionTerm, classSectionTermExamName, classSectionTermExamPercentage);
                    this.classSectionTermExamDAO.persist(classSectionTermExam);
                }
            }
            for (ClassSectionAssesmentType classSectionAssesmentType : classSectionAssesmentTypes) {
                ClassSectionAssesmentType classSectionAssesmentTypeObj = new ClassSectionAssesmentType(classSectionAssesmentType.getClassSectionAssesmentName(), classSectionAssesmentType.isGradeMethod(), classSectionAssesmentType.getGradeSystem(), classSectionAssesmentType.getAssessmentLimit());
                classSectionAssesmentTypeObj.setClassSection(classSection);
                this.classSectionAssesmentTypeDAO.persist(classSectionAssesmentTypeObj);
            }
            for (ClassSectionModule classSectionModule : classSectionModules) {
                ClassSectionModuleStaff classSectionModuleStaff = classSectionModule.getClassSectionModuleStaff();
                ClassSectionModule classSectionModuleObj = new ClassSectionModule(classSectionModule.getModule(), classSectionModule.isSkillBased());
                classSectionModuleObj.setClassSection(classSection);
                classSectionModuleObj.setStatus(1);
                ClassSectionModule persistedClassSectionModule = this.classSectionModuleDAO.save(classSectionModuleObj);
                ClassSectionModuleStaff classSectionModuleStaffObj = new ClassSectionModuleStaff(persistedClassSectionModule, classSectionModuleStaff.getStaff(), classSectionModuleStaff.getAcademicYear());
                classSectionModuleStaffObj.setClassSectionModule(persistedClassSectionModule);
                this.classSectionModuleStaffDAO.persist(classSectionModuleStaffObj);
            }
            for (ClassSectionCoScholasticActivity classSectionCoScholasticActivity : classSectionCoScholasticActivitys) {
                ClassSectionCoScholasticActivity classSectionCoScholasticActivityObj = new ClassSectionCoScholasticActivity(classSectionCoScholasticActivity.getCoScholasticActivity());
                classSectionCoScholasticActivityObj.setClassSection(classSection);
                this.ClassSectionCoScholasticActivityDAO.persist(classSectionCoScholasticActivityObj);
            }
            for (ClassSectionCoScholasticArea classSectionCoScholasticArea : classSectionCoScholasticAreas) {
                ClassSectionCoScholasticArea classSectionCoScholasticAreaObj = new ClassSectionCoScholasticArea(classSectionCoScholasticArea.getCoScholasticArea());
                classSectionCoScholasticAreaObj.setClassSection(classSection);
                this.classSectionCoScholasticAreaDAO.persist(classSectionCoScholasticAreaObj);
            }
            for (ClassSectionModule classSectionWithSkill : classSectionModuleWithSkills) {
                ClassSectionModuleStaff classSectionModuleStaff = classSectionWithSkill.getClassSectionModuleStaff();
                ClassSectionModule classSectionWithSkillObj = new ClassSectionModule(classSectionWithSkill.getModule(), classSectionWithSkill.isSkillBased());
                classSectionWithSkillObj.setStatus(1);
                classSectionWithSkillObj.setClassSection(classSection);
                classSectionWithSkillObj = this.classSectionModuleDAO.save(classSectionWithSkillObj);
                ClassSectionModuleStaff classSectionModuleStaffObj = new ClassSectionModuleStaff(classSectionWithSkillObj, classSectionModuleStaff.getStaff(), classSectionModuleStaff.getAcademicYear());
                classSectionModuleStaffObj.setClassSectionModule(classSectionWithSkillObj);
                this.classSectionModuleStaffDAO.persist(classSectionModuleStaffObj);
                for (ClassSectionModuleSkill classSectionModuleSkill : classSectionWithSkill.getClassSectionModuleSkills()) {
                    ClassSectionModuleSkill classSectionModuleSkillObj = new ClassSectionModuleSkill(classSectionWithSkillObj, classSectionModuleSkill.getModuleSkill());
                    this.classSectionModuleSkillDAO.persist(classSectionModuleSkillObj);
                }
            }
            Class setConfigure = this.classDAO.getClassById(clazz.getClassId());
            setConfigure.setClassExamConfigStatus(1);
            return classSection.getClassSectionId();
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public ThreeFieldReports getStudentRatioFromClass(Long classId) {
        Class studentClass = this.classDAO.getClassById(classId);
        Integer femaleCount = this.studentDAO.getFemaleStudentCountInClass(studentClass);
        Integer maleCount = this.studentDAO.getMaleStudentCountInClass(studentClass);
        Integer othersCount = this.studentDAO.getOtherStudentCountInClass(studentClass);
        return new ThreeFieldReports(maleCount, femaleCount, othersCount);
    }

    @Override
    public List<FourFieldReport> getStudentRatioFromClassByInstitution(Long institutionId) {
        ArrayList<FourFieldReport> threeFieldReports = new ArrayList<FourFieldReport>();
        Institution institution = this.institutionDAO.getInstitutionById(institutionId);
        Hibernate.initialize(institution.getClasses());
        if (!institution.getClasses().isEmpty()) {
            for (Class classes : institution.getClasses()) {
                Class studentClass = this.classDAO.getClassById(classes.getClassId());
                Integer femaleCount = this.studentDAO.getFemaleStudentCountInClass(studentClass);
                Integer maleCount = this.studentDAO.getMaleStudentCountInClass(studentClass);
                Integer othersCount = this.studentDAO.getOtherStudentCountInClass(studentClass);
                threeFieldReports.add(new FourFieldReport(maleCount, femaleCount, othersCount, studentClass.getClassName()));
            }
        }
        return threeFieldReports;
    }

    @Override
    public void updateClassSection(Class clazz, Set<Section> classSections, Staff staff) {
        try {
            for (ClassSection classSection : clazz.getClassSections()) {
                this.classSectionDAO.delete(classSection);
            }
            this.classDAO.saveOrUpdate(clazz);
            for (Section section : classSections) {
                if (this.classSectionDAO.getClasssSectionByClassAndSection(clazz, section) == null) {
                    this.classSectionDAO.save(new ClassSection(clazz, section, staff, 1));
                    continue;
                }
                throw new ClassAndSectionException(new Message("failure", "Already Class And Section Exist"));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
