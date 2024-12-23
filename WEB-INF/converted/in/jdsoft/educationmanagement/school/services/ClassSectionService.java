/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.exceptions.ClassAndSectionException;
import in.jdsoft.educationmanagement.school.model.Class;
import in.jdsoft.educationmanagement.school.model.ClassSection;
import in.jdsoft.educationmanagement.school.model.ClassSectionCoScholasticActivityExam;
import in.jdsoft.educationmanagement.school.model.ClassSectionCoScholasticAreaExam;
import in.jdsoft.educationmanagement.school.model.ClassSectionModule;
import in.jdsoft.educationmanagement.school.model.ClassSectionModuleExam;
import in.jdsoft.educationmanagement.school.model.ClassSectionModuleSkillExam;
import in.jdsoft.educationmanagement.school.model.ClassSectionTermExam;
import in.jdsoft.educationmanagement.school.model.ClassSectionTermExamActivity;
import in.jdsoft.educationmanagement.school.model.Section;
import in.jdsoft.educationmanagement.school.model.Staff;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ClassSectionService {
    public static final Logger log = LogManager.getLogger((String)ClassSectionService.class.getName());

    public List<ClassSection> classSectionList();

    public ClassSection classSectionById(Long var1);

    public ClassSection classSectionByIdEager(Long var1);

    public List<ClassSection> classSectionByClassId(Long var1);

    public Set<ClassSectionTermExam> classSectionTermAndExamByClassAndSectionId(Long var1, Long var2);

    public List<ClassSection> classSectionsByClassAndSectionId(Long var1, Long var2);

    public ClassSection classSectionByClassAndSectionId(Long var1, Long var2);

    public Set<ClassSectionModule> classSectionModuleEagerByClassAndSectionId(Long var1, Long var2);

    public List<ClassSection> classSectionByClassIdEager(Long var1);

    public Map<String, Object> classSectionAssessmentEagerByClassAndSectionId(Long var1, Long var2);

    public void createTermExamActivityAndAssessmentTypeExamActivity(Set<ClassSectionTermExamActivity> var1, Set<ClassSectionModuleExam> var2, Set<ClassSectionModuleSkillExam> var3, Set<ClassSectionCoScholasticAreaExam> var4, Set<ClassSectionCoScholasticActivityExam> var5, Class var6, Section var7);

    public boolean checkForExamConfigInClassSection(Class var1);

    public List<ClassSection> classSectionByClassIdAndStaffEager(Long var1, Staff var2);

    public Set<ClassSectionModule> substituteClassSectionModuleEagerByClassAndSectionId(Long var1, Long var2) throws ParseException;

    public void createClassAndSectionConfig(Class var1, Set<Section> var2, Staff var3) throws ClassAndSectionException;
}
