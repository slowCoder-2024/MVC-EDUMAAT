/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.exceptions.ClassException;
import in.jdsoft.educationmanagement.school.model.AdmissionConfig;
import in.jdsoft.educationmanagement.school.model.Class;
import in.jdsoft.educationmanagement.school.model.ClassSectionAssesmentType;
import in.jdsoft.educationmanagement.school.model.ClassSectionCoScholasticActivity;
import in.jdsoft.educationmanagement.school.model.ClassSectionCoScholasticArea;
import in.jdsoft.educationmanagement.school.model.ClassSectionModule;
import in.jdsoft.educationmanagement.school.model.ExamTemplate;
import in.jdsoft.educationmanagement.school.model.Section;
import in.jdsoft.educationmanagement.school.model.Staff;
import in.jdsoft.educationmanagement.school.reports.model.FourFieldReport;
import in.jdsoft.educationmanagement.school.reports.model.ThreeFieldReports;
import java.util.List;
import java.util.Set;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ClassService {
    public static final Logger log = LogManager.getLogger((String)ClassService.class.getName());

    public Long createClass(Class var1) throws ClassException;

    public Long configureClassWithAssessmentType(Class var1, Section var2, ExamTemplate var3, Staff var4, Set<ClassSectionAssesmentType> var5, Set<ClassSectionModule> var6, Set<ClassSectionCoScholasticActivity> var7, Set<ClassSectionCoScholasticArea> var8, Set<ClassSectionModule> var9) throws Exception;

    public void deleteClass(Long var1);

    public List<Class> classList();

    public List<Class> classList(Long var1) throws ClassException;

    public List<Class> classListEager(Long var1) throws ClassException;

    public Class classById(Long var1);

    public void update(Class var1);

    public List<Class> classzByExamConfigStatusEager(Long var1, Integer var2) throws ClassException;

    public Set<AdmissionConfig> getAdmissionConfigByClassId(Long var1);

    public ThreeFieldReports getStudentRatioFromClass(Long var1);

    public List<FourFieldReport> getStudentRatioFromClassByInstitution(Long var1);

    public void updateClassSection(Class var1, Set<Section> var2, Staff var3);
}
