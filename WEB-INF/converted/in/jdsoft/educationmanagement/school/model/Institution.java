/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonBackReference
 *  com.fasterxml.jackson.annotation.JsonIgnoreProperties
 *  com.fasterxml.jackson.annotation.JsonInclude
 *  com.fasterxml.jackson.annotation.JsonInclude$Include
 *  com.fasterxml.jackson.annotation.JsonManagedReference
 *  javax.persistence.CascadeType
 *  javax.persistence.Column
 *  javax.persistence.Entity
 *  javax.persistence.FetchType
 *  javax.persistence.GeneratedValue
 *  javax.persistence.GenerationType
 *  javax.persistence.Id
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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.Class;
import in.jdsoft.educationmanagement.school.model.CommunicationFeedBackAndOthers;
import in.jdsoft.educationmanagement.school.model.CommunicationFeedBackAndOthersArchive;
import in.jdsoft.educationmanagement.school.model.CommunicationNotification;
import in.jdsoft.educationmanagement.school.model.CommunicationNotificationArchive;
import in.jdsoft.educationmanagement.school.model.ComplaintManagement;
import in.jdsoft.educationmanagement.school.model.DocumentType;
import in.jdsoft.educationmanagement.school.model.ExamTemplate;
import in.jdsoft.educationmanagement.school.model.FeesItem;
import in.jdsoft.educationmanagement.school.model.FeesStructure;
import in.jdsoft.educationmanagement.school.model.FeesTerm;
import in.jdsoft.educationmanagement.school.model.GradeSystem;
import in.jdsoft.educationmanagement.school.model.Houses;
import in.jdsoft.educationmanagement.school.model.InstituteLedgerAccount;
import in.jdsoft.educationmanagement.school.model.InventoryPurchaseOrder;
import in.jdsoft.educationmanagement.school.model.Module;
import in.jdsoft.educationmanagement.school.model.PortalMessage;
import in.jdsoft.educationmanagement.school.model.PortalNotification;
import in.jdsoft.educationmanagement.school.model.PortalReplyMessage;
import in.jdsoft.educationmanagement.school.model.PortalTask;
import in.jdsoft.educationmanagement.school.model.ReportCardGenerator;
import in.jdsoft.educationmanagement.school.model.Section;
import in.jdsoft.educationmanagement.school.model.SickRoomVisitor;
import in.jdsoft.educationmanagement.school.model.SpecialCategory;
import in.jdsoft.educationmanagement.school.model.Staff;
import in.jdsoft.educationmanagement.school.model.StaffAppraisal;
import in.jdsoft.educationmanagement.school.model.StaffAttendance;
import in.jdsoft.educationmanagement.school.model.StaffAttendanceConfiguration;
import in.jdsoft.educationmanagement.school.model.StaffDesignation;
import in.jdsoft.educationmanagement.school.model.Student;
import in.jdsoft.educationmanagement.school.model.StudentAppraisal;
import in.jdsoft.educationmanagement.school.model.StudentAttendance;
import in.jdsoft.educationmanagement.school.model.StudentFeeRefundReceipt;
import in.jdsoft.educationmanagement.school.model.StudentHostelIDCardGeneration;
import in.jdsoft.educationmanagement.school.model.StudentIDCardGeneration;
import in.jdsoft.educationmanagement.school.model.StudentInvoice;
import in.jdsoft.educationmanagement.school.model.StudentMark;
import in.jdsoft.educationmanagement.school.model.StudentMovementRequisition;
import in.jdsoft.educationmanagement.school.model.StudentReceipt;
import in.jdsoft.educationmanagement.school.model.StudentTransportIDCardGeneration;
import in.jdsoft.educationmanagement.school.model.SubstituteTimeTableGenerator;
import in.jdsoft.educationmanagement.school.model.TCRequisition;
import in.jdsoft.educationmanagement.school.model.TimeTableGenerator;
import in.jdsoft.educationmanagement.school.model.TimeTableTemplate;
import in.jdsoft.educationmanagement.school.model.User;
import in.jdsoft.educationmanagement.school.model.UserRole;
import in.jdsoft.educationmanagement.school.model.VisitorIDCardGeneration;
import in.jdsoft.educationmanagement.school.model.VisitorManagement;
import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.apache.commons.lang.WordUtils;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tbl_institution", uniqueConstraints={@UniqueConstraint(columnNames={"institution_name", "institution_alias_name", "institution_code"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class Institution
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long institutionId;
    private String institutionCode;
    private String institutionName;
    private String institutionAliasName;
    private String institutionAddressline1;
    private String institutionAddressline2;
    private String institutionCountry;
    private String institutionState;
    private String institutionCity;
    private String institutionContact;
    private String institutionEmail;
    private String institutionLogo;
    private String institutionPostcode;
    private String currencyCode;
    private Integer institutionStatus;
    private boolean collectReceiptsInOrder;
    private String authorizedSignature;
    private Set<Class> classes = new LinkedHashSet<Class>();
    private Set<Section> sections = new LinkedHashSet<Section>();
    private Set<Module> modules = new LinkedHashSet<Module>();
    private Set<SpecialCategory> specialCategories = new LinkedHashSet<SpecialCategory>();
    private Set<Houses> houses = new LinkedHashSet<Houses>();
    private Set<DocumentType> documentTypes = new LinkedHashSet<DocumentType>();
    private Set<Student> students = new LinkedHashSet<Student>();
    private Set<AcademicYear> academicYears = new LinkedHashSet<AcademicYear>();
    private Set<UserRole> userRoles = new LinkedHashSet<UserRole>();
    private Set<User> users = new LinkedHashSet<User>();
    private Set<Staff> staffs = new LinkedHashSet<Staff>();
    private Set<TimeTableTemplate> timeTableTemplates = new LinkedHashSet<TimeTableTemplate>();
    private Set<TimeTableGenerator> timeTableGenerators = new LinkedHashSet<TimeTableGenerator>();
    private Set<GradeSystem> gradeSystem = new LinkedHashSet<GradeSystem>();
    private Set<ExamTemplate> examTemplates = new LinkedHashSet<ExamTemplate>();
    private Set<StaffDesignation> staffDesignations = new LinkedHashSet<StaffDesignation>();
    private Set<FeesTerm> feesTerms = new LinkedHashSet<FeesTerm>();
    private Set<FeesItem> feesItems = new LinkedHashSet<FeesItem>();
    private Set<FeesStructure> feesStructures = new LinkedHashSet<FeesStructure>();
    private StaffAttendanceConfiguration staffAttendanceConfiguration;
    private Set<StudentAttendance> studentAttendances = new LinkedHashSet<StudentAttendance>();
    private Set<StaffAttendance> staffAttendances = new LinkedHashSet<StaffAttendance>();
    private Set<CommunicationNotification> communicationNotifications = new LinkedHashSet<CommunicationNotification>();
    private Set<CommunicationFeedBackAndOthers> communicationFeedBackAndOthers = new LinkedHashSet<CommunicationFeedBackAndOthers>();
    private Set<CommunicationNotificationArchive> communicationNotificationArchives = new LinkedHashSet<CommunicationNotificationArchive>();
    private Set<PortalNotification> portalNotifications = new LinkedHashSet<PortalNotification>();
    private Set<PortalMessage> portalMessages = new LinkedHashSet<PortalMessage>();
    private Set<PortalTask> portalTasks = new LinkedHashSet<PortalTask>();
    private Set<PortalReplyMessage> portalReplyMessages = new LinkedHashSet<PortalReplyMessage>();
    private Set<CommunicationFeedBackAndOthersArchive> communicationFeedBackAndOthersArchives = new LinkedHashSet<CommunicationFeedBackAndOthersArchive>();
    private Set<StudentMark> studentMark = new LinkedHashSet<StudentMark>();
    private Set<ReportCardGenerator> reportCardGenerator = new LinkedHashSet<ReportCardGenerator>(0);
    private Set<InstituteLedgerAccount> ledgerAccounts = new HashSet<InstituteLedgerAccount>(0);
    private Set<StudentInvoice> studentInvoices = new HashSet<StudentInvoice>(0);
    private Set<StudentReceipt> studentReceipts = new HashSet<StudentReceipt>(0);
    private Set<StudentFeeRefundReceipt> studentFeeRefundReceipts = new HashSet<StudentFeeRefundReceipt>(0);
    private Set<StudentIDCardGeneration> studentIDCardGenerations = new LinkedHashSet<StudentIDCardGeneration>(0);
    private Set<StudentTransportIDCardGeneration> studentTransportIDCardGenerations = new LinkedHashSet<StudentTransportIDCardGeneration>(0);
    private Set<StudentHostelIDCardGeneration> studentHostelIDCardGenerations = new LinkedHashSet<StudentHostelIDCardGeneration>(0);
    private Set<VisitorIDCardGeneration> visitorIDCardGenerations = new LinkedHashSet<VisitorIDCardGeneration>(0);
    private Set<VisitorManagement> visitorManagements = new LinkedHashSet<VisitorManagement>(0);
    private Set<TCRequisition> tCRequisitions = new LinkedHashSet<TCRequisition>(0);
    private Set<StudentMovementRequisition> studentMovementRequisitions = new LinkedHashSet<StudentMovementRequisition>(0);
    private Set<InventoryPurchaseOrder> inventoryPurchaseOrders = new LinkedHashSet<InventoryPurchaseOrder>();
    private Set<SickRoomVisitor> sickRoomVisitors = new LinkedHashSet<SickRoomVisitor>();
    private Set<ComplaintManagement> complaintManagements = new LinkedHashSet<ComplaintManagement>();
    private Set<StudentAppraisal> studentAppraisals = new LinkedHashSet<StudentAppraisal>();
    private Set<StaffAppraisal> staffAppraisals = new LinkedHashSet<StaffAppraisal>();
    private Set<SubstituteTimeTableGenerator> substituteTimeTableGenerators = new LinkedHashSet<SubstituteTimeTableGenerator>();

    Institution() {
    }

    public Institution(String institutionName, String institutionCode, String institutionAliasName, String institutionAddressline1, String institutionAddressline2, String institutionCountry, String institutionState, String institutionCity, String institutionContact, String institutionEmail, String institutionLogo, String institutionPostcode, String currencyCode, Integer institutionStatus, boolean collectReceiptInOrder, String authorizedSignature) {
        this.institutionName = WordUtils.capitalize((String)institutionName);
        this.institutionCode = institutionCode;
        this.institutionAddressline1 = WordUtils.capitalize((String)institutionAddressline1);
        this.institutionAddressline2 = WordUtils.capitalize((String)institutionAddressline2);
        this.institutionCountry = institutionCountry;
        this.institutionState = institutionState;
        this.institutionCity = institutionCity;
        this.institutionContact = institutionContact;
        this.institutionEmail = institutionEmail.toLowerCase();
        this.institutionLogo = institutionLogo;
        this.institutionPostcode = institutionPostcode;
        this.currencyCode = currencyCode.toUpperCase();
        this.institutionStatus = institutionStatus;
        this.institutionAliasName = institutionAliasName;
        this.collectReceiptsInOrder = collectReceiptInOrder;
        this.authorizedSignature = authorizedSignature;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="institution_id", unique=true, nullable=false)
    public Long getInstitutionId() {
        return this.institutionId;
    }

    public void setInstitutionId(Long institutionId) {
        this.institutionId = institutionId;
    }

    @Column(name="institution_name", nullable=false, length=255)
    public String getInstitutionName() {
        return this.institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = WordUtils.capitalize((String)institutionName);
    }

    @Column(name="institution_addressline1", nullable=false)
    public String getInstitutionAddressline1() {
        return this.institutionAddressline1;
    }

    public void setInstitutionAddressline1(String institutionAddressline1) {
        this.institutionAddressline1 = WordUtils.capitalize((String)institutionAddressline1);
    }

    @Column(name="institution_addressline2", nullable=false)
    public String getInstitutionAddressline2() {
        return this.institutionAddressline2;
    }

    public void setInstitutionAddressline2(String institutionAddressline2) {
        this.institutionAddressline2 = WordUtils.capitalize((String)institutionAddressline2);
    }

    @Column(name="institution_contact", nullable=false, length=20)
    public String getInstitutionContact() {
        return this.institutionContact;
    }

    public void setInstitutionContact(String institutionContact) {
        this.institutionContact = institutionContact;
    }

    @Column(name="institution_email", nullable=false, length=100)
    public String getInstitutionEmail() {
        return this.institutionEmail;
    }

    public void setInstitutionEmail(String institutionEmail) {
        this.institutionEmail = institutionEmail.toLowerCase();
    }

    @Column(name="institution_logo", nullable=false)
    public String getInstitutionLogo() {
        return this.institutionLogo;
    }

    public void setInstitutionLogo(String institutionLogo) {
        this.institutionLogo = institutionLogo;
    }

    @Column(name="institution_postcode", nullable=false, length=10)
    public String getInstitutionPostcode() {
        return this.institutionPostcode;
    }

    public void setInstitutionPostcode(String institutionPostcode) {
        this.institutionPostcode = institutionPostcode;
    }

    @Column(name="institution_currencyCode", nullable=false, length=3)
    public String getCurrencyCode() {
        return this.currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode.toUpperCase();
    }

    @Column(name="institution_status", nullable=false)
    public Integer getInstitutionStatus() {
        return this.institutionStatus;
    }

    public void setInstitutionStatus(Integer institutionStatus) {
        this.institutionStatus = institutionStatus;
    }

    @Column(name="institution_country", nullable=false, length=100)
    public String getInstitutionCountry() {
        return this.institutionCountry;
    }

    public void setInstitutionCountry(String institutionCountry) {
        this.institutionCountry = institutionCountry;
    }

    @Column(name="institution_state", nullable=false, length=100)
    public String getInstitutionState() {
        return this.institutionState;
    }

    public void setInstitutionState(String institutionState) {
        this.institutionState = institutionState;
    }

    @Column(name="institution_city", nullable=false, length=100)
    public String getInstitutionCity() {
        return this.institutionCity;
    }

    public void setInstitutionCity(String institutionCity) {
        this.institutionCity = institutionCity;
    }

    @Column(name="institution_authorized_signature", nullable=true, length=255)
    public String getAuthorizedSignature() {
        return this.authorizedSignature;
    }

    public void setAuthorizedSignature(String authorizedSignature) {
        this.authorizedSignature = authorizedSignature;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="institution")
    @ForeignKey(name="institutionInClasses")
    @OrderBy(value="classId ASC")
    public Set<Class> getClasses() {
        return this.classes;
    }

    public void setClasses(Set<Class> classes) {
        this.classes = classes;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="institution")
    @ForeignKey(name="institutionInSections")
    public Set<Section> getSections() {
        return this.sections;
    }

    public void setSections(Set<Section> sections) {
        this.sections = sections;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="institution")
    @ForeignKey(name="institutionInModules")
    public Set<Module> getModules() {
        return this.modules;
    }

    public void setModules(Set<Module> modules) {
        this.modules = modules;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="institution")
    @ForeignKey(name="specialCategoriesInModule")
    public Set<SpecialCategory> getSpecialCategories() {
        return this.specialCategories;
    }

    public void setSpecialCategories(Set<SpecialCategory> specialCategories) {
        this.specialCategories = specialCategories;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="institution")
    @ForeignKey(name="institutionInStudents")
    public Set<Student> getStudents() {
        return this.students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="institution")
    @ForeignKey(name="institutionInAcademicYears")
    @OrderBy(value="academicYearId ASC")
    @JsonBackReference
    public Set<AcademicYear> getAcademicYears() {
        return this.academicYears;
    }

    public void setAcademicYears(Set<AcademicYear> academicYears) {
        this.academicYears = academicYears;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="institution", cascade={CascadeType.ALL})
    @ForeignKey(name="institutionInUserRoles")
    public Set<UserRole> getUserRoles() {
        return this.userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="institution", cascade={CascadeType.ALL})
    @ForeignKey(name="institutionInUsers")
    public Set<User> getUsers() {
        return this.users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Column(name="institution_alias_name", nullable=false, length=100)
    public String getInstitutionAliasName() {
        return this.institutionAliasName;
    }

    public void setInstitutionAliasName(String institutionAliasName) {
        this.institutionAliasName = institutionAliasName;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="institution", cascade={CascadeType.ALL})
    @ForeignKey(name="staffInInstitution")
    public Set<Staff> getStaffs() {
        return this.staffs;
    }

    public void setStaffs(Set<Staff> staffs) {
        this.staffs = staffs;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="institution")
    @ForeignKey(name="timeTableTemplateInInstitution")
    public Set<TimeTableTemplate> getTimeTableTemplates() {
        return this.timeTableTemplates;
    }

    public void setTimeTableTemplates(Set<TimeTableTemplate> timeTableTemplates) {
        this.timeTableTemplates = timeTableTemplates;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="institution")
    @ForeignKey(name="gradeSystemInInstitution")
    public Set<GradeSystem> getGradeSystem() {
        return this.gradeSystem;
    }

    public void setGradeSystem(Set<GradeSystem> gradeSystem) {
        this.gradeSystem = gradeSystem;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="institution")
    @ForeignKey(name="examTemplateInInstitution")
    public Set<ExamTemplate> getExamTemplates() {
        return this.examTemplates;
    }

    public void setExamTemplates(Set<ExamTemplate> examTemplates) {
        this.examTemplates = examTemplates;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="institution", cascade={CascadeType.REMOVE})
    @ForeignKey(name="staffDesignationInInstitution")
    public Set<StaffDesignation> getStaffDesignations() {
        return this.staffDesignations;
    }

    public void setStaffDesignations(Set<StaffDesignation> staffDesignations) {
        this.staffDesignations = staffDesignations;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="institution")
    @ForeignKey(name="institutionInFessTerms")
    @OrderBy(value="feesTermId")
    public Set<FeesTerm> getFeesTerms() {
        return this.feesTerms;
    }

    public void setFeesTerms(Set<FeesTerm> feesTerms) {
        this.feesTerms = feesTerms;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="institution")
    @ForeignKey(name="institutionInFeesItems")
    @OrderBy(value="fees_item_id ASC")
    public Set<FeesItem> getFeesItems() {
        return this.feesItems;
    }

    public void setFeesItems(Set<FeesItem> feesItems) {
        this.feesItems = feesItems;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="institution")
    @ForeignKey(name="institutionInFeesStructures")
    @OrderBy(value="fees_structure_id ASC")
    public Set<FeesStructure> getFeesStructures() {
        return this.feesStructures;
    }

    public void setFeesStructures(Set<FeesStructure> feesStructures) {
        this.feesStructures = feesStructures;
    }

    @OneToOne(fetch=FetchType.LAZY, mappedBy="institution")
    @JsonManagedReference
    public StaffAttendanceConfiguration getStaffAttendanceConfiguration() {
        return this.staffAttendanceConfiguration;
    }

    public void setStaffAttendanceConfiguration(StaffAttendanceConfiguration staffAttendanceConfiguration) {
        this.staffAttendanceConfiguration = staffAttendanceConfiguration;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="institution")
    @ForeignKey(name="studentAttendancesInInstitution")
    public Set<StudentAttendance> getStudentAttendances() {
        return this.studentAttendances;
    }

    public void setStudentAttendances(Set<StudentAttendance> studentAttendances) {
        this.studentAttendances = studentAttendances;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="institution")
    @ForeignKey(name="staffAttendanceInInstitution")
    public Set<StaffAttendance> getStaffAttendances() {
        return this.staffAttendances;
    }

    public void setStaffAttendances(Set<StaffAttendance> staffAttendances) {
        this.staffAttendances = staffAttendances;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="institution")
    @ForeignKey(name="communicationNotificationsInInstitution")
    public Set<CommunicationNotification> getCommunicationNotifications() {
        return this.communicationNotifications;
    }

    public void setCommunicationNotifications(Set<CommunicationNotification> communicationNotifications) {
        this.communicationNotifications = communicationNotifications;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="institution")
    @ForeignKey(name="communicationNotificationArchivesInInstitution")
    public Set<CommunicationNotificationArchive> getCommunicationNotificationArchives() {
        return this.communicationNotificationArchives;
    }

    public void setCommunicationNotificationArchives(Set<CommunicationNotificationArchive> communicationNotificationArchives) {
        this.communicationNotificationArchives = communicationNotificationArchives;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="institution")
    @ForeignKey(name="timeTableGeneratorInInstitution")
    public Set<TimeTableGenerator> getTimeTableGenerators() {
        return this.timeTableGenerators;
    }

    public void setTimeTableGenerators(Set<TimeTableGenerator> timeTableGenerators) {
        this.timeTableGenerators = timeTableGenerators;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="institution")
    @ForeignKey(name="poratlNotificationsInInstitution")
    public Set<PortalNotification> getPortalNotifications() {
        return this.portalNotifications;
    }

    public void setPortalNotifications(Set<PortalNotification> portalNotifications) {
        this.portalNotifications = portalNotifications;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="institution")
    @ForeignKey(name="communicationFeedBackAndOthersInInstitution")
    public Set<CommunicationFeedBackAndOthers> getCommunicationFeedBackAndOthers() {
        return this.communicationFeedBackAndOthers;
    }

    public void setCommunicationFeedBackAndOthers(Set<CommunicationFeedBackAndOthers> communicationFeedBackAndOthers) {
        this.communicationFeedBackAndOthers = communicationFeedBackAndOthers;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="institution")
    @ForeignKey(name="poratlMessagesInInstitution")
    public Set<PortalMessage> getPortalMessages() {
        return this.portalMessages;
    }

    public void setPortalMessages(Set<PortalMessage> portalMessages) {
        this.portalMessages = portalMessages;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="institution")
    @ForeignKey(name="communicationFeedBackAndOthersArchivesInInstitution")
    public Set<CommunicationFeedBackAndOthersArchive> getCommunicationFeedBackAndOthersArchives() {
        return this.communicationFeedBackAndOthersArchives;
    }

    public void setCommunicationFeedBackAndOthersArchives(Set<CommunicationFeedBackAndOthersArchive> communicationFeedBackAndOthersArchives) {
        this.communicationFeedBackAndOthersArchives = communicationFeedBackAndOthersArchives;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="institution")
    @ForeignKey(name="studentMarkInInstitution")
    public Set<StudentMark> getStudentMark() {
        return this.studentMark;
    }

    public void setStudentMark(Set<StudentMark> studentMark) {
        this.studentMark = studentMark;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="institution")
    @ForeignKey(name="portalReplyMessagesInInstitution")
    public Set<PortalReplyMessage> getPortalReplyMessages() {
        return this.portalReplyMessages;
    }

    public void setPortalReplyMessages(Set<PortalReplyMessage> portalReplyMessages) {
        this.portalReplyMessages = portalReplyMessages;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="institution")
    @ForeignKey(name="reportCardGeneratorInInstitution")
    public Set<ReportCardGenerator> getReportCardGenerator() {
        return this.reportCardGenerator;
    }

    public void setReportCardGenerator(Set<ReportCardGenerator> reportCardGenerator) {
        this.reportCardGenerator = reportCardGenerator;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="institution")
    @ForeignKey(name="portalTasksInInstitution")
    public Set<PortalTask> getPortalTasks() {
        return this.portalTasks;
    }

    public void setPortalTasks(Set<PortalTask> portalTasks) {
        this.portalTasks = portalTasks;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="institution")
    @ForeignKey(name="institutionInStudentReceipts")
    @OrderBy(value="student_receipt_id ASC")
    public Set<StudentReceipt> getStudentReceipts() {
        return this.studentReceipts;
    }

    public void setStudentReceipts(Set<StudentReceipt> studentReceipts) {
        this.studentReceipts = studentReceipts;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="institution")
    @ForeignKey(name="institutionInStudentInvoices")
    @OrderBy(value="student_invoice_id ASC")
    public Set<StudentInvoice> getStudentInvoices() {
        return this.studentInvoices;
    }

    public void setStudentInvoices(Set<StudentInvoice> studentInvoices) {
        this.studentInvoices = studentInvoices;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="institution")
    @ForeignKey(name="institutionInInstituteLedgerAccounts")
    @OrderBy(value="ledger_account_id ASC")
    public Set<InstituteLedgerAccount> getLedgerAccounts() {
        return this.ledgerAccounts;
    }

    public void setLedgerAccounts(Set<InstituteLedgerAccount> ledgerAccounts) {
        this.ledgerAccounts = ledgerAccounts;
    }

    @Column(name="collect_receipt_in_order", nullable=false)
    public boolean isCollectReceiptsInOrder() {
        return this.collectReceiptsInOrder;
    }

    public void setCollectReceiptsInOrder(boolean collectReceiptsInOrder) {
        this.collectReceiptsInOrder = collectReceiptsInOrder;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="institution")
    @ForeignKey(name="institutionInStudentIDCardGenerations")
    @OrderBy(value="studentIDCardGenerationId ASC")
    public Set<StudentIDCardGeneration> getStudentIDCardGenerations() {
        return this.studentIDCardGenerations;
    }

    public void setStudentIDCardGenerations(Set<StudentIDCardGeneration> studentIDCardGenerations) {
        this.studentIDCardGenerations = studentIDCardGenerations;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="institution")
    @ForeignKey(name="institutionInVisitorIDCardGenerations")
    @OrderBy(value="visitorIDCardGenerationId ASC")
    public Set<VisitorIDCardGeneration> getVisitorIDCardGenerations() {
        return this.visitorIDCardGenerations;
    }

    public void setVisitorIDCardGenerations(Set<VisitorIDCardGeneration> visitorIDCardGenerations) {
        this.visitorIDCardGenerations = visitorIDCardGenerations;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="institution")
    @ForeignKey(name="institutionInVisitorManagement")
    @OrderBy(value="visitorManagmentId ASC")
    public Set<VisitorManagement> getVisitorManagements() {
        return this.visitorManagements;
    }

    public void setVisitorManagements(Set<VisitorManagement> visitorManagements) {
        this.visitorManagements = visitorManagements;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="institution")
    @ForeignKey(name="institutionInTCRequisition")
    @OrderBy(value="transferCertificateRequisitionId ASC")
    public Set<TCRequisition> gettCRequisitions() {
        return this.tCRequisitions;
    }

    public void settCRequisitions(Set<TCRequisition> tCRequisitions) {
        this.tCRequisitions = tCRequisitions;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="institution")
    @ForeignKey(name="institutionInStudentMovementRequisition")
    @OrderBy(value="studentMovementRequisitionId ASC")
    public Set<StudentMovementRequisition> getStudentMovementRequisitions() {
        return this.studentMovementRequisitions;
    }

    public void setStudentMovementRequisitions(Set<StudentMovementRequisition> studentMovementRequisitions) {
        this.studentMovementRequisitions = studentMovementRequisitions;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="institution")
    @ForeignKey(name="housesInInstitution")
    public Set<Houses> getHouses() {
        return this.houses;
    }

    public void setHouses(Set<Houses> houses) {
        this.houses = houses;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="institution")
    @ForeignKey(name="institutionInInventoryPurchaseOrder")
    @OrderBy(value="purchase_order_id ASC")
    public Set<InventoryPurchaseOrder> getInventoryPurchaseOrders() {
        return this.inventoryPurchaseOrders;
    }

    public void setInventoryPurchaseOrders(Set<InventoryPurchaseOrder> inventoryPurchaseOrders) {
        this.inventoryPurchaseOrders = inventoryPurchaseOrders;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="institution")
    @ForeignKey(name="institutionInSickRoomVisitor")
    public Set<SickRoomVisitor> getSickRoomVisitors() {
        return this.sickRoomVisitors;
    }

    public void setSickRoomVisitors(Set<SickRoomVisitor> sickRoomVisitors) {
        this.sickRoomVisitors = sickRoomVisitors;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="institution")
    @ForeignKey(name="institutionInComplaintManagement")
    public Set<ComplaintManagement> getComplaintManagements() {
        return this.complaintManagements;
    }

    public void setComplaintManagements(Set<ComplaintManagement> complaintManagements) {
        this.complaintManagements = complaintManagements;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="institution")
    @ForeignKey(name="institutionInStudentAppraisal")
    public Set<StudentAppraisal> getStudentAppraisals() {
        return this.studentAppraisals;
    }

    public void setStudentAppraisals(Set<StudentAppraisal> studentAppraisals) {
        this.studentAppraisals = studentAppraisals;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="institution")
    @ForeignKey(name="institutionInStaffAppraisal")
    public Set<StaffAppraisal> getStaffAppraisals() {
        return this.staffAppraisals;
    }

    public void setStaffAppraisals(Set<StaffAppraisal> staffAppraisals) {
        this.staffAppraisals = staffAppraisals;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="institution")
    @ForeignKey(name="institutionInSubstituteTimeTableGenerator")
    public Set<SubstituteTimeTableGenerator> getSubstituteTimeTableGenerators() {
        return this.substituteTimeTableGenerators;
    }

    public void setSubstituteTimeTableGenerators(Set<SubstituteTimeTableGenerator> substituteTimeTableGenerators) {
        this.substituteTimeTableGenerators = substituteTimeTableGenerators;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="institution")
    @ForeignKey(name="documentTypesInInstitution")
    public Set<DocumentType> getDocumentTypes() {
        return this.documentTypes;
    }

    public void setDocumentTypes(Set<DocumentType> documentTypes) {
        this.documentTypes = documentTypes;
    }

    @Column(name="institution_code", nullable=false)
    public String getInstitutionCode() {
        return this.institutionCode;
    }

    public void setInstitutionCode(String institutionCode) {
        this.institutionCode = institutionCode;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="institution")
    @ForeignKey(name="institutionInStudentTransportIDCardGenerations")
    @OrderBy(value="studentTransportIDCardGenerationId ASC")
    public Set<StudentTransportIDCardGeneration> getStudentTransportIDCardGenerations() {
        return this.studentTransportIDCardGenerations;
    }

    public void setStudentTransportIDCardGenerations(Set<StudentTransportIDCardGeneration> studentTransportIDCardGenerations) {
        this.studentTransportIDCardGenerations = studentTransportIDCardGenerations;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="institution")
    @ForeignKey(name="institutionInStudentHostelIDCardGenerations")
    @OrderBy(value="studentHostelIDCardGenerationId ASC")
    public Set<StudentHostelIDCardGeneration> getStudentHostelIDCardGenerations() {
        return this.studentHostelIDCardGenerations;
    }

    public void setStudentHostelIDCardGenerations(Set<StudentHostelIDCardGeneration> studentHostelIDCardGenerations) {
        this.studentHostelIDCardGenerations = studentHostelIDCardGenerations;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="institution")
    @ForeignKey(name="institutionInStudentFeeRefundReceipts")
    @OrderBy(value="student_fee_refund_receipt_id ASC")
    public Set<StudentFeeRefundReceipt> getStudentFeeRefundReceipts() {
        return this.studentFeeRefundReceipts;
    }

    public void setStudentFeeRefundReceipts(Set<StudentFeeRefundReceipt> studentFeeRefundReceipts) {
        this.studentFeeRefundReceipts = studentFeeRefundReceipts;
    }
}
