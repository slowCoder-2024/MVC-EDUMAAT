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
 *  javax.persistence.JoinColumn
 *  javax.persistence.ManyToOne
 *  javax.persistence.Table
 *  javax.persistence.UniqueConstraint
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import in.jdsoft.educationmanagement.school.model.Term;
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
@Table(name="tbl_term_exam", uniqueConstraints={@UniqueConstraint(columnNames={"term_exam_name", "term_id"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class TermExam
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long termExamId;
    private String termExamName;
    private Double termPercentege;
    private Term term;

    public TermExam(String termExamName, Double termPercentege, Term term) {
        this.termExamName = termExamName;
        this.termPercentege = termPercentege;
        this.term = term;
    }

    TermExam() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="term_exam_id", nullable=false)
    public Long getTermExamId() {
        return this.termExamId;
    }

    public void setTermExamId(Long termExamId) {
        this.termExamId = termExamId;
    }

    @Column(name="term_exam_name", nullable=false, length=150)
    public String getTermExamName() {
        return this.termExamName;
    }

    public void setTermExamName(String termExamName) {
        this.termExamName = termExamName;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="term_id", nullable=false)
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@termExams")
    @JsonIdentityReference(alwaysAsId=true)
    public Term getTerm() {
        return this.term;
    }

    public void setTerm(Term term) {
        this.term = term;
    }

    @Column(name="term_exam_percentage", nullable=false, length=100)
    public Double getTermPercentege() {
        return this.termPercentege;
    }

    public void setTermPercentege(Double termPercentege) {
        this.termPercentege = termPercentege;
    }
}
