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
import in.jdsoft.educationmanagement.school.model.ClassSectionAssesmentType;
import in.jdsoft.educationmanagement.school.model.GradeSystemDetail;
import in.jdsoft.educationmanagement.school.model.Institution;
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
@Table(name="tbl_grade_system", uniqueConstraints={@UniqueConstraint(columnNames={"grade_system_name", "institution_id"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class GradeSystem
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long gradeSystemId;
    private String gradeSystemName;
    private Institution institution;
    private Set<GradeSystemDetail> gradeSystemDetails = new LinkedHashSet<GradeSystemDetail>();
    private Set<ClassSectionAssesmentType> classSectionAssesmentTypes = new LinkedHashSet<ClassSectionAssesmentType>();

    GradeSystem() {
    }

    public GradeSystem(String gradeSystemName, Institution institution) {
        this.gradeSystemName = gradeSystemName;
        this.institution = institution;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="grade_system_id", nullable=false)
    public Long getGradeSystemId() {
        return this.gradeSystemId;
    }

    public void setGradeSystemId(Long gradeSystemId) {
        this.gradeSystemId = gradeSystemId;
    }

    @Column(name="grade_system_name", nullable=false, length=100)
    public String getGradeSystemName() {
        return this.gradeSystemName;
    }

    public void setGradeSystemName(String gradeSystemName) {
        this.gradeSystemName = gradeSystemName;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="gradeSystem", cascade={CascadeType.REMOVE})
    @ForeignKey(name="gradeSystemDetailInGradeSystem")
    @OrderBy(clause="grade_system_detail_id ASC")
    public Set<GradeSystemDetail> getGradeSystemDetails() {
        return this.gradeSystemDetails;
    }

    public void setGradeSystemDetails(Set<GradeSystemDetail> gradeSystemDetails) {
        this.gradeSystemDetails = gradeSystemDetails;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="institution_id", nullable=false)
    @ForeignKey(name="institutionInGradeSystem")
    public Institution getInstitution() {
        return this.institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="gradeSystem")
    @ForeignKey(name="classSectionAssesmentTypeInGradeSystem")
    public Set<ClassSectionAssesmentType> getClassSectionAssesmentTypes() {
        return this.classSectionAssesmentTypes;
    }

    public void setClassSectionAssesmentTypes(Set<ClassSectionAssesmentType> classSectionAssesmentTypes) {
        this.classSectionAssesmentTypes = classSectionAssesmentTypes;
    }
}
