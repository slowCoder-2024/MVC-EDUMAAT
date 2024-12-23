/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonIdentityInfo
 *  com.fasterxml.jackson.annotation.JsonIdentityReference
 *  com.fasterxml.jackson.annotation.JsonIgnoreProperties
 *  com.fasterxml.jackson.annotation.JsonInclude
 *  com.fasterxml.jackson.annotation.JsonInclude$Include
 *  com.fasterxml.jackson.annotation.JsonManagedReference
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
 *  javax.persistence.Table
 *  javax.persistence.UniqueConstraint
 *  org.hibernate.annotations.ForeignKey
 *  org.hibernate.annotations.OrderBy
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import in.jdsoft.educationmanagement.school.model.ClassSectionModule;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.SubstituteTimeTableGenerator;
import in.jdsoft.educationmanagement.school.model.TimeTableGeneratorHours;
import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.OrderBy;

@Entity
@Table(name="tbl_module", uniqueConstraints={@UniqueConstraint(columnNames={"module_code", "institution_id"}), @UniqueConstraint(columnNames={"module_name", "institution_id"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class Module
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long moduleId;
    private String moduleName;
    private String moduleCode;
    private Institution institution;
    private Long totalNumberOfHours;
    private Set<ClassSectionModule> classSectionModules = new LinkedHashSet<ClassSectionModule>();
    private Set<TimeTableGeneratorHours> timeTableGeneratorHours = new LinkedHashSet<TimeTableGeneratorHours>();
    private Set<SubstituteTimeTableGenerator> substituteTimeTableGenerators = new LinkedHashSet<SubstituteTimeTableGenerator>();

    Module() {
    }

    public Module(String moduleName, String moduleCode, Institution institution, Long totalNumberOfHours) {
        this.moduleName = moduleName;
        this.moduleCode = moduleCode;
        this.institution = institution;
        this.totalNumberOfHours = totalNumberOfHours;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="module_id", nullable=false)
    public Long getModuleId() {
        return this.moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    @Column(name="module_name", nullable=false, length=50)
    public String getModuleName() {
        return this.moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    @Column(name="module_code", nullable=false, length=100)
    public String getModuleCode() {
        return this.moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    @Column(name="module_total_no_of_hours", nullable=false, length=100)
    public Long getTotalNumberOfHours() {
        return this.totalNumberOfHours;
    }

    public void setTotalNumberOfHours(Long totalNumberOfHours) {
        this.totalNumberOfHours = totalNumberOfHours;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="institution_id", nullable=false)
    @ForeignKey(name="moduleInInstitution")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@modules")
    @JsonIdentityReference(alwaysAsId=true)
    public Institution getInstitution() {
        return this.institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="module")
    @ForeignKey(name="classSectionModuleInModule")
    public Set<ClassSectionModule> getClassSectionModules() {
        return this.classSectionModules;
    }

    public void setClassSectionModules(Set<ClassSectionModule> classSectionModules) {
        this.classSectionModules = classSectionModules;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="module")
    @ForeignKey(name="timeTableGeneratorHoursInModule")
    @OrderBy(clause="time_table_generator_hour_id ASC")
    @JsonManagedReference
    public Set<TimeTableGeneratorHours> getTimeTableGeneratorHours() {
        return this.timeTableGeneratorHours;
    }

    public void setTimeTableGeneratorHours(Set<TimeTableGeneratorHours> timeTableGeneratorHours) {
        this.timeTableGeneratorHours = timeTableGeneratorHours;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="module")
    @ForeignKey(name="substituteTimeTableGeneratorInModule")
    @OrderBy(clause="substituteTimTableGeneratorHourId ASC")
    @JsonManagedReference
    public Set<SubstituteTimeTableGenerator> getSubstituteTimeTableGenerators() {
        return this.substituteTimeTableGenerators;
    }

    public void setSubstituteTimeTableGenerators(Set<SubstituteTimeTableGenerator> substituteTimeTableGenerators) {
        this.substituteTimeTableGenerators = substituteTimeTableGenerators;
    }
}
