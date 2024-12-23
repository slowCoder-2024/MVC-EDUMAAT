/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
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
 *  javax.persistence.OneToMany
 *  javax.persistence.Table
 *  javax.persistence.UniqueConstraint
 *  org.hibernate.annotations.ForeignKey
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.StudentInvoice;
import java.io.Serializable;
import java.util.HashSet;
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
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tbl_fees_term", uniqueConstraints={@UniqueConstraint(columnNames={"institution_id", "fees_term_name"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class FeesTerm
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long feesTermId;
    private String feesTermName;
    private Institution institution;
    private Set<StudentInvoice> studentInvoices = new HashSet<StudentInvoice>(0);

    public FeesTerm() {
    }

    public FeesTerm(String feesTermName, Institution institution) {
        this.feesTermName = feesTermName;
        this.institution = institution;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="fees_term_id", nullable=false)
    public Long getFeesTermId() {
        return this.feesTermId;
    }

    public void setFeesTermId(Long feesTermId) {
        this.feesTermId = feesTermId;
    }

    @Column(name="fees_term_name", nullable=false, length=100)
    public String getFeesTermName() {
        return this.feesTermName;
    }

    public void setFeesTermName(String feesTermName) {
        this.feesTermName = feesTermName;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="institution_id", nullable=false)
    @ForeignKey(name="feesTermsInInstitution")
    public Institution getInstitution() {
        return this.institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="feesTerm")
    @ForeignKey(name="feesTermInStudentInvoices")
    public Set<StudentInvoice> getStudentInvoices() {
        return this.studentInvoices;
    }

    public void setStudentInvoices(Set<StudentInvoice> studentInvoices) {
        this.studentInvoices = studentInvoices;
    }
}
