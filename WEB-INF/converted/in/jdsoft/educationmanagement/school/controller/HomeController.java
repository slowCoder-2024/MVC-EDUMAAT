/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Controller
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RequestMethod
 *  org.springframework.web.bind.annotation.RequestParam
 *  org.springframework.web.multipart.MultipartFile
 *  org.springframework.web.servlet.ModelAndView
 */
package in.jdsoft.educationmanagement.school.controller;

import in.jdsoft.educationmanagement.school.components.FileUploadHandler;
import in.jdsoft.educationmanagement.school.components.HashGenerator;
import in.jdsoft.educationmanagement.school.components.SystemDetails;
import in.jdsoft.educationmanagement.school.model.BloodGroup;
import in.jdsoft.educationmanagement.school.model.Category;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.InstitutionConfigDetails;
import in.jdsoft.educationmanagement.school.model.License;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.Staff;
import in.jdsoft.educationmanagement.school.model.StaffBankDetail;
import in.jdsoft.educationmanagement.school.model.StaffDesignation;
import in.jdsoft.educationmanagement.school.model.StaffExperienceDetail;
import in.jdsoft.educationmanagement.school.model.StaffType;
import in.jdsoft.educationmanagement.school.model.Student;
import in.jdsoft.educationmanagement.school.model.User;
import in.jdsoft.educationmanagement.school.model.UserRole;
import in.jdsoft.educationmanagement.school.services.AcademicYearService;
import in.jdsoft.educationmanagement.school.services.BloodGroupService;
import in.jdsoft.educationmanagement.school.services.CategoryService;
import in.jdsoft.educationmanagement.school.services.ClassService;
import in.jdsoft.educationmanagement.school.services.CurrencyService;
import in.jdsoft.educationmanagement.school.services.GeographicalLocationService;
import in.jdsoft.educationmanagement.school.services.InstitutionService;
import in.jdsoft.educationmanagement.school.services.LicenseService;
import in.jdsoft.educationmanagement.school.services.SpecialCategoryService;
import in.jdsoft.educationmanagement.school.services.StaffDesignationService;
import in.jdsoft.educationmanagement.school.services.StaffService;
import in.jdsoft.educationmanagement.school.services.StaffTypeService;
import in.jdsoft.educationmanagement.school.services.StudentAttendanceService;
import in.jdsoft.educationmanagement.school.services.StudentService;
import in.jdsoft.educationmanagement.school.services.SubstituteTimeTableGeneratorService;
import in.jdsoft.educationmanagement.school.services.UserRoleService;
import in.jdsoft.educationmanagement.school.services.UserService;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller(value="homeController")
public class HomeController {
    @Autowired
    InstitutionService institutionServices;
    @Autowired
    GeographicalLocationService geoGraphicalService;
    @Autowired
    CurrencyService currencyService;
    @Autowired
    FileUploadHandler fileUploadHandler;
    @Autowired
    BloodGroupService bloodGroupService;
    @Autowired
    UserService userService;
    @Autowired
    InstitutionService institutionService;
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
    StudentService studentService;
    @Autowired
    StaffService staffService;
    @Autowired
    SpecialCategoryService specialCategoryService;
    @Autowired
    ClassService classService;
    @Autowired
    AcademicYearService academicYearService;
    @Autowired
    LicenseService licenseService;
    @Autowired
    StudentAttendanceService studentAttendanceService;
    @Autowired
    SubstituteTimeTableGeneratorService substituteTimeTableGeneratorService;

