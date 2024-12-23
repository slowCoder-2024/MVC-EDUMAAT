/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.Hibernate
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.ClassSectionCoScholasticAreaExamDAO;
import in.jdsoft.educationmanagement.school.dao.ClassSectionTermExamDAO;
import in.jdsoft.educationmanagement.school.model.ClassSectionCoScholasticAreaExam;
import in.jdsoft.educationmanagement.school.model.ClassSectionTermExam;
import in.jdsoft.educationmanagement.school.services.ClassSectionCoScholasticAreaExamService;
import java.util.List;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="classSectionCoScholasticAreaExamService")
public class ClassSectionCoScholasticAreaExamServiceImpl
implements ClassSectionCoScholasticAreaExamService {
    @Autowired
    private ClassSectionTermExamDAO classSectionTermExamDAO;
    @Autowired
    private ClassSectionCoScholasticAreaExamDAO classSectionCoScholasticAreaExamDAO;

    @Override
    public List<ClassSectionCoScholasticAreaExam> classSectionCoScholasticAreaExamEagerById(Long classSectionTermExamId) {
        try {
            ClassSectionTermExam classSectionTermExam = this.classSectionTermExamDAO.getClassSectionTermExamById(classSectionTermExamId);
            List<ClassSectionCoScholasticAreaExam> classSectionCoScholasticAreaExams = this.classSectionCoScholasticAreaExamDAO.getClassSectionCoScholasticAreaExamByClassSectionTermExam(classSectionTermExam);
            for (ClassSectionCoScholasticAreaExam classSectionCoScholasticAreaExam : classSectionCoScholasticAreaExams) {
                Hibernate.initialize(classSectionCoScholasticAreaExam.getClassSectionCoScholasticArea().getCoScholasticArea().getCoScholasticAreaIndicators());
            }
            return classSectionCoScholasticAreaExams;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
