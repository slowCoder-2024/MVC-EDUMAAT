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
 *  javax.persistence.UniqueConstraint
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
import in.jdsoft.educationmanagement.school.model.Institution;
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
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tbl_student_attendance", uniqueConstraints={@UniqueConstraint(columnNames={"attendance_date", "student_id"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class StudentAttendance
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long studentAttendanceId;
    private Student student;
    private Class studentClass;
    private Section section;
    private AcademicYear academicYear;
    private Date studentAttendanceDate;
    private StudentAttendanceType studentAttendanceType;
    private Time attendanceTime;
    private Institution institution;
    private String dayAttendanceType;

    StudentAttendance() {
    }

    public StudentAttendance(Student student, Class studentClass, Section section, AcademicYear academicYear, Date studentAttendanceDate, Time attendanceTime, StudentAttendanceType studentAttendanceType, Institution institution, String dayAttendanceType) {
        this.student = student;
        this.studentClass = studentClass;
        this.section = section;
        this.academicYear = academicYear;
        this.studentAttendanceDate = studentAttendanceDate;
        this.studentAttendanceType = studentAttendanceType;
        this.attendanceTime = attendanceTime;
        this.institution = institution;
        this.dayAttendanceType = dayAttendanceType;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="student_attendance_id", nullable=false)
    public Long getStudentAttendanceId() {
        return this.studentAttendanceId;
    }

    public void setStudentAttendanceId(Long studentAttendanceId) {
        this.studentAttendanceId = studentAttendanceId;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="student_id", nullable=false)
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@studentAttendances")
    @JsonIdentityReference(alwaysAsId=true)
    @ForeignKey(name="studentInStudentAttendance")
    public Student getStudent() {
        return this.student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="class_id", nullable=false)
    @ForeignKey(name="studentClassInStudentAttendance")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@studentAttendances")
    @JsonIdentityReference(alwaysAsId=true)
    public Class getStudentClass() {
        return this.studentClass;
    }

    public void setStudentClass(Class studentClass) {
        this.studentClass = studentClass;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="section_id", nullable=false)
    @ForeignKey(name="sectionInStudentAttendance")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@studentAttendances")
    @JsonIdentityReference(alwaysAsId=true)
    public Section getSection() {
        return this.section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="academic_year_id", nullable=false)
    @ForeignKey(name="academicYearInStudentAttendance")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@studentAttendances")
    @JsonIdentityReference(alwaysAsId=true)
    public AcademicYear getAcademicYear() {
        return this.academicYear;
    }

    public void setAcademicYear(AcademicYear academicYear) {
        this.academicYear = academicYear;
    }

    @Temporal(value=TemporalType.DATE)
    @Column(name="attendance_date", nullable=false)
    public Date getStudentAttendanceDate() {
        return this.studentAttendanceDate;
    }

    public void setStudentAttendanceDate(Date studentAttendanceDate) {
        this.studentAttendanceDate = studentAttendanceDate;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="student_attendance_type_id", nullable=false)
    @ForeignKey(name="studentAttendanceTypeInStudentAttendance")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@studentAttendances")
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

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="institution_id", nullable=false)
    @ForeignKey(name="institutionInStudentAttendance")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@studentAttendances")
    @JsonIdentityReference(alwaysAsId=true)
    public Institution getInstitution() {
        return this.institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    @Column(name="day_attendance_type", nullable=false, length=20)
    public String getDayAttendanceType() {
        return this.dayAttendanceType;
    }

    public void setDayAttendanceType(String dayAttendanceType) {
        this.dayAttendanceType = dayAttendanceType;
    }
}
