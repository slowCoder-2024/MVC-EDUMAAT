/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.ServletException
 *  javax.servlet.http.HttpServletRequest
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.http.HttpStatus
 *  org.springframework.stereotype.Controller
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RequestMethod
 *  org.springframework.web.bind.annotation.RequestParam
 *  org.springframework.web.bind.annotation.ResponseBody
 *  org.springframework.web.bind.annotation.ResponseStatus
 *  org.springframework.web.multipart.MultipartFile
 *  org.springframework.web.servlet.ModelAndView
 *  org.springframework.web.servlet.mvc.support.RedirectAttributes
 */
package in.jdsoft.educationmanagement.school.controller;

import in.jdsoft.educationmanagement.school.components.AdmissionRuleHandler;
import in.jdsoft.educationmanagement.school.components.EmailHandler;
import in.jdsoft.educationmanagement.school.components.FileUploadHandler;
import in.jdsoft.educationmanagement.school.components.HashGenerator;
import in.jdsoft.educationmanagement.school.exceptions.AdmissionException;
import in.jdsoft.educationmanagement.school.model.Admission;
import in.jdsoft.educationmanagement.school.model.AdmissionConfig;
import in.jdsoft.educationmanagement.school.model.AdmissionDocument;
import in.jdsoft.educationmanagement.school.model.AdmissionDocumentTypes;
import in.jdsoft.educationmanagement.school.model.AdmissionEducationLevelDetails;
import in.jdsoft.educationmanagement.school.model.AdmissionEducationLevelSubjects;
import in.jdsoft.educationmanagement.school.model.AdmissionProcessStatus;
import in.jdsoft.educationmanagement.school.model.AdmissionStatus;
import in.jdsoft.educationmanagement.school.model.Category;
import in.jdsoft.educationmanagement.school.model.Class;
import in.jdsoft.educationmanagement.school.model.EducationLevel;
import in.jdsoft.educationmanagement.school.model.EducationLevelSubject;
import in.jdsoft.educationmanagement.school.model.HearedUs;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.Religion;
import in.jdsoft.educationmanagement.school.model.SpecialCategory;
import in.jdsoft.educationmanagement.school.model.Sponser;
import in.jdsoft.educationmanagement.school.model.User;
import in.jdsoft.educationmanagement.school.model.UserRole;
import in.jdsoft.educationmanagement.school.services.AcademicYearService;
import in.jdsoft.educationmanagement.school.services.AdmissionService;
import in.jdsoft.educationmanagement.school.services.BloodGroupService;
import in.jdsoft.educationmanagement.school.services.CategoryService;
import in.jdsoft.educationmanagement.school.services.ClassService;
import in.jdsoft.educationmanagement.school.services.EducationLevelService;
import in.jdsoft.educationmanagement.school.services.GeographicalLocationService;
import in.jdsoft.educationmanagement.school.services.HearedUsService;
import in.jdsoft.educationmanagement.school.services.InstitutionService;
import in.jdsoft.educationmanagement.school.services.ReligionService;
import in.jdsoft.educationmanagement.school.services.SectionService;
import in.jdsoft.educationmanagement.school.services.SpecialCategoryService;
import in.jdsoft.educationmanagement.school.services.SponserService;
import in.jdsoft.educationmanagement.school.services.StudentService;
import in.jdsoft.educationmanagement.school.services.StudentStatusService;
import in.jdsoft.educationmanagement.school.services.UserRoleService;
import in.jdsoft.educationmanagement.school.services.UserService;
import java.io.IOException;
import java.net.InetAddress;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value={"/admissions"})
public class AdmissionController {
    @Autowired
    private EmailHandler emailComponent;
    @Autowired
    private UserService userService;
    @Autowired
    private AdmissionService admissionService;
    @Autowired
    private GeographicalLocationService geographicalLocationService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private SpecialCategoryService specialCategoryService;
    @Autowired
    private SponserService sponserService;
    @Autowired
    private HearedUsService hearedUsService;
    @Autowired
    private EducationLevelService educationLevelService;
    @Autowired
    private ClassService classService;
    @Autowired
    private SectionService sectionService;
    @Autowired
    private ReligionService religionService;
    @Autowired
    private AdmissionRuleHandler admissionRuleHandler;
    @Autowired
    private InstitutionService institutionService;
    @Autowired
    private HashGenerator hashGenerator;
    @Autowired
    private BloodGroupService bloodGroupService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentStatusService studentStatusService;
    @Autowired
    private AcademicYearService academicYearService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private FileUploadHandler fileUploadHandler;
    @Autowired
    private EmailHandler emailHandler;
    String url = "Failed to generate url";

    @RequestMapping(value={"candidate/unversityprofile"})
    public ModelAndView displayUniversityProfilePage() {
        try {
            ModelAndView modelandview = new ModelAndView("universityprofile");
            return modelandview;
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ModelAndView("404");
        }
    }

