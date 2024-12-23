/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.Hibernate
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.ClassSectionModuleSkillExamDAO;
import in.jdsoft.educationmanagement.school.dao.ClassSectionTermExamDAO;
import in.jdsoft.educationmanagement.school.model.ClassSectionModuleSkillExam;
import in.jdsoft.educationmanagement.school.model.ClassSectionTermExam;
import in.jdsoft.educationmanagement.school.services.ClassSectionModuleSkillExamService;
import java.util.List;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="classSectionModuleSkillExamService")
public class ClassSectionModuleSkillExamServiceImpl
implements ClassSectionModuleSkillExamService {
    @Autowired
    private ClassSectionModuleSkillExamDAO classSectionModuleSkillExamDAO;
    @Autowired
    private ClassSectionTermExamDAO classSectionTermExamDAO;

    @Override
    public List<ClassSectionModuleSkillExam> classSectionModuleSkillExamEagerById(Long classSectionTermExamId) {
        try {
            ClassSectionTermExam classSectionTermExam = this.classSectionTermExamDAO.getClassSectionTermExamById(classSectionTermExamId);
            List<ClassSectionModuleSkillExam> classSectionModuleSkillExams = this.classSectionModuleSkillExamDAO.getClassSectionModuleSkillExamByClassSectionTermExam(classSectionTermExam);
            for (ClassSectionModuleSkillExam classSectionModuleSkillExam : classSectionModuleSkillExams) {
                Hibernate.initialize(classSectionModuleSkillExam.getClassSectionModuleSkill().getModuleSkill().getModuleSkillIndicators());
            }
            return classSectionModuleSkillExams;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
