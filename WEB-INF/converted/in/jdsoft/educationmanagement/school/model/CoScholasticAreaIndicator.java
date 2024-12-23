/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonBackReference
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
 *  javax.persistence.UniqueConstraint
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import in.jdsoft.educationmanagement.school.model.CoScholasticArea;
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
@Table(name="tbl_co_scholastic_area_indicator", uniqueConstraints={@UniqueConstraint(columnNames={"co_scholastic_area_indicator_name", "co_scholastic_area_id"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class CoScholasticAreaIndicator
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long coScholasticAreaIndicatorId;
    private String coScholasticAreaIndicatorName;
    private CoScholasticArea coScholasticArea;

    CoScholasticAreaIndicator() {
    }

    public CoScholasticAreaIndicator(String coScholasticAreaIndicatorName, CoScholasticArea coScholasticArea) {
        this.coScholasticAreaIndicatorName = coScholasticAreaIndicatorName;
        this.coScholasticArea = coScholasticArea;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="co_scholastic_area_indicator_id", nullable=false)
    public Long getCoScholasticAreaIndicatorId() {
        return this.coScholasticAreaIndicatorId;
    }

    public void setCoScholasticAreaIndicatorId(Long coScholasticAreaIndicatorId) {
        this.coScholasticAreaIndicatorId = coScholasticAreaIndicatorId;
    }

    @Column(name="co_scholastic_area_indicator_name", nullable=false, length=150)
    public String getCoScholasticAreaIndicatorName() {
        return this.coScholasticAreaIndicatorName;
    }

    public void setCoScholasticAreaIndicatorName(String coScholasticAreaIndicatorName) {
        this.coScholasticAreaIndicatorName = coScholasticAreaIndicatorName;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="co_scholastic_area_id", nullable=false)
    @JsonBackReference
    public CoScholasticArea getCoScholasticArea() {
        return this.coScholasticArea;
    }

    public void setCoScholasticArea(CoScholasticArea coScholasticArea) {
        this.coScholasticArea = coScholasticArea;
    }
}
