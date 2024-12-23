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
 *  javax.persistence.OneToMany
 *  javax.persistence.Table
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import in.jdsoft.educationmanagement.school.model.VisitorManagement;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_visitor_type")
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class VisitorType
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long visitorTypeId;
    private String visitorType;
    private Set<VisitorManagement> VisitorManagements = new HashSet<VisitorManagement>();

    public VisitorType() {
    }

    public VisitorType(String visitorType) {
        this.setVisitorType(visitorType);
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="visitor_type_id", nullable=false)
    public Long getVisitorTypeId() {
        return this.visitorTypeId;
    }

    public void setVisitorTypeId(Long visitorTypeId) {
        this.visitorTypeId = visitorTypeId;
    }

    @Column(name="visitor_type", nullable=false, length=25)
    public String getVisitorType() {
        return this.visitorType;
    }

    public void setVisitorType(String visitorType) {
        this.visitorType = visitorType;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="visitorType")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@visitorType")
    @JsonIdentityReference(alwaysAsId=true)
    public Set<VisitorManagement> getVisitorManagements() {
        return this.VisitorManagements;
    }

    public void setVisitorManagements(Set<VisitorManagement> visitorManagements) {
        this.VisitorManagements = visitorManagements;
    }
}
