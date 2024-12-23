/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.exceptions.ReceiptException;
import in.jdsoft.educationmanagement.school.exceptions.StudentFeeRefundReceiptException;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.Class;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.PaymentMode;
import in.jdsoft.educationmanagement.school.model.Section;
import in.jdsoft.educationmanagement.school.model.SpecialCategory;
import in.jdsoft.educationmanagement.school.model.StudentFeeRefundReceipt;
import in.jdsoft.educationmanagement.school.model.StudentInvoice;
import in.jdsoft.educationmanagement.school.reports.model.SixFieldReports;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface StudentFeeRefundReceiptService {
    public static final Logger log = LogManager.getLogger((String)StudentFeeRefundReceiptService.class.getName());

    public Long receiptByCash(Long[] var1, Long[] var2, Double[] var3, Double var4, Double var5, PaymentMode var6, Date var7, boolean var8, String var9, Double var10, String var11, String var12, String var13) throws ReceiptException;

    public Long receiptByCheque(Long[] var1, Long[] var2, Double[] var3, Double var4, Double var5, PaymentMode var6, Date var7, String var8, Date var9, String var10, String var11, boolean var12, String var13, Double var14, String var15, String var16, String var17) throws ReceiptException;

    public Long receiptByDD(Long[] var1, Long[] var2, Double[] var3, Double var4, Double var5, PaymentMode var6, Date var7, String var8, Date var9, String var10, String var11, boolean var12, String var13, Double var14, String var15, String var16, String var17) throws ReceiptException;

    public Long receiptByCashAndPartialPayment(Long[] var1, Long[] var2, Double[] var3, Double[] var4, Double var5, Double var6, PaymentMode var7, Date var8, boolean var9, String var10, Double var11, String var12, String var13, String var14) throws ReceiptException;

    public Long receiptByChequeAndPartialPayment(Long[] var1, Long[] var2, Double[] var3, Double[] var4, Double var5, Double var6, PaymentMode var7, Date var8, String var9, Date var10, String var11, String var12, boolean var13, String var14, Double var15, String var16, String var17, String var18) throws ReceiptException;

    public Long receiptByDDAndPartialPayment(Long[] var1, Long[] var2, Double[] var3, Double[] var4, Double var5, Double var6, PaymentMode var7, Date var8, String var9, Date var10, String var11, String var12, boolean var13, String var14, Double var15, String var16, String var17, String var18) throws ReceiptException;

    public boolean checkForInvoiceClosing(StudentInvoice var1);

    public ArrayList<StudentFeeRefundReceipt> getStudentFeeRefundReceiptsByPaymentMode(Long var1);

    public ArrayList<StudentFeeRefundReceipt> getStudentFeeRefundReceiptsFromPaymentModeAndStatus(Long var1, Long var2);

    public void updateReconcillation(Long[] var1, Long var2, Date var3, String var4, String var5) throws StudentFeeRefundReceiptException;

    public void updateChequeReconcillation(Long[] var1, Long var2, Date var3, String var4, String var5) throws StudentFeeRefundReceiptException;

    public void updateDdReconcillation(Long[] var1, Long var2, Date var3, String var4, String var5) throws StudentFeeRefundReceiptException;

    public StudentFeeRefundReceipt getStudentFeeRefundReceiptDetails(Long var1) throws ParseException;

    public ArrayList<StudentFeeRefundReceipt> getAllStudentFeeRefundReceipts(AcademicYear var1, Class var2, Section var3);

    public ArrayList<StudentFeeRefundReceipt> getAllStudentFeeRefundReceipts(AcademicYear var1, Institution var2);

    public ArrayList<StudentFeeRefundReceipt> getStudentFeeRefundReceiptsBySpecialCategory(AcademicYear var1, Class var2, Section var3, SpecialCategory var4);

    public ArrayList<StudentFeeRefundReceipt> getStudentFeeRefundReceiptsBySpecialCategory(AcademicYear var1, SpecialCategory var2, Institution var3);

    public ArrayList<StudentFeeRefundReceipt> getStudentFeeRefundReceiptsByAdmisssionNo(String var1);

    public ArrayList<StudentFeeRefundReceipt> getStudentFeeRefundReceiptsByAdmisssionNoAndAcademicYear(String var1, AcademicYear var2);

    public void deleteReceipt(Long var1);

    public ArrayList<StudentFeeRefundReceipt> getReceiptsByDateRange(Date var1, Date var2, Institution var3);

    public Long amountTobeCollectedOnPercentageDiscount(Long[] var1, Double var2);

    public Long amountTobeCollectedOnPercentageDiscountAndPartialAmount(Long[] var1, Double var2, Double[] var3);

    public Long amountTobeCollectedOnFlatDiscount(Long[] var1, Double[] var2);

    public Long amountTobeCollectedOnFlatDiscountAndPartialAmount(Long[] var1, Double[] var2, Double[] var3);

    public Long amountTobeCollectedWhenNoDiscount(Long[] var1);

    public Long amountTobeCollectedWhenNoDiscountAndPartialAmount(Long[] var1, Double[] var2);

    public Double calculatePercentageDiscountAmount(Long var1, Double var2);

    public Double calculatePercentageDiscountAmountAndPartialAmount(Long var1, Double var2, Double var3);

    public ArrayList<SixFieldReports> getStudentFeeRefundReceiptsByDateRange(Long var1, Date var2, Date var3, Long var4) throws Exception;

    public void deleteStudentFeeRefundReceiptsByAcademicYear(Long[] var1, Long var2) throws Exception, StudentFeeRefundReceiptException;

    public StudentFeeRefundReceipt receiptById(Long var1) throws Exception;

    public Long fineamountautomaticcalculation(Long var1) throws ParseException, Exception;
}
