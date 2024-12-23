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
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import in.jdsoft.educationmanagement.school.model.TimeTableTemplate;
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
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="tbl_time_table_template_hours", uniqueConstraints={@UniqueConstraint(columnNames={"time_table_template_hour_name", "time_table_template_id"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class TimeTableTemplateHours
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long timeTableTemplateHourId;
    private String timeTableTemplateHourName;
    private Date timeTableTemplateHourStartTime;
    private Date timeTableTemplateHourEndTime;
    private TimeTableTemplate timeTableTemplate;

    public TimeTableTemplateHours(String timeTableTemplateHourName, Date timeTableTemplateHourStartTime, Date timeTableTemplateHourEndTime, TimeTableTemplate timeTableTemplate) {
        this.timeTableTemplateHourName = timeTableTemplateHourName;
        this.timeTableTemplateHourStartTime = timeTableTemplateHourStartTime;
        this.timeTableTemplateHourEndTime = timeTableTemplateHourEndTime;
        this.timeTableTemplate = timeTableTemplate;
    }

    TimeTableTemplateHours() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="time_table_template_hour_id", nullable=false)
    public Long getTimeTableTemplateHourId() {
        return this.timeTableTemplateHourId;
    }

    public void setTimeTableTemplateHourId(Long timeTableTemplateHourId) {
        this.timeTableTemplateHourId = timeTableTemplateHourId;
    }

    @Column(name="time_table_template_hour_name", nullable=false, length=150)
    public String getTimeTableTemplateHourName() {
        return this.timeTableTemplateHourName;
    }

    public void setTimeTableTemplateHourName(String timeTableTemplateHourName) {
        this.timeTableTemplateHourName = timeTableTemplateHourName;
    }

    @Temporal(value=TemporalType.TIME)
    @Column(name="time_table_template_hour_start_time", nullable=false)
    public Date getTimeTableTemplateHourStartTime() {
        return this.timeTableTemplateHourStartTime;
    }

    public void setTimeTableTemplateHourStartTime(Date timeTableTemplateHourStartTime) {
        this.timeTableTemplateHourStartTime = timeTableTemplateHourStartTime;
    }

    @Temporal(value=TemporalType.TIME)
    @Column(name="time_table_template_hour_end_time", nullable=false)
    public Date getTimeTableTemplateHourEndTime() {
        return this.timeTableTemplateHourEndTime;
    }

    public void setTimeTableTemplateHourEndTime(Date timeTableTemplateHourEndTime) {
        this.timeTableTemplateHourEndTime = timeTableTemplateHourEndTime;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="time_table_template_id", nullable=false)
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@timeTableTemplateHours")
    @JsonIdentityReference(alwaysAsId=true)
    public TimeTableTemplate getTimeTableTemplate() {
        return this.timeTableTemplate;
    }

    public void setTimeTableTemplate(TimeTableTemplate timeTableTemplate) {
        this.timeTableTemplate = timeTableTemplate;
    }
}