    @RequestMapping(value={"/403"}, method={RequestMethod.GET})
    public ModelAndView accesssDenied(Principal user, HttpServletRequest request) {
        try {
            ModelAndView model = new ModelAndView();
            model.setViewName("403");
            String name = request.getSession().getAttribute("name").toString();
            model.addObject("denied", (Object)"Access Denied");
            model.addObject("message", (Object)("Sorry !! " + name + " you are trying to access the resource which you have not given permission.Please contact admin"));
            return model;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @RequestMapping(value={"/404"}, method={RequestMethod.GET})
    public ModelAndView pageNotFound(HttpServletRequest request) {
        try {
            ModelAndView model = new ModelAndView();
            model.setViewName("404");
            return model;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @RequestMapping(value={"/home"})
    public ModelAndView home(HttpServletRequest request) {
        try {
            ModelAndView modelandview = new ModelAndView("institutiondashboard");
            SimpleDateFormat dateformatter = new SimpleDateFormat("yyyy-MM-dd");
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            modelandview.addObject("specialCategoryList", this.specialCategoryService.specialCategoryList(institutionId));
            modelandview.addObject("categories", this.categoryService.categoryList());
            modelandview.addObject("institutionList", this.institutionService.institutionList());
            modelandview.addObject("bloodGroupList", this.bloodGroupService.bloodGroupList());
            modelandview.addObject("classList", this.classService.classListEager(institutionId));
            modelandview.addObject("academicYearList", this.academicYearService.academicYearList());
            modelandview.addObject("institutionId", (Object)institutionId);
            if (request.getSession().getAttribute("username").toString() != null && request.getSession().getAttribute("username").toString() != "") {
                String eMail = request.getSession().getAttribute("username").toString();
                User user = this.userService.userByEmailEager(eMail);
                boolean feesAdmin = false;
                boolean InventoryandAssetAdmin = false;
                boolean admissionCandidate = false;
                boolean superadmin = false;
                boolean checkstaff = false;
                boolean checkparent = false;
                boolean checkstudent = false;
                for (UserRole userRoles : user.getUserRoles()) {
                    if (userRoles.getRoleName().equals("AdmissionCandidate")) {
                        admissionCandidate = true;
                    }
                    if (userRoles.getRoleName().equals("FeesAdmin")) {
                        feesAdmin = true;
                    }
                    if (userRoles.getRoleName().equals("InventoryandAssetAdmin")) {
                        InventoryandAssetAdmin = true;
                    }
                    if (userRoles.getRoleName().equals("SuperAdministrator")) {
                        superadmin = true;
                    }
                    if (userRoles.getRoleName().equals("Staff")) {
                        checkstaff = true;
                    }
                    if (userRoles.getRoleName().equals("Student")) {
                        checkstudent = true;
                    }
                    if (!userRoles.getRoleName().equals("Parent")) continue;
                    checkparent = true;
                }
                Date now = new Date();
                if (!superadmin) {
                    modelandview = new ModelAndView("cockpit");
                    modelandview.addObject("specialCategoryList", this.specialCategoryService.specialCategoryList(institutionId));
                    modelandview.addObject("categories", this.categoryService.categoryList());
                    modelandview.addObject("institutionList", this.institutionService.institutionList());
                    modelandview.addObject("bloodGroupList", this.bloodGroupService.bloodGroupList());
                    modelandview.addObject("classList", this.classService.classListEager(institutionId));
                    modelandview.addObject("academicYearList", this.academicYearService.academicYearList());
                }
                if (checkstaff) {
                    modelandview = new ModelAndView("staffcockpit");
                    modelandview.addObject("academicYearList", this.academicYearService.academicYearList());
                    Staff staff = this.staffService.staffByEmailEager(eMail);
                    if (staff != null) {
                        SimpleDateFormat simpleDateformat = new SimpleDateFormat("EEEE");
                        modelandview.addObject("staffClassSectionModules", staff.getStaffClassSectionModules());
                        modelandview.addObject("staff", (Object)this.staffService.staffByEmailEager(eMail));
                        modelandview.addObject("dayName", (Object)simpleDateformat.format(now));
                        modelandview.addObject("substituteTimeTableGeneratorList", this.substituteTimeTableGeneratorService.substituteTimeTableGeneratorListByStaffAndDateEager(staff, dateformatter.parse(dateformatter.format(now))));
                    }
                }
                if (checkstudent) {
                    modelandview = new ModelAndView("studentcockpit");
                    modelandview.addObject("academicYearList", this.academicYearService.academicYearList());
                    Student student = this.studentService.studentByEmailEager(eMail);
                    if (student != null) {
                        modelandview.addObject("student", (Object)student);
                        modelandview.addObject("substituteTimeTableGeneratorList", this.substituteTimeTableGeneratorService.substituteTimeTableGeneratorListByClassAndSectionAndDateEager(student.getStudentClass().getClassId(), student.getSection().getSectionId(), dateformatter.parse(dateformatter.format(now))));
                    }
                }
                if (checkparent) {
                    modelandview = new ModelAndView("parentcockpit");
                    modelandview.addObject("academicYearList", this.academicYearService.academicYearList());
                    Student studentparent = this.studentService.studentByParentEmailEager(eMail);
                    if (studentparent != null) {
                        modelandview.addObject("student", (Object)studentparent);
                        modelandview.addObject("substituteTimeTableGeneratorList", this.substituteTimeTableGeneratorService.substituteTimeTableGeneratorListByClassAndSectionAndDateEager(studentparent.getStudentClass().getClassId(), studentparent.getSection().getSectionId(), dateformatter.parse(dateformatter.format(now))));
                    }
                }
                if (admissionCandidate) {
                    modelandview = new ModelAndView("admissioncandidatecockpit");
                }
                if (feesAdmin) {
                    modelandview = new ModelAndView("feescockpit");
                }
                if (InventoryandAssetAdmin) {
                    modelandview = new ModelAndView("inventorycharts");
                }
            }
            return modelandview;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw null;
        }
    }

    @RequestMapping(value={"/loginpage", "/"}, method={RequestMethod.GET})
    public ModelAndView login(@RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout) {
        ModelAndView model = new ModelAndView();
        List<Institution> institutions = this.institutionServices.institutionList();
        String ipAddress = SystemDetails.getIPAddress();
        String macAddress = SystemDetails.getMACAddress();
        License license = this.licenseService.license("fIPCHhEycFewY6ZJocHokQ==");
        if (institutions.isEmpty()) {
            model.addObject("geographicallocationList", this.geoGraphicalService.countryList());
            model.addObject("currencies", this.currencyService.currencyList());
            model.addObject("categories", this.categoryService.categoryList());
            model.addObject("bloodGroups", this.bloodGroupService.bloodGroupList());
            model.addObject("institutionList", this.institutionServices.institutionList());
            model.setViewName("install");
            return model;
        }
        if (!license.getmACAddress().equals(macAddress) && !license.getIpAddress().equals(ipAddress)) {
            model.addObject("geographicallocationList", this.geoGraphicalService.countryList());
            model.addObject("currencies", this.currencyService.currencyList());
            model.addObject("categories", this.categoryService.categoryList());
            model.addObject("bloodGroups", this.bloodGroupService.bloodGroupList());
            model.addObject("institutionList", this.institutionServices.institutionList());
            model.setViewName("install");
            model.addObject("message", (Object)new Message("failed", "Authentication Failed..."));
            return model;
        }
        if (error != null) {
            model.addObject("message", (Object)new Message("failed", "Invalid username and password!"));
        }
        if (logout != null) {
            model.addObject("message", (Object)new Message("success", "You've been logged out successfully"));
        }
        model.addObject("institutionList", this.institutionServices.institutionList());
        model.setViewName("user_login");
        return model;
    }

    @RequestMapping(value={"/install"}, method={RequestMethod.POST})
    public String setup(HttpServletRequest request, @RequestParam(value="institutionProfilePic") MultipartFile multipartFile, @RequestParam(value="staffProfilePic") MultipartFile staffProfilePic, @RequestParam(value="institutionAuthorizedSignaturePic") MultipartFile authorizedSignatureImage) {
        try {
            String institutionCode;
            boolean isMultiInstitutions;
            String institutionName = request.getParameter("institutionName");
            String customerCode = request.getParameter("customerCode");
            String licenseCode = request.getParameter("licenseCode");
            String installationKey = request.getParameter("installationKey");
            String institutionAliasName = "alias";
            String institutionAddressline1 = request.getParameter("institutionAddressLine1");
            String institutionAddressline2 = request.getParameter("institutionAddressLine2");
            String institutionCountry = request.getParameter("institutionCountry");
            String institutionState = request.getParameter("institutionState");
            String institutionCity = request.getParameter("institutionCity");
            String institutionContact = request.getParameter("institutionContact");
            String institutionEmail = request.getParameter("institutionEmail");
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
            String institutionPostcode = request.getParameter("institutionPostCode");
            String currencyCode = request.getParameter("institutionCurrencyCode");
            Integer institutionStatus = 1;
            Integer intCollectReceiptsInOrder = Integer.parseInt(request.getParameter("collectReceiptsInOrder"));
            boolean collectReceiptsInOrder = intCollectReceiptsInOrder == 1;
            Integer intIsMultiInstitutions = Integer.parseInt(request.getParameter("isMultiInstitutions"));
            if (intIsMultiInstitutions == 1) {
                isMultiInstitutions = true;
                institutionCode = "root";
            } else {
                institutionCode = request.getParameter("institutionCode");
                isMultiInstitutions = false;
            }
            Integer feeCollectionAdminType = 0;
            Integer inventoryAndAssetAdminType = 0;
            Integer visitorAdminType = 0;
            Integer libraryAdminType = 0;
            if (request.getParameter("feeCollectionAdminType") != null) {
                feeCollectionAdminType = Integer.parseInt(request.getParameter("feeCollectionAdminType"));
            }
            if (request.getParameter("inventoryAndAssetAdminType") != null) {
                inventoryAndAssetAdminType = Integer.parseInt(request.getParameter("inventoryAndAssetAdminType"));
            }
            if (request.getParameter("visitorAdminType") != null) {
                visitorAdminType = Integer.parseInt(request.getParameter("visitorAdminType"));
            }
            if (request.getParameter("libraryAdminType") != null) {
                libraryAdminType = Integer.parseInt(request.getParameter("libraryAdminType"));
            }
            InstitutionConfigDetails institutionConfigDetail = new InstitutionConfigDetails(isMultiInstitutions, feeCollectionAdminType, inventoryAndAssetAdminType, visitorAdminType, libraryAdminType);
            Institution institution = new Institution(institutionName, institutionCode, institutionAliasName, institutionAddressline1, institutionAddressline2, institutionCountry, institutionState, institutionCity, institutionContact, institutionEmail, institutionLogo, institutionPostcode, currencyCode, institutionStatus, collectReceiptsInOrder, authorizedSignature);
            StaffType staffType = this.staffTypeService.staffTypeById(2L);
            StaffDesignation staffDesignation = new StaffDesignation("SuperAdministrator", "default", staffType, institution);
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String staffCode = request.getParameter("staffCode");
            String firstName = request.getParameter("staffFirstName");
            String lastName = request.getParameter("staffLastName");
            String gender = request.getParameter("staffGender");
            Date dateOfBirth = formatter.parse(request.getParameter("staffDOB"));
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
            if (request.getParameter("staffJoinedDate") != null && !request.getParameter("staffJoinedDate").isEmpty()) {
                joinedDate = formatter.parse(request.getParameter("staffJoinedDate"));
            }
            String createdBy = "default";
            Integer status = 1;
            BloodGroup bloodGroup = null;
            if (request.getParameter("staffBloodGroupId") != null) {
                bloodGroup = this.bloodGroupService.bloodGroupById(Long.parseLong(request.getParameter("staffBloodGroupId")));
            }
            String defaultPssword = "admin";
            String profilePath = null;
            profilePath = staffProfilePic != null && !staffProfilePic.isEmpty() ? this.fileUploadHandler.uploadFile(staffProfilePic.getBytes(), request.getRealPath("/"), "/resources/themes/images/staff-profile/", staffProfilePic.getOriginalFilename()) : "/resources/themes/images/profile-pic/a.png";
            String hash = this.hashGenerator.encoder(defaultPssword);
            User user = new User(null, String.valueOf(firstName) + " " + lastName, email, defaultPssword, createdBy, status, hash, profilePath, institution);
            Long categoryId = Long.parseLong(request.getParameter("categoryId"));
            Category category = this.categoryService.categoryById(categoryId);
            Staff staff = new Staff(staffCode, firstName, lastName, gender, dateOfBirth, contact, email, accessNo, parentOrGuardianFirstName, parentOrGuardianLastName, staffAddressLine1, staffAddressLine2, country, state, city, postCode, staffPANNumber, staffPFNumber, joinedDate, createdBy, status, bloodGroup, user, user, institution, staffType, staffDesignation, category);
            HashSet<StaffExperienceDetail> staffExperiences = new HashSet<StaffExperienceDetail>();
            String[] experiences = request.getParameterValues("experience");
            if (experiences != null) {
                int i = 1;
                while (i <= experiences.length) {
                    String workedOrganisation = request.getParameter("organizationName" + i);
                    Double inPreviousExperience = Double.parseDouble(request.getParameter("workExp" + i));
                    Date startDate = formatter.parse(request.getParameter("staffESD" + i));
                    Date endDate = formatter.parse(request.getParameter("staffEED" + i));
                    String staffPreviousDesignation = request.getParameter("workDesignation" + i);
                    StaffExperienceDetail staffExperience = new StaffExperienceDetail(workedOrganisation, startDate, endDate, staffPreviousDesignation, inPreviousExperience, createdBy);
                    staffExperiences.add(staffExperience);
                    ++i;
                }
            }
            String bankName = request.getParameter("staffBankName");
            String bankAccountNo = request.getParameter("staffBankAccountNo");
            String bankIFSCCode = request.getParameter("staffBankIFSC");
            StaffBankDetail staffBankDetail = new StaffBankDetail(bankName, bankAccountNo, bankIFSCCode, createdBy);
            License license = new License(customerCode, licenseCode);
            this.institutionServices.setUpInstitutionWithAdmin(institution, staff, staffExperiences, staffBankDetail, license, installationKey, institutionConfigDetail);
            return "redirect:/";
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
