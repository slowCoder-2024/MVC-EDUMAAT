/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.DiscriminatorValue
 *  javax.persistence.Entity
 *  javax.persistence.FetchType
 *  javax.persistence.JoinColumn
 *  javax.persistence.ManyToOne
 *  org.hibernate.annotations.ForeignKey
 */
package in.jdsoft.educationmanagement.school.model;

import in.jdsoft.educationmanagement.school.model.ClassSectionCoScholasticArea;
import in.jdsoft.educationmanagement.school.model.ClassSectionTermExamActivity;
import in.jdsoft.educationmanagement.school.model.StudentMark;
import in.jdsoft.educationmanagement.school.model.StudentMarksDetail;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.ForeignKey;

@Entity
@DiscriminatorValue(value="studentmarksdetailwithcoscholasticarea")
public class StudentMarksDetailWithCoScholasticArea
extends StudentMarksDetail {
    private static final long serialVersionUID = 1L;
    private ClassSectionCoScholasticArea classSectionCoScholasticArea;

    public StudentMarksDetailWithCoScholasticArea(Double assessmentMark, ClassSectionTermExamActivity classSectionTermExamActivity, StudentMark studentMark, ClassSectionCoScholasticArea classSectionCoScholasticArea) {
        this.classSectionCoScholasticArea = classSectionCoScholasticArea;
    }

    StudentMarksDetailWithCoScholasticArea() {
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="class_section_coscholastic_area_id", nullable=true)
    @ForeignKey(name="classSectionCoScholasticAreaInStudentMarksDetailWithCoScholasticArea")
    public ClassSectionCoScholasticArea getClassSectionCoScholasticArea() {
        return this.classSectionCoScholasticArea;
    }

    public void setClassSectionCoScholasticArea(ClassSectionCoScholasticArea classSectionCoScholasticArea) {
        this.classSectionCoScholasticArea = classSectionCoScholasticArea;
    }
}