    @RequestMapping(value={"candidate/applyforadmission"})
    public ModelAndView displayadmissionPage(HttpServletRequest request) {
        try {
            ModelAndView modelandview = new ModelAndView("admission");
            Long instituteId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            AdmissionConfig admissionConfig = this.admissionService.getCurrentAdmissionConfig();
            modelandview.addObject("admissionConfig", (Object)this.admissionService.getCurrentAdmissionConfig());
            if (admissionConfig != null) {
                modelandview.addObject("categoryList", this.categoryService.categoryList());
                modelandview.addObject("specialCategoryList", this.specialCategoryService.specialCategoryList());
                modelandview.addObject("admissionConfigList", this.admissionService.getOnGoingAdmissionConfig());
                modelandview.addObject("countryList", this.geographicalLocationService.countryList());
                modelandview.addObject("stateList", this.geographicalLocationService.stateList());
                modelandview.addObject("cityList", this.geographicalLocationService.cityList());
                modelandview.addObject("sponserList", this.sponserService.getSponserList());
                modelandview.addObject("hearedUsType", this.hearedUsService.getHearedUsList());
                modelandview.addObject("educationQualificationLevelList", this.educationLevelService.getEducationLevelList());
                modelandview.addObject("classList", this.classService.classList(instituteId));
                modelandview.addObject("sectionList", this.sectionService.sectionList(instituteId));
                modelandview.addObject("admissionDocumentTypeList", this.admissionService.getAdmissionDocumentTypeList());
                modelandview.addObject("appliedApplicationsList", this.userService.getUsersAdmissionApplication(request.getSession().getAttribute("username").toString()));
                modelandview.addObject("religionList", this.religionService.getReligionList());
                return modelandview;
            }
            return modelandview;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"candidate/newAdmission/save"}, method={RequestMethod.POST})
    public String saveNewAdmission(HttpServletRequest request, RedirectAttributes redirectAttributes, @RequestParam(value="candidateProfilePicture") MultipartFile candidateProfilePicture, @RequestParam(value="candidateSignature") MultipartFile candidateSignature, @RequestParam(value="candidateSSLCCertificate") MultipartFile candidateSSLCCertificate, @RequestParam(value="candidateHSCertificate") MultipartFile candidateHSCCertificate, @RequestParam(value="candidateTransferCertificate") MultipartFile candidateTransferCertificate, @RequestParam(value="candidatePreviousMarkSheetCertificate") MultipartFile candidatePreviousMarkSheetCertificate) throws Exception {
        try {
            Long admisionConfigId = Long.parseLong(request.getParameter("admissionCodeFormat"));
            AdmissionConfig currentConfig = this.admissionService.getAdmissionConfigById(admisionConfigId);
            String candidateFirstName = request.getParameter("candidateFirstName");
            String candidateLastName = request.getParameter("candidateLastName");
            String candidateGender = request.getParameter("candidateGender");
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date dateOfBirth = null;
            if (!request.getParameter("dateOfBirth").isEmpty()) {
                dateOfBirth = formatter.parse(request.getParameter("dateOfBirth"));
            }
            Religion religion = null;
            if (request.getParameter("religionId") != null) {
                religion = this.religionService.getReligionById(Long.parseLong(request.getParameter("religionId")));
            }
            Category category = null;
            if (request.getParameter("categoryId") != null) {
                category = this.categoryService.categoryById(Long.parseLong(request.getParameter("categoryId")));
            }
            SpecialCategory specialCategory = null;
            if (request.getParameter("specialCategoryId") != null) {
                specialCategory = this.specialCategoryService.specialCategoryById(Long.parseLong(request.getParameter("specialCategoryId")));
            }
            String passportNo = request.getParameter("passportNo");
            String passportIssuedCountry = "";
            if (request.getParameter("passportissuedCountryId") != null) {
                passportIssuedCountry = request.getParameter("passportissuedCountryId");
            }
            String studiedHereBefore = request.getParameter("IsStudiedBefore");
            String previousStudentIdOfThisInstitute = request.getParameter("previousStudentId");
            Sponser sponser = null;
            if (request.getParameter("sponserId") != null) {
                sponser = this.sponserService.getSponserById(Long.parseLong(request.getParameter("sponserId")));
            }
            String disability = request.getParameter("isDisability");
            String fatherFirstName = request.getParameter("fatherFirstName");
            String fatherLastName = request.getParameter("fatherLastName");
            String fatherOccupation = request.getParameter("fatherOccupation");
            String motherFirstName = request.getParameter("motherFirstName");
            String motherLastName = request.getParameter("motherLastName");
            String motherOccupation = request.getParameter("motherOccupation");
            double fatherIncome = 0.0;
            if (!request.getParameter("fatherIncome").isEmpty()) {
                fatherIncome = Double.parseDouble(request.getParameter("fatherIncome"));
            }
            double motherIncome = 0.0;
            if (!request.getParameter("motherIncome").isEmpty()) {
                motherIncome = Double.parseDouble(request.getParameter("motherIncome"));
            }
            String guardianFirstName = request.getParameter("guardianFirstName");
            String guardianLastName = request.getParameter("guardianLastName");
            String referenceOneFirstName = request.getParameter("reference1FirstName");
            String referenceOneLastName = request.getParameter("reference1LastName");
            String referenceOneEmail = request.getParameter("reference1Email");
            String referenceOneMobile = request.getParameter("reference1Mobile");
            String referenceOneAddressLineOne = request.getParameter("reference1AddressLine1");
            String referenceOneAddressLineTwo = request.getParameter("reference1AddressLine2");
            String referenceOneCountry = "";
            if (request.getParameter("reference1CountryId") != null) {
                referenceOneCountry = request.getParameter("reference1CountryId");
            }
            String referenceOnePincode = request.getParameter("reference1Pincode");
            String referenceTwoFirstName = request.getParameter("reference2FirstName");
            String referenceTwoLastName = request.getParameter("reference2LastName");
            String referenceTwoEmail = request.getParameter("reference2Email");
            String referenceTwoMobile = request.getParameter("reference2Mobile");
            String referenceTwoAddressLineOne = request.getParameter("reference2AddressLine1");
            String referenceTwoAddressLineTwo = request.getParameter("reference2AddressLine2");
            String referenceTwoCountry = "";
            if (request.getParameter("reference2CountryId") != null) {
                referenceTwoCountry = request.getParameter("reference2CountryId");
            }
            String referenceTwoPincode = request.getParameter("reference2Pincode");
            HearedUs hearedUs = null;
            if (request.getParameter("hearedUsid") != null) {
                hearedUs = this.hearedUsService.getHearedUsById(Long.parseLong(request.getParameter("hearedUsid")));
            }
            String candidateAddressLineOne = request.getParameter("candidateAddressLine1");
            String candidateAddressLineTwo = request.getParameter("candidateAddressLine2");
            String candidateEmail = request.getParameter("candidateEmail");
            String candidateContact = request.getParameter("mobileNumber");
            String candidateCountry = "";
            if (request.getParameter("candidateCountryid") != null) {
                candidateCountry = request.getParameter("candidateCountryid");
            }
            String candidateState = "";
            if (request.getParameter("candidateStateid") != null) {
                candidateState = request.getParameter("candidateStateid");
            }
            String candidateCity = "";
            if (request.getParameter("candidateCityid") != null) {
                candidateCity = request.getParameter("candidateCityid");
            }
            String candidatePostcode = request.getParameter("candidatePostCode");
            Class classz = null;
            if (request.getParameter("classId") != null) {
                classz = this.classService.classById(Long.parseLong(request.getParameter("classId")));
            }
            String admissionCode = currentConfig.getApplicationCodeFormat().concat(Long.toString(System.currentTimeMillis()));
            AdmissionStatus admissionStatus = this.admissionService.getAdmissionStatusById(1L);
            int submitStatus = 0;
            User user = this.userService.userByEmailEager(request.getSession().getAttribute("username").toString());
            Double admissionRank = 0.0;
            String degreeName = request.getParameter("nameofDegree");
            String registerNumber = request.getParameter("registrationNumber");
            EducationLevel educationLevel = null;
            if (request.getParameter("educationLevelId") != null) {
                educationLevel = this.educationLevelService.getEducationLevelLazyById(Long.parseLong(request.getParameter("educationLevelId")));
            }
            String certificateNumber = request.getParameter("certificateNumber");
            Date startDate = null;
            Date endDate = null;
            if (request.getParameter("startDate") != null) {
                startDate = formatter.parse(request.getParameter("startDate"));
            }
            if (request.getParameter("endDate") != null) {
                endDate = formatter.parse(request.getParameter("endDate"));
            }
            Double marksObtained = Double.parseDouble(request.getParameter("marksObtained"));
            Double percentage = 0.0;
            Double cgpa = 0.0;
            String markType = request.getParameter("markType");
            if (request.getParameter("markType").equals("Percentage")) {
                percentage = Double.parseDouble(request.getParameter("marksObtained"));
            } else if (request.getParameter("markType").equals("CGPA")) {
                cgpa = Double.parseDouble(request.getParameter("marksObtained"));
            }
            String instituteCountry = "";
            if (request.getParameter("institutionCountryId") != null) {
                instituteCountry = request.getParameter("institutionCountryId");
            }
            String instituteState = "";
            if (request.getParameter("institutionStateId") != null) {
                instituteState = request.getParameter("institutionStateId");
            }
            String instituteCity = "";
            if (request.getParameter("institutionCityId") != null) {
                instituteCity = request.getParameter("institutionCityId");
            }
            String boardAndUniversity = request.getParameter("boardAndUniversity");
            String institutionName = request.getParameter("institutionName");
            String yearOfPassing = request.getParameter("yearOfPassing");
            LinkedHashSet<AdmissionEducationLevelDetails> admissionAcademicsDetails = new LinkedHashSet<AdmissionEducationLevelDetails>();
            LinkedHashSet<AdmissionEducationLevelSubjects> admissionEducationLevelSubjects = new LinkedHashSet<AdmissionEducationLevelSubjects>();
            LinkedHashSet<AdmissionDocument> admissionDocuments = new LinkedHashSet<AdmissionDocument>();
            String candidateProfilePicturePath = "";
            if (candidateProfilePicture != null && !candidateProfilePicture.isEmpty()) {
                candidateProfilePicturePath = this.fileUploadHandler.uploadFile(candidateProfilePicture.getBytes(), request.getRealPath("/"), "/resources/themes/images/profile-pic/student-profilepic/", candidateProfilePicture.getOriginalFilename());
            }
            if (candidateProfilePicturePath == "") {
                candidateProfilePicturePath = "/resources/themes/images/profile-pic/a.png";
            }
            String candidateSignaturePath = "";
            if (candidateSignature != null && !candidateSignature.isEmpty()) {
                candidateSignaturePath = this.fileUploadHandler.uploadFile(candidateSignature.getBytes(), request.getRealPath("/"), "/resources/themes/images/profile-pic/student-signature/", candidateSignature.getOriginalFilename());
            }
            if (candidateSignaturePath == "") {
                candidateSignaturePath = "/resources/themes/images/profile-pic/a.png";
            }
            String candidateSSLCCertificatePath = "";
            String candidateSSLCCertificateName = "";
            if (candidateSSLCCertificate != null && !candidateSSLCCertificate.isEmpty()) {
                candidateSSLCCertificateName = candidateSSLCCertificate.getOriginalFilename();
                candidateSSLCCertificatePath = this.fileUploadHandler.uploadFile(candidateSSLCCertificate.getBytes(), request.getRealPath("/"), "/resources/themes/images/profile-pic/student-sslc-certificates/", candidateSSLCCertificate.getOriginalFilename());
            }
            if (candidateSSLCCertificatePath == "") {
                candidateSSLCCertificatePath = "/resources/themes/images/profile-pic/a.png";
            }
            String candidateHSCCertificatePath = "";
            String candidateHSCCertificateName = "";
            if (candidateHSCCertificate != null && !candidateHSCCertificate.isEmpty()) {
                candidateHSCCertificateName = candidateHSCCertificate.getOriginalFilename();
                candidateHSCCertificatePath = this.fileUploadHandler.uploadFile(candidateHSCCertificate.getBytes(), request.getRealPath("/"), "/resources/themes/images/profile-pic/student-hsc-certificates/", candidateHSCCertificate.getOriginalFilename());
            }
            if (candidateHSCCertificatePath == "") {
                candidateHSCCertificatePath = "/resources/themes/images/profile-pic/a.png";
            }
            String candidateTransferCertificatePath = "";
            String candidateTCCertificateName = "";
            if (candidateTransferCertificate != null && !candidateTransferCertificate.isEmpty()) {
                candidateTCCertificateName = candidateTransferCertificate.getOriginalFilename();
                candidateTransferCertificatePath = this.fileUploadHandler.uploadFile(candidateTransferCertificate.getBytes(), request.getRealPath("/"), "/resources/themes/images/profile-pic/student-tc-certificates/", candidateTransferCertificate.getOriginalFilename());
            }
            if (candidateTransferCertificatePath == "") {
                candidateTransferCertificatePath = "/resources/themes/images/profile-pic/a.png";
            }
            String candidatePreviousMarkSheetCertificatePath = "";
            String candidatePreviousMarkSheetCertificateName = "";
            if (candidatePreviousMarkSheetCertificate != null && !candidatePreviousMarkSheetCertificate.isEmpty()) {
                candidatePreviousMarkSheetCertificateName = candidatePreviousMarkSheetCertificate.getOriginalFilename();
                candidatePreviousMarkSheetCertificatePath = this.fileUploadHandler.uploadFile(candidatePreviousMarkSheetCertificate.getBytes(), request.getRealPath("/"), "/resources/themes/images/profile-pic/student-previous-marksheet-certificates/", candidatePreviousMarkSheetCertificate.getOriginalFilename());
            }
            if (candidatePreviousMarkSheetCertificatePath == "") {
                candidatePreviousMarkSheetCertificatePath = "/resources/themes/images/profile-pic/a.png";
            }
            Admission newAdmission = new Admission(currentConfig, classz, admissionStatus, religion, sponser, category, specialCategory, hearedUs, admissionCode, candidateFirstName, candidateLastName, fatherFirstName, fatherLastName, fatherOccupation, motherFirstName, motherLastName, motherOccupation, fatherIncome, motherIncome, guardianFirstName, guardianLastName, passportNo, studiedHereBefore, previousStudentIdOfThisInstitute, disability, referenceOneFirstName, referenceOneLastName, referenceOneEmail, referenceOneMobile, referenceOneAddressLineOne, referenceOneAddressLineTwo, referenceOneCountry, referenceOnePincode, referenceTwoFirstName, referenceTwoLastName, referenceTwoEmail, referenceTwoMobile, referenceTwoAddressLineOne, referenceTwoAddressLineTwo, referenceTwoCountry, referenceTwoPincode, candidateSignaturePath, candidateGender, dateOfBirth, candidateEmail, candidateContact, passportIssuedCountry, candidateAddressLineOne, candidateAddressLineTwo, candidateCountry, candidateState, candidateCity, candidatePostcode, candidateProfilePicturePath, submitStatus, admissionRank, user, educationLevel);
            AdmissionDocumentTypes admissionDocumentTypeSSLC = this.admissionService.getAdmissionDocumentTypeById(1L);
            AdmissionDocument admissionDocumentSSLC = new AdmissionDocument(newAdmission, admissionDocumentTypeSSLC, candidateSSLCCertificateName, candidateSSLCCertificatePath);
            AdmissionDocumentTypes admissionDocumentTypeHSC = this.admissionService.getAdmissionDocumentTypeById(2L);
            AdmissionDocument admissionDocumentHSC = new AdmissionDocument(newAdmission, admissionDocumentTypeHSC, candidateHSCCertificateName, candidateHSCCertificatePath);
            AdmissionDocumentTypes admissionDocumentTypeTC = this.admissionService.getAdmissionDocumentTypeById(3L);
            AdmissionDocument admissionDocumentTC = new AdmissionDocument(newAdmission, admissionDocumentTypeTC, candidateTCCertificateName, candidateTransferCertificatePath);
            AdmissionDocumentTypes admissionDocumentTypePreviousMarkSheet = this.admissionService.getAdmissionDocumentTypeById(4L);
            AdmissionDocument admissionDocumentPreviousMarkSheet = new AdmissionDocument(newAdmission, admissionDocumentTypePreviousMarkSheet, candidatePreviousMarkSheetCertificateName, candidatePreviousMarkSheetCertificatePath);
            admissionDocuments.add(admissionDocumentHSC);
            admissionDocuments.add(admissionDocumentSSLC);
            admissionDocuments.add(admissionDocumentTC);
            admissionDocuments.add(admissionDocumentPreviousMarkSheet);
            AdmissionEducationLevelDetails admissionEducationLevelDetail = new AdmissionEducationLevelDetails(newAdmission, educationLevel, degreeName, registerNumber, certificateNumber, startDate, endDate, marksObtained, percentage, cgpa, boardAndUniversity, instituteCountry, instituteState, instituteCity, institutionName, yearOfPassing, markType);
            admissionAcademicsDetails.add(admissionEducationLevelDetail);
            for (EducationLevelSubject educationLevelSubject : educationLevel.getEducationLevelSubjects()) {
                String admissionEducationLevelSubjectTitle = educationLevelSubject.getEducationLevelSubjectTitle();
                Double subjectMarks = 0.0;
                if (request.getParameter("subject" + admissionEducationLevelSubjectTitle) != null) {
                    subjectMarks = Double.parseDouble(request.getParameter("subject" + admissionEducationLevelSubjectTitle));
                }
                AdmissionEducationLevelSubjects admissionEducationLevelSubject = new AdmissionEducationLevelSubjects(admissionEducationLevelDetail, newAdmission, subjectMarks, admissionEducationLevelSubjectTitle);
                admissionEducationLevelSubjects.add(admissionEducationLevelSubject);
            }
            this.admissionService.createAdmission(newAdmission, admissionAcademicsDetails, admissionEducationLevelSubjects, admissionDocuments);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Application Submitted Successfully...!"));
            return "redirect:/admissions/candidate/applyforadmission";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Cannot Be Done...!"));
            e.printStackTrace();
            return "redirect:/admissions/candidate/applyforadmission";
        }
    }

