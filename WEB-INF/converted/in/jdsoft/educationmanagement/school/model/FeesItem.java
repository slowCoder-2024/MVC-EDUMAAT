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
 *  javax.persistence.JoinTable
 *  javax.persistence.ManyToMany
 *  javax.persistence.ManyToOne
 *  javax.persistence.OneToMany
 *  javax.persistence.OneToOne
 *  javax.persistence.OrderBy
 *  javax.persistence.Table
 *  javax.persistence.UniqueConstraint
 *  org.apache.commons.lang.WordUtils
 *  org.hibernate.annotations.ForeignKey
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import in.jdsoft.educationmanagement.school.model.BusRouteStop;
import in.jdsoft.educationmanagement.school.model.FeesStructure;
import in.jdsoft.educationmanagement.school.model.InstituteLedgerAccount;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.StudentFeeRefundReceiptDetail;
import in.jdsoft.educationmanagement.school.model.StudentInvoiceDetail;
import in.jdsoft.educationmanagement.school.model.StudentPartialPaymentReceiptDetail;
import in.jdsoft.educationmanagement.school.model.StudentReceiptDetail;
import in.jdsoft.educationmanagement.school.model.TaxClass;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.apache.commons.lang.WordUtils;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tbl_fees_item", uniqueConstraints={@UniqueConstraint(columnNames={"fees_item_name", "institution_id"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class FeesItem
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long feesItemId;
    private String feesItemName;
    private double feesItemPrice;
    private InstituteLedgerAccount ledgerAccount;
    private double originalFeesItemPrice;
    private double totalGSTPercentage;
    private Institution institution;
    private BusRouteStop busRouteStop;
    private Set<FeesStructure> feesStructures = new LinkedHashSet<FeesStructure>();
    private Set<StudentInvoiceDetail> studentInvoiceItems = new LinkedHashSet<StudentInvoiceDetail>(0);
    private Set<StudentReceiptDetail> studentReceiptsItems = new LinkedHashSet<StudentReceiptDetail>(0);
    private Set<StudentPartialPaymentReceiptDetail> studentPartialPaymentReceiptsItems = new LinkedHashSet<StudentPartialPaymentReceiptDetail>(0);
    private Set<StudentFeeRefundReceiptDetail> studentFeeRefundReceiptsItems = new LinkedHashSet<StudentFeeRefundReceiptDetail>(0);
    private Set<TaxClass> taxClasses = new LinkedHashSet<TaxClass>();

    public FeesItem(String feesItemName, double feesItemPrice, InstituteLedgerAccount ledgerAccount, double originalFeesItemPrice, double totalGSTPercentage, Institution institution, Set<TaxClass> taxClasses) {
        this.feesItemName = feesItemName;
        this.feesItemPrice = feesItemPrice;
        this.ledgerAccount = ledgerAccount;
        this.originalFeesItemPrice = originalFeesItemPrice;
        this.totalGSTPercentage = totalGSTPercentage;
        this.institution = institution;
        this.taxClasses = taxClasses;
    }

    FeesItem() {
    }

    public FeesItem(String feesItemName, double feesItemPrice, InstituteLedgerAccount ledgerAccount, Institution institution) {
        this.feesItemName = WordUtils.capitalize((String)feesItemName);
        this.feesItemPrice = feesItemPrice;
        this.ledgerAccount = ledgerAccount;
        this.institution = institution;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="fees_item_id", nullable=false)
    public Long getFeesItemId() {
        return this.feesItemId;
    }

    public void setFeesItemId(Long feesItemId) {
        this.feesItemId = feesItemId;
    }

    @Column(name="fees_item_name", nullable=false, length=100)
    public String getFeesItemName() {
        return this.feesItemName;
    }

    public void setFeesItemName(String feesItemName) {
        this.feesItemName = feesItemName;
    }

    @Column(name="fees_item_price", nullable=false, precision=22, scale=0)
    public double getFeesItemPrice() {
        return this.feesItemPrice;
    }

    public void setFeesItemPrice(double feesItemPrice) {
        this.feesItemPrice = feesItemPrice;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="institution_id", nullable=false)
    @ForeignKey(name="feesItemInInstitution")
    public Institution getInstitution() {
        return this.institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    @ManyToMany(fetch=FetchType.LAZY, mappedBy="feesItems")
    @ForeignKey(name="feesItemsInFeesStructuress")
    public Set<FeesStructure> getFeesStructures() {
        return this.feesStructures;
    }

    public void setFeesStructures(Set<FeesStructure> feesStructures) {
        this.feesStructures = feesStructures;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ledger_account_id")
    @ForeignKey(name="feesItemsInLedgerAccount")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@feesItems")
    @JsonIdentityReference(alwaysAsId=true)
    public InstituteLedgerAccount getLedgerAccount() {
        return this.ledgerAccount;
    }

    public void setLedgerAccount(InstituteLedgerAccount ledgerAccount) {
        this.ledgerAccount = ledgerAccount;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="feesItem")
    @ForeignKey(name="FeesItemInStudentInvoiceDetails")
    @OrderBy(value="student_invoice_detail_id ASC")
    @JsonBackReference
    public Set<StudentInvoiceDetail> getStudentInvoiceItems() {
        return this.studentInvoiceItems;
    }

    public void setStudentInvoiceItems(Set<StudentInvoiceDetail> studentInvoiceItems) {
        this.studentInvoiceItems = studentInvoiceItems;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="feesItem")
    @ForeignKey(name="feesItemInStudentReceiptDetails")
    @OrderBy(value="student_receipt_detail_id ASC")
    public Set<StudentReceiptDetail> getStudentReceiptsItems() {
        return this.studentReceiptsItems;
    }

    public void setStudentReceiptsItems(Set<StudentReceiptDetail> studentReceiptsItems) {
        this.studentReceiptsItems = studentReceiptsItems;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="feesItem")
    @ForeignKey(name="feesItemInStudentPartialPaymentReceiptDetails")
    @OrderBy(value="student_partial_payment_receipt_detail_id ASC")
    @JsonBackReference
    public Set<StudentPartialPaymentReceiptDetail> getStudentPartialPaymentReceiptsItems() {
        return this.studentPartialPaymentReceiptsItems;
    }

    public void setStudentPartialPaymentReceiptsItems(Set<StudentPartialPaymentReceiptDetail> studentPartialPaymentReceiptsItems) {
        this.studentPartialPaymentReceiptsItems = studentPartialPaymentReceiptsItems;
    }

    @OneToOne(fetch=FetchType.LAZY, mappedBy="feesItem")
    @JsonBackReference
    public BusRouteStop getBusRouteStop() {
        return this.busRouteStop;
    }

    public void setBusRouteStop(BusRouteStop busRouteStop) {
        this.busRouteStop = busRouteStop;
    }

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="tbl_fees_item_and_taxclass_mapping", joinColumns={@JoinColumn(name="fees_item_id", updatable=true)}, inverseJoinColumns={@JoinColumn(name="tax_id", updatable=true)})
    @ForeignKey(name="taxClassesInFeesItems")
    public Set<TaxClass> getTaxClasses() {
        return this.taxClasses;
    }

    public void setTaxClasses(Set<TaxClass> taxClasses) {
        this.taxClasses = taxClasses;
    }

    @Column(name="original_fees_item_price", nullable=false, precision=22, scale=0)
    public double getOriginalFeesItemPrice() {
        return this.originalFeesItemPrice;
    }

    public void setOriginalFeesItemPrice(double originalFeesItemPrice) {
        this.originalFeesItemPrice = originalFeesItemPrice;
    }

    @Column(name="total_gst_percentage", nullable=false, precision=22, scale=0)
    public double getTotalGSTPercentage() {
        return this.totalGSTPercentage;
    }

    public void setTotalGSTPercentage(double totalGSTPercentage) {
        this.totalGSTPercentage = totalGSTPercentage;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="feesItem")
    @ForeignKey(name="feesItemInStudentFeeRefundReceiptDetails")
    @OrderBy(value="student_fee_refund_receipt_detail_id ASC")
    public Set<StudentFeeRefundReceiptDetail> getStudentFeeRefundReceiptsItems() {
        return this.studentFeeRefundReceiptsItems;
    }

    public void setStudentFeeRefundReceiptsItems(Set<StudentFeeRefundReceiptDetail> studentFeeRefundReceiptsItems) {
        this.studentFeeRefundReceiptsItems = studentFeeRefundReceiptsItems;
    }
}
