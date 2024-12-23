/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.ServletOutputStream
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Controller
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RequestMethod
 *  org.springframework.web.bind.annotation.ResponseBody
 *  org.springframework.web.servlet.ModelAndView
 */
package in.jdsoft.educationmanagement.school.controller;

import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.StudentInvoice;
import in.jdsoft.educationmanagement.school.model.StudentInvoiceDetail;
import in.jdsoft.educationmanagement.school.reports.model.NineFieldReports;
import in.jdsoft.educationmanagement.school.reports.model.SixFieldReports;
import in.jdsoft.educationmanagement.school.services.AcademicYearService;
import in.jdsoft.educationmanagement.school.services.FeesItemService;
import in.jdsoft.educationmanagement.school.services.FeesStructureService;
import in.jdsoft.educationmanagement.school.services.FeesTermService;
import in.jdsoft.educationmanagement.school.services.InstitutionConfigDetailsService;
import in.jdsoft.educationmanagement.school.services.InstitutionService;
import in.jdsoft.educationmanagement.school.services.InvoiceService;
import in.jdsoft.educationmanagement.school.services.PaymentModeService;
import in.jdsoft.educationmanagement.school.services.ReceiptService;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value={"/report"})
public class ReportController {
    @Autowired
    InvoiceService invoiceServices;
    @Autowired
    InstitutionService institutionServices;
    @Autowired
    ReceiptService receiptServices;
    @Autowired
    AcademicYearService academicYearServices;
    @Autowired
    FeesStructureService feesStructureServices;
    @Autowired
    FeesItemService feesItemServices;
    @Autowired
    PaymentModeService paymentServices;
    @Autowired
    ReceiptService receiptService;
    @Autowired
    FeesTermService feesTermService;
    @Autowired
    InstitutionConfigDetailsService institutionConfigDetailsService;

