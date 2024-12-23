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
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.BloodGroup;
import in.jdsoft.educationmanagement.school.model.Class;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Section;
import in.jdsoft.educationmanagement.school.model.Student;
import in.jdsoft.educationmanagement.school.model.StudentStatus;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tbl_student_id_card_generation", uniqueConstraints={@UniqueConstraint(columnNames={"student_class_id", "section_id", "academic_year_id", "admission_no"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class StudentIDCardGeneration
implements Serializable {
    private static final long serialVersionUID = 1L;
    private AcademicYear academicYear;
    private StudentStatus studentStatus;
    private BloodGroup bloodGroup;
    private Institution institution;
    private Class studentClass;
    private Section section;
    private Student student;
    private Long studentIDCardGenerationId;
    private String firstName;
    private String lastName;
    private String parentGuardianFirstName;
    private String parentGuardianLastName;
    private String parentGuardianEmail;
    private String sex;
    private Date birthDate;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String country;
    private String postcode;
    private String email;
    private String contact;
    private String parentContact;
    private Date createdDate;
    private Date modifiedDate;
    private String createdBy;
    private String modifiedBy;
    private String admissionNo;
    private String rollNo;
    private String institutionAddressLine1;
    private String institutionAddressLine2;
    private String institutionCity;
    private String institutionState;
    private String institutionCountry;
    private String institutionPostcode;
    private String institutionEmail;
    private String institutionContact;
    private String authorizedSignature;
    private String institutionName;
    private String institutionLogo;
    private String barCode;
    private String barCodeImage;

    public StudentIDCardGeneration(Student student, AcademicYear academicYear, StudentStatus studentStatus, BloodGroup bloodGroup, Institution institution, Class studentClass, Section section, String firstName, String lastName, String parentGuardianFirstName, String parentGuardianLastName, String parentGuardianEmail, String sex, Date birthDate, String addressLine1, String addressLine2, String city, String state, String country, String postcode, String email, String contact, String parentContact, String createdBy, String modifiedBy, String admissionNo, String rollNo, String institutionAddressLine1, String institutionAddressLine2, String institutionCity, String institutionState, String institutionCountry, String institutionPostcode, String institutionEmail, String institutionContact, String authorizedSignature, String institutionName, String institutionLogo) {
        this.student = student;
        this.academicYear = academicYear;
        this.studentStatus = studentStatus;
        this.bloodGroup = bloodGroup;
        this.institution = institution;
        this.studentClass = studentClass;
        this.section = section;
        this.firstName = firstName;
        this.lastName = lastName;
        this.parentGuardianFirstName = parentGuardianFirstName;
        this.parentGuardianLastName = parentGuardianLastName;
        this.parentGuardianEmail = parentGuardianEmail;
        this.sex = sex;
        this.birthDate = birthDate;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postcode = postcode;
        this.email = email;
        this.contact = contact;
        this.parentContact = parentContact;
        this.createdDate = new Timestamp(Calendar.getInstance().getTime().getTime());
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
        this.admissionNo = admissionNo;
        this.rollNo = rollNo;
        this.institutionAddressLine1 = institutionAddressLine1;
        this.institutionAddressLine2 = institutionAddressLine2;
        this.institutionCity = institutionCity;
        this.institutionState = institutionState;
        this.institutionCountry = institutionCountry;
        this.institutionPostcode = institutionPostcode;
        this.institutionEmail = institutionEmail;
        this.institutionContact = institutionContact;
        this.authorizedSignature = authorizedSignature;
        this.institutionName = institutionName;
        this.institutionLogo = institutionLogo;
    }

    StudentIDCardGeneration() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="student_id_card_generation_id", nullable=false)
    public Long getStudentIDCardGenerationId() {
        return this.studentIDCardGenerationId;
    }

    public void setStudentIDCardGenerationId(Long studentIDCardGenerationId) {
        this.studentIDCardGenerationId = studentIDCardGenerationId;
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

    @Column(name="authorized_signature", nullable=true, length=100)
    public String getAuthorizedSignature() {
        return this.authorizedSignature;
    }

    public void setAuthorizedSignature(String authorizedSignature) {
        this.authorizedSignature = authorizedSignature;
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

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="student_status_id", nullable=false)
    @ForeignKey(name="studentIDCardGenerationInStudentStatus")
    public StudentStatus getStudentStatus() {
        return this.studentStatus;
    }

    public void setStudentStatus(StudentStatus studentStatus) {
        this.studentStatus = studentStatus;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="blood_group_id", nullable=true)
    @ForeignKey(name="studentIDCardGenerationInBloodGroup")
    public BloodGroup getBloodGroup() {
        return this.bloodGroup;
    }

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="institution_id", nullable=false)
    @ForeignKey(name="studentIDCardGenerationInInstitution")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@studentIDCardGenerations")
    @JsonIdentityReference(alwaysAsId=true)
    public Institution getInstitution() {
        return this.institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="student_class_id", nullable=false, referencedColumnName="class_id")
    @ForeignKey(name="studentIDCardGenerationInClass")
    public Class getStudentClass() {
        return this.studentClass;
    }

    public void setStudentClass(Class studentClass) {
        this.studentClass = studentClass;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="section_id", nullable=false)
    @ForeignKey(name="studentIDCardGenerationInSection")
    public Section getSection() {
        return this.section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="academic_year_id", nullable=false)
    @ForeignKey(name="studentIDCardGenerationInAcademicYear")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@studentIDCardGenerations")
    @JsonIdentityReference(alwaysAsId=true)
    public AcademicYear getAcademicYear() {
        return this.academicYear;
    }

    public void setAcademicYear(AcademicYear academicYear) {
        this.academicYear = academicYear;
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

    @Column(name="parent_contact", nullable=true, length=20)
    public String getParentContact() {
        return this.parentContact;
    }

    public void setParentContact(String parentContact) {
        this.parentContact = parentContact;
    }

    @Column(name="modified_by", nullable=false, length=100)
    public String getModifiedBy() {
        return this.modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @Column(name="instituition_addressline1", nullable=false, length=255)
    public String getInstitutionAddressLine1() {
        return this.institutionAddressLine1;
    }

    public void setInstitutionAddressLine1(String institutionAddressLine1) {
        this.institutionAddressLine1 = institutionAddressLine1;
    }

    @Column(name="instituition_addressline2", nullable=false, length=255)
    public String getInstitutionAddressLine2() {
        return this.institutionAddressLine2;
    }

    public void setInstitutionAddressLine2(String institutionAddressLine2) {
        this.institutionAddressLine2 = institutionAddressLine2;
    }

    @Column(name="instituition_city", nullable=false, length=255)
    public String getInstitutionCity() {
        return this.institutionCity;
    }

    public void setInstitutionCity(String institutionCity) {
        this.institutionCity = institutionCity;
    }

    @Column(name="instituition_state", nullable=false, length=255)
    public String getInstitutionState() {
        return this.institutionState;
    }

    public void setInstitutionState(String institutionState) {
        this.institutionState = institutionState;
    }

    @Column(name="instituition_country", nullable=false, length=255)
    public String getInstitutionCountry() {
        return this.institutionCountry;
    }

    public void setInstitutionCountry(String institutionCountry) {
        this.institutionCountry = institutionCountry;
    }

    @Column(name="instituition_postcode", nullable=false, length=255)
    public String getInstitutionPostcode() {
        return this.institutionPostcode;
    }

    public void setInstitutionPostcode(String institutionPostcode) {
        this.institutionPostcode = institutionPostcode;
    }

    @Column(name="instituition_email", nullable=false, length=255)
    public String getInstitutionEmail() {
        return this.institutionEmail;
    }

    public void setInstitutionEmail(String institutionEmail) {
        this.institutionEmail = institutionEmail;
    }

    @Column(name="instituition_contact", nullable=true, length=255)
    public String getInstitutionContact() {
        return this.institutionContact;
    }

    public void setInstitutionContact(String institutionContact) {
        this.institutionContact = institutionContact;
    }

    @Column(name="instituition_name", nullable=false, length=255)
    public String getInstitutionName() {
        return this.institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    @Column(name="instituition_logo", nullable=true, length=255)
    public String getInstitutionLogo() {
        return this.institutionLogo;
    }

    public void setInstitutionLogo(String institutionLogo) {
        this.institutionLogo = institutionLogo;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="student_id", nullable=false)
    @ForeignKey(name="studentIDCardGenerationInStudent")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@studentIDCardGenerations")
    @JsonIdentityReference(alwaysAsId=true)
    public Student getStudent() {
        return this.student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Column(name="bar_Code", nullable=false, length=255)
    public String getBarCode() {
        return this.barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    @Column(name="bar_Code_Image", nullable=false, length=255)
    public String getBarCodeImage() {
        return this.barCodeImage;
    }

    public void setBarCodeImage(String barCodeImage) {
        this.barCodeImage = barCodeImage;
    }
}
