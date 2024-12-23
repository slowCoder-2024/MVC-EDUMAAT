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
import in.jdsoft.educationmanagement.school.dao.StudentTransportIDCardGenerationDAO;
import in.jdsoft.educationmanagement.school.exceptions.StudentTransportIDCardGenerationException;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.Class;
import in.jdsoft.educationmanagement.school.model.FeesTerm;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.Section;
import in.jdsoft.educationmanagement.school.model.StudentTransportIDCardGeneration;
import in.jdsoft.educationmanagement.school.services.StudentTransportIDCardGenerationService;
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

@Service(value="studentTransportIDCardGenerationService")
public class StudentTransportIDCardGenerationServiceImpl
implements StudentTransportIDCardGenerationService {
    @Autowired
    StudentTransportIDCardGenerationDAO studentTransportIDCardGenerationDAO;
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
    public void createBarCodeAndBarCodeImage(Set<StudentTransportIDCardGeneration> studentTransportIDCardGenerations) throws StudentTransportIDCardGenerationException, Exception {
        try {
            for (StudentTransportIDCardGeneration studentTransportIDCardGeneration : studentTransportIDCardGenerations) {
                String millisecond = Long.toString(System.currentTimeMillis());
                String code = "CBSE" + millisecond;
                String[] args = studentTransportIDCardGeneration.getBarCodeImage().split("@");
                String location = args[0];
                String path = args[1];
                location = String.valueOf(location) + path;
                this.fileUploadHandler.createFolderIfNotExist(location);
                String name = String.valueOf(studentTransportIDCardGeneration.getStudent().getFirstName()) + Long.toString(System.currentTimeMillis()) + ".jpg";
                try {
                    BitMatrix bitMatrix = new Code128Writer().encode(code, BarcodeFormat.CODE_128, 150, 80, null);
                    MatrixToImageWriter.writeToStream((BitMatrix)bitMatrix, (String)"jpg", (OutputStream)new FileOutputStream(new File(String.valueOf(location) + name)));
                }
                catch (Exception e) {
                    e.printStackTrace();
                    throw e;
                }
                studentTransportIDCardGeneration.setBarCode(code);
                studentTransportIDCardGeneration.setBarCodeImage(String.valueOf(path) + name);
                this.studentTransportIDCardGenerationDAO.persist(studentTransportIDCardGeneration);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            if (e.getClass().equals(ConstraintViolationException.class)) {
                throw new StudentTransportIDCardGenerationException(new Message("failure", "StudentID Card Cannot Be Generated!! Already ID Card Generated for this Class And Section"));
            }
            log.error((Object)"Exception in Creating student id card generation", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<StudentTransportIDCardGeneration> StudentTransportIDCardGenerationListByClassAndSectionAndAcademicYear(Long classId, Long sectionId, Long academicYearId, Long institutionId) throws Exception {
        try {
            List<Object> studentTransportIDCardGenerations = new ArrayList();
            Class classes = this.classDAO.getClassById(classId);
            Section section = this.sectionDAO.getSectionById(sectionId);
            AcademicYear academicYear = this.academicYearDAO.getAcademicYearById(academicYearId);
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            studentTransportIDCardGenerations = this.studentTransportIDCardGenerationDAO.getStudentTransportIDCardGenerationByClassAndSectionAndAcademicYear(classes, section, academicYear, institution);
            for (StudentTransportIDCardGeneration studentTransportIDCardGeneration : studentTransportIDCardGenerations) {
                Hibernate.initialize((Object)studentTransportIDCardGeneration.getAcademicYear());
                Hibernate.initialize((Object)studentTransportIDCardGeneration.getSection());
                Hibernate.initialize((Object)studentTransportIDCardGeneration.getStudentClass());
                Hibernate.initialize((Object)studentTransportIDCardGeneration.getStudent());
                Hibernate.initialize((Object)studentTransportIDCardGeneration.getStudent().getUser());
                Hibernate.initialize((Object)studentTransportIDCardGeneration.getInstitution());
            }
            return studentTransportIDCardGenerations;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteStudentIDCard(Long classId, Long sectionId, Long academicYearId, Long institutionId) throws Exception {
        try {
            List<Object> studentTransportIDCardGenerations = new ArrayList();
            Class classes = this.classDAO.getClassById(classId);
            Section section = this.sectionDAO.getSectionById(sectionId);
            AcademicYear academicYear = this.academicYearDAO.getAcademicYearById(academicYearId);
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            studentTransportIDCardGenerations = this.studentTransportIDCardGenerationDAO.getStudentTransportIDCardGenerationByClassAndSectionAndAcademicYear(classes, section, academicYear, institution);
            for (StudentTransportIDCardGeneration studentTransportIDCardGeneration : studentTransportIDCardGenerations) {
                this.studentTransportIDCardGenerationDAO.delete(studentTransportIDCardGeneration);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void createBarCodeAndBarCodeImage(StudentTransportIDCardGeneration studentTransportIDCardGeneration) throws StudentTransportIDCardGenerationException, Exception {
        try {
            String millisecond = Long.toString(System.currentTimeMillis());
            String code = "CBSE" + millisecond;
            String[] args = studentTransportIDCardGeneration.getBarCodeImage().split("@");
            String location = args[0];
            String path = args[1];
            location = String.valueOf(location) + path;
            this.fileUploadHandler.createFolderIfNotExist(location);
            String name = String.valueOf(studentTransportIDCardGeneration.getStudent().getFirstName()) + Long.toString(System.currentTimeMillis()) + ".jpg";
            try {
                BitMatrix bitMatrix = new Code128Writer().encode(code, BarcodeFormat.CODE_128, 150, 80, null);
                MatrixToImageWriter.writeToStream((BitMatrix)bitMatrix, (String)"jpg", (OutputStream)new FileOutputStream(new File(String.valueOf(location) + name)));
            }
            catch (Exception e) {
                e.printStackTrace();
                throw e;
            }
            studentTransportIDCardGeneration.setBarCode(code);
            studentTransportIDCardGeneration.setBarCodeImage(String.valueOf(path) + name);
            this.studentTransportIDCardGenerationDAO.persist(studentTransportIDCardGeneration);
        }
        catch (Exception e) {
            e.printStackTrace();
            if (e.getClass().equals(ConstraintViolationException.class)) {
                throw new StudentTransportIDCardGenerationException(new Message("failure", "Student Transport ID Card Cannot Be Generated!! Already ID Card Generated for this Admission Number"));
            }
            log.error((Object)"Exception in Creating student id card generation", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<StudentTransportIDCardGeneration> StudentTransportIDCardGenerationListByClassAndSectionAndAcademicYear(Long classId, Long sectionId, Long academicYearId) throws Exception {
        try {
            List<Object> studentTransportIDCardGenerations = new ArrayList();
            Class classes = this.classDAO.getClassById(classId);
            Section section = this.sectionDAO.getSectionById(sectionId);
            AcademicYear academicYear = this.academicYearDAO.getAcademicYearById(academicYearId);
            studentTransportIDCardGenerations = this.studentTransportIDCardGenerationDAO.getStudentTransportIDCardGenerationByClassAndSectionAndAcademicYear(classes, section, academicYear);
            for (StudentTransportIDCardGeneration studentTransportIDCardGeneration : studentTransportIDCardGenerations) {
                Hibernate.initialize((Object)studentTransportIDCardGeneration.getAcademicYear());
                Hibernate.initialize((Object)studentTransportIDCardGeneration.getSection());
                Hibernate.initialize((Object)studentTransportIDCardGeneration.getStudentClass());
                Hibernate.initialize((Object)studentTransportIDCardGeneration.getStudent());
                Hibernate.initialize((Object)studentTransportIDCardGeneration.getStudent().getBloodGroup());
                Hibernate.initialize((Object)studentTransportIDCardGeneration.getStudent().getUser());
                Hibernate.initialize((Object)studentTransportIDCardGeneration.getInstitution());
            }
            return studentTransportIDCardGenerations;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<StudentTransportIDCardGeneration> StudentTransportIDCardGenerationListByClassAndSectionAndFeesTerm(Long classId, Long sectionId, Long feesTermId) throws Exception {
        try {
            List<Object> studentTransportIDCardGenerations = new ArrayList();
            Class classes = this.classDAO.getClassById(classId);
            Section section = this.sectionDAO.getSectionById(sectionId);
            FeesTerm feesTerm = this.feesTermDAO.getFeesTermById(feesTermId);
            studentTransportIDCardGenerations = this.studentTransportIDCardGenerationDAO.getStudentTransportIDCardGenerationByClassAndSectionAndFeesTerm(classes, section, feesTerm);
            for (StudentTransportIDCardGeneration studentTransportIDCardGeneration : studentTransportIDCardGenerations) {
                Hibernate.initialize((Object)studentTransportIDCardGeneration.getAcademicYear());
                Hibernate.initialize((Object)studentTransportIDCardGeneration.getSection());
                Hibernate.initialize((Object)studentTransportIDCardGeneration.getStudentClass());
                Hibernate.initialize((Object)studentTransportIDCardGeneration.getStudent());
                Hibernate.initialize((Object)studentTransportIDCardGeneration.getStudent().getBloodGroup());
                Hibernate.initialize((Object)studentTransportIDCardGeneration.getStudent().getUser());
                Hibernate.initialize((Object)studentTransportIDCardGeneration.getInstitution());
            }
            return studentTransportIDCardGenerations;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteStudentTransportIDCardByClassAndSectionAndAcademicYear(Long classId, Long sectionId, Long academicYearId) throws Exception {
        try {
            List<Object> studentTransportIDCardGenerations = new ArrayList();
            Class classes = this.classDAO.getClassById(classId);
            Section section = this.sectionDAO.getSectionById(sectionId);
            AcademicYear academicYear = this.academicYearDAO.getAcademicYearById(academicYearId);
            studentTransportIDCardGenerations = this.studentTransportIDCardGenerationDAO.getStudentTransportIDCardGenerationByClassAndSectionAndAcademicYear(classes, section, academicYear);
            for (StudentTransportIDCardGeneration studentTransportIDCardGeneration : studentTransportIDCardGenerations) {
                this.studentTransportIDCardGenerationDAO.delete(studentTransportIDCardGeneration);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteStudentTransportIDCardByClassAndSectionAndFeesTerm(Long classId, Long sectionId, Long feesTermId) throws Exception {
        try {
            List<Object> studentTransportIDCardGenerations = new ArrayList();
            Class classes = this.classDAO.getClassById(classId);
            Section section = this.sectionDAO.getSectionById(sectionId);
            FeesTerm feesTerm = this.feesTermDAO.getFeesTermById(feesTermId);
            studentTransportIDCardGenerations = this.studentTransportIDCardGenerationDAO.getStudentTransportIDCardGenerationByClassAndSectionAndFeesTerm(classes, section, feesTerm);
            for (StudentTransportIDCardGeneration studentTransportIDCardGeneration : studentTransportIDCardGenerations) {
                this.studentTransportIDCardGenerationDAO.delete(studentTransportIDCardGeneration);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}