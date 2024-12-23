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
 *  javax.persistence.JoinColumn
 *  javax.persistence.ManyToOne
 *  javax.persistence.Table
 *  javax.persistence.Temporal
 *  javax.persistence.TemporalType
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import in.jdsoft.educationmanagement.school.model.ModulePlan;
import java.io.Serializable;
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

@Entity
@Table(name="tbl_module_plan_schedule")
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class ModulePlanSchedule
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long modulePlanScheduleId;
    private Date modulePlanScheduleStartdate;
    private Date modulePlanScheduleEnddate;
    private String modulePlanScheduleStatus;
    private String modulePlanScheduleRemarks;
    private Integer modulePlanScheduleHoursRequired;
    private ModulePlan modulePlan;

    public ModulePlanSchedule(Date modulePlanScheduleStartdate, Date modulePlanScheduleEnddate, String modulePlanScheduleStatus, String modulePlanScheduleRemarks, Integer modulePlanScheduleHoursRequired, ModulePlan modulePlan) {
        this.modulePlanScheduleStartdate = modulePlanScheduleStartdate;
        this.modulePlanScheduleEnddate = modulePlanScheduleEnddate;
        this.modulePlanScheduleStatus = modulePlanScheduleStatus;
        this.modulePlanScheduleRemarks = modulePlanScheduleRemarks;
        this.modulePlanScheduleHoursRequired = modulePlanScheduleHoursRequired;
        this.modulePlan = modulePlan;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="module_plan_schedule_id", unique=true, nullable=false)
    public Long getModulePlanScheduleId() {
        return this.modulePlanScheduleId;
    }

    public void setModulePlanScheduleId(Long modulePlanScheduleId) {
        this.modulePlanScheduleId = modulePlanScheduleId;
    }

    @Temporal(value=TemporalType.TIMESTAMP)
    @Column(name="module_plan_schedule_start_date", nullable=false, length=10)
    public Date getModulePlanScheduleStartdate() {
        return this.modulePlanScheduleStartdate;
    }

    public void setModulePlanScheduleStartdate(Date modulePlanScheduleStartdate) {
        this.modulePlanScheduleStartdate = modulePlanScheduleStartdate;
    }

    @Temporal(value=TemporalType.TIMESTAMP)
    @Column(name="module_plan_schedule_end_date", nullable=false, length=10)
    public Date getModulePlanScheduleEnddate() {
        return this.modulePlanScheduleEnddate;
    }

    public void setModulePlanScheduleEnddate(Date modulePlanScheduleEnddate) {
        this.modulePlanScheduleEnddate = modulePlanScheduleEnddate;
    }

    @Column(name="module_plan_schedule_status", nullable=false, length=255)
    public String getModulePlanScheduleStatus() {
        return this.modulePlanScheduleStatus;
    }

    public void setModulePlanScheduleStatus(String modulePlanScheduleStatus) {
        this.modulePlanScheduleStatus = modulePlanScheduleStatus;
    }

    @Column(name="module_plan_schedule_remarks", nullable=true, length=255)
    public String getModulePlanScheduleRemarks() {
        return this.modulePlanScheduleRemarks;
    }

    public void setModulePlanScheduleRemarks(String modulePlanScheduleRemarks) {
        this.modulePlanScheduleRemarks = modulePlanScheduleRemarks;
    }

    @Column(name="module_plan_schedule_hours_required", nullable=false, length=255)
    public Integer getModulePlanScheduleHoursRequired() {
        return this.modulePlanScheduleHoursRequired;
    }

    public void setModulePlanScheduleHoursRequired(Integer modulePlanScheduleHoursRequired) {
        this.modulePlanScheduleHoursRequired = modulePlanScheduleHoursRequired;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="module_plan_id", nullable=true)
    public ModulePlan getModulePlan() {
        return this.modulePlan;
    }

    public void setModulePlan(ModulePlan modulePlan) {
        this.modulePlan = modulePlan;
    }
}
