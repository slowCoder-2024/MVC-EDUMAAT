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
 *  javax.persistence.OneToMany
 *  javax.persistence.Table
 *  javax.persistence.UniqueConstraint
 *  org.hibernate.annotations.ForeignKey
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import in.jdsoft.educationmanagement.school.model.StaffModuleAttendance;
import in.jdsoft.educationmanagement.school.model.StudentAttendance;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tbl_student_attendance_type", uniqueConstraints={@UniqueConstraint(columnNames={"student_attendance_type_name"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class StudentAttendanceType
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long studentAttendaceTypeId;
    private String studentAttendanceTypeName;
    private boolean defaultSelected;
    private Set<StaffModuleAttendance> staffModuleAttendances = new LinkedHashSet<StaffModuleAttendance>();
    private Set<StudentAttendance> studentAttendances = new LinkedHashSet<StudentAttendance>();

    StudentAttendanceType() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="student_attendance_type_id", nullable=false)
    public Long getStudentAttendaceTypeId() {
        return this.studentAttendaceTypeId;
    }

    public void setStudentAttendaceTypeId(Long studentAttendaceTypeId) {
        this.studentAttendaceTypeId = studentAttendaceTypeId;
    }

    @Column(name="student_attendance_type_name", nullable=false, length=100)
    public String getStudentAttendanceTypeName() {
        return this.studentAttendanceTypeName;
    }

    public void setStudentAttendanceTypeName(String studentAttendanceTypeName) {
        this.studentAttendanceTypeName = studentAttendanceTypeName;
    }

    @Column(name="default_selected", nullable=false)
    public boolean isDefaultSelected() {
        return this.defaultSelected;
    }

    public void setDefaultSelected(boolean defaultSelected) {
        this.defaultSelected = defaultSelected;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="studentAttendanceType")
    @ForeignKey(name="staffModuleAttendanceInStudentAttendanceType")
    public Set<StaffModuleAttendance> getStaffModuleAttendances() {
        return this.staffModuleAttendances;
    }

    public void setStaffModuleAttendances(Set<StaffModuleAttendance> staffModuleAttendances) {
        this.staffModuleAttendances = staffModuleAttendances;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="studentAttendanceType")
    @ForeignKey(name="studentAttendancesInStudentAttendanceType")
    public Set<StudentAttendance> getStudentAttendances() {
        return this.studentAttendances;
    }

    public void setStudentAttendances(Set<StudentAttendance> studentAttendances) {
        this.studentAttendances = studentAttendances;
    }
}
