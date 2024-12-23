/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonIgnoreProperties
 *  com.fasterxml.jackson.annotation.JsonInclude
 *  com.fasterxml.jackson.annotation.JsonInclude$Include
 *  javax.persistence.Column
 *  javax.persistence.Entity
 *  javax.persistence.FetchType
 *  javax.persistence.GeneratedValue
 *  javax.persistence.GenerationType
 *  javax.persistence.Id
 *  javax.persistence.JoinColumn
 *  javax.persistence.ManyToOne
 *  javax.persistence.OneToMany
 *  javax.persistence.OrderBy
 *  javax.persistence.Table
 *  javax.persistence.UniqueConstraint
 *  org.hibernate.annotations.ForeignKey
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.ClassSection;
import in.jdsoft.educationmanagement.school.model.ClassSectionAssesmentType;
import in.jdsoft.educationmanagement.school.model.ClassSectionTermExam;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Student;
import in.jdsoft.educationmanagement.school.model.StudentMarksDetail;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tbl_student_marks", uniqueConstraints={@UniqueConstraint(columnNames={"student_mark_id", "class_section_term_exam_id"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class StudentMark
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long studentMarkId;
    private Student student;
    private ClassSection classSection;
    private ClassSectionAssesmentType classSectionAssesmentType;
    private ClassSectionTermExam classSectionTermExam;
    private AcademicYear academicYear;
    private Institution institution;
    private Set<StudentMarksDetail> studentMarksDetails = new LinkedHashSet<StudentMarksDetail>();

    public StudentMark(Student student, ClassSection classSection, ClassSectionAssesmentType classSectionAssesmentType, ClassSectionTermExam classSectionTermExam, AcademicYear academicYear, Institution institution) {
        this.student = student;
        this.classSection = classSection;
        this.classSectionAssesmentType = classSectionAssesmentType;
        this.classSectionTermExam = classSectionTermExam;
        this.academicYear = academicYear;
        this.institution = institution;
    }

    public StudentMark() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="student_mark_id", nullable=false)
    public Long getStudentMarkId() {
        return this.studentMarkId;
    }

    public void setStudentMarkId(Long studentMarkId) {
        this.studentMarkId = studentMarkId;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="student_id", nullable=false)
    @ForeignKey(name="studentInStudentMark")
    public Student getStudent() {
        return this.student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="class_section_id", nullable=false)
    @ForeignKey(name="ClassSectionInStudentMark")
    public ClassSection getClassSection() {
        return this.classSection;
    }

    public void setClassSection(ClassSection classSection) {
        this.classSection = classSection;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="class_section_assesment_type_id", nullable=false)
    @ForeignKey(name="ClassSectionAssesmentTypeInStudentMark")
    public ClassSectionAssesmentType getClassSectionAssesmentType() {
        return this.classSectionAssesmentType;
    }

    public void setClassSectionAssesmentType(ClassSectionAssesmentType classSectionAssesmentType) {
        this.classSectionAssesmentType = classSectionAssesmentType;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="class_section_term_exam_id", nullable=false)
    @ForeignKey(name="ClassSectionTermExamInStudentMark")
    public ClassSectionTermExam getClassSectionTermExam() {
        return this.classSectionTermExam;
    }

    public void setClassSectionTermExam(ClassSectionTermExam classSectionTermExam) {
        this.classSectionTermExam = classSectionTermExam;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="academic_year_id", nullable=false)
    @ForeignKey(name="AcademicYearInStudentMark")
    public AcademicYear getAcademicYear() {
        return this.academicYear;
    }

    public void setAcademicYear(AcademicYear academicYear) {
        this.academicYear = academicYear;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="studentMark")
    @ForeignKey(name="studentMarksDetailInStudentMark")
    @OrderBy(value="studentMarksDetailsId ASC")
    public Set<StudentMarksDetail> getStudentMarksDetails() {
        return this.studentMarksDetails;
    }

    public void setStudentMarksDetails(Set<StudentMarksDetail> studentMarksDetails) {
        this.studentMarksDetails = studentMarksDetails;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="institution_id", nullable=false)
    @ForeignKey(name="institutionInStudentMark")
    public Institution getInstitution() {
        return this.institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }
}
