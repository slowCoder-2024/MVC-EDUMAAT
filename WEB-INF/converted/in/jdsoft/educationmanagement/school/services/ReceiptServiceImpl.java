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
import in.jdsoft.educationmanagement.school.dao.StudentInvoiceDAO;
import in.jdsoft.educationmanagement.school.dao.StudentInvoiceDetailDAO;
import in.jdsoft.educationmanagement.school.dao.StudentPartialPaymentReceiptDetailDAO;
import in.jdsoft.educationmanagement.school.dao.StudentReceiptDAO;
import in.jdsoft.educationmanagement.school.dao.StudentReceiptDetailDAO;
import in.jdsoft.educationmanagement.school.exceptions.ReceiptException;
import in.jdsoft.educationmanagement.school.exceptions.StudentReceiptException;
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
import in.jdsoft.educationmanagement.school.model.StudentInvoice;
import in.jdsoft.educationmanagement.school.model.StudentInvoiceDetail;
import in.jdsoft.educationmanagement.school.model.StudentPartialPaymentReceiptDetail;
import in.jdsoft.educationmanagement.school.model.StudentReceipt;
import in.jdsoft.educationmanagement.school.model.StudentReceiptDetail;
import in.jdsoft.educationmanagement.school.model.StudentReceiptFine;
import in.jdsoft.educationmanagement.school.reports.model.SixFieldReports;
import in.jdsoft.educationmanagement.school.services.ReceiptService;
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

