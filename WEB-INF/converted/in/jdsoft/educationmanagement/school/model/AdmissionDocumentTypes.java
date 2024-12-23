/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonIgnoreProperties
 *  javax.persistence.Column
 *  javax.persistence.Entity
 *  javax.persistence.FetchType
 *  javax.persistence.GeneratedValue
 *  javax.persistence.GenerationType
 *  javax.persistence.Id
 *  javax.persistence.OneToMany
 *  javax.persistence.Table
 *  javax.persistence.UniqueConstraint
 *  org.apache.commons.lang.WordUtils
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import in.jdsoft.educationmanagement.school.model.AdmissionDocument;
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
import javax.persistence.UniqueConstraint;
import org.apache.commons.lang.WordUtils;

@Entity
@Table(name="tbl_admission_document_types", uniqueConstraints={@UniqueConstraint(columnNames={"admission_document_type_title"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
public class AdmissionDocumentTypes
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long documentTypeId;
    private String documentTypeTitle;
    private int documentMandatory;
    private Set<AdmissionDocument> admissionDocument = new HashSet<AdmissionDocument>(0);

    public AdmissionDocumentTypes() {
    }

    public AdmissionDocumentTypes(String documentTypeTitle, int documentMandatory) {
        this.documentTypeTitle = WordUtils.capitalize((String)documentTypeTitle);
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="admission_document_type_id", unique=true, nullable=false)
    public Long getDocumentTypeId() {
        return this.documentTypeId;
    }

    public void setDocumentTypeId(Long documentTypeId) {
        this.documentTypeId = documentTypeId;
    }

    @Column(name="admission_document_type_title", nullable=false, length=50, unique=true)
    public String getDocumentTypeTitle() {
        return this.documentTypeTitle;
    }

    public void setDocumentTypeTitle(String documentTypeTitle) {
        this.documentTypeTitle = WordUtils.capitalize((String)documentTypeTitle);
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="admissionDocumentType")
    public Set<AdmissionDocument> getAdmissionDocument() {
        return this.admissionDocument;
    }

    public void setAdmissionDocument(Set<AdmissionDocument> admissionDocument) {
        this.admissionDocument = admissionDocument;
    }

    @Column(name="document_mandatory", nullable=false)
    public int getDocumentMandatory() {
        return this.documentMandatory;
    }

    public void setDocumentMandatory(int documentMandatory) {
        this.documentMandatory = documentMandatory;
    }
}
