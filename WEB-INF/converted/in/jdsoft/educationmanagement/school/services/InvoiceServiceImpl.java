/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.Hibernate
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.dao.DataIntegrityViolationException
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.components.SMSHandler;
import in.jdsoft.educationmanagement.school.dao.AcademicYearDAO;
import in.jdsoft.educationmanagement.school.dao.ClassDAO;
import in.jdsoft.educationmanagement.school.dao.FeesItemDAO;
import in.jdsoft.educationmanagement.school.dao.FeesStructureDAO;
import in.jdsoft.educationmanagement.school.dao.FeesTermDAO;
import in.jdsoft.educationmanagement.school.dao.InstitutionDAO;
import in.jdsoft.educationmanagement.school.dao.StudentDAO;
import in.jdsoft.educationmanagement.school.dao.StudentInvoiceDAO;
import in.jdsoft.educationmanagement.school.dao.StudentInvoiceDetailDAO;
import in.jdsoft.educationmanagement.school.dao.StudentPartialPaymentReceiptDetailDAO;
import in.jdsoft.educationmanagement.school.dao.StudentReceiptDAO;
import in.jdsoft.educationmanagement.school.dao.StudentStatusDAO;
import in.jdsoft.educationmanagement.school.exceptions.StudentInvoiceException;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.Class;
import in.jdsoft.educationmanagement.school.model.FeesItem;
import in.jdsoft.educationmanagement.school.model.FeesPenaltySetting;
import in.jdsoft.educationmanagement.school.model.FeesStructure;
import in.jdsoft.educationmanagement.school.model.FeesTerm;
import in.jdsoft.educationmanagement.school.model.FeesTermAndFeesItems;
import in.jdsoft.educationmanagement.school.model.FeesTermAndFeesStructure;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.Section;
import in.jdsoft.educationmanagement.school.model.SpecialCategory;
import in.jdsoft.educationmanagement.school.model.Student;
import in.jdsoft.educationmanagement.school.model.StudentInvoice;
import in.jdsoft.educationmanagement.school.model.StudentInvoiceDetail;
import in.jdsoft.educationmanagement.school.model.StudentPartialPaymentReceiptDetail;
import in.jdsoft.educationmanagement.school.model.StudentStatus;
import in.jdsoft.educationmanagement.school.model.User;
import in.jdsoft.educationmanagement.school.reports.model.ThreeFieldReports;
import in.jdsoft.educationmanagement.school.reports.model.TwoFieldReport;
import in.jdsoft.educationmanagement.school.services.InvoiceService;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service(value="invoiceService")
public class InvoiceServiceImpl
implements InvoiceService {
    @Autowired
    StudentInvoiceDAO studentInvoiceDAO;
    @Autowired
    StudentDAO studentDAO;
    @Autowired
    StudentInvoiceDetailDAO studentInvoiceDetailDAO;
    @Autowired
    InstitutionDAO institutionDAO;
    @Autowired
    AcademicYearDAO academicYearDAO;
    @Autowired
    FeesStructureDAO feesStructureDAO;
    @Autowired
    FeesTermDAO feesTermDAO;
    @Autowired
    FeesItemDAO feesItemDAO;
    @Autowired
    StudentStatusDAO studentStatusDAO;
    @Autowired
    private ClassDAO classDAO;
    @Autowired
    private StudentPartialPaymentReceiptDetailDAO studentPartialPaymentReceiptDetailDAO;
    @Autowired
    private StudentReceiptDAO studentReceiptDAO;
    @Autowired
    private SMSHandler smsHandler;

    @Override
    public void generateInvoice(Long[] studentIds, ArrayList<FeesTermAndFeesStructure> feesTermsAndStructure, AcademicYear academicYear, String createdBy, Institution institution) throws Exception {
        try {
            LinkedHashSet<User> addUser = new LinkedHashSet<User>();
            String currentUserMobile = "";
            Long[] longArray = studentIds;
            int n = studentIds.length;
            int n2 = 0;
            while (n2 < n) {
                Long studentId = longArray[n2];
                Student student = this.studentDAO.getStudentById(studentId);
                Hibernate.initialize((Object)student.getUser());
                Hibernate.initialize((Object)student.getParentUser());
                currentUserMobile = String.valueOf(currentUserMobile) + "91" + student.getContact() + "," + "91" + student.getParentContact() + ",";
                addUser.add(student.getUser());
                addUser.add(student.getParentUser());
                for (FeesTermAndFeesStructure feesTermAndFeesStructure : feesTermsAndStructure) {
                    FeesStructure feesTemplate = this.feesStructureDAO.getFeesStructureById(feesTermAndFeesStructure.getFeesStructureId());
                    FeesTerm feesTerm = this.feesTermDAO.getFeesTermById(feesTermAndFeesStructure.getFeesTermId());
                    StudentInvoice studentInvoice = new StudentInvoice(student, academicYear, feesTerm, 1, createdBy, createdBy, institution, true);
                    double invoiceAmount = 0.0;
                    Set<FeesItem> feesItems = feesTemplate.getFeesItems();
                    for (FeesItem feesItem : feesItems) {
                        invoiceAmount += feesItem.getFeesItemPrice();
                        invoiceAmount = Math.round(invoiceAmount);
                        StudentInvoiceDetail studentInvoiceDetail = new StudentInvoiceDetail(academicYear, studentInvoice, feesItem, feesItem.getFeesItemPrice(), 0.0, 1, studentInvoice.getCreatedBy(), studentInvoice.getModifiedBy());
                        studentInvoice.getStudentInvoiceDetails().add(studentInvoiceDetail);
                    }
                    studentInvoice.setInvoiceAmount(invoiceAmount);
                    StudentInvoice studentInvoiceNo = this.studentInvoiceDAO.save(studentInvoice);
                    String invoiceNo = studentInvoiceNo.getStudentInvoiceId().toString();
                    studentInvoiceNo.setInvoiceNo(invoiceNo);
                    this.studentInvoiceDAO.update(studentInvoiceNo);
                }
                ++n2;
            }
            if (addUser.size() > 0) {
                String[] userMailIds = new String[addUser.size()];
                int i = 0;
                for (User user : addUser) {
                    userMailIds[i] = user.getEmail();
                    ++i;
                }
                Date d = new Date();
                d.setTime(d.getTime() + 2592000000L);
                currentUserMobile = currentUserMobile.trim();
                currentUserMobile = currentUserMobile.substring(0, currentUserMobile.length() - 1);
                this.smsHandler.sentSMS(currentUserMobile, "Please pay your fees before " + d, institution.getInstitutionId());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void generateInvoiceForFeesTermAndFeesItems(Long[] studentIds, ArrayList<FeesTermAndFeesItems> feesTermsAndFeesItems, AcademicYear academicYear, String createdBy, Institution institution, Long dueDays, FeesPenaltySetting feesPenaltySetting) throws Exception {
        try {
            LinkedHashSet<User> addUser = new LinkedHashSet<User>();
            String currentUserMobile = "";
            Long[] longArray = studentIds;
            int n = studentIds.length;
            int n2 = 0;
            while (n2 < n) {
                Long studentId = longArray[n2];
                Student student = this.studentDAO.getStudentById(studentId);
                Hibernate.initialize((Object)student.getUser());
                Hibernate.initialize((Object)student.getParentUser());
                addUser.add(student.getUser());
                addUser.add(student.getParentUser());
                currentUserMobile = String.valueOf(currentUserMobile) + "91" + student.getContact() + "," + "91" + student.getParentContact() + ",";
                for (FeesTermAndFeesItems feesTermAndFeesItem : feesTermsAndFeesItems) {
                    FeesTerm feesTerm = this.feesTermDAO.getFeesTermById(feesTermAndFeesItem.getFeesTermId());
                    StudentInvoice studentInvoice = new StudentInvoice(student, academicYear, feesTerm, 1, createdBy, createdBy, institution, true, dueDays, feesPenaltySetting);
                    double invoiceAmount = 0.0;
                    for (FeesItem feesItem : feesTermAndFeesItem.getFeesItems()) {
                        invoiceAmount += feesItem.getFeesItemPrice();
                        invoiceAmount = Math.round(invoiceAmount);
                        StudentInvoiceDetail studentInvoiceDetail = new StudentInvoiceDetail(academicYear, studentInvoice, feesItem, feesItem.getFeesItemPrice(), 0.0, 1, studentInvoice.getCreatedBy(), studentInvoice.getModifiedBy(), dueDays, feesPenaltySetting);
                        studentInvoice.getStudentInvoiceDetails().add(studentInvoiceDetail);
                    }
                    studentInvoice.setInvoiceAmount(invoiceAmount);
                    StudentInvoice studentInvoiceNo = this.studentInvoiceDAO.save(studentInvoice);
                    String invoiceNo = studentInvoiceNo.getStudentInvoiceId().toString();
                    studentInvoiceNo.setInvoiceNo(invoiceNo);
                    this.studentInvoiceDAO.update(studentInvoiceNo);
                }
                ++n2;
            }
            if (addUser.size() > 0) {
                String[] userMailIds = new String[addUser.size()];
                int i = 0;
                for (User user : addUser) {
                    userMailIds[i] = user.getEmail();
                    ++i;
                }
                Date d = new Date();
                d.setTime(d.getTime() + 2592000000L);
                currentUserMobile = currentUserMobile.trim();
                currentUserMobile = currentUserMobile.substring(0, currentUserMobile.length() - 1);
                this.smsHandler.sentSMS(currentUserMobile, "Please pay your fees before " + d, institution.getInstitutionId());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<StudentInvoice> getStudentPendingInvoices(String admissionNo) {
        Student student = this.studentDAO.getStudentByAdmissionNo(admissionNo);
        ArrayList<StudentInvoice> students = this.studentInvoiceDAO.getStudentPendingInvoices(student);
        for (StudentInvoice studentInvoice : students) {
            Hibernate.initialize(studentInvoice.getStudentInvoiceDetails());
            Hibernate.initialize((Object)studentInvoice.getAcademicYear());
            Hibernate.initialize((Object)studentInvoice.getStudent().getStudentClass());
            Hibernate.initialize((Object)studentInvoice.getStudent().getSection());
            Hibernate.initialize((Object)studentInvoice.getFeesTerm());
            LinkedHashSet<StudentInvoiceDetail> studentInvoiceDetails = new LinkedHashSet<StudentInvoiceDetail>();
            for (StudentInvoiceDetail studentInvoiceDetail : studentInvoice.getStudentInvoiceDetails()) {
                Hibernate.initialize((Object)studentInvoiceDetail.getStudentPartialPaymentReceiptDetail());
                if (this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail) != null) {
                    StudentPartialPaymentReceiptDetail studentPartialPaymentReceiptDetail = this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail);
                    studentInvoiceDetail.setStudentPartialPaymentReceiptDetail(studentPartialPaymentReceiptDetail);
                }
                studentInvoiceDetails.add(studentInvoiceDetail);
            }
            studentInvoice.setStudentInvoiceDetails(studentInvoiceDetails);
        }
        return students;
    }

    @Override
    public ArrayList<StudentInvoice> getStudentPendingInvoices(Long studentId) {
        Student student = this.studentDAO.getStudentById(studentId);
        ArrayList<StudentInvoice> students = this.studentInvoiceDAO.getStudentPendingInvoices(student);
        for (StudentInvoice studentInvoice : students) {
            Hibernate.initialize(studentInvoice.getStudentInvoiceDetails());
            Hibernate.initialize((Object)studentInvoice.getAcademicYear());
            Hibernate.initialize((Object)studentInvoice.getStudent().getStudentClass());
            Hibernate.initialize((Object)studentInvoice.getStudent().getSection());
            Hibernate.initialize((Object)studentInvoice.getFeesTerm());
            LinkedHashSet<StudentInvoiceDetail> studentInvoiceDetails = new LinkedHashSet<StudentInvoiceDetail>();
            for (StudentInvoiceDetail studentInvoiceDetail : studentInvoice.getStudentInvoiceDetails()) {
                if (this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail) != null) {
                    StudentPartialPaymentReceiptDetail studentPartialPaymentReceiptDetail = this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail);
                    studentInvoiceDetail.setStudentPartialPaymentReceiptDetail(studentPartialPaymentReceiptDetail);
                }
                studentInvoiceDetails.add(studentInvoiceDetail);
            }
            studentInvoice.setStudentInvoiceDetails(studentInvoiceDetails);
        }
        return students;
    }

    @Override
    public ArrayList<StudentInvoiceDetail> getStudentPendingInvoiceFeesItems(Long invoiceId) {
        StudentInvoice studentInvoice = this.studentInvoiceDAO.getStudentInvoiceById(invoiceId);
        ArrayList<StudentInvoiceDetail> studentInvoiceDetails = this.studentInvoiceDetailDAO.getStudentPendingInvoiceFeesItemsByStudentIvoice(studentInvoice);
        for (StudentInvoiceDetail studentInvoiceDetail : studentInvoiceDetails) {
            Hibernate.initialize((Object)studentInvoiceDetail.getFeesItem());
            if (this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail) == null) continue;
            StudentPartialPaymentReceiptDetail studentPartialPaymentReceiptDetail = this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail);
            studentInvoiceDetail.setStudentPartialPaymentReceiptDetail(studentPartialPaymentReceiptDetail);
        }
        return studentInvoiceDetails;
    }

    @Override
    public ArrayList<StudentInvoice> getAllStudentInvoices(AcademicYear academicYear, Class clazz, Section section) {
        ArrayList students = (ArrayList)this.studentDAO.getStudentsByClassAndSection(clazz, section);
        ArrayList<StudentInvoice> studentInvoices = new ArrayList<StudentInvoice>();
        for (Student student : students) {
            ArrayList studentInvoices1 = (ArrayList)this.studentInvoiceDAO.getAllStudentInvoices(academicYear, student);
            for (StudentInvoice studentInvoice : studentInvoices1) {
                Hibernate.initialize((Object)studentInvoice.getAcademicYear());
                Hibernate.initialize((Object)studentInvoice.getFeesTerm());
                Hibernate.initialize(studentInvoice.getStudentInvoiceDetails());
                Hibernate.initialize((Object)studentInvoice.getStudent().getStudentClass());
                Hibernate.initialize((Object)studentInvoice.getStudent().getSection());
            }
            studentInvoices.addAll(studentInvoices1);
        }
        return studentInvoices;
    }

    @Override
    public ArrayList<StudentInvoice> getAllStudentsInvoices(AcademicYear academicYear, Institution institution) {
        ArrayList studentInvoices = (ArrayList)this.studentInvoiceDAO.getAllStudentsInvoices(academicYear, institution);
        for (StudentInvoice studentInvoice : studentInvoices) {
            Hibernate.initialize((Object)studentInvoice.getAcademicYear());
            Hibernate.initialize((Object)studentInvoice.getFeesTerm());
            Hibernate.initialize(studentInvoice.getStudentInvoiceDetails());
            Hibernate.initialize((Object)studentInvoice.getStudent());
            Hibernate.initialize((Object)studentInvoice.getStudent().getStudentClass());
            Hibernate.initialize((Object)studentInvoice.getStudent().getSection());
        }
        return studentInvoices;
    }

    @Override
    public ArrayList<StudentInvoice> getStudentsInvoiceBySpecialCategory(AcademicYear academicYear, SpecialCategory specialCategory, Institution institution) {
        ArrayList studentInvoices = (ArrayList)this.studentInvoiceDAO.getAllStudentsInvoices(academicYear, institution);
        Iterator studentInvoicesIterator = studentInvoices.iterator();
        while (studentInvoicesIterator.hasNext()) {
            StudentInvoice studentInvoice = (StudentInvoice)studentInvoicesIterator.next();
            if (studentInvoice.getStudent().getSpecialCategories().contains(specialCategory)) continue;
            studentInvoicesIterator.remove();
        }
        for (StudentInvoice studentInvoice : studentInvoices) {
            Hibernate.initialize((Object)studentInvoice.getAcademicYear());
            Hibernate.initialize((Object)studentInvoice.getFeesTerm());
            Hibernate.initialize(studentInvoice.getStudentInvoiceDetails());
            Hibernate.initialize((Object)studentInvoice.getStudent());
            Hibernate.initialize((Object)studentInvoice.getStudent().getStudentClass());
            Hibernate.initialize((Object)studentInvoice.getStudent().getSection());
        }
        return studentInvoices;
    }

    @Override
    public ArrayList<StudentInvoice> getStudentInvoicesBySpecialCategory(AcademicYear academicYear, Class clazz, Section section, SpecialCategory specialCategory) {
        ArrayList students = (ArrayList)this.studentDAO.getStudentsByClassSectionAndSpecialCategory(clazz, section, specialCategory);
        ArrayList<StudentInvoice> studentInvoices = new ArrayList<StudentInvoice>();
        for (Student student : students) {
            ArrayList studentInvoices1 = (ArrayList)this.studentInvoiceDAO.getAllStudentInvoices(academicYear, student);
            for (StudentInvoice studentInvoice : studentInvoices1) {
                Hibernate.initialize((Object)studentInvoice.getAcademicYear());
                Hibernate.initialize((Object)studentInvoice.getFeesTerm());
                Hibernate.initialize(studentInvoice.getStudentInvoiceDetails());
                Hibernate.initialize((Object)studentInvoice.getStudent().getStudentClass());
                Hibernate.initialize((Object)studentInvoice.getStudent().getSection());
            }
            studentInvoices.addAll(studentInvoices1);
        }
        return studentInvoices;
    }

    @Override
    public ArrayList<StudentInvoice> getStudentInvoicesByAdmisssionNoAndAcademicYear(String admissionNo, AcademicYear academicYear) throws StudentInvoiceException {
        try {
            ArrayList<StudentInvoice> studentInvoices = new ArrayList<StudentInvoice>();
            Set<StudentInvoice> studentInvoices1 = this.studentDAO.getStudentByAdmissionNo(admissionNo).getInvoices();
            Iterator<StudentInvoice> invoiceIterator = studentInvoices1.iterator();
            while (invoiceIterator.hasNext()) {
                StudentInvoice studentInvoice = invoiceIterator.next();
                if (studentInvoice.getAcademicYear().getAcademicYearId() == academicYear.getAcademicYearId()) continue;
                invoiceIterator.remove();
            }
            for (StudentInvoice studentInvoice : studentInvoices1) {
                Hibernate.initialize((Object)studentInvoice.getAcademicYear());
                Hibernate.initialize((Object)studentInvoice.getFeesTerm());
                Hibernate.initialize(studentInvoice.getStudentInvoiceDetails());
                Hibernate.initialize((Object)studentInvoice.getStudent());
                Hibernate.initialize((Object)studentInvoice.getStudent().getStudentClass());
                Hibernate.initialize((Object)studentInvoice.getStudent().getSection());
            }
            studentInvoices.addAll(studentInvoices1);
            return studentInvoices;
        }
        catch (Exception e) {
            if (e.getClass().equals(NullPointerException.class)) {
                throw new StudentInvoiceException(new Message("errorMessage", "Admission Number Not Found"));
            }
            throw e;
        }
    }

    @Override
    public ArrayList<StudentInvoice> getStudentInvoicesFromIds(Long[] studentInvoiceIds) {
        ArrayList<StudentInvoice> studentInvoices = new ArrayList<StudentInvoice>();
        int i = 0;
        while (i < studentInvoiceIds.length) {
            studentInvoices.add(this.studentInvoiceDAO.getStudentInvoiceById(studentInvoiceIds[i]));
            ++i;
        }
        for (StudentInvoice studentInvoice : studentInvoices) {
            Hibernate.initialize((Object)studentInvoice.getAcademicYear());
        }
        return studentInvoices;
    }

    @Override
    public StudentInvoice getStudentInvoiceDetails(Long invoiceId) throws StudentInvoiceException {
        try {
            StudentInvoice studentInvoice = this.studentInvoiceDAO.getStudentInvoiceById(invoiceId);
            Hibernate.initialize(studentInvoice.getStudentInvoiceDetails());
            Set<StudentInvoiceDetail> studentInvoicedetails = studentInvoice.getStudentInvoiceDetails();
            for (StudentInvoiceDetail studentInvoiceDetail : studentInvoicedetails) {
                Hibernate.initialize((Object)studentInvoiceDetail.getFeesItem());
            }
            Hibernate.initialize(studentInvoice.getStudent().getSpecialCategories());
            Hibernate.initialize((Object)studentInvoice.getStudent().getStudentClass());
            Hibernate.initialize((Object)studentInvoice.getStudent().getSection());
            Hibernate.initialize((Object)studentInvoice.getInstitution());
            Hibernate.initialize((Object)studentInvoice.getFeesTerm().getFeesTermName());
            Hibernate.initialize((Object)studentInvoice.getAcademicYear().getAcademicYearTitle());
            Hibernate.initialize((Object)studentInvoice.getStudent().getInstitution());
            return studentInvoice;
        }
        catch (Exception e) {
            if (e.getClass().equals(NullPointerException.class)) {
                throw new StudentInvoiceException(new Message("errorMessage", "Invoice Not Found!"));
            }
            throw e;
        }
    }

    @Override
    public void deleteStudentInvoicesByAcademicYear(Long[] studentIds, Long academicYearId) throws StudentInvoiceException {
        try {
            AcademicYear academicYear = this.academicYearDAO.getAcademicYearById(academicYearId);
            Long[] longArray = studentIds;
            int n = studentIds.length;
            int n2 = 0;
            while (n2 < n) {
                Long studentId = longArray[n2];
                Student student = this.studentDAO.getStudentById(studentId);
                List<StudentInvoice> studentInvoices = this.studentInvoiceDAO.getStudentInvoicesByAcademicYear(student, academicYear);
                if (studentInvoices != null) {
                    for (StudentInvoice studentInvoice : studentInvoices) {
                        if (studentInvoice.getInvoiceStatus() != 0) continue;
                        throw new StudentInvoiceException(new Message("failure", "Cannot delete Invoices ! First Delete Receipts After Can Delete Invoices with admission no : " + studentInvoice.getStudent().getAdmissionNo()));
                    }
                    for (StudentInvoice studentInvoice : studentInvoices) {
                        this.studentInvoiceDAO.delete(studentInvoice);
                    }
                }
                ++n2;
            }
        }
        catch (Exception e) {
            if (e.getClass().equals(DataIntegrityViolationException.class)) {
                throw new StudentInvoiceException(new Message("failure", "Cannot Delete Invoices ! First Delete Receipts After Can Delete Invoices "));
            }
            throw e;
        }
    }

    @Override
    public boolean invoiceValidation(Long[] invoiceIds, Long institutionId) {
        Institution institution = this.institutionDAO.getInstitutionById(institutionId);
        boolean valid = true;
        boolean failure = false;
        if (institution.isCollectReceiptsInOrder()) {
            StudentInvoice studentInvoice = this.studentInvoiceDAO.getStudentInvoiceById(invoiceIds[0]);
            Student student = studentInvoice.getStudent();
            Set<StudentInvoice> studentInvoiceSet = student.getInvoices();
            Iterator<StudentInvoice> studentInvoices = studentInvoiceSet.iterator();
            while (studentInvoices.hasNext()) {
                StudentInvoice studentInvoice1 = studentInvoices.next();
                if (studentInvoice1.getInvoiceStatus() != 0) continue;
                studentInvoices.remove();
            }
            for (StudentInvoice studentInvoice2 : studentInvoiceSet) {
                Long[] longArray = invoiceIds;
                int n = invoiceIds.length;
                int n2 = 0;
                while (n2 < n) {
                    Long invoiceId = longArray[n2];
                    Long currentInvoiceId = studentInvoice2.getStudentInvoiceId();
                    if (currentInvoiceId <= invoiceId) {
                        Long[] longArray2 = invoiceIds;
                        int n3 = invoiceIds.length;
                        int n4 = 0;
                        while (n4 < n3) {
                            Long invoiceId1 = longArray2[n4];
                            if (invoiceId1 == currentInvoiceId) {
                                valid = true;
                                break;
                            }
                            valid = false;
                            ++n4;
                        }
                    }
                    if (!valid) {
                        failure = true;
                        break;
                    }
                    ++n2;
                }
                if (failure) break;
            }
            return valid;
        }
        return valid;
    }

    @Override
    public ArrayList<StudentInvoice> getStudentInvoicesByDate(Date fromDate, Date toDate, Institution institution) {
        List<StudentInvoice> studentInvoices = this.studentInvoiceDAO.getStudentInvoicesForDueRange(fromDate, toDate, institution);
        for (StudentInvoice studentInvoice : studentInvoices) {
            Hibernate.initialize((Object)studentInvoice.getAcademicYear());
            Hibernate.initialize((Object)studentInvoice.getFeesTerm());
            Hibernate.initialize(studentInvoice.getStudentInvoiceDetails());
            Hibernate.initialize((Object)studentInvoice.getStudent());
            Hibernate.initialize((Object)studentInvoice.getStudent().getStudentClass());
            Hibernate.initialize((Object)studentInvoice.getStudent().getSection());
        }
        return (ArrayList)studentInvoices;
    }

    @Override
    public List<StudentInvoice> studentInvoicesForFeesCategoryReport(Long academicYearId, Long feesTermId, Long institutionId, Integer invoiceStatus) {
        List<StudentInvoice> invoices = null;
        Institution institution = this.institutionDAO.getInstitutionById(institutionId);
        AcademicYear academicYear = this.academicYearDAO.getAcademicYearById(academicYearId);
        FeesTerm feesTerm = this.feesTermDAO.getFeesTermById(feesTermId);
        invoices = this.studentInvoiceDAO.getStudentInvoicesForReporting(institution, feesTerm, academicYear, invoiceStatus);
        for (StudentInvoice studentInvoice : invoices) {
            Hibernate.initialize((Object)studentInvoice.getStudent().getStudentClass());
            Hibernate.initialize((Object)studentInvoice.getStudent().getSection());
            Hibernate.initialize((Object)studentInvoice.getFeesTerm());
            Hibernate.initialize(studentInvoice.getStudentInvoiceDetails());
        }
        return invoices;
    }

    @Override
    public Set<Student> studentsByPartiallyAndFullyForFeesCategoryReport(Long academicYearId, Long feesTermId, Long institutionId) {
        List<StudentInvoice> invoices = null;
        LinkedHashSet<Student> addStudents = new LinkedHashSet<Student>();
        Institution institution = this.institutionDAO.getInstitutionById(institutionId);
        AcademicYear academicYear = this.academicYearDAO.getAcademicYearById(academicYearId);
        FeesTerm feesTerm = this.feesTermDAO.getFeesTermById(feesTermId);
        invoices = this.studentInvoiceDAO.getStudentInvoicesByPartiallyAndFullyForReporting(institution, feesTerm, academicYear);
        for (StudentInvoice studentInvoice : invoices) {
            if (this.studentReceiptDAO.getStudentReceiptListByStudentInvoice(studentInvoice).isEmpty()) continue;
            Hibernate.initialize((Object)studentInvoice.getStudent());
            Hibernate.initialize((Object)studentInvoice.getStudent().getStudentClass());
            Hibernate.initialize((Object)studentInvoice.getStudent().getSection());
            Hibernate.initialize((Object)studentInvoice.getFeesTerm());
            Hibernate.initialize(studentInvoice.getStudentInvoiceDetails());
            if (addStudents.contains(studentInvoice.getStudent())) continue;
            addStudents.add(studentInvoice.getStudent());
        }
        return addStudents;
    }

    @Override
    public Set<Student> studentsByPartiallyAndFullyForFeesCategoryReportAllInstitution(Long academicYearId, Long feesTermId) {
        List<StudentInvoice> invoices = null;
        LinkedHashSet<Student> addStudents = new LinkedHashSet<Student>();
        AcademicYear academicYear = this.academicYearDAO.getAcademicYearById(academicYearId);
        FeesTerm feesTerm = this.feesTermDAO.getFeesTermById(feesTermId);
        invoices = this.studentInvoiceDAO.getStudentInvoicesByPartiallyAndFullyForReporting(feesTerm, academicYear);
        for (StudentInvoice studentInvoice : invoices) {
            if (this.studentReceiptDAO.getStudentReceiptListByStudentInvoice(studentInvoice).isEmpty()) continue;
            Hibernate.initialize((Object)studentInvoice.getStudent());
            Hibernate.initialize((Object)studentInvoice.getStudent().getStudentClass());
            Hibernate.initialize((Object)studentInvoice.getStudent().getSection());
            Hibernate.initialize((Object)studentInvoice.getFeesTerm());
            Hibernate.initialize(studentInvoice.getStudentInvoiceDetails());
            if (addStudents.contains(studentInvoice.getStudent())) continue;
            addStudents.add(studentInvoice.getStudent());
        }
        return addStudents;
    }

    @Override
    public List<StudentInvoice> studentInvoicesForFeesCategoryReportByDateRange(Date fromDate, Date toDate, Long feesTermId, Long institutionId, Integer invoiceStatus) {
        List<StudentInvoice> invoices = null;
        Institution institution = this.institutionDAO.getInstitutionById(institutionId);
        FeesTerm feesTerm = this.feesTermDAO.getFeesTermById(feesTermId);
        invoices = this.studentInvoiceDAO.getStudentInvoicesForReportingByDateRange(fromDate, toDate, institution, feesTerm, invoiceStatus);
        for (StudentInvoice studentInvoice : invoices) {
            Hibernate.initialize((Object)studentInvoice.getStudent().getStudentClass());
            Hibernate.initialize((Object)studentInvoice.getStudent().getSection());
            Hibernate.initialize((Object)studentInvoice.getFeesTerm());
            Hibernate.initialize(studentInvoice.getStudentInvoiceDetails());
        }
        return invoices;
    }

    @Override
    public List<StudentInvoice> studentInvoicesForFeesCategoryReportAllTerms(Long academicYearId, Long institutionId, Integer invoiceStatus) {
        List<StudentInvoice> invoices = null;
        Institution institution = this.institutionDAO.getInstitutionById(institutionId);
        AcademicYear academicYear = this.academicYearDAO.getAcademicYearById(academicYearId);
        invoices = this.studentInvoiceDAO.getStudentInvoicesForReportingInAllTerms(institution, academicYear, invoiceStatus);
        for (StudentInvoice studentInvoice : invoices) {
            Hibernate.initialize((Object)studentInvoice.getStudent().getStudentClass());
            Hibernate.initialize((Object)studentInvoice.getFeesTerm());
            Hibernate.initialize((Object)studentInvoice.getStudent().getSection());
            Hibernate.initialize(studentInvoice.getStudentInvoiceDetails());
        }
        return invoices;
    }

    @Override
    public List<StudentInvoice> studentInvoicesForFeesCategoryReportAllTermsByDateRange(Date fromDate, Date toDate, Long institutionId, Integer invoiceStatus) {
        List<StudentInvoice> invoices = null;
        Institution institution = this.institutionDAO.getInstitutionById(institutionId);
        invoices = this.studentInvoiceDAO.getStudentInvoicesForReportingInAllTermsByDateRange(fromDate, toDate, institution, invoiceStatus);
        for (StudentInvoice studentInvoice : invoices) {
            Hibernate.initialize((Object)studentInvoice.getStudent().getStudentClass());
            Hibernate.initialize((Object)studentInvoice.getFeesTerm());
            Hibernate.initialize((Object)studentInvoice.getStudent().getSection());
            Hibernate.initialize(studentInvoice.getStudentInvoiceDetails());
        }
        return invoices;
    }

    @Override
    public List<StudentInvoiceDetail> studentInvoicesForFeesItemReport(Long academicYearId, Long feesItemId, Long institutionId, Integer invoiceDetailStatus) {
        FeesItem feesItem;
        List<StudentInvoiceDetail> invoiceDetail = null;
        Institution institution = this.institutionDAO.getInstitutionById(institutionId);
        AcademicYear academicYear = this.academicYearDAO.getAcademicYearById(academicYearId);
        invoiceDetail = this.studentInvoiceDetailDAO.getStudentInvoiceDetailForFeesItemReport(academicYear, feesItem = this.feesItemDAO.getFeesItemById(feesItemId), institution, invoiceDetailStatus);
        if (invoiceDetail != null) {
            for (StudentInvoiceDetail studentInvoiceDetail : invoiceDetail) {
                Hibernate.initialize((Object)studentInvoiceDetail.getStudentInvoice().getStudent().getStudentClass());
                Hibernate.initialize((Object)studentInvoiceDetail.getStudentInvoice().getStudent().getSection());
                Hibernate.initialize((Object)studentInvoiceDetail.getStudentInvoice().getFeesTerm());
            }
        }
        return invoiceDetail;
    }

    @Override
    public List<StudentInvoiceDetail> studentInvoicesForFeesItemReportByDateRange(Date fromDate, Date toDate, Long feesItemId, Long institutionId, Integer invoiceDetailStatus) {
        List<StudentInvoiceDetail> invoiceDetail = null;
        Institution institution = this.institutionDAO.getInstitutionById(institutionId);
        FeesItem feesItem = this.feesItemDAO.getFeesItemById(feesItemId);
        invoiceDetail = this.studentInvoiceDetailDAO.getStudentInvoiceDetailForFeesItemReportByDateRange(fromDate, toDate, feesItem, institution, invoiceDetailStatus);
        if (invoiceDetail != null) {
            for (StudentInvoiceDetail studentInvoiceDetail : invoiceDetail) {
                Hibernate.initialize((Object)studentInvoiceDetail.getStudentInvoice().getStudent().getStudentClass());
                Hibernate.initialize((Object)studentInvoiceDetail.getStudentInvoice().getStudent().getSection());
                Hibernate.initialize((Object)studentInvoiceDetail.getStudentInvoice().getFeesTerm());
            }
        }
        return invoiceDetail;
    }

    @Override
    public TwoFieldReport pendingAndPaidStudentCountByAcademicYearAndInstitution(AcademicYear activeAcademicYear, Long institutionId, Integer invoiceStatus) {
        List<Object> paidinvoice = new ArrayList();
        AcademicYear academicYear = this.academicYearDAO.getAcademicYearById(activeAcademicYear.getAcademicYearId());
        Hibernate.initialize((Object)academicYear.getInstitution());
        Institution institution = this.institutionDAO.getInstitutionById(institutionId);
        Long paidStudentCount = 0L;
        Long pendingStudentCount = 0L;
        Long studentCount = 0L;
        for (Student student : this.studentDAO.getList()) {
            boolean checkinvoice = true;
            paidinvoice = this.studentInvoiceDAO.getStudentInvoicesForReporting(student, institution, academicYear);
            if (paidinvoice != null && !paidinvoice.isEmpty()) {
                studentCount = studentCount + 1L;
                for (StudentInvoice studentInvoice : paidinvoice) {
                    if (studentInvoice.getInvoiceStatus() != 1) continue;
                    checkinvoice = false;
                }
            } else {
                checkinvoice = false;
            }
            if (!checkinvoice) continue;
            paidStudentCount = paidStudentCount + 1L;
        }
        TwoFieldReport twoFieldReport = null;
        if (!this.studentInvoiceDAO.getStudentInvoicesForReportingByAcademicYear(academicYear, institution).isEmpty()) {
            pendingStudentCount = studentCount - paidStudentCount;
            twoFieldReport = new TwoFieldReport(paidStudentCount, pendingStudentCount);
        }
        return twoFieldReport;
    }

    @Override
    public List<ThreeFieldReports> pendingAndPaidStudentCountByAllAcademicYear(Long institutionId, Integer invoiceStatus) {
        List<Object> invoice = new ArrayList();
        ArrayList<ThreeFieldReports> threeFieldReports = new ArrayList<ThreeFieldReports>();
        Institution institution = this.institutionDAO.getInstitutionById(institutionId);
        Long studentCount = 0L;
        Long paidStudentCount = 0L;
        Long pendingStudentCount = 0L;
        StudentStatus studentStatus = this.studentStatusDAO.getStudentStatusById(1L);
        if (this.studentDAO.getStudentsByStatus(institution, studentStatus) != null) {
            studentCount = this.studentDAO.getStudentsByInstitution(institution).size();
        }
        Hibernate.initialize(institution.getAcademicYears());
        for (AcademicYear currentAcademicYear : institution.getAcademicYears()) {
            AcademicYear academicYear = this.academicYearDAO.getAcademicYearById(currentAcademicYear.getAcademicYearId());
            invoice = this.studentInvoiceDAO.getStudentInvoicesForReportingInAllTerms(institution, academicYear, invoiceStatus);
            if (invoice != null) {
                pendingStudentCount = studentCount - Long.valueOf(invoice.size());
                paidStudentCount = invoice.size();
            }
            ThreeFieldReports threeFieldReport = new ThreeFieldReports(academicYear.getAcademicYearTitle(), paidStudentCount, pendingStudentCount);
            threeFieldReports.add(threeFieldReport);
        }
        return threeFieldReports;
    }

    @Override
    public List<ThreeFieldReports> pendingAndPaidStudentCountByAllClass(AcademicYear activeAcademicYear, Integer invoiceStatus) throws StudentInvoiceException {
        ArrayList<ThreeFieldReports> threeFieldReports = new ArrayList<ThreeFieldReports>();
        List<Object> paidinvoice = new ArrayList();
        try {
            AcademicYear academicYear = this.academicYearDAO.getAcademicYearById(activeAcademicYear.getAcademicYearId());
            Hibernate.initialize((Object)academicYear.getInstitution());
            Institution institution = this.institutionDAO.getInstitutionById(academicYear.getInstitution().getInstitutionId());
            Hibernate.initialize(institution.getClasses());
            for (Class classes : this.classDAO.getList()) {
                Integer studentCount = 0;
                Integer paidcount = 0;
                Integer pendingcount = 0;
                Hibernate.initialize(classes.getStudents());
                if (!classes.getStudents().isEmpty()) {
                    for (Student student : classes.getStudents()) {
                        boolean checkinvoice = true;
                        paidinvoice = this.studentInvoiceDAO.getStudentInvoicesForReporting(student, institution, academicYear);
                        if (paidinvoice != null && !paidinvoice.isEmpty()) {
                            studentCount = studentCount + 1;
                            for (StudentInvoice studentInvoice : paidinvoice) {
                                if (studentInvoice.getInvoiceStatus() != 1) continue;
                                checkinvoice = false;
                            }
                        } else {
                            checkinvoice = false;
                        }
                        if (!checkinvoice) continue;
                        paidcount = paidcount + 1;
                    }
                    pendingcount = studentCount - paidcount;
                }
                ThreeFieldReports threeFieldReport = new ThreeFieldReports(String.valueOf(classes.getClassName()) + "(" + classes.getInstitution().getInstitutionCode() + ")", paidcount, pendingcount);
                threeFieldReports.add(threeFieldReport);
            }
            return threeFieldReports;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public ArrayList<StudentInvoice> getAllStudentsInvoices(AcademicYear academicYear) {
        ArrayList studentInvoices = (ArrayList)this.studentInvoiceDAO.getAllStudentsInvoices(academicYear);
        for (StudentInvoice studentInvoice : studentInvoices) {
            Hibernate.initialize((Object)studentInvoice.getAcademicYear());
            Hibernate.initialize((Object)studentInvoice.getFeesTerm());
            Hibernate.initialize(studentInvoice.getStudentInvoiceDetails());
            Hibernate.initialize((Object)studentInvoice.getStudent());
            Hibernate.initialize((Object)studentInvoice.getStudent().getStudentClass());
            Hibernate.initialize((Object)studentInvoice.getStudent().getSection());
        }
        return studentInvoices;
    }

    @Override
    public ArrayList<StudentInvoice> getStudentsInvoiceBySpecialCategory(AcademicYear academicYear, SpecialCategory specialCategory) {
        ArrayList studentInvoices = (ArrayList)this.studentInvoiceDAO.getAllStudentsInvoices(academicYear);
        Iterator studentInvoicesIterator = studentInvoices.iterator();
        while (studentInvoicesIterator.hasNext()) {
            StudentInvoice studentInvoice = (StudentInvoice)studentInvoicesIterator.next();
            if (studentInvoice.getStudent().getSpecialCategories().contains(specialCategory)) continue;
            studentInvoicesIterator.remove();
        }
        for (StudentInvoice studentInvoice : studentInvoices) {
            Hibernate.initialize((Object)studentInvoice.getAcademicYear());
            Hibernate.initialize((Object)studentInvoice.getFeesTerm());
            Hibernate.initialize(studentInvoice.getStudentInvoiceDetails());
            Hibernate.initialize((Object)studentInvoice.getStudent());
            Hibernate.initialize((Object)studentInvoice.getStudent().getStudentClass());
            Hibernate.initialize((Object)studentInvoice.getStudent().getSection());
        }
        return studentInvoices;
    }

    @Override
    public ArrayList<StudentInvoice> getStudentInvoicesByDate(Date fromDate, Date toDate) {
        List<StudentInvoice> studentInvoices = this.studentInvoiceDAO.getStudentInvoicesForDueRange(fromDate, toDate);
        for (StudentInvoice studentInvoice : studentInvoices) {
            Hibernate.initialize((Object)studentInvoice.getAcademicYear());
            Hibernate.initialize((Object)studentInvoice.getFeesTerm());
            Hibernate.initialize(studentInvoice.getStudentInvoiceDetails());
            Hibernate.initialize((Object)studentInvoice.getStudent());
            Hibernate.initialize((Object)studentInvoice.getStudent().getStudentClass());
            Hibernate.initialize((Object)studentInvoice.getStudent().getSection());
        }
        return (ArrayList)studentInvoices;
    }

    @Override
    public List<ThreeFieldReports> pendingAndPaidStudentCountByAllClassByInstitution(Long institutionId, Integer invoiceStatus) throws StudentInvoiceException {
        ArrayList<ThreeFieldReports> threeFieldReports = new ArrayList<ThreeFieldReports>();
        List<Object> paidinvoice = new ArrayList();
        try {
            AcademicYear academicYear = this.academicYearDAO.getActiveAcademicYear();
            Hibernate.initialize((Object)academicYear.getInstitution());
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            Hibernate.initialize(institution.getClasses());
            for (Class classes : institution.getClasses()) {
                Integer studentCount = 0;
                Integer paidcount = 0;
                Integer pendingcount = 0;
                Hibernate.initialize(classes.getStudents());
                if (!classes.getStudents().isEmpty()) {
                    for (Student student : classes.getStudents()) {
                        boolean checkinvoice = true;
                        paidinvoice = this.studentInvoiceDAO.getStudentInvoicesByStudentAndAcademicYear(student, academicYear);
                        if (paidinvoice != null && !paidinvoice.isEmpty()) {
                            studentCount = studentCount + 1;
                            for (StudentInvoice studentInvoice : paidinvoice) {
                                if (studentInvoice.getInvoiceStatus() != 1) continue;
                                checkinvoice = false;
                            }
                        } else {
                            checkinvoice = false;
                        }
                        if (!checkinvoice) continue;
                        paidcount = paidcount + 1;
                    }
                    pendingcount = studentCount - paidcount;
                }
                ThreeFieldReports threeFieldReport = new ThreeFieldReports(classes.getClassName(), paidcount, pendingcount);
                threeFieldReports.add(threeFieldReport);
            }
            return threeFieldReports;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<ThreeFieldReports> pendingAndPaidStudentCountByAllClassByActiveAcademicYear(Long institutionId, AcademicYear activeAcademicYear, Integer invoiceStatus) throws StudentInvoiceException {
        ArrayList<ThreeFieldReports> threeFieldReports = new ArrayList<ThreeFieldReports>();
        List<Object> paidinvoice = new ArrayList();
        try {
            AcademicYear academicYear = this.academicYearDAO.getAcademicYearById(activeAcademicYear.getAcademicYearId());
            Hibernate.initialize((Object)academicYear.getInstitution());
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            Hibernate.initialize(institution.getClasses());
            for (Class classes : institution.getClasses()) {
                Integer studentCount = 0;
                Integer paidcount = 0;
                Integer pendingcount = 0;
                Hibernate.initialize(classes.getStudents());
                if (!classes.getStudents().isEmpty()) {
                    for (Student student : classes.getStudents()) {
                        boolean checkinvoice = true;
                        paidinvoice = this.studentInvoiceDAO.getStudentInvoicesByStudentAndAcademicYear(student, academicYear);
                        if (paidinvoice != null && !paidinvoice.isEmpty()) {
                            studentCount = studentCount + 1;
                            for (StudentInvoice studentInvoice : paidinvoice) {
                                if (studentInvoice.getInvoiceStatus() != 1) continue;
                                checkinvoice = false;
                            }
                        } else {
                            checkinvoice = false;
                        }
                        if (!checkinvoice) continue;
                        paidcount = paidcount + 1;
                    }
                    pendingcount = studentCount - paidcount;
                }
                ThreeFieldReports threeFieldReport = new ThreeFieldReports(classes.getClassName(), paidcount, pendingcount);
                threeFieldReports.add(threeFieldReport);
            }
            return threeFieldReports;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public TwoFieldReport pendingAndPaidStudentCountByAcademicYear(AcademicYear activeAcademicYear, Integer invoiceStatus) {
        List<Object> paidinvoice = new ArrayList();
        AcademicYear academicYear = this.academicYearDAO.getAcademicYearById(activeAcademicYear.getAcademicYearId());
        Hibernate.initialize((Object)academicYear.getInstitution());
        Long paidStudentCount = 0L;
        Long pendingStudentCount = 0L;
        Long studentCount = 0L;
        for (Student student : this.studentDAO.getList()) {
            boolean checkinvoice = true;
            paidinvoice = this.studentInvoiceDAO.getStudentInvoicesByAcademicYearAndStudent(student, academicYear);
            if (paidinvoice != null && !paidinvoice.isEmpty()) {
                studentCount = studentCount + 1L;
                for (StudentInvoice studentInvoice : paidinvoice) {
                    if (studentInvoice.getInvoiceStatus() != 1) continue;
                    checkinvoice = false;
                }
            } else {
                checkinvoice = false;
            }
            if (!checkinvoice) continue;
            paidStudentCount = paidStudentCount + 1L;
        }
        TwoFieldReport twoFieldReport = null;
        if (!this.studentInvoiceDAO.getStudentInvoicesByAcademicYear(academicYear).isEmpty()) {
            pendingStudentCount = studentCount - paidStudentCount;
            twoFieldReport = new TwoFieldReport(paidStudentCount, pendingStudentCount);
        }
        return twoFieldReport;
    }

    @Override
    public ArrayList<StudentInvoiceDetail> getStudentPendingInvoiceFeesItemsByInvoiceIdAndInvoiceStatus(Long invoiceId, Integer invoiceStatus) {
        StudentInvoice studentInvoice = this.studentInvoiceDAO.getStudentInvoiceById(invoiceId);
        ArrayList<StudentInvoiceDetail> studentInvoiceDetails = this.studentInvoiceDetailDAO.getStudentPendingInvoiceFeesItemsByInvoiceIdAndInvoiceStatus(studentInvoice, invoiceStatus);
        for (StudentInvoiceDetail studentInvoiceDetail : studentInvoiceDetails) {
            Hibernate.initialize((Object)studentInvoiceDetail.getFeesItem());
            if (this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail) == null) continue;
            StudentPartialPaymentReceiptDetail studentPartialPaymentReceiptDetail = this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail);
            studentInvoiceDetail.setStudentPartialPaymentReceiptDetail(studentPartialPaymentReceiptDetail);
        }
        return studentInvoiceDetails;
    }

    @Override
    public List<StudentInvoice> studentInvoicesForFeesCategoryRefundReport(Long academicYearId, Long feesTermId, Long institutionId) {
        List<StudentInvoice> invoices = null;
        ArrayList<StudentInvoice> studentinvoices = new ArrayList<StudentInvoice>();
        Institution institution = this.institutionDAO.getInstitutionById(institutionId);
        AcademicYear academicYear = this.academicYearDAO.getAcademicYearById(academicYearId);
        FeesTerm feesTerm = this.feesTermDAO.getFeesTermById(feesTermId);
        invoices = this.studentInvoiceDAO.getStudentInvoicesForRefundReporting(institution, feesTerm, academicYear);
        for (StudentInvoice studentInvoice : invoices) {
            Hibernate.initialize(studentInvoice.getStudentFeeRefundReceipts());
            Hibernate.initialize((Object)studentInvoice.getStudent().getStudentClass());
            Hibernate.initialize((Object)studentInvoice.getStudent().getSection());
            Hibernate.initialize((Object)studentInvoice.getFeesTerm());
            Hibernate.initialize(studentInvoice.getStudentInvoiceDetails());
            studentinvoices.add(studentInvoice);
        }
        return studentinvoices;
    }

    @Override
    public List<StudentInvoice> studentInvoicesForFeesCategoryRefundReportByDateRange(Date fromDate, Date toDate, Long feesTermId, Long institutionId) {
        List<StudentInvoice> invoices = null;
        ArrayList<StudentInvoice> studentinvoices = new ArrayList<StudentInvoice>();
        Institution institution = this.institutionDAO.getInstitutionById(institutionId);
        FeesTerm feesTerm = this.feesTermDAO.getFeesTermById(feesTermId);
        invoices = this.studentInvoiceDAO.getStudentInvoicesForRefundReportingByDateRange(fromDate, toDate, institution, feesTerm);
        for (StudentInvoice studentInvoice : invoices) {
            Hibernate.initialize(studentInvoice.getStudentFeeRefundReceipts());
            Hibernate.initialize((Object)studentInvoice.getStudent().getStudentClass());
            Hibernate.initialize((Object)studentInvoice.getStudent().getSection());
            Hibernate.initialize((Object)studentInvoice.getFeesTerm());
            Hibernate.initialize(studentInvoice.getStudentInvoiceDetails());
            studentinvoices.add(studentInvoice);
        }
        return studentinvoices;
    }

    @Override
    public List<StudentInvoiceDetail> studentInvoicesForFeesItemRefundReport(Long academicYearId, Long feesItemId, Long institutionId) {
        FeesItem feesItem;
        List<StudentInvoiceDetail> invoiceDetail = null;
        Institution institution = this.institutionDAO.getInstitutionById(institutionId);
        AcademicYear academicYear = this.academicYearDAO.getAcademicYearById(academicYearId);
        invoiceDetail = this.studentInvoiceDetailDAO.getStudentInvoiceDetailForFeesItemRefundReport(academicYear, feesItem = this.feesItemDAO.getFeesItemById(feesItemId), institution);
        if (invoiceDetail != null) {
            for (StudentInvoiceDetail studentInvoiceDetail : invoiceDetail) {
                Hibernate.initialize(studentInvoiceDetail.getStudentFeeRefundReceiptDetails());
                Hibernate.initialize((Object)studentInvoiceDetail.getStudentInvoice().getStudent().getStudentClass());
                Hibernate.initialize((Object)studentInvoiceDetail.getStudentInvoice().getStudent().getSection());
                Hibernate.initialize((Object)studentInvoiceDetail.getStudentInvoice().getFeesTerm());
            }
        }
        return invoiceDetail;
    }

    @Override
    public List<StudentInvoiceDetail> studentInvoicesForFeesItemRefundReportByDateRange(Date fromDate, Date toDate, Long feesItemId, Long institutionId) {
        List<StudentInvoiceDetail> invoiceDetail = null;
        Institution institution = this.institutionDAO.getInstitutionById(institutionId);
        FeesItem feesItem = this.feesItemDAO.getFeesItemById(feesItemId);
        invoiceDetail = this.studentInvoiceDetailDAO.getStudentInvoiceDetailForFeesItemRefundReportByDateRange(fromDate, toDate, feesItem, institution);
        if (invoiceDetail != null) {
            for (StudentInvoiceDetail studentInvoiceDetail : invoiceDetail) {
                Hibernate.initialize(studentInvoiceDetail.getStudentFeeRefundReceiptDetails());
                Hibernate.initialize((Object)studentInvoiceDetail.getStudentInvoice().getStudent().getStudentClass());
                Hibernate.initialize((Object)studentInvoiceDetail.getStudentInvoice().getStudent().getSection());
                Hibernate.initialize((Object)studentInvoiceDetail.getStudentInvoice().getFeesTerm());
            }
        }
        return invoiceDetail;
    }

    @Override
    public ArrayList<StudentInvoiceDetail> getStudentPendingInvoiceFeesItemsByInvoiceId(Long invoiceId) {
        StudentInvoice studentInvoice = this.studentInvoiceDAO.getStudentInvoiceById(invoiceId);
        ArrayList<StudentInvoiceDetail> studentInvoiceDetails = this.studentInvoiceDetailDAO.getStudentPendingInvoiceFeesItemsByInvoiceId(studentInvoice);
        for (StudentInvoiceDetail studentInvoiceDetail : studentInvoiceDetails) {
            Hibernate.initialize((Object)studentInvoiceDetail.getFeesItem());
            if (this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail) == null) continue;
            StudentPartialPaymentReceiptDetail studentPartialPaymentReceiptDetail = this.studentPartialPaymentReceiptDetailDAO.getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(studentInvoiceDetail);
            studentInvoiceDetail.setStudentPartialPaymentReceiptDetail(studentPartialPaymentReceiptDetail);
        }
        return studentInvoiceDetails;
    }
}
