/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.mail.MailSendException
 *  org.springframework.security.access.prepost.PreAuthorize
 *  org.springframework.stereotype.Controller
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RequestMethod
 *  org.springframework.web.bind.annotation.ResponseBody
 *  org.springframework.web.servlet.ModelAndView
 *  org.springframework.web.servlet.mvc.support.RedirectAttributes
 */
package in.jdsoft.educationmanagement.school.controller;

import in.jdsoft.educationmanagement.school.components.DecimalNumberToEnglishWords;
import in.jdsoft.educationmanagement.school.components.EmailHandler;
import in.jdsoft.educationmanagement.school.components.SMSHandler;
import in.jdsoft.educationmanagement.school.exceptions.ReceiptException;
import in.jdsoft.educationmanagement.school.exceptions.StudentException;
import in.jdsoft.educationmanagement.school.exceptions.StudentFeeRefundReceiptException;
import in.jdsoft.educationmanagement.school.exceptions.StudentReceiptException;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.Class;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.PaymentMode;
import in.jdsoft.educationmanagement.school.model.Section;
import in.jdsoft.educationmanagement.school.model.SpecialCategory;
import in.jdsoft.educationmanagement.school.model.Student;
import in.jdsoft.educationmanagement.school.model.StudentFeeRefundReceipt;
import in.jdsoft.educationmanagement.school.model.StudentFeeRefundReceiptDetail;
import in.jdsoft.educationmanagement.school.model.StudentReceipt;
import in.jdsoft.educationmanagement.school.model.StudentReceiptDetail;
import in.jdsoft.educationmanagement.school.model.StudentReceiptFine;
import in.jdsoft.educationmanagement.school.services.AcademicYearService;
import in.jdsoft.educationmanagement.school.services.ClassService;
import in.jdsoft.educationmanagement.school.services.InstitutionService;
import in.jdsoft.educationmanagement.school.services.PaymentModeService;
import in.jdsoft.educationmanagement.school.services.ReceiptService;
import in.jdsoft.educationmanagement.school.services.SectionService;
import in.jdsoft.educationmanagement.school.services.SpecialCategoryService;
import in.jdsoft.educationmanagement.school.services.StudentFeeRefundReceiptService;
import in.jdsoft.educationmanagement.school.services.StudentService;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSendException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value={"/receipt"})
public class ReceiptController {
    private Logger log = LogManager.getLogger((String)ReceiptController.class.getName());
    @Autowired
    ClassService classService;
    @Autowired
    PaymentModeService paymentModeService;
    @Autowired
    ReceiptService receiptService;
    @Autowired
    DecimalNumberToEnglishWords decimalNumberToEnglishWords;
    @Autowired
    AcademicYearService academicYearService;
    @Autowired
    SectionService sectionService;
    @Autowired
    InstitutionService institutionService;
    @Autowired
    SpecialCategoryService specialCategoryServices;
    @Autowired
    StudentService studentService;
    @Autowired
    EmailHandler emailHandler;
    @Autowired
    SMSHandler smsHandler;
    @Autowired
    StudentFeeRefundReceiptService studentFeeRefundReceiptService;

