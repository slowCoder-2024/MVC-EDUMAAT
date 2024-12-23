/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonIgnoreProperties
 *  com.fasterxml.jackson.annotation.JsonInclude
 *  com.fasterxml.jackson.annotation.JsonInclude$Include
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
 *  javax.persistence.UniqueConstraint
 *  org.hibernate.annotations.ForeignKey
 *  org.hibernate.annotations.OrderBy
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.TimeTableTemplateDays;
import in.jdsoft.educationmanagement.school.model.TimeTableTemplateHours;
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
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.OrderBy;

@Entity
@Table(name="tbl_time_table_template", uniqueConstraints={@UniqueConstraint(columnNames={"time_table_name", "institution_id"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class TimeTableTemplate
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long timeTableTemplateId;
    private String timeTableName;
    private Institution institution;
    private Set<TimeTableTemplateDays> timeTableTemplateDays = new LinkedHashSet<TimeTableTemplateDays>();
    private Set<TimeTableTemplateHours> timeTableTemplateHours = new LinkedHashSet<TimeTableTemplateHours>();

    public TimeTableTemplate(String timeTableName, Institution institution) {
        this.timeTableName = timeTableName;
        this.institution = institution;
    }

    TimeTableTemplate() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="time_table_template_id", nullable=false)
    public Long getTimeTableTemplateId() {
        return this.timeTableTemplateId;
    }

    public void setTimeTableTemplateId(Long timeTableTemplateId) {
        this.timeTableTemplateId = timeTableTemplateId;
    }

    @Column(name="time_table_name", nullable=false, length=150)
    public String getTimeTableName() {
        return this.timeTableName;
    }

    public void setTimeTableName(String timeTableName) {
        this.timeTableName = timeTableName;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="institution_id", nullable=false)
    @ForeignKey(name="institutionInTimeTableTemplate")
    public Institution getInstitution() {
        return this.institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    @OneToMany(fetch=FetchType.LAZY, cascade={CascadeType.ALL}, mappedBy="timeTableTemplate", orphanRemoval=true)
    @ForeignKey(name="timeTableTemplateInTimeTableTemplateDays")
    @OrderBy(clause="time_table_template_day_id ASC")
    public Set<TimeTableTemplateDays> getTimeTableTemplateDays() {
        return this.timeTableTemplateDays;
    }

    public void setTimeTableTemplateDays(Set<TimeTableTemplateDays> timeTableTemplateDays) {
        this.timeTableTemplateDays = timeTableTemplateDays;
    }

    @OneToMany(fetch=FetchType.LAZY, cascade={CascadeType.ALL}, mappedBy="timeTableTemplate", orphanRemoval=true)
    @ForeignKey(name="timeTableTemplateInTimeTableTemplateHours")
    @OrderBy(clause="time_table_template_hour_id ASC")
    public Set<TimeTableTemplateHours> getTimeTableTemplateHours() {
        return this.timeTableTemplateHours;
    }

    public void setTimeTableTemplateHours(Set<TimeTableTemplateHours> timeTableTemplateHours) {
        this.timeTableTemplateHours = timeTableTemplateHours;
    }
}
