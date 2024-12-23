/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import in.jdsoft.educationmanagement.school.model.BloodGroup;
import in.jdsoft.educationmanagement.school.model.Category;
import in.jdsoft.educationmanagement.school.model.ClassSection;
import in.jdsoft.educationmanagement.school.model.ClassSectionModuleStaff;
import in.jdsoft.educationmanagement.school.model.Document;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.SickRoomVisitor;
import in.jdsoft.educationmanagement.school.model.StaffAppraisal;
import in.jdsoft.educationmanagement.school.model.StaffAttendance;
import in.jdsoft.educationmanagement.school.model.StaffBankDetail;
import in.jdsoft.educationmanagement.school.model.StaffDesignation;
import in.jdsoft.educationmanagement.school.model.StaffExperienceDetail;
import in.jdsoft.educationmanagement.school.model.StaffLeaveRequisition;
import in.jdsoft.educationmanagement.school.model.StaffMovementRequisition;
import in.jdsoft.educationmanagement.school.model.StaffType;
import in.jdsoft.educationmanagement.school.model.SubstituteTimeTableGenerator;
import in.jdsoft.educationmanagement.school.model.User;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tbl_staff", uniqueConstraints={@UniqueConstraint(columnNames={"staff_code", "institution_id"}), @UniqueConstraint(columnNames={"staff_email"}), @UniqueConstraint(columnNames={"staff_access_no", "institution_id"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class Staff
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long staffId;
    private String staffCode;
    private String firstName;
    private String lastName;
    private String gender;
    private Date dateOfBirth;
    private String contact;
    private String email;
    private String accessNo;
    private String parentOrGuardianFirstName;
    private String parentOrGuardianLastName;
    private String staffAddressLine1;
    private String staffAddressLine2;
    private String country;
    private String state;
    private String city;
    private String postCode;
    private String staffPANNumber;
    private String staffPFNumber;
    private Date joinedDate;
    private String createdBy;
    private String modifiedBy;
    private Date createdDate;
    private Date modifiedDate;
    private Integer status;
    private BloodGroup bloodGroup;
    private User user;
    private User approver;
    private Institution institution;
    private StaffType staffType;
    private StaffDesignation staffDesignation;
    private Category category;
    private StaffBankDetail staffBankDetail;
    private Set<StaffExperienceDetail> staffExperienceDetails = new LinkedHashSet<StaffExperienceDetail>();
    private Set<StaffAttendance> staffAttendance = new LinkedHashSet<StaffAttendance>();
    private Set<ClassSectionModuleStaff> staffClassSectionModules = new LinkedHashSet<ClassSectionModuleStaff>();
    private Set<StaffLeaveRequisition> staffLeaveRequisitions = new LinkedHashSet<StaffLeaveRequisition>();
    private Set<StaffMovementRequisition> staffMovementRequisitions = new LinkedHashSet<StaffMovementRequisition>();
    private Set<ClassSection> classSections = new LinkedHashSet<ClassSection>();
    private Set<SickRoomVisitor> sickRoomVisitors = new LinkedHashSet<SickRoomVisitor>();
    private Set<StaffAppraisal> staffAppraisals = new LinkedHashSet<StaffAppraisal>();
    private Set<SubstituteTimeTableGenerator> substituteTimeTableGenerators = new LinkedHashSet<SubstituteTimeTableGenerator>();
    private Set<Document> documents = new LinkedHashSet<Document>();

    public Staff(String staffCode, String firstName, String lastName, String gender, Date dateOfBirth, String contact, String email, String accessNo, String parentOrGuardianFirstName, String parentOrGuardianLastName, String staffAddressLine1, String staffAddressLine2, String country, String state, String city, String postCode, String staffPANNumber, String staffPFNumber, Date joinedDate, String createdBy, Integer status, BloodGroup bloodGroup, User approver, User user, Institution institution, StaffType staffType, StaffDesignation staffDesignation, Category category) {
        this.staffCode = staffCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.contact = contact;
        this.email = email;
        this.accessNo = accessNo;
        this.parentOrGuardianFirstName = parentOrGuardianFirstName;
        this.parentOrGuardianLastName = parentOrGuardianLastName;
        this.staffAddressLine1 = staffAddressLine1;
        this.staffAddressLine2 = staffAddressLine2;
        this.country = country;
        this.state = state;
        this.city = city;
        this.postCode = postCode;
        this.staffPANNumber = staffPANNumber;
        this.staffPFNumber = staffPFNumber;
        this.joinedDate = joinedDate;
        this.createdBy = createdBy;
        this.modifiedBy = createdBy;
        this.createdDate = new Timestamp(Calendar.getInstance().getTime().getTime());
        this.status = status;
        this.bloodGroup = bloodGroup;
        this.approver = approver;
        this.user = user;
        this.institution = institution;
        this.staffType = staffType;
        this.staffDesignation = staffDesignation;
        this.category = category;
    }

    Staff() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="staff_id", nullable=false)
    public Long getStaffId() {
        return this.staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    @Column(name="staff_code", nullable=false, length=50)
    public String getStaffCode() {
        return this.staffCode;
    }

    public void setStaffCode(String staffCode) {
        this.staffCode = staffCode;
    }

    @Column(name="staff_first_name", nullable=false, length=100)
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name="staff_last_name", nullable=true, length=100)
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name="staff_gender", nullable=false, length=15)
    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Temporal(value=TemporalType.DATE)
    @Column(name="staff_date_of_birth", nullable=false, length=10)
    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Column(name="staff_contact", nullable=false, length=20)
    public String getContact() {
        return this.contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Column(name="staff_email", nullable=false, length=100)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name="staff_access_no", nullable=false, length=50)
    public String getAccessNo() {
        return this.accessNo;
    }

    public void setAccessNo(String accessNo) {
        this.accessNo = accessNo;
    }

    @Column(name="parent_guardian_first_name", nullable=false, length=100)
    public String getParentOrGuardianFirstName() {
        return this.parentOrGuardianFirstName;
    }

    public void setParentOrGuardianFirstName(String parentOrGuardianFirstName) {
        this.parentOrGuardianFirstName = parentOrGuardianFirstName;
    }

    @Column(name="parent_guardian_last_name", nullable=true, length=100)
    public String getParentOrGuardianLastName() {
        return this.parentOrGuardianLastName;
    }

    public void setParentOrGuardianLastName(String parentOrGuardianLastName) {
        this.parentOrGuardianLastName = parentOrGuardianLastName;
    }

    @Column(name="staff_address_line_one", nullable=false, length=255)
    public String getStaffAddressLine1() {
        return this.staffAddressLine1;
    }

    public void setStaffAddressLine1(String staffAddressLine1) {
        this.staffAddressLine1 = staffAddressLine1;
    }

    @Column(name="staff_address_line_two", nullable=false, length=255)
    public String getStaffAddressLine2() {
        return this.staffAddressLine2;
    }

    public void setStaffAddressLine2(String staffAddressLine2) {
        this.staffAddressLine2 = staffAddressLine2;
    }

    @Column(name="country", nullable=false, length=100)
    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Column(name="state", nullable=false, length=100)
    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Column(name="city", nullable=false, length=100)
    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name="post_code", nullable=false, length=10)
    public String getPostCode() {
        return this.postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    @Column(name="staff_pan_no", nullable=true, length=50)
    public String getStaffPANNumber() {
        return this.staffPANNumber;
    }

    public void setStaffPANNumber(String staffPANNumber) {
        this.staffPANNumber = staffPANNumber;
    }

    @Column(name="staff_pf_no", nullable=true, length=50)
    public String getStaffPFNumber() {
        return this.staffPFNumber;
    }

    public void setStaffPFNumber(String staffPFNumber) {
        this.staffPFNumber = staffPFNumber;
    }

    @Temporal(value=TemporalType.DATE)
    @Column(name="date_of_joining", nullable=true)
    public Date getJoinedDate() {
        return this.joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    @Column(name="staff_created_by", nullable=false, length=100)
    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Column(name="staff_last_modified_by", nullable=false, length=100)
    public String getModifiedBy() {
        return this.modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @Temporal(value=TemporalType.TIMESTAMP)
    @Column(name="staff_created_date", nullable=false)
    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Temporal(value=TemporalType.TIMESTAMP)
    @Column(name="staff_last_modified_date", nullable=false, columnDefinition="timestamp")
    public Date getModifiedDate() {
        return this.modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Column(name="staff_status", nullable=false, length=20)
    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="blood_group_id", nullable=true)
    @ForeignKey(name="bloodGroupInStaff")
    public BloodGroup getBloodGroup() {
        return this.bloodGroup;
    }

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    @OneToOne(fetch=FetchType.LAZY, cascade={CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.ALL})
    @JoinColumn(name="user_id", nullable=false)
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@staff")
    @ForeignKey(name="userInStaff")
    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="approver_id", nullable=false, referencedColumnName="user_id")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@staffs")
    @JsonIdentityReference(alwaysAsId=true)
    @ForeignKey(name="approverInStaff")
    public User getApprover() {
        return this.approver;
    }

    public void setApprover(User approver) {
        this.approver = approver;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="institution_id", nullable=false)
    @ForeignKey(name="institutionInStaff")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@staffs")
    @JsonIdentityReference(alwaysAsId=true)
    public Institution getInstitution() {
        return this.institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="staff_type_id", nullable=false)
    @ForeignKey(name="staffTypeInStaff")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@staffs")
    @JsonIdentityReference(alwaysAsId=true)
    public StaffType getStaffType() {
        return this.staffType;
    }

    public void setStaffType(StaffType staffType) {
        this.staffType = staffType;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="staff_designation_id", nullable=false)
    @ForeignKey(name="staffDesignationInStaff")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@staffs")
    @JsonIdentityReference(alwaysAsId=true)
    public StaffDesignation getStaffDesignation() {
        return this.staffDesignation;
    }

    public void setStaffDesignation(StaffDesignation staffDesignation) {
        this.staffDesignation = staffDesignation;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="category_id", nullable=false)
    @ForeignKey(name="categoryInStaff")
    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @OneToOne(fetch=FetchType.LAZY, cascade={CascadeType.REMOVE, CascadeType.ALL}, mappedBy="staff")
    @ForeignKey(name="staffBankDetailInStaff")
    @JsonManagedReference
    public StaffBankDetail getStaffBankDetail() {
        return this.staffBankDetail;
    }

    public void setStaffBankDetail(StaffBankDetail staffBankDetail) {
        this.staffBankDetail = staffBankDetail;
    }

    @OneToMany(fetch=FetchType.LAZY, cascade={CascadeType.ALL, CascadeType.REMOVE}, mappedBy="staff")
    @ForeignKey(name="staffExperienceDetailInStaff")
    @OrderBy(value="staffExperienceDetailId ASC")
    public Set<StaffExperienceDetail> getStaffExperienceDetails() {
        return this.staffExperienceDetails;
    }

    public void setStaffExperienceDetails(Set<StaffExperienceDetail> staffExperienceDetails) {
        this.staffExperienceDetails = staffExperienceDetails;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="staff")
    @ForeignKey(name="staffAttendanceInStaff")
    public Set<StaffAttendance> getStaffAttendance() {
        return this.staffAttendance;
    }

    public void setStaffAttendance(Set<StaffAttendance> staffAttendance) {
        this.staffAttendance = staffAttendance;
    }

    @OneToMany(fetch=FetchType.LAZY, cascade={CascadeType.ALL}, mappedBy="staff")
    @ForeignKey(name="classSectionModuleStaffsInStaff")
    @OrderBy(value="classSectionModuleStaffId ASC")
    public Set<ClassSectionModuleStaff> getStaffClassSectionModules() {
        return this.staffClassSectionModules;
    }

    public void setStaffClassSectionModules(Set<ClassSectionModuleStaff> staffClassSectionModules) {
        this.staffClassSectionModules = staffClassSectionModules;
    }

    @OneToMany(fetch=FetchType.LAZY, cascade={CascadeType.ALL}, mappedBy="staff")
    @ForeignKey(name="staffLeaveRequisitionsInStaff")
    @OrderBy(value="staffLeaveRequisitionId ASC")
    public Set<StaffLeaveRequisition> getStaffLeaveRequisitions() {
        return this.staffLeaveRequisitions;
    }

    public void setStaffLeaveRequisitions(Set<StaffLeaveRequisition> staffLeaveRequisitions) {
        this.staffLeaveRequisitions = staffLeaveRequisitions;
    }

    @OneToMany(fetch=FetchType.LAZY, cascade={CascadeType.ALL}, mappedBy="staff")
    @ForeignKey(name="staffMovementRequisitionsInStaff")
    @OrderBy(value="staffMovementRequisitionId ASC")
    public Set<StaffMovementRequisition> getStaffMovementRequisitions() {
        return this.staffMovementRequisitions;
    }

    public void setStaffMovementRequisitions(Set<StaffMovementRequisition> staffMovementRequisitions) {
        this.staffMovementRequisitions = staffMovementRequisitions;
    }

    @OneToMany(fetch=FetchType.LAZY, cascade={CascadeType.ALL}, mappedBy="classStaff")
    @ForeignKey(name="classSectionsInStaff")
    @OrderBy(value="classSectionId ASC")
    public Set<ClassSection> getClassSections() {
        return this.classSections;
    }

    public void setClassSections(Set<ClassSection> classSections) {
        this.classSections = classSections;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="staff")
    @ForeignKey(name="staffInSickRoomVisitor")
    public Set<SickRoomVisitor> getSickRoomVisitors() {
        return this.sickRoomVisitors;
    }

    public void setSickRoomVisitors(Set<SickRoomVisitor> sickRoomVisitors) {
        this.sickRoomVisitors = sickRoomVisitors;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="staff")
    @ForeignKey(name="staffInStaffAppraisal")
    public Set<StaffAppraisal> getStaffAppraisals() {
        return this.staffAppraisals;
    }

    public void setStaffAppraisals(Set<StaffAppraisal> staffAppraisals) {
        this.staffAppraisals = staffAppraisals;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="staff")
    @ForeignKey(name="staffInSubstituteTimeTableGenerator")
    public Set<SubstituteTimeTableGenerator> getSubstituteTimeTableGenerators() {
        return this.substituteTimeTableGenerators;
    }

    public void setSubstituteTimeTableGenerators(Set<SubstituteTimeTableGenerator> substituteTimeTableGenerators) {
        this.substituteTimeTableGenerators = substituteTimeTableGenerators;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="staff", cascade={CascadeType.ALL})
    @OrderBy(value="documentId ASC")
    public Set<Document> getDocuments() {
        return this.documents;
    }

    public void setDocuments(Set<Document> documents) {
        this.documents = documents;
    }
}
