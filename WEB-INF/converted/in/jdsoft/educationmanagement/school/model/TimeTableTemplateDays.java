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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="tbl_time_table_template_days", uniqueConstraints={@UniqueConstraint(columnNames={"time_table_template_day_name", "time_table_template_id"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class TimeTableTemplateDays
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long timeTableTemplateDayId;
    private String timeTableTemplateDayName;
    private TimeTableTemplate timeTableTemplate;

    public TimeTableTemplateDays(String timeTableTemplateDayName, TimeTableTemplate timeTableTemplate) {
        this.timeTableTemplateDayName = timeTableTemplateDayName;
        this.timeTableTemplate = timeTableTemplate;
    }

    TimeTableTemplateDays() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="time_table_template_day_id", nullable=false)
    public Long getTimeTableTemplateDayId() {
        return this.timeTableTemplateDayId;
    }

    public void setTimeTableTemplateDayId(Long timeTableTemplateDayId) {
        this.timeTableTemplateDayId = timeTableTemplateDayId;
    }

    @Column(name="time_table_template_day_name", nullable=false, length=150)
    public String getTimeTableTemplateDayName() {
        return this.timeTableTemplateDayName;
    }

    public void setTimeTableTemplateDayName(String timeTableTemplateDayName) {
        this.timeTableTemplateDayName = timeTableTemplateDayName;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="time_table_template_id", nullable=false)
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@timeTableTemplateDays")
    @JsonIdentityReference(alwaysAsId=true)
    public TimeTableTemplate getTimeTableTemplate() {
        return this.timeTableTemplate;
    }

    public void setTimeTableTemplate(TimeTableTemplate timeTableTemplate) {
        this.timeTableTemplate = timeTableTemplate;
    }
}
