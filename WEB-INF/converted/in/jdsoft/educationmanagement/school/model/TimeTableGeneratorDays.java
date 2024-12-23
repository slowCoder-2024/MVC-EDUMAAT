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
 *  javax.persistence.CascadeType
 *  javax.persistence.Column
 *  javax.persistence.Entity
 *  javax.persistence.FetchType
 *  javax.persistence.GeneratedValue
 *  javax.persistence.GenerationType
 *  javax.persistence.Id
 *  javax.persistence.JoinColumn
 *  javax.persistence.ManyToOne
 *  javax.persistence.OneToMany
 *  javax.persistence.Table
 *  org.hibernate.annotations.ForeignKey
 *  org.hibernate.annotations.OrderBy
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import in.jdsoft.educationmanagement.school.model.TimeTableGenerator;
import in.jdsoft.educationmanagement.school.model.TimeTableGeneratorHours;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.OrderBy;

@Entity
@Table(name="tbl_time_table_generator_days")
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class TimeTableGeneratorDays
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long timeTableGeneratorDayId;
    private String timeTableGeneratorDayName;
    private TimeTableGenerator timeTableGenerator;
    private Set<TimeTableGeneratorHours> timeTableGeneratorHours = new LinkedHashSet<TimeTableGeneratorHours>();

    public TimeTableGeneratorDays(String timeTableGeneratorDayName, TimeTableGenerator timeTableGenerator) {
        this.timeTableGeneratorDayName = timeTableGeneratorDayName;
        this.timeTableGenerator = timeTableGenerator;
    }

    TimeTableGeneratorDays() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="time_table_generator_day_id", nullable=false)
    public Long getTimeTableGeneratorDayId() {
        return this.timeTableGeneratorDayId;
    }

    public void setTimeTableGeneratorDayId(Long timeTableGeneratorDayId) {
        this.timeTableGeneratorDayId = timeTableGeneratorDayId;
    }

    @Column(name="time_table_generator_day_name", nullable=false, length=150)
    public String getTimeTableGeneratorDayName() {
        return this.timeTableGeneratorDayName;
    }

    public void setTimeTableGeneratorDayName(String timeTableGeneratorDayName) {
        this.timeTableGeneratorDayName = timeTableGeneratorDayName;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="time_table_generator_id", nullable=false)
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@timeTableGeneratorDays")
    @JsonIdentityReference(alwaysAsId=true)
    public TimeTableGenerator getTimeTableGenerator() {
        return this.timeTableGenerator;
    }

    public void setTimeTableGenerator(TimeTableGenerator timeTableGenerator) {
        this.timeTableGenerator = timeTableGenerator;
    }

    @OneToMany(fetch=FetchType.LAZY, cascade={CascadeType.REMOVE}, mappedBy="timeTableGeneratorDays")
    @ForeignKey(name="timeTableGeneratorHoursInTimeTableGeneratorDays")
    @OrderBy(clause="time_table_generator_hour_id ASC")
    public Set<TimeTableGeneratorHours> getTimeTableGeneratorHours() {
        return this.timeTableGeneratorHours;
    }

    public void setTimeTableGeneratorHours(Set<TimeTableGeneratorHours> timeTableGeneratorHours) {
        this.timeTableGeneratorHours = timeTableGeneratorHours;
    }
}
