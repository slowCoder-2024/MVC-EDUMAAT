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
 *  org.hibernate.annotations.ForeignKey
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import in.jdsoft.educationmanagement.school.model.StaffAttendance;
import java.io.Serializable;
import java.sql.Time;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tbl_staff_attendance_punch")
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class StaffAttendancePunch
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long staffAttendancePunchId;
    private StaffAttendance staffAttendance;
    private Time punchTime;

    StaffAttendancePunch() {
    }

    public StaffAttendancePunch(StaffAttendance staffAttendance, Time punchTime) {
        this.staffAttendance = staffAttendance;
        this.punchTime = punchTime;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="staff_attendance_punch_id", nullable=false)
    public Long getStaffAttendancePunchId() {
        return this.staffAttendancePunchId;
    }

    public void setStaffAttendancePunchId(Long staffAttendancePunchId) {
        this.staffAttendancePunchId = staffAttendancePunchId;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="staff_attendance_id", nullable=false)
    @ForeignKey(name="staffAttendanceInStaffAttendancePUnch")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@staffAttendancePunches")
    @JsonIdentityReference(alwaysAsId=true)
    public StaffAttendance getStaffAttendance() {
        return this.staffAttendance;
    }

    public void setStaffAttendance(StaffAttendance staffAttendance) {
        this.staffAttendance = staffAttendance;
    }

    @Column(name="punch_time", nullable=false)
    public Time getPunchTime() {
        return this.punchTime;
    }

    public void setPunchTime(Time punchTime) {
        this.punchTime = punchTime;
    }
}
