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
import in.jdsoft.educationmanagement.school.model.ClassSectionCoScholasticActivityExam;
import in.jdsoft.educationmanagement.school.model.CoScholasticActivity;
import in.jdsoft.educationmanagement.school.model.StudentMarksDetailWithCoScholasticActivity;
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
@Table(name="tbl_class_section_coscholastic_activity", uniqueConstraints={@UniqueConstraint(columnNames={"class_section_id", "co_scholastic_activity_id"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class ClassSectionCoScholasticActivity
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long classSectionCosScholasticActivityId;
    private ClassSection classSection;
    private CoScholasticActivity coScholasticActivity;
    private Set<ClassSectionCoScholasticActivityExam> classSectionCoScholasticActivityExams = new LinkedHashSet<ClassSectionCoScholasticActivityExam>();
    private Set<StudentMarksDetailWithCoScholasticActivity> studentMarksDetailWithCoScholasticActivitys = new LinkedHashSet<StudentMarksDetailWithCoScholasticActivity>();

    ClassSectionCoScholasticActivity() {
    }

    public ClassSectionCoScholasticActivity(CoScholasticActivity coScholasticActivity) {
        this.coScholasticActivity = coScholasticActivity;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="class_section_coscholastic_activity_id", nullable=false)
    public Long getClassSectionCosScholasticActivityId() {
        return this.classSectionCosScholasticActivityId;
    }

    public void setClassSectionCosScholasticActivityId(Long classSectionCosScholasticActivityId) {
        this.classSectionCosScholasticActivityId = classSectionCosScholasticActivityId;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="class_section_id", nullable=false)
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@classSectionCoScholasticActivities")
    @JsonIdentityReference(alwaysAsId=true)
    @ForeignKey(name="classSectionInClassSectionCoScholasticActivity")
    public ClassSection getClassSection() {
        return this.classSection;
    }

    public void setClassSection(ClassSection classSection) {
        this.classSection = classSection;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="co_scholastic_activity_id", nullable=false)
    @ForeignKey(name="coscholasticActivityInClassSectionCoScholasticActivity")
    public CoScholasticActivity getCoScholasticActivity() {
        return this.coScholasticActivity;
    }

    public void setCoScholasticActivity(CoScholasticActivity coScholasticActivity) {
        this.coScholasticActivity = coScholasticActivity;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="classSectionCoScholasticActivity", cascade={CascadeType.PERSIST, CascadeType.REMOVE})
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@classSectionCoScholasticActivity")
    @JsonIdentityReference(alwaysAsId=true)
    @ForeignKey(name="classSectionCoScholasticActivityExamInClassSectionCoScholasticActivity")
    public Set<ClassSectionCoScholasticActivityExam> getClassSectionCoScholasticActivityExams() {
        return this.classSectionCoScholasticActivityExams;
    }

    public void setClassSectionCoScholasticActivityExams(Set<ClassSectionCoScholasticActivityExam> classSectionCoScholasticActivityExams) {
        this.classSectionCoScholasticActivityExams = classSectionCoScholasticActivityExams;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="classSectionCoScholasticActivity")
    @ForeignKey(name="studentMarksDetailWithCoScholasticActivityInClassSectionCoScholasticActivity")
    public Set<StudentMarksDetailWithCoScholasticActivity> getStudentMarksDetailWithCoScholasticActivitys() {
        return this.studentMarksDetailWithCoScholasticActivitys;
    }

    public void setStudentMarksDetailWithCoScholasticActivitys(Set<StudentMarksDetailWithCoScholasticActivity> studentMarksDetailWithCoScholasticActivitys) {
        this.studentMarksDetailWithCoScholasticActivitys = studentMarksDetailWithCoScholasticActivitys;
    }
}
