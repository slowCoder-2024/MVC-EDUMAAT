/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.zxing.BarcodeFormat
 *  com.google.zxing.client.j2se.MatrixToImageWriter
 *  com.google.zxing.common.BitMatrix
 *  com.google.zxing.oned.Code128Writer
 *  org.hibernate.Hibernate
 *  org.hibernate.exception.ConstraintViolationException
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;
import in.jdsoft.educationmanagement.school.components.FileUploadHandler;
import in.jdsoft.educationmanagement.school.dao.AcademicYearDAO;
import in.jdsoft.educationmanagement.school.dao.ClassDAO;
import in.jdsoft.educationmanagement.school.dao.FeesTermDAO;
import in.jdsoft.educationmanagement.school.dao.InstitutionDAO;
import in.jdsoft.educationmanagement.school.dao.SectionDAO;
import in.jdsoft.educationmanagement.school.dao.StudentHostelIDCardGenerationDAO;
import in.jdsoft.educationmanagement.school.exceptions.StudentHostelIDCardGenerationException;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.Class;
import in.jdsoft.educationmanagement.school.model.FeesTerm;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.Section;
import in.jdsoft.educationmanagement.school.model.StudentHostelIDCardGeneration;
import in.jdsoft.educationmanagement.school.services.StudentHostelIDCardGenerationService;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.hibernate.Hibernate;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="studentHostelIDCardGenerationService")
public class StudentHostelIDCardGenerationServiceImpl
implements StudentHostelIDCardGenerationService {
    @Autowired
    StudentHostelIDCardGenerationDAO studentHostelIDCardGenerationDAO;
    @Autowired
    FileUploadHandler fileUploadHandler;
    @Autowired
    ClassDAO classDAO;
    @Autowired
    SectionDAO sectionDAO;
    @Autowired
    AcademicYearDAO academicYearDAO;
    @Autowired
    InstitutionDAO institutionDAO;
    @Autowired
    FeesTermDAO feesTermDAO;

    @Override
    public void createBarCodeAndBarCodeImage(Set<StudentHostelIDCardGeneration> studentHostelIDCardGenerations) throws StudentHostelIDCardGenerationException, Exception {
        try {
            for (StudentHostelIDCardGeneration studentHostelIDCardGeneration : studentHostelIDCardGenerations) {
                String millisecond = Long.toString(System.currentTimeMillis());
                String code = "CBSE" + millisecond;
                String[] args = studentHostelIDCardGeneration.getBarCodeImage().split("@");
                String location = args[0];
                String path = args[1];
                location = String.valueOf(location) + path;
                this.fileUploadHandler.createFolderIfNotExist(location);
                String name = String.valueOf(studentHostelIDCardGeneration.getStudent().getFirstName()) + Long.toString(System.currentTimeMillis()) + ".jpg";
                try {
                    BitMatrix bitMatrix = new Code128Writer().encode(code, BarcodeFormat.CODE_128, 150, 80, null);
                    MatrixToImageWriter.writeToStream((BitMatrix)bitMatrix, (String)"jpg", (OutputStream)new FileOutputStream(new File(String.valueOf(location) + name)));
                }
                catch (Exception e) {
                    e.printStackTrace();
                    throw e;
                }
                studentHostelIDCardGeneration.setBarCode(code);
                studentHostelIDCardGeneration.setBarCodeImage(String.valueOf(path) + name);
                this.studentHostelIDCardGenerationDAO.persist(studentHostelIDCardGeneration);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            if (e.getClass().equals(ConstraintViolationException.class)) {
                throw new StudentHostelIDCardGenerationException(new Message("failure", "StudentID Card Cannot Be Generated!! Already ID Card Generated for this Class And Section"));
            }
            log.error((Object)"Exception in Creating student id card generation", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<StudentHostelIDCardGeneration> StudentHostelIDCardGenerationListByClassAndSectionAndAcademicYear(Long classId, Long sectionId, Long academicYearId, Long institutionId) throws Exception {
        try {
            List<Object> studentHostelIDCardGenerations = new ArrayList();
            Class classes = this.classDAO.getClassById(classId);
            Section section = this.sectionDAO.getSectionById(sectionId);
            AcademicYear academicYear = this.academicYearDAO.getAcademicYearById(academicYearId);
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            studentHostelIDCardGenerations = this.studentHostelIDCardGenerationDAO.getStudentHostelIDCardGenerationByClassAndSectionAndAcademicYear(classes, section, academicYear, institution);
            for (StudentHostelIDCardGeneration studentHostelIDCardGeneration : studentHostelIDCardGenerations) {
                Hibernate.initialize((Object)studentHostelIDCardGeneration.getAcademicYear());
                Hibernate.initialize((Object)studentHostelIDCardGeneration.getSection());
                Hibernate.initialize((Object)studentHostelIDCardGeneration.getStudentClass());
                Hibernate.initialize((Object)studentHostelIDCardGeneration.getStudent());
                Hibernate.initialize((Object)studentHostelIDCardGeneration.getStudent().getUser());
                Hibernate.initialize((Object)studentHostelIDCardGeneration.getInstitution());
            }
            return studentHostelIDCardGenerations;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteStudentIDCard(Long classId, Long sectionId, Long academicYearId, Long institutionId) throws Exception {
        try {
            List<Object> studentHostelIDCardGenerations = new ArrayList();
            Class classes = this.classDAO.getClassById(classId);
            Section section = this.sectionDAO.getSectionById(sectionId);
            AcademicYear academicYear = this.academicYearDAO.getAcademicYearById(academicYearId);
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            studentHostelIDCardGenerations = this.studentHostelIDCardGenerationDAO.getStudentHostelIDCardGenerationByClassAndSectionAndAcademicYear(classes, section, academicYear, institution);
            for (StudentHostelIDCardGeneration studentHostelIDCardGeneration : studentHostelIDCardGenerations) {
                this.studentHostelIDCardGenerationDAO.delete(studentHostelIDCardGeneration);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void createBarCodeAndBarCodeImage(StudentHostelIDCardGeneration studentHostelIDCardGeneration) throws StudentHostelIDCardGenerationException, Exception {
        try {
            String millisecond = Long.toString(System.currentTimeMillis());
            String code = "CBSE" + millisecond;
            String[] args = studentHostelIDCardGeneration.getBarCodeImage().split("@");
            String location = args[0];
            String path = args[1];
            location = String.valueOf(location) + path;
            this.fileUploadHandler.createFolderIfNotExist(location);
            String name = String.valueOf(studentHostelIDCardGeneration.getStudent().getFirstName()) + Long.toString(System.currentTimeMillis()) + ".jpg";
            try {
                BitMatrix bitMatrix = new Code128Writer().encode(code, BarcodeFormat.CODE_128, 150, 80, null);
                MatrixToImageWriter.writeToStream((BitMatrix)bitMatrix, (String)"jpg", (OutputStream)new FileOutputStream(new File(String.valueOf(location) + name)));
            }
            catch (Exception e) {
                e.printStackTrace();
                throw e;
            }
            studentHostelIDCardGeneration.setBarCode(code);
            studentHostelIDCardGeneration.setBarCodeImage(String.valueOf(path) + name);
            this.studentHostelIDCardGenerationDAO.persist(studentHostelIDCardGeneration);
        }
        catch (Exception e) {
            e.printStackTrace();
            if (e.getClass().equals(ConstraintViolationException.class)) {
                throw new StudentHostelIDCardGenerationException(new Message("failure", "Student Hostel ID Card Cannot Be Generated!! Already ID Card Generated for this Admission Number"));
            }
            log.error((Object)"Exception in Creating student id card generation", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<StudentHostelIDCardGeneration> StudentHostelIDCardGenerationListByClassAndSectionAndAcademicYear(Long classId, Long sectionId, Long academicYearId) throws Exception {
        try {
            List<Object> studentHostelIDCardGenerations = new ArrayList();
            Class classes = this.classDAO.getClassById(classId);
            Section section = this.sectionDAO.getSectionById(sectionId);
            AcademicYear academicYear = this.academicYearDAO.getAcademicYearById(academicYearId);
            studentHostelIDCardGenerations = this.studentHostelIDCardGenerationDAO.getStudentHostelIDCardGenerationByClassAndSectionAndAcademicYear(classes, section, academicYear);
            for (StudentHostelIDCardGeneration studentHostelIDCardGeneration : studentHostelIDCardGenerations) {
                Hibernate.initialize((Object)studentHostelIDCardGeneration.getAcademicYear());
                Hibernate.initialize((Object)studentHostelIDCardGeneration.getSection());
                Hibernate.initialize((Object)studentHostelIDCardGeneration.getStudentClass());
                Hibernate.initialize((Object)studentHostelIDCardGeneration.getStudent());
                Hibernate.initialize((Object)studentHostelIDCardGeneration.getStudent().getBloodGroup());
                Hibernate.initialize((Object)studentHostelIDCardGeneration.getStudent().getUser());
                Hibernate.initialize((Object)studentHostelIDCardGeneration.getInstitution());
            }
            return studentHostelIDCardGenerations;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<StudentHostelIDCardGeneration> StudentHostelIDCardGenerationListByClassAndSectionAndFeesTerm(Long classId, Long sectionId, Long feesTermId) throws Exception {
        try {
            List<Object> studentHostelIDCardGenerations = new ArrayList();
            Class classes = this.classDAO.getClassById(classId);
            Section section = this.sectionDAO.getSectionById(sectionId);
            FeesTerm feesTerm = this.feesTermDAO.getFeesTermById(feesTermId);
            studentHostelIDCardGenerations = this.studentHostelIDCardGenerationDAO.getStudentHostelIDCardGenerationByClassAndSectionAndFeesTerm(classes, section, feesTerm);
            for (StudentHostelIDCardGeneration studentHostelIDCardGeneration : studentHostelIDCardGenerations) {
                Hibernate.initialize((Object)studentHostelIDCardGeneration.getAcademicYear());
                Hibernate.initialize((Object)studentHostelIDCardGeneration.getSection());
                Hibernate.initialize((Object)studentHostelIDCardGeneration.getStudentClass());
                Hibernate.initialize((Object)studentHostelIDCardGeneration.getStudent());
                Hibernate.initialize((Object)studentHostelIDCardGeneration.getStudent().getBloodGroup());
                Hibernate.initialize((Object)studentHostelIDCardGeneration.getStudent().getUser());
                Hibernate.initialize((Object)studentHostelIDCardGeneration.getInstitution());
            }
            return studentHostelIDCardGenerations;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteStudentHostelIDCardByClassAndSectionAndAcademicYear(Long classId, Long sectionId, Long academicYearId) throws Exception {
        try {
            List<Object> studentHostelIDCardGenerations = new ArrayList();
            Class classes = this.classDAO.getClassById(classId);
            Section section = this.sectionDAO.getSectionById(sectionId);
            AcademicYear academicYear = this.academicYearDAO.getAcademicYearById(academicYearId);
            studentHostelIDCardGenerations = this.studentHostelIDCardGenerationDAO.getStudentHostelIDCardGenerationByClassAndSectionAndAcademicYear(classes, section, academicYear);
            for (StudentHostelIDCardGeneration studentHostelIDCardGeneration : studentHostelIDCardGenerations) {
                this.studentHostelIDCardGenerationDAO.delete(studentHostelIDCardGeneration);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteStudentHostelIDCardByClassAndSectionAndFeesTerm(Long classId, Long sectionId, Long feesTermId) throws Exception {
        try {
            List<Object> studentHostelIDCardGenerations = new ArrayList();
            Class classes = this.classDAO.getClassById(classId);
            Section section = this.sectionDAO.getSectionById(sectionId);
            FeesTerm feesTerm = this.feesTermDAO.getFeesTermById(feesTermId);
            studentHostelIDCardGenerations = this.studentHostelIDCardGenerationDAO.getStudentHostelIDCardGenerationByClassAndSectionAndFeesTerm(classes, section, feesTerm);
            for (StudentHostelIDCardGeneration studentHostelIDCardGeneration : studentHostelIDCardGenerations) {
                this.studentHostelIDCardGenerationDAO.delete(studentHostelIDCardGeneration);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
