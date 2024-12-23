/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.hibernate.exception.ConstraintViolationException
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.dao.DataIntegrityViolationException
 *  org.springframework.http.HttpStatus
 *  org.springframework.security.access.prepost.PreAuthorize
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

import in.jdsoft.educationmanagement.school.components.EmailHandler;
import in.jdsoft.educationmanagement.school.components.FileUploadHandler;
import in.jdsoft.educationmanagement.school.components.HashGenerator;
import in.jdsoft.educationmanagement.school.exceptions.InstitutionException;
import in.jdsoft.educationmanagement.school.model.BloodGroup;
import in.jdsoft.educationmanagement.school.model.Category;
import in.jdsoft.educationmanagement.school.model.InstituteLedgerAccount;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.Staff;
import in.jdsoft.educationmanagement.school.model.StaffBankDetail;
import in.jdsoft.educationmanagement.school.model.StaffDesignation;
import in.jdsoft.educationmanagement.school.model.StaffExperienceDetail;
import in.jdsoft.educationmanagement.school.model.StaffType;
import in.jdsoft.educationmanagement.school.model.User;
import in.jdsoft.educationmanagement.school.reports.model.NineFieldReports;
import in.jdsoft.educationmanagement.school.reports.model.SixFieldReports;
import in.jdsoft.educationmanagement.school.services.BloodGroupService;
import in.jdsoft.educationmanagement.school.services.CategoryService;
import in.jdsoft.educationmanagement.school.services.CurrencyService;
import in.jdsoft.educationmanagement.school.services.GeographicalLocationService;
import in.jdsoft.educationmanagement.school.services.InstitutionService;
import in.jdsoft.educationmanagement.school.services.StaffBankDetailService;
import in.jdsoft.educationmanagement.school.services.StaffDesignationService;
import in.jdsoft.educationmanagement.school.services.StaffExperienceDetailService;
import in.jdsoft.educationmanagement.school.services.StaffService;
import in.jdsoft.educationmanagement.school.services.StaffTypeService;
import in.jdsoft.educationmanagement.school.services.UserRoleService;
import in.jdsoft.educationmanagement.school.services.UserService;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping(value={"/institution"})
public class InstitutionController {
    private Logger log = LogManager.getLogger((String)InstitutionController.class.getName());
    @Autowired
    InstitutionService institutionService;
    @Autowired
    GeographicalLocationService geographicallocationService;
    @Autowired
    CurrencyService currencyService;
    @Autowired
    FileUploadHandler fileUploadHandler;
    @Autowired
    UserService userService;
    @Autowired
    BloodGroupService bloodGroupService;
    @Autowired
    StaffTypeService staffTypeService;
    @Autowired
    StaffDesignationService staffDesignationService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    UserRoleService userRoleService;
    @Autowired
    HashGenerator hashGenerator;
    @Autowired
    StaffService staffService;
    @Autowired
    StaffExperienceDetailService staffExperienceDetailService;
    @Autowired
    StaffBankDetailService staffBankDetailService;
    @Autowired
    EmailHandler emailHandler;

