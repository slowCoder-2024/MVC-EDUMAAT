/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.Hibernate
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.ReportCardGeneratorDAO;
import in.jdsoft.educationmanagement.school.model.ReportCardGenerator;
import in.jdsoft.educationmanagement.school.model.ReportCardGeneratorDetail;
import in.jdsoft.educationmanagement.school.model.ReportCardGeneratorDetailWithModuleBased;
import in.jdsoft.educationmanagement.school.model.Student;
import in.jdsoft.educationmanagement.school.services.ReportCardGeneratorService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="reportCardGeneratorService")
public class ReportCardGeneratorServiceImpl
implements ReportCardGeneratorService {
    @Autowired
    private ReportCardGeneratorDAO reportCardGeneratorDAO;

    @Override
    public ReportCardGenerator reportCardGeneratorEagerByStudent(Student student) {
        try {
            ReportCardGenerator reportCardGenerator = this.reportCardGeneratorDAO.getReportCardGeneratorByStudent(student);
            Hibernate.initialize((Object)reportCardGenerator.getAcademicYear());
            Hibernate.initialize((Object)reportCardGenerator.getcGPAGradeObtained());
            Hibernate.initialize((Object)reportCardGenerator.getcGPAGradePointObtained());
            Hibernate.initialize((Object)reportCardGenerator.getcGPAGradePercentageObtained());
            Hibernate.initialize((Object)reportCardGenerator.getClassSection());
            Hibernate.initialize((Object)reportCardGenerator.getStudent().getUser());
            Hibernate.initialize((Object)reportCardGenerator.getStudent().getStudentStatus());
            Hibernate.initialize((Object)reportCardGenerator.getInstitution());
            Hibernate.initialize(reportCardGenerator.getReportCardGeneratorDetails());
            for (ReportCardGeneratorDetail reportCardGeneratorDetail : reportCardGenerator.getReportCardGeneratorDetails()) {
                ReportCardGeneratorDetailWithModuleBased reportCardGeneratorDetailWithModuleBaseds = (ReportCardGeneratorDetailWithModuleBased)reportCardGeneratorDetail;
                Hibernate.initialize((Object)reportCardGeneratorDetailWithModuleBaseds.getClassSectionModule().getModule());
                Hibernate.initialize((Object)reportCardGeneratorDetail.getFormativeAssessmentGradeObtained());
                Hibernate.initialize((Object)reportCardGeneratorDetail.getFormativeAssessmentGradePointObtained());
                Hibernate.initialize((Object)reportCardGeneratorDetail.getOverAllGradePointInGrade());
                Hibernate.initialize((Object)reportCardGeneratorDetail.getOverAllGradePointInPoint());
                Hibernate.initialize((Object)reportCardGeneratorDetail.getSummativeAssessmentGradeObtained());
                Hibernate.initialize((Object)reportCardGeneratorDetail.getSummativeAssessmentGradePointObtained());
            }
            return reportCardGenerator;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