    @RequestMapping(method={RequestMethod.GET}, value={"/generate"})
    @PreAuthorize(value="hasAuthority('feesManagement/collectFees')")
    public ModelAndView displayGenerateInvoicePage(HttpServletRequest request) {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed Generate Receipt page"));
            ModelAndView modelandview = new ModelAndView("receipt");
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            if (request.getSession().getAttribute("institutiontype").toString().equals("true")) {
                if (request.getSession().getAttribute("feeadminadmintype").toString().equals("1")) {
                    modelandview.addObject("classes", this.classService.classList());
                } else {
                    modelandview.addObject("classes", this.classService.classList(institutionId));
                }
            } else {
                modelandview.addObject("classes", this.classService.classList(institutionId));
            }
            modelandview.addObject("paymentModes", this.paymentModeService.paymentModeList());
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

    @RequestMapping(method={RequestMethod.GET}, value={"/refund"})
    public ModelAndView displayRefundPage(HttpServletRequest request) {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed Refund page"));
            ModelAndView modelandview = new ModelAndView("refund");
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            if (request.getSession().getAttribute("institutiontype").toString().equals("true")) {
                if (request.getSession().getAttribute("feeadminadmintype").toString().equals("1")) {
                    modelandview.addObject("classes", this.classService.classList());
                } else {
                    modelandview.addObject("classes", this.classService.classList(institutionId));
                }
            } else {
                modelandview.addObject("classes", this.classService.classList(institutionId));
            }
            modelandview.addObject("paymentModes", this.paymentModeService.paymentModeList());
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

    @RequestMapping(method={RequestMethod.GET}, value={"/manage"})
    @PreAuthorize(value="hasAuthority('feesManagement/manageReceipts')")
    public ModelAndView displayManageInvoicePage(HttpServletRequest request) {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed Manage Receipt page"));
            ModelAndView modelandview = new ModelAndView("managereceipt");
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            if (request.getSession().getAttribute("institutiontype").toString().equals("true")) {
                if (request.getSession().getAttribute("feeadminadmintype").toString().equals("1")) {
                    modelandview.addObject("classes", this.classService.classList());
                    modelandview.addObject("specialCategories", this.specialCategoryServices.specialCategoryList());
                } else {
                    modelandview.addObject("classes", this.classService.classList(institutionId));
                    modelandview.addObject("specialCategories", this.specialCategoryServices.specialCategoryList(institutionId));
                }
            } else {
                modelandview.addObject("classes", this.classService.classList(institutionId));
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

    @RequestMapping(method={RequestMethod.GET}, value={"/manage/refund"})
    public ModelAndView displayManageFeeRefundPage(HttpServletRequest request) {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed Manage Refund page"));
            ModelAndView modelandview = new ModelAndView("managerefund");
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            if (request.getSession().getAttribute("institutiontype").toString().equals("true")) {
                if (request.getSession().getAttribute("feeadminadmintype").toString().equals("1")) {
                    modelandview.addObject("classes", this.classService.classList());
                    modelandview.addObject("specialCategories", this.specialCategoryServices.specialCategoryList());
                } else {
                    modelandview.addObject("classes", this.classService.classList(institutionId));
                    modelandview.addObject("specialCategories", this.specialCategoryServices.specialCategoryList(institutionId));
                }
            } else {
                modelandview.addObject("classes", this.classService.classList(institutionId));
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

    @RequestMapping(value={"/delete"}, method={RequestMethod.POST})
    public String deleteReceipt(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            Long receiptId = Long.parseLong(request.getParameter("deleteReceiptId"));
            this.receiptService.deleteReceipt(receiptId);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Receipt Deleted Successfully...!"));
            return "redirect:/receipt/manage";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done...!"));
            e.printStackTrace();
            return "redirect:/receipt/manage";
        }
    }

    @RequestMapping(value={"invoiceAndReceipt/receipt"}, method={RequestMethod.GET})
    @ResponseBody
    public ArrayList<StudentReceipt> getReceiptsFromSelectedCriteria(HttpServletRequest request) throws Exception {
        try {
            String option = request.getParameter("option");
            AcademicYear academicYear = null;
            if (!option.equals("byDateRange")) {
                Long academicYearId = Long.parseLong(request.getParameter("academicYearId"));
                academicYear = this.academicYearService.academicYearById(academicYearId);
            }
            ArrayList<StudentReceipt> studentReceipts = new ArrayList<StudentReceipt>();
            if (option.equals("byadmissionno")) {
                String admissionNo = request.getParameter("admissionNo");
                studentReceipts.addAll(this.receiptService.getStudentReceiptsByAdmisssionNoAndAcademicYear(admissionNo, academicYear));
                return studentReceipts;
            }
            if (option.equals("byclass")) {
                String criteria = request.getParameter("criteria");
                String classId = request.getParameter("class");
                if (classId.equals("all")) {
                    if (criteria.equals("all")) {
                        Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
                        Institution institution = this.institutionService.institutionById(institutionId);
                        studentReceipts.addAll(this.receiptService.getAllStudentsReceipts(academicYear, institution));
                        return studentReceipts;
                    }
                    if (criteria.equals("specialcategory")) {
                        Long specialCategoryId = Long.parseLong(request.getParameter("specialCategoryId"));
                        Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
                        Institution institution = this.institutionService.institutionById(institutionId);
                        SpecialCategory specialCategory = this.specialCategoryServices.specialCategoryById(specialCategoryId);
                        studentReceipts.addAll(this.receiptService.getStudentReceiptsBySpecialCategory(academicYear, specialCategory, institution));
                        return studentReceipts;
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
                            studentReceipts.addAll(this.receiptService.getAllStudentReceipts(academicYear, clazz, section));
                        } else if (criteria.equals("specialcategory")) {
                            Long specialCategoryId = Long.parseLong(request.getParameter("specialCategoryId"));
                            SpecialCategory specialCategory = this.specialCategoryServices.specialCategoryById(specialCategoryId);
                            studentReceipts.addAll(this.receiptService.getStudentReceiptsBySpecialCategory(academicYear, clazz, section, specialCategory));
                        }
                        ++n2;
                    }
                    return studentReceipts;
                }
                return studentReceipts;
            }
            if (option.equals("byDateRange")) {
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                Date fromDate = formatter.parse(request.getParameter("fromDate"));
                Date toDate = formatter.parse(request.getParameter("toDate"));
                Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
                Institution institution = this.institutionService.institutionById(institutionId);
                studentReceipts.addAll(this.receiptService.getReceiptsByDateRange(fromDate, toDate, institution));
                return studentReceipts;
            }
            return studentReceipts;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"/generate/testingpayment"}, method={RequestMethod.POST})
    public ModelAndView onlinePaymentPage(HttpServletRequest request) {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed Generate Receipt page"));
            ModelAndView modelandview = new ModelAndView("payuform");
            return modelandview;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            e.printStackTrace();
            throw null;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @RequestMapping(value={"/generate/payment"}, method={RequestMethod.POST})
    public String generateReceipt(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            PaymentMode paymentMode;
            int n;
            int n2;
            String[] stringArray;
            Integer i;
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            double fineAmount = 0.0;
            Integer discountApplied = Integer.parseInt(request.getParameter("isDiscountAppliedHF"));
            String selectedCheckBoxEmailId = request.getParameter("selectedCheckBoxEmailId");
            String selectedCheckBoxSmsId = request.getParameter("selectedCheckBoxSmsId");
            boolean isdiscountApplied = false;
            if (discountApplied == 1) {
                isdiscountApplied = true;
            } else if (discountApplied == 0) {
                isdiscountApplied = false;
            }
            String discountType = request.getParameter("disTypeHF");
            Double discountPercentage = null;
            if (discountType.equals("percentage")) {
                discountPercentage = Double.parseDouble(request.getParameter("disPerHF"));
            }
            String[] normalFeesItemsIds = request.getParameterValues("normalItem");
            Long[] normalFeesItems = null;
            String[] flatDiscountFeesItemsIds = request.getParameterValues("flatDiscountItem");
            Long[] flatDiscountFeesItems = null;
            String[] flatDiscountFeesItemsAmounts = request.getParameterValues("flatDiscountItemAmount");
            Double[] flatDiscountFeesItemsAmount = null;
            String[] partialFeesItemsAmounts = request.getParameterValues("partialItemAmount");
            Double[] partialFeesItemsAmount = null;
            String narration = null;
            if (!request.getParameter("fineAmount").isEmpty()) {
                fineAmount = Double.parseDouble(request.getParameter("fineAmount"));
            }
            if (!request.getParameter("narration").isEmpty()) {
                narration = request.getParameter("narration");
            }
            if (normalFeesItemsIds != null) {
                normalFeesItems = new Long[normalFeesItemsIds.length];
                i = 0;
                stringArray = normalFeesItemsIds;
                n2 = normalFeesItemsIds.length;
                n = 0;
                while (n < n2) {
                    String normalFeesItemsId = stringArray[n];
                    Integer n3 = i;
                    i = n3 + 1;
                    normalFeesItems[n3.intValue()] = Long.parseLong(normalFeesItemsId);
                    ++n;
                }
            }
            if (flatDiscountFeesItemsIds != null) {
                flatDiscountFeesItems = new Long[flatDiscountFeesItemsIds.length];
                i = 0;
                stringArray = flatDiscountFeesItemsIds;
                n2 = flatDiscountFeesItemsIds.length;
                n = 0;
                while (n < n2) {
                    String flatDiscountFeesItemsId = stringArray[n];
                    Integer n4 = i;
                    i = n4 + 1;
                    flatDiscountFeesItems[n4.intValue()] = Long.parseLong(flatDiscountFeesItemsId);
                    ++n;
                }
            }
            if (flatDiscountFeesItemsAmounts != null) {
                flatDiscountFeesItemsAmount = new Double[flatDiscountFeesItemsAmounts.length];
                i = 0;
                stringArray = flatDiscountFeesItemsAmounts;
                n2 = flatDiscountFeesItemsAmounts.length;
                n = 0;
                while (n < n2) {
                    String flatDiscountFeesItemAmount = stringArray[n];
                    Integer n5 = i;
                    i = n5 + 1;
                    flatDiscountFeesItemsAmount[n5.intValue()] = Double.parseDouble(flatDiscountFeesItemAmount);
                    ++n;
                }
            }
            if (partialFeesItemsAmounts != null) {
                partialFeesItemsAmount = new Double[partialFeesItemsAmounts.length];
                i = 0;
                stringArray = partialFeesItemsAmounts;
                n2 = partialFeesItemsAmounts.length;
                n = 0;
                while (n < n2) {
                    String partialFeesItemAmount = stringArray[n];
                    Integer n6 = i;
                    i = n6 + 1;
                    partialFeesItemsAmount[n6.intValue()] = Double.parseDouble(partialFeesItemAmount);
                    ++n;
                }
            }
            double totalPaidAmount = Double.parseDouble(request.getParameter("amount"));
            Long paymentModeId = Long.parseLong(request.getParameter("paymentMode"));
            String checkPaymentType = request.getParameter("checkPaymentType");
            if (checkPaymentType.equals("Full")) {
                if (paymentModeId == 1L) {
                    paymentMode = this.paymentModeService.paymentModeById(paymentModeId);
                    Date receivedDate = formatter.parse(request.getParameter("receivedDate"));
                    String createdBy = request.getSession().getAttribute("username").toString();
                    String modifiedBy = request.getSession().getAttribute("username").toString();
                    Long receiptId = this.receiptService.receiptByCash(normalFeesItems, flatDiscountFeesItems, flatDiscountFeesItemsAmount, fineAmount, totalPaidAmount, paymentMode, receivedDate, isdiscountApplied, discountType, discountPercentage, narration, createdBy, modifiedBy);
                    if (selectedCheckBoxEmailId.equals("1")) {
                        this.exportAsEmail(receiptId);
                    }
                    if (selectedCheckBoxSmsId.equals("1")) {
                        Student student = this.receiptService.receiptById(receiptId).getStudent();
                        this.smsHandler.sentSMS("91" + student.getParentContact() + ",91" + student.getContact(), "Total Paid Amount = " + totalPaidAmount, institutionId);
                    }
                    redirectAttributes.addFlashAttribute("receiptId", (Object)receiptId);
                    return "redirect:/receipt/generate";
                }
                if (paymentModeId == 2L) {
                    paymentMode = this.paymentModeService.paymentModeById(paymentModeId);
                    Date chequeReceivedDate = formatter.parse(request.getParameter("receivedDate"));
                    String chequeNo = request.getParameter("chequeNo");
                    Date chequeDate = formatter.parse(request.getParameter("chequeDate"));
                    String chequeBankName = request.getParameter("chequeBankName");
                    String chequeBranchName = request.getParameter("chequeBranchName");
                    String createdBy = request.getSession().getAttribute("username").toString();
                    String modifiedBy = request.getSession().getAttribute("username").toString();
                    Long receiptId = this.receiptService.receiptByCheque(normalFeesItems, flatDiscountFeesItems, flatDiscountFeesItemsAmount, fineAmount, totalPaidAmount, paymentMode, chequeReceivedDate, chequeNo, chequeDate, chequeBankName, chequeBranchName, isdiscountApplied, discountType, discountPercentage, narration, createdBy, modifiedBy);
                    if (selectedCheckBoxEmailId.equals("1")) {
                        this.exportAsEmail(receiptId);
                    }
                    if (selectedCheckBoxSmsId.equals("1")) {
                        Student student = this.receiptService.receiptById(receiptId).getStudent();
                        this.smsHandler.sentSMS("91" + student.getParentContact() + ",91" + student.getContact(), "Total Paid Amount = " + totalPaidAmount, institutionId);
                    }
                    redirectAttributes.addFlashAttribute("receiptId", (Object)receiptId);
                    return "redirect:/receipt/generate";
                }
                if (paymentModeId != 3L) {
                    throw new StudentReceiptException(new Message("failed", "Invalid Payment Method"));
                }
                paymentMode = this.paymentModeService.paymentModeById(paymentModeId);
                Date ddReceivedDate = formatter.parse(request.getParameter("receivedDate"));
                String ddNo = request.getParameter("ddNo");
                Date ddDate = formatter.parse(request.getParameter("ddDate"));
                String ddBankName = request.getParameter("ddBankName");
                String ddBranchName = request.getParameter("ddBranchName");
                String createdBy = request.getSession().getAttribute("username").toString();
                String modifiedBy = request.getSession().getAttribute("username").toString();
                Long receiptId = this.receiptService.receiptByDD(normalFeesItems, flatDiscountFeesItems, flatDiscountFeesItemsAmount, fineAmount, totalPaidAmount, paymentMode, ddReceivedDate, ddNo, ddDate, ddBankName, ddBranchName, isdiscountApplied, discountType, discountPercentage, narration, createdBy, modifiedBy);
                if (selectedCheckBoxEmailId.equals("1")) {
                    this.exportAsEmail(receiptId);
                }
                if (selectedCheckBoxSmsId.equals("1")) {
                    Student student = this.receiptService.receiptById(receiptId).getStudent();
                    this.smsHandler.sentSMS("91" + student.getParentContact() + ",91" + student.getContact(), "Total Paid Amount = " + totalPaidAmount, institutionId);
                }
                redirectAttributes.addFlashAttribute("receiptId", (Object)receiptId);
                return "redirect:/receipt/generate";
            }
            if (!checkPaymentType.equals("Partial")) {
                return "redirect:/receipt/generate";
            }
            if (paymentModeId == 1L) {
                paymentMode = this.paymentModeService.paymentModeById(paymentModeId);
                Date receivedDate = formatter.parse(request.getParameter("receivedDate"));
                String createdBy = request.getSession().getAttribute("username").toString();
                String modifiedBy = request.getSession().getAttribute("username").toString();
                Long receiptId = this.receiptService.receiptByCashAndPartialPayment(normalFeesItems, flatDiscountFeesItems, flatDiscountFeesItemsAmount, partialFeesItemsAmount, fineAmount, totalPaidAmount, paymentMode, receivedDate, isdiscountApplied, discountType, discountPercentage, narration, createdBy, modifiedBy);
                if (selectedCheckBoxEmailId.equals("1")) {
                    this.exportAsEmail(receiptId);
                }
                if (selectedCheckBoxSmsId.equals("1")) {
                    Student student = this.receiptService.receiptById(receiptId).getStudent();
                    this.smsHandler.sentSMS("91" + student.getParentContact() + ",91" + student.getContact(), "Total Paid Amount = " + totalPaidAmount, institutionId);
                }
                redirectAttributes.addFlashAttribute("receiptId", (Object)receiptId);
                return "redirect:/receipt/generate";
            }
            if (paymentModeId == 2L) {
                paymentMode = this.paymentModeService.paymentModeById(paymentModeId);
                Date chequeReceivedDate = formatter.parse(request.getParameter("receivedDate"));
                String chequeNo = request.getParameter("chequeNo");
                Date chequeDate = formatter.parse(request.getParameter("chequeDate"));
                String chequeBankName = request.getParameter("chequeBankName");
                String chequeBranchName = request.getParameter("chequeBranchName");
                String createdBy = request.getSession().getAttribute("username").toString();
                String modifiedBy = request.getSession().getAttribute("username").toString();
                Long receiptId = this.receiptService.receiptByChequeAndPartialPayment(normalFeesItems, flatDiscountFeesItems, flatDiscountFeesItemsAmount, partialFeesItemsAmount, fineAmount, totalPaidAmount, paymentMode, chequeReceivedDate, chequeNo, chequeDate, chequeBankName, chequeBranchName, isdiscountApplied, discountType, discountPercentage, narration, createdBy, modifiedBy);
                if (selectedCheckBoxEmailId.equals("1")) {
                    this.exportAsEmail(receiptId);
                }
                if (selectedCheckBoxSmsId.equals("1")) {
                    Student student = this.receiptService.receiptById(receiptId).getStudent();
                    this.smsHandler.sentSMS("91" + student.getParentContact() + ",91" + student.getContact(), "Total Paid Amount = " + totalPaidAmount, institutionId);
                }
                redirectAttributes.addFlashAttribute("receiptId", (Object)receiptId);
                return "redirect:/receipt/generate";
            }
            if (paymentModeId != 3L) {
                throw new StudentReceiptException(new Message("failed", "Invalid Payment Method"));
            }
            paymentMode = this.paymentModeService.paymentModeById(paymentModeId);
            Date ddReceivedDate = formatter.parse(request.getParameter("receivedDate"));
            String ddNo = request.getParameter("ddNo");
            Date ddDate = formatter.parse(request.getParameter("ddDate"));
            String ddBankName = request.getParameter("ddBankName");
            String ddBranchName = request.getParameter("ddBranchName");
            String createdBy = request.getSession().getAttribute("username").toString();
            String modifiedBy = request.getSession().getAttribute("username").toString();
            Long receiptId = this.receiptService.receiptByDDAndPartialPayment(normalFeesItems, flatDiscountFeesItems, flatDiscountFeesItemsAmount, partialFeesItemsAmount, fineAmount, totalPaidAmount, paymentMode, ddReceivedDate, ddNo, ddDate, ddBankName, ddBranchName, isdiscountApplied, discountType, discountPercentage, narration, createdBy, modifiedBy);
            if (selectedCheckBoxEmailId.equals("1")) {
                this.exportAsEmail(receiptId);
            }
            if (selectedCheckBoxSmsId.equals("1")) {
                Student student = this.receiptService.receiptById(receiptId).getStudent();
                this.smsHandler.sentSMS("91" + student.getParentContact() + ",91" + student.getContact(), "Total Paid Amount = " + totalPaidAmount, institutionId);
            }
            redirectAttributes.addFlashAttribute("receiptId", (Object)receiptId);
            return "redirect:/receipt/generate";
        }
        catch (Exception e) {
            if (e.getClass().equals(ReceiptException.class)) {
                ReceiptException receiptException = (ReceiptException)e;
                redirectAttributes.addFlashAttribute("alert", (Object)receiptException.getCustomMessage());
                return "redirect:/receipt/generate";
            }
            return "redirect:/receipt/generate";
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @RequestMapping(value={"/refund/payment"}, method={RequestMethod.POST})
    public String generateRefundReceipt(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            PaymentMode paymentMode;
            int n;
            int n2;
            String[] stringArray;
            Integer i;
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            double fineAmount = 0.0;
            Integer discountApplied = Integer.parseInt(request.getParameter("isDiscountAppliedHF"));
            String selectedCheckBoxEmailId = request.getParameter("selectedCheckBoxEmailId");
            String selectedCheckBoxSmsId = request.getParameter("selectedCheckBoxSmsId");
            boolean isdiscountApplied = false;
            if (discountApplied == 1) {
                isdiscountApplied = true;
            } else if (discountApplied == 0) {
                isdiscountApplied = false;
            }
            String discountType = request.getParameter("disTypeHF");
            Double discountPercentage = null;
            if (discountType.equals("percentage")) {
                discountPercentage = Double.parseDouble(request.getParameter("disPerHF"));
            }
            String[] normalFeesItemsIds = request.getParameterValues("normalItem");
            Long[] normalFeesItems = null;
            String[] flatDiscountFeesItemsIds = request.getParameterValues("flatDiscountItem");
            Long[] flatDiscountFeesItems = null;
            String[] flatDiscountFeesItemsAmounts = request.getParameterValues("flatDiscountItemAmount");
            Double[] flatDiscountFeesItemsAmount = null;
            String[] partialFeesItemsAmounts = request.getParameterValues("partialItemAmount");
            Double[] partialFeesItemsAmount = null;
            String narration = null;
            if (!request.getParameter("fineAmount").isEmpty()) {
                fineAmount = Double.parseDouble(request.getParameter("fineAmount"));
            }
            if (!request.getParameter("narration").isEmpty()) {
                narration = request.getParameter("narration");
            }
            if (normalFeesItemsIds != null) {
                normalFeesItems = new Long[normalFeesItemsIds.length];
                i = 0;
                stringArray = normalFeesItemsIds;
                n2 = normalFeesItemsIds.length;
                n = 0;
                while (n < n2) {
                    String normalFeesItemsId = stringArray[n];
                    Integer n3 = i;
                    i = n3 + 1;
                    normalFeesItems[n3.intValue()] = Long.parseLong(normalFeesItemsId);
                    ++n;
                }
            }
            if (flatDiscountFeesItemsIds != null) {
                flatDiscountFeesItems = new Long[flatDiscountFeesItemsIds.length];
                i = 0;
                stringArray = flatDiscountFeesItemsIds;
                n2 = flatDiscountFeesItemsIds.length;
                n = 0;
                while (n < n2) {
                    String flatDiscountFeesItemsId = stringArray[n];
                    Integer n4 = i;
                    i = n4 + 1;
                    flatDiscountFeesItems[n4.intValue()] = Long.parseLong(flatDiscountFeesItemsId);
                    ++n;
                }
            }
            if (flatDiscountFeesItemsAmounts != null) {
                flatDiscountFeesItemsAmount = new Double[flatDiscountFeesItemsAmounts.length];
                i = 0;
                stringArray = flatDiscountFeesItemsAmounts;
                n2 = flatDiscountFeesItemsAmounts.length;
                n = 0;
                while (n < n2) {
                    String flatDiscountFeesItemAmount = stringArray[n];
                    Integer n5 = i;
                    i = n5 + 1;
                    flatDiscountFeesItemsAmount[n5.intValue()] = Double.parseDouble(flatDiscountFeesItemAmount);
                    ++n;
                }
            }
            if (partialFeesItemsAmounts != null) {
                partialFeesItemsAmount = new Double[partialFeesItemsAmounts.length];
                i = 0;
                stringArray = partialFeesItemsAmounts;
                n2 = partialFeesItemsAmounts.length;
                n = 0;
                while (n < n2) {
                    String partialFeesItemAmount = stringArray[n];
                    Integer n6 = i;
                    i = n6 + 1;
                    partialFeesItemsAmount[n6.intValue()] = Double.parseDouble(partialFeesItemAmount);
                    ++n;
                }
            }
            double totalPaidAmount = Double.parseDouble(request.getParameter("amount"));
            Long paymentModeId = Long.parseLong(request.getParameter("paymentMode"));
            String checkPaymentType = request.getParameter("checkPaymentType");
            if (checkPaymentType.equals("Full")) {
                if (paymentModeId == 1L) {
                    paymentMode = this.paymentModeService.paymentModeById(paymentModeId);
                    Date receivedDate = formatter.parse(request.getParameter("receivedDate"));
                    String createdBy = request.getSession().getAttribute("username").toString();
                    String modifiedBy = request.getSession().getAttribute("username").toString();
                    Long receiptId = this.studentFeeRefundReceiptService.receiptByCash(normalFeesItems, flatDiscountFeesItems, flatDiscountFeesItemsAmount, fineAmount, totalPaidAmount, paymentMode, receivedDate, isdiscountApplied, discountType, discountPercentage, narration, createdBy, modifiedBy);
                    if (selectedCheckBoxEmailId.equals("1")) {
                        this.exportAsEmailForRefund(receiptId);
                    }
                    if (selectedCheckBoxSmsId.equals("1")) {
                        Student student = this.studentFeeRefundReceiptService.receiptById(receiptId).getStudent();
                        this.smsHandler.sentSMS("91" + student.getParentContact() + ",91" + student.getContact(), "Total Paid Amount = " + totalPaidAmount, institutionId);
                    }
                    redirectAttributes.addFlashAttribute("receiptId", (Object)receiptId);
                    return "redirect:/receipt/refund";
                }
                if (paymentModeId == 2L) {
                    paymentMode = this.paymentModeService.paymentModeById(paymentModeId);
                    Date chequeReceivedDate = formatter.parse(request.getParameter("receivedDate"));
                    String chequeNo = request.getParameter("chequeNo");
                    Date chequeDate = formatter.parse(request.getParameter("chequeDate"));
                    String chequeBankName = request.getParameter("chequeBankName");
                    String chequeBranchName = request.getParameter("chequeBranchName");
                    String createdBy = request.getSession().getAttribute("username").toString();
                    String modifiedBy = request.getSession().getAttribute("username").toString();
                    Long receiptId = this.studentFeeRefundReceiptService.receiptByCheque(normalFeesItems, flatDiscountFeesItems, flatDiscountFeesItemsAmount, fineAmount, totalPaidAmount, paymentMode, chequeReceivedDate, chequeNo, chequeDate, chequeBankName, chequeBranchName, isdiscountApplied, discountType, discountPercentage, narration, createdBy, modifiedBy);
                    if (selectedCheckBoxEmailId.equals("1")) {
                        this.exportAsEmailForRefund(receiptId);
                    }
                    if (selectedCheckBoxSmsId.equals("1")) {
                        Student student = this.studentFeeRefundReceiptService.receiptById(receiptId).getStudent();
                        this.smsHandler.sentSMS("91" + student.getParentContact() + ",91" + student.getContact(), "Total Paid Amount = " + totalPaidAmount, institutionId);
                    }
                    redirectAttributes.addFlashAttribute("receiptId", (Object)receiptId);
                    return "redirect:/receipt/refund";
                }
                if (paymentModeId != 3L) {
                    throw new StudentFeeRefundReceiptException(new Message("failed", "Invalid Payment Method"));
                }
                paymentMode = this.paymentModeService.paymentModeById(paymentModeId);
                Date ddReceivedDate = formatter.parse(request.getParameter("receivedDate"));
                String ddNo = request.getParameter("ddNo");
                Date ddDate = formatter.parse(request.getParameter("ddDate"));
                String ddBankName = request.getParameter("ddBankName");
                String ddBranchName = request.getParameter("ddBranchName");
                String createdBy = request.getSession().getAttribute("username").toString();
                String modifiedBy = request.getSession().getAttribute("username").toString();
                Long receiptId = this.studentFeeRefundReceiptService.receiptByDD(normalFeesItems, flatDiscountFeesItems, flatDiscountFeesItemsAmount, fineAmount, totalPaidAmount, paymentMode, ddReceivedDate, ddNo, ddDate, ddBankName, ddBranchName, isdiscountApplied, discountType, discountPercentage, narration, createdBy, modifiedBy);
                if (selectedCheckBoxEmailId.equals("1")) {
                    this.exportAsEmailForRefund(receiptId);
                }
                if (selectedCheckBoxSmsId.equals("1")) {
                    Student student = this.studentFeeRefundReceiptService.receiptById(receiptId).getStudent();
                    this.smsHandler.sentSMS("91" + student.getParentContact() + ",91" + student.getContact(), "Total Paid Amount = " + totalPaidAmount, institutionId);
                }
                redirectAttributes.addFlashAttribute("receiptId", (Object)receiptId);
                return "redirect:/receipt/refund";
            }
            if (!checkPaymentType.equals("Partial")) {
                return "redirect:/receipt/refund";
            }
            if (paymentModeId == 1L) {
                paymentMode = this.paymentModeService.paymentModeById(paymentModeId);
                Date receivedDate = formatter.parse(request.getParameter("receivedDate"));
                String createdBy = request.getSession().getAttribute("username").toString();
                String modifiedBy = request.getSession().getAttribute("username").toString();
                Long receiptId = this.studentFeeRefundReceiptService.receiptByCashAndPartialPayment(normalFeesItems, flatDiscountFeesItems, flatDiscountFeesItemsAmount, partialFeesItemsAmount, fineAmount, totalPaidAmount, paymentMode, receivedDate, isdiscountApplied, discountType, discountPercentage, narration, createdBy, modifiedBy);
                if (selectedCheckBoxEmailId.equals("1")) {
                    this.exportAsEmailForRefund(receiptId);
                }
                if (selectedCheckBoxSmsId.equals("1")) {
                    Student student = this.studentFeeRefundReceiptService.receiptById(receiptId).getStudent();
                    this.smsHandler.sentSMS("91" + student.getParentContact() + ",91" + student.getContact(), "Total Paid Amount = " + totalPaidAmount, institutionId);
                }
                redirectAttributes.addFlashAttribute("receiptId", (Object)receiptId);
                return "redirect:/receipt/refund";
            }
            if (paymentModeId == 2L) {
                paymentMode = this.paymentModeService.paymentModeById(paymentModeId);
                Date chequeReceivedDate = formatter.parse(request.getParameter("receivedDate"));
                String chequeNo = request.getParameter("chequeNo");
                Date chequeDate = formatter.parse(request.getParameter("chequeDate"));
                String chequeBankName = request.getParameter("chequeBankName");
                String chequeBranchName = request.getParameter("chequeBranchName");
                String createdBy = request.getSession().getAttribute("username").toString();
                String modifiedBy = request.getSession().getAttribute("username").toString();
                Long receiptId = this.studentFeeRefundReceiptService.receiptByChequeAndPartialPayment(normalFeesItems, flatDiscountFeesItems, flatDiscountFeesItemsAmount, partialFeesItemsAmount, fineAmount, totalPaidAmount, paymentMode, chequeReceivedDate, chequeNo, chequeDate, chequeBankName, chequeBranchName, isdiscountApplied, discountType, discountPercentage, narration, createdBy, modifiedBy);
                if (selectedCheckBoxEmailId.equals("1")) {
                    this.exportAsEmailForRefund(receiptId);
                }
                if (selectedCheckBoxSmsId.equals("1")) {
                    Student student = this.studentFeeRefundReceiptService.receiptById(receiptId).getStudent();
                    this.smsHandler.sentSMS("91" + student.getParentContact() + ",91" + student.getContact(), "Total Paid Amount = " + totalPaidAmount, institutionId);
                }
                redirectAttributes.addFlashAttribute("receiptId", (Object)receiptId);
                return "redirect:/receipt/refund";
            }
            if (paymentModeId != 3L) {
                throw new StudentFeeRefundReceiptException(new Message("failed", "Invalid Payment Method"));
            }
            paymentMode = this.paymentModeService.paymentModeById(paymentModeId);
            Date ddReceivedDate = formatter.parse(request.getParameter("receivedDate"));
            String ddNo = request.getParameter("ddNo");
            Date ddDate = formatter.parse(request.getParameter("ddDate"));
            String ddBankName = request.getParameter("ddBankName");
            String ddBranchName = request.getParameter("ddBranchName");
            String createdBy = request.getSession().getAttribute("username").toString();
            String modifiedBy = request.getSession().getAttribute("username").toString();
            Long receiptId = this.studentFeeRefundReceiptService.receiptByDDAndPartialPayment(normalFeesItems, flatDiscountFeesItems, flatDiscountFeesItemsAmount, partialFeesItemsAmount, fineAmount, totalPaidAmount, paymentMode, ddReceivedDate, ddNo, ddDate, ddBankName, ddBranchName, isdiscountApplied, discountType, discountPercentage, narration, createdBy, modifiedBy);
            if (selectedCheckBoxEmailId.equals("1")) {
                this.exportAsEmailForRefund(receiptId);
            }
            if (selectedCheckBoxSmsId.equals("1")) {
                Student student = this.studentFeeRefundReceiptService.receiptById(receiptId).getStudent();
                this.smsHandler.sentSMS("91" + student.getParentContact() + ",91" + student.getContact(), "Total Paid Amount = " + totalPaidAmount, institutionId);
            }
            redirectAttributes.addFlashAttribute("receiptId", (Object)receiptId);
            return "redirect:/receipt/refund";
        }
        catch (Exception e) {
            if (e.getClass().equals(StudentFeeRefundReceiptException.class)) {
                StudentFeeRefundReceiptException receiptException = (StudentFeeRefundReceiptException)e;
                redirectAttributes.addFlashAttribute("alert", (Object)receiptException.getCustomMessage());
                return "redirect:/receipt/refund";
            }
            return "redirect:/receipt/refund";
        }
    }

    @RequestMapping(value={"print"})
    public ModelAndView printReceipt(HttpServletRequest request) throws Exception {
        try {
            ModelAndView modelandview = new ModelAndView("printreceipt");
            Long receiptId = Long.parseLong(request.getParameter("receiptId"));
            modelandview.addObject("studentReceipt", (Object)this.receiptService.getStudentReceiptDetails(receiptId));
            modelandview.addObject("numberConverter", (Object)this.decimalNumberToEnglishWords);
            return modelandview;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"/allStudent"}, method={RequestMethod.GET})
    @ResponseBody
    public List<Student> getAllStudentListForReceipt(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
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

    @RequestMapping(value={"receiptDelete"}, method={RequestMethod.POST})
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
                this.receiptService.deleteStudentReceiptsByAcademicYear(studentsId, academicYearId);
                redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Receipts Deleted Successfully...!"));
                return "redirect:/receipt/manage";
            }
            catch (Exception e) {
                if (e.getClass().equals(StudentReceiptException.class)) {
                    StudentReceiptException ex = (StudentReceiptException)e;
                    redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", ex.getMessage()));
                    return "redirect:/receipt/manage";
                }
                e.printStackTrace();
                return "redirect:/receipt/manage";
            }
        }
        throw new StudentReceiptException(new Message("failure", "No Student  Or Academic Year Selected"));
    }

    @RequestMapping(value={"refund/receiptDelete"}, method={RequestMethod.POST})
    public String deleteRefundReceipt(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
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
                this.studentFeeRefundReceiptService.deleteStudentFeeRefundReceiptsByAcademicYear(studentsId, academicYearId);
                redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Receipts Deleted Successfully...!"));
                return "redirect:/receipt/manage/refund";
            }
            catch (Exception e) {
                if (e.getClass().equals(StudentFeeRefundReceiptException.class)) {
                    StudentFeeRefundReceiptException ex = (StudentFeeRefundReceiptException)e;
                    redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", ex.getMessage()));
                    return "redirect:/receipt/manage/refund";
                }
                e.printStackTrace();
                return "redirect:/receipt/manage/refund";
            }
        }
        throw new StudentFeeRefundReceiptException(new Message("failure", "No Student  Or Academic Year Selected"));
    }

    @RequestMapping(value={"printPage"})
    public ModelAndView printPageReceipt(HttpServletRequest request) throws Exception {
        try {
            ModelAndView modelandview = new ModelAndView("receiptprint");
            Long receiptId = Long.parseLong(request.getParameter("receiptId"));
            modelandview.addObject("studentReceipt", (Object)this.receiptService.getStudentReceiptDetails(receiptId));
            modelandview.addObject("numberConverter", (Object)this.decimalNumberToEnglishWords);
            return modelandview;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"refund/printPage"})
    public ModelAndView printPageRefundReceipt(HttpServletRequest request) throws Exception {
        try {
            ModelAndView modelandview = new ModelAndView("refundreceiptprint");
            Long receiptId = Long.parseLong(request.getParameter("receiptId"));
            modelandview.addObject("studentReceipt", (Object)this.studentFeeRefundReceiptService.getStudentFeeRefundReceiptDetails(receiptId));
            modelandview.addObject("numberConverter", (Object)this.decimalNumberToEnglishWords);
            return modelandview;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"/byAdmissionNo"})
    @ResponseBody
    public ArrayList<StudentReceipt> getStudentReceiptsByAdmisionNo(HttpServletRequest request) {
        try {
            String admissionNo = request.getParameter("admissionNo");
            return this.receiptService.getStudentReceiptsByAdmisssionNo(admissionNo);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/reconcillation"})
    @PreAuthorize(value="hasAuthority('feesManagement/reconcillation')")
    public ModelAndView displayReconcillationPage(HttpServletRequest request) {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed Reconcillation page"));
            ModelAndView modelandview = new ModelAndView("reconcillation");
            String institutioncurrencycode = request.getSession().getAttribute("institutioncurrency").toString();
            modelandview.addObject("currencycode", (Object)institutioncurrencycode);
            modelandview.addObject("paymentModes", this.paymentModeService.paymentModeList());
            return modelandview;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            e.printStackTrace();
            throw null;
        }
    }

    @RequestMapping(value={"/amounttobeCollected"}, method={RequestMethod.GET})
    @ResponseBody
    public Long amountTobeCollected(HttpServletRequest request) {
        try {
            String discountMethod = request.getParameter("discountMethod");
            Long amountToBeCollected = 0L;
            String[] normalFeesItemIds = request.getParameterValues("finalNormalFeesItemIds[]");
            Long[] feesItemIds = new Long[normalFeesItemIds.length];
            int i = 0;
            while (i < normalFeesItemIds.length) {
                String feesItem = normalFeesItemIds[i];
                feesItemIds[i] = Long.parseLong(feesItem);
                ++i;
            }
            if (discountMethod.equals("none")) {
                amountToBeCollected = this.receiptService.amountTobeCollectedWhenNoDiscount(feesItemIds);
            } else if (discountMethod.equals("flat")) {
                String[] normalFlatDiscountAmounts = request.getParameterValues("finalSelectedFeesItemFlatDiscountAmounts[]");
                Double[] flatDiscounts = new Double[normalFlatDiscountAmounts.length];
                int i2 = 0;
                while (i2 < normalFeesItemIds.length) {
                    String amount = normalFlatDiscountAmounts[i2];
                    flatDiscounts[i2] = Double.parseDouble(amount);
                    ++i2;
                }
                amountToBeCollected = this.receiptService.amountTobeCollectedOnFlatDiscount(feesItemIds, flatDiscounts);
            } else if (discountMethod.equals("percentage")) {
                Double percentage = Double.parseDouble(request.getParameter("percentage"));
                amountToBeCollected = this.receiptService.amountTobeCollectedOnPercentageDiscount(feesItemIds, percentage);
            } else if (discountMethod.equals("refund")) {
                amountToBeCollected = this.receiptService.amountTobeCollectedForRefund(feesItemIds);
            }
            return amountToBeCollected;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"/amounttobeCollectedWithPartialAmount"}, method={RequestMethod.GET})
    @ResponseBody
    public Long amountTobeCollectedWithPartialAmount(HttpServletRequest request) {
        try {
            String discountMethod = request.getParameter("discountMethod");
            Long amountToBeCollected = 0L;
            String[] normalFeesItemIds = request.getParameterValues("finalNormalFeesItemIds[]");
            Long[] feesItemIds = new Long[normalFeesItemIds.length];
            int i = 0;
            while (i < normalFeesItemIds.length) {
                String feesItem = normalFeesItemIds[i];
                feesItemIds[i] = Long.parseLong(feesItem);
                ++i;
            }
            if (discountMethod.equals("none")) {
                String[] normalPartialAmounts = request.getParameterValues("allSelectedFeesItemPartialAmounts[]");
                Double[] partialAmounts = new Double[normalPartialAmounts.length];
                int i2 = 0;
                while (i2 < normalFeesItemIds.length) {
                    String amount = normalPartialAmounts[i2];
                    partialAmounts[i2] = Double.parseDouble(amount);
                    ++i2;
                }
                amountToBeCollected = this.receiptService.amountTobeCollectedWhenNoDiscountAndPartialAmount(feesItemIds, partialAmounts);
            } else if (discountMethod.equals("flat")) {
                String[] normalFlatDiscountAmounts = request.getParameterValues("finalSelectedFeesItemFlatDiscountAmounts[]");
                Double[] flatDiscounts = new Double[normalFlatDiscountAmounts.length];
                int i3 = 0;
                while (i3 < normalFeesItemIds.length) {
                    String amount = normalFlatDiscountAmounts[i3];
                    flatDiscounts[i3] = Double.parseDouble(amount);
                    ++i3;
                }
                String[] normalPartialAmounts = request.getParameterValues("allSelectedFeesItemPartialAmounts[]");
                Double[] partialAmounts = new Double[normalPartialAmounts.length];
                int i4 = 0;
                while (i4 < normalFeesItemIds.length) {
                    String amount = normalPartialAmounts[i4];
                    partialAmounts[i4] = Double.parseDouble(amount);
                    ++i4;
                }
                amountToBeCollected = this.receiptService.amountTobeCollectedOnFlatDiscountAndPartialAmount(feesItemIds, flatDiscounts, partialAmounts);
            } else if (discountMethod.equals("percentage")) {
                Double percentage = Double.parseDouble(request.getParameter("percentage"));
                String[] normalPartialAmounts = request.getParameterValues("allSelectedFeesItemPartialAmounts[]");
                Double[] partialAmounts = new Double[normalPartialAmounts.length];
                int i5 = 0;
                while (i5 < normalFeesItemIds.length) {
                    String amount = normalPartialAmounts[i5];
                    partialAmounts[i5] = Double.parseDouble(amount);
                    ++i5;
                }
                amountToBeCollected = this.receiptService.amountTobeCollectedOnPercentageDiscountAndPartialAmount(feesItemIds, percentage, partialAmounts);
            }
            return amountToBeCollected;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"/fineamounttobeCollected"}, method={RequestMethod.GET})
    @ResponseBody
    public Long fineAmountAutomaticCalculation(HttpServletRequest request) {
        try {
            Long invoiceId = Long.parseLong(request.getParameter("invoiceId"));
            Long amountToBeCollected = 0L;
            amountToBeCollected = this.receiptService.fineamountautomaticcalculation(invoiceId);
            return amountToBeCollected;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"byPaymentModeAndStatus"}, method={RequestMethod.GET})
    @ResponseBody
    public ArrayList<StudentReceipt> studentReceiptsByPaymentMode(HttpServletRequest request) {
        try {
            Long paymentModeId = Long.parseLong(request.getParameter("paymentModeId"));
            Long paymentStatusId = Long.parseLong(request.getParameter("paymentStatusId"));
            return this.receiptService.getStudentReceiptsFromPaymentModeAndStatus(paymentModeId, paymentStatusId);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @RequestMapping(value={"cashRecon"}, method={RequestMethod.POST})
    public String updateReconcillation(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            String[] cashReconReceiptId = request.getParameterValues("cashReconReceiptId");
            Long[] cashReconReceipt = new Long[cashReconReceiptId.length];
            int i = 0;
            while (i < cashReconReceiptId.length) {
                String cashReceiptId = cashReconReceiptId[i];
                cashReconReceipt[i] = Long.parseLong(cashReceiptId.trim());
                ++i;
            }
            Long cashReconPaymentStatusId = Long.parseLong(request.getParameter("cashReconPaymentStatusId"));
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date clearanceDate = formatter.parse(request.getParameter("clearanceDate"));
            String comment = request.getParameter("cashReconComment");
            String receiptClearedBy = request.getSession().getAttribute("username").toString();
            this.receiptService.updateReconcillation(cashReconReceipt, cashReconPaymentStatusId, clearanceDate, comment, receiptClearedBy);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Updated Successfully...!"));
            return "redirect:/receipt/reconcillation";
        }
        catch (Exception e) {
            if (e.getClass().equals(StudentReceiptException.class)) {
                StudentReceiptException studentReceiptException = (StudentReceiptException)e;
                redirectAttributes.addFlashAttribute("alert", (Object)studentReceiptException.getCustomMessage());
                return "redirect:/receipt/reconcillation";
            }
            e.printStackTrace();
            return "redirect:/receipt/reconcillation";
        }
    }

    @RequestMapping(value={"chequeRecon"}, method={RequestMethod.POST})
    public String updateChequeReconcillation(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            String[] chequeReconReceiptId = request.getParameterValues("chequeReconReceiptId");
            Long[] chequeReconReceipt = new Long[chequeReconReceiptId.length];
            int i = 0;
            while (i < chequeReconReceiptId.length) {
                String chequeReceiptId = chequeReconReceiptId[i];
                chequeReconReceipt[i] = Long.parseLong(chequeReceiptId.trim());
                ++i;
            }
            Long chequeReconPaymentStatusId = Long.parseLong(request.getParameter("chequeReconPaymentStatusId"));
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date clearanceDate = formatter.parse(request.getParameter("chequeReconClearanceDate"));
            String comment = request.getParameter("chequeReconComment");
            String receiptClearedBy = request.getSession().getAttribute("username").toString();
            this.receiptService.updateChequeReconcillation(chequeReconReceipt, chequeReconPaymentStatusId, clearanceDate, comment, receiptClearedBy);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Updated Successfully...!"));
            return "redirect:/receipt/reconcillation";
        }
        catch (Exception e) {
            if (e.getClass().equals(StudentReceiptException.class)) {
                StudentReceiptException studentReceiptException = (StudentReceiptException)e;
                redirectAttributes.addFlashAttribute("alert", (Object)studentReceiptException.getCustomMessage());
                return "redirect:/receipt/reconcillation";
            }
            e.printStackTrace();
            return "redirect:/receipt/reconcillation";
        }
    }

    @RequestMapping(value={"ddRecon"}, method={RequestMethod.POST})
    public String updateddReconcillation(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            String[] ddReconReceiptId = request.getParameterValues("ddReconReceiptId");
            Long[] ddReconReceipt = new Long[ddReconReceiptId.length];
            int i = 0;
            while (i < ddReconReceiptId.length) {
                String ddReceiptId = ddReconReceiptId[i];
                ddReconReceipt[i] = Long.parseLong(ddReceiptId.trim());
                ++i;
            }
            Long ddReconPaymentStatusId = Long.parseLong(request.getParameter("ddReconPaymentStatusId"));
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date clearanceDate = formatter.parse(request.getParameter("ddReconClearanceDate"));
            String comment = request.getParameter("ddReconComment");
            String receiptClearedBy = request.getSession().getAttribute("username").toString();
            this.receiptService.updateDdReconcillation(ddReconReceipt, ddReconPaymentStatusId, clearanceDate, comment, receiptClearedBy);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Updated Successfully...!"));
            return "redirect:/receipt/reconcillation";
        }
        catch (Exception e) {
            if (e.getClass().equals(StudentReceiptException.class)) {
                StudentReceiptException studentReceiptException = (StudentReceiptException)e;
                redirectAttributes.addFlashAttribute("alert", (Object)studentReceiptException.getCustomMessage());
                return "redirect:/receipt/reconcillation";
            }
            e.printStackTrace();
            return "redirect:/receipt/reconcillation";
        }
    }

    public String hashCal(String type, String str) {
        byte[] hashseq = str.getBytes();
        StringBuffer hexString = new StringBuffer();
        try {
            MessageDigest algorithm = MessageDigest.getInstance(type);
            algorithm.reset();
            algorithm.update(hashseq);
            byte[] messageDigest = algorithm.digest();
            int i = 0;
            while (i < messageDigest.length) {
                String hex = Integer.toHexString(0xFF & messageDigest[i]);
                if (hex.length() == 1) {
                    hexString.append("0");
                }
                hexString.append(hex);
                ++i;
            }
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            // empty catch block
        }
        return hexString.toString();
    }

    public void exportAsEmailForRefund(Long receiptId) throws Exception {
        try {
            StudentFeeRefundReceipt studentFeeRefundReceipt = this.studentFeeRefundReceiptService.getStudentFeeRefundReceiptDetails(receiptId);
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String content = null;
            StringBuilder htmlBuilder = new StringBuilder();
            if (studentFeeRefundReceipt != null) {
                htmlBuilder.append("<html>");
                htmlBuilder.append("<body><header class='clearfix'><h2 ><label >" + studentFeeRefundReceipt.getStudent().getInstitution().getInstitutionName() + "</label></h2>" + "<h3 ><label>(Affiliated to the Central Board Of Secondary Education)</label></h3>" + "<h4 ><label >" + studentFeeRefundReceipt.getStudent().getInstitution().getInstitutionAddressline1() + ", " + studentFeeRefundReceipt.getInstitution().getInstitutionAddressline2() + "," + studentFeeRefundReceipt.getInstitution().getInstitutionCity() + "-" + studentFeeRefundReceipt.getInstitution().getInstitutionPostcode() + "</label></h2>" + "<br><br>" + "<div id='company1'><div style='margin-top: -30px;margin-bottom: 4px;'> <span style='margin-left:-7px'>REFUND RECEIPT NO:</span>" + studentFeeRefundReceipt.getStudentFeeRefundReceiptId() + "<br></div><div style='margin-bottom: 0px;'<span style='margin-right:30px'>DATE:</span>" + formatter.format(studentFeeRefundReceipt.getPaymentReceivedDate()) + "</div></div><br><h1></h1>" + " <div id='project'><div style='margin-bottom: 4px;'><span>NAME<label style='margin-left:92px;'>:</label>  </span><label style='margin-left:0px;'>" + studentFeeRefundReceipt.getStudent().getFirstName() + "<div style='margin-bottom: 4px;'><span>ADMISSION NO <label style='margin-left:17px;'>:</label></span><label style='margin-left:0px;'>" + studentFeeRefundReceipt.getStudent().getAdmissionNo() + "</label></div>" + "<div style='margin-bottom: 4px;' ><span>CLASS & SECTION<label>:</label></span><label>" + studentFeeRefundReceipt.getStudent().getStudentClass().getClassName() + " & " + studentFeeRefundReceipt.getStudent().getSection().getSectionName() + "</label></div>" + "<br><br>");
                if (studentFeeRefundReceipt.getPaymentMode() != null) {
                    htmlBuilder.append("<table border='1'> <thead style='border-top:2px solid black;text-align: center;border-bottom:2px solid black;border-left:2px solid black;border-right:2px solid black;'><tr><th class='service' style='color:#000000'>Payment Mode</th><th class='deschead' style='width:300px;color:#000000' >DD/Cheque No</th><th class='deschead' style='color:#000000'>Bank Name</th><th class='deschead' style='color:#000000'>Bank Branch</th></tr></thead><tbody style='border-top:2px solid black;border-bottom:2px solid black;border-left:2px solid black;border-right:2px solid black;'>");
                    if (studentFeeRefundReceipt.getPaymentMode().getPaymentModeId() == 1L) {
                        htmlBuilder.append("<tr style='text-align: center;'><td class='service'>" + studentFeeRefundReceipt.getPaymentMode().getPaymentModeTitle() + "</td><td class='service'>-</td><td class='service'>-</td><td class='service'>-</td></tr>");
                    }
                    if (studentFeeRefundReceipt.getPaymentMode().getPaymentModeId() == 2L) {
                        htmlBuilder.append("<tr style='text-align: center;'><td class='service'>" + studentFeeRefundReceipt.getPaymentMode().getPaymentModeTitle() + "</td><td class='service'>" + studentFeeRefundReceipt.getChequeNumber() + "</td><td class='service'>" + studentFeeRefundReceipt.getChequeBankName() + "</td><td class='service'>" + studentFeeRefundReceipt.getChequeBranchName() + "</td></tr>");
                    }
                    if (studentFeeRefundReceipt.getPaymentMode().getPaymentModeId() == 3L) {
                        htmlBuilder.append("<tr style='text-align: center;'><td class='service'>" + studentFeeRefundReceipt.getPaymentMode().getPaymentModeTitle() + "</td><td class='service'>" + studentFeeRefundReceipt.getDdNumber() + "</td><td class='service'>" + studentFeeRefundReceipt.getDdBankName() + "</td><td class='service'>" + studentFeeRefundReceipt.getDdBranchName() + "</td></tr>");
                    }
                    if (studentFeeRefundReceipt.getPaymentMode().getPaymentModeId() == 4L) {
                        htmlBuilder.append("<tr style='text-align: center;'><td class='service'>" + studentFeeRefundReceipt.getPaymentMode().getPaymentModeTitle() + "</td><td class='service'>-</td><td class='service'>-</td><td class='service'>-</td></tr>");
                    }
                    htmlBuilder.append("</tbody></table>");
                }
                double grandTotal = 0.0;
                double subTotal = 0.0;
                int serialNumber = 1;
                htmlBuilder.append("<br><br><table border='1'><thead style='border-top:2px solid black;border-bottom:2px solid black;border-left:2px solid black;border-right:2px solid black;'><tr><th class='service' style='color:#000000'>SERIAL NO</th><th class='deschead' style='width:500px;color:#000000'>FEE DESCRIPTION</th><th style='color:#000000'>REFUND AMOUNT</th></tr></thead><tbody style='border-top:2px solid black;border-bottom:2px solid black;border-left:2px solid black;border-right:2px solid black;'>");
                if (!studentFeeRefundReceipt.getStudentFeeRefundReceiptDetails().isEmpty()) {
                    for (StudentFeeRefundReceiptDetail receiptDetail : studentFeeRefundReceipt.getStudentFeeRefundReceiptDetails()) {
                        htmlBuilder.append("<tr style='text-align: center;'><td class='service'>" + serialNumber + "</td><td class='desc'>" + receiptDetail.getStudentInvoiceDetail().getFeesItem().getFeesItemName() + "</td><td class='total'>" + receiptDetail.getPaidReceiptAmount() + "</td></tr>");
                        ++serialNumber;
                        subTotal += receiptDetail.getPaidReceiptAmount().doubleValue();
                    }
                }
                htmlBuilder.append("<tr><td colspan='2' style='color:red;font-weight: bold;text-align: right''>SUB TOTAL</td><td class='sub Total'style='text-align: center;'>" + subTotal + "</td></tr>");
                grandTotal = subTotal;
                htmlBuilder.append("<tr><td colspan='2' style='color:red; font-weight: bold;text-align: right;' class='grand total'><b>TOTAL</b></td><td class='grand total' style='text-align: center;'><b>" + grandTotal + "</b></td></tr>" + " <tr><td style='color:red; font-weight: bold;' class='Narration'><b>Narration</b></td><td colspan='2' class='grand total' style='text-align: left'>&nbsp;" + studentFeeRefundReceipt.getNarration() + "</td></tr>" + " <tr><td  colspan='2' style='text-align:left;height:50px'>Amount In Words :<label style='color: red'>" + DecimalNumberToEnglishWords.doubleConvert(grandTotal).toUpperCase() + "RUPEES ONLY</label></td><td style=' text-align:center;height:80px'>Cashier Signature</td></tr>" + "</tbody></table>" + "<br><br>" + "<div id='notices'> <div>NOTE:</div><div class='notice'>Receipt  is subject to realization of the payment made.</div></div>" + "</main></body>");
                htmlBuilder.append("</html>");
                content = htmlBuilder.toString();
            }
            this.emailHandler.sendEmail(studentFeeRefundReceipt.getStudent().getEmail(), studentFeeRefundReceipt.getStudent().getParentGuardianEmail(), "Receipt for" + studentFeeRefundReceipt.getStudentInvoice().getFeesTerm().getFeesTermName() + "(" + studentFeeRefundReceipt.getPaymentReceivedDate() + ")", content);
        }
        catch (Exception e) {
            if (e.getClass().equals(MailSendException.class)) {
                throw new ReceiptException(new Message("failure", "No Internet Connnetion Found ! Please Check The Connection But Receipt Generated."));
            }
            throw e;
        }
    }

    public void exportAsEmail(Long receiptId) throws Exception {
        try {
            StudentReceipt studentReceipt = this.receiptService.getStudentReceiptDetails(receiptId);
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String content = null;
            StringBuilder htmlBuilder = new StringBuilder();
            if (studentReceipt != null) {
                htmlBuilder.append("<html>");
                htmlBuilder.append("<body><header class='clearfix'><h2 ><label >" + studentReceipt.getStudent().getInstitution().getInstitutionName() + "</label></h2>" + "<h3 ><label>(Affiliated to the Central Board Of Secondary Education)</label></h3>" + "<h4 ><label >" + studentReceipt.getStudent().getInstitution().getInstitutionAddressline1() + ", " + studentReceipt.getInstitution().getInstitutionAddressline2() + "," + studentReceipt.getInstitution().getInstitutionCity() + "-" + studentReceipt.getInstitution().getInstitutionPostcode() + "</label></h2>" + "<br><br>" + "<div id='company1'><div style='margin-top: -30px;margin-bottom: 4px;'> <span style='margin-left:-7px'>RECEIPT NO:</span>" + studentReceipt.getReceiptId() + "<br></div><div style='margin-bottom: 0px;'<span style='margin-right:30px'>DATE:</span>" + formatter.format(studentReceipt.getPaymentReceivedDate()) + "</div></div><br><h1></h1>" + " <div id='project'><div style='margin-bottom: 4px;'><span>NAME<label style='margin-left:92px;'>:</label>  </span><label style='margin-left:0px;'>" + studentReceipt.getStudent().getFirstName() + "<div style='margin-bottom: 4px;'><span>ADMISSION NO <label style='margin-left:17px;'>:</label></span><label style='margin-left:0px;'>" + studentReceipt.getStudent().getAdmissionNo() + "</label></div>" + "<div style='margin-bottom: 4px;' ><span>CLASS & SECTION<label>:</label></span><label>" + studentReceipt.getStudent().getStudentClass().getClassName() + " & " + studentReceipt.getStudent().getSection().getSectionName() + "</label></div>" + "<br><br>");
                if (studentReceipt.getPaymentMode() != null) {
                    htmlBuilder.append("<table border='1'> <thead style='border-top:2px solid black;text-align: center;border-bottom:2px solid black;border-left:2px solid black;border-right:2px solid black;'><tr><th class='service' style='color:#000000'>Payment Mode</th><th class='deschead' style='width:300px;color:#000000' >DD/Cheque No</th><th class='deschead' style='color:#000000'>Bank Name</th><th class='deschead' style='color:#000000'>Bank Branch</th></tr></thead><tbody style='border-top:2px solid black;border-bottom:2px solid black;border-left:2px solid black;border-right:2px solid black;'>");
                    if (studentReceipt.getPaymentMode().getPaymentModeId() == 1L) {
                        htmlBuilder.append("<tr style='text-align: center;'><td class='service'>" + studentReceipt.getPaymentMode().getPaymentModeTitle() + "</td><td class='service'>-</td><td class='service'>-</td><td class='service'>-</td></tr>");
                    }
                    if (studentReceipt.getPaymentMode().getPaymentModeId() == 2L) {
                        htmlBuilder.append("<tr style='text-align: center;'><td class='service'>" + studentReceipt.getPaymentMode().getPaymentModeTitle() + "</td><td class='service'>" + studentReceipt.getChequeNumber() + "</td><td class='service'>" + studentReceipt.getChequeBankName() + "</td><td class='service'>" + studentReceipt.getChequeBranchName() + "</td></tr>");
                    }
                    if (studentReceipt.getPaymentMode().getPaymentModeId() == 3L) {
                        htmlBuilder.append("<tr style='text-align: center;'><td class='service'>" + studentReceipt.getPaymentMode().getPaymentModeTitle() + "</td><td class='service'>" + studentReceipt.getDdNumber() + "</td><td class='service'>" + studentReceipt.getDdBankName() + "</td><td class='service'>" + studentReceipt.getDdBranchName() + "</td></tr>");
                    }
                    if (studentReceipt.getPaymentMode().getPaymentModeId() == 4L) {
                        htmlBuilder.append("<tr style='text-align: center;'><td class='service'>" + studentReceipt.getPaymentMode().getPaymentModeTitle() + "</td><td class='service'>-</td><td class='service'>-</td><td class='service'>-</td></tr>");
                    }
                    htmlBuilder.append("</tbody></table>");
                }
                double grandTotal = 0.0;
                double subTotal = 0.0;
                double subTotalForActualAmount = 0.0;
                double subTotalForDiscountAmount = 0.0;
                int serialNumber = 1;
                htmlBuilder.append("<br><br><table border='1'><thead style='border-top:2px solid black;border-bottom:2px solid black;border-left:2px solid black;border-right:2px solid black;'><tr><th class='service' style='color:#000000'>SERIAL NO</th><th class='deschead' style='width:500px;color:#000000'>FEE DESCRIPTION</th><th style='color:#000000'>ACTUAL AMOUNT</th><th style='color:#000000'>DISCOUNT AMOUNT</th><th style='color:#000000'>PAID AMOUNT</th></tr></thead><tbody style='border-top:2px solid black;border-bottom:2px solid black;border-left:2px solid black;border-right:2px solid black;'>");
                if (!studentReceipt.getReceiptDetails().isEmpty()) {
                    for (StudentReceiptDetail receiptDetail : studentReceipt.getReceiptDetails()) {
                        htmlBuilder.append("<tr style='text-align: center;'><td class='service'>" + serialNumber + "</td><td class='desc'>" + receiptDetail.getStudentInvoiceDetail().getFeesItem().getFeesItemName() + "</td><td class='total'>" + receiptDetail.getActualReceiptAmount() + "</td><td class='total'>" + receiptDetail.getDiscountAmount() + "</td><td class='total'>" + receiptDetail.getPaidReceiptAmount() + "</td></tr>");
                        ++serialNumber;
                        subTotalForActualAmount += receiptDetail.getActualReceiptAmount().doubleValue();
                        subTotalForDiscountAmount += receiptDetail.getDiscountAmount().doubleValue();
                        subTotal += receiptDetail.getPaidReceiptAmount().doubleValue();
                    }
                }
                htmlBuilder.append("<tr><td colspan='2' style='color:red;font-weight: bold;text-align: right''>SUB TOTAL</td><td class='sub Total For  ActualAmount' style='text-align: center;'>" + subTotalForActualAmount + "</td><td class='sub Total For Discount Amount' style='text-align: center;'>" + subTotalForDiscountAmount + "</td><td class='sub Total'style='text-align: center;'>" + subTotal + "</td></tr>");
                if (!studentReceipt.getReceiptFines().isEmpty()) {
                    for (StudentReceiptFine receiptFine : studentReceipt.getReceiptFines()) {
                        htmlBuilder.append("<tr><td colspan='4' class='' style='color: red;text-align: right;font-weight: bold'>" + receiptFine.getFineTitle() + "</td><td class='total' style='text-align: center;'>" + receiptFine.getFineAmount() + "</td></tr>");
                        grandTotal = subTotal + receiptFine.getFineAmount();
                    }
                } else {
                    grandTotal = subTotal;
                }
                htmlBuilder.append("<tr><td colspan='4' style='color:red; font-weight: bold;text-align: right;' class='grand total'><b>TOTAL</b></td><td class='grand total' style='text-align: center;'><b>" + grandTotal + "</b></td></tr>" + " <tr><td style='color:red; font-weight: bold;' class='Narration'><b>Narration</b></td><td colspan='5' class='grand total' style='text-align: left'>&nbsp;" + studentReceipt.getNarration() + "</td></tr>" + " <tr><td  colspan='4' style='text-align:left;height:50px'>Amount In Words :<label style='color: red'>" + DecimalNumberToEnglishWords.doubleConvert(grandTotal).toUpperCase() + "RUPEES ONLY</label></td><td style=' text-align:center;height:80px'>Cashier Signature</td></tr>" + "</tbody></table>" + "<br><br>" + "<div id='notices'> <div>NOTE:</div><div class='notice'>Receipt  is subject to realization of the payment made.</div></div>" + "</main></body>");
                htmlBuilder.append("</html>");
                content = htmlBuilder.toString();
            }
            this.emailHandler.sendEmail(studentReceipt.getStudent().getEmail(), studentReceipt.getStudent().getParentGuardianEmail(), "Receipt for" + studentReceipt.getStudentInvoice().getFeesTerm().getFeesTermName() + "(" + studentReceipt.getPaymentReceivedDate() + ")", content);
        }
        catch (Exception e) {
            if (e.getClass().equals(MailSendException.class)) {
                throw new ReceiptException(new Message("failure", "No Internet Connnetion Found ! Please Check The Connection But Receipt Generated."));
            }
            throw e;
        }
    }
}