    @RequestMapping(value={"candidate/newAdmission/edit"})
    @ResponseBody
    public Admission editNewAdmission(HttpServletRequest request) {
        try {
            Long admissionId = Long.parseLong(request.getParameter("admissionId"));
            Admission admission = this.admissionService.editAdmissionApplication(admissionId);
            return admission;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"/uploadStudentAdmissionExcel"}, method={RequestMethod.POST})
    public String studentAdmissionBulkUpload(@RequestParam(value="studentBulkUpdate") MultipartFile studentAdmissionExcelFile, RedirectAttributes redirectAttributes, HttpServletRequest request) throws AdmissionException, Exception {
        try {
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            String createdBy = request.getSession().getAttribute("username").toString();
            this.admissionService.studentAdmissionBulkUpload(studentAdmissionExcelFile, institutionId, createdBy);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Uploaded Successfully"));
            return "redirect:/admissions/candidate/applyforadmission";
        }
        catch (Exception e) {
            if (e.getClass().equals(AdmissionException.class)) {
                AdmissionException admissionException = (AdmissionException)e;
                redirectAttributes.addFlashAttribute("alert", (Object)admissionException.getCustomMessage());
                return "redirect:/admissions/candidate/applyforadmission";
            }
            e.printStackTrace();
            return "redirect:/admissions/candidate/applyforadmission";
        }
    }

