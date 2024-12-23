/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonIdentityInfo
 *  com.fasterxml.jackson.annotation.JsonIgnoreProperties
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
 *  org.apache.commons.lang.WordUtils
 *  org.hibernate.annotations.ForeignKey
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import in.jdsoft.educationmanagement.school.model.AdmissionConfig;
import in.jdsoft.educationmanagement.school.model.AdmissionDocument;
import in.jdsoft.educationmanagement.school.model.AdmissionEducationLevelDetails;
import in.jdsoft.educationmanagement.school.model.AdmissionEducationLevelSubjects;
import in.jdsoft.educationmanagement.school.model.AdmissionFeesPaymentDetails;
import in.jdsoft.educationmanagement.school.model.AdmissionStatus;
import in.jdsoft.educationmanagement.school.model.Category;
import in.jdsoft.educationmanagement.school.model.Class;
import in.jdsoft.educationmanagement.school.model.EducationLevel;
import in.jdsoft.educationmanagement.school.model.HearedUs;
import in.jdsoft.educationmanagement.school.model.Religion;
import in.jdsoft.educationmanagement.school.model.SpecialCategory;
import in.jdsoft.educationmanagement.school.model.Sponser;
import in.jdsoft.educationmanagement.school.model.Student;
import in.jdsoft.educationmanagement.school.model.User;
import java.io.Serializable;
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
import org.apache.commons.lang.WordUtils;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tbl_admission")
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
public class Admission
implements Serializable {
    private static final long serialVersionUID = 1L;
    private AdmissionConfig admissionConfig;
    private Class classz;
    private AdmissionStatus admissionStatus;
    private Religion religion;
    private Sponser sponser;
    private Category category;
    private SpecialCategory specialCategory;
    private HearedUs hearedUs;
    private User user;
    private EducationLevel educationLevel;
    private Long admissionId;
    private String admissionCode;
    private String candidateFirstName;
    private String candidateLastName;
    private String fatherFirstName;
    private String fatherLastName;
    private String fatherOccupation;
    private String motherFirstName;
    private String motherLastName;
    private String motherOccupation;
    private double fatherIncome;
    private double motherIncome;
    private String guardianFirstName;
    private String guardianLastName;
    private String passportNo;
    private String studiedHereBefore;
    private String previousStudentIdOfThisInstitute;
    private String disability;
    private String referenceOneFirstName;
    private String referenceOneLastName;
    private String referenceOneEmail;
    private String referenceOneMobile;
    private String referenceOneAddressLineOne;
    private String referenceOneAddressLineTwo;
    private String referenceOneCountry;
    private String referenceOnePincode;
    private String referenceTwoFirstName;
    private String referenceTwoLastName;
    private String referenceTwoEmail;
    private String referenceTwoMobile;
    private String referenceTwoAddressLineOne;
    private String referenceTwoAddressLineTwo;
    private String referenceTwoCountry;
    private String referenceTwoPincode;
    private String scannedSignaturePath;
    private String candidateGender;
    private Date dateOfBirth;
    private String candidateEmail;
    private String candidateContact;
    private String passportIssuedCountry;
    private String candidateAddressLineOne;
    private String candidateAddressLineTwo;
    private String candidateCountry;
    private String candidateState;
    private String candidateCity;
    private String candidatePostcode;
    private String candidatePhotoPath;
    private int submitStatus;
    private Date createdDate;
    private Date modifiedDate;
    private Double admissionRank;
    private Double total;
    private Set<AdmissionDocument> admissionDocuments = new HashSet<AdmissionDocument>(0);
    private Set<AdmissionEducationLevelDetails> admissionAcademicsDetails = new HashSet<AdmissionEducationLevelDetails>(0);
    private AdmissionFeesPaymentDetails admissionFeesPaymentDetails = new AdmissionFeesPaymentDetails();
    private Set<AdmissionEducationLevelSubjects> admissionEducationLevelSubjects = new HashSet<AdmissionEducationLevelSubjects>(0);
    private Student student;

    public Admission() {
    }

    public Admission(AdmissionConfig admissionConfig, Class classz, AdmissionStatus admissionStatus, Religion religion, Sponser sponser, Category category, SpecialCategory specialCategory, HearedUs hearedUs, String admissionCode, String candidateFirstName, String candidateLastName, String fatherFirstName, String fatherLastName, String fatherOccupation, String motherFirstName, String motherLastName, String motherOccupation, double fatherIncome, double motherIncome, String guardianFirstName, String guardianLastName, String passportNo, String studiedHereBefore, String previousStudentIdOfThisInstitute, String disability, String referenceOneFirstName, String referenceOneLastName, String referenceOneEmail, String referenceOneMobile, String referenceOneAddressLineOne, String referenceOneAddressLineTwo, String referenceOneCountry, String referenceOnePincode, String referenceTwoFirstName, String referenceTwoLastName, String referenceTwoEmail, String referenceTwoMobile, String referenceTwoAddressLineOne, String referenceTwoAddressLineTwo, String referenceTwoCountry, String referenceTwoPincode, String scannedSignaturePath, String candidateGender, Date dateOfBirth, String candidateEmail, String candidateContact, String passportIssuedCountry, String candidateAddressLineOne, String candidateAddressLineTwo, String candidateCountry, String candidateState, String candidateCity, String candidatePostcode, String candidatePhotoPath, int submitStatus, Double admissionRank, User user, Set<AdmissionDocument> admissionDocuments, Set<AdmissionEducationLevelDetails> admissionAcademicsDetails, AdmissionFeesPaymentDetails admissionFeesPaymentDetails, Set<AdmissionEducationLevelSubjects> admissionEducationLevelSubjects) {
        this.admissionConfig = admissionConfig;
        this.classz = classz;
        this.admissionStatus = admissionStatus;
        this.religion = religion;
        this.sponser = sponser;
        this.category = category;
        this.specialCategory = specialCategory;
        this.hearedUs = hearedUs;
        this.admissionCode = admissionCode.toUpperCase();
        this.candidateFirstName = WordUtils.capitalize((String)candidateFirstName);
        this.candidateLastName = WordUtils.capitalize((String)candidateLastName);
        this.fatherFirstName = WordUtils.capitalize((String)fatherFirstName);
        this.fatherLastName = WordUtils.capitalize((String)fatherLastName);
        this.fatherOccupation = WordUtils.capitalize((String)fatherOccupation);
        this.motherFirstName = WordUtils.capitalize((String)motherFirstName);
        this.motherLastName = WordUtils.capitalize((String)motherLastName);
        this.motherOccupation = WordUtils.capitalize((String)motherOccupation);
        this.fatherIncome = fatherIncome;
        this.motherIncome = motherIncome;
        this.guardianFirstName = WordUtils.capitalize((String)guardianFirstName);
        this.guardianLastName = WordUtils.capitalize((String)guardianLastName);
        this.passportNo = passportNo;
        this.studiedHereBefore = WordUtils.capitalize((String)studiedHereBefore);
        this.previousStudentIdOfThisInstitute = previousStudentIdOfThisInstitute;
        this.disability = WordUtils.capitalize((String)disability);
        this.referenceOneFirstName = WordUtils.capitalize((String)referenceOneFirstName);
        this.referenceOneLastName = WordUtils.capitalize((String)referenceOneLastName);
        this.referenceOneEmail = referenceOneEmail.toLowerCase();
        this.referenceOneMobile = referenceOneMobile;
        this.referenceOneAddressLineOne = WordUtils.capitalize((String)referenceOneAddressLineOne);
        this.referenceOneAddressLineTwo = WordUtils.capitalize((String)referenceOneAddressLineTwo);
        this.referenceOneCountry = referenceOneCountry;
        this.referenceOnePincode = referenceOnePincode;
        this.referenceTwoFirstName = WordUtils.capitalize((String)referenceTwoFirstName);
        this.referenceTwoLastName = WordUtils.capitalize((String)referenceTwoLastName);
        this.referenceTwoEmail = referenceTwoEmail.toLowerCase();
        this.referenceTwoMobile = referenceTwoMobile;
        this.referenceTwoAddressLineOne = WordUtils.capitalize((String)referenceTwoAddressLineOne);
        this.referenceTwoAddressLineTwo = WordUtils.capitalize((String)referenceTwoAddressLineTwo);
        this.referenceTwoCountry = referenceTwoCountry;
        this.referenceTwoPincode = referenceTwoPincode;
        this.scannedSignaturePath = scannedSignaturePath;
        this.candidateGender = WordUtils.capitalize((String)candidateGender);
        this.dateOfBirth = dateOfBirth;
        this.candidateEmail = candidateEmail.toLowerCase();
        this.candidateContact = candidateContact;
        this.passportIssuedCountry = passportIssuedCountry;
        this.candidateAddressLineOne = WordUtils.capitalize((String)candidateAddressLineOne);
        this.candidateAddressLineTwo = WordUtils.capitalize((String)candidateAddressLineTwo);
        this.candidateCountry = candidateCountry;
        this.candidateState = candidateState;
        this.candidateCity = candidateCity;
        this.candidatePostcode = candidatePostcode;
        this.candidatePhotoPath = candidatePhotoPath;
        this.submitStatus = submitStatus;
        this.createdDate = new Date(Calendar.getInstance().getTime().getTime());
        this.admissionDocuments = admissionDocuments;
        this.admissionAcademicsDetails = admissionAcademicsDetails;
        this.admissionFeesPaymentDetails = admissionFeesPaymentDetails;
        this.admissionEducationLevelSubjects = admissionEducationLevelSubjects;
        this.user = user;
        this.admissionRank = admissionRank;
    }

    public Admission(AdmissionConfig admissionConfig, Class classz, AdmissionStatus admissionStatus, Religion religion, Sponser sponser, Category category, SpecialCategory specialCategory, HearedUs hearedUs, String admissionCode, String candidateFirstName, String candidateLastName, String fatherFirstName, String fatherLastName, String fatherOccupation, String motherFirstName, String motherLastName, String motherOccupation, double fatherIncome, double motherIncome, String guardianFirstName, String guardianLastName, String passportNo, String studiedHereBefore, String previousStudentIdOfThisInstitute, String disability, String referenceOneFirstName, String referenceOneLastName, String referenceOneEmail, String referenceOneMobile, String referenceOneAddressLineOne, String referenceOneAddressLineTwo, String referenceOneCountry, String referenceOnePincode, String referenceTwoFirstName, String referenceTwoLastName, String referenceTwoEmail, String referenceTwoMobile, String referenceTwoAddressLineOne, String referenceTwoAddressLineTwo, String referenceTwoCountry, String referenceTwoPincode, String scannedSignaturePath, String candidateGender, Date dateOfBirth, String candidateEmail, String candidateContact, String passportIssuedCountry, String candidateAddressLineOne, String candidateAddressLineTwo, String candidateCountry, String candidateState, String candidateCity, String candidatePostcode, String candidatePhotoPath, int submitStatus, Double admissionRank, User user, EducationLevel educationLevel) {
        this.admissionConfig = admissionConfig;
        this.classz = classz;
        this.admissionStatus = admissionStatus;
        this.religion = religion;
        this.sponser = sponser;
        this.category = category;
        this.specialCategory = specialCategory;
        this.hearedUs = hearedUs;
        this.admissionCode = admissionCode.toUpperCase();
        this.candidateFirstName = WordUtils.capitalize((String)candidateFirstName);
        this.candidateLastName = WordUtils.capitalize((String)candidateLastName);
        this.fatherFirstName = WordUtils.capitalize((String)fatherFirstName);
        this.fatherLastName = WordUtils.capitalize((String)fatherLastName);
        this.fatherOccupation = WordUtils.capitalize((String)fatherOccupation);
        this.motherFirstName = WordUtils.capitalize((String)motherFirstName);
        this.motherLastName = WordUtils.capitalize((String)motherLastName);
        this.motherOccupation = WordUtils.capitalize((String)motherOccupation);
        this.fatherIncome = fatherIncome;
        this.motherIncome = motherIncome;
        this.guardianFirstName = WordUtils.capitalize((String)guardianFirstName);
        this.guardianLastName = WordUtils.capitalize((String)guardianLastName);
        this.passportNo = passportNo;
        this.studiedHereBefore = WordUtils.capitalize((String)studiedHereBefore);
        this.previousStudentIdOfThisInstitute = previousStudentIdOfThisInstitute;
        this.disability = WordUtils.capitalize((String)disability);
        this.referenceOneFirstName = WordUtils.capitalize((String)referenceOneFirstName);
        this.referenceOneLastName = WordUtils.capitalize((String)referenceOneLastName);
        this.referenceOneEmail = referenceOneEmail.toLowerCase();
        this.referenceOneMobile = referenceOneMobile;
        this.referenceOneAddressLineOne = WordUtils.capitalize((String)referenceOneAddressLineOne);
        this.referenceOneAddressLineTwo = WordUtils.capitalize((String)referenceOneAddressLineTwo);
        this.referenceOneCountry = referenceOneCountry;
        this.referenceOnePincode = referenceOnePincode;
        this.referenceTwoFirstName = WordUtils.capitalize((String)referenceTwoFirstName);
        this.referenceTwoLastName = WordUtils.capitalize((String)referenceTwoLastName);
        this.referenceTwoEmail = referenceTwoEmail.toLowerCase();
        this.referenceTwoMobile = referenceTwoMobile;
        this.referenceTwoAddressLineOne = WordUtils.capitalize((String)referenceTwoAddressLineOne);
        this.referenceTwoAddressLineTwo = WordUtils.capitalize((String)referenceTwoAddressLineTwo);
        this.referenceTwoCountry = referenceTwoCountry;
        this.referenceTwoPincode = referenceTwoPincode;
        this.scannedSignaturePath = scannedSignaturePath;
        this.candidateGender = WordUtils.capitalize((String)candidateGender);
        this.dateOfBirth = dateOfBirth;
        this.candidateEmail = candidateEmail.toLowerCase();
        this.candidateContact = candidateContact;
        this.passportIssuedCountry = passportIssuedCountry;
        this.candidateAddressLineOne = WordUtils.capitalize((String)candidateAddressLineOne);
        this.candidateAddressLineTwo = WordUtils.capitalize((String)candidateAddressLineTwo);
        this.candidateCountry = candidateCountry;
        this.candidateState = candidateState;
        this.candidateCity = candidateCity;
        this.candidatePostcode = candidatePostcode;
        this.candidatePhotoPath = candidatePhotoPath;
        this.submitStatus = submitStatus;
        this.createdDate = new Date(Calendar.getInstance().getTime().getTime());
        this.user = user;
        this.admissionRank = admissionRank;
        this.educationLevel = educationLevel;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="admission_id", nullable=false)
    public Long getAdmissionId() {
        return this.admissionId;
    }

    public void setAdmissionId(Long admissionId) {
        this.admissionId = admissionId;
    }

    @Column(name="admission_code", nullable=false, length=50)
    public String getAdmissionCode() {
        return this.admissionCode;
    }

    public void setAdmissionCode(String admissionCode) {
        this.admissionCode = admissionCode.toUpperCase();
    }

    @Column(name="candidate_first_name", nullable=true, length=50)
    public String getCandidateFirstName() {
        return this.candidateFirstName;
    }

    public void setCandidateFirstName(String candidateFirstName) {
        this.candidateFirstName = WordUtils.capitalize((String)candidateFirstName);
    }

    @Column(name="candidate_last_name", nullable=true, length=50)
    public String getCandidateLastName() {
        return this.candidateLastName;
    }

    public void setCandidateLastName(String candidateLastName) {
        this.candidateLastName = WordUtils.capitalize((String)candidateLastName);
    }

    @Column(name="candidate_father_first_name", nullable=true, length=50)
    public String getFatherFirstName() {
        return this.fatherFirstName;
    }

    public void setFatherFirstName(String fatherFirstName) {
        this.fatherFirstName = WordUtils.capitalize((String)fatherFirstName);
    }

    @Column(name="candidate_father_last_name", nullable=true, length=50)
    public String getFatherLastName() {
        return this.fatherLastName;
    }

    public void setFatherLastName(String fatherLastName) {
        this.fatherLastName = WordUtils.capitalize((String)fatherLastName);
    }

    @Column(name="candidate_father_occupation", nullable=true, length=100)
    public String getFatherOccupation() {
        return this.fatherOccupation;
    }

    public void setFatherOccupation(String fatherOccupation) {
        this.fatherOccupation = WordUtils.capitalize((String)fatherOccupation);
    }

    @Column(name="candidate_mother_first_name", nullable=true, length=50)
    public String getMotherFirstName() {
        return this.motherFirstName;
    }

    public void setMotherFirstName(String motherFirstName) {
        this.motherFirstName = WordUtils.capitalize((String)motherFirstName);
    }

    @Column(name="candidate_mother_last_name", nullable=true, length=50)
    public String getMotherLastName() {
        return this.motherLastName;
    }

    public void setMotherLastName(String motherLastName) {
        this.motherLastName = WordUtils.capitalize((String)motherLastName);
    }

    @Column(name="candidate_mother_occupation", nullable=true, length=50)
    public String getMotherOccupation() {
        return this.motherOccupation;
    }

    public void setMotherOccupation(String motherOccupation) {
        this.motherOccupation = WordUtils.capitalize((String)motherOccupation);
    }

    @Column(name="candidate_guardian_first_name", nullable=true, length=50)
    public String getGuardianFirstName() {
        return this.guardianFirstName;
    }

    public void setGuardianFirstName(String guardianFirstName) {
        this.guardianFirstName = WordUtils.capitalize((String)guardianFirstName);
    }

    @Column(name="candidate_guardian_last_name", nullable=true, length=50)
    public String getGuardianLastName() {
        return this.guardianLastName;
    }

    public void setGuardianLastName(String guardianLastName) {
        this.guardianLastName = WordUtils.capitalize((String)guardianLastName);
    }

    @Column(name="candidate_passport_no", nullable=true, length=50)
    public String getPassportNo() {
        return this.passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    @Column(name="studied_here_before", nullable=true, length=3)
    public String getStudiedHereBefore() {
        return this.studiedHereBefore;
    }

    public void setStudiedHereBefore(String studiedHereBefore) {
        this.studiedHereBefore = WordUtils.capitalize((String)studiedHereBefore);
    }

    @Column(name="previous_student_id", nullable=true, length=50)
    public String getPreviousStudentIdOfThisInstitute() {
        return this.previousStudentIdOfThisInstitute;
    }

    public void setPreviousStudentIdOfThisInstitute(String previousStudentIdOfThisInstitute) {
        this.previousStudentIdOfThisInstitute = previousStudentIdOfThisInstitute;
    }

    @Column(name="disability", nullable=true, length=3)
    public String getDisability() {
        return this.disability;
    }

    public void setDisability(String disability) {
        this.disability = WordUtils.capitalize((String)disability);
    }

    @Column(name="referenceOne_first_name", nullable=true, length=50)
    public String getReferenceOneFirstName() {
        return this.referenceOneFirstName;
    }

    public void setReferenceOneFirstName(String referenceOneFirstName) {
        this.referenceOneFirstName = WordUtils.capitalize((String)referenceOneFirstName);
    }

    @Column(name="referenceOne_last_name", nullable=true, length=50)
    public String getReferenceOneLastName() {
        return this.referenceOneLastName;
    }

    public void setReferenceOneLastName(String referenceOneLastName) {
        this.referenceOneLastName = WordUtils.capitalize((String)referenceOneLastName);
    }

    @Column(name="referenceOne_email", nullable=true, length=50)
    public String getReferenceOneEmail() {
        return this.referenceOneEmail;
    }

    public void setReferenceOneEmail(String referenceOneEmail) {
        this.referenceOneEmail = referenceOneEmail.toLowerCase();
    }

    @Column(name="referenceOne_mobile", nullable=true, length=20)
    public String getReferenceOneMobile() {
        return this.referenceOneMobile;
    }

    public void setReferenceOneMobile(String referenceOneMobile) {
        this.referenceOneMobile = referenceOneMobile;
    }

    @Column(name="referenceOne_addressLine_one", nullable=true, length=100)
    public String getReferenceOneAddressLineOne() {
        return this.referenceOneAddressLineOne;
    }

    public void setReferenceOneAddressLineOne(String referenceOneAddressLineOne) {
        this.referenceOneAddressLineOne = WordUtils.capitalize((String)referenceOneAddressLineOne);
    }

    @Column(name="referenceOne_addressLine_two", nullable=true, length=100)
    public String getReferenceOneAddressLineTwo() {
        return this.referenceOneAddressLineTwo;
    }

    public void setReferenceOneAddressLineTwo(String referenceOneAddressLineTwo) {
        this.referenceOneAddressLineTwo = WordUtils.capitalize((String)referenceOneAddressLineTwo);
    }

    @Column(name="referenceOne_pincode", nullable=true, length=10)
    public String getReferenceOnePincode() {
        return this.referenceOnePincode;
    }

    public void setReferenceOnePincode(String referenceOnePincode) {
        this.referenceOnePincode = referenceOnePincode;
    }

    @Column(name="referenceTwo_first_name", nullable=true, length=50)
    public String getReferenceTwoFirstName() {
        return this.referenceTwoFirstName;
    }

    public void setReferenceTwoFirstName(String referenceTwoFirstName) {
        this.referenceTwoFirstName = WordUtils.capitalize((String)referenceTwoFirstName);
    }

    @Column(name="referenceTwo_last_name", nullable=true, length=50)
    public String getReferenceTwoLastName() {
        return this.referenceTwoLastName;
    }

    public void setReferenceTwoLastName(String referenceTwoLastName) {
        this.referenceTwoLastName = WordUtils.capitalize((String)referenceTwoLastName);
    }

    @Column(name="referenceTwo_email", nullable=true, length=100)
    public String getReferenceTwoEmail() {
        return this.referenceTwoEmail;
    }

    public void setReferenceTwoEmail(String referenceTwoEmail) {
        this.referenceTwoEmail = referenceTwoEmail.toLowerCase();
    }

    @Column(name="referenceTwo_mobile", nullable=true, length=20)
    public String getReferenceTwoMobile() {
        return this.referenceTwoMobile;
    }

    public void setReferenceTwoMobile(String referenceTwoMobile) {
        this.referenceTwoMobile = referenceTwoMobile;
    }

    @Column(name="referenceTwo_addressLine_one", nullable=true, length=100)
    public String getReferenceTwoAddressLineOne() {
        return this.referenceTwoAddressLineOne;
    }

    public void setReferenceTwoAddressLineOne(String referenceTwoAddressLineOne) {
        this.referenceTwoAddressLineOne = WordUtils.capitalize((String)referenceTwoAddressLineOne);
    }

    @Column(name="referenceTwo_addressLine_two", nullable=true, length=100)
    public String getReferenceTwoAddressLineTwo() {
        return this.referenceTwoAddressLineTwo;
    }

    public void setReferenceTwoAddressLineTwo(String referenceTwoAddressLineTwo) {
        this.referenceTwoAddressLineTwo = WordUtils.capitalize((String)referenceTwoAddressLineTwo);
    }

    @Column(name="referenceTwo_pincode", nullable=true, length=10)
    public String getReferenceTwoPincode() {
        return this.referenceTwoPincode;
    }

    public void setReferenceTwoPincode(String referenceTwoPincode) {
        this.referenceTwoPincode = referenceTwoPincode;
    }

    @Column(name="scanned_signature_path", nullable=true, length=255)
    public String getScannedSignaturePath() {
        return this.scannedSignaturePath;
    }

    public void setScannedSignaturePath(String scannedSignaturePath) {
        this.scannedSignaturePath = scannedSignaturePath;
    }

    @Column(name="candidate_gender", nullable=true, length=7)
    public String getCandidateGender() {
        return this.candidateGender;
    }

    public void setCandidateGender(String candidateGender) {
        this.candidateGender = WordUtils.capitalize((String)candidateGender);
    }

    @Column(name="candidate_email", nullable=true, length=50)
    public String getCandidateEmail() {
        return this.candidateEmail;
    }

    public void setCandidateEmail(String candidateEmail) {
        this.candidateEmail = candidateEmail.toLowerCase();
    }

    @Column(name="candidate_contact_no", nullable=true, length=20)
    public String getCandidateContactNo() {
        return this.candidateContact;
    }

    public void setCandidateContactNo(String candidateContact) {
        this.candidateContact = candidateContact;
    }

    @Column(name="candidate_addressLine_one", nullable=true, length=100)
    public String getCandidateAddressLineOne() {
        return this.candidateAddressLineOne;
    }

    public void setCandidateAddressLineOne(String candidateAddressLineOne) {
        this.candidateAddressLineOne = WordUtils.capitalize((String)candidateAddressLineOne);
    }

    @Column(name="candidate_addressLine_two", nullable=true, length=100)
    public String getCandidateAddressLineTwo() {
        return this.candidateAddressLineTwo;
    }

    public void setCandidateAddressLineTwo(String candidateAddressLineTwo) {
        this.candidateAddressLineTwo = WordUtils.capitalize((String)candidateAddressLineTwo);
    }

    @Column(name="candidate_postcode", nullable=true, length=10)
    public String getCandidatePostcode() {
        return this.candidatePostcode;
    }

    public void setCandidatePostcode(String candidatePostcode) {
        this.candidatePostcode = candidatePostcode;
    }

    @Column(name="candidate_photo_path", nullable=true, length=255)
    public String getCandidatePhotoPath() {
        return this.candidatePhotoPath;
    }

    public void setCandidatePhotoPath(String candidatePhotoPath) {
        this.candidatePhotoPath = candidatePhotoPath;
    }

    @Column(name="referenceOne_country", nullable=true)
    public String getReferenceOneCountry() {
        return this.referenceOneCountry;
    }

    public void setReferenceOneCountry(String referenceOneCountry) {
        this.referenceOneCountry = referenceOneCountry;
    }

    @Column(name="referenceTwo_country", nullable=true)
    public String getReferenceTwoCountry() {
        return this.referenceTwoCountry;
    }

    public void setReferenceTwoCountry(String referenceTwoCountry) {
        this.referenceTwoCountry = referenceTwoCountry;
    }

    @Column(name="passport_issued_country", nullable=true)
    public String getPassportIssuedCountry() {
        return this.passportIssuedCountry;
    }

    public void setPassportIssuedCountry(String passportIssuedCountry) {
        this.passportIssuedCountry = passportIssuedCountry;
    }

    @Column(name="candidate_country", nullable=true)
    public String getCandidateCountry() {
        return this.candidateCountry;
    }

    public void setCandidateCountry(String candidateCountry) {
        this.candidateCountry = candidateCountry;
    }

    @Column(name="candidate_state", nullable=true)
    public String getCandidateState() {
        return this.candidateState;
    }

    public void setCandidateState(String candidateState) {
        this.candidateState = candidateState;
    }

    @Column(name="candidate_city", nullable=true)
    public String getCandidateCity() {
        return this.candidateCity;
    }

    public void setCandidateCity(String candidateCity) {
        this.candidateCity = candidateCity;
    }

    @Column(name="submit_status", nullable=true)
    public int getSubmitStatus() {
        return this.submitStatus;
    }

    public void setSubmitStatus(int submitStatus) {
        this.submitStatus = submitStatus;
    }

    @Column(name="father_income", nullable=true)
    public double getFatherIncome() {
        return this.fatherIncome;
    }

    public void setFatherIncome(double fatherIncome) {
        this.fatherIncome = fatherIncome;
    }

    @Column(name="mother_income", nullable=true)
    public double getMotherIncome() {
        return this.motherIncome;
    }

    public void setMotherIncome(double motherIncome) {
        this.motherIncome = motherIncome;
    }

    @Column(name="admission_rank", nullable=true)
    public Double getAdmissionRank() {
        return this.admissionRank;
    }

    public void setAdmissionRank(Double admissionRank) {
        this.admissionRank = admissionRank;
    }

    @Temporal(value=TemporalType.DATE)
    @Column(name="date_of_birth", nullable=true)
    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="admission_config_id", nullable=false)
    public AdmissionConfig getAdmissionConfig() {
        return this.admissionConfig;
    }

    public void setAdmissionConfig(AdmissionConfig admissionConfig) {
        this.admissionConfig = admissionConfig;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="admission_status_id", nullable=true)
    public AdmissionStatus getAdmissionStatus() {
        return this.admissionStatus;
    }

    public void setAdmissionStatus(AdmissionStatus admissionStatus) {
        this.admissionStatus = admissionStatus;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="class_id", nullable=true)
    @ForeignKey(name="admissionInClass")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@admissions")
    public Class getClassz() {
        return this.classz;
    }

    public void setClassz(Class classz) {
        this.classz = classz;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="religion_id", nullable=true)
    public Religion getReligion() {
        return this.religion;
    }

    public void setReligion(Religion religion) {
        this.religion = religion;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="sponser_id", nullable=true)
    public Sponser getSponser() {
        return this.sponser;
    }

    public void setSponser(Sponser sponser) {
        this.sponser = sponser;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id", nullable=true)
    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="category_id", nullable=true)
    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="special_category_id", nullable=true)
    public SpecialCategory getSpecialCategory() {
        return this.specialCategory;
    }

    public void setSpecialCategory(SpecialCategory specialCategory) {
        this.specialCategory = specialCategory;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="hearedus_id", nullable=true)
    public HearedUs getHearedUs() {
        return this.hearedUs;
    }

    public void setHearedUs(HearedUs hearedUs) {
        this.hearedUs = hearedUs;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="admission", cascade={CascadeType.ALL})
    @OrderBy(value="admissionDocumentId ASC")
    public Set<AdmissionDocument> getAdmissionDocuments() {
        return this.admissionDocuments;
    }

    public void setAdmissionDocuments(Set<AdmissionDocument> admissionDocuments) {
        this.admissionDocuments = admissionDocuments;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="admission", cascade={CascadeType.ALL})
    @OrderBy(value="admissionAcademicDetailId ASC")
    public Set<AdmissionEducationLevelDetails> getAdmissionAcademicsDetails() {
        return this.admissionAcademicsDetails;
    }

    public void setAdmissionAcademicsDetails(Set<AdmissionEducationLevelDetails> admissionAcademicsDetails) {
        this.admissionAcademicsDetails = admissionAcademicsDetails;
    }

    @OneToOne(fetch=FetchType.LAZY, mappedBy="admission")
    public AdmissionFeesPaymentDetails getAdmissionFeesPaymentDetails() {
        return this.admissionFeesPaymentDetails;
    }

    public void setAdmissionFeesPaymentDetails(AdmissionFeesPaymentDetails admissionFeesPaymentDetails) {
        this.admissionFeesPaymentDetails = admissionFeesPaymentDetails;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="admission", cascade={CascadeType.ALL})
    @OrderBy(value="admissionEducationLevelSubjectId ASC")
    public Set<AdmissionEducationLevelSubjects> getAdmissionEducationLevelSubjects() {
        return this.admissionEducationLevelSubjects;
    }

    public void setAdmissionEducationLevelSubjects(Set<AdmissionEducationLevelSubjects> admissionEducationLevelSubjects) {
        this.admissionEducationLevelSubjects = admissionEducationLevelSubjects;
    }

    @OneToOne(fetch=FetchType.LAZY, mappedBy="admission")
    public Student getStudent() {
        return this.student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="education_level_id", nullable=false)
    public EducationLevel getEducationLevel() {
        return this.educationLevel;
    }

    public void setEducationLevel(EducationLevel educationLevel) {
        this.educationLevel = educationLevel;
    }

    @Column(name="total", nullable=true)
    public Double getTotal() {
        return this.total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
