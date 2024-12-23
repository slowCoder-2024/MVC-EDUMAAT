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
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Term;
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
@Table(name="tbl_exam_template", uniqueConstraints={@UniqueConstraint(columnNames={"exam_template_name", "institution_id"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class ExamTemplate
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long examTemplateId;
    private String examTemplateName;
    private Institution institution;
    private Set<Term> terms = new LinkedHashSet<Term>();

    public ExamTemplate(String examTemplateName, Institution institution) {
        this.examTemplateName = examTemplateName;
        this.institution = institution;
    }

    ExamTemplate() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="exam_template_id", nullable=false)
    public Long getExamTemplateId() {
        return this.examTemplateId;
    }

    public void setExamTemplateId(Long examTemplateId) {
        this.examTemplateId = examTemplateId;
    }

    @Column(name="exam_template_name", nullable=false, length=150)
    public String getExamTemplateName() {
        return this.examTemplateName;
    }

    public void setExamTemplateName(String examTemplateName) {
        this.examTemplateName = examTemplateName;
    }

    @OneToMany(fetch=FetchType.LAZY, cascade={CascadeType.REMOVE}, mappedBy="examTemplate")
    @ForeignKey(name="examTemplateInTerm")
    @OrderBy(clause="term_id ASC")
    public Set<Term> getTerms() {
        return this.terms;
    }

    public void setTerms(Set<Term> terms) {
        this.terms = terms;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="institution_id", nullable=false)
    @ForeignKey(name="institutionInExamTemplate")
    public Institution getInstitution() {
        return this.institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }
}