    @RequestMapping(value={"candidate/newAdmission/submit"})
    public ModelAndView submitNewAdmission(HttpServletRequest request) {
        try {
            ModelAndView modelandview = new ModelAndView("admission");
            return modelandview;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"candidate/admissioncourses"})
    public ModelAndView displayadmissioncoursePage(HttpServletRequest request) {
        try {
            ModelAndView modelandview = new ModelAndView("admissioncourses");
            Long instituteId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            modelandview.addObject("classList", this.classService.classListEager(instituteId));
            modelandview.addObject("sectionList", this.sectionService.sectionList(instituteId));
            return modelandview;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"candidate/statusandcommunication"})
    public ModelAndView displaystatusPage(HttpServletRequest request) {
        try {
            ModelAndView modelandview = new ModelAndView("statusandcommunication");
            String email = request.getSession().getAttribute("username").toString();
            this.emailHandler.setMailFrom(email);
            modelandview.addObject("user", (Object)this.userService.userByEmailEager(email));
            modelandview.addObject("receivedCommunicationNotifications", (Object)this.userService.userCommunicationNotificationByEmail(email));
            return modelandview;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"candidate/signup"}, method={RequestMethod.POST})
    public String addAdmissionUser(HttpServletRequest request, RedirectAttributes redirectAttributes) throws ServletException, IOException {
        Message message;
        block3: {
            try {
                String userEmail = request.getParameter("e-mail");
                message = this.userService.emailAvailablityCheck(userEmail);
                if (!message.getStatus().equals("success")) break block3;
                String userPassword = request.getParameter("pass_word");
                String name = request.getParameter("name");
                Long institutionId = Long.parseLong(request.getParameter("institutionId"));
                String hashedvalue = this.hashGenerator.encoder(userPassword);
                LinkedHashSet<UserRole> userRoles = new LinkedHashSet<UserRole>();
                UserRole candidateRole = this.userRoleService.userRoleBy("admissioncandidate", institutionId);
                userRoles.add(candidateRole);
                String createdBy = request.getParameter("e-mail");
                Institution institution = this.institutionService.institutionById(institutionId);
                String profilePicturePath = "/resources/themes/images/profile-pic/a.png";
                User user = new User(userRoles, name, userEmail, userPassword, createdBy, 0, hashedvalue, profilePicturePath, institution);
                this.userService.createUser(user);
                InetAddress ipad = InetAddress.getLocalHost();
                this.url = "http://" + ipad.getHostName() + ":8080" + request.getContextPath() + "/admissions/candidate/verify?email=" + userEmail + "&hash=" + hashedvalue;
                String emailmessage = "Dear " + name.toUpperCase() + ",\n\n You have signed up for edumaat, please verify your account by " + "clicking the below given link to activate it.\n\n" + this.url + "\n\n Thank You\n Edumaat \n JD Soft";
                this.emailComponent.sendEmail(userEmail, "Verify You Login Details", emailmessage);
                redirectAttributes.addFlashAttribute("message", (Object)new Message("success", "You have successfully created Account!! You have to verify your account to Log in"));
                return "redirect:/";
            }
            catch (Exception e) {
                e.printStackTrace();
                redirectAttributes.addFlashAttribute("message", (Object)new Message("failed", "Some Error Occurred Contact Institution Admin"));
                return "redirect:/";
            }
        }
        redirectAttributes.addFlashAttribute("message", (Object)message);
        return "redirect:/";
    }

