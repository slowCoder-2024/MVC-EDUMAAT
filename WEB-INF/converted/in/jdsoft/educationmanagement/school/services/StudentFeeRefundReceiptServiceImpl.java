/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.Hibernate
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.AcademicYearDAO;
import in.jdsoft.educationmanagement.school.dao.InstitutionDAO;
import in.jdsoft.educationmanagement.school.dao.PaymentModeDAO;
import in.jdsoft.educationmanagement.school.dao.PaymentStatusDAO;
import in.jdsoft.educationmanagement.school.dao.StudentDAO;
import in.jdsoft.educationmanagement.school.dao.StudentFeeRefundReceiptDAO;
import in.jdsoft.educationmanagement.school.dao.StudentFeeRefundReceiptDetailDAO;
import in.jdsoft.educationmanagement.school.dao.StudentInvoiceDAO;
import in.jdsoft.educationmanagement.school.dao.StudentInvoiceDetailDAO;
import in.jdsoft.educationmanagement.school.dao.StudentPartialPaymentReceiptDetailDAO;
import in.jdsoft.educationmanagement.school.exceptions.ReceiptException;
import in.jdsoft.educationmanagement.school.exceptions.StudentFeeRefundReceiptException;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.Class;
import in.jdsoft.educationmanagement.school.model.FeesItem;
import in.jdsoft.educationmanagement.school.model.FeesPenaltySetting;
import in.jdsoft.educationmanagement.school.model.InstituteLedgerAccount;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.PaymentMode;
import in.jdsoft.educationmanagement.school.model.PaymentStatus;
import in.jdsoft.educationmanagement.school.model.Section;
import in.jdsoft.educationmanagement.school.model.SpecialCategory;
import in.jdsoft.educationmanagement.school.model.Student;
import in.jdsoft.educationmanagement.school.model.StudentFeeRefundReceipt;
import in.jdsoft.educationmanagement.school.model.StudentFeeRefundReceiptDetail;
import in.jdsoft.educationmanagement.school.model.StudentInvoice;
import in.jdsoft.educationmanagement.school.model.StudentInvoiceDetail;
import in.jdsoft.educationmanagement.school.model.StudentPartialPaymentReceiptDetail;
import in.jdsoft.educationmanagement.school.reports.model.SixFieldReports;
import in.jdsoft.educationmanagement.school.services.StudentFeeRefundReceiptService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="studentFeeRefundReceiptService")
public class StudentFeeRefundReceiptServiceImpl
implements StudentFeeRefundReceiptService {
    @Autowired
    StudentFeeRefundReceiptDAO studentFeeRefundReceiptDAO;
    @Autowired
    StudentFeeRefundReceiptDetailDAO studentFeeRefundReceiptDetailDAO;
    @Autowired
    PaymentModeDAO paymentModeDAO;
    @Autowired
    PaymentStatusDAO paymentStatusDAO;
    @Autowired
    StudentInvoiceDetailDAO studentInvoiceDetailDAO;
    @Autowired
    StudentInvoiceDAO studentInvoiceDAO;
    @Autowired
    StudentDAO studentDAO;
    @Autowired
    InstitutionDAO institutionDAO;
    @Autowired
    AcademicYearDAO academicYearDAO;
    @Autowired
    private StudentPartialPaymentReceiptDetailDAO studentPartialPaymentReceiptDetailDAO;

    @Override
    public Long receiptByCash(Long[] normalFeesItem, Long[] flatDiscountFeesItems, Double[] flatDiscountFeesItemAmount, Double fineAmount, Double totalAmountPaid, PaymentMode paymentMode, Date receivedDate, boolean isdiscountApplied, String discountType, Double discountPercentage, String narration, String createdBy, String modifiedBy) throws ReceiptException {
        try {
            int i;
            int i2;
            PaymentStatus paymentStatus = this.paymentStatusDAO.getPaymentStatusById(1L);
            StudentInvoice studentInvoice = null;
            if (normalFeesItem != null) {
                i2 = 0;
                while (i2 < normalFeesItem.length) {
                    if (i2 == 0) {
                        studentInvoice = this.studentInvoiceDAO.getStudentInvoiceById(this.studentInvoiceDetailDAO.getStudentInvoiceDetailById(normalFeesItem[i2]).getStudentInvoice().getStudentInvoiceId());
                    }
                    ++i2;
                }
            } else {
                i2 = 0;
                while (i2 < flatDiscountFeesItems.length) {
                    if (i2 == 0) {
                        studentInvoice = this.studentInvoiceDAO.getStudentInvoiceById(this.studentInvoiceDetailDAO.getStudentInvoiceDetailById(flatDiscountFeesItems[i2]).getStudentInvoice().getStudentInvoiceId());
                    }
                    ++i2;
                }
            }
            Long persistedReceiptNo = null;
            StudentFeeRefundReceipt receipt = new StudentFeeRefundReceipt(studentInvoice.getInstitution(), studentInvoice.getAcademicYear(), paymentMode, receivedDate, Double.valueOf(Math.round(totalAmountPaid)), studentInvoice.getStudent(), paymentStatus, narration, createdBy, modifiedBy, studentInvoice);
            if (!isdiscountApplied) {
                i = 0;
                while (i < normalFeesItem.length) {
                    Long invoiceDetailId = normalFeesItem[i];
                    StudentInvoiceDetail studentInvoiceDetail = this.studentInvoiceDetailDAO.getStudentInvoiceDetailById(invoiceDetailId);
                    StudentFeeRefundReceiptDetail studentFeeRefundReceiptdetail = new StudentFeeRefundReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), false, null, null, 0.0, Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), receivedDate, paymentStatus, createdBy, modifiedBy);
                    receipt.getStudentFeeRefundReceiptDetails().add(studentFeeRefundReceiptdetail);
                    ++i;
                }
            } else {
                if (discountType.equals("percentage")) {
                    i = 0;
                    while (i < normalFeesItem.length) {
                        Long invoiceDetailId = normalFeesItem[i];
                        StudentInvoiceDetail studentInvoiceDetail = this.studentInvoiceDetailDAO.getStudentInvoiceDetailById(invoiceDetailId);
                        Double actualAmount = studentInvoiceDetail.getStudentInvoiceElementTotalAmount();
                        Double discountAmount = this.calculatePercentageDiscountAmount(invoiceDetailId, discountPercentage);
                        Long roundDiscountAmount = Math.round(discountAmount);
                        discountAmount = (double)roundDiscountAmount;
                        StudentFeeRefundReceiptDetail studentFeeRefundReceiptdetail = new StudentFeeRefundReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), true, discountType, discountPercentage.toString(), Double.valueOf(Math.round(discountAmount)), Double.valueOf(Math.round(actualAmount)), Double.valueOf(Math.round(actualAmount)), receivedDate, paymentStatus, createdBy, modifiedBy);
                        receipt.getStudentFeeRefundReceiptDetails().add(studentFeeRefundReceiptdetail);
                        ++i;
                    }
                } else if (discountType.equals("flat")) {
                    StudentInvoiceDetail studentInvoiceDetail;
                    Long invoiceDetailId;
                    if (normalFeesItem != null) {
                        i = 0;
                        while (i < normalFeesItem.length) {
                            invoiceDetailId = normalFeesItem[i];
                            studentInvoiceDetail = this.studentInvoiceDetailDAO.getStudentInvoiceDetailById(invoiceDetailId);
                            StudentFeeRefundReceiptDetail studentFeeRefundReceiptdetail = new StudentFeeRefundReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), false, null, null, 0.0, Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), receivedDate, paymentStatus, createdBy, modifiedBy);
                            receipt.getStudentFeeRefundReceiptDetails().add(studentFeeRefundReceiptdetail);
                            ++i;
                        }
                    }
                    i = 0;
                    while (i < flatDiscountFeesItems.length) {
                        invoiceDetailId = flatDiscountFeesItems[i];
                        studentInvoiceDetail = this.studentInvoiceDetailDAO.getStudentInvoiceDetailById(invoiceDetailId);
                        Double actualAmount = studentInvoiceDetail.getStudentInvoiceElementTotalAmount();
                        Double discountAmount = flatDiscountFeesItemAmount[i];
                        Long roundDiscountAmount = Math.round(discountAmount);
                        discountAmount = (double)roundDiscountAmount;
                        Double paidAmount = actualAmount - discountAmount;
                        paidAmount = paidAmount - 1.0;
                        StudentFeeRefundReceiptDetail studentFeeRefundReceiptdetail = new StudentFeeRefundReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), true, discountType, null, Double.valueOf(Math.round(discountAmount)), Double.valueOf(Math.round(actualAmount)), Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), receivedDate, paymentStatus, createdBy, modifiedBy);
                        receipt.getStudentFeeRefundReceiptDetails().add(studentFeeRefundReceiptdetail);
                        ++i;
                    }
                }
                studentInvoice.setDiscountApplicable(false);
            }
            StudentFeeRefundReceipt persistedStudentFeeRefundReceipt = this.studentFeeRefundReceiptDAO.save(receipt);
            if (this.checkForInvoiceClosing(studentInvoice)) {
                studentInvoice.setInvoiceStatus(0);
            }
            persistedReceiptNo = persistedStudentFeeRefundReceipt.getStudentFeeRefundReceiptId();
            return persistedReceiptNo;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Long receiptByCheque(Long[] normalFeesItem, Long[] flatDiscountFeesItems, Double[] flatDiscountFeesItemsAmount, Double fineAmount, Double totalAmountPaid, PaymentMode paymentMode, Date chequeReceivedDate, String chequeNo, Date chequeDate, String chequeBankName, String chequeBranchName, boolean isdiscountApplied, String discountType, Double discountPercentage, String narration, String createdBy, String modifiedBy) throws ReceiptException {
        try {
            int i;
            int i2;
            PaymentStatus paymentStatus = this.paymentStatusDAO.getPaymentStatusById(1L);
            StudentInvoice studentInvoice = null;
            if (normalFeesItem != null) {
                i2 = 0;
                while (i2 < normalFeesItem.length) {
                    if (i2 == 0) {
                        studentInvoice = this.studentInvoiceDAO.getStudentInvoiceById(this.studentInvoiceDetailDAO.getStudentInvoiceDetailById(normalFeesItem[i2]).getStudentInvoice().getStudentInvoiceId());
                    }
                    ++i2;
                }
            } else {
                i2 = 0;
                while (i2 < flatDiscountFeesItems.length) {
                    if (i2 == 0) {
                        studentInvoice = this.studentInvoiceDAO.getStudentInvoiceById(this.studentInvoiceDetailDAO.getStudentInvoiceDetailById(flatDiscountFeesItems[i2]).getStudentInvoice().getStudentInvoiceId());
                    }
                    ++i2;
                }
            }
            Long persistedReceiptNo = null;
            StudentFeeRefundReceipt receipt = new StudentFeeRefundReceipt(studentInvoice.getInstitution(), studentInvoice.getAcademicYear(), paymentMode, chequeReceivedDate, Double.valueOf(Math.round(totalAmountPaid)), studentInvoice.getStudent(), paymentStatus, chequeNo, chequeDate, chequeBankName, chequeBranchName, narration, createdBy, modifiedBy, studentInvoice);
            if (!isdiscountApplied) {
                i = 0;
                while (i < normalFeesItem.length) {
                    Long invoiceDetailId = normalFeesItem[i];
                    StudentInvoiceDetail studentInvoiceDetail = this.studentInvoiceDetailDAO.getStudentInvoiceDetailById(invoiceDetailId);
                    StudentFeeRefundReceiptDetail studentFeeRefundReceiptdetail = new StudentFeeRefundReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), false, null, null, 0.0, Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), chequeReceivedDate, paymentStatus, createdBy, modifiedBy);
                    receipt.getStudentFeeRefundReceiptDetails().add(studentFeeRefundReceiptdetail);
                    ++i;
                }
            } else {
                if (discountType.equals("percentage")) {
                    i = 0;
                    while (i < normalFeesItem.length) {
                        Long invoiceDetailId = normalFeesItem[i];
                        StudentInvoiceDetail studentInvoiceDetail = this.studentInvoiceDetailDAO.getStudentInvoiceDetailById(invoiceDetailId);
                        Double actualAmount = studentInvoiceDetail.getStudentInvoiceElementTotalAmount();
                        Double discountAmount = this.calculatePercentageDiscountAmount(invoiceDetailId, discountPercentage);
                        Long roundDiscountAmount = Math.round(discountAmount);
                        discountAmount = (double)roundDiscountAmount;
                        StudentFeeRefundReceiptDetail studentFeeRefundReceiptdetail = new StudentFeeRefundReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), true, discountType, discountPercentage.toString(), Double.valueOf(Math.round(discountAmount)), Double.valueOf(Math.round(actualAmount)), Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), chequeReceivedDate, paymentStatus, createdBy, modifiedBy);
                        receipt.getStudentFeeRefundReceiptDetails().add(studentFeeRefundReceiptdetail);
                        ++i;
                    }
                } else if (discountType.equals("flat")) {
                    StudentInvoiceDetail studentInvoiceDetail;
                    Long invoiceDetailId;
                    if (normalFeesItem != null) {
                        i = 0;
                        while (i < normalFeesItem.length) {
                            invoiceDetailId = normalFeesItem[i];
                            studentInvoiceDetail = this.studentInvoiceDetailDAO.getStudentInvoiceDetailById(invoiceDetailId);
                            StudentFeeRefundReceiptDetail studentFeeRefundReceiptdetail = new StudentFeeRefundReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), false, null, null, 0.0, Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), chequeReceivedDate, paymentStatus, createdBy, modifiedBy);
                            receipt.getStudentFeeRefundReceiptDetails().add(studentFeeRefundReceiptdetail);
                            ++i;
                        }
                    }
                    i = 0;
                    while (i < flatDiscountFeesItems.length) {
                        invoiceDetailId = flatDiscountFeesItems[i];
                        studentInvoiceDetail = this.studentInvoiceDetailDAO.getStudentInvoiceDetailById(invoiceDetailId);
                        Double actualAmount = studentInvoiceDetail.getStudentInvoiceElementTotalAmount();
                        Double discountAmount = flatDiscountFeesItemsAmount[i];
                        Long roundDiscountAmount = Math.round(discountAmount);
                        discountAmount = (double)roundDiscountAmount;
                        StudentFeeRefundReceiptDetail studentFeeRefundReceiptdetail = new StudentFeeRefundReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), true, discountType, null, Double.valueOf(Math.round(discountAmount)), Double.valueOf(Math.round(actualAmount)), Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), chequeReceivedDate, paymentStatus, createdBy, modifiedBy);
                        receipt.getStudentFeeRefundReceiptDetails().add(studentFeeRefundReceiptdetail);
                        ++i;
                    }
                }
                studentInvoice.setDiscountApplicable(false);
            }
            StudentFeeRefundReceipt persistedStudentFeeRefundReceipt = this.studentFeeRefundReceiptDAO.save(receipt);
            if (this.checkForInvoiceClosing(studentInvoice)) {
                studentInvoice.setInvoiceStatus(0);
            }
            persistedReceiptNo = persistedStudentFeeRefundReceipt.getStudentFeeRefundReceiptId();
            return persistedReceiptNo;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Long receiptByDD(Long[] normalFeesItem, Long[] flatDiscountFeesItems, Double[] flatDiscountFeesItemsAmount, Double fineAmount, Double totalAmountPaid, PaymentMode paymentMode, Date ddReceivedDate, String ddNo, Date ddDate, String ddBankName, String ddBranchName, boolean isdiscountApplied, String discountType, Double discountPercentage, String narration, String createdBy, String modifiedBy) throws ReceiptException {
        try {
            int i;
            int i2;
            PaymentStatus paymentStatus = this.paymentStatusDAO.getPaymentStatusById(1L);
            StudentInvoice studentInvoice = null;
            if (normalFeesItem != null) {
                i2 = 0;
                while (i2 < normalFeesItem.length) {
                    if (i2 == 0) {
                        studentInvoice = this.studentInvoiceDAO.getStudentInvoiceById(this.studentInvoiceDetailDAO.getStudentInvoiceDetailById(normalFeesItem[i2]).getStudentInvoice().getStudentInvoiceId());
                    }
                    ++i2;
                }
            } else {
                i2 = 0;
                while (i2 < flatDiscountFeesItems.length) {
                    if (i2 == 0) {
                        studentInvoice = this.studentInvoiceDAO.getStudentInvoiceById(this.studentInvoiceDetailDAO.getStudentInvoiceDetailById(flatDiscountFeesItems[i2]).getStudentInvoice().getStudentInvoiceId());
                    }
                    ++i2;
                }
            }
            Long persistedReceiptNo = null;
            StudentFeeRefundReceipt receipt = new StudentFeeRefundReceipt(studentInvoice.getInstitution(), studentInvoice.getAcademicYear(), paymentMode, Double.valueOf(Math.round(totalAmountPaid)), studentInvoice.getStudent(), paymentStatus, ddNo, ddDate, ddBankName, ddBranchName, ddReceivedDate, narration, createdBy, modifiedBy, studentInvoice);
            if (!isdiscountApplied) {
                i = 0;
                while (i < normalFeesItem.length) {
                    Long invoiceDetailId = normalFeesItem[i];
                    StudentInvoiceDetail studentInvoiceDetail = this.studentInvoiceDetailDAO.getStudentInvoiceDetailById(invoiceDetailId);
                    StudentFeeRefundReceiptDetail studentFeeRefundReceiptdetail = new StudentFeeRefundReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), false, null, null, 0.0, Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), ddReceivedDate, paymentStatus, createdBy, modifiedBy);
                    receipt.getStudentFeeRefundReceiptDetails().add(studentFeeRefundReceiptdetail);
                    ++i;
                }
            } else {
                if (discountType.equals("percentage")) {
                    i = 0;
                    while (i < normalFeesItem.length) {
                        Long invoiceDetailId = normalFeesItem[i];
                        StudentInvoiceDetail studentInvoiceDetail = this.studentInvoiceDetailDAO.getStudentInvoiceDetailById(invoiceDetailId);
                        Double actualAmount = studentInvoiceDetail.getStudentInvoiceElementTotalAmount();
                        Double discountAmount = this.calculatePercentageDiscountAmount(invoiceDetailId, discountPercentage);
                        Long roundDiscountAmount = Math.round(discountAmount);
                        discountAmount = (double)roundDiscountAmount;
                        StudentFeeRefundReceiptDetail studentFeeRefundReceiptdetail = new StudentFeeRefundReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), true, discountType, discountPercentage.toString(), Double.valueOf(Math.round(discountAmount)), Double.valueOf(Math.round(actualAmount)), Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), ddReceivedDate, paymentStatus, createdBy, modifiedBy);
                        receipt.getStudentFeeRefundReceiptDetails().add(studentFeeRefundReceiptdetail);
                        ++i;
                    }
                } else if (discountType.equals("flat")) {
                    StudentInvoiceDetail studentInvoiceDetail;
                    Long invoiceDetailId;
                    if (normalFeesItem != null) {
                        i = 0;
                        while (i < normalFeesItem.length) {
                            invoiceDetailId = normalFeesItem[i];
                            studentInvoiceDetail = this.studentInvoiceDetailDAO.getStudentInvoiceDetailById(invoiceDetailId);
                            StudentFeeRefundReceiptDetail studentFeeRefundReceiptdetail = new StudentFeeRefundReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), false, null, null, 0.0, Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), ddReceivedDate, paymentStatus, createdBy, modifiedBy);
                            receipt.getStudentFeeRefundReceiptDetails().add(studentFeeRefundReceiptdetail);
                            ++i;
                        }
                    }
                    i = 0;
                    while (i < flatDiscountFeesItems.length) {
                        invoiceDetailId = flatDiscountFeesItems[i];
                        studentInvoiceDetail = this.studentInvoiceDetailDAO.getStudentInvoiceDetailById(invoiceDetailId);
                        Double actualAmount = studentInvoiceDetail.getStudentInvoiceElementTotalAmount();
                        Double discountAmount = flatDiscountFeesItemsAmount[i];
                        Long roundDiscountAmount = Math.round(discountAmount);
                        discountAmount = (double)roundDiscountAmount;
                        StudentFeeRefundReceiptDetail studentFeeRefundReceiptdetail = new StudentFeeRefundReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), true, discountType, null, Double.valueOf(Math.round(discountAmount)), Double.valueOf(Math.round(actualAmount)), Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), ddReceivedDate, paymentStatus, createdBy, modifiedBy);
                        receipt.getStudentFeeRefundReceiptDetails().add(studentFeeRefundReceiptdetail);
                        ++i;
                    }
                }
                studentInvoice.setDiscountApplicable(false);
            }
            StudentFeeRefundReceipt persistedStudentFeeRefundReceipt = this.studentFeeRefundReceiptDAO.save(receipt);
            if (this.checkForInvoiceClosing(studentInvoice)) {
                studentInvoice.setInvoiceStatus(0);
            }
            persistedReceiptNo = persistedStudentFeeRefundReceipt.getStudentFeeRefundReceiptId();
            return persistedReceiptNo;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public boolean checkForInvoiceClosing(StudentInvoice studentInvoice) {
        boolean closeStatus = false;
        if (this.studentInvoiceDetailDAO.getStudentPendingInvoiceFeesItemsByInvoiceIdAndInvoiceStatus(studentInvoice, 1).isEmpty()) {
            closeStatus = true;
        }
        return closeStatus;
    }

    @Override
    public ArrayList<StudentFeeRefundReceipt> getStudentFeeRefundReceiptsByPaymentMode(Long paymentModeId) {
        PaymentMode paymentMode = this.paymentModeDAO.getPaymentModeById(paymentModeId);
        Set<StudentFeeRefundReceipt> studentFeeRefundReceipts = paymentMode.getStudentFeeRefundReceipts();
        ArrayList<StudentFeeRefundReceipt> studentFeeRefundReceiptList = new ArrayList<StudentFeeRefundReceipt>();
        studentFeeRefundReceiptList.addAll(studentFeeRefundReceipts);
        return studentFeeRefundReceiptList;
    }

    @Override
    public ArrayList<StudentFeeRefundReceipt> getStudentFeeRefundReceiptsFromPaymentModeAndStatus(Long paymentModeId, Long paymentStatusId) {
        PaymentMode paymentMode = this.paymentModeDAO.getPaymentModeById(paymentModeId);
        PaymentStatus paymentStatus = this.paymentStatusDAO.getPaymentStatusById(paymentStatusId);
        ArrayList studentFeeRefundReceipts = (ArrayList)this.studentFeeRefundReceiptDAO.getStudentFeeRefundReceiptByPaymentModeAndStatus(paymentMode, paymentStatus);
        for (StudentFeeRefundReceipt studentFeeRefundReceipt : studentFeeRefundReceipts) {
            Hibernate.initialize((Object)studentFeeRefundReceipt.getStudent());
        }
        return studentFeeRefundReceipts;
    }

    @Override
    public void updateReconcillation(Long[] receiptId, Long paymentStatusId, Date clearanceDate, String comment, String receiptClearedBy) throws StudentFeeRefundReceiptException {
        StudentFeeRefundReceipt studentFeeRefundReceipt = null;
        int i = 0;
        while (i < receiptId.length) {
            Long receipt = receiptId[i];
            studentFeeRefundReceipt = this.studentFeeRefundReceiptDAO.getStudentFeeRefundReceiptById(receipt);
            PaymentStatus paymentStatus = this.paymentStatusDAO.getPaymentStatusById(paymentStatusId);
            if (paymentStatusId == 2L) {
                studentFeeRefundReceipt.setPaymentStatus(paymentStatus);
                studentFeeRefundReceipt.setPaymentClearedDate(clearanceDate);
                studentFeeRefundReceipt.setComments(comment);
                studentFeeRefundReceipt.setReceiptClearedBy(receiptClearedBy);
                for (StudentFeeRefundReceiptDetail studentFeeRefundReceiptDetail : studentFeeRefundReceipt.getStudentFeeRefundReceiptDetails()) {
                    studentFeeRefundReceiptDetail.setPaymentStatus(paymentStatus);
                    studentFeeRefundReceiptDetail.setPaymentClearedDate(clearanceDate);
                    this.studentFeeRefundReceiptDetailDAO.update(studentFeeRefundReceiptDetail);
                }
                this.studentFeeRefundReceiptDAO.update(studentFeeRefundReceipt);
            } else if (paymentStatusId == 1L) {
                throw new StudentFeeRefundReceiptException(new Message("failure", "Invoice Status Already Pending"));
            }
            ++i;
        }
    }

    @Override
    public void updateChequeReconcillation(Long[] receiptId, Long paymentStatusId, Date chequeClearanceDate, String comment, String receiptClearedBy) throws StudentFeeRefundReceiptException {
        int i = 0;
        while (i < receiptId.length) {
            Long receipt = receiptId[i];
            StudentFeeRefundReceipt studentFeeRefundReceipt = this.studentFeeRefundReceiptDAO.getStudentFeeRefundReceiptById(receipt);
            PaymentStatus paymentStatus = this.paymentStatusDAO.getPaymentStatusById(paymentStatusId);
            if (paymentStatusId == 2L) {
                studentFeeRefundReceipt.setPaymentStatus(paymentStatus);
                studentFeeRefundReceipt.setPaymentClearedDate(chequeClearanceDate);
                studentFeeRefundReceipt.setComments(comment);
                studentFeeRefundReceipt.setReceiptClearedBy(receiptClearedBy);
                for (StudentFeeRefundReceiptDetail studentFeeRefundReceiptDetail : studentFeeRefundReceipt.getStudentFeeRefundReceiptDetails()) {
                    studentFeeRefundReceiptDetail.setPaymentStatus(paymentStatus);
                    studentFeeRefundReceiptDetail.setPaymentClearedDate(chequeClearanceDate);
                    this.studentFeeRefundReceiptDetailDAO.update(studentFeeRefundReceiptDetail);
                }
                this.studentFeeRefundReceiptDAO.update(studentFeeRefundReceipt);
            } else if (paymentStatusId == 3L) {
                boolean chequeForDiscount = true;
                StudentInvoice studentInvoice = studentFeeRefundReceipt.getStudentInvoice();
                Set<StudentFeeRefundReceiptDetail> receiptFeeRefundDetails = studentFeeRefundReceipt.getStudentFeeRefundReceiptDetails();
                if (receiptFeeRefundDetails != null) {
                    boolean count = true;
                    for (StudentFeeRefundReceiptDetail studentFeeRefundReceiptDetail : receiptFeeRefundDetails) {
                        if (count) {
                            studentFeeRefundReceipt.setPaymentStatus(paymentStatus);
                            studentFeeRefundReceipt.setReceiptClearedBy(receiptClearedBy);
                            studentFeeRefundReceipt.setComments(comment);
                            this.studentFeeRefundReceiptDAO.update(studentFeeRefundReceipt);
                            count = false;
                        }
                        studentFeeRefundReceiptDetail.getStudentInvoiceDetail().setStudentInvoiceElementPaymentStatus(1);
                        studentFeeRefundReceiptDetail.setPaymentStatus(paymentStatus);
                        if (chequeForDiscount && studentFeeRefundReceiptDetail.isDiscountApplied()) {
                            chequeForDiscount = false;
                            studentInvoice.setDiscountApplicable(true);
                        }
                        this.studentFeeRefundReceiptDetailDAO.update(studentFeeRefundReceiptDetail);
                    }
                    studentInvoice.setInvoiceStatus(1);
                }
            } else if (paymentStatusId == 1L) {
                throw new StudentFeeRefundReceiptException(new Message("failure", "Invoice Status Already Pending"));
            }
            ++i;
        }
    }

    @Override
    public void updateDdReconcillation(Long[] receiptId, Long paymentStatusId, Date chequeClearanceDate, String comment, String receiptClearedBy) throws StudentFeeRefundReceiptException {
        int i = 0;
        while (i < receiptId.length) {
            Long receipt = receiptId[i];
            StudentFeeRefundReceipt studentFeeRefundReceipt = this.studentFeeRefundReceiptDAO.getStudentFeeRefundReceiptById(receipt);
            PaymentStatus paymentStatus = this.paymentStatusDAO.getPaymentStatusById(paymentStatusId);
            if (paymentStatusId == 2L) {
                studentFeeRefundReceipt.setPaymentStatus(paymentStatus);
                studentFeeRefundReceipt.setPaymentClearedDate(chequeClearanceDate);
                studentFeeRefundReceipt.setComments(comment);
                studentFeeRefundReceipt.setReceiptClearedBy(receiptClearedBy);
                for (StudentFeeRefundReceiptDetail studentFeeRefundReceiptDetail : studentFeeRefundReceipt.getStudentFeeRefundReceiptDetails()) {
                    studentFeeRefundReceiptDetail.setPaymentStatus(paymentStatus);
                    studentFeeRefundReceiptDetail.setPaymentClearedDate(chequeClearanceDate);
                    this.studentFeeRefundReceiptDetailDAO.update(studentFeeRefundReceiptDetail);
                }
                this.studentFeeRefundReceiptDAO.update(studentFeeRefundReceipt);
            } else if (paymentStatusId == 3L) {
                boolean chequeForDiscount = true;
                StudentInvoice studentInvoice = studentFeeRefundReceipt.getStudentInvoice();
                Set<StudentFeeRefundReceiptDetail> receiptDetails = studentFeeRefundReceipt.getStudentFeeRefundReceiptDetails();
                if (receiptDetails != null) {
                    boolean count = true;
                    for (StudentFeeRefundReceiptDetail studentFeeRefundReceiptDetail : receiptDetails) {
                        if (count) {
                            studentFeeRefundReceipt.setPaymentStatus(paymentStatus);
                            studentFeeRefundReceipt.setReceiptClearedBy(receiptClearedBy);
                            studentFeeRefundReceipt.setComments(comment);
                            this.studentFeeRefundReceiptDAO.update(studentFeeRefundReceipt);
                            count = false;
                        }
                        studentFeeRefundReceiptDetail.getStudentInvoiceDetail().setStudentInvoiceElementPaymentStatus(1);
                        studentFeeRefundReceiptDetail.setPaymentStatus(paymentStatus);
                        if (chequeForDiscount && studentFeeRefundReceiptDetail.isDiscountApplied()) {
                            chequeForDiscount = false;
                            studentInvoice.setDiscountApplicable(true);
                        }
                        this.studentFeeRefundReceiptDetailDAO.update(studentFeeRefundReceiptDetail);
                    }
                    studentInvoice.setInvoiceStatus(1);
                }
            } else if (paymentStatusId == 1L) {
                throw new StudentFeeRefundReceiptException(new Message("failure", "Invoice Status Already Pending"));
            }
            ++i;
        }
    }

    @Override
    public StudentFeeRefundReceipt getStudentFeeRefundReceiptDetails(Long receiptId) throws ParseException {
        StudentFeeRefundReceipt studentFeeRefundReceipt = this.studentFeeRefundReceiptDAO.getStudentFeeRefundReceiptById(receiptId);
        Hibernate.initialize(studentFeeRefundReceipt.getStudentFeeRefundReceiptDetails());
        Set<StudentFeeRefundReceiptDetail> studentFeeRefundReceiptdetails = studentFeeRefundReceipt.getStudentFeeRefundReceiptDetails();
        for (StudentFeeRefundReceiptDetail studentFeeRefundReceiptDetail : studentFeeRefundReceiptdetails) {
            Hibernate.initialize((Object)studentFeeRefundReceiptDetail.getStudentInvoiceDetail().getFeesItem());
        }
        Hibernate.initialize(studentFeeRefundReceipt.getStudent().getSpecialCategories());
        Hibernate.initialize((Object)studentFeeRefundReceipt.getPaymentMode());
        Hibernate.initialize((Object)studentFeeRefundReceipt.getInstitution());
        Hibernate.initialize((Object)studentFeeRefundReceipt.getAcademicYear());
        Hibernate.initialize((Object)studentFeeRefundReceipt.getStudent().getStudentClass());
        Hibernate.initialize((Object)studentFeeRefundReceipt.getStudent().getSection());
        Hibernate.initialize((Object)studentFeeRefundReceipt.getPaymentReceivedDate());
        Hibernate.initialize((Object)studentFeeRefundReceipt.getStudentInvoice().getFeesTerm());
        Hibernate.initialize((Object)studentFeeRefundReceipt.getStudent().getInstitution());
        return studentFeeRefundReceipt;
    }

    @Override
    public ArrayList<StudentFeeRefundReceipt> getAllStudentFeeRefundReceipts(AcademicYear academicYear, Class clazz, Section section) {
        ArrayList students = (ArrayList)this.studentDAO.getStudentsByClassAndSection(clazz, section);
        ArrayList<StudentFeeRefundReceipt> studentFeeRefundReceipts = new ArrayList<StudentFeeRefundReceipt>();
        for (Student student : students) {
            ArrayList studentFeeRefundReceipts1 = (ArrayList)this.studentFeeRefundReceiptDAO.getAllStudentFeeRefundReceipts(academicYear, student);
            for (StudentFeeRefundReceipt studentFeeRefundReceipt : studentFeeRefundReceipts1) {
                for (StudentFeeRefundReceiptDetail StudentFeeRefundReceiptDetail2 : studentFeeRefundReceipt.getStudentFeeRefundReceiptDetails()) {
                    Hibernate.initialize((Object)StudentFeeRefundReceiptDetail2.getDiscountAmount());
                }
                Hibernate.initialize((Object)studentFeeRefundReceipt.getPaymentMode());
                Hibernate.initialize((Object)studentFeeRefundReceipt.getPaymentStatus());
                Hibernate.initialize((Object)studentFeeRefundReceipt.getStudent().getStudentClass());
                Hibernate.initialize((Object)studentFeeRefundReceipt.getStudent().getSection());
                Hibernate.initialize((Object)studentFeeRefundReceipt.getStudentInvoice().getFeesTerm().getFeesTermName());
            }
            studentFeeRefundReceipts.addAll(studentFeeRefundReceipts1);
        }
        return studentFeeRefundReceipts;
    }

    @Override
    public ArrayList<StudentFeeRefundReceipt> getAllStudentFeeRefundReceipts(AcademicYear academicYear, Institution institution) {
        ArrayList studentFeeRefundReceipts = (ArrayList)this.studentFeeRefundReceiptDAO.getAllStudentsReceipts(academicYear, institution);
        for (StudentFeeRefundReceipt studentFeeRefundReceipt : studentFeeRefundReceipts) {
            for (StudentFeeRefundReceiptDetail StudentFeeRefundReceiptDetail2 : studentFeeRefundReceipt.getStudentFeeRefundReceiptDetails()) {
                Hibernate.initialize((Object)StudentFeeRefundReceiptDetail2.getDiscountAmount());
            }
            Hibernate.initialize((Object)studentFeeRefundReceipt.getPaymentMode());
            Hibernate.initialize((Object)studentFeeRefundReceipt.getPaymentStatus());
            Hibernate.initialize((Object)studentFeeRefundReceipt.getStudent().getStudentClass());
            Hibernate.initialize((Object)studentFeeRefundReceipt.getStudentInvoice().getFeesTerm().getFeesTermName());
            Hibernate.initialize((Object)studentFeeRefundReceipt.getStudent().getSection());
        }
        return studentFeeRefundReceipts;
    }

    @Override
    public ArrayList<StudentFeeRefundReceipt> getStudentFeeRefundReceiptsBySpecialCategory(AcademicYear academicYear, Class clazz, Section section, SpecialCategory specialCategory) {
        ArrayList students = (ArrayList)this.studentDAO.getStudentsByClassSectionAndSpecialCategory(clazz, section, specialCategory);
        ArrayList<StudentFeeRefundReceipt> studentFeeRefundReceipts = new ArrayList<StudentFeeRefundReceipt>();
        for (Student student : students) {
            ArrayList receipts = (ArrayList)this.studentFeeRefundReceiptDAO.getAllStudentFeeRefundReceipts(academicYear, student);
            for (StudentFeeRefundReceipt studentFeeRefundReceipt : receipts) {
                for (StudentFeeRefundReceiptDetail StudentFeeRefundReceiptDetail2 : studentFeeRefundReceipt.getStudentFeeRefundReceiptDetails()) {
                    Hibernate.initialize((Object)StudentFeeRefundReceiptDetail2.getDiscountAmount());
                }
                Hibernate.initialize((Object)studentFeeRefundReceipt.getPaymentMode());
                Hibernate.initialize((Object)studentFeeRefundReceipt.getPaymentStatus());
                Hibernate.initialize((Object)studentFeeRefundReceipt.getStudent().getStudentClass());
                Hibernate.initialize((Object)studentFeeRefundReceipt.getStudent().getSection());
                Hibernate.initialize((Object)studentFeeRefundReceipt.getStudentInvoice().getFeesTerm().getFeesTermName());
            }
            studentFeeRefundReceipts.addAll(receipts);
        }
        return studentFeeRefundReceipts;
    }

    @Override
    public ArrayList<StudentFeeRefundReceipt> getStudentFeeRefundReceiptsBySpecialCategory(AcademicYear academicYear, SpecialCategory specialCategory, Institution institution) {
        ArrayList receipts = (ArrayList)this.studentFeeRefundReceiptDAO.getAllStudentsReceipts(academicYear, institution);
        Iterator receiptIterator = receipts.iterator();
        while (receiptIterator.hasNext()) {
            StudentFeeRefundReceipt studentFeeRefundReceipt = (StudentFeeRefundReceipt)receiptIterator.next();
            if (studentFeeRefundReceipt.getStudent().getSpecialCategories().contains(specialCategory)) continue;
            receiptIterator.remove();
        }
        for (StudentFeeRefundReceipt studentFeeRefundReceipt : receipts) {
            for (StudentFeeRefundReceiptDetail StudentFeeRefundReceiptDetail2 : studentFeeRefundReceipt.getStudentFeeRefundReceiptDetails()) {
                Hibernate.initialize((Object)StudentFeeRefundReceiptDetail2.getDiscountAmount());
            }
            Hibernate.initialize((Object)studentFeeRefundReceipt.getPaymentMode());
            Hibernate.initialize((Object)studentFeeRefundReceipt.getPaymentStatus());
            Hibernate.initialize((Object)studentFeeRefundReceipt.getStudent().getStudentClass());
            Hibernate.initialize((Object)studentFeeRefundReceipt.getStudent().getSection());
            Hibernate.initialize((Object)studentFeeRefundReceipt.getStudentInvoice().getFeesTerm().getFeesTermName());
        }
        return receipts;
    }

    @Override
    public ArrayList<StudentFeeRefundReceipt> getStudentFeeRefundReceiptsByAdmisssionNo(String admissionNo) {
        Student student = this.studentDAO.getStudentByAdmissionNo(admissionNo);
        ArrayList<StudentFeeRefundReceipt> studentFeeRefundReceipts = new ArrayList<StudentFeeRefundReceipt>();
        if (student != null) {
            Hibernate.initialize(student.getStudentFeeRefundReceipts());
            Set<StudentFeeRefundReceipt> receipts = student.getStudentFeeRefundReceipts();
            for (StudentFeeRefundReceipt studentFeeRefundReceipt : receipts) {
                Hibernate.initialize((Object)studentFeeRefundReceipt);
                Hibernate.initialize((Object)studentFeeRefundReceipt.getPaymentMode());
                Hibernate.initialize((Object)studentFeeRefundReceipt.getAcademicYear());
                Hibernate.initialize((Object)studentFeeRefundReceipt.getPaymentStatus());
                Hibernate.initialize((Object)studentFeeRefundReceipt.getStudent().getStudentClass());
                Hibernate.initialize((Object)studentFeeRefundReceipt.getStudent().getSection());
                Hibernate.initialize((Object)studentFeeRefundReceipt.getStudentInvoice().getFeesTerm());
                studentFeeRefundReceipts.add(studentFeeRefundReceipt);
            }
        }
        return studentFeeRefundReceipts;
    }

    @Override
    public ArrayList<StudentFeeRefundReceipt> getStudentFeeRefundReceiptsByAdmisssionNoAndAcademicYear(String admissionNo, AcademicYear academicYear) {
        Student student = this.studentDAO.getStudentByAdmissionNo(admissionNo);
        ArrayList<StudentFeeRefundReceipt> studentFeeRefundReceipts = new ArrayList<StudentFeeRefundReceipt>();
        if (student != null) {
            Set<StudentFeeRefundReceipt> receipts = student.getStudentFeeRefundReceipts();
            Iterator<StudentFeeRefundReceipt> studentFeeRefundReceiptIterator = receipts.iterator();
            while (studentFeeRefundReceiptIterator.hasNext()) {
                StudentFeeRefundReceipt studentFeeRefundReceipt = studentFeeRefundReceiptIterator.next();
                if (studentFeeRefundReceipt.getAcademicYear().getAcademicYearId() == academicYear.getAcademicYearId()) continue;
                studentFeeRefundReceiptIterator.remove();
            }
            for (StudentFeeRefundReceipt studentFeeRefundReceipt : receipts) {
                for (StudentFeeRefundReceiptDetail StudentFeeRefundReceiptDetail2 : studentFeeRefundReceipt.getStudentFeeRefundReceiptDetails()) {
                    Hibernate.initialize((Object)StudentFeeRefundReceiptDetail2.getDiscountAmount());
                }
                Hibernate.initialize((Object)studentFeeRefundReceipt.getPaymentMode());
                Hibernate.initialize((Object)studentFeeRefundReceipt.getPaymentStatus());
                Hibernate.initialize((Object)studentFeeRefundReceipt.getStudent().getStudentClass());
                Hibernate.initialize((Object)studentFeeRefundReceipt.getStudent().getSection());
                Hibernate.initialize((Object)studentFeeRefundReceipt.getStudentInvoice().getFeesTerm().getFeesTermName());
            }
            studentFeeRefundReceipts.addAll(receipts);
        }
        return studentFeeRefundReceipts;
    }

    @Override
    public void deleteReceipt(Long receiptId) {
        StudentFeeRefundReceipt receipt = this.studentFeeRefundReceiptDAO.getStudentFeeRefundReceiptById(receiptId);
        StudentInvoice studentInvoice = receipt.getStudentInvoice();
        studentInvoice.setInvoiceStatus(1);
        Set<StudentInvoiceDetail> studentInvoiceDetails = studentInvoice.getStudentInvoiceDetails();
        for (StudentInvoiceDetail studentInvoiceDetail : studentInvoiceDetails) {
            studentInvoiceDetail.setStudentInvoiceElementPaymentStatus(1);
            if (this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail) == null) continue;
            this.studentPartialPaymentReceiptDetailDAO.delete(this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail));
        }
        this.studentFeeRefundReceiptDAO.delete(receipt);
    }

    @Override
    public ArrayList<StudentFeeRefundReceipt> getReceiptsByDateRange(Date fromDate, Date toDate, Institution institution) {
        List<StudentFeeRefundReceipt> receipts = this.studentFeeRefundReceiptDAO.getStudentFeeRefundReceiptByDate(fromDate, toDate, institution);
        for (StudentFeeRefundReceipt studentFeeRefundReceipt : receipts) {
            for (StudentFeeRefundReceiptDetail StudentFeeRefundReceiptDetail2 : studentFeeRefundReceipt.getStudentFeeRefundReceiptDetails()) {
                Hibernate.initialize((Object)StudentFeeRefundReceiptDetail2.getDiscountAmount());
            }
            Hibernate.initialize((Object)studentFeeRefundReceipt.getPaymentMode());
            Hibernate.initialize((Object)studentFeeRefundReceipt.getPaymentStatus());
            Hibernate.initialize((Object)studentFeeRefundReceipt.getStudent().getStudentClass());
            Hibernate.initialize((Object)studentFeeRefundReceipt.getStudent().getSection());
            Hibernate.initialize((Object)studentFeeRefundReceipt.getStudentInvoice().getFeesTerm().getFeesTermName());
        }
        return (ArrayList)receipts;
    }

    @Override
    public Long amountTobeCollectedOnPercentageDiscount(Long[] normalFeesItemId, Double percentage) {
        Double totalAmount = 0.0;
        Double totalDiscountAmount = 0.0;
        Double totalAmountTobeCollected = 0.0;
        int i = 0;
        while (i < normalFeesItemId.length) {
            Long feesItemId = normalFeesItemId[i];
            StudentInvoiceDetail studentInvoiceDetail = this.studentInvoiceDetailDAO.getStudentInvoiceDetailById(feesItemId);
            if (this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail) != null) {
                StudentPartialPaymentReceiptDetail studentPartialPaymentReceiptDetail = this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail);
                totalAmount = totalAmount + (studentInvoiceDetail.getStudentInvoiceElementTotalAmount() - studentPartialPaymentReceiptDetail.getPaidReceiptAmount());
            } else {
                totalAmount = totalAmount + studentInvoiceDetail.getStudentInvoiceElementTotalAmount();
            }
            totalDiscountAmount = totalDiscountAmount + this.calculatePercentageDiscountAmount(feesItemId, percentage);
            ++i;
        }
        totalAmountTobeCollected = totalAmount - (double)Math.round(totalDiscountAmount);
        return Math.round(totalAmountTobeCollected);
    }

    @Override
    public Long amountTobeCollectedOnPercentageDiscountAndPartialAmount(Long[] normalFeesItemId, Double percentage, Double[] partialAmounts) {
        Double totalAmount = 0.0;
        Double totalAmount1 = 0.0;
        Double totalDiscountAmount = 0.0;
        int i = 0;
        while (i < normalFeesItemId.length) {
            Long feesItemId = normalFeesItemId[i];
            StudentInvoiceDetail studentInvoiceDetail = this.studentInvoiceDetailDAO.getStudentInvoiceDetailById(feesItemId);
            totalAmount = totalAmount + studentInvoiceDetail.getStudentInvoiceElementTotalAmount();
            totalDiscountAmount = totalDiscountAmount + this.calculatePercentageDiscountAmountAndPartialAmount(feesItemId, percentage, partialAmounts[i]);
            totalAmount1 = totalAmount1 + (double)Math.round(partialAmounts[i]);
            ++i;
        }
        return Math.round(totalAmount1);
    }

    @Override
    public Long amountTobeCollectedOnFlatDiscount(Long[] normalFeesItemId, Double[] flatDiscount) {
        Double totalAmount = 0.0;
        int i = 0;
        while (i < normalFeesItemId.length) {
            Long feesItemId = normalFeesItemId[i];
            StudentInvoiceDetail studentInvoiceDetail = this.studentInvoiceDetailDAO.getStudentInvoiceDetailById(feesItemId);
            if (this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail) != null) {
                StudentPartialPaymentReceiptDetail studentPartialPaymentReceiptDetail = this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail);
                totalAmount = totalAmount + (studentInvoiceDetail.getStudentInvoiceElementTotalAmount() - studentPartialPaymentReceiptDetail.getPaidReceiptAmount());
            } else {
                totalAmount = totalAmount + studentInvoiceDetail.getStudentInvoiceElementTotalAmount();
            }
            Double discount = Math.round(flatDiscount[i]);
            totalAmount = totalAmount - discount;
            ++i;
        }
        return Math.round(totalAmount);
    }

    @Override
    public Long amountTobeCollectedOnFlatDiscountAndPartialAmount(Long[] normalFeesItemId, Double[] flatDiscount, Double[] partialAmounts) {
        Double totalAmount = 0.0;
        int i = 0;
        while (i < normalFeesItemId.length) {
            Long feesItemId = normalFeesItemId[i];
            StudentInvoiceDetail studentInvoiceDetail = this.studentInvoiceDetailDAO.getStudentInvoiceDetailById(feesItemId);
            if (studentInvoiceDetail != null) {
                Double discount = Math.round(partialAmounts[i]);
                totalAmount = totalAmount + discount;
            }
            ++i;
        }
        return Math.round(totalAmount);
    }

    @Override
    public Long amountTobeCollectedWhenNoDiscount(Long[] normalFeesItemId) {
        Double totalAmount = 0.0;
        int i = 0;
        while (i < normalFeesItemId.length) {
            Long feesItemId = normalFeesItemId[i];
            StudentInvoiceDetail studentInvoiceDetail = this.studentInvoiceDetailDAO.getStudentInvoiceDetailById(feesItemId);
            if (this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail) != null) {
                StudentPartialPaymentReceiptDetail studentPartialPaymentReceiptDetail = this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail);
                totalAmount = totalAmount + (studentInvoiceDetail.getStudentInvoiceElementTotalAmount() - studentPartialPaymentReceiptDetail.getPaidReceiptAmount());
            } else {
                totalAmount = totalAmount + studentInvoiceDetail.getStudentInvoiceElementTotalAmount();
            }
            ++i;
        }
        return Math.round(totalAmount);
    }

    @Override
    public Long amountTobeCollectedWhenNoDiscountAndPartialAmount(Long[] normalFeesItemId, Double[] partialAmounts) {
        Double totalAmount = 0.0;
        int i = 0;
        while (i < normalFeesItemId.length) {
            Long feesItemId = normalFeesItemId[i];
            StudentInvoiceDetail studentInvoiceDetail = this.studentInvoiceDetailDAO.getStudentInvoiceDetailById(feesItemId);
            if (studentInvoiceDetail != null) {
                totalAmount = totalAmount + (double)Math.round(partialAmounts[i]);
            }
            ++i;
        }
        return Math.round(totalAmount);
    }

    @Override
    public Double calculatePercentageDiscountAmount(Long feesItemId, Double percentage) {
        StudentInvoiceDetail studentInvoiceDetail = this.studentInvoiceDetailDAO.getStudentInvoiceDetailById(feesItemId);
        Double totalAmount = 0.0;
        if (this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail) != null) {
            StudentPartialPaymentReceiptDetail studentPartialPaymentReceiptDetail = this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail);
            totalAmount = totalAmount + (studentInvoiceDetail.getStudentInvoiceElementTotalAmount() - studentPartialPaymentReceiptDetail.getPaidReceiptAmount());
        } else {
            totalAmount = totalAmount + studentInvoiceDetail.getStudentInvoiceElementTotalAmount();
        }
        Double itemActualAmount = totalAmount;
        Double percentageVariable = percentage / 100.0;
        return (double)Math.round(itemActualAmount * percentageVariable * 100.0) / 100.0;
    }

    @Override
    public Double calculatePercentageDiscountAmountAndPartialAmount(Long feesItemId, Double percentage, Double partialAmount) {
        StudentInvoiceDetail studentInvoiceDetail = this.studentInvoiceDetailDAO.getStudentInvoiceDetailById(feesItemId);
        Double totalAmount = 0.0;
        if (studentInvoiceDetail != null) {
            Double itemActualAmount = studentInvoiceDetail.getStudentInvoiceElementTotalAmount();
            Double percentageVariable = percentage / 100.0;
            totalAmount = (double)Math.round(itemActualAmount * percentageVariable * 100.0) / 100.0;
        }
        totalAmount = totalAmount + partialAmount;
        return partialAmount;
    }

    @Override
    public ArrayList<SixFieldReports> getStudentFeeRefundReceiptsByDateRange(Long institutionId, Date fromDate, Date toDate, Long paymentModeId) throws Exception {
        try {
            ArrayList<SixFieldReports> addSixFieldReports = new ArrayList<SixFieldReports>();
            PaymentMode paymentMode = this.paymentModeDAO.getPaymentModeById(paymentModeId);
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            Hibernate.initialize(institution.getLedgerAccounts());
            Set<InstituteLedgerAccount> instituteLedgerAccounts = institution.getLedgerAccounts();
            for (InstituteLedgerAccount instituteLedgerAccount : instituteLedgerAccounts) {
                Hibernate.initialize(instituteLedgerAccount.getFeesItems());
                Set<FeesItem> feesItems = instituteLedgerAccount.getFeesItems();
                for (FeesItem feesItem : feesItems) {
                    String feesTemplateName = "";
                    Long feesTemplateId = 0L;
                    Double totalAmount = 0.0;
                    Double paidReceiptAmount = 0.0;
                    Double discountAmount = 0.0;
                    Double outStandingAmount = 0.0;
                    feesTemplateName = feesItem.getFeesItemName();
                    feesTemplateId = feesItem.getFeesItemId();
                    Hibernate.initialize(feesItem.getStudentReceiptsItems());
                    Set<StudentFeeRefundReceiptDetail> studentFeeRefundReceiptDetails = feesItem.getStudentFeeRefundReceiptsItems();
                    for (StudentFeeRefundReceiptDetail studentFeeRefundReceiptDetail : studentFeeRefundReceiptDetails) {
                        for (StudentFeeRefundReceipt studentFeeRefundReceipt : this.studentFeeRefundReceiptDAO.getStudentFeeRefundReceiptByPaymentAndInstitution(institution, paymentMode)) {
                            StudentFeeRefundReceiptDetail curStudentFeeRefundReceiptDetail = this.studentFeeRefundReceiptDetailDAO.getStudentFeeRefundReceiptDetailByDate(fromDate, toDate, studentFeeRefundReceiptDetail.getStudentFeeRefundReceiptDetailId(), studentFeeRefundReceipt);
                            if (curStudentFeeRefundReceiptDetail == null || studentFeeRefundReceiptDetail.getStudentFeeRefundReceiptDetailId() != curStudentFeeRefundReceiptDetail.getStudentFeeRefundReceiptDetailId()) continue;
                            paidReceiptAmount = paidReceiptAmount + curStudentFeeRefundReceiptDetail.getPaidReceiptAmount();
                            discountAmount = discountAmount + curStudentFeeRefundReceiptDetail.getDiscountAmount();
                        }
                    }
                    totalAmount = (double)Math.round(totalAmount * 100.0) / 100.0;
                    outStandingAmount = (double)Math.round(outStandingAmount * 100.0) / 100.0;
                    paidReceiptAmount = (double)Math.round(paidReceiptAmount * 100.0) / 100.0;
                    discountAmount = (double)Math.round(discountAmount * 100.0) / 100.0;
                    SixFieldReports sixFieldReport = new SixFieldReports(feesTemplateId, feesTemplateName, totalAmount, paidReceiptAmount, discountAmount, outStandingAmount);
                    addSixFieldReports.add(sixFieldReport);
                }
            }
            return addSixFieldReports;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteStudentFeeRefundReceiptsByAcademicYear(Long[] studentIds, Long academicYearId) throws Exception, StudentFeeRefundReceiptException {
        AcademicYear academicYear = this.academicYearDAO.getAcademicYearById(academicYearId);
        Long[] longArray = studentIds;
        int n = studentIds.length;
        int n2 = 0;
        while (n2 < n) {
            Long studentId = longArray[n2];
            Student student = this.studentDAO.getStudentById(studentId);
            List<StudentFeeRefundReceipt> studentFeeRefundReceipts = this.studentFeeRefundReceiptDAO.getAllStudentFeeRefundReceipts(academicYear, student);
            if (studentFeeRefundReceipts != null) {
                for (StudentFeeRefundReceipt studentFeeRefundReceipt : studentFeeRefundReceipts) {
                    StudentFeeRefundReceipt receipt = this.studentFeeRefundReceiptDAO.getStudentFeeRefundReceiptById(studentFeeRefundReceipt.getStudentFeeRefundReceiptId());
                    StudentInvoice studentInvoice = receipt.getStudentInvoice();
                    studentInvoice.setInvoiceStatus(1);
                    Set<StudentInvoiceDetail> studentInvoiceDetails = studentInvoice.getStudentInvoiceDetails();
                    for (StudentInvoiceDetail studentInvoiceDetail : studentInvoiceDetails) {
                        if (this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail) != null) {
                            studentInvoiceDetail.setStudentPartialPaymentReceiptDetail(null);
                            this.studentInvoiceDetailDAO.update(studentInvoiceDetail);
                            this.studentPartialPaymentReceiptDetailDAO.delete(this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail));
                        }
                        studentInvoiceDetail.setStudentInvoiceElementPaymentStatus(1);
                    }
                    this.studentInvoiceDAO.update(studentInvoice);
                    this.studentFeeRefundReceiptDAO.delete(receipt);
                }
            }
            ++n2;
        }
    }

    @Override
    public Long receiptByCashAndPartialPayment(Long[] normalFeesItem, Long[] flatDiscountFeesItems, Double[] flatDiscountFeesItemAmount, Double[] partialFeesItemAmounts, Double fineAmount, Double totalAmountPaid, PaymentMode paymentMode, Date receivedDate, boolean isdiscountApplied, String discountType, Double discountPercentage, String narration, String createdBy, String modifiedBy) throws ReceiptException {
        int i;
        int i2;
        PaymentStatus paymentStatus = this.paymentStatusDAO.getPaymentStatusById(1L);
        StudentInvoice studentInvoice = null;
        if (normalFeesItem != null) {
            i2 = 0;
            while (i2 < normalFeesItem.length) {
                if (i2 == 0) {
                    studentInvoice = this.studentInvoiceDAO.getStudentInvoiceById(this.studentInvoiceDetailDAO.getStudentInvoiceDetailById(normalFeesItem[i2]).getStudentInvoice().getStudentInvoiceId());
                }
                ++i2;
            }
        } else {
            i2 = 0;
            while (i2 < flatDiscountFeesItems.length) {
                if (i2 == 0) {
                    studentInvoice = this.studentInvoiceDAO.getStudentInvoiceById(this.studentInvoiceDetailDAO.getStudentInvoiceDetailById(flatDiscountFeesItems[i2]).getStudentInvoice().getStudentInvoiceId());
                }
                ++i2;
            }
        }
        Long persistedReceiptNo = null;
        StudentFeeRefundReceipt receipt = new StudentFeeRefundReceipt(studentInvoice.getInstitution(), studentInvoice.getAcademicYear(), paymentMode, receivedDate, Double.valueOf(Math.round(totalAmountPaid)), studentInvoice.getStudent(), paymentStatus, narration, createdBy, modifiedBy, studentInvoice);
        if (!isdiscountApplied) {
            i = 0;
            while (i < normalFeesItem.length) {
                Long invoiceDetailId = normalFeesItem[i];
                Double partialAmount = partialFeesItemAmounts[i];
                StudentInvoiceDetail studentInvoiceDetail = this.studentInvoiceDetailDAO.getStudentInvoiceDetailById(invoiceDetailId);
                StudentFeeRefundReceiptDetail studentFeeRefundReceiptdetail = new StudentFeeRefundReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), false, null, null, 0.0, Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), Double.valueOf(Math.round(partialAmount)), receivedDate, paymentStatus, createdBy, modifiedBy);
                receipt.getStudentFeeRefundReceiptDetails().add(studentFeeRefundReceiptdetail);
                ++i;
            }
        } else {
            if (discountType.equals("percentage")) {
                i = 0;
                while (i < normalFeesItem.length) {
                    Long invoiceDetailId = normalFeesItem[i];
                    Double partialAmount = partialFeesItemAmounts[i];
                    StudentInvoiceDetail studentInvoiceDetail = this.studentInvoiceDetailDAO.getStudentInvoiceDetailById(invoiceDetailId);
                    StudentFeeRefundReceiptDetail studentFeeRefundReceiptdetail = new StudentFeeRefundReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), true, discountType, discountPercentage.toString(), Double.valueOf(Math.round(0.0)), Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), Double.valueOf(Math.round(partialAmount)), receivedDate, paymentStatus, createdBy, modifiedBy);
                    receipt.getStudentFeeRefundReceiptDetails().add(studentFeeRefundReceiptdetail);
                    ++i;
                }
            } else if (discountType.equals("flat")) {
                StudentInvoiceDetail studentInvoiceDetail;
                Double partialAmount;
                Long invoiceDetailId;
                if (normalFeesItem != null) {
                    i = 0;
                    while (i < normalFeesItem.length) {
                        invoiceDetailId = normalFeesItem[i];
                        partialAmount = partialFeesItemAmounts[i];
                        studentInvoiceDetail = this.studentInvoiceDetailDAO.getStudentInvoiceDetailById(invoiceDetailId);
                        StudentFeeRefundReceiptDetail studentFeeRefundReceiptdetail = new StudentFeeRefundReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), false, null, null, 0.0, Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), Double.valueOf(Math.round(partialAmount)), receivedDate, paymentStatus, createdBy, modifiedBy);
                        receipt.getStudentFeeRefundReceiptDetails().add(studentFeeRefundReceiptdetail);
                        ++i;
                    }
                }
                i = 0;
                while (i < flatDiscountFeesItems.length) {
                    invoiceDetailId = flatDiscountFeesItems[i];
                    partialAmount = partialFeesItemAmounts[i];
                    studentInvoiceDetail = this.studentInvoiceDetailDAO.getStudentInvoiceDetailById(invoiceDetailId);
                    Double discountAmount = flatDiscountFeesItemAmount[i];
                    Long roundDiscountAmount = Math.round(discountAmount);
                    discountAmount = (double)roundDiscountAmount;
                    Double actualAmount = studentInvoiceDetail.getStudentInvoiceElementTotalAmount();
                    StudentFeeRefundReceiptDetail studentFeeRefundReceiptdetail = new StudentFeeRefundReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), true, discountType, null, Double.valueOf(Math.round(discountAmount)), Double.valueOf(Math.round(actualAmount)), Double.valueOf(Math.round(partialAmount)), receivedDate, paymentStatus, createdBy, modifiedBy);
                    receipt.getStudentFeeRefundReceiptDetails().add(studentFeeRefundReceiptdetail);
                    ++i;
                }
            }
            studentInvoice.setDiscountApplicable(false);
        }
        StudentFeeRefundReceipt persistedReceipt = this.studentFeeRefundReceiptDAO.save(receipt);
        if (this.checkForInvoiceClosing(studentInvoice)) {
            studentInvoice.setInvoiceStatus(0);
        }
        persistedReceiptNo = persistedReceipt.getStudentFeeRefundReceiptId();
        return persistedReceiptNo;
    }

    @Override
    public Long receiptByChequeAndPartialPayment(Long[] normalFeesItem, Long[] flatDiscountFeesItems, Double[] flatDiscountFeesItemsAmount, Double[] partialFeesItemAmounts, Double fineAmount, Double totalAmountPaid, PaymentMode paymentMode, Date chequeReceivedDate, String chequeNo, Date chequeDate, String chequeBankName, String chequeBranchName, boolean isdiscountApplied, String discountType, Double discountPercentage, String narration, String createdBy, String modifiedBy) throws ReceiptException {
        try {
            int i;
            int i2;
            PaymentStatus paymentStatus = this.paymentStatusDAO.getPaymentStatusById(1L);
            StudentInvoice studentInvoice = null;
            if (normalFeesItem != null) {
                i2 = 0;
                while (i2 < normalFeesItem.length) {
                    if (i2 == 0) {
                        studentInvoice = this.studentInvoiceDAO.getStudentInvoiceById(this.studentInvoiceDetailDAO.getStudentInvoiceDetailById(normalFeesItem[i2]).getStudentInvoice().getStudentInvoiceId());
                    }
                    ++i2;
                }
            } else {
                i2 = 0;
                while (i2 < flatDiscountFeesItems.length) {
                    if (i2 == 0) {
                        studentInvoice = this.studentInvoiceDAO.getStudentInvoiceById(this.studentInvoiceDetailDAO.getStudentInvoiceDetailById(flatDiscountFeesItems[i2]).getStudentInvoice().getStudentInvoiceId());
                    }
                    ++i2;
                }
            }
            Long persistedReceiptNo = null;
            StudentFeeRefundReceipt receipt = new StudentFeeRefundReceipt(studentInvoice.getInstitution(), studentInvoice.getAcademicYear(), paymentMode, chequeReceivedDate, Double.valueOf(Math.round(totalAmountPaid)), studentInvoice.getStudent(), paymentStatus, chequeNo, chequeDate, chequeBankName, chequeBranchName, narration, createdBy, modifiedBy, studentInvoice);
            if (!isdiscountApplied) {
                i = 0;
                while (i < normalFeesItem.length) {
                    Long invoiceDetailId = normalFeesItem[i];
                    Double partialAmount = partialFeesItemAmounts[i];
                    StudentInvoiceDetail studentInvoiceDetail = this.studentInvoiceDetailDAO.getStudentInvoiceDetailById(invoiceDetailId);
                    StudentFeeRefundReceiptDetail studentFeeRefundReceiptdetail = new StudentFeeRefundReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), false, null, null, 0.0, Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), Double.valueOf(Math.round(partialAmount)), chequeReceivedDate, paymentStatus, createdBy, modifiedBy);
                    receipt.getStudentFeeRefundReceiptDetails().add(studentFeeRefundReceiptdetail);
                    ++i;
                }
            } else {
                if (discountType.equals("percentage")) {
                    i = 0;
                    while (i < normalFeesItem.length) {
                        Long invoiceDetailId = normalFeesItem[i];
                        StudentInvoiceDetail studentInvoiceDetail = this.studentInvoiceDetailDAO.getStudentInvoiceDetailById(invoiceDetailId);
                        Double partialAmount = partialFeesItemAmounts[i];
                        Double discountAmount = this.calculatePercentageDiscountAmount(invoiceDetailId, discountPercentage);
                        Long roundDiscountAmount = Math.round(discountAmount);
                        discountAmount = (double)roundDiscountAmount;
                        Double actualAmount = studentInvoiceDetail.getStudentInvoiceElementTotalAmount();
                        StudentFeeRefundReceiptDetail studentFeeRefundReceiptdetail = new StudentFeeRefundReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), true, discountType, discountPercentage.toString(), Double.valueOf(Math.round(discountAmount)), Double.valueOf(Math.round(actualAmount)), Double.valueOf(Math.round(partialAmount)), chequeReceivedDate, paymentStatus, createdBy, modifiedBy);
                        receipt.getStudentFeeRefundReceiptDetails().add(studentFeeRefundReceiptdetail);
                        ++i;
                    }
                } else if (discountType.equals("flat")) {
                    Long invoiceDetailId;
                    if (normalFeesItem != null) {
                        i = 0;
                        while (i < normalFeesItem.length) {
                            invoiceDetailId = normalFeesItem[i];
                            Double partialAmount = partialFeesItemAmounts[i];
                            StudentInvoiceDetail studentInvoiceDetail = this.studentInvoiceDetailDAO.getStudentInvoiceDetailById(invoiceDetailId);
                            StudentFeeRefundReceiptDetail studentFeeRefundReceiptdetail = new StudentFeeRefundReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), false, null, null, 0.0, Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), Double.valueOf(Math.round(partialAmount)), chequeReceivedDate, paymentStatus, createdBy, modifiedBy);
                            receipt.getStudentFeeRefundReceiptDetails().add(studentFeeRefundReceiptdetail);
                            ++i;
                        }
                    }
                    i = 0;
                    while (i < flatDiscountFeesItems.length) {
                        invoiceDetailId = flatDiscountFeesItems[i];
                        Double discountAmount = flatDiscountFeesItemsAmount[i];
                        Long roundDiscountAmount = Math.round(discountAmount);
                        discountAmount = (double)roundDiscountAmount;
                        Double partialAmount = partialFeesItemAmounts[i];
                        StudentInvoiceDetail studentInvoiceDetail = this.studentInvoiceDetailDAO.getStudentInvoiceDetailById(invoiceDetailId);
                        Double actualAmount = studentInvoiceDetail.getStudentInvoiceElementTotalAmount();
                        StudentFeeRefundReceiptDetail studentFeeRefundReceiptdetail = new StudentFeeRefundReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), true, discountType, null, Double.valueOf(Math.round(discountAmount)), Double.valueOf(Math.round(actualAmount)), Double.valueOf(Math.round(partialAmount)), chequeReceivedDate, paymentStatus, createdBy, modifiedBy);
                        receipt.getStudentFeeRefundReceiptDetails().add(studentFeeRefundReceiptdetail);
                        ++i;
                    }
                }
                studentInvoice.setDiscountApplicable(false);
            }
            StudentFeeRefundReceipt persistedReceipt = this.studentFeeRefundReceiptDAO.save(receipt);
            persistedReceiptNo = persistedReceipt.getStudentFeeRefundReceiptId();
            return persistedReceiptNo;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Long receiptByDDAndPartialPayment(Long[] normalFeesItem, Long[] flatDiscountFeesItems, Double[] flatDiscountFeesItemsAmount, Double[] partialFeesItemAmounts, Double fineAmount, Double totalAmountPaid, PaymentMode paymentMode, Date ddReceivedDate, String ddNo, Date ddDate, String ddBankName, String ddBranchName, boolean isdiscountApplied, String discountType, Double discountPercentage, String narration, String createdBy, String modifiedBy) throws ReceiptException {
        try {
            int i;
            int i2;
            PaymentStatus paymentStatus = this.paymentStatusDAO.getPaymentStatusById(1L);
            StudentInvoice studentInvoice = null;
            if (normalFeesItem != null) {
                i2 = 0;
                while (i2 < normalFeesItem.length) {
                    if (i2 == 0) {
                        studentInvoice = this.studentInvoiceDAO.getStudentInvoiceById(this.studentInvoiceDetailDAO.getStudentInvoiceDetailById(normalFeesItem[i2]).getStudentInvoice().getStudentInvoiceId());
                    }
                    ++i2;
                }
            } else {
                i2 = 0;
                while (i2 < flatDiscountFeesItems.length) {
                    if (i2 == 0) {
                        studentInvoice = this.studentInvoiceDAO.getStudentInvoiceById(this.studentInvoiceDetailDAO.getStudentInvoiceDetailById(flatDiscountFeesItems[i2]).getStudentInvoice().getStudentInvoiceId());
                    }
                    ++i2;
                }
            }
            Long persistedReceiptNo = null;
            StudentFeeRefundReceipt receipt = new StudentFeeRefundReceipt(studentInvoice.getInstitution(), studentInvoice.getAcademicYear(), paymentMode, Double.valueOf(Math.round(totalAmountPaid)), studentInvoice.getStudent(), paymentStatus, ddNo, ddDate, ddBankName, ddBranchName, ddReceivedDate, narration, createdBy, modifiedBy, studentInvoice);
            if (!isdiscountApplied) {
                i = 0;
                while (i < normalFeesItem.length) {
                    Double partialAmount = partialFeesItemAmounts[i];
                    Long invoiceDetailId = normalFeesItem[i];
                    StudentInvoiceDetail studentInvoiceDetail = this.studentInvoiceDetailDAO.getStudentInvoiceDetailById(invoiceDetailId);
                    StudentFeeRefundReceiptDetail studentFeeRefundReceiptdetail = new StudentFeeRefundReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), false, null, null, 0.0, Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), Double.valueOf(Math.round(partialAmount)), ddReceivedDate, paymentStatus, createdBy, modifiedBy);
                    receipt.getStudentFeeRefundReceiptDetails().add(studentFeeRefundReceiptdetail);
                    ++i;
                }
            } else {
                if (discountType.equals("percentage")) {
                    i = 0;
                    while (i < normalFeesItem.length) {
                        Long invoiceDetailId = normalFeesItem[i];
                        Double partialAmount = partialFeesItemAmounts[i];
                        StudentInvoiceDetail studentInvoiceDetail = this.studentInvoiceDetailDAO.getStudentInvoiceDetailById(invoiceDetailId);
                        Double actualAmount = studentInvoiceDetail.getStudentInvoiceElementTotalAmount();
                        Double discountAmount = this.calculatePercentageDiscountAmount(invoiceDetailId, discountPercentage);
                        Long roundDiscountAmount = Math.round(discountAmount);
                        discountAmount = (double)roundDiscountAmount;
                        StudentFeeRefundReceiptDetail studentFeeRefundReceiptdetail = new StudentFeeRefundReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), true, discountType, discountPercentage.toString(), Double.valueOf(Math.round(discountAmount)), Double.valueOf(Math.round(actualAmount)), Double.valueOf(Math.round(partialAmount)), ddReceivedDate, paymentStatus, createdBy, modifiedBy);
                        receipt.getStudentFeeRefundReceiptDetails().add(studentFeeRefundReceiptdetail);
                        ++i;
                    }
                } else if (discountType.equals("flat")) {
                    StudentInvoiceDetail studentInvoiceDetail;
                    Double partialAmount;
                    Long invoiceDetailId;
                    if (normalFeesItem != null) {
                        i = 0;
                        while (i < normalFeesItem.length) {
                            invoiceDetailId = normalFeesItem[i];
                            partialAmount = partialFeesItemAmounts[i];
                            studentInvoiceDetail = this.studentInvoiceDetailDAO.getStudentInvoiceDetailById(invoiceDetailId);
                            StudentFeeRefundReceiptDetail studentFeeRefundReceiptdetail = new StudentFeeRefundReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), false, null, null, 0.0, Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), Double.valueOf(Math.round(partialAmount)), ddReceivedDate, paymentStatus, createdBy, modifiedBy);
                            receipt.getStudentFeeRefundReceiptDetails().add(studentFeeRefundReceiptdetail);
                            ++i;
                        }
                    }
                    i = 0;
                    while (i < flatDiscountFeesItems.length) {
                        invoiceDetailId = flatDiscountFeesItems[i];
                        partialAmount = partialFeesItemAmounts[i];
                        studentInvoiceDetail = this.studentInvoiceDetailDAO.getStudentInvoiceDetailById(invoiceDetailId);
                        Double discountAmount = flatDiscountFeesItemsAmount[i];
                        Long roundDiscountAmount = Math.round(discountAmount);
                        discountAmount = (double)roundDiscountAmount;
                        Double actualAmount = studentInvoiceDetail.getStudentInvoiceElementTotalAmount();
                        StudentFeeRefundReceiptDetail studentFeeRefundReceiptdetail = new StudentFeeRefundReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), true, discountType, null, Double.valueOf(Math.round(discountAmount)), Double.valueOf(Math.round(actualAmount)), Double.valueOf(Math.round(partialAmount)), ddReceivedDate, paymentStatus, createdBy, modifiedBy);
                        receipt.getStudentFeeRefundReceiptDetails().add(studentFeeRefundReceiptdetail);
                        ++i;
                    }
                }
                studentInvoice.setDiscountApplicable(false);
            }
            StudentFeeRefundReceipt persistedReceipt = this.studentFeeRefundReceiptDAO.save(receipt);
            persistedReceiptNo = persistedReceipt.getStudentFeeRefundReceiptId();
            return persistedReceiptNo;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public StudentFeeRefundReceipt receiptById(Long receiptId) throws Exception {
        try {
            StudentFeeRefundReceipt studentFeeRefundReceipt = this.studentFeeRefundReceiptDAO.getStudentFeeRefundReceiptById(receiptId);
            Hibernate.initialize((Object)studentFeeRefundReceipt);
            Hibernate.initialize((Object)studentFeeRefundReceipt.getStudent());
            return studentFeeRefundReceipt;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Long fineamountautomaticcalculation(Long invoiceId) throws ParseException, Exception {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Double totalAmount = 0.0;
            StudentInvoice studentInvoice = this.studentInvoiceDAO.getStudentInvoiceById(invoiceId);
            Hibernate.initialize((Object)studentInvoice.getFeesPenaltySetting());
            FeesPenaltySetting feesPenaltySetting = studentInvoice.getFeesPenaltySetting();
            Date today = dateFormat.parse(dateFormat.format(new Date()));
            Date invoiceLastDueDay = dateFormat.parse(dateFormat.format(studentInvoice.getLastDateForPayment()));
            if (today.compareTo(invoiceLastDueDay) > 0) {
                long diff = today.getTime() - studentInvoice.getLastDateForPayment().getTime();
                diff /= 86400000L;
                if (feesPenaltySetting.getFeesPenaltySettingType().equals("fees")) {
                    if (feesPenaltySetting.getPenaltyCategory().equals("perday")) {
                        if (feesPenaltySetting.getPenaltyType().equals("percentage")) {
                            totalAmount = totalAmount + (double)diff * studentInvoice.getInvoiceAmount() * (feesPenaltySetting.getPercentage() / 100.0);
                        } else if (feesPenaltySetting.getPenaltyType().equals("amount")) {
                            totalAmount = totalAmount + (double)diff * feesPenaltySetting.getAmount();
                        }
                    } else if (feesPenaltySetting.getPenaltyCategory().equals("annual")) {
                        if (feesPenaltySetting.getPenaltyType().equals("percentage")) {
                            Year year = Year.of(invoiceLastDueDay.getYear());
                            int countDaysInYear = year.length();
                            boolean isLeapYear = year.isLeap();
                            if (isLeapYear) {
                                ++countDaysInYear;
                            }
                            totalAmount = totalAmount + (double)diff * (studentInvoice.getInvoiceAmount() * (feesPenaltySetting.getPercentage() / 100.0)) / (double)countDaysInYear;
                        } else if (feesPenaltySetting.getPenaltyType().equals("amount")) {
                            Year year = Year.of(invoiceLastDueDay.getYear());
                            int countDaysInYear = year.length();
                            boolean isLeapYear = year.isLeap();
                            if (isLeapYear) {
                                ++countDaysInYear;
                            }
                            totalAmount = totalAmount + (double)diff * (feesPenaltySetting.getAmount() / (double)countDaysInYear);
                        }
                    }
                } else if (feesPenaltySetting.getFeesPenaltySettingType().equals("inventory")) {
                    if (feesPenaltySetting.getPenaltyCategory().equals("perday")) {
                        if (feesPenaltySetting.getPenaltyType().equals("percentage")) {
                            totalAmount = totalAmount + (double)diff * studentInvoice.getInvoiceAmount() * (feesPenaltySetting.getPercentage() / 100.0);
                        } else if (feesPenaltySetting.getPenaltyType().equals("amount")) {
                            totalAmount = totalAmount + (double)diff * feesPenaltySetting.getAmount();
                        }
                    } else if (feesPenaltySetting.getPenaltyCategory().equals("annual")) {
                        if (feesPenaltySetting.getPenaltyType().equals("percentage")) {
                            Year year = Year.of(invoiceLastDueDay.getYear());
                            int countDaysInYear = year.length();
                            boolean isLeapYear = year.isLeap();
                            if (isLeapYear) {
                                ++countDaysInYear;
                            }
                            totalAmount = totalAmount + (double)diff * (studentInvoice.getInvoiceAmount() * (feesPenaltySetting.getPercentage() / 100.0)) / (double)countDaysInYear;
                        } else if (feesPenaltySetting.getPenaltyType().equals("amount")) {
                            Year year = Year.of(invoiceLastDueDay.getYear());
                            int countDaysInYear = year.length();
                            boolean isLeapYear = year.isLeap();
                            if (isLeapYear) {
                                ++countDaysInYear;
                            }
                            totalAmount = totalAmount + (double)diff * (feesPenaltySetting.getAmount() / (double)countDaysInYear);
                        }
                    }
                } else if (feesPenaltySetting.getFeesPenaltySettingType().equals("library")) {
                    if (feesPenaltySetting.getPenaltyCategory().equals("perday")) {
                        if (feesPenaltySetting.getPenaltyType().equals("percentage")) {
                            totalAmount = totalAmount + (double)diff * studentInvoice.getInvoiceAmount() * (feesPenaltySetting.getPercentage() / 100.0);
                        } else if (feesPenaltySetting.getPenaltyType().equals("amount")) {
                            totalAmount = totalAmount + (double)diff * feesPenaltySetting.getAmount();
                        }
                    } else if (feesPenaltySetting.getPenaltyCategory().equals("annual")) {
                        if (feesPenaltySetting.getPenaltyType().equals("percentage")) {
                            Year year = Year.of(invoiceLastDueDay.getYear());
                            int countDaysInYear = year.length();
                            boolean isLeapYear = year.isLeap();
                            if (isLeapYear) {
                                ++countDaysInYear;
                            }
                            totalAmount = totalAmount + (double)diff * (studentInvoice.getInvoiceAmount() * (feesPenaltySetting.getPercentage() / 100.0)) / (double)countDaysInYear;
                        } else if (feesPenaltySetting.getPenaltyType().equals("amount")) {
                            Year year = Year.of(invoiceLastDueDay.getYear());
                            int countDaysInYear = year.length();
                            boolean isLeapYear = year.isLeap();
                            if (isLeapYear) {
                                ++countDaysInYear;
                            }
                            totalAmount = totalAmount + (double)diff * (feesPenaltySetting.getAmount() / (double)countDaysInYear);
                        }
                    }
                } else if (feesPenaltySetting.getFeesPenaltySettingType().equals("transport")) {
                    if (feesPenaltySetting.getPenaltyCategory().equals("perday")) {
                        if (feesPenaltySetting.getPenaltyType().equals("percentage")) {
                            totalAmount = totalAmount + (double)diff * studentInvoice.getInvoiceAmount() * (feesPenaltySetting.getPercentage() / 100.0);
                        } else if (feesPenaltySetting.getPenaltyType().equals("amount")) {
                            totalAmount = totalAmount + (double)diff * feesPenaltySetting.getAmount();
                        }
                    } else if (feesPenaltySetting.getPenaltyCategory().equals("annual")) {
                        if (feesPenaltySetting.getPenaltyType().equals("percentage")) {
                            Year year = Year.of(invoiceLastDueDay.getYear());
                            int countDaysInYear = year.length();
                            boolean isLeapYear = year.isLeap();
                            if (isLeapYear) {
                                ++countDaysInYear;
                            }
                            totalAmount = totalAmount + (double)diff * (studentInvoice.getInvoiceAmount() * (feesPenaltySetting.getPercentage() / 100.0)) / (double)countDaysInYear;
                        } else if (feesPenaltySetting.getPenaltyType().equals("amount")) {
                            Year year = Year.of(invoiceLastDueDay.getYear());
                            int countDaysInYear = year.length();
                            boolean isLeapYear = year.isLeap();
                            if (isLeapYear) {
                                ++countDaysInYear;
                            }
                            totalAmount = totalAmount + (double)diff * (feesPenaltySetting.getAmount() / (double)countDaysInYear);
                        }
                    }
                } else if (feesPenaltySetting.getFeesPenaltySettingType().equals("hostel")) {
                    if (feesPenaltySetting.getPenaltyCategory().equals("perday")) {
                        if (feesPenaltySetting.getPenaltyType().equals("percentage")) {
                            totalAmount = totalAmount + (double)diff * studentInvoice.getInvoiceAmount() * (feesPenaltySetting.getPercentage() / 100.0);
                        } else if (feesPenaltySetting.getPenaltyType().equals("amount")) {
                            totalAmount = totalAmount + (double)diff * feesPenaltySetting.getAmount();
                        }
                    } else if (feesPenaltySetting.getPenaltyCategory().equals("annual")) {
                        if (feesPenaltySetting.getPenaltyType().equals("percentage")) {
                            Year year = Year.of(invoiceLastDueDay.getYear());
                            int countDaysInYear = year.length();
                            boolean isLeapYear = year.isLeap();
                            if (isLeapYear) {
                                ++countDaysInYear;
                            }
                            totalAmount = totalAmount + (double)diff * (studentInvoice.getInvoiceAmount() * (feesPenaltySetting.getPercentage() / 100.0)) / (double)countDaysInYear;
                        } else if (feesPenaltySetting.getPenaltyType().equals("amount")) {
                            Year year = Year.of(invoiceLastDueDay.getYear());
                            int countDaysInYear = year.length();
                            boolean isLeapYear = year.isLeap();
                            if (isLeapYear) {
                                ++countDaysInYear;
                            }
                            totalAmount = totalAmount + (double)diff * (feesPenaltySetting.getAmount() / (double)countDaysInYear);
                        }
                    }
                }
            }
            return Math.round(totalAmount);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
