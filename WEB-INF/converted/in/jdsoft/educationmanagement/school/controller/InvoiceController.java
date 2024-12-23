/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.http.HttpStatus
 *  org.springframework.security.access.prepost.PreAuthorize
 *  org.springframework.stereotype.Controller
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RequestMethod
 *  org.springframework.web.bind.annotation.ResponseBody
 *  org.springframework.web.bind.annotation.ResponseStatus
 *  org.springframework.web.servlet.ModelAndView
 *  org.springframework.web.servlet.mvc.support.RedirectAttributes
 */
package in.jdsoft.educationmanagement.school.controller;

import in.jdsoft.educationmanagement.school.components.DecimalNumberToEnglishWords;
import in.jdsoft.educationmanagement.school.exceptions.StudentException;
import in.jdsoft.educationmanagement.school.exceptions.StudentInvoiceException;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.Class;
import in.jdsoft.educationmanagement.school.model.FeesItem;
import in.jdsoft.educationmanagement.school.model.FeesPenaltySetting;
import in.jdsoft.educationmanagement.school.model.FeesStructure;
import in.jdsoft.educationmanagement.school.model.FeesTermAndFeesItems;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.Section;
import in.jdsoft.educationmanagement.school.model.SpecialCategory;
import in.jdsoft.educationmanagement.school.model.Student;
import in.jdsoft.educationmanagement.school.model.StudentInvoice;
import in.jdsoft.educationmanagement.school.model.StudentInvoiceDetail;
import in.jdsoft.educationmanagement.school.services.AcademicYearService;
import in.jdsoft.educationmanagement.school.services.ClassService;
import in.jdsoft.educationmanagement.school.services.FeesItemService;
import in.jdsoft.educationmanagement.school.services.FeesPenaltySettingService;
import in.jdsoft.educationmanagement.school.services.FeesStructureService;
import in.jdsoft.educationmanagement.school.services.FeesTermService;
import in.jdsoft.educationmanagement.school.services.InstitutionService;
import in.jdsoft.educationmanagement.school.services.InvoiceService;
import in.jdsoft.educationmanagement.school.services.SectionService;
import in.jdsoft.educationmanagement.school.services.SpecialCategoryService;
import in.jdsoft.educationmanagement.school.services.StudentService;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value={"/invoice"})
public class InvoiceController {
    private Logger log = LogManager.getLogger((String)InvoiceController.class.getName());
    @Autowired
    SpecialCategoryService specialCategoryServices;
    @Autowired
    ClassService classService;
    @Autowired
    StudentService studentService;
    @Autowired
    SectionService sectionService;
    @Autowired
    FeesStructureService feesStructureService;
    @Autowired
    InstitutionService institutionService;
    @Autowired
    AcademicYearService academicYearService;
    @Autowired
    FeesTermService feesTermService;
    @Autowired
    InvoiceService invoiceService;
    @Autowired
    DecimalNumberToEnglishWords decimalNumberToEnglishWords;
    @Autowired
    FeesItemService feesItemService;
    @Autowired
    FeesPenaltySettingService feesPenaltySettingService;

