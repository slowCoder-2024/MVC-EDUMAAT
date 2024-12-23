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
import in.jdsoft.educationmanagement.school.model.ClassSectionCoScholasticActivity;
import in.jdsoft.educationmanagement.school.model.CoScholasticActivityIndicator;
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
@Table(name="tbl_co_scholastic_activity", uniqueConstraints={@UniqueConstraint(columnNames={"co_scholastic_activity_name"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class CoScholasticActivity
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long coScholasticActivityId;
    private String coScholasticActivityName;
    private Set<CoScholasticActivityIndicator> coScholasticActivityIndicators = new LinkedHashSet<CoScholasticActivityIndicator>();
    private Set<ClassSectionCoScholasticActivity> classSectionCoScholasticActivites = new LinkedHashSet<ClassSectionCoScholasticActivity>();

    public CoScholasticActivity(String coScholasticActivityName) {
        this.coScholasticActivityName = coScholasticActivityName;
    }

    CoScholasticActivity() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="co_scholastic_activity_id", nullable=false)
    public Long getCoScholasticActivityId() {
        return this.coScholasticActivityId;
    }

    public void setCoScholasticActivityId(Long coScholasticActivityId) {
        this.coScholasticActivityId = coScholasticActivityId;
    }

    @Column(name="co_scholastic_activity_name", nullable=false, length=150)
    public String getCoScholasticActivityName() {
        return this.coScholasticActivityName;
    }

    public void setCoScholasticActivityName(String coScholasticActivityName) {
        this.coScholasticActivityName = coScholasticActivityName;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="coScholasticActivity")
    @ForeignKey(name="coScholasticActivityIndicatorInCoScholasticActivity")
    @JsonManagedReference
    public Set<CoScholasticActivityIndicator> getCoScholasticActivityIndicators() {
        return this.coScholasticActivityIndicators;
    }

    public void setCoScholasticActivityIndicators(Set<CoScholasticActivityIndicator> coScholasticActivityIndicators) {
        this.coScholasticActivityIndicators = coScholasticActivityIndicators;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="coScholasticActivity")
    @ForeignKey(name="classSectionCoScholasticActivityInCoScholasticActivity")
    public Set<ClassSectionCoScholasticActivity> getClassSectionCoScholasticActivites() {
        return this.classSectionCoScholasticActivites;
    }

    public void setClassSectionCoScholasticActivites(Set<ClassSectionCoScholasticActivity> classSectionCoScholasticActivites) {
        this.classSectionCoScholasticActivites = classSectionCoScholasticActivites;
    }
}
