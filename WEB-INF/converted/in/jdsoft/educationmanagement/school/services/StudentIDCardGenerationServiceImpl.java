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
import in.jdsoft.educationmanagement.school.dao.InstitutionDAO;
import in.jdsoft.educationmanagement.school.dao.SectionDAO;
import in.jdsoft.educationmanagement.school.dao.StudentIDCardGenerationDAO;
import in.jdsoft.educationmanagement.school.exceptions.StudentIDCardGenerationException;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.Class;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.Section;
import in.jdsoft.educationmanagement.school.model.StudentIDCardGeneration;
import in.jdsoft.educationmanagement.school.services.StudentIDCardGenerationService;
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

@Service(value="studentIDCardGenerationService")
public class StudentIDCardGenerationServiceImpl
implements StudentIDCardGenerationService {
    @Autowired
    StudentIDCardGenerationDAO studentIDCardGenerationDAO;
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

    @Override
    public void createBarCodeAndBarCodeImage(Set<StudentIDCardGeneration> studentIDCardGenerations) throws StudentIDCardGenerationException, Exception {
        try {
            for (StudentIDCardGeneration studentIDCardGeneration : studentIDCardGenerations) {
                String millisecond = Long.toString(System.currentTimeMillis());
                String code = "CBSE" + millisecond;
                String[] args = studentIDCardGeneration.getBarCodeImage().split("@");
                String location = args[0];
                String path = args[1];
                location = String.valueOf(location) + path;
                this.fileUploadHandler.createFolderIfNotExist(location);
                String name = String.valueOf(studentIDCardGeneration.getFirstName()) + Long.toString(System.currentTimeMillis()) + ".jpg";
                try {
                    BitMatrix bitMatrix = new Code128Writer().encode(code, BarcodeFormat.CODE_128, 150, 80, null);
                    MatrixToImageWriter.writeToStream((BitMatrix)bitMatrix, (String)"jpg", (OutputStream)new FileOutputStream(new File(String.valueOf(location) + name)));
                }
                catch (Exception e) {
                    e.printStackTrace();
                    throw e;
                }
                studentIDCardGeneration.setBarCode(code);
                studentIDCardGeneration.setBarCodeImage(String.valueOf(path) + name);
                this.studentIDCardGenerationDAO.persist(studentIDCardGeneration);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            if (e.getClass().equals(ConstraintViolationException.class)) {
                throw new StudentIDCardGenerationException(new Message("failure", "StudentID Card Cannot Be Generated!! Already ID Card Generated for this Class And Section"));
            }
            log.error((Object)"Exception in Creating student id card generation", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<StudentIDCardGeneration> studentIDCardGenerationListByClassAndSectionAndAcademicYear(Long classId, Long sectionId, Long academicYearId, Long institutionId) throws Exception {
        try {
            List<Object> studentIDCardGenerations = new ArrayList();
            Class classes = this.classDAO.getClassById(classId);
            Section section = this.sectionDAO.getSectionById(sectionId);
            AcademicYear academicYear = this.academicYearDAO.getAcademicYearById(academicYearId);
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            studentIDCardGenerations = this.studentIDCardGenerationDAO.getStudentIDCardGenerationByClassAndSectionAndAcademicYear(classes, section, academicYear, institution);
            for (StudentIDCardGeneration studentIDCardGeneration : studentIDCardGenerations) {
                Hibernate.initialize((Object)studentIDCardGeneration.getAcademicYear());
                Hibernate.initialize((Object)studentIDCardGeneration.getSection());
                Hibernate.initialize((Object)studentIDCardGeneration.getStudentClass());
                Hibernate.initialize((Object)studentIDCardGeneration.getStudent());
                Hibernate.initialize((Object)studentIDCardGeneration.getStudent().getUser());
                Hibernate.initialize((Object)studentIDCardGeneration.getInstitution());
                Hibernate.initialize((Object)studentIDCardGeneration.getBloodGroup());
            }
            return studentIDCardGenerations;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteStudentIDCard(Long classId, Long sectionId, Long academicYearId, Long institutionId) throws Exception {
        try {
            List<Object> studentIDCardGenerations = new ArrayList();
            Class classes = this.classDAO.getClassById(classId);
            Section section = this.sectionDAO.getSectionById(sectionId);
            AcademicYear academicYear = this.academicYearDAO.getAcademicYearById(academicYearId);
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            studentIDCardGenerations = this.studentIDCardGenerationDAO.getStudentIDCardGenerationByClassAndSectionAndAcademicYear(classes, section, academicYear, institution);
            for (StudentIDCardGeneration studentIDCardGeneration : studentIDCardGenerations) {
                this.studentIDCardGenerationDAO.delete(studentIDCardGeneration);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
