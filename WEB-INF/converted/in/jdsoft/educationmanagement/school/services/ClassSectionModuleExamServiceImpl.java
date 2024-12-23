/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.Hibernate
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.ClassSectionModuleExamDAO;
import in.jdsoft.educationmanagement.school.dao.ClassSectionTermExamDAO;
import in.jdsoft.educationmanagement.school.model.ClassSectionModuleExam;
import in.jdsoft.educationmanagement.school.model.ClassSectionTermExam;
import in.jdsoft.educationmanagement.school.services.ClassSectionModuleExamService;
import java.util.List;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="classSectionModuleExamService")
public class ClassSectionModuleExamServiceImpl
implements ClassSectionModuleExamService {
    @Autowired
    private ClassSectionModuleExamDAO classSectionModuleExamDAO;
    @Autowired
    private ClassSectionTermExamDAO classSectionTermExamDAO;

    @Override
    public List<ClassSectionModuleExam> classSectionModuleExamEagerById(Long classSectionTermExamId) {
        try {
            ClassSectionTermExam classSectionTermExam = this.classSectionTermExamDAO.getClassSectionTermExamById(classSectionTermExamId);
            List<ClassSectionModuleExam> classSectionModuleExams = this.classSectionModuleExamDAO.getClassSectionModuleExamByClassSectionTermExam(classSectionTermExam);
            for (ClassSectionModuleExam classSectionModuleExam : classSectionModuleExams) {
                Hibernate.initialize((Object)classSectionModuleExam.getClassSectionModule().getModule());
                Hibernate.initialize((Object)classSectionModuleExam.getClassSectionModuleExamId());
                Hibernate.initialize((Object)classSectionModuleExam.getClassSectionTerm());
            }
            return classSectionModuleExams;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
