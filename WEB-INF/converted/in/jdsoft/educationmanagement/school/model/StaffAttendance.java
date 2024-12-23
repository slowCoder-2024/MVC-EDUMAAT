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
 *  javax.persistence.OneToMany
 *  javax.persistence.OrderBy
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
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Staff;
import in.jdsoft.educationmanagement.school.model.StaffAttendancePunch;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tbl_staff_attendance", uniqueConstraints={@UniqueConstraint(columnNames={"academic_year_id", "date", "staff_id"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class StaffAttendance
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long StaffAttendanceId;
    private Date date;
    private AcademicYear academicYear;
    private Time startTime;
    private Time endTime;
    private Staff staff;
    private Institution institution;
    private Set<StaffAttendancePunch> staffAttendancePunches = new LinkedHashSet<StaffAttendancePunch>();

    StaffAttendance() {
    }

    public StaffAttendance(Date date, AcademicYear academicYear, Time startTime, Time endTime, Staff staff, Institution institution) {
        this.date = date;
        this.academicYear = academicYear;
        this.startTime = startTime;
        this.endTime = endTime;
        this.staff = staff;
        this.institution = institution;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="staff_attendance_id", nullable=false)
    public Long getStaffAttendanceId() {
        return this.StaffAttendanceId;
    }

    public void setStaffAttendanceId(Long staffAttendanceId) {
        this.StaffAttendanceId = staffAttendanceId;
    }

    @Temporal(value=TemporalType.DATE)
    @Column(name="date", nullable=false)
    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="academic_year_id", nullable=false)
    @ForeignKey(name="academicYearInStaffAttendance")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@staffAttendances")
    @JsonIdentityReference(alwaysAsId=true)
    public AcademicYear getAcademicYear() {
        return this.academicYear;
    }

    public void setAcademicYear(AcademicYear academicYear) {
        this.academicYear = academicYear;
    }

    @Column(name="work_start_time", nullable=false)
    public Time getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    @Column(name="work_end_time", nullable=false)
    public Time getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="staff_id", nullable=false)
    @ForeignKey(name="staffInStaffAttendance")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@staffAttendance")
    @JsonIdentityReference(alwaysAsId=true)
    public Staff getStaff() {
        return this.staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="staffAttendance")
    @ForeignKey(name="staffAttendancePunchInStaffAttendance")
    @OrderBy(value="punch_time DESC")
    public Set<StaffAttendancePunch> getStaffAttendancePunches() {
        return this.staffAttendancePunches;
    }

    public void setStaffAttendancePunches(Set<StaffAttendancePunch> staffAttendancePunches) {
        this.staffAttendancePunches = staffAttendancePunches;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="institution_id", nullable=false)
    @ForeignKey(name="institutionInStaffAttendance")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@studentAttendances")
    @JsonIdentityReference(alwaysAsId=true)
    public Institution getInstitution() {
        return this.institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }
}
