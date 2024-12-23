/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonIdentityInfo
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
 *  javax.persistence.OrderBy
 *  javax.persistence.Table
 *  org.hibernate.annotations.ForeignKey
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import in.jdsoft.educationmanagement.school.model.Class;
import in.jdsoft.educationmanagement.school.model.ClassSectionAssesmentType;
import in.jdsoft.educationmanagement.school.model.ClassSectionCoScholasticActivity;
import in.jdsoft.educationmanagement.school.model.ClassSectionCoScholasticArea;
import in.jdsoft.educationmanagement.school.model.ClassSectionModule;
import in.jdsoft.educationmanagement.school.model.ClassSectionTerm;
import in.jdsoft.educationmanagement.school.model.ReportCardGenerator;
import in.jdsoft.educationmanagement.school.model.Section;
import in.jdsoft.educationmanagement.school.model.Staff;
import in.jdsoft.educationmanagement.school.model.StudentMark;
import in.jdsoft.educationmanagement.school.model.TimeTableGenerator;
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
import javax.persistence.OrderBy;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tbl_class_section")
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class ClassSection
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long classSectionId;
    private Class classSection;
    private Section sectionClass;
    private Staff classStaff;
    private Integer classSectionExamConfigStatus;
    private Set<ClassSectionTerm> classSectionTerms = new LinkedHashSet<ClassSectionTerm>();
    private Set<ClassSectionModule> classSectionModules = new LinkedHashSet<ClassSectionModule>();
    private Set<ClassSectionCoScholasticArea> classSectionCoScholasticAreas = new LinkedHashSet<ClassSectionCoScholasticArea>();
    private Set<ClassSectionCoScholasticActivity> classSectionCoScholasticActivities = new LinkedHashSet<ClassSectionCoScholasticActivity>();
    private Set<ClassSectionAssesmentType> classSectionAssesmentType = new LinkedHashSet<ClassSectionAssesmentType>();
    private Set<TimeTableGenerator> timeTableGenerators = new LinkedHashSet<TimeTableGenerator>();
    private Set<StudentMark> studentMarks = new LinkedHashSet<StudentMark>();
    private Set<ReportCardGenerator> reportCardGenerator = new LinkedHashSet<ReportCardGenerator>(0);

    ClassSection() {
    }

    public ClassSection(Class classSection, Section sectionClass, Staff classStaff, Integer classSectionExamConfigStatus) {
        this.classSection = classSection;
        this.sectionClass = sectionClass;
        this.classSectionExamConfigStatus = classSectionExamConfigStatus;
        this.classStaff = classStaff;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="class_section_id", nullable=false)
    public Long getClassSectionId() {
        return this.classSectionId;
    }

    public void setClassSectionId(Long classSectionId) {
        this.classSectionId = classSectionId;
    }

    @ManyToOne
    @JoinColumn(name="class_id")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@classSections")
    @OrderBy(value="classId ASC")
    public Class getClassSection() {
        return this.classSection;
    }

    public void setClassSection(Class classSection) {
        this.classSection = classSection;
    }

    @ManyToOne
    @JoinColumn(name="section_id")
    @OrderBy(value="sectionId ASC")
    public Section getSectionClass() {
        return this.sectionClass;
    }

    public void setSectionClass(Section sectionClass) {
        this.sectionClass = sectionClass;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="classSection", cascade={CascadeType.PERSIST, CascadeType.REMOVE})
    @ForeignKey(name="classSectionTermInClassSection")
    @OrderBy(value="classSectionTermId")
    public Set<ClassSectionTerm> getClassSectionTerms() {
        return this.classSectionTerms;
    }

    public void setClassSectionTerms(Set<ClassSectionTerm> classSectionTerms) {
        this.classSectionTerms = classSectionTerms;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="classSection", cascade={CascadeType.PERSIST, CascadeType.REMOVE})
    @ForeignKey(name="classSectionModuleInClassSection")
    public Set<ClassSectionModule> getClassSectionModules() {
        return this.classSectionModules;
    }

    public void setClassSectionModules(Set<ClassSectionModule> classSectionModules) {
        this.classSectionModules = classSectionModules;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="classSection", cascade={CascadeType.PERSIST, CascadeType.REMOVE})
    @ForeignKey(name="classSectionCoScholasticAreaInClassSection")
    public Set<ClassSectionCoScholasticArea> getClassSectionCoScholasticAreas() {
        return this.classSectionCoScholasticAreas;
    }

    public void setClassSectionCoScholasticAreas(Set<ClassSectionCoScholasticArea> classSectionCoScholasticAreas) {
        this.classSectionCoScholasticAreas = classSectionCoScholasticAreas;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="classSection", cascade={CascadeType.PERSIST, CascadeType.REMOVE})
    @ForeignKey(name="classSectionCoScholasticActivityInClassSection")
    public Set<ClassSectionCoScholasticActivity> getClassSectionCoScholasticActivities() {
        return this.classSectionCoScholasticActivities;
    }

    public void setClassSectionCoScholasticActivities(Set<ClassSectionCoScholasticActivity> classSectionCoScholasticActivities) {
        this.classSectionCoScholasticActivities = classSectionCoScholasticActivities;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="classSection", cascade={CascadeType.REMOVE})
    @ForeignKey(name="classSectionAssessmentTypeInClassSection")
    public Set<ClassSectionAssesmentType> getClassSectionAssesmentType() {
        return this.classSectionAssesmentType;
    }

    public void setClassSectionAssesmentType(Set<ClassSectionAssesmentType> classSectionAssesmentType) {
        this.classSectionAssesmentType = classSectionAssesmentType;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="classSection", cascade={CascadeType.REMOVE})
    @ForeignKey(name="timeTableGeneratorsInClassSection")
    public Set<TimeTableGenerator> getTimeTableGenerators() {
        return this.timeTableGenerators;
    }

    public void setTimeTableGenerators(Set<TimeTableGenerator> timeTableGenerators) {
        this.timeTableGenerators = timeTableGenerators;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="classSection")
    @ForeignKey(name="studentMarksInClassSection")
    public Set<StudentMark> getStudentMarks() {
        return this.studentMarks;
    }

    public void setStudentMarks(Set<StudentMark> studentMarks) {
        this.studentMarks = studentMarks;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="classSection")
    @ForeignKey(name="reportCardGeneratorInClassSection")
    public Set<ReportCardGenerator> getReportCardGenerator() {
        return this.reportCardGenerator;
    }

    public void setReportCardGenerator(Set<ReportCardGenerator> reportCardGenerator) {
        this.reportCardGenerator = reportCardGenerator;
    }

    public Integer getClassSectionExamConfigStatus() {
        return this.classSectionExamConfigStatus;
    }

    public void setClassSectionExamConfigStatus(Integer classSectionExamConfigStatus) {
        this.classSectionExamConfigStatus = classSectionExamConfigStatus;
    }

    @ManyToOne
    @JoinColumn(name="staff_id")
    @OrderBy(value="staffId ASC")
    public Staff getClassStaff() {
        return this.classStaff;
    }

    public void setClassStaff(Staff classStaff) {
        this.classStaff = classStaff;
    }
}