    @RequestMapping(value={"studentWise"})
    public ModelAndView displayTermFeesReportPage(HttpServletRequest request) {
        try {
            Long instituteId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            ModelAndView mv = new ModelAndView("studentwisefeesreport");
            String institutioncurrencycode = request.getSession().getAttribute("institutioncurrency").toString();
            mv.addObject("currencycode", (Object)institutioncurrencycode);
            mv.addObject("academicYears", this.academicYearServices.academicYearList());
            if (request.getSession().getAttribute("institutiontype").toString().equals("true")) {
                if (request.getSession().getAttribute("feeadminadmintype").toString().equals("1")) {
                    mv.addObject("feesCategories", this.feesTermService.feesTermList());
                    mv.addObject("feesItems", this.feesItemServices.feesItemList());
                } else {
                    mv.addObject("feesCategories", this.feesTermService.feesTermList(instituteId));
                    mv.addObject("feesItems", this.feesItemServices.feesItemList(instituteId));
                }
            }
            return mv;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"studentWise/refund"})
    public ModelAndView displayTermFeesRefundReportPage(HttpServletRequest request) {
        try {
            Long instituteId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            ModelAndView mv = new ModelAndView("studentwisefeesrefundreport");
            String institutioncurrencycode = request.getSession().getAttribute("institutioncurrency").toString();
            mv.addObject("currencycode", (Object)institutioncurrencycode);
            mv.addObject("academicYears", this.academicYearServices.academicYearList());
            if (request.getSession().getAttribute("institutiontype").toString().equals("true")) {
                if (request.getSession().getAttribute("feeadminadmintype").toString().equals("1")) {
                    mv.addObject("feesCategories", this.feesTermService.feesTermList());
                    mv.addObject("feesItems", this.feesItemServices.feesItemList());
                } else {
                    mv.addObject("feesCategories", this.feesTermService.feesTermList(instituteId));
                    mv.addObject("feesItems", this.feesItemServices.feesItemList(instituteId));
                }
            }
            return mv;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"accountingfeesreport"})
    public ModelAndView displayAccountingFeesReportPage(HttpServletRequest request) {
        try {
            ModelAndView mv = new ModelAndView("accountingfeesreport");
            String institutioncurrencycode = request.getSession().getAttribute("institutioncurrency").toString();
            mv.addObject("currencycode", (Object)institutioncurrencycode);
            return mv;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"accountingfeesreportbasedtaxclass"})
    public ModelAndView displayAccountingFeesReportBasedTAXPage(HttpServletRequest request) {
        try {
            ModelAndView mv = new ModelAndView("accountingfeesreportbasedtaxclass");
            String institutioncurrencycode = request.getSession().getAttribute("institutioncurrency").toString();
            mv.addObject("currencycode", (Object)institutioncurrencycode);
            return mv;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"academicfeesreport"})
    public ModelAndView displayAcademicFeesReportPage(HttpServletRequest request) {
        try {
            ModelAndView mv = new ModelAndView("academicfeesreport");
            String institutioncurrencycode = request.getSession().getAttribute("institutioncurrency").toString();
            mv.addObject("academicYears", this.academicYearServices.academicYearList());
            mv.addObject("currencycode", (Object)institutioncurrencycode);
            return mv;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"academicfeesreportbasedtaxclass"})
    public ModelAndView displayAcademicFeesReportBasedTAXClassPage(HttpServletRequest request) {
        try {
            ModelAndView mv = new ModelAndView("academicfeesreportbasedtaxclass");
            String institutioncurrencycode = request.getSession().getAttribute("institutioncurrency").toString();
            mv.addObject("academicYears", this.academicYearServices.academicYearList());
            mv.addObject("currencycode", (Object)institutioncurrencycode);
            return mv;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"paymentmodewisefeesreport"})
    public ModelAndView displayPaymentModeWiseFeesReportPage(HttpServletRequest request) {
        try {
            ModelAndView mv = new ModelAndView("paymentmodewisefeesreport");
            String institutioncurrencycode = request.getSession().getAttribute("institutioncurrency").toString();
            mv.addObject("paymentModes", this.paymentServices.getActivePaymentModes());
            mv.addObject("currencycode", (Object)institutioncurrencycode);
            return mv;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"paymentModeWiseStudentReceiptsList"}, method={RequestMethod.GET})
    @ResponseBody
    public ArrayList<SixFieldReports> getPaymentModeWiseStudentReceiptsList(HttpServletRequest request) throws Exception {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date fromDate = formatter.parse(request.getParameter("fromDate"));
            Date toDate = formatter.parse(request.getParameter("toDate"));
            Long instituteId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            Long paymentMode = Long.parseLong(request.getParameter("paymentMode"));
            return this.receiptService.getStudentReceiptsByDateRange(instituteId, fromDate, toDate, paymentMode);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"accountingfeesreportlist"}, method={RequestMethod.GET})
    @ResponseBody
    public ArrayList<SixFieldReports> getInstitutionLedgerList(HttpServletRequest request) throws Exception {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date fromDate = formatter.parse(request.getParameter("fromDate"));
            Date toDate = formatter.parse(request.getParameter("toDate"));
            Long instituteId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            Long paymentStatus = 3L;
            String category = request.getParameter("category");
            if (category.equals("specificinvoice")) {
                return this.institutionServices.getInstitutionLedgerByInvoiceDate(instituteId, fromDate, toDate, paymentStatus);
            }
            if (category.equals("specificreceipt")) {
                return this.institutionServices.getInstitutionLedgerByReceiptDate(instituteId, fromDate, toDate, paymentStatus);
            }
            return null;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"accountingfeesreportlistbasedtaxclass"}, method={RequestMethod.GET})
    @ResponseBody
    public ArrayList<NineFieldReports> getInstitutionLedgerListBasedTAXClass(HttpServletRequest request) throws Exception {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date fromDate = formatter.parse(request.getParameter("fromDate"));
            Date toDate = formatter.parse(request.getParameter("toDate"));
            Long instituteId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            Long paymentStatus = 3L;
            String category = request.getParameter("category");
            if (category.equals("specificinvoice")) {
                return this.institutionServices.getInstitutionLedgerByInvoiceDateWithoutTAX(instituteId, fromDate, toDate, paymentStatus);
            }
            if (category.equals("specificreceipt")) {
                return this.institutionServices.getInstitutionLedgerByReceiptDateWithoutTAX(instituteId, fromDate, toDate, paymentStatus);
            }
            return null;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"allaccountingfeesreportlist"}, method={RequestMethod.GET})
    @ResponseBody
    public ArrayList<SixFieldReports> getCurrentInstitutionLedgerAccountDetails(HttpServletRequest request) throws Exception {
        try {
            Long instituteId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            Long paymentStatus = 3L;
            return this.institutionServices.getInstitutionLedgerAccountDetails(instituteId, paymentStatus);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"currentacademicyearacademicfeesreportlist"}, method={RequestMethod.GET})
    @ResponseBody
    public ArrayList<SixFieldReports> getCurrentAcademicYearLedgerAccountDetailsByInstitution(HttpServletRequest request) throws Exception {
        try {
            Long instituteId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            Long paymentStatus = 3L;
            return this.institutionServices.getCurrentAcademicYearLedgerAccountDetailsByInstitution(instituteId, paymentStatus);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"currentacademicyearacademicfeesreportlistwithouttax"}, method={RequestMethod.GET})
    @ResponseBody
    public ArrayList<NineFieldReports> getCurrentAcademicYearLedgerAccountDetailsWithoutTAXByInstitution(HttpServletRequest request) throws Exception {
        try {
            Long instituteId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            Long paymentStatus = 3L;
            return this.institutionServices.getCurrentAcademicYearLedgerAccountDetailsWithoutTAXByInstitution(instituteId, paymentStatus);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"currentactiveacademicyearfinelist"}, method={RequestMethod.GET})
    @ResponseBody
    public AcademicYear getcurrentActiveAcademicYearFineDetailsByInstitution(HttpServletRequest request) throws Exception {
        try {
            Long instituteId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            return this.institutionServices.getCurrentActiveAcademicYearFineDetailsByInstitution(instituteId);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"currentacademicyearfinelist"}, method={RequestMethod.GET})
    @ResponseBody
    public Set<AcademicYear> getCurrentAcademicYearFineDetailsByInstitution(HttpServletRequest request) throws Exception {
        try {
            Long instituteId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            if (request.getParameter("category") != "") {
                Long academicYearId = Long.parseLong(request.getParameter("category"));
                if (academicYearId == 0L) {
                    return this.institutionServices.getAcademicYearFineDetailsByInstitution(instituteId);
                }
                return this.institutionServices.getCurrentAcademicYearFineDetails(academicYearId);
            }
            Long academicYearId = Long.parseLong(request.getParameter("academicYearId"));
            return this.institutionServices.getCurrentAcademicYearFineDetails(academicYearId);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"academicfeesreportlist"}, method={RequestMethod.GET})
    @ResponseBody
    public ArrayList<SixFieldReports> getInstitutionLedgerAccountDetailsByAcademicYear(HttpServletRequest request) throws Exception {
        try {
            Long instituteId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            Long academicYearId = Long.parseLong(request.getParameter("category"));
            Long paymentStatus = 3L;
            if (academicYearId == 0L) {
                return this.institutionServices.getInstitutionLedgerAccountDetails(instituteId, paymentStatus);
            }
            return this.institutionServices.getInstitutionLedgerAccountDetailsByAcademicYear(academicYearId, paymentStatus);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"academicfeesreportlistwithouttax"}, method={RequestMethod.GET})
    @ResponseBody
    public ArrayList<NineFieldReports> getInstitutionLedgerAccountDetailsWithoutTaxByAcademicYear(HttpServletRequest request) throws Exception {
        try {
            Long instituteId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            Long academicYearId = Long.parseLong(request.getParameter("category"));
            Long paymentStatus = 3L;
            if (academicYearId == 0L) {
                return this.institutionServices.getInstitutionLedgerAccountDetailsWithoutTAX(instituteId, paymentStatus);
            }
            return this.institutionServices.getInstitutionLedgerAccountDetailsByAcademicYearWithoutTAX(academicYearId, paymentStatus);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"/studentWise/feesCategoryReport"}, method={RequestMethod.GET})
    @ResponseBody
    public List<StudentInvoice> feesCategoryReport(HttpServletRequest request) {
        ArrayList<StudentInvoice> studentInvoices = new ArrayList<StudentInvoice>();
        try {
            String criteria = request.getParameter("criteria");
            if (criteria.equals("academicYear")) {
                String[] feesTerm;
                Long instituteId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
                String reportType = request.getParameter("reportType");
                Long academicYearId = Long.parseLong(request.getParameter("academicYearId"));
                String[] stringArray = feesTerm = request.getParameterValues("feesCategoryList");
                int n = feesTerm.length;
                int n2 = 0;
                while (n2 < n) {
                    String feesTermId = stringArray[n2];
                    if (reportType.equals("paid")) {
                        studentInvoices.addAll(this.invoiceServices.studentInvoicesForFeesCategoryReport(academicYearId, Long.parseLong(feesTermId), instituteId, 0));
                    } else if (reportType.equals("pending")) {
                        studentInvoices.addAll(this.invoiceServices.studentInvoicesForFeesCategoryReport(academicYearId, Long.parseLong(feesTermId), instituteId, 1));
                    }
                    ++n2;
                }
            } else if (criteria.equals("dateRange")) {
                String[] feesTerm;
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                Date fromDate = formatter.parse(request.getParameter("fromDate"));
                Date toDate = formatter.parse(request.getParameter("toDate"));
                Long instituteId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
                String reportType = request.getParameter("reportType");
                String[] stringArray = feesTerm = request.getParameterValues("feesCategoryList");
                int n = feesTerm.length;
                int n3 = 0;
                while (n3 < n) {
                    String feesTermId = stringArray[n3];
                    if (reportType.equals("paid")) {
                        studentInvoices.addAll(this.invoiceServices.studentInvoicesForFeesCategoryReportByDateRange(fromDate, toDate, Long.parseLong(feesTermId), instituteId, 0));
                    } else if (reportType.equals("pending")) {
                        studentInvoices.addAll(this.invoiceServices.studentInvoicesForFeesCategoryReportByDateRange(fromDate, toDate, Long.parseLong(feesTermId), instituteId, 1));
                    }
                    ++n3;
                }
            }
            return studentInvoices;
        }
        catch (Exception e) {
            e.printStackTrace();
            return studentInvoices;
        }
    }

    @RequestMapping(value={"/studentWise/feesCategoryReport/refund"}, method={RequestMethod.GET})
    @ResponseBody
    public List<StudentInvoice> feesCategoryRefundReport(HttpServletRequest request) {
        ArrayList<StudentInvoice> studentInvoices = new ArrayList<StudentInvoice>();
        try {
            String criteria = request.getParameter("criteria");
            if (criteria.equals("academicYear")) {
                String[] feesTerm;
                Long instituteId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
                Long academicYearId = Long.parseLong(request.getParameter("academicYearId"));
                String[] stringArray = feesTerm = request.getParameterValues("feesCategoryList");
                int n = feesTerm.length;
                int n2 = 0;
                while (n2 < n) {
                    String feesTermId = stringArray[n2];
                    studentInvoices.addAll(this.invoiceServices.studentInvoicesForFeesCategoryRefundReport(academicYearId, Long.parseLong(feesTermId), instituteId));
                    ++n2;
                }
            } else if (criteria.equals("dateRange")) {
                String[] feesTerm;
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                Date fromDate = formatter.parse(request.getParameter("fromDate"));
                Date toDate = formatter.parse(request.getParameter("toDate"));
                Long instituteId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
                String[] stringArray = feesTerm = request.getParameterValues("feesCategoryList");
                int n = feesTerm.length;
                int n3 = 0;
                while (n3 < n) {
                    String feesTermId = stringArray[n3];
                    studentInvoices.addAll(this.invoiceServices.studentInvoicesForFeesCategoryRefundReportByDateRange(fromDate, toDate, Long.parseLong(feesTermId), instituteId));
                    ++n3;
                }
            }
            return studentInvoices;
        }
        catch (Exception e) {
            e.printStackTrace();
            return studentInvoices;
        }
    }

    @RequestMapping(value={"/studentWise/feesItemReport"}, method={RequestMethod.GET})
    @ResponseBody
    public List<StudentInvoiceDetail> feesItemReport(HttpServletRequest request) {
        ArrayList<StudentInvoiceDetail> studentInvoices = new ArrayList<StudentInvoiceDetail>();
        try {
            String criteria = request.getParameter("criteria");
            if (criteria.equals("academicYear")) {
                Long instituteId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
                String reportType = request.getParameter("reportType");
                Long academicYearId = Long.parseLong(request.getParameter("academicYearId"));
                String[] feesItemIds = request.getParameterValues("feesItemList");
                if (reportType.equals("paid")) {
                    String[] stringArray = feesItemIds;
                    int n = feesItemIds.length;
                    int n2 = 0;
                    while (n2 < n) {
                        String feesItemId = stringArray[n2];
                        Long integerfeesItemId = Long.parseLong(feesItemId);
                        studentInvoices.addAll(this.invoiceServices.studentInvoicesForFeesItemReport(academicYearId, integerfeesItemId, instituteId, 0));
                        ++n2;
                    }
                } else if (reportType.equals("pending")) {
                    String[] stringArray = feesItemIds;
                    int n = feesItemIds.length;
                    int n3 = 0;
                    while (n3 < n) {
                        String feesItemId = stringArray[n3];
                        Long integerfeesItemId = Long.parseLong(feesItemId);
                        studentInvoices.addAll(this.invoiceServices.studentInvoicesForFeesItemReport(academicYearId, integerfeesItemId, instituteId, 1));
                        ++n3;
                    }
                }
            } else if (criteria.equals("dateRange")) {
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                Date fromDate = formatter.parse(request.getParameter("fromDate"));
                Date toDate = formatter.parse(request.getParameter("toDate"));
                Long instituteId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
                String reportType = request.getParameter("reportType");
                String[] feesItemIds = request.getParameterValues("feesItemList");
                if (reportType.equals("paid")) {
                    String[] stringArray = feesItemIds;
                    int n = feesItemIds.length;
                    int n4 = 0;
                    while (n4 < n) {
                        String feesItemId = stringArray[n4];
                        Long integerfeesItemId = Long.parseLong(feesItemId);
                        studentInvoices.addAll(this.invoiceServices.studentInvoicesForFeesItemReportByDateRange(fromDate, toDate, integerfeesItemId, instituteId, 0));
                        ++n4;
                    }
                } else if (reportType.equals("pending")) {
                    String[] stringArray = feesItemIds;
                    int n = feesItemIds.length;
                    int n5 = 0;
                    while (n5 < n) {
                        String feesItemId = stringArray[n5];
                        Long integerfeesItemId = Long.parseLong(feesItemId);
                        studentInvoices.addAll(this.invoiceServices.studentInvoicesForFeesItemReportByDateRange(fromDate, toDate, integerfeesItemId, instituteId, 1));
                        ++n5;
                    }
                }
            }
            return studentInvoices;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"/studentWise/feesItemReport/refund"}, method={RequestMethod.GET})
    @ResponseBody
    public List<StudentInvoiceDetail> feesItemRefundReport(HttpServletRequest request) {
        ArrayList<StudentInvoiceDetail> studentInvoices = new ArrayList<StudentInvoiceDetail>();
        try {
            String criteria = request.getParameter("criteria");
            if (criteria.equals("academicYear")) {
                String[] feesItemIds;
                Long instituteId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
                Long academicYearId = Long.parseLong(request.getParameter("academicYearId"));
                String[] stringArray = feesItemIds = request.getParameterValues("feesItemList");
                int n = feesItemIds.length;
                int n2 = 0;
                while (n2 < n) {
                    String feesItemId = stringArray[n2];
                    Long integerfeesItemId = Long.parseLong(feesItemId);
                    studentInvoices.addAll(this.invoiceServices.studentInvoicesForFeesItemRefundReport(academicYearId, integerfeesItemId, instituteId));
                    ++n2;
                }
            } else if (criteria.equals("dateRange")) {
                String[] feesItemIds;
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                Date fromDate = formatter.parse(request.getParameter("fromDate"));
                Date toDate = formatter.parse(request.getParameter("toDate"));
                Long instituteId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
                String[] stringArray = feesItemIds = request.getParameterValues("feesItemList");
                int n = feesItemIds.length;
                int n3 = 0;
                while (n3 < n) {
                    String feesItemId = stringArray[n3];
                    Long integerfeesItemId = Long.parseLong(feesItemId);
                    studentInvoices.addAll(this.invoiceServices.studentInvoicesForFeesItemRefundReportByDateRange(fromDate, toDate, integerfeesItemId, instituteId));
                    ++n3;
                }
            }
            return studentInvoices;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/receiptVoucher"})
    @ResponseBody
    public String doDownload(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            int BUFFER_SIZE = 4096;
            String date = request.getParameter("receivedDate");
            String rearrangeddate = "";
            String[] splitDate = date.split("/");
            int i = splitDate.length - 1;
            while (i >= 0) {
                rearrangeddate = rearrangeddate.concat(splitDate[i]);
                --i;
            }
            date = rearrangeddate;
            String narration = request.getParameter("narration");
            String accountLedger = request.getParameter("accountLedger");
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date fromDate = formatter.parse(request.getParameter("currentFromDate"));
            Date toDate = formatter.parse(request.getParameter("currentToDate"));
            Long instituteId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            Long paymentStatus = 3L;
            String category = request.getParameter("currentCategory");
            String staticTopData = "<ENVELOPE><HEADER><TALLYREQUEST>Import Data</TALLYREQUEST></HEADER><BODY><IMPORTDATA><REQUESTDESC><REPORTNAME>All Masters</REPORTNAME><STATICVARIABLES><SVCURRENTCOMPANY>Edumaat</SVCURRENTCOMPANY></STATICVARIABLES></REQUESTDESC><REQUESTDATA><TALLYMESSAGE xmlns:UDF=\"TallyUDF\"><VOUCHER VCHTYPE=\"Receipt\" ACTION=\"Create\" OBJVIEW=\"Accounting Voucher View\"><DATE>" + date + "</DATE>" + "<NARRATION>" + narration + "</NARRATION>" + "<VOUCHERTYPENAME>Receipt</VOUCHERTYPENAME>" + "<CSTFORMISSUETYPE/>" + "<CSTFORMRECVTYPE/>" + "<FBTPAYMENTTYPE>Default</FBTPAYMENTTYPE>" + "<PERSISTEDVIEW>Accounting Voucher View</PERSISTEDVIEW>" + "<VCHGSTCLASS/>" + "<DIFFACTUALQTY>No</DIFFACTUALQTY>" + "<AUDITED>No</AUDITED>" + "<FORJOBCOSTING>No</FORJOBCOSTING>" + "<ISOPTIONAL>No</ISOPTIONAL>" + "<EFFECTIVEDATE>" + date + "</EFFECTIVEDATE>" + "<ISFORJOBWORKIN>No</ISFORJOBWORKIN>" + "<ALLOWCONSUMPTION>No</ALLOWCONSUMPTION>" + "<USEFORINTEREST>No</USEFORINTEREST>" + "<USEFORGAINLOSS>No</USEFORGAINLOSS>" + "<USEFORGODOWNTRANSFER>No</USEFORGODOWNTRANSFER>" + "<USEFORCOMPOUND>No</USEFORCOMPOUND>" + "<EXCISEOPENING>No</EXCISEOPENING>" + "<USEFORFINALPRODUCTION>No</USEFORFINALPRODUCTION>" + "<ISCANCELLED>No</ISCANCELLED>" + "<HASCASHFLOW>Yes</HASCASHFLOW>" + "<ISPOSTDATED>No</ISPOSTDATED>" + "<USETRACKINGNUMBER>No</USETRACKINGNUMBER>" + "<ISINVOICE>No</ISINVOICE>" + "<MFGJOURNAL>No</MFGJOURNAL>" + "<HASDISCOUNTS>No</HASDISCOUNTS>" + "<ASPAYSLIP>No</ASPAYSLIP>" + "<ISCOSTCENTRE>No</ISCOSTCENTRE>" + "<ISSTXNONREALIZEDVCH>No</ISSTXNONREALIZEDVCH>" + "<ISDELETED>No</ISDELETED>" + "<ASORIGINAL>No</ASORIGINAL>" + "<VCHISFROMSYNC>No</VCHISFROMSYNC>" + "<MASTERID> 22</MASTERID>" + "<VOUCHERKEY>182364311388168</VOUCHERKEY>";
            String ledgerName = "";
            Double ledgerAmount = 0.0;
            Double ledgerDiscountAmount = 0.0;
            Double totalAmount = 0.0;
            ArrayList<Object> addNineFieldReports = new ArrayList();
            if (category.equals("specificreceipt")) {
                addNineFieldReports = this.institutionServices.getInstitutionLedgerByReceiptDateWithoutTAX(instituteId, fromDate, toDate, paymentStatus);
            }
            for (NineFieldReports nineFieldReports : addNineFieldReports) {
                ledgerName = (String)nineFieldReports.getF2();
                ledgerDiscountAmount = (Double)nineFieldReports.getF5();
                ledgerAmount = (Double)nineFieldReports.getF4();
                totalAmount = totalAmount + ledgerAmount;
                ledgerAmount = ledgerAmount + ledgerDiscountAmount;
                String dynamicFeesItemData = "<ALLLEDGERENTRIES.LIST><LEDGERNAME>" + ledgerName + "</LEDGERNAME>" + "<ISDEEMEDPOSITIVE>No</ISDEEMEDPOSITIVE>" + "<LEDGERFROMITEM>No</LEDGERFROMITEM>" + "<REMOVEZEROENTRIES>No</REMOVEZEROENTRIES>" + "<ISPARTYLEDGER>No</ISPARTYLEDGER>" + "<ISLASTDEEMEDPOSITIVE>No</ISLASTDEEMEDPOSITIVE>" + "<AMOUNT>" + ledgerAmount + "</AMOUNT>" + "</ALLLEDGERENTRIES.LIST>";
                String discountFeesItemData = "<ALLLEDGERENTRIES.LIST><LEDGERNAME>" + ledgerName + " Discount</LEDGERNAME>" + "<ISDEEMEDPOSITIVE>No</ISDEEMEDPOSITIVE>" + "<LEDGERFROMITEM>No</LEDGERFROMITEM>" + "<REMOVEZEROENTRIES>No</REMOVEZEROENTRIES>" + "<ISPARTYLEDGER>No</ISPARTYLEDGER>" + "<ISLASTDEEMEDPOSITIVE>No</ISLASTDEEMEDPOSITIVE>" + "<AMOUNT>-" + ledgerDiscountAmount + "</AMOUNT>" + "</ALLLEDGERENTRIES.LIST>";
                staticTopData = staticTopData.concat(dynamicFeesItemData).concat(discountFeesItemData);
            }
            String bottomStaticData = "<ALLLEDGERENTRIES.LIST><LEDGERNAME>" + accountLedger + "</LEDGERNAME>" + "<ISDEEMEDPOSITIVE>Yes</ISDEEMEDPOSITIVE>" + "<LEDGERFROMITEM>No</LEDGERFROMITEM>" + "<REMOVEZEROENTRIES>No</REMOVEZEROENTRIES>" + "<ISPARTYLEDGER>Yes</ISPARTYLEDGER>" + "<ISLASTDEEMEDPOSITIVE>Yes</ISLASTDEEMEDPOSITIVE>" + "<AMOUNT>-" + totalAmount + "</AMOUNT>" + "</ALLLEDGERENTRIES.LIST>" + "</VOUCHER>" + "</TALLYMESSAGE>" + "</REQUESTDATA>" + "</IMPORTDATA>" + "</BODY>" + "</ENVELOPE>";
            String content = staticTopData.concat(bottomStaticData);
            ByteArrayInputStream inputStream = new ByteArrayInputStream(content.getBytes());
            Timestamp name = new Timestamp(Calendar.getInstance().getTime().getTime());
            response.setContentType("application/xml");
            String headerKey = "Content-Disposition";
            String headerValue = String.format("attachment; filename=\"%s\"", "receiptVoucher_" + name + ".xml");
            response.setHeader(headerKey, headerValue);
            ServletOutputStream outStream = response.getOutputStream();
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead = -1;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, bytesRead);
            }
            ((InputStream)inputStream).close();
            outStream.close();
            return "redirect:/report/accountingfeesreport";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "redirect:/report/accountingfeesreport";
        }
    }
}
