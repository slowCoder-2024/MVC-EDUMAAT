/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonIgnoreProperties
 *  com.fasterxml.jackson.annotation.JsonInclude
 *  com.fasterxml.jackson.annotation.JsonInclude$Include
 *  com.fasterxml.jackson.annotation.JsonManagedReference
 *  javax.persistence.Column
 *  javax.persistence.Entity
 *  javax.persistence.FetchType
 *  javax.persistence.GeneratedValue
 *  javax.persistence.GenerationType
 *  javax.persistence.Id
 *  javax.persistence.OneToMany
 *  javax.persistence.Table
 *  javax.persistence.UniqueConstraint
 *  org.hibernate.annotations.ForeignKey
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import in.jdsoft.educationmanagement.school.model.ClassSectionCoScholasticArea;
import in.jdsoft.educationmanagement.school.model.CoScholasticAreaIndicator;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tbl_co_scholastic_area", uniqueConstraints={@UniqueConstraint(columnNames={"co_scholastic_area_name"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class CoScholasticArea
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long coScholasticAreaId;
    private String coScholasticAreaName;
    private Set<CoScholasticAreaIndicator> coScholasticAreaIndicators = new LinkedHashSet<CoScholasticAreaIndicator>();
    private Set<ClassSectionCoScholasticArea> classSectionCoScholasticArea = new LinkedHashSet<ClassSectionCoScholasticArea>();

    public CoScholasticArea(String coScholasticAreaName) {
        this.coScholasticAreaName = coScholasticAreaName;
    }

    CoScholasticArea() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="co_scholastic_area_id", nullable=false)
    public Long getCoScholasticAreaId() {
        return this.coScholasticAreaId;
    }

    public void setCoScholasticAreaId(Long coScholasticAreaId) {
        this.coScholasticAreaId = coScholasticAreaId;
    }

    @Column(name="co_scholastic_area_name", nullable=false, length=150)
    public String getcoScholasticAreaName() {
        return this.coScholasticAreaName;
    }

    public void setcoScholasticAreaName(String coScholasticAreaName) {
        this.coScholasticAreaName = coScholasticAreaName;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="coScholasticArea")
    @ForeignKey(name="coScholasticAreaInCoScholasticAreaIndicator")
    @JsonManagedReference
    public Set<CoScholasticAreaIndicator> getCoScholasticAreaIndicators() {
        return this.coScholasticAreaIndicators;
    }

    public void setCoScholasticAreaIndicators(Set<CoScholasticAreaIndicator> coScholasticAreaIndicators) {
        this.coScholasticAreaIndicators = coScholasticAreaIndicators;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="coScholasticArea")
    @ForeignKey(name="classSectionCoScholasticAreaInCoScholasticArea")
    public Set<ClassSectionCoScholasticArea> getClassSectionCoScholasticArea() {
        return this.classSectionCoScholasticArea;
    }

    public void setClassSectionCoScholasticArea(Set<ClassSectionCoScholasticArea> classSectionCoScholasticArea) {
        this.classSectionCoScholasticArea = classSectionCoScholasticArea;
    }
}