    @RequestMapping(value={"candidate/verify"}, method={RequestMethod.GET})
    public String verifyAdmissionUser(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        block8: {
            block9: {
                User users;
                String hash;
                block6: {
                    block7: {
                        try {
                            String username = request.getParameter("email");
                            hash = request.getParameter("hash");
                            users = this.userService.userByEmailEager(username);
                            InetAddress ipad = InetAddress.getLocalHost();
                            if (users.getStatus() != 0) break block6;
                            if (!users.getHash().equals(hash)) break block7;
                            users.setStatus(1);
                            this.userService.updateUser(users);
                            String message = "Welcome !! " + users.getName().toUpperCase() + ",\n\n You have successfully verified Your account, now you can login with your username and password" + "\n\n Login @ " + "http://" + ipad.getHostName() + ":8080" + request.getContextPath() + "\n\n Thank You\n Edumaat \n JD Soft";
                            this.emailComponent.sendEmail(username, "Welcome to EDUMAAT", message);
                            redirectAttributes.addFlashAttribute("message", (Object)new Message("success", "successfully verified"));
                            return "redirect:/";
                        }
                        catch (Exception e) {
                            e.printStackTrace();
                            return "redirect:/";
                        }
                    }
                    redirectAttributes.addFlashAttribute("message", (Object)new Message("failure", "Invalid Link !!"));
                    return "redirect:/";
                }
                if (users.getStatus() != 1) break block8;
                if (!users.getHash().equals(hash)) break block9;
                redirectAttributes.addFlashAttribute("message", (Object)new Message("success", "already your account is verified"));
                return "redirect:/";
            }
            redirectAttributes.addFlashAttribute("message", (Object)new Message("failure", "Invalid Link !!"));
            return "redirect:/";
        }
        redirectAttributes.addFlashAttribute("message", (Object)new Message("failure", "Error Contact Admin"));
        return "redirect:/";
    }

