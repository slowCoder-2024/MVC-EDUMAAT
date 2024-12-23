/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonIdentityInfo
 *  com.fasterxml.jackson.annotation.JsonIdentityReference
 *  com.fasterxml.jackson.annotation.JsonIgnoreProperties
 *  com.fasterxml.jackson.annotation.ObjectIdGenerators$IntSequenceGenerator
 *  javax.persistence.Column
 *  javax.persistence.Entity
 *  javax.persistence.FetchType
 *  javax.persistence.GeneratedValue
 *  javax.persistence.GenerationType
 *  javax.persistence.Id
 *  javax.persistence.JoinColumn
 *  javax.persistence.ManyToOne
 *  javax.persistence.Table
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import in.jdsoft.educationmanagement.school.model.Admission;
import in.jdsoft.educationmanagement.school.model.AdmissionDocumentTypes;
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

@Entity
@Table(name="tbl_admission_document")
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
public class AdmissionDocument
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long admissionDocumentId;
    private Admission admission;
    private AdmissionDocumentTypes admissionDocumentType;
    private String documentName;
    private String documentPath;

    public AdmissionDocument() {
    }

    public AdmissionDocument(Admission admission, AdmissionDocumentTypes admissionDocumentType, String documentName, String documentPath) {
        this.admission = admission;
        this.admissionDocumentType = admissionDocumentType;
        this.documentName = documentName;
        this.documentPath = documentPath;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="admission_document_id", unique=true, nullable=false)
    public Long getAdmissionDocumentId() {
        return this.admissionDocumentId;
    }

    public void setAdmissionDocumentId(Long admissionDocumentId) {
        this.admissionDocumentId = admissionDocumentId;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="admission_id", nullable=false)
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@admissionDocuments")
    @JsonIdentityReference(alwaysAsId=true)
    public Admission getAdmission() {
        return this.admission;
    }

    public void setAdmission(Admission admission) {
        this.admission = admission;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="admission_document_type_id", nullable=false)
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@admissionDocument")
    @JsonIdentityReference(alwaysAsId=true)
    public AdmissionDocumentTypes getAdmissionDocumentType() {
        return this.admissionDocumentType;
    }

    public void setAdmissionDocumentType(AdmissionDocumentTypes admissionDocumentType) {
        this.admissionDocumentType = admissionDocumentType;
    }

    @Column(name="document_name", nullable=false, length=50)
    public String getDocumentName() {
        return this.documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    @Column(name="document_path", nullable=false, length=255)
    public String getDocumentPath() {
        return this.documentPath;
    }

    public void setDocumentPath(String documentPath) {
        this.documentPath = documentPath;
    }
}
