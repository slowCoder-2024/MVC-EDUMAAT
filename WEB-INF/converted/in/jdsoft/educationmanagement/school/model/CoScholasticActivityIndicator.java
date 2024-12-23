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
import in.jdsoft.educationmanagement.school.model.CoScholasticActivity;
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
@Table(name="tbl_co_scholastic_activity_indicator", uniqueConstraints={@UniqueConstraint(columnNames={"co_scholastic_activity_indicator_name", "co_scholastic_activity_id"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class CoScholasticActivityIndicator
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long coScholasticActivityIndicatorId;
    private String coScholasticActivityIndicatorName;
    private CoScholasticActivity coScholasticActivity;

    public CoScholasticActivityIndicator(String coScholasticActivityIndicatorName, CoScholasticActivity coScholasticActivity) {
        this.coScholasticActivityIndicatorName = coScholasticActivityIndicatorName;
        this.coScholasticActivity = coScholasticActivity;
    }

    CoScholasticActivityIndicator() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="co_scholastic_activity_indicator_id", nullable=false)
    public Long getCoScholasticActivityIndicatorId() {
        return this.coScholasticActivityIndicatorId;
    }

    public void setCoScholasticActivityIndicatorId(Long coScholasticActivityIndicatorId) {
        this.coScholasticActivityIndicatorId = coScholasticActivityIndicatorId;
    }

    @Column(name="co_scholastic_activity_indicator_name", nullable=false, length=150)
    public String getCoScholasticActivityIndicatorName() {
        return this.coScholasticActivityIndicatorName;
    }

    public void setCoScholasticActivityIndicatorName(String coScholasticActivityIndicatorName) {
        this.coScholasticActivityIndicatorName = coScholasticActivityIndicatorName;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="co_scholastic_activity_id", nullable=false)
    @JsonBackReference
    public CoScholasticActivity getCoScholasticActivity() {
        return this.coScholasticActivity;
    }

    public void setCoScholasticActivity(CoScholasticActivity coScholasticActivity) {
        this.coScholasticActivity = coScholasticActivity;
    }
}
