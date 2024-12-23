/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonBackReference
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
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import in.jdsoft.educationmanagement.school.model.Module;
import in.jdsoft.educationmanagement.school.model.TimeTableGeneratorDays;
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

@Entity
@Table(name="tbl_time_table_generator_hours")
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class TimeTableGeneratorHours
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long timTableGeneratorHourId;
    private String subjectName;
    private String hourTitle;
    private TimeTableGeneratorDays timeTableGeneratorDays;
    private Module module;

    public TimeTableGeneratorHours(String subjectName, String hourTitle, TimeTableGeneratorDays timeTableGeneratorDays) {
        this.subjectName = subjectName;
        this.hourTitle = hourTitle;
        this.timeTableGeneratorDays = timeTableGeneratorDays;
    }

    TimeTableGeneratorHours() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="time_table_generator_hour_id", nullable=false)
    public Long getTimTableGeneratorHourId() {
        return this.timTableGeneratorHourId;
    }

    public void setTimTableGeneratorHourId(Long timTableGeneratorHourId) {
        this.timTableGeneratorHourId = timTableGeneratorHourId;
    }

    @Column(name="time_table_generator_subject_name", nullable=false, length=150)
    public String getsubjectName() {
        return this.subjectName;
    }

    public void setsubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    @Column(name="time_table_generator_hour_title", nullable=false, length=150)
    public String getHourTitle() {
        return this.hourTitle;
    }

    public void setHourTitle(String hourTitle) {
        this.hourTitle = hourTitle;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="time_table_generator_day_id", nullable=false)
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@timeTableGeneratorHours")
    @JsonIdentityReference(alwaysAsId=true)
    public TimeTableGeneratorDays getTimeTableGeneratorDays() {
        return this.timeTableGeneratorDays;
    }

    public void setTimeTableGeneratorDays(TimeTableGeneratorDays timeTableGeneratorDays) {
        this.timeTableGeneratorDays = timeTableGeneratorDays;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="module_id", nullable=true)
    @JsonBackReference
    public Module getModule() {
        return this.module;
    }

    public void setModule(Module module) {
        this.module = module;
    }
}