    @RequestMapping(method={RequestMethod.GET}, value={"editinstitution"})
    @PreAuthorize(value="hasAuthority('editinstitution')")
    public ModelAndView displayInstitutionProfilePage(HttpServletRequest request) {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed Institution Profile page"));
            ModelAndView modelandview = new ModelAndView("editinstitution");
            Long instituteId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            modelandview.addObject("institutionDetails", (Object)this.institutionService.institutionById(instituteId));
            modelandview.addObject("geographicallocationList", this.geographicallocationService.countryList());
            modelandview.addObject("geographicallocationStateList", this.geographicallocationService.stateList());
            modelandview.addObject("geographicallocationCityList", this.geographicallocationService.cityList());
            modelandview.addObject("currencyList", this.currencyService.currencyList());
            return modelandview;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw null;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"manageinstitution"})
    @PreAuthorize(value="hasAuthority('manageinstitution')")
    public ModelAndView displayManageInstitutionPage(HttpServletRequest request) {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed Manage Institution page"));
            ModelAndView modelandview = new ModelAndView("manageinstitution");
            modelandview.addObject("institutionList", this.institutionService.institutionList());
            modelandview.addObject("geographicallocationList", this.geographicallocationService.countryList());
            modelandview.addObject("geographicallocationStateList", this.geographicallocationService.stateList());
            modelandview.addObject("geographicallocationCityList", this.geographicallocationService.cityList());
            modelandview.addObject("currencyList", this.currencyService.currencyList());
            modelandview.addObject("categories", this.categoryService.categoryList());
            modelandview.addObject("bloodGroups", this.bloodGroupService.bloodGroupList());
            return modelandview;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw null;
        }
    }

    @RequestMapping(value={"editinstitution/update"}, method={RequestMethod.POST})
    @PreAuthorize(value="hasAuthority('editinstitution/update')")
    public String updateInstitutionProfile(HttpServletRequest request, RedirectAttributes redirectAttributes, @RequestParam(value="institutionProfilePic") MultipartFile multipartFile, @RequestParam(value="institutionAuthorizedSignaturePic") MultipartFile institutionAuthorizedSignaturePic) throws Exception {
        try {
            Long institutionId = Long.parseLong(request.getParameter("updateInstitutionId"));
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " updating Institution with id=" + institutionId));
            String institutionName = request.getParameter("institutionName");
            String institutionLogo = "";
            String institutionEmail = request.getParameter("institutionEmail");
            String institutionContact = request.getParameter("institutionContact");
            String institutionAddressline1 = request.getParameter("institutionAddressLine1");
            String institutionAddressline2 = request.getParameter("institutionAddressLine2");
            String institutionCountry = request.getParameter("institutionCountry");
            String institutionState = request.getParameter("institutionState");
            String institutionCity = request.getParameter("institutionCity");
            String institutionPostcode = request.getParameter("institutionPostCode");
            String currencyCode = request.getParameter("institutionCurrencyCode");
            String institutionCode = request.getParameter("institutionCode");
            Integer institutionStatus = Integer.parseInt(request.getParameter("institutionStatus"));
            Integer intCollectReceiptsInOrder = Integer.parseInt(request.getParameter("collectReceiptsInOrder"));
            boolean collectReceiptsInOrder = intCollectReceiptsInOrder == 1;
            Institution institution = this.institutionService.institutionById(institutionId);
            institution.setInstitutionName(institutionName);
            if (multipartFile != null && !multipartFile.isEmpty()) {
                institutionLogo = this.fileUploadHandler.uploadFile(multipartFile.getBytes(), request.getRealPath("/"), "/resources/themes/images/institute-logo/", multipartFile.getOriginalFilename());
            }
            if (institutionLogo != "") {
                institution.setInstitutionLogo(institutionLogo);
            }
            String authorizedSignature = "";
            if (institutionAuthorizedSignaturePic != null && !institutionAuthorizedSignaturePic.isEmpty()) {
                authorizedSignature = this.fileUploadHandler.uploadFile(institutionAuthorizedSignaturePic.getBytes(), request.getRealPath("/"), "/resources/themes/images/institute-authorized-signature/", institutionAuthorizedSignaturePic.getOriginalFilename());
            }
            if (authorizedSignature != "") {
                institution.setAuthorizedSignature(authorizedSignature);
            }
            institution.setInstitutionEmail(institutionEmail);
            institution.setInstitutionContact(institutionContact);
            institution.setInstitutionAddressline1(institutionAddressline1);
            institution.setInstitutionAddressline2(institutionAddressline2);
            institution.setInstitutionCountry(institutionCountry);
            institution.setInstitutionState(institutionState);
            institution.setInstitutionCity(institutionCity);
            institution.setInstitutionPostcode(institutionPostcode);
            institution.setCurrencyCode(currencyCode);
            institution.setInstitutionStatus(institutionStatus);
            institution.setCollectReceiptsInOrder(collectReceiptsInOrder);
            institution.setInstitutionCode(institutionCode);
            this.institutionService.updateInstitution(institution);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Institution Details Updated Successfully...!"));
            return "redirect:/institution/editinstitution";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done...!"));
            e.printStackTrace();
            return "redirect:/institution/editinstitution";
        }
    }

    @RequestMapping(value={"manageinstitution/add"}, method={RequestMethod.POST})
    @PreAuthorize(value="hasAuthority('manageinstitution/add')")
    public String addNewInstitution(HttpServletRequest request, RedirectAttributes redirectAttributes, @RequestParam(value="institutionProfilePic") MultipartFile multipartFile, @RequestParam(value="staffProfilePic") MultipartFile staffProfilePic, @RequestParam(value="institutionAuthorizedSignaturePic") MultipartFile authorizedSignatureImage) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " trying to create Institution,default administrator user"));
            String institutionName = request.getParameter("institutionName");
            String institutionCode = request.getParameter("institutionCode");
            String institutionLogo = "";
            if (multipartFile != null && !multipartFile.isEmpty()) {
                institutionLogo = this.fileUploadHandler.uploadFile(multipartFile.getBytes(), request.getRealPath("/"), "/resources/themes/images/institute-logo/", multipartFile.getOriginalFilename());
            }
            if (institutionLogo == "") {
                institutionLogo = "/resources/themes/images/com.png";
            }
            String authorizedSignature = "";
            if (authorizedSignatureImage != null && !authorizedSignatureImage.isEmpty()) {
                authorizedSignature = this.fileUploadHandler.uploadFile(authorizedSignatureImage.getBytes(), request.getRealPath("/"), "/resources/themes/images/institute-authorized-signature/", authorizedSignatureImage.getOriginalFilename());
            }
            if (authorizedSignature == "") {
                authorizedSignature = "/resources/themes/images/profile-pic/a.png";
            }
            String institutionAliasName = "alias";
            String institutionEmail = request.getParameter("institutionEmail");
            String institutionContact = request.getParameter("institutionContact");
            String institutionAddressline1 = request.getParameter("institutionAddressLine1");
            String institutionAddressline2 = request.getParameter("institutionAddressLine2");
            String institutionCountry = request.getParameter("institutionCountry");
            String institutionState = request.getParameter("institutionState");
            String institutionCity = request.getParameter("institutionCity");
            String institutionPostcode = request.getParameter("institutionPostCode");
            Integer institutionStatus = Integer.parseInt(request.getParameter("institutionStatus"));
            String currencyCode = request.getParameter("institutionCurrencyCode");
            Integer intCollectReceiptsInOrder = Integer.parseInt(request.getParameter("collectReceiptsInOrder"));
            boolean collectReceiptsInOrder = intCollectReceiptsInOrder == 1;
            Institution institution = new Institution(institutionName, institutionCode, institutionAliasName, institutionAddressline1, institutionAddressline2, institutionCountry, institutionState, institutionCity, institutionContact, institutionEmail, institutionLogo, institutionPostcode, currencyCode, institutionStatus, collectReceiptsInOrder, authorizedSignature);
            StaffType staffType = this.staffTypeService.staffTypeById(2L);
            StaffDesignation staffDesignation = new StaffDesignation("Administrator", "default", staffType, institution);
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String staffCode = request.getParameter("staffCode");
            String firstName = request.getParameter("staffFirstName");
            String lastName = request.getParameter("staffLastName");
            String gender = request.getParameter("staffGender");
            Date dateOfBirth = null;
            if (request.getParameter("staffDOB") != null) {
                dateOfBirth = formatter.parse(request.getParameter("staffDOB"));
            }
            String contact = request.getParameter("staffContact");
            String email = request.getParameter("staffEmail");
            String accessNo = request.getParameter("staffAccessId");
            String parentOrGuardianFirstName = request.getParameter("staffParentOrGuardianFirstName");
            String parentOrGuardianLastName = request.getParameter("staffParentOrGuardianLastName");
            String staffAddressLine1 = request.getParameter("staffAddressLine1");
            String staffAddressLine2 = request.getParameter("staffAddressLine2");
            String country = request.getParameter("staffCountry");
            String state = request.getParameter("staffState");
            String city = request.getParameter("staffCity");
            String postCode = request.getParameter("staffPostCode");
            String staffPANNumber = request.getParameter("staffPANNo");
            String staffPFNumber = request.getParameter("staffPFAccountNo");
            Date joinedDate = null;
            if (request.getParameter("staffJoinedDate") != null && !request.getParameter("staffJoinedDate").isEmpty() && request.getParameter("staffJoinedDate") != "") {
                joinedDate = formatter.parse(request.getParameter("staffJoinedDate"));
            }
            String createdBy = "default";
            Integer status = Integer.parseInt(request.getParameter("userStatus"));
            BloodGroup bloodGroup = null;
            if (request.getParameter("staffBloodGroupId") != null) {
                Long bloodGroupId = Long.parseLong(request.getParameter("staffBloodGroupId"));
                bloodGroup = this.bloodGroupService.bloodGroupById(bloodGroupId);
            }
            String password = request.getParameter("adminPassword");
            String profilePath = "";
            if (staffProfilePic != null && !staffProfilePic.isEmpty()) {
                profilePath = this.fileUploadHandler.uploadFile(staffProfilePic.getBytes(), request.getRealPath("/"), "/resources/themes/images/staff-profile/", staffProfilePic.getOriginalFilename());
            }
            if (profilePath == "") {
                profilePath = "/resources/themes/images/profile-pic/a.png";
            }
            String hash = this.hashGenerator.encoder(password);
            User user = new User(null, String.valueOf(firstName) + " " + lastName, email, password, createdBy, status, hash, profilePath, institution);
            Category category = null;
            if (request.getParameter("categoryId") != null) {
                Long categoryId = Long.parseLong(request.getParameter("categoryId"));
                category = this.categoryService.categoryById(categoryId);
            }
            Staff staff = new Staff(staffCode, firstName, lastName, gender, dateOfBirth, contact, email, accessNo, parentOrGuardianFirstName, parentOrGuardianLastName, staffAddressLine1, staffAddressLine2, country, state, city, postCode, staffPANNumber, staffPFNumber, joinedDate, createdBy, status, bloodGroup, user, user, institution, staffType, staffDesignation, category);
            HashSet<StaffExperienceDetail> staffExperiences = new HashSet<StaffExperienceDetail>();
            String[] experiences = request.getParameterValues("staffExperienceIdArray");
            if (experiences != null) {
                String[] stringArray = experiences;
                int n = experiences.length;
                int n2 = 0;
                while (n2 < n) {
                    String experienceId = stringArray[n2];
                    String[] splitexperiences = experienceId.split("/");
                    splitexperiences = (String[])Arrays.stream(splitexperiences).filter(s -> s != null && s.length() > 0).toArray(String[]::new);
                    int i = 0;
                    while (i < splitexperiences.length) {
                        String[] experience = splitexperiences[i].split(",");
                        experience = (String[])Arrays.stream(experience).filter(s -> s != null && s.length() > 0).toArray(String[]::new);
                        int j = 0;
                        while (j < experience.length) {
                            String[] workedOrganisation;
                            if (experience[j].contains("organizationName") && (workedOrganisation = experience[j].split("-")).length <= 1) {
                                String currentworkedOrganisation = request.getParameter(experience[0].toString());
                                Double inPreviousExperience = Double.parseDouble(request.getParameter(experience[1].toString()));
                                Date startDate = formatter.parse(request.getParameter(experience[2].toString()));
                                Date endDate = formatter.parse(request.getParameter(experience[3].toString()));
                                String staffPreviousDesignation = request.getParameter(experience[4].toString());
                                StaffExperienceDetail staffExperience = new StaffExperienceDetail(currentworkedOrganisation, startDate, endDate, staffPreviousDesignation, inPreviousExperience, createdBy);
                                staffExperience.setStaff(staff);
                                staffExperiences.add(staffExperience);
                            }
                            ++j;
                        }
                        ++i;
                    }
                    ++n2;
                }
            }
            String bankName = request.getParameter("staffBankName");
            String bankAccountNo = request.getParameter("staffBankAccountNo");
            String bankIFSCCode = request.getParameter("staffBankIFSC");
            StaffBankDetail staffBankDetail = new StaffBankDetail(bankName, bankAccountNo, bankIFSCCode, createdBy);
            this.institutionService.institutionWithAdmin(institution, staff, staffExperiences, staffBankDetail);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Institution Created Successfully...!"));
            return "redirect:/institution/manageinstitution";
        }
        catch (Exception e) {
            if (e.getClass().equals(InstitutionException.class)) {
                InstitutionException ex = (InstitutionException)e;
                redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", ex.getMessage()));
                return "redirect:/institution/manageinstitution";
            }
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Created...!"));
            e.printStackTrace();
            return "redirect:/institution/manageinstitution";
        }
    }

    @RequestMapping(value={"manageinstitution/retrieveinstitution"}, method={RequestMethod.GET})
    @ResponseBody
    @PreAuthorize(value="hasAuthority('manageinstitution/view')")
    public Institution retrieveInstitute(HttpServletRequest request) {
        try {
            Long instituteId = Long.parseLong(request.getParameter("institutionId"));
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " retrieving Institution,User with id=" + instituteId));
            Institution institution = this.institutionService.institutionByUserRoleAdmin(instituteId);
            return institution;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"manageinstitution/delete"}, method={RequestMethod.POST})
    @PreAuthorize(value="hasAuthority('manageinstitution/delete')")
    public String deleteInstitute(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            Long currentinstituteId = Long.parseLong(request.getParameter("deleteInstitutionId"));
            Long instituteId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            this.log.info((Object)("User " + request.getSession().getAttribute("username") + " deleting Institution,User with id=" + currentinstituteId));
            if (instituteId == currentinstituteId) {
                throw new Exception("Cannot Be Deleted");
            }
            this.institutionService.deleteInstitution(currentinstituteId);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Institution Deleted Successfully...!"));
            return "redirect:/institution/manageinstitution";
        }
        catch (Exception e) {
            if (e.getClass().equals(DataIntegrityViolationException.class)) {
                redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Deleted...!"));
                return "redirect:/institution/manageinstitution";
            }
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Deleted...!"));
            return "redirect:/institution/manageinstitution";
        }
    }

    @RequestMapping(value={"manageinstitution/update"}, method={RequestMethod.POST})
    @PreAuthorize(value="hasAuthority('manageinstitution/update')")
    public String updateInstitution(HttpServletRequest request, @RequestParam(value="editInstitutionProfilePic") MultipartFile multipartFile, @RequestParam(value="editStaffProfilePic") MultipartFile staffProfilePic, RedirectAttributes redirectAttributes, @RequestParam(value="editInstitutionAuthorizedSignaturePic") MultipartFile authorizedSignatureImage) throws Exception {
        try {
            Long institutionId = Long.parseLong(request.getParameter("updateInstitutionId"));
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " updating Institution,User with id=" + institutionId));
            String institutionName = request.getParameter("editInstitutionName");
            String institutionCode = request.getParameter("editInstitutionCode");
            String institutionLogo = "";
            String institutionEmail = request.getParameter("editInstitutionEmail");
            String institutionContact = request.getParameter("editInstitutionContact");
            String institutionAddressline1 = request.getParameter("editInstitutionAddressLine1");
            String institutionAddressline2 = request.getParameter("editInstitutionAddressLine2");
            String institutionCountry = request.getParameter("editInstitutionCountry");
            String institutionState = request.getParameter("editInstitutionState");
            String institutionCity = request.getParameter("editInstitutionCity");
            String institutionPostcode = request.getParameter("editInstitutionPostCode");
            String currencyCode = request.getParameter("editCurrencyCode");
            Integer institutionStatus = Integer.parseInt(request.getParameter("editInstitutionStatus"));
            Integer intCollectReceiptsInOrder = Integer.parseInt(request.getParameter("editCollectReceiptsInOrder"));
            boolean collectReceiptsInOrder = intCollectReceiptsInOrder == 1;
            Institution institution = this.institutionService.institutionById(institutionId);
            institution.setInstitutionName(institutionName);
            institution.setInstitutionCode(institutionCode);
            if (multipartFile != null && !multipartFile.isEmpty()) {
                institutionLogo = this.fileUploadHandler.uploadFile(multipartFile.getBytes(), request.getRealPath("/"), "/resources/themes/images/institute-logo/", multipartFile.getOriginalFilename());
            }
            if (institutionLogo != "") {
                institution.setInstitutionLogo(institutionLogo);
            }
            String authorizedSignature = "";
            if (authorizedSignatureImage != null && !authorizedSignatureImage.isEmpty()) {
                authorizedSignature = this.fileUploadHandler.uploadFile(authorizedSignatureImage.getBytes(), request.getRealPath("/"), "/resources/themes/images/institute-authorized-signature/", authorizedSignatureImage.getOriginalFilename());
            }
            if (authorizedSignature != "") {
                institution.setAuthorizedSignature(authorizedSignature);
            }
            institution.setInstitutionEmail(institutionEmail);
            institution.setInstitutionContact(institutionContact);
            institution.setInstitutionAddressline1(institutionAddressline1);
            institution.setInstitutionAddressline2(institutionAddressline2);
            institution.setInstitutionCountry(institutionCountry);
            institution.setInstitutionState(institutionState);
            institution.setInstitutionCity(institutionCity);
            institution.setInstitutionPostcode(institutionPostcode);
            institution.setCurrencyCode(currencyCode);
            institution.setInstitutionStatus(institutionStatus);
            institution.setCollectReceiptsInOrder(collectReceiptsInOrder);
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Long staffId = Long.parseLong(request.getParameter("updateStaffId"));
            String staffCode = request.getParameter("editStaffCode");
            String firstName = request.getParameter("editStaffFirstName");
            String lastName = request.getParameter("editStaffLastName");
            String gender = request.getParameter("editStaffGender");
            Date dateOfBirth = formatter.parse(request.getParameter("editStaffDOB"));
            String contact = request.getParameter("editStaffContact");
            String eMail = request.getParameter("editStaffEmail");
            String accessNo = request.getParameter("editStaffAccessId");
            String parentOrGuardianFirstName = request.getParameter("editStaffParentOrGuardianFirstName");
            String parentOrGuardianLastName = request.getParameter("editStaffParentOrGuardianLastName");
            String staffAddressLine1 = request.getParameter("editStaffAddressLine1");
            String staffAddressLine2 = request.getParameter("editStaffAddressLine2");
            String country = request.getParameter("editStaffCountry");
            String state = request.getParameter("editStaffState");
            String city = request.getParameter("editStaffCity");
            String postCode = request.getParameter("editStaffPostCode");
            String staffPANNumber = request.getParameter("editStaffPANNo");
            String staffPFNumber = request.getParameter("editStaffPFAccountNo");
            Date joinedDate = null;
            if (request.getParameter("editStaffJoinedDate") != null && !request.getParameter("editStaffJoinedDate").isEmpty() && request.getParameter("editStaffJoinedDate") != "") {
                joinedDate = formatter.parse(request.getParameter("editStaffJoinedDate"));
            }
            Integer status = Integer.parseInt(request.getParameter("editStaffStatus"));
            String modifiedBy = request.getSession().getAttribute("username").toString();
            Long categoryId = Long.parseLong(request.getParameter("editCategoryId"));
            Category category = this.categoryService.categoryById(categoryId);
            Staff staff = this.staffService.staffByIdEager(staffId);
            BloodGroup bloodGroup = null;
            if (request.getParameter("editStaffBloodGroupId") != null) {
                bloodGroup = this.bloodGroupService.bloodGroupById(Long.parseLong(request.getParameter("editStaffBloodGroupId")));
            }
            staff.setFirstName(firstName);
            staff.setLastName(lastName);
            staff.setParentOrGuardianFirstName(parentOrGuardianFirstName);
            staff.setParentOrGuardianLastName(parentOrGuardianLastName);
            staff.setGender(gender);
            staff.setDateOfBirth(dateOfBirth);
            staff.setEmail(eMail);
            staff.setContact(contact);
            staff.setStaffAddressLine1(staffAddressLine1);
            staff.setStaffAddressLine2(staffAddressLine2);
            staff.setCountry(country);
            staff.setState(state);
            staff.setCity(city);
            staff.setPostCode(postCode);
            staff.setStaffPANNumber(staffPANNumber);
            staff.setStaffPFNumber(staffPFNumber);
            staff.setBloodGroup(bloodGroup);
            staff.setModifiedBy(modifiedBy);
            staff.setStaffCode(staffCode);
            staff.setAccessNo(accessNo);
            staff.setJoinedDate(joinedDate);
            staff.setStatus(status);
            staff.setCategory(category);
            Long staffBankDetailId = Long.parseLong(request.getParameter("updateStaffBankDetailId"));
            String bankName = request.getParameter("editStaffBankName");
            String bankAccountNo = request.getParameter("editStaffBankAccountNo");
            String bankIFSCCode = request.getParameter("editStaffBankIFSC");
            StaffBankDetail staffBankDetail = this.staffBankDetailService.staffBankDetailById(staffBankDetailId);
            staffBankDetail.setBankName(bankName);
            staffBankDetail.setBankAccountNo(bankAccountNo);
            staffBankDetail.setBankIFSCCode(bankIFSCCode);
            staffBankDetail.setStaff(staff);
            LinkedHashSet<StaffExperienceDetail> staffExperiences = new LinkedHashSet<StaffExperienceDetail>();
            String[] experiences = request.getParameterValues("editStaffExperienceIdArray");
            if (experiences != null) {
                String[] stringArray = experiences;
                int n = experiences.length;
                int n2 = 0;
                while (n2 < n) {
                    String experienceId = stringArray[n2];
                    String[] splitexperiences = experienceId.split("/");
                    splitexperiences = (String[])Arrays.stream(splitexperiences).filter(s -> s != null && s.length() > 0).toArray(String[]::new);
                    int i = 0;
                    while (i < splitexperiences.length) {
                        String[] experience = splitexperiences[i].split(",");
                        experience = (String[])Arrays.stream(experience).filter(s -> s != null && s.length() > 0).toArray(String[]::new);
                        int j = 0;
                        while (j < experience.length) {
                            if (experience[j].contains("editOrganizationName")) {
                                String[] workedOrganisation = experience[j].split("-");
                                if (workedOrganisation.length > 1) {
                                    Long staffExperienceDetailId = Long.parseLong(workedOrganisation[1].toString());
                                    String currentworkedOrganisation = request.getParameter(experience[0].toString());
                                    Double inPreviousExperience = Double.parseDouble(request.getParameter(experience[1].toString()));
                                    Date startDate = formatter.parse(request.getParameter(experience[2].toString()));
                                    Date endDate = formatter.parse(request.getParameter(experience[3].toString()));
                                    String staffPreviousDesignation = request.getParameter(experience[4].toString());
                                    StaffExperienceDetail staffExperience = this.staffExperienceDetailService.staffExperienceDetailById(staffExperienceDetailId);
                                    staffExperience.setWorkedOrganisation(currentworkedOrganisation);
                                    staffExperience.setInPreviousExperience(inPreviousExperience);
                                    staffExperience.setStartDate(startDate);
                                    staffExperience.setEndDate(endDate);
                                    staffExperience.setStaffPreviousDesignation(staffPreviousDesignation);
                                    staffExperience.setStaff(staff);
                                    staffExperiences.add(staffExperience);
                                } else {
                                    String currentworkedOrganisation = request.getParameter(experience[0].toString());
                                    Double inPreviousExperience = Double.parseDouble(request.getParameter(experience[1].toString()));
                                    Date startDate = formatter.parse(request.getParameter(experience[2].toString()));
                                    Date endDate = formatter.parse(request.getParameter(experience[3].toString()));
                                    String staffPreviousDesignation = request.getParameter(experience[4].toString());
                                    StaffExperienceDetail staffExperience = new StaffExperienceDetail(currentworkedOrganisation, startDate, endDate, staffPreviousDesignation, inPreviousExperience, modifiedBy);
                                    staffExperience.setStaff(staff);
                                    staffExperiences.add(staffExperience);
                                }
                            }
                            ++j;
                        }
                        ++i;
                    }
                    ++n2;
                }
            }
            String password = request.getParameter("editAdminPassword");
            String profilePath = "";
            Long userId = Long.parseLong(request.getParameter("updateUserId"));
            User user = this.userService.userById(userId);
            if (staffProfilePic != null && !staffProfilePic.isEmpty()) {
                profilePath = this.fileUploadHandler.uploadFile(staffProfilePic.getBytes(), request.getRealPath("/"), "/resources/themes/images/staff-profile/", staffProfilePic.getOriginalFilename());
            }
            if (profilePath != "") {
                user.setProfilePicturePath(profilePath);
            }
            user.setName(String.valueOf(firstName) + " " + lastName);
            user.setPassword(password);
            String hash = this.hashGenerator.encoder(password);
            user.setPassword(password);
            user.setEmail(eMail);
            user.setModifiedBy(modifiedBy);
            user.setHash(hash);
            user.setStaff(staff);
            user.setModifiedDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
            staff.setUser(user);
            staff.setStaffBankDetail(staffBankDetail);
            this.institutionService.updateInstitutionWithAdmin(institution, staff, staffExperiences);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Institution Updated Successfully...!"));
            return "redirect:/institution/manageinstitution";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Updated...!"));
            e.printStackTrace();
            throw e;
        }
    }

    @RequestMapping(value={"ledgerAccounts"})
    public ModelAndView displayInstitutionLedgerAccountPage(HttpServletRequest request) {
        try {
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            ModelAndView modelandview = new ModelAndView("institutionLedgerAccount");
            modelandview.addObject("institutionAccountsList", this.institutionService.ledgerAccountListByInstitution(institutionId));
            return modelandview;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"ledgerAccount/add"}, method={RequestMethod.POST})
    public String addNewLedgerAccount(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            String ledgerAccountName = request.getParameter("ledgerAccountName");
            String ledgerAccountReferenceNo = request.getParameter("ledgerAccountReferenceNo");
            Long instituteId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            Institution institution = this.institutionService.institutionById(instituteId);
            InstituteLedgerAccount ledgerAccount = new InstituteLedgerAccount(ledgerAccountName, ledgerAccountReferenceNo, institution);
            this.institutionService.addInstituteLedgerAccount(ledgerAccount);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Ledger Account Created Successfully...!"));
            return "redirect:/institution/ledgerAccounts";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Created...!"));
            e.printStackTrace();
            return "redirect:/institution/ledgerAccounts";
        }
    }

    @RequestMapping(value={"ledgerAccount/editReterive"}, method={RequestMethod.GET})
    @ResponseBody
    public InstituteLedgerAccount editLedgerAccountReterive(HttpServletRequest request) {
        try {
            Long ledgerAccountId = Long.parseLong(request.getParameter("ledgerAccountId"));
            return this.institutionService.ledgerAccountById(ledgerAccountId);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"ledgerAccount/ledgerAccountName"}, method={RequestMethod.GET})
    @ResponseBody
    public ArrayList<SixFieldReports> getLedgerAccountByName(HttpServletRequest request) {
        try {
            String ledgerAccountName = request.getParameter("ledgerAccountName");
            Long instituteId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            String category = request.getParameter("category");
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Long paymentStatus = 3L;
            if (category.equals("specificinvoice")) {
                Date fromDate = formatter.parse(request.getParameter("fromDate"));
                Date toDate = formatter.parse(request.getParameter("toDate"));
                return this.institutionService.getInstitutionLedgerAccountListByInvoice(ledgerAccountName, instituteId, fromDate, toDate, paymentStatus);
            }
            if (category.equals("specificreceipt")) {
                Date fromDate = formatter.parse(request.getParameter("fromDate"));
                Date toDate = formatter.parse(request.getParameter("toDate"));
                return this.institutionService.getInstitutionLedgerAccountListByReceipt(ledgerAccountName, instituteId, fromDate, toDate, paymentStatus);
            }
            return this.institutionService.getInstitutionLedgerAccountListByNameEager(ledgerAccountName, instituteId, paymentStatus);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"ledgerAccount/ledgerAccountNameWithoutTax"}, method={RequestMethod.GET})
    @ResponseBody
    public ArrayList<NineFieldReports> getLedgerAccountByNameWithoutTax(HttpServletRequest request) {
        try {
            String ledgerAccountName = request.getParameter("ledgerAccountName");
            Long instituteId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            String category = request.getParameter("category");
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Long paymentStatus = 3L;
            if (category.equals("specificinvoice")) {
                Date fromDate = formatter.parse(request.getParameter("fromDate"));
                Date toDate = formatter.parse(request.getParameter("toDate"));
                return this.institutionService.getInstitutionLedgerAccountListByInvoiceWithoutTAX(ledgerAccountName, instituteId, fromDate, toDate, paymentStatus);
            }
            if (category.equals("specificreceipt")) {
                Date fromDate = formatter.parse(request.getParameter("fromDate"));
                Date toDate = formatter.parse(request.getParameter("toDate"));
                return this.institutionService.getInstitutionLedgerAccountListByReceiptWithoutTAX(ledgerAccountName, instituteId, fromDate, toDate, paymentStatus);
            }
            return this.institutionService.getInstitutionLedgerAccountListByNameEagerWithoutTAX(ledgerAccountName, instituteId, paymentStatus);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"ledgerAccount/ledgerAccountNameAndAcademicYear"}, method={RequestMethod.GET})
    @ResponseBody
    public ArrayList<SixFieldReports> getLedgerAccountByNameAndAcademicYear(HttpServletRequest request) {
        try {
            String ledgerAccountName = request.getParameter("ledgerAccountName");
            Long instituteId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            Long paymentStatus = 3L;
            if (request.getParameter("category") != "") {
                Long academicYearId = Long.parseLong(request.getParameter("category"));
                if (academicYearId == 0L) {
                    return this.institutionService.getInstitutionLedgerAccountListByNameEager(ledgerAccountName, instituteId, paymentStatus);
                }
                return this.institutionService.getInstitutionLedgerAccountDetailsByAcademicYear(academicYearId, instituteId, ledgerAccountName, paymentStatus);
            }
            return this.institutionService.getCurrentAcademicYearLedgerAccountDetailsByInstitution(instituteId, ledgerAccountName, paymentStatus);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"ledgerAccount/ledgerAccountNameAndAcademicYearWithoutTax"}, method={RequestMethod.GET})
    @ResponseBody
    public ArrayList<NineFieldReports> getLedgerAccountByNameAndAcademicYearWithoutTax(HttpServletRequest request) {
        try {
            String ledgerAccountName = request.getParameter("ledgerAccountName");
            Long instituteId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            Long paymentStatus = 3L;
            if (request.getParameter("category") != "") {
                Long academicYearId = Long.parseLong(request.getParameter("category"));
                if (academicYearId == 0L) {
                    return this.institutionService.getInstitutionLedgerAccountListByNameEagerWithoutTAX(ledgerAccountName, instituteId, paymentStatus);
                }
                return this.institutionService.getInstitutionLedgerAccountDetailsByAcademicYearWithoutTAX(academicYearId, instituteId, ledgerAccountName, paymentStatus);
            }
            return this.institutionService.getCurrentAcademicYearLedgerAccountDetailsByInstitutionWithoutTAX(instituteId, ledgerAccountName, paymentStatus);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"ledgerAccount/editUpdate"}, method={RequestMethod.POST})
    @ResponseStatus(value=HttpStatus.OK)
    public String editLedgerAccountUpdate(HttpServletRequest request, HttpServletRequest response, RedirectAttributes redirectAttributes) throws Exception {
        try {
            Long ledgerAccountId = Long.parseLong(request.getParameter("updateLedgerId"));
            String editLedgerAccountReferenceNo = request.getParameter("editLedgerAccountReferenceNo");
            String editLedgerAccountName = request.getParameter("editLedgerAccountName");
            InstituteLedgerAccount ledgerAccount = this.institutionService.ledgerAccountById(ledgerAccountId);
            ledgerAccount.setLedgerAccountName(editLedgerAccountName);
            ledgerAccount.setLedgerReferenceNo(editLedgerAccountReferenceNo);
            this.institutionService.updateLedgerAccount(ledgerAccount);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Ledger Account Updated Successfully...!"));
            return "redirect:/institution/ledgerAccounts";
        }
        catch (DataIntegrityViolationException e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Updated...!"));
            e.printStackTrace();
            return "redirect:/institution/ledgerAccounts";
        }
    }

    @RequestMapping(value={"ledgerAccount/delete"}, method={RequestMethod.POST})
    public String deleteLedgerAccount(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            Long ledgerAccountId = Long.parseLong(request.getParameter("deleteLedgerId"));
            this.institutionService.deleteLedgerAccount(ledgerAccountId);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Ledger Account Deleted Successfully...!"));
            return "redirect:/institution/ledgerAccounts";
        }
        catch (DataIntegrityViolationException e) {
            if (((Object)((Object)e)).getClass().equals(DataIntegrityViolationException.class)) {
                Throwable cause = e.getCause();
                if (cause.getClass().equals(ConstraintViolationException.class)) {
                    redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Ledger Account in use cannot be deleted"));
                    return "redirect:/institution/ledgerAccounts";
                }
                redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Deleted...!"));
                e.printStackTrace();
                return "redirect:/institution/ledgerAccounts";
            }
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Deleted...!"));
            e.printStackTrace();
            return "redirect:/institution/ledgerAccounts";
        }
    }
}
