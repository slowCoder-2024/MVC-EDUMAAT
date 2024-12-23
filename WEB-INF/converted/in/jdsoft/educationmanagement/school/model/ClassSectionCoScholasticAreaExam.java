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
 *  javax.persistence.Table
 *  javax.persistence.UniqueConstraint
 *  org.hibernate.annotations.ForeignKey
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import in.jdsoft.educationmanagement.school.model.ClassSectionCoScholasticArea;
import in.jdsoft.educationmanagement.school.model.ClassSectionTerm;
import in.jdsoft.educationmanagement.school.model.ClassSectionTermExam;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tbl_class_section_coscholastic_area_exam", uniqueConstraints={@UniqueConstraint(columnNames={"class_section_coscholastic_area_id", "class_section_term_id", "class_section_term_exam_id"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class ClassSectionCoScholasticAreaExam
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long classSectionCoScholasticAreaExamId;
    private ClassSectionCoScholasticArea classSectionCoScholasticArea;
    private ClassSectionTerm classSectionTerm;
    private ClassSectionTermExam classSectionTermExam;

    ClassSectionCoScholasticAreaExam() {
    }

    public ClassSectionCoScholasticAreaExam(ClassSectionCoScholasticArea classSectionCoScholasticArea, ClassSectionTermExam classSectionTermExam) {
        this.classSectionCoScholasticArea = classSectionCoScholasticArea;
        this.classSectionTermExam = classSectionTermExam;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="class_section_coscholastic_area_exam_id", nullable=false)
    public Long getClassSectionCoScholasticAreaExamId() {
        return this.classSectionCoScholasticAreaExamId;
    }

    public void setClassSectionCoScholasticAreaExamId(Long classSectionCoScholasticAreaExamId) {
        this.classSectionCoScholasticAreaExamId = classSectionCoScholasticAreaExamId;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="class_section_coscholastic_area_id", nullable=false)
    @ForeignKey(name="classSectionCoScholasticAreaInClassSectionCoScholasticAreaExam")
    public ClassSectionCoScholasticArea getClassSectionCoScholasticArea() {
        return this.classSectionCoScholasticArea;
    }

    public void setClassSectionCoScholasticArea(ClassSectionCoScholasticArea classSectionCoScholasticArea) {
        this.classSectionCoScholasticArea = classSectionCoScholasticArea;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="class_section_term_id", nullable=false)
    @ForeignKey(name="classSectionTermInClassSectionCoScholasticAreaExam")
    public ClassSectionTerm getClassSectionTerm() {
        return this.classSectionTerm;
    }

    public void setClassSectionTerm(ClassSectionTerm classSectionTerm) {
        this.classSectionTerm = classSectionTerm;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="class_section_term_exam_id", nullable=false)
    @ForeignKey(name="classSectionTermExamInClassSectionCoScholasticAreaExam")
    public ClassSectionTermExam getClassSectionTermExam() {
        return this.classSectionTermExam;
    }

    public void setClassSectionTermExam(ClassSectionTermExam classSectionTermExam) {
        this.classSectionTermExam = classSectionTermExam;
    }
}
