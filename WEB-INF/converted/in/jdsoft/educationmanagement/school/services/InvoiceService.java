/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.exceptions.StudentInvoiceException;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.Class;
import in.jdsoft.educationmanagement.school.model.FeesPenaltySetting;
import in.jdsoft.educationmanagement.school.model.FeesTermAndFeesItems;
import in.jdsoft.educationmanagement.school.model.FeesTermAndFeesStructure;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Section;
import in.jdsoft.educationmanagement.school.model.SpecialCategory;
import in.jdsoft.educationmanagement.school.model.Student;
import in.jdsoft.educationmanagement.school.model.StudentInvoice;
import in.jdsoft.educationmanagement.school.model.StudentInvoiceDetail;
import in.jdsoft.educationmanagement.school.reports.model.ThreeFieldReports;
import in.jdsoft.educationmanagement.school.reports.model.TwoFieldReport;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface InvoiceService {
    public static final Logger log = LogManager.getLogger((String)InvoiceService.class.getName());

    public void generateInvoice(Long[] var1, ArrayList<FeesTermAndFeesStructure> var2, AcademicYear var3, String var4, Institution var5) throws Exception;

    public void generateInvoiceForFeesTermAndFeesItems(Long[] var1, ArrayList<FeesTermAndFeesItems> var2, AcademicYear var3, String var4, Institution var5, Long var6, FeesPenaltySetting var7) throws Exception;

    public ArrayList<StudentInvoice> getStudentPendingInvoices(String var1);

    public ArrayList<StudentInvoice> getStudentPendingInvoices(Long var1);

    public ArrayList<StudentInvoiceDetail> getStudentPendingInvoiceFeesItems(Long var1);

    public ArrayList<StudentInvoiceDetail> getStudentPendingInvoiceFeesItemsByInvoiceIdAndInvoiceStatus(Long var1, Integer var2);

    public ArrayList<StudentInvoiceDetail> getStudentPendingInvoiceFeesItemsByInvoiceId(Long var1);

    public ArrayList<StudentInvoice> getAllStudentInvoices(AcademicYear var1, Class var2, Section var3);

    public ArrayList<StudentInvoice> getAllStudentsInvoices(AcademicYear var1, Institution var2);

    public ArrayList<StudentInvoice> getAllStudentsInvoices(AcademicYear var1);

    public ArrayList<StudentInvoice> getStudentsInvoiceBySpecialCategory(AcademicYear var1, SpecialCategory var2, Institution var3);

    public ArrayList<StudentInvoice> getStudentsInvoiceBySpecialCategory(AcademicYear var1, SpecialCategory var2);

    public ArrayList<StudentInvoice> getStudentInvoicesBySpecialCategory(AcademicYear var1, Class var2, Section var3, SpecialCategory var4);

    public ArrayList<StudentInvoice> getStudentInvoicesByAdmisssionNoAndAcademicYear(String var1, AcademicYear var2) throws StudentInvoiceException;

    public ArrayList<StudentInvoice> getStudentInvoicesFromIds(Long[] var1);

    public StudentInvoice getStudentInvoiceDetails(Long var1) throws StudentInvoiceException;

    public void deleteStudentInvoicesByAcademicYear(Long[] var1, Long var2) throws StudentInvoiceException;

    public boolean invoiceValidation(Long[] var1, Long var2);

    public ArrayList<StudentInvoice> getStudentInvoicesByDate(Date var1, Date var2, Institution var3);

    public ArrayList<StudentInvoice> getStudentInvoicesByDate(Date var1, Date var2);

    public List<StudentInvoice> studentInvoicesForFeesCategoryReport(Long var1, Long var2, Long var3, Integer var4);

    public List<StudentInvoice> studentInvoicesForFeesCategoryRefundReport(Long var1, Long var2, Long var3);

    public Set<Student> studentsByPartiallyAndFullyForFeesCategoryReport(Long var1, Long var2, Long var3);

    public Set<Student> studentsByPartiallyAndFullyForFeesCategoryReportAllInstitution(Long var1, Long var2);

    public List<StudentInvoice> studentInvoicesForFeesCategoryReportByDateRange(Date var1, Date var2, Long var3, Long var4, Integer var5);

    public List<StudentInvoice> studentInvoicesForFeesCategoryRefundReportByDateRange(Date var1, Date var2, Long var3, Long var4);

    public List<StudentInvoice> studentInvoicesForFeesCategoryReportAllTerms(Long var1, Long var2, Integer var3);

    public List<StudentInvoice> studentInvoicesForFeesCategoryReportAllTermsByDateRange(Date var1, Date var2, Long var3, Integer var4);

    public List<StudentInvoiceDetail> studentInvoicesForFeesItemReport(Long var1, Long var2, Long var3, Integer var4);

    public List<StudentInvoiceDetail> studentInvoicesForFeesItemRefundReport(Long var1, Long var2, Long var3);

    public List<StudentInvoiceDetail> studentInvoicesForFeesItemRefundReportByDateRange(Date var1, Date var2, Long var3, Long var4);

    public List<StudentInvoiceDetail> studentInvoicesForFeesItemReportByDateRange(Date var1, Date var2, Long var3, Long var4, Integer var5);

    public TwoFieldReport pendingAndPaidStudentCountByAcademicYearAndInstitution(AcademicYear var1, Long var2, Integer var3);

    public TwoFieldReport pendingAndPaidStudentCountByAcademicYear(AcademicYear var1, Integer var2);

    public List<ThreeFieldReports> pendingAndPaidStudentCountByAllAcademicYear(Long var1, Integer var2);

    public List<ThreeFieldReports> pendingAndPaidStudentCountByAllClassByInstitution(Long var1, Integer var2) throws StudentInvoiceException;

    public List<ThreeFieldReports> pendingAndPaidStudentCountByAllClass(AcademicYear var1, Integer var2) throws StudentInvoiceException;

    public List<ThreeFieldReports> pendingAndPaidStudentCountByAllClassByActiveAcademicYear(Long var1, AcademicYear var2, Integer var3) throws StudentInvoiceException;
}
