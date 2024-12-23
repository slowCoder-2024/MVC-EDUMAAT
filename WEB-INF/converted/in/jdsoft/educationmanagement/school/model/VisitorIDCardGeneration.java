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
 *  javax.persistence.OneToOne
 *  javax.persistence.Table
 *  javax.persistence.Temporal
 *  javax.persistence.TemporalType
 *  org.hibernate.annotations.ForeignKey
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.VisitorManagement;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tbl_visitor_id_card_generation")
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class VisitorIDCardGeneration
implements Serializable {
    private static final long serialVersionUID = 1L;
    private VisitorManagement visitorManagement;
    private Institution institution;
    private Long visitorIDCardGenerationId;
    private String qrCode;
    private String qrImage;
    private String createdBy;
    private String modifiedBy;
    private Date createdDate;
    private Date modifiedDate;

    public VisitorIDCardGeneration(VisitorManagement visitorManagement, Institution institution, String createdBy, String modifiedBy) {
        this.visitorManagement = visitorManagement;
        this.institution = institution;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
        this.createdDate = new Timestamp(Calendar.getInstance().getTime().getTime());
    }

    VisitorIDCardGeneration() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="visitor_id_card_generation_id", nullable=false)
    public Long getVisitorIDCardGenerationId() {
        return this.visitorIDCardGenerationId;
    }

    public void setVisitorIDCardGenerationId(Long visitorIDCardGenerationId) {
        this.visitorIDCardGenerationId = visitorIDCardGenerationId;
    }

    @Column(name="created_by", nullable=false, length=50)
    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="institution_id", nullable=false)
    @ForeignKey(name="visitorIDCardGenerationInInstitution")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@visitorIDCardGenerations")
    @JsonIdentityReference(alwaysAsId=true)
    public Institution getInstitution() {
        return this.institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    @Column(name="modified_by", nullable=false, length=100)
    public String getModifiedBy() {
        return this.modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @OneToOne(fetch=FetchType.LAZY, mappedBy="visitorIDCardGeneration")
    @JsonBackReference
    public VisitorManagement getVisitorManagement() {
        return this.visitorManagement;
    }

    public void setVisitorManagement(VisitorManagement visitorManagement) {
        this.visitorManagement = visitorManagement;
    }

    @Column(name="qr_Code", nullable=false, length=255)
    public String getQrCode() {
        return this.qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    @Column(name="qr_Image", nullable=false, length=255)
    public String getQrImage() {
        return this.qrImage;
    }

    public void setQrImage(String qrImage) {
        this.qrImage = qrImage;
    }

    @Temporal(value=TemporalType.DATE)
    @Column(name="created_date", nullable=false)
    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Temporal(value=TemporalType.TIMESTAMP)
    @Column(name="modified_date", nullable=false, columnDefinition="timestamp")
    public Date getModifiedDate() {
        return this.modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
