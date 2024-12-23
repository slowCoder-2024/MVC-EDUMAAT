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
import in.jdsoft.educationmanagement.school.model.ClassSection;
import in.jdsoft.educationmanagement.school.model.ClassSectionCoScholasticAreaExam;
import in.jdsoft.educationmanagement.school.model.CoScholasticArea;
import in.jdsoft.educationmanagement.school.model.StudentMarksDetailWithCoScholasticArea;
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
@Table(name="tbl_class_section_coscholastic_area", uniqueConstraints={@UniqueConstraint(columnNames={"class_section_id", "co_scholastic_area_id"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class ClassSectionCoScholasticArea
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long classSectionCosScholasticAreaId;
    private ClassSection classSection;
    private CoScholasticArea coScholasticArea;
    private Set<ClassSectionCoScholasticAreaExam> classSectionCoScholasticAreaExams = new LinkedHashSet<ClassSectionCoScholasticAreaExam>();
    private Set<StudentMarksDetailWithCoScholasticArea> studentMarksDetailWithCoScholasticAreas = new LinkedHashSet<StudentMarksDetailWithCoScholasticArea>();

    ClassSectionCoScholasticArea() {
    }

    public ClassSectionCoScholasticArea(CoScholasticArea coScholasticArea) {
        this.coScholasticArea = coScholasticArea;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="class_section_coscholastic_area_id", nullable=false)
    public Long getClassSectionCosScholasticAreaId() {
        return this.classSectionCosScholasticAreaId;
    }

    public void setClassSectionCosScholasticAreaId(Long classSectionCosScholasticAreaId) {
        this.classSectionCosScholasticAreaId = classSectionCosScholasticAreaId;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="class_section_id", nullable=false)
    @ForeignKey(name="classSectionInClassSectionCoScholasticArea")
    public ClassSection getClassSection() {
        return this.classSection;
    }

    public void setClassSection(ClassSection classSection) {
        this.classSection = classSection;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="co_scholastic_area_id", nullable=false)
    @ForeignKey(name="coscholasticAreaInClassSectionCoScholasticArea")
    public CoScholasticArea getCoScholasticArea() {
        return this.coScholasticArea;
    }

    public void setCoScholasticArea(CoScholasticArea coScholasticArea) {
        this.coScholasticArea = coScholasticArea;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="classSectionCoScholasticArea", cascade={CascadeType.PERSIST, CascadeType.REMOVE})
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@classSectionCoScholasticArea")
    @JsonIdentityReference(alwaysAsId=true)
    @ForeignKey(name="classSectionCoScholasticAreaExamInClassSectionCoScholasticArea")
    public Set<ClassSectionCoScholasticAreaExam> getClassSectionCoScholasticAreaExams() {
        return this.classSectionCoScholasticAreaExams;
    }

    public void setClassSectionCoScholasticAreaExams(Set<ClassSectionCoScholasticAreaExam> classSectionCoScholasticAreaExams) {
        this.classSectionCoScholasticAreaExams = classSectionCoScholasticAreaExams;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="classSectionCoScholasticArea")
    @ForeignKey(name="studentMarksDetailWithCoScholasticAreaInClassSectionCoScholasticArea")
    public Set<StudentMarksDetailWithCoScholasticArea> getStudentMarksDetailWithCoScholasticAreas() {
        return this.studentMarksDetailWithCoScholasticAreas;
    }

    public void setStudentMarksDetailWithCoScholasticAreas(Set<StudentMarksDetailWithCoScholasticArea> studentMarksDetailWithCoScholasticAreas) {
        this.studentMarksDetailWithCoScholasticAreas = studentMarksDetailWithCoScholasticAreas;
    }
}
