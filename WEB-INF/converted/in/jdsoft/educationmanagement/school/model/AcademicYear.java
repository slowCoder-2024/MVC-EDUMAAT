/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonIgnoreProperties
 *  com.fasterxml.jackson.annotation.JsonInclude
 *  com.fasterxml.jackson.annotation.JsonInclude$Include
 *  com.fasterxml.jackson.annotation.JsonManagedReference
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
import com.fasterxml.jackson.annotation.JsonManagedReference;
import in.jdsoft.educationmanagement.school.model.ComplaintManagement;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.InventoryItemIssueMaster;
import in.jdsoft.educationmanagement.school.model.InventoryItemReturnMaster;
import in.jdsoft.educationmanagement.school.model.InventoryPurchaseOrder;
import in.jdsoft.educationmanagement.school.model.InventoryReceipt;
import in.jdsoft.educationmanagement.school.model.SickRoomVisitor;
import in.jdsoft.educationmanagement.school.model.StaffAppraisal;
import in.jdsoft.educationmanagement.school.model.Student;
import in.jdsoft.educationmanagement.school.model.StudentAppraisal;
import in.jdsoft.educationmanagement.school.model.StudentFeeRefundReceipt;
import in.jdsoft.educationmanagement.school.model.StudentHostelIDCardGeneration;
import in.jdsoft.educationmanagement.school.model.StudentIDCardGeneration;
import in.jdsoft.educationmanagement.school.model.StudentInvoice;
import in.jdsoft.educationmanagement.school.model.StudentMovementRequisition;
import in.jdsoft.educationmanagement.school.model.StudentReceipt;
import in.jdsoft.educationmanagement.school.model.StudentReceiptFine;
import in.jdsoft.educationmanagement.school.model.StudentTransportIDCardGeneration;
import in.jdsoft.educationmanagement.school.model.SubstituteTimeTableGenerator;
import in.jdsoft.educationmanagement.school.model.TCRequisition;
import in.jdsoft.educationmanagement.school.model.TimeTableGenerator;
import java.util.HashSet;
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
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tbl_academic_year", uniqueConstraints={@UniqueConstraint(columnNames={"academic_year_title"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class AcademicYear {
    private Long academicYearId;
    private String academicYearTitle;
    private Long totalWorkingDays;
    private Integer academicYearStatus;
    private Institution institution;
    private Set<TimeTableGenerator> timeTableGenerators = new LinkedHashSet<TimeTableGenerator>();
    private Set<Student> joinedStudents = new HashSet<Student>(0);
    private Set<StudentInvoice> studentInvoices = new HashSet<StudentInvoice>(0);
    private Set<StudentReceipt> studentReceipts = new HashSet<StudentReceipt>(0);
    private Set<StudentFeeRefundReceipt> studentFeeRefundReceipts = new HashSet<StudentFeeRefundReceipt>(0);
    private Set<StudentReceiptFine> studentReceiptFines = new HashSet<StudentReceiptFine>(0);
    private Set<StudentIDCardGeneration> studentIDCardGenerations = new LinkedHashSet<StudentIDCardGeneration>(0);
    private Set<StudentTransportIDCardGeneration> studentTransportIDCardGenerations = new LinkedHashSet<StudentTransportIDCardGeneration>(0);
    private Set<StudentHostelIDCardGeneration> studentHostelIDCardGenerations = new LinkedHashSet<StudentHostelIDCardGeneration>(0);
    private Set<TCRequisition> tCRequisitions = new LinkedHashSet<TCRequisition>(0);
    private Set<StudentMovementRequisition> studentMovementRequisitions = new LinkedHashSet<StudentMovementRequisition>(0);
    private Set<InventoryPurchaseOrder> inventoryPurchaseOrders = new LinkedHashSet<InventoryPurchaseOrder>();
    private Set<InventoryReceipt> inventoryReceipts = new LinkedHashSet<InventoryReceipt>();
    private Set<InventoryItemIssueMaster> inventoryItemIssueAndReturnMasters = new LinkedHashSet<InventoryItemIssueMaster>();
    private Set<InventoryItemReturnMaster> returnedInventoryItemIssueAndReturnMasters = new LinkedHashSet<InventoryItemReturnMaster>();
    private Set<SickRoomVisitor> sickRoomVisitors = new LinkedHashSet<SickRoomVisitor>();
    private Set<ComplaintManagement> complaintManagements = new LinkedHashSet<ComplaintManagement>();
    private Set<StudentAppraisal> studentAppraisals = new LinkedHashSet<StudentAppraisal>();
    private Set<StaffAppraisal> staffAppraisals = new LinkedHashSet<StaffAppraisal>();
    private Set<SubstituteTimeTableGenerator> substituteTimeTableGenerators = new LinkedHashSet<SubstituteTimeTableGenerator>();

    public AcademicYear() {
    }

    public AcademicYear(String academicYearTitle, Integer academicYearStatus, Long totalWorkingDays, Institution institution) {
        this.academicYearTitle = academicYearTitle;
        this.academicYearStatus = academicYearStatus;
        this.institution = institution;
        this.totalWorkingDays = totalWorkingDays;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="academic_year_id", nullable=false)
    public Long getAcademicYearId() {
        return this.academicYearId;
    }

    public void setAcademicYearId(Long academicYearId) {
        this.academicYearId = academicYearId;
    }

    @Column(name="academic_year_title", nullable=false, length=100)
    public String getAcademicYearTitle() {
        return this.academicYearTitle;
    }

    public void setAcademicYearTitle(String academicYearTitle) {
        this.academicYearTitle = academicYearTitle;
    }

    @Column(name="academic_total_working_days", nullable=false, length=100)
    public Long getTotalWorkingDays() {
        return this.totalWorkingDays;
    }

    public void setTotalWorkingDays(Long totalWorkingDays) {
        this.totalWorkingDays = totalWorkingDays;
    }

    @Column(name="academic_year_status", nullable=false)
    public Integer getAcademicYearStatus() {
        return this.academicYearStatus;
    }

    public void setAcademicYearStatus(Integer academicYearStatus) {
        this.academicYearStatus = academicYearStatus;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="institution_id", nullable=true)
    @ForeignKey(name="academicYearInInstitution")
    @JsonManagedReference
    public Institution getInstitution() {
        return this.institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="joinedAcademicYear")
    @ForeignKey(name="academicYearInStudents")
    @OrderBy(value="student_id ASC")
    public Set<Student> getJoinedStudents() {
        return this.joinedStudents;
    }

    public void setJoinedStudents(Set<Student> joinedStudents) {
        this.joinedStudents = joinedStudents;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="academicYear")
    @ForeignKey(name="academicYearInStudentInvoices")
    @OrderBy(value="student_invoice_id ASC")
    public Set<StudentInvoice> getStudentInvoices() {
        return this.studentInvoices;
    }

    public void setStudentInvoices(Set<StudentInvoice> studentInvoices) {
        this.studentInvoices = studentInvoices;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="academicYear")
    @ForeignKey(name="academicYearInStudentReceipts")
    @OrderBy(value="student_receipt_id ASC")
    public Set<StudentReceipt> getStudentReceipts() {
        return this.studentReceipts;
    }

    public void setStudentReceipts(Set<StudentReceipt> studentReceipts) {
        this.studentReceipts = studentReceipts;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="academicYear")
    @ForeignKey(name="academicYearInStudentReceiptFine")
    public Set<StudentReceiptFine> getStudentReceiptFines() {
        return this.studentReceiptFines;
    }

    public void setStudentReceiptFines(Set<StudentReceiptFine> studentReceiptFines) {
        this.studentReceiptFines = studentReceiptFines;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="academicYear")
    @ForeignKey(name="timeTableGeneratorInAcademicYear")
    public Set<TimeTableGenerator> getTimeTableGenerators() {
        return this.timeTableGenerators;
    }

    public void setTimeTableGenerators(Set<TimeTableGenerator> timeTableGenerators) {
        this.timeTableGenerators = timeTableGenerators;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="academicYear")
    @ForeignKey(name="academicYearInStudentIDCardGenerations")
    @OrderBy(value="studentIDCardGenerationId ASC")
    public Set<StudentIDCardGeneration> getStudentIDCardGenerations() {
        return this.studentIDCardGenerations;
    }

    public void setStudentIDCardGenerations(Set<StudentIDCardGeneration> studentIDCardGenerations) {
        this.studentIDCardGenerations = studentIDCardGenerations;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="academicYear")
    @ForeignKey(name="academicYearInTCRequisition")
    @OrderBy(value="transferCertificateRequisitionId ASC")
    public Set<TCRequisition> gettCRequisitions() {
        return this.tCRequisitions;
    }

    public void settCRequisitions(Set<TCRequisition> tCRequisitions) {
        this.tCRequisitions = tCRequisitions;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="academicYear")
    @ForeignKey(name="academicYearInStudentMovementRequisition")
    @OrderBy(value="studentMovementRequisitionId ASC")
    public Set<StudentMovementRequisition> getStudentMovementRequisitions() {
        return this.studentMovementRequisitions;
    }

    public void setStudentMovementRequisitions(Set<StudentMovementRequisition> studentMovementRequisitions) {
        this.studentMovementRequisitions = studentMovementRequisitions;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="academicYear")
    @ForeignKey(name="academicYearInInventoryPurchaseOrder")
    @OrderBy(value="purchase_order_id ASC")
    public Set<InventoryPurchaseOrder> getInventoryPurchaseOrders() {
        return this.inventoryPurchaseOrders;
    }

    public void setInventoryPurchaseOrders(Set<InventoryPurchaseOrder> inventoryPurchaseOrders) {
        this.inventoryPurchaseOrders = inventoryPurchaseOrders;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="academicYear")
    @ForeignKey(name="academicYearInInventoryReceipt")
    public Set<InventoryReceipt> getInventoryReceipts() {
        return this.inventoryReceipts;
    }

    public void setInventoryReceipts(Set<InventoryReceipt> inventoryReceipts) {
        this.inventoryReceipts = inventoryReceipts;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="academicYear")
    @ForeignKey(name="academicYearInInventoryItemIssueAndReturnMaster")
    public Set<InventoryItemIssueMaster> getInventoryItemIssueAndReturnMasters() {
        return this.inventoryItemIssueAndReturnMasters;
    }

    public void setInventoryItemIssueAndReturnMasters(Set<InventoryItemIssueMaster> inventoryItemIssueAndReturnMasters) {
        this.inventoryItemIssueAndReturnMasters = inventoryItemIssueAndReturnMasters;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="itemReturnedAcademicYear")
    @ForeignKey(name="academicYearInInventoryItemIssueAndReturnMaster")
    public Set<InventoryItemReturnMaster> getReturnedInventoryItemIssueAndReturnMasters() {
        return this.returnedInventoryItemIssueAndReturnMasters;
    }

    public void setReturnedInventoryItemIssueAndReturnMasters(Set<InventoryItemReturnMaster> returnedInventoryItemIssueAndReturnMasters) {
        this.returnedInventoryItemIssueAndReturnMasters = returnedInventoryItemIssueAndReturnMasters;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="academicYear")
    @ForeignKey(name="academicYearInSickRoomVisitor")
    public Set<SickRoomVisitor> getSickRoomVisitors() {
        return this.sickRoomVisitors;
    }

    public void setSickRoomVisitors(Set<SickRoomVisitor> sickRoomVisitors) {
        this.sickRoomVisitors = sickRoomVisitors;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="academicYear")
    @ForeignKey(name="academicYearInComplaintManagment")
    public Set<ComplaintManagement> getComplaintManagements() {
        return this.complaintManagements;
    }

    public void setComplaintManagements(Set<ComplaintManagement> complaintManagements) {
        this.complaintManagements = complaintManagements;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="academicYear")
    @ForeignKey(name="academicYearInStudentAppraisal")
    public Set<StudentAppraisal> getStudentAppraisals() {
        return this.studentAppraisals;
    }

    public void setStudentAppraisals(Set<StudentAppraisal> studentAppraisals) {
        this.studentAppraisals = studentAppraisals;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="academicYear")
    @ForeignKey(name="academicYearInStaffAppraisal")
    public Set<StaffAppraisal> getStaffAppraisals() {
        return this.staffAppraisals;
    }

    public void setStaffAppraisals(Set<StaffAppraisal> staffAppraisals) {
        this.staffAppraisals = staffAppraisals;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="academicYear")
    @ForeignKey(name="academicYearInSubstituteTimeTableGenerator")
    public Set<SubstituteTimeTableGenerator> getSubstituteTimeTableGenerators() {
        return this.substituteTimeTableGenerators;
    }

    public void setSubstituteTimeTableGenerators(Set<SubstituteTimeTableGenerator> substituteTimeTableGenerators) {
        this.substituteTimeTableGenerators = substituteTimeTableGenerators;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="academicYear")
    @ForeignKey(name="academicYearInStudentTransportIDCardGenerations")
    @OrderBy(value="studentTransportIDCardGenerationId ASC")
    public Set<StudentTransportIDCardGeneration> getStudentTransportIDCardGenerations() {
        return this.studentTransportIDCardGenerations;
    }

    public void setStudentTransportIDCardGenerations(Set<StudentTransportIDCardGeneration> studentTransportIDCardGenerations) {
        this.studentTransportIDCardGenerations = studentTransportIDCardGenerations;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="academicYear")
    @ForeignKey(name="academicYearInStudentHostelIDCardGenerations")
    @OrderBy(value="studentHostelIDCardGenerationId ASC")
    public Set<StudentHostelIDCardGeneration> getStudentHostelIDCardGenerations() {
        return this.studentHostelIDCardGenerations;
    }

    public void setStudentHostelIDCardGenerations(Set<StudentHostelIDCardGeneration> studentHostelIDCardGenerations) {
        this.studentHostelIDCardGenerations = studentHostelIDCardGenerations;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="academicYear")
    @ForeignKey(name="academicYearInStudentFeeRefundReceipts")
    @OrderBy(value="student_fee_refund_receipt_id ASC")
    public Set<StudentFeeRefundReceipt> getStudentFeeRefundReceipts() {
        return this.studentFeeRefundReceipts;
    }

    public void setStudentFeeRefundReceipts(Set<StudentFeeRefundReceipt> studentFeeRefundReceipts) {
        this.studentFeeRefundReceipts = studentFeeRefundReceipts;
    }
}