    @RequestMapping(method={RequestMethod.GET})
    @PreAuthorize(value="hasAuthority('feesManagment/generateFees')")
    public ModelAndView displayGenerateInvoicePage(HttpServletRequest request) {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed Generate Invoice page"));
            ModelAndView modelandview = new ModelAndView("generatecharges");
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            if (request.getSession().getAttribute("institutiontype").toString().equals("true")) {
                if (request.getSession().getAttribute("feeadminadmintype").toString().equals("1")) {
                    modelandview.addObject("classes", this.classService.classList());
                    modelandview.addObject("specialCategories", this.specialCategoryServices.specialCategoryList());
                    modelandview.addObject("feesTemplates", this.feesStructureService.feesStructureList());
                    modelandview.addObject("feesTerms", this.feesTermService.feesTermList());
                } else {
                    modelandview.addObject("classes", this.classService.classListEager(institutionId));
                    modelandview.addObject("specialCategories", this.specialCategoryServices.specialCategoryList(institutionId));
                    modelandview.addObject("feesTemplates", this.feesStructureService.feesStructureList(institutionId));
                    modelandview.addObject("feesTerms", this.feesTermService.feesTermList(institutionId));
                }
            } else {
                modelandview.addObject("classes", this.classService.classListEager(institutionId));
                modelandview.addObject("specialCategories", this.specialCategoryServices.specialCategoryList(institutionId));
                modelandview.addObject("feesTemplates", this.feesStructureService.feesStructureList(institutionId));
                modelandview.addObject("feesTerms", this.feesTermService.feesTermList(institutionId));
            }
            String institutioncurrencycode = request.getSession().getAttribute("institutioncurrency").toString();
            modelandview.addObject("currencycode", (Object)institutioncurrencycode);
            return modelandview;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            e.printStackTrace();
            throw null;
        }
    }

    @RequestMapping(value={"invoiceAndReceipt"})
    public ModelAndView invoiceAndReceiptPage(HttpServletRequest request) {
        try {
            Long instituteId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            ModelAndView modelandview = new ModelAndView("invoiceandreceipt");
            String institutioncurrencycode = request.getSession().getAttribute("institutioncurrency").toString();
            modelandview.addObject("currencycode", (Object)institutioncurrencycode);
            if (request.getSession().getAttribute("institutiontype").toString().equals("true")) {
                if (request.getSession().getAttribute("feeadminadmintype").toString().equals("1")) {
                    modelandview.addObject("classes", this.classService.classList());
                    modelandview.addObject("specialCategories", this.specialCategoryServices.specialCategoryList());
                } else {
                    modelandview.addObject("classes", this.classService.classListEager(instituteId));
                    modelandview.addObject("specialCategories", this.specialCategoryServices.specialCategoryList(instituteId));
                }
            } else {
                modelandview.addObject("classes", this.classService.classListEager(instituteId));
                modelandview.addObject("specialCategories", this.specialCategoryServices.specialCategoryList(instituteId));
            }
            modelandview.addObject("academicYears", this.academicYearService.academicYearList());
            return modelandview;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/manage"})
    @PreAuthorize(value="hasAuthority('feesManagement/manageInvoices')")
    public ModelAndView displayManageInvoicePage(HttpServletRequest request) {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed Manage Invoice page"));
            ModelAndView modelandview = new ModelAndView("manageinvoice");
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            if (request.getSession().getAttribute("institutiontype").toString().equals("true")) {
                if (request.getSession().getAttribute("feeadminadmintype").toString().equals("1")) {
                    modelandview.addObject("classes", this.classService.classList());
                    modelandview.addObject("specialCategories", this.specialCategoryServices.specialCategoryList());
                } else {
                    modelandview.addObject("classes", this.classService.classListEager(institutionId));
                    modelandview.addObject("specialCategories", this.specialCategoryServices.specialCategoryList(institutionId));
                }
            } else {
                modelandview.addObject("classes", this.classService.classListEager(institutionId));
                modelandview.addObject("specialCategories", this.specialCategoryServices.specialCategoryList(institutionId));
            }
            modelandview.addObject("academicYears", this.academicYearService.academicYearList());
            String institutioncurrencycode = request.getSession().getAttribute("institutioncurrency").toString();
            modelandview.addObject("currencycode", (Object)institutioncurrencycode);
            return modelandview;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            e.printStackTrace();
            throw null;
        }
    }

    @RequestMapping(value={"/students"}, method={RequestMethod.GET})
    @ResponseBody
    public List<Student> getStudentListForInvoice(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        String classNameOrId;
        ArrayList<Student> students;
        block20: {
            students = new ArrayList<Student>();
            classNameOrId = request.getParameter("class");
            String admissionNo = null;
            if (!request.getParameter("admissionNo").isEmpty()) {
                admissionNo = request.getParameter("admissionNo");
                Student student = this.studentService.activeStudentByAdmissionNoWithoutInvoiceGenerated(admissionNo);
                if (student != null) {
                    students.add(student);
                }
                return students;
            }
            if (!classNameOrId.equals("all")) break block20;
            String criteria = request.getParameter("criteria");
            if (criteria.equals("all")) {
                if (request.getSession().getAttribute("institutiontype").toString().equals("true")) {
                    if (request.getSession().getAttribute("feeadminadmintype").toString().equals("1")) {
                        return this.studentService.activeStudentsInAllClassWithoutInvoiceGeneratedFromAllInstituions();
                    }
                    return this.studentService.activeStudentsInAllClassWithoutInvoiceGenerated(Long.parseLong(request.getSession().getAttribute("instituteId").toString()));
                }
                return this.studentService.activeStudentsInAllClassWithoutInvoiceGenerated(Long.parseLong(request.getSession().getAttribute("instituteId").toString()));
            }
            if (criteria.equals("specialcategory")) {
                Long specialCategoryId = null;
                if (request.getParameter("specialCategoryId") != null) {
                    specialCategoryId = Long.parseLong(request.getParameter("specialCategoryId"));
                    if (request.getSession().getAttribute("institutiontype").toString().equals("true")) {
                        if (request.getSession().getAttribute("feeadminadmintype").toString().equals("1")) {
                            return this.studentService.activeStudentsFromAllClassBySpecialCategoryWithoutInvoiceGenerated(specialCategoryId);
                        }
                        return this.studentService.activeStudentsFromAllClassBySpecialCategoryWithoutInvoiceGenerated(Long.parseLong(request.getSession().getAttribute("instituteId").toString()), specialCategoryId);
                    }
                    return this.studentService.activeStudentsFromAllClassBySpecialCategoryWithoutInvoiceGenerated(Long.parseLong(request.getSession().getAttribute("instituteId").toString()), specialCategoryId);
                }
                return null;
            }
            return null;
        }
        try {
            Long classId = Long.parseLong(classNameOrId);
            String criteria = request.getParameter("criteria");
            if (criteria.equals("all")) {
                String[] sections;
                String[] stringArray = sections = request.getParameterValues("section");
                int n = sections.length;
                int n2 = 0;
                while (n2 < n) {
                    String selectedsectionId = stringArray[n2];
                    Long sectionId = Long.parseLong(selectedsectionId);
                    if (this.studentService.activeStudentsInClassAndSectionWithoutInvoiceGenerated(classId, sectionId) != null) {
                        students.addAll(this.studentService.activeStudentsInClassAndSectionWithoutInvoiceGenerated(classId, sectionId));
                    }
                    ++n2;
                }
                return students;
            }
            if (criteria.equals("specialcategory")) {
                Long specialCategoryId = null;
                if (request.getParameter("specialCategoryId") != null) {
                    String[] sections;
                    specialCategoryId = Long.parseLong(request.getParameter("specialCategoryId"));
                    String[] stringArray = sections = request.getParameterValues("section");
                    int n = sections.length;
                    int n3 = 0;
                    while (n3 < n) {
                        String selectedsectionId = stringArray[n3];
                        Long sectionId = Long.parseLong(selectedsectionId);
                        if (this.studentService.activeStudentsInClassSectionAndSpecialCategoryWithoutInvoiceGenerated(classId, sectionId, specialCategoryId) != null) {
                            students.addAll(this.studentService.activeStudentsInClassSectionAndSpecialCategoryWithoutInvoiceGenerated(classId, sectionId, specialCategoryId));
                        }
                        ++n3;
                    }
                }
                return students;
            }
            return students;
        }
        catch (Exception e) {
            if (e.getClass().equals(StudentException.class)) {
                throw e;
            }
            throw e;
        }
    }

    @RequestMapping(value={"generate"}, method={RequestMethod.POST})
    @ResponseStatus(value=HttpStatus.OK)
    public String generateStudentInvoice(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            String[] academicTermAndFeesStructureIds;
            Long instituteId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            String penaltycriteriaid = request.getParameter("penaltycriteriaid");
            FeesPenaltySetting feesPenaltySetting = this.feesPenaltySettingService.feesPenaltySettingByFeesPenaltySettingTypeAndInstitution(penaltycriteriaid, instituteId);
            String selectedStudentIds = request.getParameter("selectedStudentIds");
            String selectedFeesStructureDetailsIds = request.getParameter("selectedFeesStructureDetails");
            ArrayList<FeesTermAndFeesItems> addFeesTermAndFeesItems = new ArrayList<FeesTermAndFeesItems>();
            if (selectedStudentIds != null && (academicTermAndFeesStructureIds = selectedFeesStructureDetailsIds.split(",")) != null) {
                String[] stringArray = academicTermAndFeesStructureIds;
                int n = academicTermAndFeesStructureIds.length;
                int n2 = 0;
                while (n2 < n) {
                    int n3;
                    int n4;
                    String[] stringArray2;
                    String academicTermAndFeesStructure = stringArray[n2];
                    LinkedHashSet<FeesItem> addFeesItems = new LinkedHashSet<FeesItem>();
                    LinkedHashSet<FeesItem> addTempFeesItems = new LinkedHashSet<FeesItem>();
                    String[] splits = academicTermAndFeesStructure.split("-");
                    String[] selectedFeesStructureIds = request.getParameterValues(splits[1].toString());
                    String[] selectedFeesItemIds = request.getParameterValues(splits[2].toString());
                    if (selectedFeesItemIds != null) {
                        stringArray2 = selectedFeesItemIds;
                        n4 = selectedFeesItemIds.length;
                        n3 = 0;
                        while (n3 < n4) {
                            String feesItemId = stringArray2[n3];
                            addFeesItems.add(this.feesItemService.feesItemById(Long.parseLong(feesItemId)));
                            ++n3;
                        }
                    }
                    if (selectedFeesStructureIds != null) {
                        stringArray2 = selectedFeesStructureIds;
                        n4 = selectedFeesStructureIds.length;
                        n3 = 0;
                        while (n3 < n4) {
                            String feesStructureIds = stringArray2[n3];
                            FeesStructure feesStructure = this.feesStructureService.feesStructureByIdEager(Long.parseLong(feesStructureIds));
                            LinkedHashSet<Long> tempItem = new LinkedHashSet<Long>();
                            for (FeesItem tempfee : feesStructure.getFeesItems()) {
                                tempItem.add(tempfee.getFeesItemId());
                            }
                            Iterator feesItems = addFeesItems.iterator();
                            while (feesItems.hasNext()) {
                                FeesItem feeItem = (FeesItem)feesItems.next();
                                if (!tempItem.contains(feeItem.getFeesItemId())) continue;
                                feesItems.remove();
                            }
                            addTempFeesItems.addAll(feesStructure.getFeesItems());
                            ++n3;
                        }
                    }
                    addTempFeesItems.addAll(addFeesItems);
                    FeesTermAndFeesItems feesTermAndFeesStructureAndFeesItem = new FeesTermAndFeesItems(Long.parseLong(splits[0]), addTempFeesItems);
                    addFeesTermAndFeesItems.add(feesTermAndFeesStructureAndFeesItem);
                    ++n2;
                }
            }
            String createdByAndModifiedBy = request.getSession().getAttribute("username").toString();
            AcademicYear academicYear = this.academicYearService.getActiveAcademicYear();
            String[] selectStudents = selectedStudentIds.split(",");
            Long[] students = new Long[selectStudents.length];
            Integer count = 0;
            int i = 0;
            while (i < selectStudents.length) {
                Integer n = count;
                count = n + 1;
                students[n.intValue()] = Long.parseLong(selectStudents[i]);
                ++i;
            }
            this.invoiceService.generateInvoiceForFeesTermAndFeesItems(students, addFeesTermAndFeesItems, academicYear, createdByAndModifiedBy, this.institutionService.institutionById(instituteId), feesPenaltySetting.getDueDays(), feesPenaltySetting);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Invoice Generated"));
            return "redirect:/invoice";
        }
        catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Failed To Generate Invoice"));
            return "redirect:/invoice";
        }
    }

    @RequestMapping(value={"allStudent"}, method={RequestMethod.GET})
    @ResponseBody
    public List<Student> getAllStudentListForInvoice(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        String classNameOrId;
        ArrayList<Student> students;
        block18: {
            students = new ArrayList<Student>();
            classNameOrId = request.getParameter("class");
            String admissionNo = null;
            if (!request.getParameter("admissionNo").isEmpty()) {
                admissionNo = request.getParameter("admissionNo");
                students.add(this.studentService.studentByAdmissionNoEager(admissionNo));
                return students;
            }
            if (!classNameOrId.equals("all")) break block18;
            String criteria = request.getParameter("criteria");
            if (criteria.equals("all")) {
                if (request.getSession().getAttribute("institutiontype").toString().equals("true")) {
                    if (request.getSession().getAttribute("feeadminadmintype").toString().equals("1")) {
                        return this.studentService.studentListEager();
                    }
                    return this.studentService.studentListEager(Long.parseLong(request.getSession().getAttribute("instituteId").toString()));
                }
                return this.studentService.studentListEager(Long.parseLong(request.getSession().getAttribute("instituteId").toString()));
            }
            if (criteria.equals("specialcategory")) {
                Long specialCategoryId = null;
                if (request.getParameter("specialCategoryId") != null) {
                    specialCategoryId = Long.parseLong(request.getParameter("specialCategoryId"));
                    if (request.getSession().getAttribute("institutiontype").toString().equals("true")) {
                        if (request.getSession().getAttribute("feeadminadmintype").toString().equals("1")) {
                            return this.studentService.studentsBySpecialCategoryEager(specialCategoryId);
                        }
                        return this.studentService.studentsBySpecialCategoryEager(Long.parseLong(request.getSession().getAttribute("instituteId").toString()), specialCategoryId);
                    }
                    return this.studentService.studentsBySpecialCategoryEager(Long.parseLong(request.getSession().getAttribute("instituteId").toString()), specialCategoryId);
                }
                return null;
            }
            return null;
        }
        try {
            Long classId = Long.parseLong(classNameOrId);
            String criteria = request.getParameter("criteria");
            if (criteria.equals("all")) {
                String[] sections;
                String[] stringArray = sections = request.getParameterValues("section");
                int n = sections.length;
                int n2 = 0;
                while (n2 < n) {
                    String selectedsectionId = stringArray[n2];
                    Long sectionId = Long.parseLong(selectedsectionId);
                    if (this.studentService.studentListByClassAndSectionEager(classId, sectionId) != null) {
                        students.addAll(this.studentService.studentListByClassAndSectionEager(classId, sectionId));
                    }
                    ++n2;
                }
                return students;
            }
            if (criteria.equals("specialcategory")) {
                String[] sections;
                String[] stringArray = sections = request.getParameterValues("section");
                int n = sections.length;
                int n3 = 0;
                while (n3 < n) {
                    String selectedsectionId = stringArray[n3];
                    Long sectionId = Long.parseLong(selectedsectionId);
                    Long specialCategoryId = null;
                    if (request.getParameter("specialCategoryId") != null && this.studentService.studentsByClassSectionAndSpecialCategoryEager(classId, sectionId, specialCategoryId = Long.valueOf(Long.parseLong(request.getParameter("specialCategoryId")))) != null) {
                        students.addAll(this.studentService.studentsByClassSectionAndSpecialCategoryEager(classId, sectionId, specialCategoryId));
                    }
                    ++n3;
                }
                return students;
            }
            return students;
        }
        catch (Exception e) {
            if (e.getClass().equals(StudentException.class)) {
                StudentException studentException = (StudentException)e;
                redirectAttributes.addFlashAttribute("errorMessage", (Object)studentException.getCustomMessage());
                return null;
            }
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/pendinginvoices"})
    @ResponseBody
    public List<StudentInvoice> studentPendingInvoice(HttpServletRequest request) {
        ArrayList<StudentInvoice> studentInvoices = null;
        try {
            String admissionNo = request.getParameter("admissionNo");
            String student = request.getParameter("studentId").trim();
            Long studentId = null;
            if (!student.isEmpty()) {
                studentId = Long.parseLong(student);
            }
            if (admissionNo.isEmpty()) {
                studentInvoices = this.invoiceService.getStudentPendingInvoices(studentId);
            } else if (studentId == null) {
                studentInvoices = this.invoiceService.getStudentPendingInvoices(admissionNo);
            }
            return studentInvoices;
        }
        catch (Exception e) {
            e.printStackTrace();
            return studentInvoices;
        }
    }

    @RequestMapping(value={"/studentInvoice/itemdetails"}, method={RequestMethod.GET})
    @ResponseBody
    public ArrayList<StudentInvoiceDetail> getStudentPendingInvoiceFeesItems(HttpServletRequest request) {
        try {
            Long studentInvoiceId = Long.parseLong(request.getParameter("studentInvoiceId"));
            return this.invoiceService.getStudentPendingInvoiceFeesItems(studentInvoiceId);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"/studentInvoice/itemdetailsandstatus"}, method={RequestMethod.GET})
    @ResponseBody
    public ArrayList<StudentInvoiceDetail> getStudentPendingInvoiceFeesItemsByInvoiceIdAndInvocieStatus(HttpServletRequest request) {
        try {
            Long studentInvoiceId = Long.parseLong(request.getParameter("studentInvoiceId"));
            return this.invoiceService.getStudentPendingInvoiceFeesItemsByInvoiceIdAndInvoiceStatus(studentInvoiceId, 1);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"/studentInvoice/itemdetailsandstatus/refund"}, method={RequestMethod.GET})
    @ResponseBody
    public ArrayList<StudentInvoiceDetail> getStudentPendingInvoiceFeesItemsByInvoiceId(HttpServletRequest request) {
        try {
            Long studentInvoiceId = Long.parseLong(request.getParameter("studentInvoiceId"));
            return this.invoiceService.getStudentPendingInvoiceFeesItemsByInvoiceId(studentInvoiceId);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"invoiceValidation"}, method={RequestMethod.GET})
    @ResponseBody
    public Boolean invoiceValidation(HttpServletRequest request) {
        try {
            String[] invoiceIds = request.getParameterValues("invoiceForPayment[]");
            Long instituteId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            Long[] invoicesId = new Long[invoiceIds.length];
            Integer count = 0;
            String[] stringArray = invoiceIds;
            int n = invoiceIds.length;
            int n2 = 0;
            while (n2 < n) {
                String invoiceId = stringArray[n2];
                Integer n3 = count;
                count = n3 + 1;
                invoicesId[n3.intValue()] = Long.parseLong(invoiceId);
                ++n2;
            }
            return this.invoiceService.invoiceValidation(invoicesId, instituteId);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"invoicedetailsforpayment"}, method={RequestMethod.GET})
    @ResponseBody
    public ArrayList<StudentInvoice> getStudentPendingInvoicesForPayment(HttpServletRequest request) {
        try {
            String[] ids = request.getParameterValues("invoiceForPayment[]");
            Long[] invoicesId = new Long[ids.length];
            Integer count = 0;
            String[] stringArray = ids;
            int n = ids.length;
            int n2 = 0;
            while (n2 < n) {
                String invoiceId = stringArray[n2];
                Integer n3 = count;
                count = n3 + 1;
                invoicesId[n3.intValue()] = Long.parseLong(invoiceId);
                ++n2;
            }
            return this.invoiceService.getStudentInvoicesFromIds(invoicesId);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"invoiceAndReceipt/invoice"}, method={RequestMethod.GET})
    @ResponseBody
    public ArrayList<StudentInvoice> getInvoicesFromSelectedCriteria(HttpServletRequest request) throws Exception {
        try {
            String option = request.getParameter("option");
            AcademicYear academicYear = null;
            if (!option.equals("byDateRange")) {
                Long academicYearId = Long.parseLong(request.getParameter("academicYearId"));
                academicYear = this.academicYearService.academicYearById(academicYearId);
            }
            ArrayList<StudentInvoice> studentInvoices = new ArrayList<StudentInvoice>();
            if (option.equals("byadmissionno")) {
                String admissionNo = request.getParameter("admissionNo");
                studentInvoices.addAll(this.invoiceService.getStudentInvoicesByAdmisssionNoAndAcademicYear(admissionNo, academicYear));
                return studentInvoices;
            }
            if (option.equals("byclass")) {
                String criteria = request.getParameter("criteria");
                String classId = request.getParameter("class");
                if (classId.equals("all")) {
                    if (criteria.equals("all")) {
                        Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
                        Institution institution = this.institutionService.institutionById(institutionId);
                        studentInvoices.addAll(this.invoiceService.getAllStudentsInvoices(academicYear, institution));
                        return studentInvoices;
                    }
                    if (criteria.equals("specialcategory")) {
                        Long specialCategoryId = Long.parseLong(request.getParameter("specialCategoryId"));
                        Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
                        Institution institution = this.institutionService.institutionById(institutionId);
                        SpecialCategory specialCategory = this.specialCategoryServices.specialCategoryById(specialCategoryId);
                        studentInvoices.addAll(this.invoiceService.getStudentsInvoiceBySpecialCategory(academicYear, specialCategory, institution));
                        return studentInvoices;
                    }
                } else {
                    String[] sections;
                    Long classid = Long.parseLong(classId);
                    Class clazz = this.classService.classById(classid);
                    String[] stringArray = sections = request.getParameterValues("section");
                    int n = sections.length;
                    int n2 = 0;
                    while (n2 < n) {
                        String selectedsectionId = stringArray[n2];
                        Long sectionId = Long.parseLong(selectedsectionId);
                        Section section = this.sectionService.sectionById(sectionId);
                        if (criteria.equals("all")) {
                            studentInvoices.addAll(this.invoiceService.getAllStudentInvoices(academicYear, clazz, section));
                        } else if (criteria.equals("specialcategory")) {
                            Long specialCategoryId = Long.parseLong(request.getParameter("specialCategoryId"));
                            SpecialCategory specialCategory = this.specialCategoryServices.specialCategoryById(specialCategoryId);
                            studentInvoices.addAll(this.invoiceService.getStudentInvoicesBySpecialCategory(academicYear, clazz, section, specialCategory));
                        }
                        ++n2;
                    }
                    return studentInvoices;
                }
                return studentInvoices;
            }
            if (option.equals("byDateRange")) {
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                Date fromDate = formatter.parse(request.getParameter("fromDate"));
                Date toDate = formatter.parse(request.getParameter("toDate"));
                Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
                Institution institution = this.institutionService.institutionById(institutionId);
                studentInvoices.addAll(this.invoiceService.getStudentInvoicesByDate(fromDate, toDate, institution));
                return studentInvoices;
            }
            return studentInvoices;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"invoiceDelete"}, method={RequestMethod.POST})
    public String deleteInvoice(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        block5: {
            try {
                String studentIds = request.getParameter("selectedStudentIds");
                Long academicYearId = Long.parseLong(request.getParameter("academicYearId"));
                if (studentIds == null || academicYearId == null) break block5;
                String[] studentsIds = studentIds.split(",");
                Long[] studentsId = new Long[studentsIds.length];
                Integer count = 0;
                String[] stringArray = studentsIds;
                int n = studentsIds.length;
                int n2 = 0;
                while (n2 < n) {
                    String studentId = stringArray[n2];
                    Integer n3 = count;
                    count = n3 + 1;
                    studentsId[n3.intValue()] = Long.parseLong(studentId.trim());
                    ++n2;
                }
                this.invoiceService.deleteStudentInvoicesByAcademicYear(studentsId, academicYearId);
                redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Invoices Deleted Successfully...!"));
                return "redirect:/invoice/manage";
            }
            catch (Exception e) {
                if (e.getClass().equals(StudentInvoiceException.class)) {
                    StudentInvoiceException ex = (StudentInvoiceException)e;
                    redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", ex.getMessage()));
                    return "redirect:/invoice/manage";
                }
                redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Delete Invoices ! First Delete Receipts After Can Delete Invoices"));
                e.printStackTrace();
                return "redirect:/invoice/manage";
            }
        }
        throw new StudentInvoiceException(new Message("failure", "No Student  Or Academic Year Selected"));
    }

    @RequestMapping(value={"print"})
    public ModelAndView printInvoice(HttpServletRequest request) {
        try {
            ModelAndView modelandview = new ModelAndView("printinvoice");
            Long invoiceId = Long.parseLong(request.getParameter("invoiceId"));
            modelandview.addObject("studentInvoice", (Object)this.invoiceService.getStudentInvoiceDetails(invoiceId));
            modelandview.addObject("numberConverter", (Object)this.decimalNumberToEnglishWords);
            return modelandview;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
