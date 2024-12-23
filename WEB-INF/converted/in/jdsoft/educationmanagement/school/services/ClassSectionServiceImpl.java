/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.Hibernate
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.components.ExceptionComparator;
import in.jdsoft.educationmanagement.school.dao.ClassDAO;
import in.jdsoft.educationmanagement.school.dao.ClassSectionCoScholasticActivityDAO;
import in.jdsoft.educationmanagement.school.dao.ClassSectionCoScholasticActivityExamDAO;
import in.jdsoft.educationmanagement.school.dao.ClassSectionCoScholasticAreaDAO;
import in.jdsoft.educationmanagement.school.dao.ClassSectionCoScholasticAreaExamDAO;
import in.jdsoft.educationmanagement.school.dao.ClassSectionDAO;
import in.jdsoft.educationmanagement.school.dao.ClassSectionModuleDAO;
import in.jdsoft.educationmanagement.school.dao.ClassSectionModuleExamDAO;
import in.jdsoft.educationmanagement.school.dao.ClassSectionModuleSkillDAO;
import in.jdsoft.educationmanagement.school.dao.ClassSectionModuleSkillExamDAO;
import in.jdsoft.educationmanagement.school.dao.ClassSectionTermExamActivityDAO;
import in.jdsoft.educationmanagement.school.dao.SectionDAO;
import in.jdsoft.educationmanagement.school.dao.StaffDAO;
import in.jdsoft.educationmanagement.school.exceptions.ClassAndSectionException;
import in.jdsoft.educationmanagement.school.model.Class;
import in.jdsoft.educationmanagement.school.model.ClassSection;
import in.jdsoft.educationmanagement.school.model.ClassSectionAssesmentType;
import in.jdsoft.educationmanagement.school.model.ClassSectionCoScholasticActivity;
import in.jdsoft.educationmanagement.school.model.ClassSectionCoScholasticActivityExam;
import in.jdsoft.educationmanagement.school.model.ClassSectionCoScholasticArea;
import in.jdsoft.educationmanagement.school.model.ClassSectionCoScholasticAreaExam;
import in.jdsoft.educationmanagement.school.model.ClassSectionModule;
import in.jdsoft.educationmanagement.school.model.ClassSectionModuleExam;
import in.jdsoft.educationmanagement.school.model.ClassSectionModuleSkill;
import in.jdsoft.educationmanagement.school.model.ClassSectionModuleSkillExam;
import in.jdsoft.educationmanagement.school.model.ClassSectionTerm;
import in.jdsoft.educationmanagement.school.model.ClassSectionTermExam;
import in.jdsoft.educationmanagement.school.model.ClassSectionTermExamActivity;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.Section;
import in.jdsoft.educationmanagement.school.model.Staff;
import in.jdsoft.educationmanagement.school.model.StaffLeaveRequisition;
import in.jdsoft.educationmanagement.school.services.ClassSectionService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="classSectionService")
public class ClassSectionServiceImpl
implements ClassSectionService {
    @Autowired
    ClassSectionDAO classSectionDAO;
    @Autowired
    ClassDAO classDAO;
    @Autowired
    SectionDAO sectionDAO;
    @Autowired
    ClassSectionTermExamActivityDAO classSectionTermExamActivityDAO;
    @Autowired
    ClassSectionModuleDAO classSectionModuleDAO;
    @Autowired
    ClassSectionModuleSkillDAO classSectionModuleSkillDAO;
    @Autowired
    ClassSectionCoScholasticAreaDAO classSectionCoScholasticAreaDAO;
    @Autowired
    ClassSectionCoScholasticActivityDAO classSectionCoScholasticActivityDAO;
    @Autowired
    ClassSectionModuleExamDAO classSectionModuleExamDAO;
    @Autowired
    ClassSectionCoScholasticAreaExamDAO classSectionCoScholasticAreaExamDAO;
    @Autowired
    ClassSectionCoScholasticActivityExamDAO classSectionCoScholasticActivityExamDAO;
    @Autowired
    ClassSectionModuleSkillExamDAO classSectionModuleSkillExamDAO;
    @Autowired
    StaffDAO staffDAO;
    @Autowired
    ExceptionComparator exceptionComparator;

    @Override
    public List<ClassSection> classSectionList() {
        try {
            List<ClassSection> classSectionList = this.classSectionDAO.getList();
            Integer classSectionSize = classSectionList.size();
            if (classSectionSize > 0) {
                log.info((Object)(classSectionSize + " ClassSection records where reterived"));
            } else {
                log.info((Object)"No ClassSection(s) available");
            }
            return classSectionList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving ClassSection list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public ClassSection classSectionById(Long classSectionId) {
        try {
            ClassSection classSection = this.classSectionDAO.getClassSectionById(classSectionId);
            if (classSection != null) {
                log.info((Object)("ClassSection with id=" + classSectionId + " has been reterived"));
                return classSection;
            }
            log.info((Object)("No ClassSection with  id=" + classSectionId + " is available"));
            return classSection;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving ClassSection by id=" + classSectionId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<ClassSection> classSectionByClassId(Long classId) {
        try {
            Class classs = this.classDAO.getClassById(classId);
            List<ClassSection> classSectionList = this.classSectionDAO.getClasssSectionByClass(classs);
            Integer classSectionSize = classSectionList.size();
            if (classSectionSize > 0) {
                log.info((Object)(classSectionSize + " ClassSection records where reterived"));
            } else {
                log.info((Object)"No ClassSection(s) available");
            }
            return classSectionList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving ClassSection list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Set<ClassSectionTermExam> classSectionTermAndExamByClassAndSectionId(Long classId, Long sectionId) {
        try {
            Class clazz = this.classDAO.getClassById(classId);
            Section section = this.sectionDAO.getSectionById(sectionId);
            List<ClassSection> classSectionTermAndExams = this.classSectionDAO.getClasssSectionsByClassAndSection(clazz, section);
            LinkedHashSet<ClassSectionTermExam> classSectionTermExams = new LinkedHashSet<ClassSectionTermExam>();
            for (ClassSection classSection : classSectionTermAndExams) {
                for (ClassSectionTerm classSectionTerm : classSection.getClassSectionTerms()) {
                    for (ClassSectionTermExam classSectionTermExam : classSectionTerm.getClassSectionTermExams()) {
                        classSectionTermExams.add(classSectionTermExam);
                    }
                }
            }
            return classSectionTermExams;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving classSectionTermAndExam list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<ClassSection> classSectionsByClassAndSectionId(Long classId, Long sectionId) {
        try {
            Class clazz = this.classDAO.getClassById(classId);
            Section section = this.sectionDAO.getSectionById(sectionId);
            List<ClassSection> classSections = this.classSectionDAO.getClasssSectionsByClassAndSection(clazz, section);
            return classSections;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving classSection", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Set<ClassSectionModule> classSectionModuleEagerByClassAndSectionId(Long classId, Long sectionId) {
        try {
            Class clazz = this.classDAO.getClassById(classId);
            Section section = this.sectionDAO.getSectionById(sectionId);
            List<ClassSection> classSections = this.classSectionDAO.getClasssSectionsByClassAndSection(clazz, section);
            LinkedHashSet<ClassSectionModule> classSectionModules = new LinkedHashSet<ClassSectionModule>();
            for (ClassSection classSection : classSections) {
                Hibernate.initialize(classSection.getClassSectionModules());
                for (ClassSectionModule classSectionModule : classSection.getClassSectionModules()) {
                    Hibernate.initialize((Object)classSectionModule);
                    Hibernate.initialize((Object)classSectionModule.getModule());
                    Hibernate.initialize((Object)classSectionModule.getClassSectionModuleStaff());
                    Hibernate.initialize((Object)classSectionModule.getClassSectionModuleStaff().getStaff());
                    Hibernate.initialize(classSectionModule.getClassSectionModuleExams());
                    Hibernate.initialize(classSectionModule.getClassSectionModuleSkills());
                    classSectionModules.add(classSectionModule);
                }
            }
            return classSectionModules;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving classSectionModule list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public ClassSection classSectionByClassAndSectionId(Long classId, Long sectionId) {
        try {
            Class clazz = this.classDAO.getClassById(classId);
            Section section = this.sectionDAO.getSectionById(sectionId);
            ClassSection classSection = this.classSectionDAO.getClasssSectionByClassAndSection(clazz, section);
            Hibernate.initialize(classSection.getClassSectionModules());
            Hibernate.initialize((Object)classSection.getClassStaff());
            for (ClassSectionModule classSectionModule : classSection.getClassSectionModules()) {
                Hibernate.initialize((Object)classSectionModule);
                Hibernate.initialize((Object)classSectionModule.getModule());
                Hibernate.initialize(classSectionModule.getClassSection().getClassSection().getStudents());
            }
            return classSection;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving classSection", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Map<String, Object> classSectionAssessmentEagerByClassAndSectionId(Long classId, Long sectionId) {
        LinkedHashMap<String, Object> assessmentTypeWithData = new LinkedHashMap<String, Object>();
        try {
            Class clazz = this.classDAO.getClassById(classId);
            Section section = this.sectionDAO.getSectionById(sectionId);
            ClassSection classSection = this.classSectionDAO.getClasssSectionByClassAndSection(clazz, section);
            for (ClassSectionAssesmentType classSectionAssesmentType : classSection.getClassSectionAssesmentType()) {
                List<ClassSectionModule> classSectionModules;
                if (classSectionAssesmentType.getClassSectionAssesmentName().equals("ModulesBased")) {
                    classSectionModules = this.classSectionModuleDAO.getClassSectionModuleBy(classSection, false);
                    for (ClassSectionModule classSectionModule : classSectionModules) {
                        Hibernate.initialize((Object)classSectionModule.getModule());
                    }
                    assessmentTypeWithData.put("ModulesBased", classSectionModules);
                    continue;
                }
                if (classSectionAssesmentType.getClassSectionAssesmentName().equals("CoScholasticArea")) {
                    List<ClassSectionCoScholasticArea> classSectionCoScholasticAreas = this.classSectionCoScholasticAreaDAO.getClassSectionCoScholasticAreaBy(classSection);
                    for (ClassSectionCoScholasticArea classSectionCoScholasticArea : classSectionCoScholasticAreas) {
                        Hibernate.initialize((Object)classSectionCoScholasticArea.getCoScholasticArea());
                    }
                    assessmentTypeWithData.put("CoScholasticArea", classSectionCoScholasticAreas);
                    continue;
                }
                if (classSectionAssesmentType.getClassSectionAssesmentName().equals("CoScholasticActivity")) {
                    List<ClassSectionCoScholasticActivity> classSectionCoScholasticActivitys = this.classSectionCoScholasticActivityDAO.getClassSectionCoScholasticActivityBy(classSection);
                    for (ClassSectionCoScholasticActivity classSectionCoScholasticActivity : classSectionCoScholasticActivitys) {
                        Hibernate.initialize((Object)classSectionCoScholasticActivity.getCoScholasticActivity());
                    }
                    assessmentTypeWithData.put("CoScholasticActivity", classSectionCoScholasticActivitys);
                    continue;
                }
                if (!classSectionAssesmentType.getClassSectionAssesmentName().equals("ModuleAndSkillBased")) continue;
                classSectionModules = this.classSectionModuleDAO.getClassSectionModuleBy(classSection, true);
                for (ClassSectionModule classSectionModule : classSectionModules) {
                    Hibernate.initialize((Object)classSectionModule.getModule());
                    Hibernate.initialize(classSectionModule.getClassSectionModuleSkills());
                    for (ClassSectionModuleSkill classSectionModuleSkill : classSectionModule.getClassSectionModuleSkills()) {
                        Hibernate.initialize((Object)classSectionModuleSkill.getModuleSkill());
                    }
                }
                assessmentTypeWithData.put("ModuleAndSkillBased", classSectionModules);
            }
            return assessmentTypeWithData;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving assessmentTypeWithData", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<ClassSection> classSectionByClassIdEager(Long classId) {
        try {
            Class classs = this.classDAO.getClassById(classId);
            List<ClassSection> classSectionList = this.classSectionDAO.getClasssSectionByClass(classs);
            Integer classSectionSize = classSectionList.size();
            if (classSectionSize > 0) {
                for (ClassSection classSection : classSectionList) {
                    Hibernate.initialize((Object)classSection.getSectionClass());
                    Hibernate.initialize(classSection.getClassSectionModules());
                    Hibernate.initialize(classSection.getTimeTableGenerators());
                    Hibernate.initialize((Object)classSection.getClassSection());
                    for (ClassSectionModule classSectionModule : classSection.getClassSectionModules()) {
                        Hibernate.initialize((Object)classSectionModule.getClassSectionModuleStaff());
                        Hibernate.initialize((Object)classSectionModule.getModule());
                        Hibernate.initialize((Object)classSectionModule.getClassSectionModuleStaff().getStaff());
                    }
                }
                log.info((Object)(classSectionSize + " ClassSection records where reterived with childs"));
            } else {
                log.info((Object)"No ClassSection(s) available");
            }
            return classSectionList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving ClassSection list with eager", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void createTermExamActivityAndAssessmentTypeExamActivity(Set<ClassSectionTermExamActivity> classSectionTermExamActivitys, Set<ClassSectionModuleExam> classSectionModuleExams, Set<ClassSectionModuleSkillExam> classSectionModuleSkillExams, Set<ClassSectionCoScholasticAreaExam> classSectionCoScholasticAreaExams, Set<ClassSectionCoScholasticActivityExam> classSectionCoScholasticActivityExams, Class clazz, Section section) {
        try {
            for (ClassSectionTermExamActivity classSectionTermExamActivity : classSectionTermExamActivitys) {
                this.classSectionTermExamActivityDAO.persist(classSectionTermExamActivity);
            }
            for (ClassSectionModuleExam classSectionModuleExam : classSectionModuleExams) {
                classSectionModuleExam.setClassSectionTerm(classSectionModuleExam.getClassSectionTermExam().getClassSectionTerm());
                this.classSectionModuleExamDAO.persist(classSectionModuleExam);
            }
            for (ClassSectionModuleSkillExam classSectionModuleSkillExam : classSectionModuleSkillExams) {
                classSectionModuleSkillExam.setClassSectionTerm(classSectionModuleSkillExam.getClassSectionTermExam().getClassSectionTerm());
                this.classSectionModuleSkillExamDAO.persist(classSectionModuleSkillExam);
            }
            for (ClassSectionCoScholasticAreaExam classSectionCoScholasticAreaExam : classSectionCoScholasticAreaExams) {
                classSectionCoScholasticAreaExam.setClassSectionTerm(classSectionCoScholasticAreaExam.getClassSectionTermExam().getClassSectionTerm());
                this.classSectionCoScholasticAreaExamDAO.persist(classSectionCoScholasticAreaExam);
            }
            for (ClassSectionCoScholasticActivityExam classSectionCoScholasticActivityExam : classSectionCoScholasticActivityExams) {
                classSectionCoScholasticActivityExam.setClassSectionTerm(classSectionCoScholasticActivityExam.getClassSectionTermExam().getClassSectionTerm());
                this.classSectionCoScholasticActivityExamDAO.persist(classSectionCoScholasticActivityExam);
            }
            ClassSection setclassSectionExamConfigStatus = this.classSectionDAO.getClasssSectionByClassAndSection(clazz, section);
            setclassSectionExamConfigStatus.setClassSectionExamConfigStatus(1);
            if (this.checkForExamConfigInClassSection(clazz)) {
                Class setConfigure = this.classDAO.getClassById(clazz.getClassId());
                setConfigure.setClassExamConfigStatus(0);
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in creating classsection exam activity", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public ClassSection classSectionByIdEager(Long classSectionId) {
        try {
            ClassSection classSection = this.classSectionDAO.getClassSectionById(classSectionId);
            if (classSection != null) {
                log.info((Object)("ClassSection with id=" + classSectionId + " has been reterived"));
                Hibernate.initialize((Object)classSection.getClassSection());
                Hibernate.initialize((Object)classSection.getSectionClass());
                return classSection;
            }
            log.info((Object)("No ClassSection with  id=" + classSectionId + " is available"));
            return classSection;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving ClassSection by id=" + classSectionId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public boolean checkForExamConfigInClassSection(Class clazz) {
        boolean status = false;
        if (this.classSectionDAO.getclassSectionExamConfigStatus(clazz).isEmpty()) {
            // empty if block
        }
        status = true;
        return status;
    }

    @Override
    public List<ClassSection> classSectionByClassIdAndStaffEager(Long classId, Staff staff) {
        try {
            Class classs = this.classDAO.getClassById(classId);
            List<ClassSection> classSectionList = this.classSectionDAO.getClasssSectionsByClassAndStaff(classs, staff);
            Integer classSectionSize = classSectionList.size();
            if (classSectionSize > 0) {
                for (ClassSection classSection : classSectionList) {
                    Hibernate.initialize((Object)classSection.getSectionClass());
                    Hibernate.initialize((Object)classSection.getClassSection());
                }
                log.info((Object)(classSectionSize + " ClassSection records where reterived with childs"));
            } else {
                log.info((Object)"No ClassSection(s) available");
            }
            return classSectionList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving ClassSection list with eager", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Set<ClassSectionModule> substituteClassSectionModuleEagerByClassAndSectionId(Long classId, Long sectionId) throws ParseException {
        SimpleDateFormat dateformatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = new Date();
            Class clazz = this.classDAO.getClassById(classId);
            Section section = this.sectionDAO.getSectionById(sectionId);
            List<ClassSection> classSections = this.classSectionDAO.getClasssSectionsByClassAndSection(clazz, section);
            HashSet<ClassSectionModule> classSectionModules = new HashSet<ClassSectionModule>();
            for (ClassSection classSection : classSections) {
                Iterator<ClassSectionModule> iterator = classSection.getClassSectionModules().iterator();
                while (iterator.hasNext()) {
                    ClassSectionModule classSectionModule = iterator.next();
                    boolean checkStatus = true;
                    Hibernate.initialize((Object)classSectionModule.getClassSectionModuleStaff().getStaff());
                    if (classSectionModule.getClassSectionModuleStaff().getStaff() == null) continue;
                    Staff staff = this.staffDAO.getStaffById(classSectionModule.getClassSectionModuleStaff().getStaff().getStaffId());
                    Hibernate.initialize(staff.getStaffLeaveRequisitions());
                    if (staff.getStaffLeaveRequisitions().isEmpty()) {
                        Hibernate.initialize((Object)classSectionModule.getModule());
                        Hibernate.initialize(classSectionModule.getClassSectionModuleExams());
                        Hibernate.initialize(classSectionModule.getClassSectionModuleSkills());
                        classSectionModule.getClassSectionModuleStaff().setStaff(staff);
                        classSectionModules.add(classSectionModule);
                        continue;
                    }
                    for (StaffLeaveRequisition staffLeaveRequisition : staff.getStaffLeaveRequisitions()) {
                        if (dateformatter.parse(dateformatter.format(date)).compareTo(staffLeaveRequisition.getStaffLeaveStartDate()) < 0 || dateformatter.parse(dateformatter.format(date)).compareTo(staffLeaveRequisition.getStaffLeaveEndDate()) > 0 || !staffLeaveRequisition.getApprovalStatus().equals("Approved")) continue;
                        checkStatus = false;
                    }
                    if (checkStatus) {
                        Hibernate.initialize((Object)classSectionModule.getModule());
                        Hibernate.initialize(classSectionModule.getClassSectionModuleExams());
                        Hibernate.initialize(classSectionModule.getClassSectionModuleSkills());
                        classSectionModule.getClassSectionModuleStaff().setStaff(staff);
                        classSectionModules.add(classSectionModule);
                        continue;
                    }
                    iterator.remove();
                }
            }
            return classSectionModules;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving classSectionModule list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void createClassAndSectionConfig(Class clazz, Set<Section> sections, Staff staff) throws ClassAndSectionException {
        block5: {
            if (this.classDAO.getClassByClassNameAndInstitution(clazz.getClassName(), clazz.getInstitution()) == null) {
                Class clazzz = this.classDAO.save(clazz);
                for (Section section : sections) {
                    if (this.classSectionDAO.getClasssSectionByClassAndSection(clazzz, section) == null) {
                        this.classSectionDAO.save(new ClassSection(clazzz, section, staff, 1));
                        continue;
                    }
                    throw new ClassAndSectionException(new Message("failure", "Already Class And Section Exist"));
                }
                break block5;
            }
            throw new ClassAndSectionException(new Message("failure", "Cannot Create Duplicate Class...!"));
        }
    }
}
