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
 *  javax.persistence.Column
 *  javax.persistence.Entity
 *  javax.persistence.FetchType
 *  javax.persistence.GeneratedValue
 *  javax.persistence.GenerationType
 *  javax.persistence.Id
 *  javax.persistence.JoinColumn
 *  javax.persistence.ManyToOne
 *  javax.persistence.Table
 *  javax.persistence.Temporal
 *  javax.persistence.TemporalType
 *  org.hibernate.annotations.ForeignKey
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.Class;
import in.jdsoft.educationmanagement.school.model.ClassSectionModule;
import in.jdsoft.educationmanagement.school.model.Section;
import in.jdsoft.educationmanagement.school.model.Student;
import in.jdsoft.educationmanagement.school.model.StudentAttendanceType;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tbl_staff_module_attendance")
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class StaffModuleAttendance
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long staffModuleAttendanceId;
    private Student student;
    private Class studentClass;
    private Section section;
    private ClassSectionModule classSectionModule;
    private Date attendanceDate;
    private AcademicYear acdemicYear;
    private StudentAttendanceType studentAttendanceType;
    private Time attendanceTime;

    StaffModuleAttendance() {
    }

    public StaffModuleAttendance(Student student, Class studentClass, Section section, ClassSectionModule classSectionModule, Date attendanceDate, Time attendanceTime, AcademicYear academicYear, StudentAttendanceType studentAttendanceType) {
        this.student = student;
        this.studentClass = studentClass;
        this.section = section;
        this.classSectionModule = classSectionModule;
        this.attendanceDate = attendanceDate;
        this.studentAttendanceType = studentAttendanceType;
        this.acdemicYear = academicYear;
        this.attendanceTime = attendanceTime;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="staff_module_attendance_id", nullable=false)
    public Long getStaffModuleAttendanceId() {
        return this.staffModuleAttendanceId;
    }

    public void setStaffModuleAttendanceId(Long staffModuleAttendanceId) {
        this.staffModuleAttendanceId = staffModuleAttendanceId;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="student_id", nullable=false)
    @ForeignKey(name="studentInStaffModuleAttendance")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@staffModuleAttendances")
    @JsonIdentityReference(alwaysAsId=true)
    public Student getStudent() {
        return this.student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="class_id", nullable=false)
    @ForeignKey(name="studentClassInStaffModuleAttendance")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@staffModuleAttendances")
    @JsonIdentityReference(alwaysAsId=true)
    public Class getStudentClass() {
        return this.studentClass;
    }

    public void setStudentClass(Class studentClass) {
        this.studentClass = studentClass;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="section_id", nullable=false)
    @ForeignKey(name="sectionInStaffModuleAttendance")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@staffModuleAttendances")
    @JsonIdentityReference(alwaysAsId=true)
    public Section getSection() {
        return this.section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="class_section_module_id", nullable=false)
    @ForeignKey(name="classSectionModuleInStaffModuleAttendance")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@staffModuleAttendances")
    @JsonIdentityReference(alwaysAsId=true)
    public ClassSectionModule getClassSectionModule() {
        return this.classSectionModule;
    }

    public void setClassSectionModule(ClassSectionModule classSectionModule) {
        this.classSectionModule = classSectionModule;
    }

    @Temporal(value=TemporalType.DATE)
    @Column(name="attendance_date", nullable=false)
    public Date getAttendanceDate() {
        return this.attendanceDate;
    }

    public void setAttendanceDate(Date attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="academic_year_id", nullable=false)
    @ForeignKey(name="academicYearInStaffModuleAttendance")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@staffModuleAttendance")
    @JsonIdentityReference(alwaysAsId=true)
    public AcademicYear getAcdemicYear() {
        return this.acdemicYear;
    }

    public void setAcdemicYear(AcademicYear acdemicYear) {
        this.acdemicYear = acdemicYear;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="student_attendance_type_id", nullable=false)
    @ForeignKey(name="studentAttendanceTypeInStaffModuleAttendance")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@staffModuleAttendances")
    @JsonIdentityReference(alwaysAsId=true)
    public StudentAttendanceType getStudentAttendanceType() {
        return this.studentAttendanceType;
    }

    public void setStudentAttendanceType(StudentAttendanceType studentAttendanceType) {
        this.studentAttendanceType = studentAttendanceType;
    }

    @Column(name="attendance_time", nullable=false)
    public Time getAttendanceTime() {
        return this.attendanceTime;
    }

    public void setAttendanceTime(Time attendanceTime) {
        this.attendanceTime = attendanceTime;
    }
}
