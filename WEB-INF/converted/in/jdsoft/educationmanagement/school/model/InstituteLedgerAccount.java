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
 *  javax.persistence.OrderBy
 *  javax.persistence.Table
 *  javax.persistence.UniqueConstraint
 *  org.hibernate.annotations.ForeignKey
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import in.jdsoft.educationmanagement.school.model.FeesItem;
import in.jdsoft.educationmanagement.school.model.Institution;
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
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tbl_institution_ledger_account", uniqueConstraints={@UniqueConstraint(columnNames={"ledger_account_name", "institution_id"}), @UniqueConstraint(columnNames={"ledger_reference_number", "institution_id"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class InstituteLedgerAccount
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long ledgerAccountId;
    private String ledgerAccountName;
    private String ledgerReferenceNo;
    private Institution institution;
    private Set<FeesItem> feesItems = new HashSet<FeesItem>(0);

    public InstituteLedgerAccount() {
    }

    public InstituteLedgerAccount(String ledgerAccountName, String ledgerReferenceNo, Institution institution) {
        this.ledgerAccountName = ledgerAccountName;
        this.ledgerReferenceNo = ledgerReferenceNo;
        this.institution = institution;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ledger_account_id", nullable=false)
    public Long getLedgerAccountId() {
        return this.ledgerAccountId;
    }

    public void setLedgerAccountId(Long ledgerAccountId) {
        this.ledgerAccountId = ledgerAccountId;
    }

    @Column(name="ledger_account_name", nullable=false, length=100)
    public String getLedgerAccountName() {
        return this.ledgerAccountName;
    }

    public void setLedgerAccountName(String ledgerAccountName) {
        this.ledgerAccountName = ledgerAccountName;
    }

    @Column(name="ledger_reference_number", nullable=false, length=100)
    public String getLedgerReferenceNo() {
        return this.ledgerReferenceNo;
    }

    public void setLedgerReferenceNo(String ledgerReferenceNo) {
        this.ledgerReferenceNo = ledgerReferenceNo;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="institution_id")
    @ForeignKey(name="instituteLedgerAccountInInstitution")
    public Institution getInstitution() {
        return this.institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="ledgerAccount")
    @ForeignKey(name="ledgerAccountInFeesItems")
    @OrderBy(value="fees_item_id ASC")
    public Set<FeesItem> getFeesItems() {
        return this.feesItems;
    }

    public void setFeesItems(Set<FeesItem> feesItems) {
        this.feesItems = feesItems;
    }
}
