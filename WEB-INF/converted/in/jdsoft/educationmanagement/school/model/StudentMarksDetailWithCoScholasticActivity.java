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

import in.jdsoft.educationmanagement.school.model.ClassSectionCoScholasticActivity;
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
@DiscriminatorValue(value="studentmarksdetailwithcoScholasticactivity")
public class StudentMarksDetailWithCoScholasticActivity
extends StudentMarksDetail {
    private static final long serialVersionUID = 1L;
    private ClassSectionCoScholasticActivity classSectionCoScholasticActivity;

    public StudentMarksDetailWithCoScholasticActivity(Double assessmentMark, ClassSectionTermExamActivity classSectionTermExamActivity, StudentMark studentMark, ClassSectionCoScholasticActivity classSectionCoScholasticActivity) {
        this.classSectionCoScholasticActivity = classSectionCoScholasticActivity;
    }

    StudentMarksDetailWithCoScholasticActivity() {
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="class_section_coscholastic_activity_id", nullable=true)
    @ForeignKey(name="classSectionCoScholasticActivityInStudentMarksDetailWithCoScholasticActivity")
    public ClassSectionCoScholasticActivity getClassSectionCoScholasticActivity() {
        return this.classSectionCoScholasticActivity;
    }

    public void setClassSectionCoScholasticActivity(ClassSectionCoScholasticActivity classSectionCoScholasticActivity) {
        this.classSectionCoScholasticActivity = classSectionCoScholasticActivity;
    }
}
