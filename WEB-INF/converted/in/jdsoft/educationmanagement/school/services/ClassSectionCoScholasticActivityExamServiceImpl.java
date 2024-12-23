/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.Hibernate
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.ClassSectionCoScholasticActivityExamDAO;
import in.jdsoft.educationmanagement.school.dao.ClassSectionTermExamDAO;
import in.jdsoft.educationmanagement.school.model.ClassSectionCoScholasticActivityExam;
import in.jdsoft.educationmanagement.school.model.ClassSectionTermExam;
import in.jdsoft.educationmanagement.school.services.ClassSectionCoScholasticActivityExamService;
import java.util.List;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="classSectionCoScholasticActivityExamService")
public class ClassSectionCoScholasticActivityExamServiceImpl
implements ClassSectionCoScholasticActivityExamService {
    @Autowired
    private ClassSectionTermExamDAO classSectionTermExamDAO;
    @Autowired
    private ClassSectionCoScholasticActivityExamDAO classSectionCoScholasticActivityExamDAO;

    @Override
    public List<ClassSectionCoScholasticActivityExam> classSectionCoScholasticActivityExamEagerById(Long classSectionTermExamId) {
        try {
            ClassSectionTermExam classSectionTermExam = this.classSectionTermExamDAO.getClassSectionTermExamById(classSectionTermExamId);
            List<ClassSectionCoScholasticActivityExam> classSectionCoScholasticActivityExams = this.classSectionCoScholasticActivityExamDAO.getClassSectionCoScholasticActivityExamByClassSectionTermExam(classSectionTermExam);
            for (ClassSectionCoScholasticActivityExam classSectionCoScholasticActivityExam : classSectionCoScholasticActivityExams) {
                Hibernate.initialize(classSectionCoScholasticActivityExam.getClassSectionCoScholasticActivity().getCoScholasticActivity().getCoScholasticActivityIndicators());
            }
            return classSectionCoScholasticActivityExams;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
