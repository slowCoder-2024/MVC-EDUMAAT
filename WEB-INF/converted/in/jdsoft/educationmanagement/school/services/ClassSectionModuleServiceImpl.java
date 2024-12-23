/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.Hibernate
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.ClassSectionModuleDAO;
import in.jdsoft.educationmanagement.school.model.ClassSection;
import in.jdsoft.educationmanagement.school.model.ClassSectionModule;
import in.jdsoft.educationmanagement.school.model.Module;
import in.jdsoft.educationmanagement.school.model.Staff;
import in.jdsoft.educationmanagement.school.model.TimeTableGeneratorHours;
import in.jdsoft.educationmanagement.school.services.ClassSectionModuleService;
import java.util.LinkedHashSet;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="classSectionModuleService")
public class ClassSectionModuleServiceImpl
implements ClassSectionModuleService {
    @Autowired
    ClassSectionModuleDAO classSectionModuleDAO;

    @Override
    public ClassSectionModule classSectionModuleById(Long classSectionModuleId) {
        try {
            ClassSectionModule classSectionModule = this.classSectionModuleDAO.getClassSectionModuleById(classSectionModuleId);
            if (classSectionModule != null) {
                log.info((Object)("Class Section Module with id=" + classSectionModuleId + " has been reterived"));
                return classSectionModule;
            }
            log.info((Object)("No Class Section Module with  id=" + classSectionModuleId + " is available"));
            return classSectionModule;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving Class Section Module by id=" + classSectionModuleId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public ClassSectionModule classSectionModuleByIdEager(Long classSectionModuleId) {
        try {
            ClassSectionModule classSectionModule = this.classSectionModuleDAO.getClassSectionModuleById(classSectionModuleId);
            if (classSectionModule != null) {
                Hibernate.initialize((Object)classSectionModule.getClassSection());
                Hibernate.initialize((Object)classSectionModule.getClassSectionModuleStaff());
                Hibernate.initialize((Object)classSectionModule.getModule());
                Hibernate.initialize(classSectionModule.getModule().getTimeTableGeneratorHours());
                for (TimeTableGeneratorHours timeTableGeneratorHours : classSectionModule.getModule().getTimeTableGeneratorHours()) {
                    Hibernate.initialize((Object)timeTableGeneratorHours.getTimeTableGeneratorDays());
                    Hibernate.initialize((Object)timeTableGeneratorHours.getTimeTableGeneratorDays().getTimeTableGenerator());
                }
                log.info((Object)("Class Section Module with id=" + classSectionModuleId + " has been reterived"));
                return classSectionModule;
            }
            log.info((Object)("No Class Section Module with  id=" + classSectionModuleId + " is available"));
            return classSectionModule;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving Class Section Module by id=" + classSectionModuleId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public ClassSectionModule classSectionModuleByIdAndStaffEager(Long classSectionModuleId, Staff staff) {
        try {
            ClassSectionModule classSectionModule = this.classSectionModuleDAO.getClassSectionModuleByIdAndStaff(classSectionModuleId, staff);
            if (classSectionModule != null) {
                Hibernate.initialize((Object)classSectionModule.getClassSection());
                Hibernate.initialize((Object)classSectionModule.getClassSectionModuleStaff());
                Hibernate.initialize((Object)classSectionModule.getClassSectionModuleStaff().getStaff());
                Hibernate.initialize((Object)classSectionModule.getModule());
                Hibernate.initialize(classSectionModule.getModule().getTimeTableGeneratorHours());
                LinkedHashSet<TimeTableGeneratorHours> addTimeTableGeneratorHours = new LinkedHashSet<TimeTableGeneratorHours>();
                for (TimeTableGeneratorHours timeTableGeneratorHours : classSectionModule.getModule().getTimeTableGeneratorHours()) {
                    Hibernate.initialize((Object)timeTableGeneratorHours.getTimeTableGeneratorDays());
                    Hibernate.initialize((Object)timeTableGeneratorHours.getTimeTableGeneratorDays().getTimeTableGenerator());
                    if (timeTableGeneratorHours.getTimeTableGeneratorDays().getTimeTableGenerator().getClassSection().getClassSectionId() != classSectionModule.getClassSectionModuleStaff().getClassSectionModule().getClassSection().getClassSectionId()) continue;
                    addTimeTableGeneratorHours.add(timeTableGeneratorHours);
                }
                classSectionModule.getModule().setTimeTableGeneratorHours(addTimeTableGeneratorHours);
                log.info((Object)("Class Section Module with id=" + classSectionModuleId + " has been reterived"));
                return classSectionModule;
            }
            log.info((Object)("No Class Section Module with  id=" + classSectionModuleId + " is available"));
            return classSectionModule;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving Class Section Module by id=" + classSectionModuleId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public ClassSectionModule classSectionModuleByClassSectionAndModule(ClassSection classSection, Module module) {
        try {
            ClassSectionModule classSectionModule = this.classSectionModuleDAO.getClassSectionModuleByClassSectionAndModule(classSection, module);
            if (classSectionModule != null) {
                Hibernate.initialize((Object)classSectionModule.getModule());
                Hibernate.initialize((Object)classSectionModule.getClassSectionModuleStaff());
                Hibernate.initialize((Object)classSectionModule.getClassSectionModuleStaff().getStaff());
                log.info((Object)("Class Section Module with classSection=" + classSection.getClassSectionId() + ",Module=" + module.getModuleId() + " has been reterived"));
                return classSectionModule;
            }
            log.info((Object)("No Class Section Module with  classSection=" + classSection.getClassSectionId() + ",Module=" + module.getModuleId() + "  is available"));
            return classSectionModule;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving Class Section Module by classSection=" + classSection.getClassSectionId() + ",Module=" + module.getModuleId() + " , " + e.getCause()));
            e.printStackTrace();
            throw e;
        }
    }
}
