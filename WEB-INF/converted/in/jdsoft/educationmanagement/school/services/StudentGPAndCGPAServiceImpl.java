/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.ClassSectionAssesmentTypeDAO;
import in.jdsoft.educationmanagement.school.dao.GradeSystemDAO;
import in.jdsoft.educationmanagement.school.dao.GradeSystemDetailDAO;
import in.jdsoft.educationmanagement.school.dao.ReportCardGeneratorDAO;
import in.jdsoft.educationmanagement.school.dao.ReportCardGeneratorDetailDAO;
import in.jdsoft.educationmanagement.school.dao.StudentMarkDAO;
import in.jdsoft.educationmanagement.school.model.ClassSectionAssesmentType;
import in.jdsoft.educationmanagement.school.model.ClassSectionModule;
import in.jdsoft.educationmanagement.school.model.ClassSectionTermExam;
import in.jdsoft.educationmanagement.school.model.GradeSystem;
import in.jdsoft.educationmanagement.school.model.GradeSystemDetail;
import in.jdsoft.educationmanagement.school.model.ReportCardGenerator;
import in.jdsoft.educationmanagement.school.model.ReportCardGeneratorDetailWithModuleBased;
import in.jdsoft.educationmanagement.school.model.Student;
import in.jdsoft.educationmanagement.school.model.StudentMark;
import in.jdsoft.educationmanagement.school.model.StudentMarksDetail;
import in.jdsoft.educationmanagement.school.model.StudentMarksDetailWithModuleBased;
import in.jdsoft.educationmanagement.school.services.StudentGPAndCGPAService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="studentGPAndCGPAService")
public class StudentGPAndCGPAServiceImpl
implements StudentGPAndCGPAService {
    @Autowired
    private StudentMarkDAO studentMarkDAO;
    @Autowired
    private GradeSystemDetailDAO gradeSystemDetailDAO;
    @Autowired
    private GradeSystemDAO gradeSystemDAO;
    @Autowired
    private ReportCardGeneratorDAO reportCardGeneratorDAO;
    @Autowired
    private ClassSectionAssesmentTypeDAO classSectionAssesmentTypeDAO;
    @Autowired
    private ReportCardGeneratorDetailDAO reportCardGeneratorDetailDAO;

    @Override
    public void GenerateGPAndCGPA(ReportCardGenerator reportCardGenerators, ArrayList<ClassSectionTermExam> formativeAssessments, ArrayList<ClassSectionTermExam> summativeAssessments) {
        try {
            ClassSectionAssesmentType classSectionAssesmentType = this.classSectionAssesmentTypeDAO.getClassSectionAssesmentType(reportCardGenerators.getClassSection());
            Long gradeSystemId = classSectionAssesmentType.getGradeSystem().getGradeSystemId();
            GradeSystem gradeSystem = this.gradeSystemDAO.getGradeSystemById(gradeSystemId);
            for (Student student : reportCardGenerators.getClassSection().getClassSection().getStudents()) {
                ReportCardGenerator reportCardGeneratorObj = new ReportCardGenerator();
                reportCardGeneratorObj.setClassSection(reportCardGenerators.getClassSection());
                reportCardGeneratorObj.setInstitution(reportCardGenerators.getInstitution());
                reportCardGeneratorObj.setAcademicYear(reportCardGenerators.getAcademicYear());
                reportCardGeneratorObj.setStudent(student);
                ReportCardGenerator persistedReportCardGenerator = this.reportCardGeneratorDAO.save(reportCardGeneratorObj);
                double summationOfGradePoint = 0.0;
                for (ClassSectionModule classSectionModule : persistedReportCardGenerator.getClassSection().getClassSectionModules()) {
                    StudentMarksDetailWithModuleBased studentMarksDetailWithModuleBaseds;
                    List<StudentMark> studentMarks;
                    double summationOfGradePointObtainedForEachModuleInFormativeAssessment = 0.0;
                    double summationOfGradePointObtainedForEachModuleInSummativeAssessment = 0.0;
                    int noOfFormativeAssessments = formativeAssessments.size();
                    int noOfSummativeAssessments = summativeAssessments.size();
                    for (ClassSectionTermExam formativeAssessment : formativeAssessments) {
                        studentMarks = this.studentMarkDAO.getStudentMarkBy(persistedReportCardGenerator.getClassSection(), persistedReportCardGenerator.getAcademicYear(), formativeAssessment, student);
                        for (StudentMark studentMarkForFormativeAssessment : studentMarks) {
                            for (StudentMarksDetail studentMarksDetail : studentMarkForFormativeAssessment.getStudentMarksDetails()) {
                                studentMarksDetailWithModuleBaseds = (StudentMarksDetailWithModuleBased)studentMarksDetail;
                                if (!classSectionModule.getModule().getModuleName().equals(studentMarksDetailWithModuleBaseds.getClassSectionModule().getModule().getModuleName())) continue;
                                summationOfGradePointObtainedForEachModuleInFormativeAssessment += studentMarksDetail.getTermExamGradePointObtained().doubleValue();
                            }
                        }
                    }
                    for (ClassSectionTermExam summativeAssessment : summativeAssessments) {
                        studentMarks = this.studentMarkDAO.getStudentMarkBy(persistedReportCardGenerator.getClassSection(), persistedReportCardGenerator.getAcademicYear(), summativeAssessment, student);
                        for (StudentMark studentMarkForSummativeAssessment : studentMarks) {
                            for (StudentMarksDetail studentMarksDetail : studentMarkForSummativeAssessment.getStudentMarksDetails()) {
                                studentMarksDetailWithModuleBaseds = (StudentMarksDetailWithModuleBased)studentMarksDetail;
                                if (!classSectionModule.getModule().getModuleName().equals(studentMarksDetailWithModuleBaseds.getClassSectionModule().getModule().getModuleName())) continue;
                                double eachTermExamGradePointForSummativeAssessment = studentMarksDetail.getTermExamGradePointObtained() / (double)noOfSummativeAssessments;
                                summationOfGradePointObtainedForEachModuleInSummativeAssessment += eachTermExamGradePointForSummativeAssessment;
                            }
                        }
                    }
                    double formativeAssessmentGradePointObtained = summationOfGradePointObtainedForEachModuleInFormativeAssessment / (double)noOfFormativeAssessments;
                    double roundOfSummationOfGradePointObtainedForEachModuleInFormativeAssessment = Math.round(formativeAssessmentGradePointObtained);
                    GradeSystemDetail gradeForSummationOfGradePointObtainedForEachModuleInFormativeAssessment = this.gradeSystemDetailDAO.getGradeByPoint(roundOfSummationOfGradePointObtainedForEachModuleInFormativeAssessment, gradeSystem);
                    String formativeAssessmentGradeObtained = gradeForSummationOfGradePointObtainedForEachModuleInFormativeAssessment != null ? gradeForSummationOfGradePointObtainedForEachModuleInFormativeAssessment.getGradeTitle() : "GNG";
                    double summativeAssessmentGradePointObtained = summationOfGradePointObtainedForEachModuleInSummativeAssessment / (double)noOfSummativeAssessments;
                    double roundOfSummationOfGradePointObtainedForEachModuleInSummativeAssessment = Math.round(summativeAssessmentGradePointObtained);
                    GradeSystemDetail gradeForSummationOfGradePointObtainedForEachModuleInSummativeAssessment = this.gradeSystemDetailDAO.getGradeByPoint(roundOfSummationOfGradePointObtainedForEachModuleInSummativeAssessment, gradeSystem);
                    String summativeAssessmentGradeObtained = gradeForSummationOfGradePointObtainedForEachModuleInSummativeAssessment != null ? gradeForSummationOfGradePointObtainedForEachModuleInSummativeAssessment.getGradeTitle() : "GNG";
                    double overAllGradePointInPoint = (formativeAssessmentGradePointObtained + summativeAssessmentGradePointObtained) / 2.0;
                    double roundOfOverAllGradePointInPoint = Math.round(overAllGradePointInPoint);
                    GradeSystemDetail gradeForOverAllGradePointInPoint = this.gradeSystemDetailDAO.getGradeByPoint(roundOfOverAllGradePointInPoint, gradeSystem);
                    String overAllGradePointInGrade = gradeForOverAllGradePointInPoint != null ? gradeForOverAllGradePointInPoint.getGradeTitle() : "GNG";
                    ReportCardGeneratorDetailWithModuleBased reportCardGeneratorDetailWithModuleBaseds = new ReportCardGeneratorDetailWithModuleBased(formativeAssessmentGradeObtained, formativeAssessmentGradePointObtained, summativeAssessmentGradeObtained, summativeAssessmentGradePointObtained, overAllGradePointInGrade, overAllGradePointInPoint, persistedReportCardGenerator, classSectionModule);
                    this.reportCardGeneratorDetailDAO.persist(reportCardGeneratorDetailWithModuleBaseds);
                    summationOfGradePoint += overAllGradePointInPoint;
                }
                double cGPAGradePointObtained = summationOfGradePoint / 6.0;
                double cGPAGradePercentageObtained = cGPAGradePointObtained * 9.5;
                ReportCardGenerator setCGPAInReportCardGenerator = this.reportCardGeneratorDAO.getReportCardGeneratorById(persistedReportCardGenerator.getReportCardGeneratorId());
                setCGPAInReportCardGenerator.setcGPAGradePointObtained(cGPAGradePointObtained);
                setCGPAInReportCardGenerator.setcGPAGradePercentageObtained(cGPAGradePercentageObtained);
                double roundOfCGPA = Math.round(cGPAGradePointObtained);
                GradeSystemDetail gradeForCGPA = this.gradeSystemDetailDAO.getGradeByPoint(roundOfCGPA, gradeSystem);
                if (gradeForCGPA != null) {
                    setCGPAInReportCardGenerator.setcGPAGradeObtained(gradeForCGPA.getGradeTitle());
                    continue;
                }
                setCGPAInReportCardGenerator.setcGPAGradeObtained("GNG");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
