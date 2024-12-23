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

import in.jdsoft.educationmanagement.school.model.ClassSectionModuleSkill;
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
@DiscriminatorValue(value="studentmarksdetailwithmoduleskill")
public class StudentMarksDetailWithModuleSkill
extends StudentMarksDetail {
    private static final long serialVersionUID = 1L;
    private ClassSectionModuleSkill classSectionModuleSkill;

    public StudentMarksDetailWithModuleSkill(Double assessmentMark, ClassSectionTermExamActivity classSectionTermExamActivity, StudentMark studentMark, ClassSectionModuleSkill classSectionModuleSkill) {
        this.classSectionModuleSkill = classSectionModuleSkill;
    }

    StudentMarksDetailWithModuleSkill() {
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="class_section_module_skill_id", nullable=true)
    @ForeignKey(name="classSectionModuleSkillInStudentMarksDetailWithModuleSkill")
    public ClassSectionModuleSkill getClassSectionModuleSkill() {
        return this.classSectionModuleSkill;
    }

    public void setClassSectionModuleSkill(ClassSectionModuleSkill classSectionModuleSkill) {
        this.classSectionModuleSkill = classSectionModuleSkill;
    }
}
