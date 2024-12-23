/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonBackReference
 *  com.fasterxml.jackson.annotation.JsonIgnoreProperties
 *  com.fasterxml.jackson.annotation.JsonInclude
 *  com.fasterxml.jackson.annotation.JsonInclude$Include
 *  javax.persistence.Column
 *  javax.persistence.Entity
 *  javax.persistence.FetchType
 *  javax.persistence.GeneratedValue
 *  javax.persistence.GenerationType
 *  javax.persistence.Id
 *  javax.persistence.JoinColumn
 *  javax.persistence.OneToOne
 *  javax.persistence.Table
 *  javax.persistence.UniqueConstraint
 *  org.hibernate.annotations.ForeignKey
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import in.jdsoft.educationmanagement.school.model.Institution;
import java.io.Serializable;
import java.sql.Time;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tbl_staff_attendance_configuration", uniqueConstraints={@UniqueConstraint(columnNames={"institution_id"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class StaffAttendanceConfiguration
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long staffAttendanceConfigurationId;
    private Time startingWorkTime;
    private Time closingWorkTime;
    private boolean enablePermissionHours;
    private boolean enableLeaveDays;
    private Double monthlyPermissionHours;
    private Double monthlyleaveDays;
    private boolean permissionCarryForward;
    private boolean leaveCarryForward;
    private Institution institution;

    StaffAttendanceConfiguration() {
    }

    public StaffAttendanceConfiguration(Time startingWorkTime, Time closingWorkTime, boolean enablePermissionHours, boolean enableLeaveDays, Double monthlyPermissionHours, Double monthlyleaveDays, boolean permissionCarryForward, boolean leaveCarryForward, Institution institution) {
        this.startingWorkTime = startingWorkTime;
        this.closingWorkTime = closingWorkTime;
        this.enablePermissionHours = enablePermissionHours;
        this.enableLeaveDays = enableLeaveDays;
        this.monthlyPermissionHours = monthlyPermissionHours;
        this.monthlyleaveDays = monthlyleaveDays;
        this.permissionCarryForward = permissionCarryForward;
        this.leaveCarryForward = leaveCarryForward;
        this.institution = institution;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="staff_attendance_configuration", nullable=false)
    public Long getStaffAttendanceConfigurationId() {
        return this.staffAttendanceConfigurationId;
    }

    public void setStaffAttendanceConfigurationId(Long staffAttendanceConfigurationId) {
        this.staffAttendanceConfigurationId = staffAttendanceConfigurationId;
    }

    @Column(name="work_start_time")
    public Time getStartingWorkTime() {
        return this.startingWorkTime;
    }

    public void setStartingWorkTime(Time startingWorkTime) {
        this.startingWorkTime = startingWorkTime;
    }

    @Column(name="work_end_time")
    public Time getClosingWorkTime() {
        return this.closingWorkTime;
    }

    public void setClosingWorkTime(Time closingWorkTime) {
        this.closingWorkTime = closingWorkTime;
    }

    @Column(name="enable_permission_hours", nullable=false)
    public boolean isEnablePermissionHours() {
        return this.enablePermissionHours;
    }

    public void setEnablePermissionHours(boolean enablePermissionHours) {
        this.enablePermissionHours = enablePermissionHours;
    }

    @Column(name="enable_leave_days", nullable=false)
    public boolean isEnableLeaveDays() {
        return this.enableLeaveDays;
    }

    public void setEnableLeaveDays(boolean enableLeaveDays) {
        this.enableLeaveDays = enableLeaveDays;
    }

    @Column(name="monthly_permission_hours")
    public Double getMonthlyPermissionHours() {
        return this.monthlyPermissionHours;
    }

    public void setMonthlyPermissionHours(Double monthlyPermissionHours) {
        this.monthlyPermissionHours = monthlyPermissionHours;
    }

    @Column(name="monthly_leave_days")
    public Double getMonthlyleaveDays() {
        return this.monthlyleaveDays;
    }

    public void setMonthlyleaveDays(Double monthlyleaveDays) {
        this.monthlyleaveDays = monthlyleaveDays;
    }

    @Column(name="permission_carry_forward")
    public boolean isPermissionCarryForward() {
        return this.permissionCarryForward;
    }

    public void setPermissionCarryForward(boolean permissionCarryForward) {
        this.permissionCarryForward = permissionCarryForward;
    }

    @Column(name="leave_carry_forward")
    public boolean isLeaveCarryForward() {
        return this.leaveCarryForward;
    }

    public void setLeaveCarryForward(boolean leaveCarryForward) {
        this.leaveCarryForward = leaveCarryForward;
    }

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="institution_id", nullable=true)
    @ForeignKey(name="institutionInStaffAttendance")
    @JsonBackReference
    public Institution getInstitution() {
        return this.institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }
}