    @RequestMapping(value={"admissiondashboard"})
    public ModelAndView displayAdmissionDashboardPage(HttpServletRequest request) {
        try {
            ModelAndView modelandview = new ModelAndView("admissiondashboard");
            Long instituteId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            modelandview.addObject("institution", (Object)this.institutionService.institutionById(instituteId));
            return modelandview;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"admissionconfig"})
    public ModelAndView displayAdmissionConfigPage(HttpServletRequest request) {
        try {
            ModelAndView modelandview = new ModelAndView("admissionconfig");
            Long instituteId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            modelandview.addObject("admissionProcessStatusList", this.admissionService.getAdmissionProcessStatusList());
            modelandview.addObject("admissionConfigList", this.admissionService.getAdmissionConfigList());
            modelandview.addObject("classList", this.classService.classList(instituteId));
            return modelandview;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"admissionconfig/add"}, method={RequestMethod.POST})
    public String addAdmissionConfig(HttpServletRequest request, RedirectAttributes redirectAttributes) throws ParseException {
        try {
            String applicationCodeFormat = request.getParameter("admissionCodeFormat");
            double applicationFees = Double.parseDouble(request.getParameter("admissionApplicationFees"));
            Long applicationTotalSeats = Long.parseLong(request.getParameter("admissionTotalSeats"));
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date startdate = formatter.parse(request.getParameter("admissionstartdate"));
            Date enddate = formatter.parse(request.getParameter("admissionenddate"));
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startdate);
            int year = calendar.get(1);
            String admissionProcessYear = Integer.toString(year);
            String[] classIds = request.getParameterValues("classId");
            HashSet<Class> classes = new HashSet<Class>();
            String[] stringArray = classIds;
            int n = classIds.length;
            int n2 = 0;
            while (n2 < n) {
                String classId = stringArray[n2];
                classes.add(this.classService.classById(Long.parseLong(classId)));
                ++n2;
            }
            AdmissionProcessStatus admissionProcessStatus = this.admissionService.getAdmissionProcessStatusById(Long.parseLong(request.getParameter("admissionProcessStatusId")));
            AdmissionConfig admissionConfig = new AdmissionConfig(admissionProcessStatus, admissionProcessYear, startdate, enddate, applicationCodeFormat, applicationFees, applicationTotalSeats, classes);
            this.admissionService.addAdmissionConfig(admissionConfig);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Admission Configure Successfully...!"));
            return "redirect:/admissions/admissionconfig";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "redirect:/admissions/admissionconfig";
        }
    }

    @RequestMapping(value={"admissionconfig/update"}, method={RequestMethod.POST})
    public String updateAdmissionConfig(HttpServletRequest request, RedirectAttributes redirectAttributes) throws ParseException {
        try {
            Long admissionConfigId = Long.parseLong(request.getParameter("updateAdmissionConfigId"));
            AdmissionConfig admissionConfig = this.admissionService.getAdmissionConfigById(admissionConfigId);
            String applicationCodeFormat = request.getParameter("editadmissionCodeFormat");
            double applicationFees = Double.parseDouble(request.getParameter("editadmissionApplicationFees"));
            Long applicationTotalSeats = Long.parseLong(request.getParameter("editAdmissionTotalSeats"));
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date startdate = formatter.parse(request.getParameter("editadmissionstartdate"));
            Date enddate = formatter.parse(request.getParameter("editadmissionenddate"));
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startdate);
            int year = calendar.get(1);
            String admissionProcessYear = Integer.toString(year);
            String[] classIds = request.getParameterValues("editClassId");
            HashSet<Class> classes = new HashSet<Class>();
            String[] stringArray = classIds;
            int n = classIds.length;
            int n2 = 0;
            while (n2 < n) {
                String classId = stringArray[n2];
                classes.add(this.classService.classById(Long.parseLong(classId)));
                ++n2;
            }
            AdmissionProcessStatus admissionProcessStatus = this.admissionService.getAdmissionProcessStatusById(Long.parseLong(request.getParameter("editadmissionProcessStatusId")));
            admissionConfig.setAdmissionEndDate(enddate);
            admissionConfig.setAdmissionStartDate(startdate);
            admissionConfig.setApplicationCodeFormat(applicationCodeFormat);
            admissionConfig.setApplicationFees(applicationFees);
            admissionConfig.setAdmissionProcessYear(admissionProcessYear);
            admissionConfig.setAdmissionProcessStatus(admissionProcessStatus);
            admissionConfig.setApplicationTotalSeats(applicationTotalSeats);
            admissionConfig.setClasses(classes);
            this.admissionService.updateAdmissionConfig(admissionConfig);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Updated Successfully...!"));
            return "redirect:/admissions/admissionconfig";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "redirect:/admissions/admissionconfig";
        }
    }

    @RequestMapping(value={"admissionconfig/delete"}, method={RequestMethod.GET})
    public String deleteAdmissionConfig(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            ArrayList<Object> admissions = new ArrayList();
            Long admissionConfigId = Long.parseLong(request.getParameter("admissionConfigId"));
            AdmissionConfig admissionConfig = this.admissionService.getAdmissionConfigById(admissionConfigId);
            admissions = this.admissionService.getApplicantsDetailsByAcademicYear(admissionConfig);
            if (admissions.size() > 0) {
                throw new Exception();
            }
            if (admissionConfig.getAdmissionProcessStatus().equals("On Going")) {
                throw new Exception();
            }
            this.admissionService.deleteAdmissionConfig(admissionConfigId);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Deleted Successfully...!"));
            return "redirect:/admissions/admissionconfig";
        }
        catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failed", "Cannot Delete This Configuration...!"));
            return "redirect:/admissions/admissionconfig";
        }
    }

    @RequestMapping(value={"admissionconfig/view"}, method={RequestMethod.GET})
    @ResponseBody
    public AdmissionConfig viewAdmissionConfig(HttpServletRequest request) {
        try {
            Long admissionConfigId = Long.parseLong(request.getParameter("admissionConfigId"));
            return this.admissionService.getAdmissionConfigById(admissionConfigId);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"newadmission"})
    public ModelAndView displayNewAdmissionPage(HttpServletRequest request) {
        try {
            ModelAndView modelandview = new ModelAndView("newadmission");
            Long instituteId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            modelandview.addObject("categoryList", this.categoryService.categoryList());
            modelandview.addObject("specialCategoryList", this.specialCategoryService.specialCategoryList());
            modelandview.addObject("countryList", this.geographicalLocationService.countryList());
            modelandview.addObject("stateList", this.geographicalLocationService.stateList());
            modelandview.addObject("cityList", this.geographicalLocationService.cityList());
            modelandview.addObject("sponserList", this.sponserService.getSponserList());
            modelandview.addObject("hearedUsType", this.hearedUsService.getHearedUsList());
            modelandview.addObject("educationQualificationLevelList", this.educationLevelService.getEducationLevelList());
            modelandview.addObject("classList", this.classService.classList(instituteId));
            modelandview.addObject("sectionList", this.sectionService.sectionList(instituteId));
            modelandview.addObject("bloodGroupList", this.bloodGroupService.bloodGroupList());
            modelandview.addObject("academicYearList", (Object)this.academicYearService.getActiveAcademicYear());
            modelandview.addObject("studentStatusList", this.studentStatusService.studentStatusList());
            modelandview.addObject("studentList", this.studentService.studentList());
            return modelandview;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"notification"})
    public ModelAndView displayNotificationage(HttpServletRequest request) {
        try {
            ModelAndView modelandview = new ModelAndView("notification");
            return modelandview;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"/finalization"}, method={RequestMethod.GET})
    public ModelAndView displayFinalizationPage(HttpServletRequest request) {
        try {
            ModelAndView modelandview = new ModelAndView("finalization");
            Long instituteId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            modelandview.addObject("classList", this.classService.classList(instituteId));
            modelandview.addObject("sectionList", this.sectionService.sectionList(instituteId));
            modelandview.addObject("educationQualificationLevelList", this.educationLevelService.getEducationLevelList());
            modelandview.addObject("admissionConfigList", this.admissionService.getOnGoingAdmissionConfig());
            return modelandview;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"admissioncandidatedetails"})
    public ModelAndView displayAdmissionCandidateDetailsPage(HttpServletRequest request) {
        try {
            ModelAndView modelandview = new ModelAndView("admissioncandidatedetails");
            Long instituteId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            modelandview.addObject("classList", this.classService.classList(instituteId));
            modelandview.addObject("educationQualificationLevelList", this.educationLevelService.getEducationLevelList());
            modelandview.addObject("admissionConfigList", this.admissionService.getAdmissionConfigList());
            return modelandview;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"/finalization/applyAdmissionRule"}, method={RequestMethod.GET})
    @ResponseBody
    public ArrayList<Admission> applyAdmissionRule(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        ArrayList<Admission> admissions = new ArrayList<Admission>();
        try {
            Long classId = Long.parseLong(request.getParameter("classId"));
            Long admissionConfigId = Long.parseLong(request.getParameter("admissionCodeFormat"));
            AdmissionConfig admissionConfig = this.admissionService.getAdmissionConfigById(admissionConfigId);
            Class classz = this.classService.classById(classId);
            int ruleId = Integer.parseInt(request.getParameter("ruleId"));
            Long maxSelect = admissionConfig.getApplicationTotalSeats();
            admissions = this.admissionRuleHandler.executeRule1(classz, admissionConfig, ruleId, maxSelect);
            return admissions;
        }
        catch (Exception e) {
            e.printStackTrace();
            return admissions;
        }
    }

    @RequestMapping(value={"/admissioncandidatedetails/getadmissioncandidatedetails"}, method={RequestMethod.GET})
    @ResponseBody
    public ArrayList<Admission> getAdmissionCandidateDetails(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        ArrayList<Admission> admissions = new ArrayList<Admission>();
        try {
            String criteria = request.getParameter("criteria");
            if (criteria.equals("academicyear")) {
                Long academicYearId = Long.parseLong(request.getParameter("academicYearId"));
                AdmissionConfig admissionConfig = this.admissionService.getAdmissionConfigById(academicYearId);
                admissions = this.admissionService.getApplicantsDetailsByAcademicYear(admissionConfig);
            } else if (criteria.equals("classes")) {
                Long classId = Long.parseLong(request.getParameter("classId"));
                Class classz = this.classService.classById(classId);
                admissions = this.admissionService.getApplicantsDetailsByClass(classz);
            }
            return admissions;
        }
        catch (Exception e) {
            e.printStackTrace();
            return admissions;
        }
    }

    @RequestMapping(value={"/admissionStatus"})
    public ModelAndView displayAdmissionStatuspage(HttpServletRequest request) {
        try {
            ModelAndView modelandview = new ModelAndView("admissionStatus");
            return modelandview;
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ModelAndView("admissionStatus");
        }
    }

    @RequestMapping(value={"/finalization/intimateSelectCandidate"}, method={RequestMethod.POST})
    @ResponseStatus(value=HttpStatus.OK)
    public void intimateCandidate(HttpServletRequest request) {
        try {
            String selectedApplications = request.getParameter("selectedAdmissionCandidates");
            String[] split = selectedApplications.trim().split(",");
            if (split.length > 0) {
                String[] stringArray = split;
                int n = split.length;
                int n2 = 0;
                while (n2 < n) {
                    String selectedApplication = stringArray[n2];
                    Long selectedApplicationAdmissionId = Long.parseLong(selectedApplication);
                    Admission admission = this.admissionService.getAdmissionDetailsById(selectedApplicationAdmissionId);
                    admission.setAdmissionStatus(this.admissionService.getAdmissionStatusById(4L));
                    User createdUser = this.userService.userByEmailEager(request.getSession().getAttribute("username").toString());
                    this.admissionService.intimateApplicationStatus(admission, createdUser);
                    ++n2;
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value={"/educationLevelSubject/list"})
    @ResponseBody
    public Set<EducationLevelSubject> geteducationLevelSubjects(HttpServletRequest request) {
        try {
            Long educationLevelId = Long.parseLong(request.getParameter("educationLevelId"));
            return this.educationLevelService.getEducationLevelSubjectByEducationLevelId(educationLevelId);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"/getAdmission"}, method={RequestMethod.GET})
    @ResponseBody
    public Admission getAdmission(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            Admission admission = this.admissionService.getFullAdmissionDetailsByApplicantCode(request.getParameter("applicantCode"));
            return admission;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"/getApplicantList"}, method={RequestMethod.GET})
    @ResponseBody
    public List<String> getApplicantList(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            ArrayList<String> applicantCode = new ArrayList<String>();
            for (Admission admission : this.admissionService.getAdmissionsList()) {
                applicantCode.add(admission.getAdmissionCode());
            }
            return applicantCode;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"getAdmissionByClass"}, method={RequestMethod.GET})
    @ResponseBody
    public Set<AdmissionConfig> getAdmissionConfigByClass(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            Long classId = Long.parseLong(request.getParameter("classId"));
            Set<AdmissionConfig> admissionConfig = this.classService.getAdmissionConfigByClassId(classId);
            return admissionConfig;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
