/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonIdentityInfo
 *  com.fasterxml.jackson.annotation.JsonIdentityReference
 *  com.fasterxml.jackson.annotation.JsonIgnoreProperties
 *  com.fasterxml.jackson.annotation.JsonInclude
 *  com.fasterxml.jackson.annotation.JsonInclude$Include
 *  com.fasterxml.jackson.annotation.ObjectIdGenerators$IntSequenceGenerator
 *  javax.persistence.CascadeType
 *  javax.persistence.Column
 *  javax.persistence.Entity
 *  javax.persistence.FetchType
 *  javax.persistence.GeneratedValue
 *  javax.persistence.GenerationType
 *  javax.persistence.Id
 *  javax.persistence.JoinColumn
 *  javax.persistence.ManyToOne
 *  javax.persistence.OneToMany
 *  javax.persistence.Table
 *  javax.persistence.UniqueConstraint
 *  org.hibernate.annotations.ForeignKey
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import in.jdsoft.educationmanagement.school.model.ClassSectionCoScholasticActivityExam;
import in.jdsoft.educationmanagement.school.model.ClassSectionCoScholasticAreaExam;
import in.jdsoft.educationmanagement.school.model.ClassSectionModuleExam;
import in.jdsoft.educationmanagement.school.model.ClassSectionTerm;
import in.jdsoft.educationmanagement.school.model.ClassSectionTermExamActivity;
import in.jdsoft.educationmanagement.school.model.StudentMark;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tbl_class_section_term_exam", uniqueConstraints={@UniqueConstraint(columnNames={"class_section_term_id", "term_exam_name"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class ClassSectionTermExam
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long classSectionTermExamId;
    private ClassSectionTerm classSectionTerm;
    private String classSectionTermExamName;
    private Double classSectionTermExamPercentage;
    private Set<ClassSectionModuleExam> classSectionModuleExams = new LinkedHashSet<ClassSectionModuleExam>();
    private Set<ClassSectionCoScholasticAreaExam> classSectionAreaCoScholasticAreaExams = new LinkedHashSet<ClassSectionCoScholasticAreaExam>();
    private Set<ClassSectionCoScholasticActivityExam> classSectionAreaCoScholasticActivityExams = new LinkedHashSet<ClassSectionCoScholasticActivityExam>();
    private Set<ClassSectionTermExamActivity> classSectionTermExamActivitys = new LinkedHashSet<ClassSectionTermExamActivity>();
    private Set<StudentMark> studentMarks = new LinkedHashSet<StudentMark>();

    ClassSectionTermExam() {
    }

    public ClassSectionTermExam(ClassSectionTerm classSectionTerm, String classSectionTermExamName, Double classSectionTermExamPercentage) {
        this.classSectionTerm = classSectionTerm;
        this.classSectionTermExamName = classSectionTermExamName;
        this.classSectionTermExamPercentage = classSectionTermExamPercentage;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="class_section_term_exam_id", nullable=false)
    public Long getClassSectionTermExamId() {
        return this.classSectionTermExamId;
    }

    public void setClassSectionTermExamId(Long classSectionTermExamId) {
        this.classSectionTermExamId = classSectionTermExamId;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="class_section_term_id", nullable=false)
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@classSectionTermExams")
    @JsonIdentityReference(alwaysAsId=true)
    @ForeignKey(name="classSectionTermInClassSectionTermExam")
    public ClassSectionTerm getClassSectionTerm() {
        return this.classSectionTerm;
    }

    public void setClassSectionTerm(ClassSectionTerm classSectionTerm) {
        this.classSectionTerm = classSectionTerm;
    }

    @Column(name="term_exam_name", nullable=false, length=100)
    public String getClassSectionTermExamName() {
        return this.classSectionTermExamName;
    }

    public void setClassSectionTermExamName(String classSectionTermExamName) {
        this.classSectionTermExamName = classSectionTermExamName;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="classSectionTermExam")
    @ForeignKey(name="classSectionModuleExamInClassSectionTermExam")
    public Set<ClassSectionModuleExam> getClassSectionModuleExams() {
        return this.classSectionModuleExams;
    }

    public void setClassSectionModuleExams(Set<ClassSectionModuleExam> classSectionModuleExams) {
        this.classSectionModuleExams = classSectionModuleExams;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="classSectionTermExam")
    @ForeignKey(name="classSectionCoScholasticAreaExamInClassSectionTermExam")
    public Set<ClassSectionCoScholasticAreaExam> getClassSectionAreaCoScholasticAreaExams() {
        return this.classSectionAreaCoScholasticAreaExams;
    }

    public void setClassSectionAreaCoScholasticAreaExams(Set<ClassSectionCoScholasticAreaExam> classSectionAreaCoScholasticAreaExams) {
        this.classSectionAreaCoScholasticAreaExams = classSectionAreaCoScholasticAreaExams;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="classSectionTermExam")
    @ForeignKey(name="classSectionCoScholasticActivityExamInClassSectionTermExam")
    public Set<ClassSectionCoScholasticActivityExam> getClassSectionAreaCoScholasticActivityExams() {
        return this.classSectionAreaCoScholasticActivityExams;
    }

    public void setClassSectionAreaCoScholasticActivityExams(Set<ClassSectionCoScholasticActivityExam> classSectionAreaCoScholasticActivityExams) {
        this.classSectionAreaCoScholasticActivityExams = classSectionAreaCoScholasticActivityExams;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="classSectionTermExam", cascade={CascadeType.PERSIST, CascadeType.REMOVE})
    @ForeignKey(name="classSectionTermExamActivityInClassSectionTermExam")
    public Set<ClassSectionTermExamActivity> getClassSectionTermExamActivitys() {
        return this.classSectionTermExamActivitys;
    }

    public void setClassSectionTermExamActivitys(Set<ClassSectionTermExamActivity> classSectionTermExamActivitys) {
        this.classSectionTermExamActivitys = classSectionTermExamActivitys;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="classSectionTermExam")
    @ForeignKey(name="studentMarksInClassSectionTermExam")
    public Set<StudentMark> getStudentMarks() {
        return this.studentMarks;
    }

    public void setStudentMarks(Set<StudentMark> studentMarks) {
        this.studentMarks = studentMarks;
    }

    @Column(name="class_section_term_exam_percentage", nullable=false, length=100)
    public Double getClassSectionTermExamPercentage() {
        return this.classSectionTermExamPercentage;
    }

    public void setClassSectionTermExamPercentage(Double classSectionTermExamPercentage) {
        this.classSectionTermExamPercentage = classSectionTermExamPercentage;
    }
}