@Service(value="receiptService")
public class ReceiptServiceImpl
implements ReceiptService {
    @Autowired
    StudentReceiptDAO studentReceiptDAO;
    @Autowired
    StudentReceiptDetailDAO studentReceiptDetailDAO;
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
            StudentReceipt receipt = new StudentReceipt(studentInvoice.getInstitution(), studentInvoice.getAcademicYear(), paymentMode, receivedDate, Double.valueOf(Math.round(totalAmountPaid)), studentInvoice.getStudent(), paymentStatus, narration, createdBy, modifiedBy, studentInvoice);
            if (!isdiscountApplied) {
                i = 0;
                while (i < normalFeesItem.length) {
                    Long invoiceDetailId = normalFeesItem[i];
                    StudentInvoiceDetail studentInvoiceDetail = this.studentInvoiceDetailDAO.getStudentInvoiceDetailById(invoiceDetailId);
                    if (this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail) == null) {
                        StudentReceiptDetail studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), false, null, null, 0.0, Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), receivedDate, paymentStatus, createdBy, modifiedBy);
                        receipt.getReceiptDetails().add(studentReceiptdetail);
                        studentInvoiceDetail.setStudentInvoiceElementPaymentStatus(0);
                        this.studentInvoiceDetailDAO.update(studentInvoiceDetail);
                    } else {
                        StudentPartialPaymentReceiptDetail studentPartialPaymentReceiptDetail = this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail);
                        Double alreadyPaidTotalAmount = studentPartialPaymentReceiptDetail.getPaidReceiptAmount() + studentPartialPaymentReceiptDetail.getDiscountAmount();
                        Double balanceAmount = studentInvoiceDetail.getStudentInvoiceElementTotalAmount() - alreadyPaidTotalAmount;
                        StudentReceiptDetail studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), false, null, null, 0.0, Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), Double.valueOf(Math.round(balanceAmount)), receivedDate, paymentStatus, createdBy, modifiedBy);
                        studentPartialPaymentReceiptDetail.setPaidReceiptAmount(studentInvoiceDetail.getStudentInvoiceElementTotalAmount());
                        studentPartialPaymentReceiptDetail.setModifiedBy(modifiedBy);
                        receipt.getReceiptDetails().add(studentReceiptdetail);
                        studentInvoiceDetail.setStudentInvoiceElementPaymentStatus(0);
                        this.studentInvoiceDetailDAO.update(studentInvoiceDetail);
                        this.studentPartialPaymentReceiptDetailDAO.update(studentPartialPaymentReceiptDetail);
                    }
                    ++i;
                }
            } else {
                if (discountType.equals("percentage")) {
                    i = 0;
                    while (i < normalFeesItem.length) {
                        Long invoiceDetailId = normalFeesItem[i];
                        StudentInvoiceDetail studentInvoiceDetail = this.studentInvoiceDetailDAO.getStudentInvoiceDetailById(invoiceDetailId);
                        if (this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail) == null) {
                            Double actualAmount = studentInvoiceDetail.getStudentInvoiceElementTotalAmount();
                            Double discountAmount = this.calculatePercentageDiscountAmount(invoiceDetailId, discountPercentage);
                            Long roundDiscountAmount = Math.round(discountAmount);
                            discountAmount = (double)roundDiscountAmount;
                            Double paidAmount = actualAmount - discountAmount;
                            StudentReceiptDetail studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), true, discountType, discountPercentage.toString(), Double.valueOf(Math.round(discountAmount)), Double.valueOf(Math.round(actualAmount)), Double.valueOf(Math.round(paidAmount)), receivedDate, paymentStatus, createdBy, modifiedBy);
                            receipt.getReceiptDetails().add(studentReceiptdetail);
                            studentInvoiceDetail.setStudentInvoiceElementPaymentStatus(0);
                            this.studentInvoiceDetailDAO.update(studentInvoiceDetail);
                        } else {
                            StudentPartialPaymentReceiptDetail studentPartialPaymentReceiptDetail = this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail);
                            Double alreadyPaidTotalAmount = studentPartialPaymentReceiptDetail.getPaidReceiptAmount() + studentPartialPaymentReceiptDetail.getDiscountAmount();
                            Double balanceAmount = studentInvoiceDetail.getStudentInvoiceElementTotalAmount() - alreadyPaidTotalAmount;
                            Double discountAmount = this.calculatePercentageDiscountAmount(invoiceDetailId, discountPercentage);
                            Long roundDiscountAmount = Math.round(discountAmount);
                            discountAmount = (double)roundDiscountAmount;
                            Double paidAmount = balanceAmount - discountAmount;
                            if (studentInvoiceDetail.getStudentInvoiceElementTotalAmount() - (paidAmount + discountAmount + alreadyPaidTotalAmount) < 0.0) {
                                throw new ReceiptException(new Message("failure", "Please Enter Valid Percentage..!"));
                            }
                            StudentReceiptDetail studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), true, discountType, discountPercentage.toString(), Double.valueOf(Math.round(discountAmount)), Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), Double.valueOf(Math.round(paidAmount)), receivedDate, paymentStatus, createdBy, modifiedBy);
                            studentPartialPaymentReceiptDetail.setPaidReceiptAmount(studentInvoiceDetail.getStudentInvoiceElementTotalAmount());
                            studentPartialPaymentReceiptDetail.setDiscountAmount(discountAmount + studentPartialPaymentReceiptDetail.getDiscountAmount());
                            studentPartialPaymentReceiptDetail.setModifiedBy(modifiedBy);
                            receipt.getReceiptDetails().add(studentReceiptdetail);
                            studentInvoiceDetail.setStudentInvoiceElementPaymentStatus(0);
                            this.studentInvoiceDetailDAO.update(studentInvoiceDetail);
                            this.studentPartialPaymentReceiptDetailDAO.update(studentPartialPaymentReceiptDetail);
                        }
                        ++i;
                    }
                } else if (discountType.equals("flat")) {
                    Double balanceAmount;
                    Double alreadyPaidTotalAmount;
                    StudentPartialPaymentReceiptDetail studentPartialPaymentReceiptDetail;
                    StudentInvoiceDetail studentInvoiceDetail;
                    Long invoiceDetailId;
                    if (normalFeesItem != null) {
                        i = 0;
                        while (i < normalFeesItem.length) {
                            invoiceDetailId = normalFeesItem[i];
                            studentInvoiceDetail = this.studentInvoiceDetailDAO.getStudentInvoiceDetailById(invoiceDetailId);
                            if (this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail) == null) {
                                StudentReceiptDetail studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), false, null, null, 0.0, Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), receivedDate, paymentStatus, createdBy, modifiedBy);
                                receipt.getReceiptDetails().add(studentReceiptdetail);
                                studentInvoiceDetail.setStudentInvoiceElementPaymentStatus(0);
                                this.studentInvoiceDetailDAO.update(studentInvoiceDetail);
                            } else {
                                studentPartialPaymentReceiptDetail = this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail);
                                alreadyPaidTotalAmount = studentPartialPaymentReceiptDetail.getPaidReceiptAmount() + studentPartialPaymentReceiptDetail.getDiscountAmount();
                                balanceAmount = studentInvoiceDetail.getStudentInvoiceElementTotalAmount() - alreadyPaidTotalAmount;
                                StudentReceiptDetail studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), false, null, null, 0.0, Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), Double.valueOf(Math.round(balanceAmount)), receivedDate, paymentStatus, createdBy, modifiedBy);
                                studentPartialPaymentReceiptDetail.setPaidReceiptAmount(studentInvoiceDetail.getStudentInvoiceElementTotalAmount());
                                studentPartialPaymentReceiptDetail.setModifiedBy(modifiedBy);
                                receipt.getReceiptDetails().add(studentReceiptdetail);
                                studentInvoiceDetail.setStudentInvoiceElementPaymentStatus(0);
                                this.studentInvoiceDetailDAO.update(studentInvoiceDetail);
                                this.studentPartialPaymentReceiptDetailDAO.update(studentPartialPaymentReceiptDetail);
                            }
                            ++i;
                        }
                    }
                    i = 0;
                    while (i < flatDiscountFeesItems.length) {
                        invoiceDetailId = flatDiscountFeesItems[i];
                        studentInvoiceDetail = this.studentInvoiceDetailDAO.getStudentInvoiceDetailById(invoiceDetailId);
                        if (this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail) == null) {
                            Double actualAmount = studentInvoiceDetail.getStudentInvoiceElementTotalAmount();
                            Double discountAmount = flatDiscountFeesItemAmount[i];
                            Long roundDiscountAmount = Math.round(discountAmount);
                            discountAmount = (double)roundDiscountAmount;
                            Double paidAmount = actualAmount - discountAmount;
                            StudentReceiptDetail studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), true, discountType, null, Double.valueOf(Math.round(discountAmount)), Double.valueOf(Math.round(actualAmount)), Double.valueOf(Math.round(paidAmount)), receivedDate, paymentStatus, createdBy, modifiedBy);
                            receipt.getReceiptDetails().add(studentReceiptdetail);
                            studentInvoiceDetail.setStudentInvoiceElementPaymentStatus(0);
                            this.studentInvoiceDetailDAO.update(studentInvoiceDetail);
                        } else {
                            studentPartialPaymentReceiptDetail = this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail);
                            alreadyPaidTotalAmount = studentPartialPaymentReceiptDetail.getPaidReceiptAmount() + studentPartialPaymentReceiptDetail.getDiscountAmount();
                            balanceAmount = studentInvoiceDetail.getStudentInvoiceElementTotalAmount() - alreadyPaidTotalAmount;
                            Double discountAmount = flatDiscountFeesItemAmount[i];
                            Long roundDiscountAmount = Math.round(discountAmount);
                            discountAmount = (double)roundDiscountAmount;
                            Double paidAmount = balanceAmount - discountAmount;
                            StudentReceiptDetail studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), true, discountType, null, Double.valueOf(Math.round(discountAmount)), Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), Double.valueOf(Math.round(paidAmount)), receivedDate, paymentStatus, createdBy, modifiedBy);
                            studentPartialPaymentReceiptDetail.setPaidReceiptAmount(studentInvoiceDetail.getStudentInvoiceElementTotalAmount());
                            studentPartialPaymentReceiptDetail.setModifiedBy(modifiedBy);
                            studentPartialPaymentReceiptDetail.setDiscountAmount(discountAmount + studentPartialPaymentReceiptDetail.getDiscountAmount());
                            receipt.getReceiptDetails().add(studentReceiptdetail);
                            studentInvoiceDetail.setStudentInvoiceElementPaymentStatus(0);
                            this.studentInvoiceDetailDAO.update(studentInvoiceDetail);
                            this.studentPartialPaymentReceiptDetailDAO.update(studentPartialPaymentReceiptDetail);
                        }
                        ++i;
                    }
                }
                studentInvoice.setDiscountApplicable(false);
            }
            if (fineAmount > 0.0) {
                fineAmount = Math.round(fineAmount);
                receipt.getReceiptFines().add(new StudentReceiptFine(studentInvoice.getAcademicYear(), receipt, fineAmount, receivedDate, createdBy, modifiedBy));
            }
            StudentReceipt persistedReceipt = this.studentReceiptDAO.save(receipt);
            if (this.checkForInvoiceClosing(studentInvoice)) {
                studentInvoice.setInvoiceStatus(0);
                this.studentInvoiceDAO.update(studentInvoice);
            }
            persistedReceiptNo = persistedReceipt.getReceiptId();
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
            StudentReceipt receipt = new StudentReceipt(studentInvoice.getInstitution(), studentInvoice.getAcademicYear(), paymentMode, chequeReceivedDate, Double.valueOf(Math.round(totalAmountPaid)), studentInvoice.getStudent(), paymentStatus, chequeNo, chequeDate, chequeBankName, chequeBranchName, narration, createdBy, modifiedBy, studentInvoice);
            if (!isdiscountApplied) {
                i = 0;
                while (i < normalFeesItem.length) {
                    Long invoiceDetailId = normalFeesItem[i];
                    StudentInvoiceDetail studentInvoiceDetail = this.studentInvoiceDetailDAO.getStudentInvoiceDetailById(invoiceDetailId);
                    if (this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail) == null) {
                        StudentReceiptDetail studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), false, null, null, 0.0, Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), chequeReceivedDate, paymentStatus, createdBy, modifiedBy);
                        receipt.getReceiptDetails().add(studentReceiptdetail);
                        studentInvoiceDetail.setStudentInvoiceElementPaymentStatus(0);
                        this.studentInvoiceDetailDAO.update(studentInvoiceDetail);
                    } else {
                        StudentPartialPaymentReceiptDetail studentPartialPaymentReceiptDetail = this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail);
                        Double alreadyPaidTotalAmount = studentPartialPaymentReceiptDetail.getPaidReceiptAmount() + studentPartialPaymentReceiptDetail.getDiscountAmount();
                        Double balanceAmount = studentInvoiceDetail.getStudentInvoiceElementTotalAmount() - alreadyPaidTotalAmount;
                        StudentReceiptDetail studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), false, null, null, 0.0, Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), Double.valueOf(Math.round(balanceAmount)), chequeReceivedDate, paymentStatus, createdBy, modifiedBy);
                        studentPartialPaymentReceiptDetail.setPaidReceiptAmount(balanceAmount + studentPartialPaymentReceiptDetail.getPaidReceiptAmount());
                        studentPartialPaymentReceiptDetail.setModifiedBy(modifiedBy);
                        receipt.getReceiptDetails().add(studentReceiptdetail);
                        studentInvoiceDetail.setStudentInvoiceElementPaymentStatus(0);
                        this.studentInvoiceDetailDAO.update(studentInvoiceDetail);
                        this.studentPartialPaymentReceiptDetailDAO.update(studentPartialPaymentReceiptDetail);
                    }
                    ++i;
                }
            } else {
                if (discountType.equals("percentage")) {
                    i = 0;
                    while (i < normalFeesItem.length) {
                        Long invoiceDetailId = normalFeesItem[i];
                        StudentInvoiceDetail studentInvoiceDetail = this.studentInvoiceDetailDAO.getStudentInvoiceDetailById(invoiceDetailId);
                        if (this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail) == null) {
                            Double actualAmount = studentInvoiceDetail.getStudentInvoiceElementTotalAmount();
                            Double discountAmount = this.calculatePercentageDiscountAmount(invoiceDetailId, discountPercentage);
                            Long roundDiscountAmount = Math.round(discountAmount);
                            discountAmount = (double)roundDiscountAmount;
                            Double paidAmount = actualAmount - discountAmount;
                            StudentReceiptDetail studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), true, discountType, discountPercentage.toString(), Double.valueOf(Math.round(discountAmount)), Double.valueOf(Math.round(actualAmount)), Double.valueOf(Math.round(paidAmount)), chequeReceivedDate, paymentStatus, createdBy, modifiedBy);
                            receipt.getReceiptDetails().add(studentReceiptdetail);
                            studentInvoiceDetail.setStudentInvoiceElementPaymentStatus(0);
                            this.studentInvoiceDetailDAO.update(studentInvoiceDetail);
                        } else {
                            StudentPartialPaymentReceiptDetail studentPartialPaymentReceiptDetail = this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail);
                            Double alreadyPaidTotalAmount = studentPartialPaymentReceiptDetail.getPaidReceiptAmount() + studentPartialPaymentReceiptDetail.getDiscountAmount();
                            Double balanceAmount = studentInvoiceDetail.getStudentInvoiceElementTotalAmount() - alreadyPaidTotalAmount;
                            Double discountAmount = this.calculatePercentageDiscountAmount(invoiceDetailId, discountPercentage);
                            Long roundDiscountAmount = Math.round(discountAmount);
                            discountAmount = (double)roundDiscountAmount;
                            Double paidAmount = balanceAmount - discountAmount;
                            if (studentInvoiceDetail.getStudentInvoiceElementTotalAmount() - (paidAmount + discountAmount + alreadyPaidTotalAmount) < 0.0) {
                                throw new ReceiptException(new Message("failure", "Please Enter Valid Percentage..!"));
                            }
                            StudentReceiptDetail studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), true, discountType, discountPercentage.toString(), Double.valueOf(Math.round(discountAmount)), Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), Double.valueOf(Math.round(paidAmount)), chequeReceivedDate, paymentStatus, createdBy, modifiedBy);
                            studentPartialPaymentReceiptDetail.setPaidReceiptAmount(balanceAmount + studentPartialPaymentReceiptDetail.getPaidReceiptAmount());
                            studentPartialPaymentReceiptDetail.setModifiedBy(modifiedBy);
                            studentPartialPaymentReceiptDetail.setDiscountAmount(discountAmount + studentPartialPaymentReceiptDetail.getDiscountAmount());
                            receipt.getReceiptDetails().add(studentReceiptdetail);
                            studentInvoiceDetail.setStudentInvoiceElementPaymentStatus(0);
                            this.studentInvoiceDetailDAO.update(studentInvoiceDetail);
                            this.studentPartialPaymentReceiptDetailDAO.update(studentPartialPaymentReceiptDetail);
                        }
                        ++i;
                    }
                } else if (discountType.equals("flat")) {
                    Double balanceAmount;
                    Double alreadyPaidTotalAmount;
                    StudentPartialPaymentReceiptDetail studentPartialPaymentReceiptDetail;
                    StudentInvoiceDetail studentInvoiceDetail;
                    Long invoiceDetailId;
                    if (normalFeesItem != null) {
                        i = 0;
                        while (i < normalFeesItem.length) {
                            invoiceDetailId = normalFeesItem[i];
                            studentInvoiceDetail = this.studentInvoiceDetailDAO.getStudentInvoiceDetailById(invoiceDetailId);
                            if (this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail) == null) {
                                StudentReceiptDetail studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), false, null, null, 0.0, Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), chequeReceivedDate, paymentStatus, createdBy, modifiedBy);
                                receipt.getReceiptDetails().add(studentReceiptdetail);
                                studentInvoiceDetail.setStudentInvoiceElementPaymentStatus(0);
                                this.studentInvoiceDetailDAO.update(studentInvoiceDetail);
                            } else {
                                studentPartialPaymentReceiptDetail = this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail);
                                alreadyPaidTotalAmount = studentPartialPaymentReceiptDetail.getPaidReceiptAmount() + studentPartialPaymentReceiptDetail.getDiscountAmount();
                                balanceAmount = studentInvoiceDetail.getStudentInvoiceElementTotalAmount() - alreadyPaidTotalAmount;
                                StudentReceiptDetail studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), false, null, null, 0.0, Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), Double.valueOf(Math.round(balanceAmount)), chequeReceivedDate, paymentStatus, createdBy, modifiedBy);
                                studentPartialPaymentReceiptDetail.setPaidReceiptAmount(balanceAmount + studentPartialPaymentReceiptDetail.getPaidReceiptAmount());
                                studentPartialPaymentReceiptDetail.setModifiedBy(modifiedBy);
                                receipt.getReceiptDetails().add(studentReceiptdetail);
                                studentInvoiceDetail.setStudentInvoiceElementPaymentStatus(0);
                                this.studentInvoiceDetailDAO.update(studentInvoiceDetail);
                                this.studentPartialPaymentReceiptDetailDAO.update(studentPartialPaymentReceiptDetail);
                            }
                            ++i;
                        }
                    }
                    i = 0;
                    while (i < flatDiscountFeesItems.length) {
                        invoiceDetailId = flatDiscountFeesItems[i];
                        studentInvoiceDetail = this.studentInvoiceDetailDAO.getStudentInvoiceDetailById(invoiceDetailId);
                        if (this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail) == null) {
                            Double actualAmount = studentInvoiceDetail.getStudentInvoiceElementTotalAmount();
                            Double discountAmount = flatDiscountFeesItemsAmount[i];
                            Long roundDiscountAmount = Math.round(discountAmount);
                            discountAmount = (double)roundDiscountAmount;
                            Double paidAmount = actualAmount - discountAmount;
                            StudentReceiptDetail studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), true, discountType, null, Double.valueOf(Math.round(discountAmount)), Double.valueOf(Math.round(actualAmount)), Double.valueOf(Math.round(paidAmount)), chequeReceivedDate, paymentStatus, createdBy, modifiedBy);
                            receipt.getReceiptDetails().add(studentReceiptdetail);
                            studentInvoiceDetail.setStudentInvoiceElementPaymentStatus(0);
                            this.studentInvoiceDetailDAO.update(studentInvoiceDetail);
                        } else {
                            studentPartialPaymentReceiptDetail = this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail);
                            alreadyPaidTotalAmount = studentPartialPaymentReceiptDetail.getPaidReceiptAmount() + studentPartialPaymentReceiptDetail.getDiscountAmount();
                            balanceAmount = studentInvoiceDetail.getStudentInvoiceElementTotalAmount() - alreadyPaidTotalAmount;
                            Double discountAmount = flatDiscountFeesItemsAmount[i];
                            Long roundDiscountAmount = Math.round(discountAmount);
                            discountAmount = (double)roundDiscountAmount;
                            Double paidAmount = balanceAmount - discountAmount;
                            StudentReceiptDetail studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), true, discountType, null, Double.valueOf(Math.round(discountAmount)), Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), Double.valueOf(Math.round(paidAmount)), chequeReceivedDate, paymentStatus, createdBy, modifiedBy);
                            studentPartialPaymentReceiptDetail.setPaidReceiptAmount(balanceAmount + studentPartialPaymentReceiptDetail.getPaidReceiptAmount());
                            studentPartialPaymentReceiptDetail.setModifiedBy(modifiedBy);
                            studentPartialPaymentReceiptDetail.setDiscountAmount(discountAmount + studentPartialPaymentReceiptDetail.getDiscountAmount());
                            receipt.getReceiptDetails().add(studentReceiptdetail);
                            studentInvoiceDetail.setStudentInvoiceElementPaymentStatus(0);
                            this.studentInvoiceDetailDAO.update(studentInvoiceDetail);
                            this.studentPartialPaymentReceiptDetailDAO.update(studentPartialPaymentReceiptDetail);
                        }
                        ++i;
                    }
                }
                studentInvoice.setDiscountApplicable(false);
            }
            if (fineAmount > 0.0) {
                fineAmount = Math.round(fineAmount);
                receipt.getReceiptFines().add(new StudentReceiptFine(studentInvoice.getAcademicYear(), receipt, fineAmount, chequeReceivedDate, createdBy, modifiedBy));
            }
            StudentReceipt persistedReceipt = this.studentReceiptDAO.save(receipt);
            if (this.checkForInvoiceClosing(studentInvoice)) {
                studentInvoice.setInvoiceStatus(0);
                this.studentInvoiceDAO.update(studentInvoice);
            }
            persistedReceiptNo = persistedReceipt.getReceiptId();
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
            StudentReceipt receipt = new StudentReceipt(studentInvoice.getInstitution(), studentInvoice.getAcademicYear(), paymentMode, Double.valueOf(Math.round(totalAmountPaid)), studentInvoice.getStudent(), paymentStatus, ddNo, ddDate, ddBankName, ddBranchName, ddReceivedDate, narration, createdBy, modifiedBy, studentInvoice);
            if (!isdiscountApplied) {
                i = 0;
                while (i < normalFeesItem.length) {
                    Long invoiceDetailId = normalFeesItem[i];
                    StudentInvoiceDetail studentInvoiceDetail = this.studentInvoiceDetailDAO.getStudentInvoiceDetailById(invoiceDetailId);
                    if (this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail) == null) {
                        StudentReceiptDetail studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), false, null, null, 0.0, Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), ddReceivedDate, paymentStatus, createdBy, modifiedBy);
                        receipt.getReceiptDetails().add(studentReceiptdetail);
                        studentInvoiceDetail.setStudentInvoiceElementPaymentStatus(0);
                        studentInvoiceDetail.setStudentInvoiceElementPaymentStatus(0);
                        this.studentInvoiceDetailDAO.update(studentInvoiceDetail);
                    } else {
                        StudentPartialPaymentReceiptDetail studentPartialPaymentReceiptDetail = this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail);
                        Double alreadyPaidTotalAmount = studentPartialPaymentReceiptDetail.getPaidReceiptAmount() + studentPartialPaymentReceiptDetail.getDiscountAmount();
                        Double balanceAmount = studentInvoiceDetail.getStudentInvoiceElementTotalAmount() - alreadyPaidTotalAmount;
                        StudentReceiptDetail studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), false, null, null, 0.0, Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), Double.valueOf(Math.round(balanceAmount)), ddReceivedDate, paymentStatus, createdBy, modifiedBy);
                        studentPartialPaymentReceiptDetail.setPaidReceiptAmount(balanceAmount + studentPartialPaymentReceiptDetail.getPaidReceiptAmount());
                        studentPartialPaymentReceiptDetail.setModifiedBy(modifiedBy);
                        receipt.getReceiptDetails().add(studentReceiptdetail);
                        studentInvoiceDetail.setStudentInvoiceElementPaymentStatus(0);
                        this.studentInvoiceDetailDAO.update(studentInvoiceDetail);
                        this.studentPartialPaymentReceiptDetailDAO.update(studentPartialPaymentReceiptDetail);
                    }
                    ++i;
                }
            } else {
                if (discountType.equals("percentage")) {
                    i = 0;
                    while (i < normalFeesItem.length) {
                        Long invoiceDetailId = normalFeesItem[i];
                        StudentInvoiceDetail studentInvoiceDetail = this.studentInvoiceDetailDAO.getStudentInvoiceDetailById(invoiceDetailId);
                        if (this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail) == null) {
                            Double actualAmount = studentInvoiceDetail.getStudentInvoiceElementTotalAmount();
                            Double discountAmount = this.calculatePercentageDiscountAmount(invoiceDetailId, discountPercentage);
                            Long roundDiscountAmount = Math.round(discountAmount);
                            discountAmount = (double)roundDiscountAmount;
                            Double paidAmount = actualAmount - discountAmount;
                            StudentReceiptDetail studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), true, discountType, discountPercentage.toString(), Double.valueOf(Math.round(discountAmount)), Double.valueOf(Math.round(actualAmount)), Double.valueOf(Math.round(paidAmount)), ddReceivedDate, paymentStatus, createdBy, modifiedBy);
                            receipt.getReceiptDetails().add(studentReceiptdetail);
                            studentInvoiceDetail.setStudentInvoiceElementPaymentStatus(0);
                            this.studentInvoiceDetailDAO.update(studentInvoiceDetail);
                        } else {
                            StudentPartialPaymentReceiptDetail studentPartialPaymentReceiptDetail = this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail);
                            Double alreadyPaidTotalAmount = studentPartialPaymentReceiptDetail.getPaidReceiptAmount() + studentPartialPaymentReceiptDetail.getDiscountAmount();
                            Double balanceAmount = studentInvoiceDetail.getStudentInvoiceElementTotalAmount() - alreadyPaidTotalAmount;
                            Double discountAmount = this.calculatePercentageDiscountAmount(invoiceDetailId, discountPercentage);
                            Long roundDiscountAmount = Math.round(discountAmount);
                            discountAmount = (double)roundDiscountAmount;
                            Double paidAmount = balanceAmount - discountAmount;
                            if (studentInvoiceDetail.getStudentInvoiceElementTotalAmount() - (paidAmount + discountAmount + alreadyPaidTotalAmount) < 0.0) {
                                throw new ReceiptException(new Message("failure", "Please Enter Valid Percentage..!"));
                            }
                            StudentReceiptDetail studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), true, discountType, discountPercentage.toString(), Double.valueOf(Math.round(discountAmount)), Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), Double.valueOf(Math.round(paidAmount)), ddReceivedDate, paymentStatus, createdBy, modifiedBy);
                            studentPartialPaymentReceiptDetail.setPaidReceiptAmount(balanceAmount + studentPartialPaymentReceiptDetail.getPaidReceiptAmount());
                            studentPartialPaymentReceiptDetail.setModifiedBy(modifiedBy);
                            studentPartialPaymentReceiptDetail.setDiscountAmount(discountAmount + studentPartialPaymentReceiptDetail.getDiscountAmount());
                            receipt.getReceiptDetails().add(studentReceiptdetail);
                            studentInvoiceDetail.setStudentInvoiceElementPaymentStatus(0);
                            this.studentInvoiceDetailDAO.update(studentInvoiceDetail);
                            this.studentPartialPaymentReceiptDetailDAO.update(studentPartialPaymentReceiptDetail);
                        }
                        ++i;
                    }
                } else if (discountType.equals("flat")) {
                    Double balanceAmount;
                    Double alreadyPaidTotalAmount;
                    StudentPartialPaymentReceiptDetail studentPartialPaymentReceiptDetail;
                    StudentInvoiceDetail studentInvoiceDetail;
                    Long invoiceDetailId;
                    if (normalFeesItem != null) {
                        i = 0;
                        while (i < normalFeesItem.length) {
                            invoiceDetailId = normalFeesItem[i];
                            studentInvoiceDetail = this.studentInvoiceDetailDAO.getStudentInvoiceDetailById(invoiceDetailId);
                            if (this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail) == null) {
                                StudentReceiptDetail studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), false, null, null, 0.0, Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), ddReceivedDate, paymentStatus, createdBy, modifiedBy);
                                receipt.getReceiptDetails().add(studentReceiptdetail);
                                studentInvoiceDetail.setStudentInvoiceElementPaymentStatus(0);
                                this.studentInvoiceDetailDAO.update(studentInvoiceDetail);
                            } else {
                                studentPartialPaymentReceiptDetail = this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail);
                                alreadyPaidTotalAmount = studentPartialPaymentReceiptDetail.getPaidReceiptAmount() + studentPartialPaymentReceiptDetail.getDiscountAmount();
                                balanceAmount = studentInvoiceDetail.getStudentInvoiceElementTotalAmount() - alreadyPaidTotalAmount;
                                StudentReceiptDetail studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), false, null, null, 0.0, Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), Double.valueOf(Math.round(balanceAmount)), ddReceivedDate, paymentStatus, createdBy, modifiedBy);
                                studentPartialPaymentReceiptDetail.setPaidReceiptAmount(balanceAmount + studentPartialPaymentReceiptDetail.getPaidReceiptAmount());
                                studentPartialPaymentReceiptDetail.setModifiedBy(modifiedBy);
                                receipt.getReceiptDetails().add(studentReceiptdetail);
                                studentInvoiceDetail.setStudentInvoiceElementPaymentStatus(0);
                                this.studentInvoiceDetailDAO.update(studentInvoiceDetail);
                                this.studentPartialPaymentReceiptDetailDAO.update(studentPartialPaymentReceiptDetail);
                            }
                            ++i;
                        }
                    }
                    i = 0;
                    while (i < flatDiscountFeesItems.length) {
                        invoiceDetailId = flatDiscountFeesItems[i];
                        studentInvoiceDetail = this.studentInvoiceDetailDAO.getStudentInvoiceDetailById(invoiceDetailId);
                        if (this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail) == null) {
                            Double actualAmount = studentInvoiceDetail.getStudentInvoiceElementTotalAmount();
                            Double discountAmount = flatDiscountFeesItemsAmount[i];
                            Long roundDiscountAmount = Math.round(discountAmount);
                            discountAmount = (double)roundDiscountAmount;
                            Double paidAmount = actualAmount - discountAmount;
                            StudentReceiptDetail studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), true, discountType, null, Double.valueOf(Math.round(discountAmount)), Double.valueOf(Math.round(actualAmount)), Double.valueOf(Math.round(paidAmount)), ddReceivedDate, paymentStatus, createdBy, modifiedBy);
                            receipt.getReceiptDetails().add(studentReceiptdetail);
                            studentInvoiceDetail.setStudentInvoiceElementPaymentStatus(0);
                            this.studentInvoiceDetailDAO.update(studentInvoiceDetail);
                        } else {
                            studentPartialPaymentReceiptDetail = this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail);
                            alreadyPaidTotalAmount = studentPartialPaymentReceiptDetail.getPaidReceiptAmount() + studentPartialPaymentReceiptDetail.getDiscountAmount();
                            balanceAmount = studentInvoiceDetail.getStudentInvoiceElementTotalAmount() - alreadyPaidTotalAmount;
                            Double discountAmount = flatDiscountFeesItemsAmount[i];
                            Long roundDiscountAmount = Math.round(discountAmount);
                            discountAmount = (double)roundDiscountAmount;
                            Double paidAmount = balanceAmount - discountAmount;
                            StudentReceiptDetail studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), true, discountType, null, Double.valueOf(Math.round(discountAmount)), Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), Double.valueOf(Math.round(paidAmount)), ddReceivedDate, paymentStatus, createdBy, modifiedBy);
                            studentPartialPaymentReceiptDetail.setPaidReceiptAmount(balanceAmount + studentPartialPaymentReceiptDetail.getPaidReceiptAmount());
                            studentPartialPaymentReceiptDetail.setModifiedBy(modifiedBy);
                            studentPartialPaymentReceiptDetail.setDiscountAmount(discountAmount + studentPartialPaymentReceiptDetail.getDiscountAmount());
                            receipt.getReceiptDetails().add(studentReceiptdetail);
                            studentInvoiceDetail.setStudentInvoiceElementPaymentStatus(0);
                            this.studentInvoiceDetailDAO.update(studentInvoiceDetail);
                            this.studentPartialPaymentReceiptDetailDAO.update(studentPartialPaymentReceiptDetail);
                        }
                        ++i;
                    }
                }
                studentInvoice.setDiscountApplicable(false);
            }
            if (fineAmount > 0.0) {
                fineAmount = Math.round(fineAmount);
                receipt.getReceiptFines().add(new StudentReceiptFine(studentInvoice.getAcademicYear(), receipt, fineAmount, ddReceivedDate, createdBy, modifiedBy));
            }
            StudentReceipt persistedReceipt = this.studentReceiptDAO.save(receipt);
            if (this.checkForInvoiceClosing(studentInvoice)) {
                studentInvoice.setInvoiceStatus(0);
                this.studentInvoiceDAO.update(studentInvoice);
            }
            persistedReceiptNo = persistedReceipt.getReceiptId();
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
    public ArrayList<StudentReceipt> getStudentReceiptsByPaymentMode(Long paymentModeId) {
        PaymentMode paymentMode = this.paymentModeDAO.getPaymentModeById(paymentModeId);
        Set<StudentReceipt> studentReceipts = paymentMode.getStudentReceipts();
        ArrayList<StudentReceipt> studentReceiptList = new ArrayList<StudentReceipt>();
        studentReceiptList.addAll(studentReceipts);
        return studentReceiptList;
    }

    @Override
    public ArrayList<StudentReceipt> getStudentReceiptsFromPaymentModeAndStatus(Long paymentModeId, Long paymentStatusId) {
        PaymentMode paymentMode = this.paymentModeDAO.getPaymentModeById(paymentModeId);
        PaymentStatus paymentStatus = this.paymentStatusDAO.getPaymentStatusById(paymentStatusId);
        ArrayList studentReceipts = (ArrayList)this.studentReceiptDAO.getStudentReceiptByPaymentModeAndStatus(paymentMode, paymentStatus);
        for (StudentReceipt studentReceipt : studentReceipts) {
            Hibernate.initialize((Object)studentReceipt.getStudent());
            Hibernate.initialize(studentReceipt.getReceiptFines());
        }
        return studentReceipts;
    }

    @Override
    public void updateReconcillation(Long[] receiptId, Long paymentStatusId, Date clearanceDate, String comment, String receiptClearedBy) throws StudentReceiptException {
        StudentReceipt studentReceipt = null;
        int i = 0;
        while (i < receiptId.length) {
            Long receipt = receiptId[i];
            studentReceipt = this.studentReceiptDAO.getStudentReceiptById(receipt);
            PaymentStatus paymentStatus = this.paymentStatusDAO.getPaymentStatusById(paymentStatusId);
            if (paymentStatusId == 2L) {
                studentReceipt.setPaymentStatus(paymentStatus);
                studentReceipt.setPaymentClearedDate(clearanceDate);
                studentReceipt.setComments(comment);
                studentReceipt.setReceiptClearedBy(receiptClearedBy);
                for (StudentReceiptDetail studentReceiptDetail : studentReceipt.getReceiptDetails()) {
                    studentReceiptDetail.setPaymentStatus(paymentStatus);
                    studentReceiptDetail.setPaymentClearedDate(clearanceDate);
                    this.studentReceiptDetailDAO.update(studentReceiptDetail);
                }
                this.studentReceiptDAO.update(studentReceipt);
            } else if (paymentStatusId == 1L) {
                throw new StudentReceiptException(new Message("failure", "Invoice Status Already Pending"));
            }
            ++i;
        }
    }

    @Override
    public void updateChequeReconcillation(Long[] receiptId, Long paymentStatusId, Date chequeClearanceDate, String comment, String receiptClearedBy) throws StudentReceiptException {
        int i = 0;
        while (i < receiptId.length) {
            Long receipt = receiptId[i];
            StudentReceipt studentReceipt = this.studentReceiptDAO.getStudentReceiptById(receipt);
            PaymentStatus paymentStatus = this.paymentStatusDAO.getPaymentStatusById(paymentStatusId);
            if (paymentStatusId == 2L) {
                studentReceipt.setPaymentStatus(paymentStatus);
                studentReceipt.setPaymentClearedDate(chequeClearanceDate);
                studentReceipt.setComments(comment);
                studentReceipt.setReceiptClearedBy(receiptClearedBy);
                for (StudentReceiptDetail studentReceiptDetail : studentReceipt.getReceiptDetails()) {
                    studentReceiptDetail.setPaymentStatus(paymentStatus);
                    studentReceiptDetail.setPaymentClearedDate(chequeClearanceDate);
                    this.studentReceiptDetailDAO.update(studentReceiptDetail);
                }
                this.studentReceiptDAO.update(studentReceipt);
            } else if (paymentStatusId == 3L) {
                boolean chequeForDiscount = true;
                StudentInvoice studentInvoice = studentReceipt.getStudentInvoice();
                Set<StudentReceiptDetail> receiptDetails = studentReceipt.getReceiptDetails();
                if (receiptDetails != null) {
                    boolean count = true;
                    for (StudentReceiptDetail studentReceiptDetail : receiptDetails) {
                        if (count) {
                            studentReceipt.setPaymentStatus(paymentStatus);
                            studentReceipt.setReceiptClearedBy(receiptClearedBy);
                            studentReceipt.setComments(comment);
                            this.studentReceiptDAO.update(studentReceipt);
                            count = false;
                        }
                        studentReceiptDetail.getStudentInvoiceDetail().setStudentInvoiceElementPaymentStatus(1);
                        studentReceiptDetail.setPaymentStatus(paymentStatus);
                        if (chequeForDiscount && studentReceiptDetail.isDiscountApplied()) {
                            chequeForDiscount = false;
                            studentInvoice.setDiscountApplicable(true);
                        }
                        this.studentReceiptDetailDAO.update(studentReceiptDetail);
                    }
                    studentInvoice.setInvoiceStatus(1);
                    this.studentInvoiceDAO.update(studentInvoice);
                }
            } else if (paymentStatusId == 1L) {
                throw new StudentReceiptException(new Message("failure", "Invoice Status Already Pending"));
            }
            ++i;
        }
    }

    @Override
    public void updateDdReconcillation(Long[] receiptId, Long paymentStatusId, Date chequeClearanceDate, String comment, String receiptClearedBy) throws StudentReceiptException {
        int i = 0;
        while (i < receiptId.length) {
            Long receipt = receiptId[i];
            StudentReceipt studentReceipt = this.studentReceiptDAO.getStudentReceiptById(receipt);
            PaymentStatus paymentStatus = this.paymentStatusDAO.getPaymentStatusById(paymentStatusId);
            if (paymentStatusId == 2L) {
                studentReceipt.setPaymentStatus(paymentStatus);
                studentReceipt.setPaymentClearedDate(chequeClearanceDate);
                studentReceipt.setComments(comment);
                studentReceipt.setReceiptClearedBy(receiptClearedBy);
                for (StudentReceiptDetail studentReceiptDetail : studentReceipt.getReceiptDetails()) {
                    studentReceiptDetail.setPaymentStatus(paymentStatus);
                    studentReceiptDetail.setPaymentClearedDate(chequeClearanceDate);
                    this.studentReceiptDetailDAO.update(studentReceiptDetail);
                }
                this.studentReceiptDAO.update(studentReceipt);
            } else if (paymentStatusId == 3L) {
                boolean chequeForDiscount = true;
                StudentInvoice studentInvoice = studentReceipt.getStudentInvoice();
                Set<StudentReceiptDetail> receiptDetails = studentReceipt.getReceiptDetails();
                if (receiptDetails != null) {
                    boolean count = true;
                    for (StudentReceiptDetail studentReceiptDetail : receiptDetails) {
                        if (count) {
                            studentReceipt.setPaymentStatus(paymentStatus);
                            studentReceipt.setReceiptClearedBy(receiptClearedBy);
                            studentReceipt.setComments(comment);
                            this.studentReceiptDAO.update(studentReceipt);
                            count = false;
                        }
                        studentReceiptDetail.getStudentInvoiceDetail().setStudentInvoiceElementPaymentStatus(1);
                        studentReceiptDetail.setPaymentStatus(paymentStatus);
                        if (chequeForDiscount && studentReceiptDetail.isDiscountApplied()) {
                            chequeForDiscount = false;
                            studentInvoice.setDiscountApplicable(true);
                        }
                        this.studentReceiptDetailDAO.update(studentReceiptDetail);
                    }
                    studentInvoice.setInvoiceStatus(1);
                    this.studentInvoiceDAO.update(studentInvoice);
                }
            } else if (paymentStatusId == 1L) {
                throw new StudentReceiptException(new Message("failure", "Invoice Status Already Pending"));
            }
            ++i;
        }
    }

    @Override
    public StudentReceipt getStudentReceiptDetails(Long receiptId) throws ParseException {
        StudentReceipt studentReceipt = this.studentReceiptDAO.getStudentReceiptById(receiptId);
        Hibernate.initialize(studentReceipt.getReceiptDetails());
        Set<StudentReceiptDetail> studentReceiptdetails = studentReceipt.getReceiptDetails();
        for (StudentReceiptDetail studentReceiptDetail : studentReceiptdetails) {
            Hibernate.initialize((Object)studentReceiptDetail.getStudentInvoiceDetail().getFeesItem());
        }
        Hibernate.initialize(studentReceipt.getReceiptFines());
        Hibernate.initialize(studentReceipt.getStudent().getSpecialCategories());
        Hibernate.initialize((Object)studentReceipt.getPaymentMode());
        Hibernate.initialize((Object)studentReceipt.getInstitution());
        Hibernate.initialize((Object)studentReceipt.getAcademicYear());
        Hibernate.initialize((Object)studentReceipt.getStudent().getStudentClass());
        Hibernate.initialize((Object)studentReceipt.getStudent().getSection());
        Hibernate.initialize((Object)studentReceipt.getPaymentReceivedDate());
        Hibernate.initialize((Object)studentReceipt.getStudentInvoice().getFeesTerm());
        Hibernate.initialize((Object)studentReceipt.getStudent().getInstitution());
        return studentReceipt;
    }

    @Override
    public ArrayList<StudentReceipt> getAllStudentReceipts(AcademicYear academicYear, Class clazz, Section section) {
        ArrayList students = (ArrayList)this.studentDAO.getStudentsByClassAndSection(clazz, section);
        ArrayList<StudentReceipt> studentReceipts = new ArrayList<StudentReceipt>();
        for (Student student : students) {
            ArrayList studentReceipts1 = (ArrayList)this.studentReceiptDAO.getAllStudentReceipts(academicYear, student);
            for (StudentReceipt studentReceipt : studentReceipts1) {
                for (StudentReceiptDetail StudentReceiptDetail2 : studentReceipt.getReceiptDetails()) {
                    Hibernate.initialize((Object)StudentReceiptDetail2.getDiscountAmount());
                }
                Hibernate.initialize((Object)studentReceipt.getPaymentMode());
                Hibernate.initialize((Object)studentReceipt.getPaymentStatus());
                Hibernate.initialize(studentReceipt.getReceiptFines());
                Hibernate.initialize((Object)studentReceipt.getStudent().getStudentClass());
                Hibernate.initialize((Object)studentReceipt.getStudent().getSection());
                Hibernate.initialize((Object)studentReceipt.getStudentInvoice().getFeesTerm().getFeesTermName());
            }
            studentReceipts.addAll(studentReceipts1);
        }
        return studentReceipts;
    }

    @Override
    public ArrayList<StudentReceipt> getAllStudentsReceipts(AcademicYear academicYear, Institution institution) {
        ArrayList studentReceipts = (ArrayList)this.studentReceiptDAO.getAllStudentsReceipts(academicYear, institution);
        for (StudentReceipt studentReceipt : studentReceipts) {
            for (StudentReceiptDetail StudentReceiptDetail2 : studentReceipt.getReceiptDetails()) {
                Hibernate.initialize((Object)StudentReceiptDetail2.getDiscountAmount());
            }
            Hibernate.initialize((Object)studentReceipt.getPaymentMode());
            Hibernate.initialize((Object)studentReceipt.getPaymentStatus());
            Hibernate.initialize(studentReceipt.getReceiptFines());
            Hibernate.initialize((Object)studentReceipt.getStudent().getStudentClass());
            Hibernate.initialize((Object)studentReceipt.getStudentInvoice().getFeesTerm().getFeesTermName());
            Hibernate.initialize((Object)studentReceipt.getStudent().getSection());
        }
        return studentReceipts;
    }

    @Override
    public ArrayList<StudentReceipt> getStudentReceiptsBySpecialCategory(AcademicYear academicYear, Class clazz, Section section, SpecialCategory specialCategory) {
        ArrayList students = (ArrayList)this.studentDAO.getStudentsByClassSectionAndSpecialCategory(clazz, section, specialCategory);
        ArrayList<StudentReceipt> studentReceipts = new ArrayList<StudentReceipt>();
        for (Student student : students) {
            ArrayList receipts = (ArrayList)this.studentReceiptDAO.getAllStudentReceipts(academicYear, student);
            for (StudentReceipt studentReceipt : receipts) {
                for (StudentReceiptDetail StudentReceiptDetail2 : studentReceipt.getReceiptDetails()) {
                    Hibernate.initialize((Object)StudentReceiptDetail2.getDiscountAmount());
                }
                Hibernate.initialize((Object)studentReceipt.getPaymentMode());
                Hibernate.initialize((Object)studentReceipt.getPaymentStatus());
                Hibernate.initialize(studentReceipt.getReceiptFines());
                Hibernate.initialize((Object)studentReceipt.getStudent().getStudentClass());
                Hibernate.initialize((Object)studentReceipt.getStudent().getSection());
                Hibernate.initialize((Object)studentReceipt.getStudentInvoice().getFeesTerm().getFeesTermName());
            }
            studentReceipts.addAll(receipts);
        }
        return studentReceipts;
    }

    @Override
    public ArrayList<StudentReceipt> getStudentReceiptsBySpecialCategory(AcademicYear academicYear, SpecialCategory specialCategory, Institution institution) {
        ArrayList receipts = (ArrayList)this.studentReceiptDAO.getAllStudentsReceipts(academicYear, institution);
        Iterator receiptIterator = receipts.iterator();
        while (receiptIterator.hasNext()) {
            StudentReceipt studentReceipt = (StudentReceipt)receiptIterator.next();
            if (studentReceipt.getStudent().getSpecialCategories().contains(specialCategory)) continue;
            receiptIterator.remove();
        }
        for (StudentReceipt studentReceipt : receipts) {
            for (StudentReceiptDetail StudentReceiptDetail2 : studentReceipt.getReceiptDetails()) {
                Hibernate.initialize((Object)StudentReceiptDetail2.getDiscountAmount());
            }
            Hibernate.initialize((Object)studentReceipt.getPaymentMode());
            Hibernate.initialize((Object)studentReceipt.getPaymentStatus());
            Hibernate.initialize(studentReceipt.getReceiptFines());
            Hibernate.initialize((Object)studentReceipt.getStudent().getStudentClass());
            Hibernate.initialize((Object)studentReceipt.getStudent().getSection());
            Hibernate.initialize((Object)studentReceipt.getStudentInvoice().getFeesTerm().getFeesTermName());
        }
        return receipts;
    }

    @Override
    public ArrayList<StudentReceipt> getStudentReceiptsByAdmisssionNo(String admissionNo) {
        Student student = this.studentDAO.getStudentByAdmissionNo(admissionNo);
        ArrayList<StudentReceipt> studentReceipts = new ArrayList<StudentReceipt>();
        if (student != null) {
            Hibernate.initialize(student.getStudentReceipts());
            Set<StudentReceipt> receipts = student.getStudentReceipts();
            for (StudentReceipt studentReceipt : receipts) {
                Hibernate.initialize((Object)studentReceipt);
                Hibernate.initialize((Object)studentReceipt.getPaymentMode());
                Hibernate.initialize((Object)studentReceipt.getAcademicYear());
                Hibernate.initialize((Object)studentReceipt.getPaymentStatus());
                Hibernate.initialize((Object)studentReceipt.getStudent().getStudentClass());
                Hibernate.initialize((Object)studentReceipt.getStudent().getSection());
                Hibernate.initialize(studentReceipt.getReceiptFines());
                Hibernate.initialize((Object)studentReceipt.getStudentInvoice().getFeesTerm());
                studentReceipts.add(studentReceipt);
            }
        }
        return studentReceipts;
    }

    @Override
    public ArrayList<StudentReceipt> getStudentReceiptsByAdmisssionNoAndAcademicYear(String admissionNo, AcademicYear academicYear) {
        Student student = this.studentDAO.getStudentByAdmissionNo(admissionNo);
        ArrayList<StudentReceipt> studentReceipts = new ArrayList<StudentReceipt>();
        if (student != null) {
            Set<StudentReceipt> receipts = student.getStudentReceipts();
            Iterator<StudentReceipt> studentReceiptIterator = receipts.iterator();
            while (studentReceiptIterator.hasNext()) {
                StudentReceipt studentReceipt = studentReceiptIterator.next();
                if (studentReceipt.getAcademicYear().getAcademicYearId() == academicYear.getAcademicYearId()) continue;
                studentReceiptIterator.remove();
            }
            for (StudentReceipt studentReceipt : receipts) {
                for (StudentReceiptDetail StudentReceiptDetail2 : studentReceipt.getReceiptDetails()) {
                    Hibernate.initialize((Object)StudentReceiptDetail2.getDiscountAmount());
                }
                Hibernate.initialize((Object)studentReceipt.getPaymentMode());
                Hibernate.initialize((Object)studentReceipt.getPaymentStatus());
                Hibernate.initialize((Object)studentReceipt.getStudent().getStudentClass());
                Hibernate.initialize((Object)studentReceipt.getStudent().getSection());
                Hibernate.initialize((Object)studentReceipt.getStudentInvoice().getFeesTerm().getFeesTermName());
                Hibernate.initialize(studentReceipt.getReceiptFines());
            }
            studentReceipts.addAll(receipts);
        }
        return studentReceipts;
    }

    @Override
    public void deleteReceipt(Long receiptId) {
        StudentReceipt receipt = this.studentReceiptDAO.getStudentReceiptById(receiptId);
        StudentInvoice studentInvoice = receipt.getStudentInvoice();
        studentInvoice.setInvoiceStatus(1);
        Set<StudentInvoiceDetail> studentInvoiceDetails = studentInvoice.getStudentInvoiceDetails();
        for (StudentInvoiceDetail studentInvoiceDetail : studentInvoiceDetails) {
            studentInvoiceDetail.setStudentInvoiceElementPaymentStatus(1);
            if (this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail) == null) continue;
            this.studentPartialPaymentReceiptDetailDAO.delete(this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail));
        }
        this.studentInvoiceDAO.update(studentInvoice);
        this.studentReceiptDAO.delete(receipt);
    }

    @Override
    public ArrayList<StudentReceipt> getReceiptsByDateRange(Date fromDate, Date toDate, Institution institution) {
        List<StudentReceipt> receipts = this.studentReceiptDAO.getStudentReceiptByDate(fromDate, toDate, institution);
        for (StudentReceipt studentReceipt : receipts) {
            for (StudentReceiptDetail StudentReceiptDetail2 : studentReceipt.getReceiptDetails()) {
                Hibernate.initialize((Object)StudentReceiptDetail2.getDiscountAmount());
            }
            Hibernate.initialize((Object)studentReceipt.getPaymentMode());
            Hibernate.initialize((Object)studentReceipt.getPaymentStatus());
            Hibernate.initialize((Object)studentReceipt.getStudent().getStudentClass());
            Hibernate.initialize((Object)studentReceipt.getStudent().getSection());
            Hibernate.initialize(studentReceipt.getReceiptFines());
            Hibernate.initialize((Object)studentReceipt.getStudentInvoice().getFeesTerm().getFeesTermName());
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
                totalAmount = totalAmount + (studentInvoiceDetail.getStudentInvoiceElementTotalAmount() - (studentPartialPaymentReceiptDetail.getPaidReceiptAmount() + studentPartialPaymentReceiptDetail.getDiscountAmount()));
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
            totalAmount1 = totalAmount1 + (double)Math.round(totalDiscountAmount);
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
                totalAmount = totalAmount + (studentInvoiceDetail.getStudentInvoiceElementTotalAmount() - (studentPartialPaymentReceiptDetail.getPaidReceiptAmount() + studentPartialPaymentReceiptDetail.getDiscountAmount()));
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
                Double discount = Math.round(flatDiscount[i]);
                totalAmount = totalAmount + (partialAmounts[i] + discount);
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
                totalAmount = totalAmount + (studentInvoiceDetail.getStudentInvoiceElementTotalAmount() - (studentPartialPaymentReceiptDetail.getPaidReceiptAmount() + studentPartialPaymentReceiptDetail.getDiscountAmount()));
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
            totalAmount = totalAmount + (studentInvoiceDetail.getStudentInvoiceElementTotalAmount() - (studentPartialPaymentReceiptDetail.getPaidReceiptAmount() + studentPartialPaymentReceiptDetail.getDiscountAmount()));
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
        if (this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail) != null) {
            StudentPartialPaymentReceiptDetail studentPartialPaymentReceiptDetail = this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail);
            totalAmount = totalAmount + (studentInvoiceDetail.getStudentInvoiceElementTotalAmount() - (studentPartialPaymentReceiptDetail.getPaidReceiptAmount() + studentPartialPaymentReceiptDetail.getDiscountAmount()));
        } else {
            totalAmount = totalAmount + studentInvoiceDetail.getStudentInvoiceElementTotalAmount();
        }
        if (studentInvoiceDetail != null) {
            Double percentageVariable = percentage / 100.0;
            totalAmount = (double)Math.round(totalAmount * percentageVariable * 100.0) / 100.0;
        }
        totalAmount = totalAmount + partialAmount;
        return totalAmount;
    }

    @Override
    public ArrayList<SixFieldReports> getStudentReceiptsByDateRange(Long institutionId, Date fromDate, Date toDate, Long paymentModeId) throws Exception {
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
                    Set<StudentReceiptDetail> studentReceiptDetails = feesItem.getStudentReceiptsItems();
                    for (StudentReceiptDetail studentReceiptDetail : studentReceiptDetails) {
                        for (StudentReceipt studentReceipt : this.studentReceiptDAO.getStudentReceiptByPaymentAndInstitution(institution, paymentMode)) {
                            StudentReceiptDetail curStudentReceiptDetail = this.studentReceiptDetailDAO.getStudentReceiptDetailByDate(fromDate, toDate, studentReceiptDetail.getStudentReceiptDetailId(), studentReceipt);
                            if (curStudentReceiptDetail == null || studentReceiptDetail.getStudentReceiptDetailId() != curStudentReceiptDetail.getStudentReceiptDetailId()) continue;
                            paidReceiptAmount = paidReceiptAmount + curStudentReceiptDetail.getPaidReceiptAmount();
                            discountAmount = discountAmount + curStudentReceiptDetail.getDiscountAmount();
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
    public void deleteStudentReceiptsByAcademicYear(Long[] studentIds, Long academicYearId) throws Exception, StudentReceiptException {
        AcademicYear academicYear = this.academicYearDAO.getAcademicYearById(academicYearId);
        Long[] longArray = studentIds;
        int n = studentIds.length;
        int n2 = 0;
        while (n2 < n) {
            Long studentId = longArray[n2];
            Student student = this.studentDAO.getStudentById(studentId);
            List<StudentReceipt> studentReceipts = this.studentReceiptDAO.getAllStudentReceipts(academicYear, student);
            if (studentReceipts != null) {
                for (StudentReceipt studentReceipt : studentReceipts) {
                    StudentReceipt receipt = this.studentReceiptDAO.getStudentReceiptById(studentReceipt.getReceiptId());
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
                    this.studentReceiptDAO.delete(receipt);
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
        StudentReceipt receipt = new StudentReceipt(studentInvoice.getInstitution(), studentInvoice.getAcademicYear(), paymentMode, receivedDate, Double.valueOf(Math.round(totalAmountPaid)), studentInvoice.getStudent(), paymentStatus, narration, createdBy, modifiedBy, studentInvoice);
        if (!isdiscountApplied) {
            i = 0;
            while (i < normalFeesItem.length) {
                Long invoiceDetailId = normalFeesItem[i];
                Double partialAmount = partialFeesItemAmounts[i];
                StudentInvoiceDetail studentInvoiceDetail = this.studentInvoiceDetailDAO.getStudentInvoiceDetailById(invoiceDetailId);
                if (this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail) == null) {
                    StudentReceiptDetail studentReceiptdetail;
                    if ((double)Math.round(partialAmount) == (double)Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())) {
                        studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), false, null, null, 0.0, Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), receivedDate, paymentStatus, createdBy, modifiedBy);
                        receipt.getReceiptDetails().add(studentReceiptdetail);
                        studentInvoiceDetail.setStudentInvoiceElementPaymentStatus(0);
                        this.studentInvoiceDetailDAO.update(studentInvoiceDetail);
                    } else {
                        studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), false, null, null, 0.0, Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), Double.valueOf(Math.round(partialAmount)), receivedDate, paymentStatus, createdBy, modifiedBy);
                        StudentPartialPaymentReceiptDetail studentPartialPaymentReceiptDetail = new StudentPartialPaymentReceiptDetail(studentInvoice.getAcademicYear(), studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), false, null, null, 0.0, Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), Double.valueOf(Math.round(partialAmount)), receivedDate, paymentStatus, createdBy, modifiedBy);
                        receipt.getReceiptDetails().add(studentReceiptdetail);
                        this.studentPartialPaymentReceiptDetailDAO.save(studentPartialPaymentReceiptDetail);
                    }
                } else {
                    StudentReceiptDetail studentReceiptdetail;
                    StudentPartialPaymentReceiptDetail studentPartialPaymentReceiptDetail = this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail);
                    Double alreadyPaidTotalAmount = studentPartialPaymentReceiptDetail.getPaidReceiptAmount() + studentPartialPaymentReceiptDetail.getDiscountAmount();
                    if ((double)Math.round(partialAmount + alreadyPaidTotalAmount) == (double)Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())) {
                        studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), false, null, null, 0.0, Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), Double.valueOf(Math.round(partialAmount)), receivedDate, paymentStatus, createdBy, modifiedBy);
                        receipt.getReceiptDetails().add(studentReceiptdetail);
                        studentInvoiceDetail.setStudentInvoiceElementPaymentStatus(0);
                        studentPartialPaymentReceiptDetail.setPaidReceiptAmount(studentInvoiceDetail.getStudentInvoiceElementTotalAmount());
                        this.studentInvoiceDetailDAO.update(studentInvoiceDetail);
                        this.studentPartialPaymentReceiptDetailDAO.update(studentPartialPaymentReceiptDetail);
                    } else {
                        studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), false, null, null, 0.0, Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), Double.valueOf(Math.round(partialAmount)), receivedDate, paymentStatus, createdBy, modifiedBy);
                        studentPartialPaymentReceiptDetail.setPaidReceiptAmount(partialAmount + studentPartialPaymentReceiptDetail.getPaidReceiptAmount());
                        studentPartialPaymentReceiptDetail.setModifiedBy(modifiedBy);
                        receipt.getReceiptDetails().add(studentReceiptdetail);
                        this.studentPartialPaymentReceiptDetailDAO.update(studentPartialPaymentReceiptDetail);
                    }
                }
                ++i;
            }
        } else {
            if (discountType.equals("percentage")) {
                i = 0;
                while (i < normalFeesItem.length) {
                    Long invoiceDetailId = normalFeesItem[i];
                    Double partialAmount = partialFeesItemAmounts[i];
                    StudentInvoiceDetail studentInvoiceDetail = this.studentInvoiceDetailDAO.getStudentInvoiceDetailById(invoiceDetailId);
                    if (this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail) == null) {
                        StudentReceiptDetail studentReceiptdetail;
                        Double discountAmount = this.calculatePercentageDiscountAmount(invoiceDetailId, discountPercentage);
                        Long roundDiscountAmount = Math.round(discountAmount);
                        discountAmount = (double)roundDiscountAmount;
                        Double actualAmount = studentInvoiceDetail.getStudentInvoiceElementTotalAmount();
                        Double paidAmount = partialAmount;
                        if (actualAmount - (paidAmount + discountAmount) < 0.0) {
                            throw new ReceiptException(new Message("failure", "Please Enter Valid Percentage..!"));
                        }
                        if ((double)Math.round(partialAmount + discountAmount) == (double)Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())) {
                            studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), true, discountType, discountPercentage.toString(), Double.valueOf(Math.round(discountAmount)), Double.valueOf(Math.round(actualAmount)), Double.valueOf(Math.round(partialAmount)), receivedDate, paymentStatus, createdBy, modifiedBy);
                            receipt.getReceiptDetails().add(studentReceiptdetail);
                            studentInvoiceDetail.setStudentInvoiceElementPaymentStatus(0);
                            this.studentInvoiceDetailDAO.update(studentInvoiceDetail);
                        } else {
                            studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), true, discountType, discountPercentage.toString(), Double.valueOf(Math.round(discountAmount)), Double.valueOf(Math.round(actualAmount)), Double.valueOf(Math.round(partialAmount)), receivedDate, paymentStatus, createdBy, modifiedBy);
                            StudentPartialPaymentReceiptDetail studentPartialPaymentReceiptDetail = new StudentPartialPaymentReceiptDetail(studentInvoice.getAcademicYear(), studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), true, discountType, discountPercentage.toString(), Double.valueOf(Math.round(discountAmount)), Double.valueOf(Math.round(actualAmount)), Double.valueOf(Math.round(partialAmount)), receivedDate, paymentStatus, createdBy, modifiedBy);
                            receipt.getReceiptDetails().add(studentReceiptdetail);
                            this.studentPartialPaymentReceiptDetailDAO.save(studentPartialPaymentReceiptDetail);
                        }
                    } else {
                        StudentReceiptDetail studentReceiptdetail;
                        StudentPartialPaymentReceiptDetail studentPartialPaymentReceiptDetail = this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail);
                        Double alreadyPaidTotalAmount = studentPartialPaymentReceiptDetail.getPaidReceiptAmount() + studentPartialPaymentReceiptDetail.getDiscountAmount();
                        Double discountAmount = this.calculatePercentageDiscountAmount(invoiceDetailId, discountPercentage);
                        Long roundDiscountAmount = Math.round(discountAmount);
                        discountAmount = (double)roundDiscountAmount;
                        Double actualAmount = studentInvoiceDetail.getStudentInvoiceElementTotalAmount();
                        Double paidAmount = partialAmount;
                        if (actualAmount - (paidAmount + discountAmount + alreadyPaidTotalAmount) < 0.0) {
                            throw new ReceiptException(new Message("failure", "Please Enter Valid Percentage..!"));
                        }
                        if ((double)Math.round(partialAmount + alreadyPaidTotalAmount + discountAmount) == (double)Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())) {
                            studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), true, discountType, discountPercentage.toString(), Double.valueOf(Math.round(discountAmount)), Double.valueOf(Math.round(actualAmount)), Double.valueOf(Math.round(partialAmount)), receivedDate, paymentStatus, createdBy, modifiedBy);
                            receipt.getReceiptDetails().add(studentReceiptdetail);
                            studentInvoiceDetail.setStudentInvoiceElementPaymentStatus(0);
                            studentPartialPaymentReceiptDetail.setPaidReceiptAmount(studentInvoiceDetail.getStudentInvoiceElementTotalAmount());
                            this.studentInvoiceDetailDAO.update(studentInvoiceDetail);
                            this.studentPartialPaymentReceiptDetailDAO.update(studentPartialPaymentReceiptDetail);
                        } else {
                            studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), true, discountType, discountPercentage.toString(), Double.valueOf(Math.round(discountAmount)), Double.valueOf(Math.round(actualAmount)), Double.valueOf(Math.round(partialAmount)), receivedDate, paymentStatus, createdBy, modifiedBy);
                            studentPartialPaymentReceiptDetail.setPaidReceiptAmount(partialAmount + studentPartialPaymentReceiptDetail.getPaidReceiptAmount());
                            studentPartialPaymentReceiptDetail.setModifiedBy(modifiedBy);
                            studentPartialPaymentReceiptDetail.setDiscountAmount(discountAmount + studentPartialPaymentReceiptDetail.getDiscountAmount());
                            receipt.getReceiptDetails().add(studentReceiptdetail);
                            this.studentPartialPaymentReceiptDetailDAO.update(studentPartialPaymentReceiptDetail);
                        }
                    }
                    ++i;
                }
            } else if (discountType.equals("flat")) {
                Double alreadyPaidTotalAmount;
                StudentPartialPaymentReceiptDetail studentPartialPaymentReceiptDetail;
                StudentInvoiceDetail studentInvoiceDetail;
                Double partialAmount;
                Long invoiceDetailId;
                if (normalFeesItem != null) {
                    i = 0;
                    while (i < normalFeesItem.length) {
                        invoiceDetailId = normalFeesItem[i];
                        partialAmount = partialFeesItemAmounts[i];
                        studentInvoiceDetail = this.studentInvoiceDetailDAO.getStudentInvoiceDetailById(invoiceDetailId);
                        if (this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail) == null) {
                            StudentReceiptDetail studentReceiptdetail;
                            if ((double)Math.round(partialAmount) == (double)Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())) {
                                studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), false, null, null, 0.0, Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), receivedDate, paymentStatus, createdBy, modifiedBy);
                                receipt.getReceiptDetails().add(studentReceiptdetail);
                                studentInvoiceDetail.setStudentInvoiceElementPaymentStatus(0);
                                this.studentInvoiceDetailDAO.update(studentInvoiceDetail);
                            } else {
                                studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), false, null, null, 0.0, Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), Double.valueOf(Math.round(partialAmount)), receivedDate, paymentStatus, createdBy, modifiedBy);
                                StudentPartialPaymentReceiptDetail studentPartialPaymentReceiptDetail2 = new StudentPartialPaymentReceiptDetail(studentInvoice.getAcademicYear(), studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), false, null, null, 0.0, Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), Double.valueOf(Math.round(partialAmount)), receivedDate, paymentStatus, createdBy, modifiedBy);
                                receipt.getReceiptDetails().add(studentReceiptdetail);
                                this.studentPartialPaymentReceiptDetailDAO.save(studentPartialPaymentReceiptDetail2);
                            }
                        } else {
                            StudentReceiptDetail studentReceiptdetail;
                            studentPartialPaymentReceiptDetail = this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail);
                            alreadyPaidTotalAmount = studentPartialPaymentReceiptDetail.getPaidReceiptAmount() + studentPartialPaymentReceiptDetail.getDiscountAmount();
                            if ((double)Math.round(partialAmount + alreadyPaidTotalAmount) == (double)Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())) {
                                studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), false, null, null, 0.0, Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), Double.valueOf(Math.round(partialAmount)), receivedDate, paymentStatus, createdBy, modifiedBy);
                                receipt.getReceiptDetails().add(studentReceiptdetail);
                                studentInvoiceDetail.setStudentInvoiceElementPaymentStatus(0);
                                studentPartialPaymentReceiptDetail.setPaidReceiptAmount(studentInvoiceDetail.getStudentInvoiceElementTotalAmount());
                                this.studentInvoiceDetailDAO.update(studentInvoiceDetail);
                                this.studentPartialPaymentReceiptDetailDAO.update(studentPartialPaymentReceiptDetail);
                            } else {
                                studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), false, null, null, 0.0, Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), Double.valueOf(Math.round(partialAmount)), receivedDate, paymentStatus, createdBy, modifiedBy);
                                studentPartialPaymentReceiptDetail.setPaidReceiptAmount(partialAmount + studentPartialPaymentReceiptDetail.getPaidReceiptAmount());
                                studentPartialPaymentReceiptDetail.setModifiedBy(modifiedBy);
                                receipt.getReceiptDetails().add(studentReceiptdetail);
                                this.studentPartialPaymentReceiptDetailDAO.update(studentPartialPaymentReceiptDetail);
                            }
                        }
                        ++i;
                    }
                }
                i = 0;
                while (i < flatDiscountFeesItems.length) {
                    invoiceDetailId = flatDiscountFeesItems[i];
                    partialAmount = partialFeesItemAmounts[i];
                    studentInvoiceDetail = this.studentInvoiceDetailDAO.getStudentInvoiceDetailById(invoiceDetailId);
                    if (this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail) == null) {
                        Double actualAmount;
                        Double discountAmount = flatDiscountFeesItemAmount[i];
                        Long roundDiscountAmount = Math.round(discountAmount);
                        discountAmount = (double)roundDiscountAmount;
                        if ((double)Math.round(partialAmount + discountAmount) == (double)Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())) {
                            Double paidAmount = actualAmount = Double.valueOf(studentInvoiceDetail.getStudentInvoiceElementTotalAmount());
                            StudentReceiptDetail studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), true, discountType, null, Double.valueOf(Math.round(discountAmount)), Double.valueOf(Math.round(actualAmount)), Double.valueOf(Math.round(paidAmount + discountAmount)), receivedDate, paymentStatus, createdBy, modifiedBy);
                            receipt.getReceiptDetails().add(studentReceiptdetail);
                            studentInvoiceDetail.setStudentInvoiceElementPaymentStatus(0);
                            this.studentInvoiceDetailDAO.update(studentInvoiceDetail);
                        } else {
                            actualAmount = studentInvoiceDetail.getStudentInvoiceElementTotalAmount();
                            StudentReceiptDetail studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), true, discountType, null, Double.valueOf(Math.round(discountAmount)), Double.valueOf(Math.round(actualAmount)), Double.valueOf(Math.round(partialAmount)), receivedDate, paymentStatus, createdBy, modifiedBy);
                            StudentPartialPaymentReceiptDetail studentPartialPaymentReceiptDetail3 = new StudentPartialPaymentReceiptDetail(studentInvoice.getAcademicYear(), studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), true, discountType, null, Double.valueOf(Math.round(discountAmount)), Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), Double.valueOf(Math.round(partialAmount)), receivedDate, paymentStatus, createdBy, modifiedBy);
                            receipt.getReceiptDetails().add(studentReceiptdetail);
                            this.studentPartialPaymentReceiptDetailDAO.save(studentPartialPaymentReceiptDetail3);
                        }
                    } else {
                        StudentReceiptDetail studentReceiptdetail;
                        Double actualAmount;
                        studentPartialPaymentReceiptDetail = this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail);
                        alreadyPaidTotalAmount = studentPartialPaymentReceiptDetail.getPaidReceiptAmount() + studentPartialPaymentReceiptDetail.getDiscountAmount();
                        Double discountAmount = flatDiscountFeesItemAmount[i];
                        Long roundDiscountAmount = Math.round(discountAmount);
                        discountAmount = (double)roundDiscountAmount;
                        if ((double)Math.round(partialAmount + alreadyPaidTotalAmount + discountAmount) == (double)Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())) {
                            actualAmount = studentInvoiceDetail.getStudentInvoiceElementTotalAmount();
                            studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), true, discountType, null, Double.valueOf(Math.round(discountAmount)), Double.valueOf(Math.round(actualAmount)), Double.valueOf(Math.round(partialAmount)), receivedDate, paymentStatus, createdBy, modifiedBy);
                            receipt.getReceiptDetails().add(studentReceiptdetail);
                            studentInvoiceDetail.setStudentInvoiceElementPaymentStatus(0);
                            studentPartialPaymentReceiptDetail.setPaidReceiptAmount(studentInvoiceDetail.getStudentInvoiceElementTotalAmount());
                            studentPartialPaymentReceiptDetail.setDiscountAmount(discountAmount + studentPartialPaymentReceiptDetail.getDiscountAmount());
                            this.studentInvoiceDetailDAO.update(studentInvoiceDetail);
                            this.studentPartialPaymentReceiptDetailDAO.update(studentPartialPaymentReceiptDetail);
                        } else {
                            actualAmount = studentInvoiceDetail.getStudentInvoiceElementTotalAmount();
                            studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), true, discountType, null, Double.valueOf(Math.round(discountAmount)), Double.valueOf(Math.round(actualAmount)), Double.valueOf(Math.round(partialAmount)), receivedDate, paymentStatus, createdBy, modifiedBy);
                            studentPartialPaymentReceiptDetail.setPaidReceiptAmount(partialAmount + studentPartialPaymentReceiptDetail.getPaidReceiptAmount());
                            studentPartialPaymentReceiptDetail.setModifiedBy(modifiedBy);
                            studentPartialPaymentReceiptDetail.setDiscountAmount(discountAmount + studentPartialPaymentReceiptDetail.getDiscountAmount());
                            receipt.getReceiptDetails().add(studentReceiptdetail);
                            this.studentPartialPaymentReceiptDetailDAO.update(studentPartialPaymentReceiptDetail);
                        }
                    }
                    ++i;
                }
            }
            studentInvoice.setDiscountApplicable(false);
        }
        if (fineAmount > 0.0) {
            fineAmount = Math.round(fineAmount);
            receipt.getReceiptFines().add(new StudentReceiptFine(studentInvoice.getAcademicYear(), receipt, fineAmount, receivedDate, createdBy, modifiedBy));
        }
        StudentReceipt persistedReceipt = this.studentReceiptDAO.save(receipt);
        if (this.checkForInvoiceClosing(studentInvoice)) {
            studentInvoice.setInvoiceStatus(0);
            this.studentInvoiceDAO.update(studentInvoice);
        }
        persistedReceiptNo = persistedReceipt.getReceiptId();
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
            StudentReceipt receipt = new StudentReceipt(studentInvoice.getInstitution(), studentInvoice.getAcademicYear(), paymentMode, chequeReceivedDate, Double.valueOf(Math.round(totalAmountPaid)), studentInvoice.getStudent(), paymentStatus, chequeNo, chequeDate, chequeBankName, chequeBranchName, narration, createdBy, modifiedBy, studentInvoice);
            if (!isdiscountApplied) {
                i = 0;
                while (i < normalFeesItem.length) {
                    Long invoiceDetailId = normalFeesItem[i];
                    Double partialAmount = partialFeesItemAmounts[i];
                    StudentInvoiceDetail studentInvoiceDetail = this.studentInvoiceDetailDAO.getStudentInvoiceDetailById(invoiceDetailId);
                    if (this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail) == null) {
                        StudentReceiptDetail studentReceiptdetail;
                        if ((double)Math.round(partialAmount) == (double)Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())) {
                            studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), false, null, null, 0.0, Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), chequeReceivedDate, paymentStatus, createdBy, modifiedBy);
                            receipt.getReceiptDetails().add(studentReceiptdetail);
                            studentInvoiceDetail.setStudentInvoiceElementPaymentStatus(0);
                            this.studentInvoiceDetailDAO.update(studentInvoiceDetail);
                        } else {
                            studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), false, null, null, 0.0, Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), Double.valueOf(Math.round(partialAmount)), chequeReceivedDate, paymentStatus, createdBy, modifiedBy);
                            StudentPartialPaymentReceiptDetail studentPartialPaymentReceiptDetail = new StudentPartialPaymentReceiptDetail(studentInvoice.getAcademicYear(), studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), false, null, null, 0.0, Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), Double.valueOf(Math.round(partialAmount)), chequeReceivedDate, paymentStatus, createdBy, modifiedBy);
                            receipt.getReceiptDetails().add(studentReceiptdetail);
                            this.studentPartialPaymentReceiptDetailDAO.save(studentPartialPaymentReceiptDetail);
                        }
                    } else {
                        StudentReceiptDetail studentReceiptdetail;
                        StudentPartialPaymentReceiptDetail studentPartialPaymentReceiptDetail = this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail);
                        Double alreadyPaidTotalAmount = studentPartialPaymentReceiptDetail.getPaidReceiptAmount() + studentPartialPaymentReceiptDetail.getDiscountAmount();
                        if ((double)Math.round(partialAmount + alreadyPaidTotalAmount) == (double)Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())) {
                            studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), false, null, null, 0.0, Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), Double.valueOf(Math.round(partialAmount)), chequeReceivedDate, paymentStatus, createdBy, modifiedBy);
                            receipt.getReceiptDetails().add(studentReceiptdetail);
                            studentInvoiceDetail.setStudentInvoiceElementPaymentStatus(0);
                            studentPartialPaymentReceiptDetail.setPaidReceiptAmount(studentInvoiceDetail.getStudentInvoiceElementTotalAmount());
                            this.studentInvoiceDetailDAO.update(studentInvoiceDetail);
                            this.studentPartialPaymentReceiptDetailDAO.update(studentPartialPaymentReceiptDetail);
                        } else {
                            studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), false, null, null, 0.0, Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), Double.valueOf(Math.round(partialAmount)), chequeReceivedDate, paymentStatus, createdBy, modifiedBy);
                            studentPartialPaymentReceiptDetail.setPaidReceiptAmount(partialAmount + studentPartialPaymentReceiptDetail.getPaidReceiptAmount());
                            studentPartialPaymentReceiptDetail.setModifiedBy(modifiedBy);
                            receipt.getReceiptDetails().add(studentReceiptdetail);
                            this.studentPartialPaymentReceiptDetailDAO.update(studentPartialPaymentReceiptDetail);
                        }
                    }
                    ++i;
                }
            } else {
                if (discountType.equals("percentage")) {
                    i = 0;
                    while (i < normalFeesItem.length) {
                        Long invoiceDetailId = normalFeesItem[i];
                        StudentInvoiceDetail studentInvoiceDetail = this.studentInvoiceDetailDAO.getStudentInvoiceDetailById(invoiceDetailId);
                        Double partialAmount = partialFeesItemAmounts[i];
                        if (this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail) == null) {
                            StudentReceiptDetail studentReceiptdetail;
                            Double discountAmount = this.calculatePercentageDiscountAmount(invoiceDetailId, discountPercentage);
                            Long roundDiscountAmount = Math.round(discountAmount);
                            discountAmount = (double)roundDiscountAmount;
                            Double actualAmount = studentInvoiceDetail.getStudentInvoiceElementTotalAmount();
                            Double paidAmount = partialAmount;
                            if (actualAmount - (paidAmount + discountAmount) < 0.0) {
                                throw new ReceiptException(new Message("failure", "Please Enter Valid Percentage..!"));
                            }
                            if ((double)Math.round(partialAmount + discountAmount) == (double)Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())) {
                                studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), true, discountType, discountPercentage.toString(), Double.valueOf(Math.round(discountAmount)), Double.valueOf(Math.round(actualAmount)), Double.valueOf(Math.round(partialAmount)), chequeReceivedDate, paymentStatus, createdBy, modifiedBy);
                                receipt.getReceiptDetails().add(studentReceiptdetail);
                                studentInvoiceDetail.setStudentInvoiceElementPaymentStatus(0);
                                this.studentInvoiceDetailDAO.update(studentInvoiceDetail);
                            } else {
                                studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), true, discountType, discountPercentage.toString(), Double.valueOf(Math.round(discountAmount)), Double.valueOf(Math.round(actualAmount)), Double.valueOf(Math.round(partialAmount)), chequeReceivedDate, paymentStatus, createdBy, modifiedBy);
                                StudentPartialPaymentReceiptDetail studentPartialPaymentReceiptDetail = new StudentPartialPaymentReceiptDetail(studentInvoice.getAcademicYear(), studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), true, discountType, discountPercentage.toString(), Double.valueOf(Math.round(discountAmount)), Double.valueOf(Math.round(actualAmount)), Double.valueOf(Math.round(partialAmount)), chequeReceivedDate, paymentStatus, createdBy, modifiedBy);
                                receipt.getReceiptDetails().add(studentReceiptdetail);
                                this.studentPartialPaymentReceiptDetailDAO.save(studentPartialPaymentReceiptDetail);
                            }
                        } else {
                            StudentReceiptDetail studentReceiptdetail;
                            StudentPartialPaymentReceiptDetail studentPartialPaymentReceiptDetail = this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail);
                            Double alreadyPaidTotalAmount = studentPartialPaymentReceiptDetail.getPaidReceiptAmount() + studentPartialPaymentReceiptDetail.getDiscountAmount();
                            Double discountAmount = this.calculatePercentageDiscountAmount(invoiceDetailId, discountPercentage);
                            Long roundDiscountAmount = Math.round(discountAmount);
                            discountAmount = (double)roundDiscountAmount;
                            Double actualAmount = studentInvoiceDetail.getStudentInvoiceElementTotalAmount();
                            Double paidAmount = partialAmount;
                            if (actualAmount - (paidAmount + discountAmount + alreadyPaidTotalAmount) < 0.0) {
                                throw new ReceiptException(new Message("failure", "Please Enter Valid Percentage..!"));
                            }
                            if ((double)Math.round(partialAmount + alreadyPaidTotalAmount + discountAmount) == (double)Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())) {
                                studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), true, discountType, discountPercentage.toString(), Double.valueOf(Math.round(discountAmount)), Double.valueOf(Math.round(actualAmount)), Double.valueOf(Math.round(partialAmount)), chequeReceivedDate, paymentStatus, createdBy, modifiedBy);
                                receipt.getReceiptDetails().add(studentReceiptdetail);
                                studentInvoiceDetail.setStudentInvoiceElementPaymentStatus(0);
                                studentPartialPaymentReceiptDetail.setPaidReceiptAmount(studentInvoiceDetail.getStudentInvoiceElementTotalAmount());
                                this.studentInvoiceDetailDAO.update(studentInvoiceDetail);
                                this.studentPartialPaymentReceiptDetailDAO.update(studentPartialPaymentReceiptDetail);
                            } else {
                                studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), true, discountType, discountPercentage.toString(), Double.valueOf(Math.round(discountAmount)), Double.valueOf(Math.round(actualAmount)), Double.valueOf(Math.round(partialAmount)), chequeReceivedDate, paymentStatus, createdBy, modifiedBy);
                                studentPartialPaymentReceiptDetail.setPaidReceiptAmount(partialAmount + studentPartialPaymentReceiptDetail.getPaidReceiptAmount());
                                studentPartialPaymentReceiptDetail.setModifiedBy(modifiedBy);
                                studentPartialPaymentReceiptDetail.setDiscountAmount(discountAmount + studentPartialPaymentReceiptDetail.getDiscountAmount());
                                receipt.getReceiptDetails().add(studentReceiptdetail);
                                this.studentPartialPaymentReceiptDetailDAO.update(studentPartialPaymentReceiptDetail);
                            }
                        }
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
                            if (this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail) == null) {
                                StudentReceiptDetail studentReceiptdetail;
                                if ((double)Math.round(partialAmount) == (double)Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())) {
                                    studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), false, null, null, 0.0, Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), chequeReceivedDate, paymentStatus, createdBy, modifiedBy);
                                    receipt.getReceiptDetails().add(studentReceiptdetail);
                                    studentInvoiceDetail.setStudentInvoiceElementPaymentStatus(0);
                                    this.studentInvoiceDetailDAO.update(studentInvoiceDetail);
                                } else {
                                    studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), false, null, null, 0.0, Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), Double.valueOf(Math.round(partialAmount)), chequeReceivedDate, paymentStatus, createdBy, modifiedBy);
                                    StudentPartialPaymentReceiptDetail studentPartialPaymentReceiptDetail = new StudentPartialPaymentReceiptDetail(studentInvoice.getAcademicYear(), studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), false, null, null, 0.0, Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), Double.valueOf(Math.round(partialAmount)), chequeReceivedDate, paymentStatus, createdBy, modifiedBy);
                                    receipt.getReceiptDetails().add(studentReceiptdetail);
                                    this.studentPartialPaymentReceiptDetailDAO.save(studentPartialPaymentReceiptDetail);
                                }
                            } else {
                                StudentReceiptDetail studentReceiptdetail;
                                StudentPartialPaymentReceiptDetail studentPartialPaymentReceiptDetail = this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail);
                                Double alreadyPaidTotalAmount = studentPartialPaymentReceiptDetail.getPaidReceiptAmount() + studentPartialPaymentReceiptDetail.getDiscountAmount();
                                if ((double)Math.round(partialAmount + alreadyPaidTotalAmount) == (double)Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())) {
                                    studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), false, null, null, 0.0, Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), Double.valueOf(Math.round(partialAmount)), chequeReceivedDate, paymentStatus, createdBy, modifiedBy);
                                    receipt.getReceiptDetails().add(studentReceiptdetail);
                                    studentInvoiceDetail.setStudentInvoiceElementPaymentStatus(0);
                                    studentPartialPaymentReceiptDetail.setPaidReceiptAmount(studentInvoiceDetail.getStudentInvoiceElementTotalAmount());
                                    this.studentInvoiceDetailDAO.update(studentInvoiceDetail);
                                    this.studentPartialPaymentReceiptDetailDAO.update(studentPartialPaymentReceiptDetail);
                                } else {
                                    studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), false, null, null, 0.0, Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), Double.valueOf(Math.round(partialAmount)), chequeReceivedDate, paymentStatus, createdBy, modifiedBy);
                                    studentPartialPaymentReceiptDetail.setPaidReceiptAmount(partialAmount + studentPartialPaymentReceiptDetail.getPaidReceiptAmount());
                                    studentPartialPaymentReceiptDetail.setModifiedBy(modifiedBy);
                                    receipt.getReceiptDetails().add(studentReceiptdetail);
                                    this.studentPartialPaymentReceiptDetailDAO.update(studentPartialPaymentReceiptDetail);
                                }
                            }
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
                        if (this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail) == null) {
                            StudentReceiptDetail studentReceiptdetail;
                            Double actualAmount;
                            if ((double)Math.round(partialAmount + discountAmount) == (double)Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())) {
                                actualAmount = studentInvoiceDetail.getStudentInvoiceElementTotalAmount();
                                studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), true, discountType, null, Double.valueOf(Math.round(discountAmount)), Double.valueOf(Math.round(actualAmount)), Double.valueOf(Math.round(partialAmount)), chequeReceivedDate, paymentStatus, createdBy, modifiedBy);
                                receipt.getReceiptDetails().add(studentReceiptdetail);
                                studentInvoiceDetail.setStudentInvoiceElementPaymentStatus(0);
                                this.studentInvoiceDetailDAO.update(studentInvoiceDetail);
                            } else {
                                actualAmount = studentInvoiceDetail.getStudentInvoiceElementTotalAmount();
                                studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), true, discountType, null, Double.valueOf(Math.round(discountAmount)), Double.valueOf(Math.round(actualAmount)), Double.valueOf(Math.round(partialAmount)), chequeReceivedDate, paymentStatus, createdBy, modifiedBy);
                                StudentPartialPaymentReceiptDetail studentPartialPaymentReceiptDetail = new StudentPartialPaymentReceiptDetail(studentInvoice.getAcademicYear(), studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), true, discountType, null, Double.valueOf(Math.round(discountAmount)), Double.valueOf(Math.round(actualAmount)), Double.valueOf(Math.round(partialAmount)), chequeReceivedDate, paymentStatus, createdBy, modifiedBy);
                                receipt.getReceiptDetails().add(studentReceiptdetail);
                                this.studentPartialPaymentReceiptDetailDAO.save(studentPartialPaymentReceiptDetail);
                            }
                        } else {
                            StudentReceiptDetail studentReceiptdetail;
                            Double actualAmount;
                            StudentPartialPaymentReceiptDetail studentPartialPaymentReceiptDetail = this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail);
                            Double alreadyPaidTotalAmount = studentPartialPaymentReceiptDetail.getPaidReceiptAmount() + studentPartialPaymentReceiptDetail.getDiscountAmount();
                            if ((double)Math.round(partialAmount + alreadyPaidTotalAmount + discountAmount) == (double)Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())) {
                                actualAmount = studentInvoiceDetail.getStudentInvoiceElementTotalAmount();
                                studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), true, discountType, null, Double.valueOf(Math.round(discountAmount)), Double.valueOf(Math.round(actualAmount)), Double.valueOf(Math.round(partialAmount)), chequeReceivedDate, paymentStatus, createdBy, modifiedBy);
                                receipt.getReceiptDetails().add(studentReceiptdetail);
                                studentInvoiceDetail.setStudentInvoiceElementPaymentStatus(0);
                                studentPartialPaymentReceiptDetail.setPaidReceiptAmount(studentInvoiceDetail.getStudentInvoiceElementTotalAmount());
                                studentPartialPaymentReceiptDetail.setDiscountAmount(discountAmount + studentPartialPaymentReceiptDetail.getDiscountAmount());
                                this.studentInvoiceDetailDAO.update(studentInvoiceDetail);
                                this.studentPartialPaymentReceiptDetailDAO.update(studentPartialPaymentReceiptDetail);
                            } else {
                                actualAmount = studentInvoiceDetail.getStudentInvoiceElementTotalAmount();
                                studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), true, discountType, null, Double.valueOf(Math.round(discountAmount)), Double.valueOf(Math.round(actualAmount)), Double.valueOf(Math.round(partialAmount)), chequeReceivedDate, paymentStatus, createdBy, modifiedBy);
                                studentPartialPaymentReceiptDetail.setPaidReceiptAmount(partialAmount + studentPartialPaymentReceiptDetail.getPaidReceiptAmount());
                                studentPartialPaymentReceiptDetail.setModifiedBy(modifiedBy);
                                studentPartialPaymentReceiptDetail.setDiscountAmount(discountAmount + studentPartialPaymentReceiptDetail.getDiscountAmount());
                                receipt.getReceiptDetails().add(studentReceiptdetail);
                                this.studentPartialPaymentReceiptDetailDAO.update(studentPartialPaymentReceiptDetail);
                            }
                        }
                        ++i;
                    }
                }
                studentInvoice.setDiscountApplicable(false);
            }
            if (fineAmount > 0.0) {
                fineAmount = Math.round(fineAmount);
                receipt.getReceiptFines().add(new StudentReceiptFine(studentInvoice.getAcademicYear(), receipt, fineAmount, chequeReceivedDate, createdBy, modifiedBy));
            }
            StudentReceipt persistedReceipt = this.studentReceiptDAO.save(receipt);
            if (this.checkForInvoiceClosing(studentInvoice)) {
                studentInvoice.setInvoiceStatus(0);
                this.studentInvoiceDAO.update(studentInvoice);
            }
            persistedReceiptNo = persistedReceipt.getReceiptId();
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
            StudentReceipt receipt = new StudentReceipt(studentInvoice.getInstitution(), studentInvoice.getAcademicYear(), paymentMode, Double.valueOf(Math.round(totalAmountPaid)), studentInvoice.getStudent(), paymentStatus, ddNo, ddDate, ddBankName, ddBranchName, ddReceivedDate, narration, createdBy, modifiedBy, studentInvoice);
            if (!isdiscountApplied) {
                i = 0;
                while (i < normalFeesItem.length) {
                    Double partialAmount = partialFeesItemAmounts[i];
                    Long invoiceDetailId = normalFeesItem[i];
                    StudentInvoiceDetail studentInvoiceDetail = this.studentInvoiceDetailDAO.getStudentInvoiceDetailById(invoiceDetailId);
                    if (this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail) == null) {
                        StudentReceiptDetail studentReceiptdetail;
                        if ((double)Math.round(partialAmount) == (double)Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())) {
                            studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), false, null, null, 0.0, Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), ddReceivedDate, paymentStatus, createdBy, modifiedBy);
                            receipt.getReceiptDetails().add(studentReceiptdetail);
                            studentInvoiceDetail.setStudentInvoiceElementPaymentStatus(0);
                            this.studentInvoiceDetailDAO.update(studentInvoiceDetail);
                        } else {
                            studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), false, null, null, 0.0, Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), Double.valueOf(Math.round(partialAmount)), ddReceivedDate, paymentStatus, createdBy, modifiedBy);
                            StudentPartialPaymentReceiptDetail studentPartialPaymentReceiptDetail = new StudentPartialPaymentReceiptDetail(studentInvoice.getAcademicYear(), studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), false, null, null, 0.0, Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), Double.valueOf(Math.round(partialAmount)), ddReceivedDate, paymentStatus, createdBy, modifiedBy);
                            receipt.getReceiptDetails().add(studentReceiptdetail);
                            this.studentPartialPaymentReceiptDetailDAO.save(studentPartialPaymentReceiptDetail);
                        }
                    } else {
                        StudentReceiptDetail studentReceiptdetail;
                        StudentPartialPaymentReceiptDetail studentPartialPaymentReceiptDetail = this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail);
                        Double alreadyPaidTotalAmount = studentPartialPaymentReceiptDetail.getPaidReceiptAmount() + studentPartialPaymentReceiptDetail.getDiscountAmount();
                        if ((double)Math.round(partialAmount + alreadyPaidTotalAmount) == (double)Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())) {
                            studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), false, null, null, 0.0, Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), Double.valueOf(Math.round(partialAmount)), ddReceivedDate, paymentStatus, createdBy, modifiedBy);
                            receipt.getReceiptDetails().add(studentReceiptdetail);
                            studentInvoiceDetail.setStudentInvoiceElementPaymentStatus(0);
                            studentPartialPaymentReceiptDetail.setPaidReceiptAmount(studentInvoiceDetail.getStudentInvoiceElementTotalAmount());
                            this.studentInvoiceDetailDAO.update(studentInvoiceDetail);
                            this.studentPartialPaymentReceiptDetailDAO.update(studentPartialPaymentReceiptDetail);
                        } else {
                            studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), false, null, null, 0.0, Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), Double.valueOf(Math.round(partialAmount)), ddReceivedDate, paymentStatus, createdBy, modifiedBy);
                            studentPartialPaymentReceiptDetail.setPaidReceiptAmount(partialAmount + studentPartialPaymentReceiptDetail.getPaidReceiptAmount());
                            studentPartialPaymentReceiptDetail.setModifiedBy(modifiedBy);
                            receipt.getReceiptDetails().add(studentReceiptdetail);
                            this.studentPartialPaymentReceiptDetailDAO.update(studentPartialPaymentReceiptDetail);
                        }
                    }
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
                        if (this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail) == null) {
                            StudentReceiptDetail studentReceiptdetail;
                            Double paidAmount = partialAmount;
                            if (actualAmount - (paidAmount + discountAmount) < 0.0) {
                                throw new ReceiptException(new Message("failure", "Please Enter Valid Percentage..!"));
                            }
                            if ((double)Math.round(partialAmount + discountAmount) == (double)Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())) {
                                studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), true, discountType, discountPercentage.toString(), Double.valueOf(Math.round(discountAmount)), Double.valueOf(Math.round(actualAmount)), Double.valueOf(Math.round(partialAmount)), ddReceivedDate, paymentStatus, createdBy, modifiedBy);
                                receipt.getReceiptDetails().add(studentReceiptdetail);
                                studentInvoiceDetail.setStudentInvoiceElementPaymentStatus(0);
                                this.studentInvoiceDetailDAO.update(studentInvoiceDetail);
                            } else {
                                studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), true, discountType, discountPercentage.toString(), Double.valueOf(Math.round(discountAmount)), Double.valueOf(Math.round(actualAmount)), Double.valueOf(Math.round(partialAmount)), ddReceivedDate, paymentStatus, createdBy, modifiedBy);
                                StudentPartialPaymentReceiptDetail studentPartialPaymentReceiptDetail = new StudentPartialPaymentReceiptDetail(studentInvoice.getAcademicYear(), studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), true, discountType, discountPercentage.toString(), Double.valueOf(Math.round(discountAmount)), Double.valueOf(Math.round(actualAmount)), Double.valueOf(Math.round(partialAmount)), ddReceivedDate, paymentStatus, createdBy, modifiedBy);
                                receipt.getReceiptDetails().add(studentReceiptdetail);
                                this.studentPartialPaymentReceiptDetailDAO.save(studentPartialPaymentReceiptDetail);
                            }
                        } else {
                            StudentReceiptDetail studentReceiptdetail;
                            StudentPartialPaymentReceiptDetail studentPartialPaymentReceiptDetail = this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail);
                            Double alreadyPaidTotalAmount = studentPartialPaymentReceiptDetail.getPaidReceiptAmount() + studentPartialPaymentReceiptDetail.getDiscountAmount();
                            Double paidAmount = partialAmount;
                            if (actualAmount - (paidAmount + discountAmount + alreadyPaidTotalAmount) < 0.0) {
                                throw new ReceiptException(new Message("failure", "Please Enter Valid Percentage..!"));
                            }
                            if ((double)Math.round(partialAmount + alreadyPaidTotalAmount + discountAmount) == (double)Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())) {
                                studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), true, discountType, discountPercentage.toString(), Double.valueOf(Math.round(discountAmount)), Double.valueOf(Math.round(actualAmount)), Double.valueOf(Math.round(partialAmount)), ddReceivedDate, paymentStatus, createdBy, modifiedBy);
                                receipt.getReceiptDetails().add(studentReceiptdetail);
                                studentInvoiceDetail.setStudentInvoiceElementPaymentStatus(0);
                                studentPartialPaymentReceiptDetail.setPaidReceiptAmount(studentInvoiceDetail.getStudentInvoiceElementTotalAmount());
                                this.studentInvoiceDetailDAO.update(studentInvoiceDetail);
                                this.studentPartialPaymentReceiptDetailDAO.update(studentPartialPaymentReceiptDetail);
                            } else {
                                studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), true, discountType, discountPercentage.toString(), Double.valueOf(Math.round(discountAmount)), Double.valueOf(Math.round(actualAmount)), Double.valueOf(Math.round(partialAmount)), ddReceivedDate, paymentStatus, createdBy, modifiedBy);
                                studentPartialPaymentReceiptDetail.setPaidReceiptAmount(partialAmount + studentPartialPaymentReceiptDetail.getPaidReceiptAmount());
                                studentPartialPaymentReceiptDetail.setModifiedBy(modifiedBy);
                                studentPartialPaymentReceiptDetail.setDiscountAmount(discountAmount + studentPartialPaymentReceiptDetail.getDiscountAmount());
                                receipt.getReceiptDetails().add(studentReceiptdetail);
                                this.studentPartialPaymentReceiptDetailDAO.update(studentPartialPaymentReceiptDetail);
                            }
                        }
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
                            if (this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail) == null) {
                                StudentReceiptDetail studentReceiptdetail;
                                if ((double)Math.round(partialAmount) == (double)Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())) {
                                    studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), false, null, null, 0.0, Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), Double.valueOf(Math.round(partialAmount)), ddReceivedDate, paymentStatus, createdBy, modifiedBy);
                                    receipt.getReceiptDetails().add(studentReceiptdetail);
                                    studentInvoiceDetail.setStudentInvoiceElementPaymentStatus(0);
                                    this.studentInvoiceDetailDAO.update(studentInvoiceDetail);
                                } else {
                                    studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), false, null, null, 0.0, Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), Double.valueOf(Math.round(partialAmount)), ddReceivedDate, paymentStatus, createdBy, modifiedBy);
                                    StudentPartialPaymentReceiptDetail studentPartialPaymentReceiptDetail = new StudentPartialPaymentReceiptDetail(studentInvoice.getAcademicYear(), studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), false, null, null, 0.0, Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), Double.valueOf(Math.round(partialAmount)), ddReceivedDate, paymentStatus, createdBy, modifiedBy);
                                    receipt.getReceiptDetails().add(studentReceiptdetail);
                                    this.studentPartialPaymentReceiptDetailDAO.save(studentPartialPaymentReceiptDetail);
                                }
                            } else {
                                StudentReceiptDetail studentReceiptdetail;
                                StudentPartialPaymentReceiptDetail studentPartialPaymentReceiptDetail = this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail);
                                Double alreadyPaidTotalAmount = studentPartialPaymentReceiptDetail.getPaidReceiptAmount() + studentPartialPaymentReceiptDetail.getDiscountAmount();
                                if ((double)Math.round(partialAmount + alreadyPaidTotalAmount) == (double)Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())) {
                                    studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), false, null, null, 0.0, Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), Double.valueOf(Math.round(partialAmount)), ddReceivedDate, paymentStatus, createdBy, modifiedBy);
                                    receipt.getReceiptDetails().add(studentReceiptdetail);
                                    studentInvoiceDetail.setStudentInvoiceElementPaymentStatus(0);
                                    studentPartialPaymentReceiptDetail.setPaidReceiptAmount(studentInvoiceDetail.getStudentInvoiceElementTotalAmount());
                                    this.studentInvoiceDetailDAO.update(studentInvoiceDetail);
                                    this.studentPartialPaymentReceiptDetailDAO.update(studentPartialPaymentReceiptDetail);
                                } else {
                                    studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), false, null, null, 0.0, Double.valueOf(Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())), Double.valueOf(Math.round(partialAmount)), ddReceivedDate, paymentStatus, createdBy, modifiedBy);
                                    studentPartialPaymentReceiptDetail.setPaidReceiptAmount(partialAmount + studentPartialPaymentReceiptDetail.getPaidReceiptAmount());
                                    studentPartialPaymentReceiptDetail.setModifiedBy(modifiedBy);
                                    receipt.getReceiptDetails().add(studentReceiptdetail);
                                    this.studentPartialPaymentReceiptDetailDAO.update(studentPartialPaymentReceiptDetail);
                                }
                            }
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
                        if (this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail) == null) {
                            StudentReceiptDetail studentReceiptdetail;
                            Double actualAmount;
                            if ((double)Math.round(partialAmount + discountAmount) == (double)Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())) {
                                actualAmount = studentInvoiceDetail.getStudentInvoiceElementTotalAmount();
                                studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), true, discountType, null, Double.valueOf(Math.round(discountAmount)), Double.valueOf(Math.round(actualAmount)), Double.valueOf(Math.round(partialAmount)), ddReceivedDate, paymentStatus, createdBy, modifiedBy);
                                receipt.getReceiptDetails().add(studentReceiptdetail);
                                studentInvoiceDetail.setStudentInvoiceElementPaymentStatus(0);
                                this.studentInvoiceDetailDAO.update(studentInvoiceDetail);
                            } else {
                                actualAmount = studentInvoiceDetail.getStudentInvoiceElementTotalAmount();
                                studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), true, discountType, null, Double.valueOf(Math.round(discountAmount)), Double.valueOf(Math.round(actualAmount)), Double.valueOf(Math.round(partialAmount)), ddReceivedDate, paymentStatus, createdBy, modifiedBy);
                                StudentPartialPaymentReceiptDetail studentPartialPaymentReceiptDetail = new StudentPartialPaymentReceiptDetail(studentInvoice.getAcademicYear(), studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), true, discountType, null, Double.valueOf(Math.round(discountAmount)), Double.valueOf(Math.round(actualAmount)), Double.valueOf(Math.round(partialAmount)), ddReceivedDate, paymentStatus, createdBy, modifiedBy);
                                receipt.getReceiptDetails().add(studentReceiptdetail);
                                this.studentPartialPaymentReceiptDetailDAO.save(studentPartialPaymentReceiptDetail);
                            }
                        } else {
                            StudentReceiptDetail studentReceiptdetail;
                            Double actualAmount;
                            StudentPartialPaymentReceiptDetail studentPartialPaymentReceiptDetail = this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail);
                            Double alreadyPaidTotalAmount = studentPartialPaymentReceiptDetail.getPaidReceiptAmount() + studentPartialPaymentReceiptDetail.getDiscountAmount();
                            if ((double)Math.round(partialAmount + alreadyPaidTotalAmount + discountAmount) == (double)Math.round(studentInvoiceDetail.getStudentInvoiceElementTotalAmount())) {
                                actualAmount = studentInvoiceDetail.getStudentInvoiceElementTotalAmount();
                                studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), true, discountType, null, Double.valueOf(Math.round(discountAmount)), Double.valueOf(Math.round(actualAmount)), Double.valueOf(Math.round(partialAmount)), ddReceivedDate, paymentStatus, createdBy, modifiedBy);
                                receipt.getReceiptDetails().add(studentReceiptdetail);
                                studentInvoiceDetail.setStudentInvoiceElementPaymentStatus(0);
                                studentPartialPaymentReceiptDetail.setPaidReceiptAmount(studentInvoiceDetail.getStudentInvoiceElementTotalAmount());
                                studentPartialPaymentReceiptDetail.setDiscountAmount(discountAmount + studentPartialPaymentReceiptDetail.getDiscountAmount());
                                this.studentInvoiceDetailDAO.update(studentInvoiceDetail);
                                this.studentPartialPaymentReceiptDetailDAO.update(studentPartialPaymentReceiptDetail);
                            } else {
                                actualAmount = studentInvoiceDetail.getStudentInvoiceElementTotalAmount();
                                studentReceiptdetail = new StudentReceiptDetail(studentInvoice.getAcademicYear(), receipt, studentInvoiceDetail, studentInvoiceDetail.getFeesItem(), true, discountType, null, Double.valueOf(Math.round(discountAmount)), Double.valueOf(Math.round(actualAmount)), Double.valueOf(Math.round(partialAmount)), ddReceivedDate, paymentStatus, createdBy, modifiedBy);
                                studentPartialPaymentReceiptDetail.setPaidReceiptAmount(partialAmount + studentPartialPaymentReceiptDetail.getPaidReceiptAmount());
                                studentPartialPaymentReceiptDetail.setModifiedBy(modifiedBy);
                                studentPartialPaymentReceiptDetail.setDiscountAmount(discountAmount + studentPartialPaymentReceiptDetail.getDiscountAmount());
                                receipt.getReceiptDetails().add(studentReceiptdetail);
                                this.studentPartialPaymentReceiptDetailDAO.update(studentPartialPaymentReceiptDetail);
                            }
                        }
                        ++i;
                    }
                }
                studentInvoice.setDiscountApplicable(false);
            }
            if (fineAmount > 0.0) {
                fineAmount = Math.round(fineAmount);
                receipt.getReceiptFines().add(new StudentReceiptFine(studentInvoice.getAcademicYear(), receipt, fineAmount, ddReceivedDate, createdBy, modifiedBy));
            }
            StudentReceipt persistedReceipt = this.studentReceiptDAO.save(receipt);
            if (this.checkForInvoiceClosing(studentInvoice)) {
                studentInvoice.setInvoiceStatus(0);
                this.studentInvoiceDAO.update(studentInvoice);
            }
            persistedReceiptNo = persistedReceipt.getReceiptId();
            return persistedReceiptNo;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public StudentReceipt receiptById(Long receiptId) throws Exception {
        try {
            StudentReceipt studentReceipt = this.studentReceiptDAO.getStudentReceiptById(receiptId);
            Hibernate.initialize((Object)studentReceipt);
            Hibernate.initialize((Object)studentReceipt.getStudent());
            return studentReceipt;
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

    @Override
    public Long amountTobeCollectedForRefund(Long[] normalFeesItemId) {
        Double totalAmount = 0.0;
        int i = 0;
        while (i < normalFeesItemId.length) {
            Long feesItemId = normalFeesItemId[i];
            StudentInvoiceDetail studentInvoiceDetail = this.studentInvoiceDetailDAO.getStudentInvoiceDetailById(feesItemId);
            totalAmount = totalAmount + studentInvoiceDetail.getStudentInvoiceElementTotalAmount();
            ++i;
        }
        return Math.round(totalAmount);
    }
}
