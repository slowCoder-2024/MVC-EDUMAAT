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
 *  javax.persistence.OrderBy
 *  javax.persistence.Table
 *  javax.persistence.UniqueConstraint
 *  org.hibernate.annotations.ForeignKey
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import in.jdsoft.educationmanagement.school.model.ExamTemplate;
import in.jdsoft.educationmanagement.school.model.TermExam;
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
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tbl_term", uniqueConstraints={@UniqueConstraint(columnNames={"term_name", "exam_template_id"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class Term
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long termId;
    private String termName;
    private ExamTemplate examTemplate;
    private Set<TermExam> termExams = new LinkedHashSet<TermExam>();

    public Term(String termName, ExamTemplate examTemplate) {
        this.termName = termName;
        this.examTemplate = examTemplate;
    }

    Term() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="term_id", nullable=false)
    public Long getTermId() {
        return this.termId;
    }

    public void setTermId(Long termId) {
        this.termId = termId;
    }

    @Column(name="term_name", nullable=false, length=150)
    public String getTermName() {
        return this.termName;
    }

    public void setTermName(String termName) {
        this.termName = termName;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="exam_template_id", nullable=false)
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@terms")
    @JsonIdentityReference(alwaysAsId=true)
    public ExamTemplate getExamTemplate() {
        return this.examTemplate;
    }

    public void setExamTemplate(ExamTemplate examTemplate) {
        this.examTemplate = examTemplate;
    }

    @OneToMany(fetch=FetchType.LAZY, cascade={CascadeType.REMOVE}, mappedBy="term")
    @ForeignKey(name="termInTermExam")
    @OrderBy(value="termExamId")
    public Set<TermExam> getTermExams() {
        return this.termExams;
    }

    public void setTermExams(Set<TermExam> termExams) {
        this.termExams = termExams;
    }
}
