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
 *  com.fasterxml.jackson.annotation.JsonManagedReference
 *  com.fasterxml.jackson.annotation.ObjectIdGenerators$IntSequenceGenerator
 *  javax.persistence.CascadeType
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
 *  javax.persistence.Temporal
 *  javax.persistence.TemporalType
 *  javax.persistence.UniqueConstraint
 *  org.hibernate.annotations.ForeignKey
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.Admission;
import in.jdsoft.educationmanagement.school.model.BloodGroup;
import in.jdsoft.educationmanagement.school.model.Category;
import in.jdsoft.educationmanagement.school.model.Class;
import in.jdsoft.educationmanagement.school.model.Document;
import in.jdsoft.educationmanagement.school.model.Houses;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.ReportCardGenerator;
import in.jdsoft.educationmanagement.school.model.Section;
import in.jdsoft.educationmanagement.school.model.SickRoomVisitor;
import in.jdsoft.educationmanagement.school.model.SpecialCategory;
import in.jdsoft.educationmanagement.school.model.StaffModuleAttendance;
import in.jdsoft.educationmanagement.school.model.StudentAppraisal;
import in.jdsoft.educationmanagement.school.model.StudentAttendance;
import in.jdsoft.educationmanagement.school.model.StudentFeeRefundReceipt;
import in.jdsoft.educationmanagement.school.model.StudentIDCardGeneration;
import in.jdsoft.educationmanagement.school.model.StudentInvoice;
import in.jdsoft.educationmanagement.school.model.StudentLeaveRequisition;
import in.jdsoft.educationmanagement.school.model.StudentMark;
import in.jdsoft.educationmanagement.school.model.StudentMovementRequisition;
import in.jdsoft.educationmanagement.school.model.StudentReceipt;
import in.jdsoft.educationmanagement.school.model.StudentStatus;
import in.jdsoft.educationmanagement.school.model.StudentTransportIDCardGeneration;
import in.jdsoft.educationmanagement.school.model.TCRequisition;
import in.jdsoft.educationmanagement.school.model.User;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name="tbl_student", uniqueConstraints={@UniqueConstraint(columnNames={"student_class_id", "section_id", "roll_no"}), @UniqueConstraint(columnNames={"institution_id", "admission_no"}), @UniqueConstraint(columnNames={"email"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class Student
implements Serializable {
    private static final long serialVersionUID = 1L;
    private AcademicYear joinedAcademicYear;
    private Category category;
    private StudentStatus studentStatus;
    private BloodGroup bloodGroup;
    private User user;
    private User parentUser;
    private Institution institution;
    private Class studentClass;
    private Class joinedClass;
    private Section section;
    private Admission admission;
    private Houses houses;
    private Long studentId;
    private String firstName;
    private String lastName;
    private String parentGuardianFirstName;
    private String parentGuardianLastName;
    private String parentGuardianEmail;
    private String sex;
    private Date birthDate;
    private Long aadharCardNumber;
    private Double fathersIncome;
    private Double mothersIncome;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String country;
    private String postcode;
    private String email;
    private String contact;
    private String parentContact;
    private String passportNumber;
    private Date joinedDate;
    private Date createdDate;
    private Date modifiedDate;
    private String scannedSignature;
    private String accessNo;
    private String createdBy;
    private String modifiedBy;
    private String admissionNo;
    private String rollNo;
    private Set<SpecialCategory> specialCategories = new LinkedHashSet<SpecialCategory>();
    private Set<Document> documents = new LinkedHashSet<Document>();
    private Set<StudentAttendance> studentAttendances = new LinkedHashSet<StudentAttendance>();
    private Set<StaffModuleAttendance> staffModuleAttendances = new LinkedHashSet<StaffModuleAttendance>();
    private Set<StudentInvoice> invoices = new HashSet<StudentInvoice>(0);
    private Set<StudentReceipt> studentReceipts = new HashSet<StudentReceipt>(0);
    private Set<StudentFeeRefundReceipt> studentFeeRefundReceipts = new HashSet<StudentFeeRefundReceipt>(0);
    private Set<StudentMark> studentMarks = new LinkedHashSet<StudentMark>(0);
    private Set<ReportCardGenerator> reportCardGenerator = new LinkedHashSet<ReportCardGenerator>(0);
    private Set<StudentIDCardGeneration> studentIDCardGenerations = new LinkedHashSet<StudentIDCardGeneration>(0);
    private Set<StudentTransportIDCardGeneration> studentTransportIDCardGenerations = new LinkedHashSet<StudentTransportIDCardGeneration>(0);
    private Set<StudentLeaveRequisition> studentLeaveRequistions = new LinkedHashSet<StudentLeaveRequisition>();
    private Set<TCRequisition> tCRequisitions = new LinkedHashSet<TCRequisition>(0);
    private Set<StudentMovementRequisition> studentMovementRequisitions = new LinkedHashSet<StudentMovementRequisition>(0);
    private Set<SickRoomVisitor> sickRoomVisitors = new LinkedHashSet<SickRoomVisitor>(0);
    private Set<StudentAppraisal> StudentAppraisals = new LinkedHashSet<StudentAppraisal>(0);

    Student() {
    }

    public Student(Houses house, AcademicYear joinedAcademicYear, Class studentClass, Section section, Class joinedClass, Category category, Set<SpecialCategory> specialCategories, StudentStatus studentStatus, String firstName, String lastName, String parentGuardianFirstName, String parentGuardianLastName, String parentGuardianEmail, String sex, Date birthDate, Double fathersIncome, Double mothersIncome, String addressLine1, String addressLine2, String city, String state, String country, String postcode, String email, String contact, String passportNumber, Date joinedDate, String scannedSignature, BloodGroup bloodGroup, String accessNo, String admissionNo, String rollNo, String parentContact, Institution institution, String createdBy, String modifiedBy, Long aadharCardNumber) {
        this.studentClass = joinedClass;
        this.rollNo = rollNo;
        this.admissionNo = admissionNo;
        this.joinedClass = joinedClass;
        this.section = section;
        this.category = category;
        this.specialCategories = specialCategories;
        this.studentStatus = studentStatus;
        this.firstName = firstName;
        this.lastName = lastName;
        this.parentGuardianFirstName = parentGuardianFirstName;
        this.parentGuardianLastName = parentGuardianLastName;
        this.sex = sex;
        this.birthDate = birthDate;
        this.fathersIncome = fathersIncome;
        this.mothersIncome = mothersIncome;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postcode = postcode;
        this.email = email;
        this.contact = contact;
        this.passportNumber = passportNumber;
        this.joinedDate = joinedDate;
        this.createdDate = new Timestamp(Calendar.getInstance().getTime().getTime());
        this.scannedSignature = scannedSignature;
        this.bloodGroup = bloodGroup;
        this.accessNo = accessNo;
        this.parentGuardianEmail = parentGuardianEmail;
        this.createdBy = createdBy;
        this.institution = institution;
        this.joinedAcademicYear = joinedAcademicYear;
        this.parentContact = parentContact;
        this.modifiedBy = modifiedBy;
        this.houses = house;
        this.aadharCardNumber = aadharCardNumber;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="student_id", nullable=false)
    public Long getStudentId() {
        return this.studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    @Column(name="first_name", nullable=false, length=100)
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name="last_name", nullable=true, length=100)
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name="parent_guardian_first_name", nullable=false, length=100)
    public String getParentGuardianFirstName() {
        return this.parentGuardianFirstName;
    }

    public void setParentGuardianFirstName(String parentGuardianFirstName) {
        this.parentGuardianFirstName = parentGuardianFirstName;
    }

    @Column(name="parent_guardian_last_name", nullable=true, length=100)
    public String getParentGuardianLastName() {
        return this.parentGuardianLastName;
    }

    public void setParentGuardianLastName(String parentGuardianLastName) {
        this.parentGuardianLastName = parentGuardianLastName;
    }

    @Column(name="sex", nullable=false, length=7)
    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Temporal(value=TemporalType.DATE)
    @Column(name="birth_date", nullable=false, length=10)
    public Date getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Column(name="address_line_1", nullable=true)
    public String getAddressLine1() {
        return this.addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    @Column(name="address_line_2", nullable=true)
    public String getAddressLine2() {
        return this.addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    @Column(name="postcode", nullable=true, length=10)
    public String getPostcode() {
        return this.postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @Column(name="email", nullable=false, length=100)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name="contact", nullable=true, length=20)
    public String getContact() {
        return this.contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Column(name="passport_number", nullable=true, length=100)
    public String getPassportNumber() {
        return this.passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    @Temporal(value=TemporalType.DATE)
    @Column(name="joined_date", nullable=false, length=10)
    public Date getJoinedDate() {
        return this.joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    @Temporal(value=TemporalType.TIMESTAMP)
    @Column(name="created_date", nullable=false, length=19)
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

    @Column(name="scanned_signature", nullable=true, length=255)
    public String getScannedSignature() {
        return this.scannedSignature;
    }

    public void setScannedSignature(String scannedSignature) {
        this.scannedSignature = scannedSignature;
    }

    @Column(name="fathers_income", nullable=true)
    public Double getFathersIncome() {
        return this.fathersIncome;
    }

    public void setFathersIncome(Double fathersIncome) {
        this.fathersIncome = fathersIncome;
    }

    @Column(name="mothers_income", nullable=true)
    public Double getMothersIncome() {
        return this.mothersIncome;
    }

    public void setMothersIncome(Double mothersIncome) {
        this.mothersIncome = mothersIncome;
    }

    @Column(name="student_city", nullable=false, length=50)
    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name="student_state", nullable=false, length=50)
    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Column(name="student_country", nullable=false, length=50)
    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Column(name="access_no", nullable=true, length=50)
    public String getAccessNo() {
        return this.accessNo;
    }

    public void setAccessNo(String accessNo) {
        this.accessNo = accessNo;
    }

    @Column(name="parent_guardian_email", nullable=true, length=100)
    public String getParentGuardianEmail() {
        return this.parentGuardianEmail;
    }

    public void setParentGuardianEmail(String parentGuardianEmail) {
        this.parentGuardianEmail = parentGuardianEmail;
    }

    @Column(name="created_by", nullable=false, length=50)
    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @OneToOne(fetch=FetchType.LAZY, cascade={CascadeType.REMOVE})
    @JoinColumn(name="user_id", nullable=true)
    @ForeignKey(name="studentInUser")
    @JsonManagedReference
    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @OneToOne(fetch=FetchType.LAZY, cascade={CascadeType.ALL})
    @JoinColumn(name="parent_id", nullable=true, referencedColumnName="user_id")
    @ForeignKey(name="parentInStudent")
    public User getParentUser() {
        return this.parentUser;
    }

    public void setParentUser(User parentUser) {
        this.parentUser = parentUser;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="student_status_id", nullable=false)
    @ForeignKey(name="studentInStudentStatus")
    public StudentStatus getStudentStatus() {
        return this.studentStatus;
    }

    public void setStudentStatus(StudentStatus studentStatus) {
        this.studentStatus = studentStatus;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="category_id", nullable=true)
    @ForeignKey(name="studentInCategory")
    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="blood_group_id", nullable=true)
    @ForeignKey(name="studentInBloodGroup")
    public BloodGroup getBloodGroup() {
        return this.bloodGroup;
    }

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="institution_id", nullable=false)
    @ForeignKey(name="studentInInstitution")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@students")
    @JsonIdentityReference(alwaysAsId=true)
    public Institution getInstitution() {
        return this.institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="student_class_id", nullable=false, referencedColumnName="class_id")
    @ForeignKey(name="studentInClass")
    public Class getStudentClass() {
        return this.studentClass;
    }

    public void setStudentClass(Class studentClass) {
        this.studentClass = studentClass;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="section_id", nullable=false)
    @ForeignKey(name="studentInSection")
    public Section getSection() {
        return this.section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="student")
    @ForeignKey(name="studentInStudentInvoices")
    @JsonBackReference
    @OrderBy(value="student_invoice_id ASC")
    public Set<StudentInvoice> getInvoices() {
        return this.invoices;
    }

    public void setInvoices(Set<StudentInvoice> invoices) {
        this.invoices = invoices;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="academic_year_id", nullable=false)
    @ForeignKey(name="studentInAcademicYear")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@joinedStudents")
    @JsonIdentityReference(alwaysAsId=true)
    public AcademicYear getJoinedAcademicYear() {
        return this.joinedAcademicYear;
    }

    public void setJoinedAcademicYear(AcademicYear joinedAcademicYear) {
        this.joinedAcademicYear = joinedAcademicYear;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="joined_class_id", nullable=false, referencedColumnName="class_id")
    @ForeignKey(name="joinedStudentInClass")
    public Class getJoinedClass() {
        return this.joinedClass;
    }

    public void setJoinedClass(Class joinedClass) {
        this.joinedClass = joinedClass;
    }

    @Column(name="admission_no", nullable=false, length=50)
    public String getAdmissionNo() {
        return this.admissionNo;
    }

    public void setAdmissionNo(String admissionNo) {
        this.admissionNo = admissionNo;
    }

    @Column(name="roll_no", nullable=true, length=50)
    public String getRollNo() {
        return this.rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="student")
    @ForeignKey(name="studentInStudentReceipts")
    @OrderBy(value="student_receipt_id ASC")
    @JsonBackReference
    public Set<StudentReceipt> getStudentReceipts() {
        return this.studentReceipts;
    }

    public void setStudentReceipts(Set<StudentReceipt> studentReceipts) {
        this.studentReceipts = studentReceipts;
    }

    @Column(name="parent_contact", nullable=true, length=20)
    public String getParentContact() {
        return this.parentContact;
    }

    public void setParentContact(String parentContact) {
        this.parentContact = parentContact;
    }

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="tbl_student_special_categories", joinColumns={@JoinColumn(name="student_id", updatable=false)}, inverseJoinColumns={@JoinColumn(name="special_category_id", updatable=true)})
    @ForeignKey(name="studentsInSpecialCategory")
    public Set<SpecialCategory> getSpecialCategories() {
        return this.specialCategories;
    }

    public void setSpecialCategories(Set<SpecialCategory> specialCategories) {
        this.specialCategories = specialCategories;
    }

    @Column(name="modified_by", nullable=false, length=100)
    public String getModifiedBy() {
        return this.modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="student")
    @ForeignKey(name="staffModuleAteendanceInStudent")
    public Set<StaffModuleAttendance> getStaffModuleAttendances() {
        return this.staffModuleAttendances;
    }

    public void setStaffModuleAttendances(Set<StaffModuleAttendance> staffModuleAttendances) {
        this.staffModuleAttendances = staffModuleAttendances;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="student")
    @ForeignKey(name="studentMarksInStudent")
    public Set<StudentMark> getStudentMarks() {
        return this.studentMarks;
    }

    public void setStudentMarks(Set<StudentMark> studentMarks) {
        this.studentMarks = studentMarks;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="student")
    @ForeignKey(name="reportCardGeneratorInStudent")
    public Set<ReportCardGenerator> getReportCardGenerator() {
        return this.reportCardGenerator;
    }

    public void setReportCardGenerator(Set<ReportCardGenerator> reportCardGenerator) {
        this.reportCardGenerator = reportCardGenerator;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="student")
    @ForeignKey(name="studentAttendancesInStudent")
    public Set<StudentAttendance> getStudentAttendances() {
        return this.studentAttendances;
    }

    public void setStudentAttendances(Set<StudentAttendance> studentAttendances) {
        this.studentAttendances = studentAttendances;
    }

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="admission_id", nullable=true)
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@student")
    @JsonIdentityReference(alwaysAsId=true)
    public Admission getAdmission() {
        return this.admission;
    }

    public void setAdmission(Admission admission) {
        this.admission = admission;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="student")
    @ForeignKey(name="studentIDCardGenerationInStudent")
    @OrderBy(value="studentIDCardGenerationId ASC")
    public Set<StudentIDCardGeneration> getStudentIDCardGenerations() {
        return this.studentIDCardGenerations;
    }

    public void setStudentIDCardGenerations(Set<StudentIDCardGeneration> studentIDCardGenerations) {
        this.studentIDCardGenerations = studentIDCardGenerations;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="student")
    @ForeignKey(name="studentInStudentLeaveRequisition")
    public Set<StudentLeaveRequisition> getStudentLeaveRequistions() {
        return this.studentLeaveRequistions;
    }

    public void setStudentLeaveRequistions(Set<StudentLeaveRequisition> studentLeaveRequistions) {
        this.studentLeaveRequistions = studentLeaveRequistions;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="student")
    @ForeignKey(name="studentInTCRequisition")
    @OrderBy(value="transferCertificateRequisitionId ASC")
    public Set<TCRequisition> gettCRequisitions() {
        return this.tCRequisitions;
    }

    public void settCRequisitions(Set<TCRequisition> tCRequisitions) {
        this.tCRequisitions = tCRequisitions;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="student")
    @ForeignKey(name="studentInStudentMovementRequisition")
    public Set<StudentMovementRequisition> getStudentMovementRequisitions() {
        return this.studentMovementRequisitions;
    }

    public void setStudentMovementRequisitions(Set<StudentMovementRequisition> studentMovementRequisitions) {
        this.studentMovementRequisitions = studentMovementRequisitions;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="house_id", nullable=false)
    @ForeignKey(name="studentInHouse")
    public Houses getHouses() {
        return this.houses;
    }

    public void setHouses(Houses houses) {
        this.houses = houses;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="student")
    @ForeignKey(name="studentInSickRoomVisitor")
    public Set<SickRoomVisitor> getSickRoomVisitors() {
        return this.sickRoomVisitors;
    }

    public void setSickRoomVisitors(Set<SickRoomVisitor> sickRoomVisitors) {
        this.sickRoomVisitors = sickRoomVisitors;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="student")
    @ForeignKey(name="studentInStudentAppraisal")
    public Set<StudentAppraisal> getStudentAppraisals() {
        return this.StudentAppraisals;
    }

    public void setStudentAppraisals(Set<StudentAppraisal> studentAppraisals) {
        this.StudentAppraisals = studentAppraisals;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="student", cascade={CascadeType.ALL})
    @OrderBy(value="documentId ASC")
    public Set<Document> getDocuments() {
        return this.documents;
    }

    public void setDocuments(Set<Document> documents) {
        this.documents = documents;
    }

    @Column(name="aadhar_card_number", nullable=true, length=100)
    public Long getAadharCardNumber() {
        return this.aadharCardNumber;
    }

    public void setAadharCardNumber(Long aadharCardNumber) {
        this.aadharCardNumber = aadharCardNumber;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="student")
    @ForeignKey(name="studentTransportIDCardGenerationInStudent")
    @OrderBy(value="studentTransportIDCardGenerationId ASC")
    public Set<StudentTransportIDCardGeneration> getStudentTransportIDCardGenerations() {
        return this.studentTransportIDCardGenerations;
    }

    public void setStudentTransportIDCardGenerations(Set<StudentTransportIDCardGeneration> studentTransportIDCardGenerations) {
        this.studentTransportIDCardGenerations = studentTransportIDCardGenerations;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="student")
    @ForeignKey(name="studentInStudentFeeRefundReceipts")
    @OrderBy(value="student_fee_refund_receipt_id ASC")
    @JsonBackReference
    public Set<StudentFeeRefundReceipt> getStudentFeeRefundReceipts() {
        return this.studentFeeRefundReceipts;
    }

    public void setStudentFeeRefundReceipts(Set<StudentFeeRefundReceipt> studentFeeRefundReceipts) {
        this.studentFeeRefundReceipts = studentFeeRefundReceipts;
    }
}
