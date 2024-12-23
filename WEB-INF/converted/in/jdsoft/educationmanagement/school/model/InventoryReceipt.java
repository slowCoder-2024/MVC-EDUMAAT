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
 *  javax.persistence.OneToOne
 *  javax.persistence.OrderBy
 *  javax.persistence.Table
 *  javax.persistence.Temporal
 *  javax.persistence.TemporalType
 *  javax.persistence.UniqueConstraint
 *  org.hibernate.annotations.ForeignKey
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.InventoryPurchaseOrder;
import in.jdsoft.educationmanagement.school.model.InventoryReceiptDetails;
import in.jdsoft.educationmanagement.school.model.PaymentMode;
import in.jdsoft.educationmanagement.school.model.SupplierMaster;
import in.jdsoft.educationmanagement.school.model.TaxClass;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
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
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tbl_inventory_receipt", uniqueConstraints={@UniqueConstraint(columnNames={"inventory_purchase_order_id"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class InventoryReceipt
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long inventoryReceiptId;
    private InventoryPurchaseOrder inventoryPurchaseOrder;
    private SupplierMaster supplierMaster;
    private String invoiceNumber;
    private String receiptNumber;
    private String tallyReferenceNumber;
    private String transactionNo;
    private PaymentMode paymentMode;
    private Date inventoryReceiptGenerateDate;
    private TaxClass taxClass;
    private Double quantity;
    private Double amount;
    private String chequeNumber;
    private Date chequeDate;
    private String chequeBankName;
    private String chequeBranchName;
    private String ddNumber;
    private Date ddDate;
    private String ddBankName;
    private String ddBranchName;
    private String paymentGateway;
    private String paymentGatewayMode;
    private String createdBy;
    private String modifiedBy;
    private Date createdDate;
    private Date modifiedDate;
    private String narration;
    private AcademicYear academicYear;
    private Set<InventoryReceiptDetails> inventoryReceiptDetails = new HashSet<InventoryReceiptDetails>(0);

    public InventoryReceipt(InventoryPurchaseOrder inventoryPurchaseOrder, String invoiceNumber, String receiptNumber, String tallyReferenceNumber, PaymentMode paymentMode, TaxClass taxClass, Double amount, String ddNumber, Date ddDate, String ddBankName, String ddBranchName, String createdBy, String modifiedBy, String narration, AcademicYear academicYear) {
        this.inventoryPurchaseOrder = inventoryPurchaseOrder;
        this.invoiceNumber = invoiceNumber;
        this.receiptNumber = receiptNumber;
        this.tallyReferenceNumber = tallyReferenceNumber;
        this.transactionNo = Long.toString(System.currentTimeMillis());
        this.paymentMode = paymentMode;
        this.inventoryReceiptGenerateDate = new Timestamp(Calendar.getInstance().getTime().getTime());
        this.taxClass = taxClass;
        this.amount = amount;
        this.ddNumber = ddNumber;
        this.ddDate = ddDate;
        this.ddBankName = ddBankName;
        this.ddBranchName = ddBranchName;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
        this.createdDate = new Timestamp(Calendar.getInstance().getTime().getTime());
        this.narration = narration;
        this.academicYear = academicYear;
    }

    public InventoryReceipt(InventoryPurchaseOrder inventoryPurchaseOrder, String receiptNumber, String tallyReferenceNumber, PaymentMode paymentMode, TaxClass taxClass, Double amount, String chequeNumber, Date chequeDate, String chequeBankName, String chequeBranchName, String createdBy, String modifiedBy, String narration, AcademicYear academicYear, String invoiceNumber) {
        this.inventoryPurchaseOrder = inventoryPurchaseOrder;
        this.invoiceNumber = invoiceNumber;
        this.receiptNumber = receiptNumber;
        this.tallyReferenceNumber = tallyReferenceNumber;
        this.transactionNo = Long.toString(System.currentTimeMillis());
        this.paymentMode = paymentMode;
        this.inventoryReceiptGenerateDate = new Timestamp(Calendar.getInstance().getTime().getTime());
        this.taxClass = taxClass;
        this.amount = amount;
        this.chequeNumber = chequeNumber;
        this.chequeDate = chequeDate;
        this.chequeBankName = chequeBankName;
        this.chequeBranchName = chequeBranchName;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
        this.createdDate = new Timestamp(Calendar.getInstance().getTime().getTime());
        this.narration = narration;
        this.academicYear = academicYear;
    }

    public InventoryReceipt(InventoryPurchaseOrder inventoryPurchaseOrder, String invoiceNumber, PaymentMode paymentMode, String receiptNumber, TaxClass taxClass, Double amount, String createdBy, String tallyReferenceNumber, String modifiedBy, String narration, AcademicYear academicYear) {
        this.inventoryPurchaseOrder = inventoryPurchaseOrder;
        this.invoiceNumber = invoiceNumber;
        this.receiptNumber = receiptNumber;
        this.tallyReferenceNumber = tallyReferenceNumber;
        this.transactionNo = Long.toString(System.currentTimeMillis());
        this.paymentMode = paymentMode;
        this.inventoryReceiptGenerateDate = new Timestamp(Calendar.getInstance().getTime().getTime());
        this.taxClass = taxClass;
        this.amount = amount;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
        this.createdDate = new Timestamp(Calendar.getInstance().getTime().getTime());
        this.narration = narration;
        this.academicYear = academicYear;
    }

    public InventoryReceipt() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="inventory_receipt_id", unique=true, nullable=false)
    public Long getInventoryReceiptId() {
        return this.inventoryReceiptId;
    }

    public void setInventoryReceiptId(Long inventoryReceiptId) {
        this.inventoryReceiptId = inventoryReceiptId;
    }

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="inventory_purchase_order_id", nullable=false)
    @ForeignKey(name="inventoryReceiptInInventoryPurchaseOrder")
    public InventoryPurchaseOrder getInventoryPurchaseOrder() {
        return this.inventoryPurchaseOrder;
    }

    public void setInventoryPurchaseOrder(InventoryPurchaseOrder inventoryPurchaseOrder) {
        this.inventoryPurchaseOrder = inventoryPurchaseOrder;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="supplier_id", nullable=false)
    @ForeignKey(name="inventoryReceiptInSupplierMaster")
    public SupplierMaster getSupplierMaster() {
        return this.supplierMaster;
    }

    public void setSupplierMaster(SupplierMaster supplierMaster) {
        this.supplierMaster = supplierMaster;
    }

    @Column(name="invoice_number", nullable=false, length=100)
    public String getInvoiceNumber() {
        return this.invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    @Column(name="receipt_number", nullable=false, length=100)
    public String getReceiptNumber() {
        return this.receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    @Column(name="tally_ref_number", nullable=false, length=100)
    public String getTallyReferenceNumber() {
        return this.tallyReferenceNumber;
    }

    public void setTallyReferenceNumber(String tallyReferenceNumber) {
        this.tallyReferenceNumber = tallyReferenceNumber;
    }

    @Column(name="transaction_no", nullable=false, length=100)
    public String getTransactionNo() {
        return this.transactionNo;
    }

    public void setTransactionNo(String transactionNo) {
        this.transactionNo = transactionNo;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="payment_mode_id", nullable=false)
    @ForeignKey(name="inventoryReceiptsInPaymentmode")
    public PaymentMode getPaymentMode() {
        return this.paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    @Temporal(value=TemporalType.DATE)
    @Column(name="generate_date", nullable=false)
    public Date getInventoryReceiptGenerateDate() {
        return this.inventoryReceiptGenerateDate;
    }

    public void setInventoryReceiptGenerateDate(Date inventoryReceiptGenerateDate) {
        this.inventoryReceiptGenerateDate = inventoryReceiptGenerateDate;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="tax_id", nullable=false)
    @ForeignKey(name="inventoryReceiptsInTaxClass")
    public TaxClass getTaxClass() {
        return this.taxClass;
    }

    public void setTaxClass(TaxClass taxClass) {
        this.taxClass = taxClass;
    }

    @Column(name="total_qty", nullable=false)
    public Double getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    @Column(name="total_amount", nullable=false)
    public Double getAmount() {
        return this.amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Column(name="cheque_number", nullable=true, length=100)
    public String getChequeNumber() {
        return this.chequeNumber;
    }

    public void setChequeNumber(String chequeNumber) {
        this.chequeNumber = chequeNumber;
    }

    @Temporal(value=TemporalType.DATE)
    @Column(name="cheque_date", nullable=true)
    public Date getChequeDate() {
        return this.chequeDate;
    }

    public void setChequeDate(Date chequeDate) {
        this.chequeDate = chequeDate;
    }

    @Column(name="cheque_bank_name", nullable=true, length=100)
    public String getChequeBankName() {
        return this.chequeBankName;
    }

    public void setChequeBankName(String chequeBankName) {
        this.chequeBankName = chequeBankName;
    }

    @Column(name="cheque_branch_name", nullable=true, length=100)
    public String getChequeBranchName() {
        return this.chequeBranchName;
    }

    public void setChequeBranchName(String chequeBranchName) {
        this.chequeBranchName = chequeBranchName;
    }

    @Column(name="dd_number", nullable=true, length=100)
    public String getDdNumber() {
        return this.ddNumber;
    }

    public void setDdNumber(String ddNumber) {
        this.ddNumber = ddNumber;
    }

    @Temporal(value=TemporalType.DATE)
    @Column(name="dd_date", nullable=true)
    public Date getDdDate() {
        return this.ddDate;
    }

    public void setDdDate(Date ddDate) {
        this.ddDate = ddDate;
    }

    @Column(name="dd_bank_name", nullable=true, length=100)
    public String getDdBankName() {
        return this.ddBankName;
    }

    public void setDdBankName(String ddBankName) {
        this.ddBankName = ddBankName;
    }

    @Column(name="dd_branch_name", nullable=true, length=100)
    public String getDdBranchName() {
        return this.ddBranchName;
    }

    public void setDdBranchName(String ddBranchName) {
        this.ddBranchName = ddBranchName;
    }

    @Column(name="payment_gateway", nullable=true, length=100)
    public String getPaymentGateway() {
        return this.paymentGateway;
    }

    public void setPaymentGateway(String paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    @Column(name="payment_gateway_mode", nullable=true, length=100)
    public String getPaymentGatewayMode() {
        return this.paymentGatewayMode;
    }

    public void setPaymentGatewayMode(String paymentGatewayMode) {
        this.paymentGatewayMode = paymentGatewayMode;
    }

    @Column(name="created_by", nullable=false, length=100)
    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Column(name="modified_by", nullable=false, length=100)
    public String getModifiedBy() {
        return this.modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @Temporal(value=TemporalType.TIMESTAMP)
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

    @Column(name="narration", nullable=true, length=255)
    public String getNarration() {
        return this.narration;
    }

    public void setNarration(String narration) {
        this.narration = narration;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="academic_year_id", nullable=false)
    @ForeignKey(name="inventoryReceiptsInAcademicYear")
    public AcademicYear getAcademicYear() {
        return this.academicYear;
    }

    public void setAcademicYear(AcademicYear academicYear) {
        this.academicYear = academicYear;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="inventoryReceipt", cascade={CascadeType.ALL})
    @ForeignKey(name="inventoryReceiptInInventoryReceiptDetails")
    @OrderBy(value="inventory_receipt_detail_id ASC")
    public Set<InventoryReceiptDetails> getInventoryReceiptDetails() {
        return this.inventoryReceiptDetails;
    }

    public void setInventoryReceiptDetails(Set<InventoryReceiptDetails> inventoryReceiptDetails) {
        this.inventoryReceiptDetails = inventoryReceiptDetails;
    }
}
