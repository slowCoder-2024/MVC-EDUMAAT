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
 *  javax.persistence.OneToMany
 *  javax.persistence.Table
 *  javax.persistence.UniqueConstraint
 *  org.apache.commons.lang.WordUtils
 *  org.hibernate.annotations.ForeignKey
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import in.jdsoft.educationmanagement.school.model.Document;
import in.jdsoft.educationmanagement.school.model.Institution;
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
import org.apache.commons.lang.WordUtils;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tbl_document_type", uniqueConstraints={@UniqueConstraint(columnNames={"document_type_title", "institution_id"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
public class DocumentType
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long documentTypeId;
    private String documentTypeTitle;
    private int documentMandatory;
    private Institution institution;
    private Set<Document> documents = new LinkedHashSet<Document>();

    public DocumentType() {
    }

    public DocumentType(String documentTypeTitle, int documentMandatory, Institution institution) {
        this.documentTypeTitle = WordUtils.capitalize((String)documentTypeTitle);
        this.institution = institution;
        this.documentMandatory = documentMandatory;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="document_type_id", unique=true, nullable=false)
    public Long getDocumentTypeId() {
        return this.documentTypeId;
    }

    public void setDocumentTypeId(Long documentTypeId) {
        this.documentTypeId = documentTypeId;
    }

    @Column(name="document_type_title", nullable=false, length=100)
    public String getDocumentTypeTitle() {
        return this.documentTypeTitle;
    }

    public void setDocumentTypeTitle(String documentTypeTitle) {
        this.documentTypeTitle = WordUtils.capitalize((String)documentTypeTitle);
    }

    @Column(name="document_mandatory", nullable=false)
    public int getDocumentMandatory() {
        return this.documentMandatory;
    }

    public void setDocumentMandatory(int documentMandatory) {
        this.documentMandatory = documentMandatory;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="documentType")
    public Set<Document> getDocuments() {
        return this.documents;
    }

    public void setDocuments(Set<Document> documents) {
        this.documents = documents;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="institution_id", nullable=false)
    @ForeignKey(name="documentTypeInInstitution")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@documentTypes")
    @JsonIdentityReference(alwaysAsId=true)
    public Institution getInstitution() {
        return this.institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }
}
