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

import in.jdsoft.educationmanagement.school.components.EncryptionAndDecryption;
import in.jdsoft.educationmanagement.school.components.SystemDetails;
import in.jdsoft.educationmanagement.school.dao.AcademicYearDAO;
import in.jdsoft.educationmanagement.school.dao.InstituteLedgerAccountDAO;
import in.jdsoft.educationmanagement.school.dao.InstitutionConfigDetailsDAO;
import in.jdsoft.educationmanagement.school.dao.InstitutionDAO;
import in.jdsoft.educationmanagement.school.dao.LicenseDAO;
import in.jdsoft.educationmanagement.school.dao.PaymentStatusDAO;
import in.jdsoft.educationmanagement.school.dao.PrivilegeDAO;
import in.jdsoft.educationmanagement.school.dao.StaffBankDetailDAO;
import in.jdsoft.educationmanagement.school.dao.StaffDAO;
import in.jdsoft.educationmanagement.school.dao.StaffDesignationDAO;
import in.jdsoft.educationmanagement.school.dao.StaffExperienceDetailDAO;
import in.jdsoft.educationmanagement.school.dao.StudentInvoiceDetailDAO;
import in.jdsoft.educationmanagement.school.dao.StudentReceiptDetailDAO;
import in.jdsoft.educationmanagement.school.dao.UserDAO;
import in.jdsoft.educationmanagement.school.dao.UserRoleDAO;
import in.jdsoft.educationmanagement.school.exceptions.InstitutionException;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.FeesItem;
import in.jdsoft.educationmanagement.school.model.InstituteLedgerAccount;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.InstitutionConfigDetails;
import in.jdsoft.educationmanagement.school.model.License;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.PaymentStatus;
import in.jdsoft.educationmanagement.school.model.Privilege;
import in.jdsoft.educationmanagement.school.model.Staff;
import in.jdsoft.educationmanagement.school.model.StaffBankDetail;
import in.jdsoft.educationmanagement.school.model.StaffDesignation;
import in.jdsoft.educationmanagement.school.model.StaffExperienceDetail;
import in.jdsoft.educationmanagement.school.model.StudentInvoiceDetail;
import in.jdsoft.educationmanagement.school.model.StudentReceipt;
import in.jdsoft.educationmanagement.school.model.StudentReceiptDetail;
import in.jdsoft.educationmanagement.school.model.StudentReceiptFine;
import in.jdsoft.educationmanagement.school.model.User;
import in.jdsoft.educationmanagement.school.model.UserRole;
import in.jdsoft.educationmanagement.school.reports.model.NineFieldReports;
import in.jdsoft.educationmanagement.school.reports.model.SixFieldReports;
import in.jdsoft.educationmanagement.school.services.InstitutionService;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service(value="institutionService")
public class InstitutionServiceImpl
implements InstitutionService {
    @Autowired
    private InstitutionDAO institutionDAO;
    @Autowired
    private UserRoleDAO userRoleDAO;
    @Autowired
    private UserDAO usersDAO;
    @Autowired
    private StaffDAO staffDAO;
    @Autowired
    private PrivilegeDAO PrivilegeDAO;
    @Autowired
    private StaffDesignationDAO staffDesignationDAO;
    @Autowired
    private StaffBankDetailDAO staffBankDetailDAO;
    @Autowired
    private StaffExperienceDetailDAO staffExperienceDetailDAO;
    @Autowired
    InstituteLedgerAccountDAO instituteLedgerAccountDAO;
    @Autowired
    PaymentStatusDAO paymentStatusDAO;
    @Autowired
    StudentInvoiceDetailDAO studentInvoiceDetailDAO;
    @Autowired
    StudentReceiptDetailDAO studentReceiptDetailDAO;
    @Autowired
    AcademicYearDAO academicYearDAO;
    @Autowired
    LicenseDAO licenseDAO;
    @Autowired
    InstitutionConfigDetailsDAO institutionConfigDetailsDAO;

    @Override
    public void setUpInstitutionWithAdmin(Institution institution, Staff staff, Set<StaffExperienceDetail> staffExperiences, StaffBankDetail staffBankDetail, License license, String installationKey, InstitutionConfigDetails institutionConfigDetails) {
        try {
            String secretKey = installationKey;
            String licenseStatus = "wHGjbQJEpkung+pYrqeusw==";
            String encryptedCustomerCode = EncryptionAndDecryption.encrypt(license.getCustomerCode().trim(), secretKey);
            String encryptedLicenseCode = EncryptionAndDecryption.encrypt(license.getLicenseCode().trim(), secretKey.trim());
            if (!this.licenseDAO.getLicensesBy(encryptedCustomerCode, encryptedLicenseCode, "wHGjbQJEpkung+pYrqeusw==").isEmpty()) {
                UserRole superadminRole;
                String setLicenseStatus = "fIPCHhEycFewY6ZJocHokQ==";
                Long institutionId = this.institutionDAO.save(institution).getInstitutionId();
                Institution persistedinstitution = this.institutionDAO.getInstitutionById(institutionId);
                InstitutionConfigDetails institutionConfigDetail = this.institutionConfigDetailsDAO.save(institutionConfigDetails);
                InstitutionConfigDetails institutionConfigDetailObj = this.institutionConfigDetailsDAO.getInstitutionConfigDetailsById(institutionConfigDetail.getInstitutionConfigDetailsId());
                if (institutionConfigDetails.isMultiInstitutions()) {
                    superadminRole = this.userRoleDAO.save(new UserRole("SuperAdministrator", persistedinstitution, new LinkedHashSet<Privilege>(this.PrivilegeDAO.privilegesByTargetType("superadmin")), "superadmin", true));
                    this.userRoleDAO.save(new UserRole("SuperStaff", persistedinstitution, new LinkedHashSet<Privilege>(this.PrivilegeDAO.privilegesByTargetType("superstaff")), "superstaff", true));
                    this.userRoleDAO.save(new UserRole("SuperAdmissionCandidate", persistedinstitution, new LinkedHashSet<Privilege>(this.PrivilegeDAO.privilegesByTargetType("admissioncandidate")), "admissioncandidate", true));
                    if (institutionConfigDetailObj.getFeeCollectionAdminType() == 1) {
                        this.userRoleDAO.save(new UserRole("FeesAdmin", persistedinstitution, new LinkedHashSet<Privilege>(this.PrivilegeDAO.privilegesByTargetType("feesadmin")), "feesadmin", true));
                    }
                    if (institutionConfigDetailObj.getInventoryAndAssetAdminType() == 1) {
                        this.userRoleDAO.save(new UserRole("InventoryandAssetAdmin", persistedinstitution, new LinkedHashSet<Privilege>(this.PrivilegeDAO.privilegesByTargetType("inventoryandassetadmin")), "inventoryandassetadmin", true));
                    }
                    if (institutionConfigDetailObj.getVisitorAdminType() == 1) {
                        this.userRoleDAO.save(new UserRole("VisitorAdmin", persistedinstitution, new LinkedHashSet<Privilege>(this.PrivilegeDAO.privilegesByTargetType("visitoradmin")), "visitoradmin", true));
                    }
                    if (institutionConfigDetailObj.getLibraryAdminType() == 1) {
                        this.userRoleDAO.save(new UserRole("LibraryAdmin", persistedinstitution, new LinkedHashSet<Privilege>(this.PrivilegeDAO.privilegesByTargetType("libraryadmin")), "libraryadmin", true));
                    }
                } else {
                    superadminRole = this.userRoleDAO.save(new UserRole("Administrator", persistedinstitution, new LinkedHashSet<Privilege>(this.PrivilegeDAO.privilegesByTargetType("admin")), "admin", true));
                    if (institutionConfigDetailObj.getFeeCollectionAdminType() == 3) {
                        this.userRoleDAO.save(new UserRole("FeesAdmin", persistedinstitution, new LinkedHashSet<Privilege>(this.PrivilegeDAO.privilegesByTargetType("feesadmin")), "feesadmin", true));
                    }
                    if (institutionConfigDetailObj.getInventoryAndAssetAdminType() == 3) {
                        this.userRoleDAO.save(new UserRole("InventoryandAssetAdmin", persistedinstitution, new LinkedHashSet<Privilege>(this.PrivilegeDAO.privilegesByTargetType("inventoryandassetadmin")), "inventoryandassetadmin", true));
                    }
                    if (institutionConfigDetailObj.getLibraryAdminType() == 3) {
                        this.userRoleDAO.save(new UserRole("LibraryAdmin", persistedinstitution, new LinkedHashSet<Privilege>(this.PrivilegeDAO.privilegesByTargetType("libraryadmin")), "libraryadmin", true));
                    }
                    if (institutionConfigDetailObj.getVisitorAdminType() == 3) {
                        this.userRoleDAO.save(new UserRole("VisitorAdmin", persistedinstitution, new LinkedHashSet<Privilege>(this.PrivilegeDAO.privilegesByTargetType("visitoradmin")), "visitoradmin", true));
                    }
                    this.userRoleDAO.save(new UserRole("Principal", persistedinstitution, new LinkedHashSet<Privilege>(this.PrivilegeDAO.privilegesByTargetType("principal")), "principal", true));
                    this.userRoleDAO.save(new UserRole("Staff", persistedinstitution, new LinkedHashSet<Privilege>(this.PrivilegeDAO.privilegesByTargetType("staff")), "staff", true));
                    this.userRoleDAO.save(new UserRole("Student", persistedinstitution, new LinkedHashSet<Privilege>(this.PrivilegeDAO.privilegesByTargetType("student")), "student", true));
                    this.userRoleDAO.save(new UserRole("Parent", persistedinstitution, new LinkedHashSet<Privilege>(this.PrivilegeDAO.privilegesByTargetType("parent")), "parent", true));
                    this.userRoleDAO.save(new UserRole("AdmissionCandidate", persistedinstitution, new LinkedHashSet<Privilege>(this.PrivilegeDAO.privilegesByTargetType("admissioncandidate")), "admissioncandidate", true));
                }
                StaffDesignation staffDesignation = this.staffDesignationDAO.save(staff.getStaffDesignation());
                staff.setStaffDesignation(staffDesignation);
                LinkedHashSet<UserRole> roles = new LinkedHashSet<UserRole>();
                roles.add(superadminRole);
                staff.getUser().setUserRoles(roles);
                User persistedUser = this.usersDAO.save(staff.getUser());
                for (StaffExperienceDetail staffExperienceDetail : staffExperiences) {
                    staffExperienceDetail.setStaff(staff);
                }
                staffBankDetail.setStaff(staff);
                staff.setUser(persistedUser);
                staff.setApprover(persistedUser);
                staff.setStaffExperienceDetails(staffExperiences);
                staff.setStaffBankDetail(staffBankDetail);
                this.staffDAO.persist(staff);
                this.institutionConfigDetailsDAO.persist(institutionConfigDetails);
                License license1 = this.licenseDAO.getLicenseBy(encryptedCustomerCode, encryptedLicenseCode, "wHGjbQJEpkung+pYrqeusw==");
                License setStatus = this.licenseDAO.getLicenseById(license1.getLicenseId());
                setStatus.setMotherBoardSerialNumber(SystemDetails.getSystemMotherBoard_SerialNumber());
                setStatus.setIpAddress(SystemDetails.getIPAddress());
                setStatus.setmACAddress(SystemDetails.getMACAddress());
                setStatus.setStatus("fIPCHhEycFewY6ZJocHokQ==");
            } else {
                System.out.println("Check The Product License....!");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Institution> institutionList() {
        try {
            List<Institution> institutionList = this.institutionDAO.getList();
            Integer institutionListSize = institutionList.size();
            if (institutionListSize > 0) {
                for (Institution institution : institutionList) {
                    Hibernate.initialize(institution.getUsers());
                }
                log.info((Object)(institutionListSize + " institution records where reterived"));
            } else {
                log.info((Object)"No institution(s) available");
            }
            return institutionList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving institution list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Institution institutionById(Long institutionId) {
        try {
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            if (institution != null) {
                log.info((Object)("institution with id=" + institutionId + " has been reterived"));
                return institution;
            }
            log.info((Object)("No institution with  id=" + institutionId + " is available"));
            return institution;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving institution by id=" + institutionId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteInstitution(Long institutionId) throws DataIntegrityViolationException {
        try {
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            if (institution != null) {
                this.institutionDAO.delete(institution);
                log.info((Object)("Institution with id=" + institutionId + " has been deleted successfully"));
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in deleting Institution", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateInstitution(Institution institution) {
        try {
            this.institutionDAO.saveOrUpdate(institution);
            Long institutionId = institution.getInstitutionId();
            if (institutionId != null) {
                log.info((Object)("institution with id=" + institutionId + " has been updated"));
            } else {
                log.info((Object)"New institution has been added, because no institution found for update");
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in updating institution", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Institution institutionByUserRoleAdmin(Long institutionId) {
        try {
            LinkedHashSet<User> addUsers = new LinkedHashSet<User>();
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            if (institution != null) {
                Hibernate.initialize(institution.getUsers());
                for (User user : institution.getUsers()) {
                    Hibernate.initialize(user.getUserRoles());
                    for (UserRole userRole : user.getUserRoles()) {
                        if (userRole.getRoleName().equals("Student") || userRole.getRoleName().equals("Parent")) continue;
                        addUsers.add(user);
                    }
                }
                institution.setUsers(addUsers);
                log.info((Object)("institution with id=" + institutionId + " has been reterived"));
            }
            return institution;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving institution by id=" + institutionId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateInstitutionWithAdmin(Institution institution, Staff staff, Set<StaffExperienceDetail> staffExperiences) {
        try {
            this.institutionDAO.saveOrUpdate(institution);
            this.usersDAO.saveOrUpdate(staff.getUser());
            this.staffBankDetailDAO.saveOrUpdate(staff.getStaffBankDetail());
            Set<StaffExperienceDetail> staffExperienceDetails = staff.getStaffExperienceDetails();
            for (StaffExperienceDetail staffExperienceDetail : staffExperienceDetails) {
                this.staffExperienceDetailDAO.delete(staffExperienceDetail);
            }
            for (StaffExperienceDetail staffExperienceDetailObj : staffExperiences) {
                this.staffExperienceDetailDAO.save(staffExperienceDetailObj);
            }
            staff.setStaffExperienceDetails(null);
            this.staffDAO.saveOrUpdate(staff);
            Long institutionId = institution.getInstitutionId();
            if (institutionId != null) {
                log.info((Object)("institution with id=" + institutionId + " has been updated"));
            } else {
                log.info((Object)"New institution has been added, because no institution found for update");
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in updating institution", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void addInstituteLedgerAccount(InstituteLedgerAccount instituteLedgerAccount) throws InstitutionException {
        try {
            this.instituteLedgerAccountDAO.persist(instituteLedgerAccount);
        }
        catch (Exception e) {
            log.error((Object)"Exception in create new institution ledger account", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateLedgerAccount(InstituteLedgerAccount instituteLedgerAccount) throws DataIntegrityViolationException {
        try {
            this.instituteLedgerAccountDAO.update(instituteLedgerAccount);
        }
        catch (Exception e) {
            log.error((Object)"Exception in updating institution ledger account", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public ArrayList<InstituteLedgerAccount> ledgerAccountList() {
        try {
            return (ArrayList)this.instituteLedgerAccountDAO.getList();
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving institution ledger account", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public ArrayList<InstituteLedgerAccount> ledgerAccountListByInstitution(Long institutionId) {
        try {
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            Hibernate.initialize(institution.getLedgerAccounts());
            ArrayList<InstituteLedgerAccount> ledgerAccounts = new ArrayList<InstituteLedgerAccount>();
            ledgerAccounts.addAll(institution.getLedgerAccounts());
            return ledgerAccounts;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving institution leger account", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteLedgerAccount(Long instituteLedgerAccountId) throws DataIntegrityViolationException {
        try {
            this.instituteLedgerAccountDAO.delete(this.instituteLedgerAccountDAO.getInstituteLedgerAccountById(instituteLedgerAccountId));
            log.info((Object)("institution ledger account with id=" + instituteLedgerAccountId + " has been deleted"));
        }
        catch (Exception e) {
            log.error((Object)"Exception in delete institution ledger account", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public InstituteLedgerAccount ledgerAccountById(Long ledgerAccountId) {
        try {
            return this.instituteLedgerAccountDAO.getInstituteLedgerAccountById(ledgerAccountId);
        }
        catch (Exception e) {
            log.error((Object)("Exception in retreiving institution ledger account by id=" + ledgerAccountId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public ArrayList<SixFieldReports> getInstitutionLedgerByInvoiceDate(Long institutionId, Date fromDate, Date toDate, Long paymentStatusId) throws Exception {
        try {
            ArrayList<SixFieldReports> addSixFieldReports = new ArrayList<SixFieldReports>();
            PaymentStatus paymentStatus = this.paymentStatusDAO.getPaymentStatusById(paymentStatusId);
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            Hibernate.initialize(institution.getLedgerAccounts());
            Set<InstituteLedgerAccount> instituteLedgerAccounts = institution.getLedgerAccounts();
            for (InstituteLedgerAccount instituteLedgerAccount : instituteLedgerAccounts) {
                String ledgerName = "";
                Double totalAmount = 0.0;
                Double paidReceiptAmount = 0.0;
                Double discountAmount = 0.0;
                Double outStandingAmount = 0.0;
                ledgerName = instituteLedgerAccount.getLedgerAccountName();
                Long ledgerId = instituteLedgerAccount.getLedgerAccountId();
                Hibernate.initialize(instituteLedgerAccount.getFeesItems());
                Set<FeesItem> feesItems = instituteLedgerAccount.getFeesItems();
                for (FeesItem feesItem : feesItems) {
                    Hibernate.initialize(feesItem.getStudentInvoiceItems());
                    Set<StudentInvoiceDetail> studentInvoiceDetails = feesItem.getStudentInvoiceItems();
                    for (StudentInvoiceDetail studentInvoiceDetail : studentInvoiceDetails) {
                        StudentInvoiceDetail curStudentInvoiceDetail = this.studentInvoiceDetailDAO.getStudentInvoiceDetailByDate(studentInvoiceDetail.getStudentInvoiceDetailId(), fromDate, toDate);
                        Long curElementPaymentStatus = Long.parseLong(String.valueOf(curStudentInvoiceDetail.getStudentInvoiceElementPaymentStatus()));
                        if (curStudentInvoiceDetail == null || paymentStatus.getPaymentStatusId() == curElementPaymentStatus) continue;
                        totalAmount = totalAmount + curStudentInvoiceDetail.getStudentInvoiceElementTotalAmount();
                    }
                }
                totalAmount = (double)Math.round(totalAmount * 100.0) / 100.0;
                paidReceiptAmount = (double)Math.round(paidReceiptAmount * 100.0) / 100.0;
                discountAmount = (double)Math.round(discountAmount * 100.0) / 100.0;
                outStandingAmount = (double)Math.round(outStandingAmount * 100.0) / 100.0;
                SixFieldReports sixFieldReport = new SixFieldReports(ledgerId, ledgerName, totalAmount, paidReceiptAmount, discountAmount, outStandingAmount);
                addSixFieldReports.add(sixFieldReport);
            }
            return addSixFieldReports;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public ArrayList<SixFieldReports> getInstitutionLedgerByReceiptDate(Long institutionId, Date fromDate, Date toDate, Long paymentStatusId) throws Exception {
        try {
            ArrayList<SixFieldReports> addSixFieldReports = new ArrayList<SixFieldReports>();
            PaymentStatus paymentStatus = this.paymentStatusDAO.getPaymentStatusById(paymentStatusId);
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            Hibernate.initialize(institution.getLedgerAccounts());
            Set<InstituteLedgerAccount> instituteLedgerAccounts = institution.getLedgerAccounts();
            for (InstituteLedgerAccount instituteLedgerAccount : instituteLedgerAccounts) {
                String ledgerName = "";
                Double totalAmount = 0.0;
                Double paidReceiptAmount = 0.0;
                Double discountAmount = 0.0;
                Double outStandingAmount = 0.0;
                ledgerName = instituteLedgerAccount.getLedgerAccountName();
                Long ledgerId = instituteLedgerAccount.getLedgerAccountId();
                Hibernate.initialize(instituteLedgerAccount.getFeesItems());
                Set<FeesItem> feesItems = instituteLedgerAccount.getFeesItems();
                for (FeesItem feesItem : feesItems) {
                    Hibernate.initialize(feesItem.getStudentReceiptsItems());
                    Set<StudentReceiptDetail> studentReceiptDetails = feesItem.getStudentReceiptsItems();
                    for (StudentReceiptDetail studentReceiptDetail : studentReceiptDetails) {
                        StudentReceiptDetail curStudentReceiptDetail = this.studentReceiptDetailDAO.getStudentReceiptDetailByDate(fromDate, toDate, studentReceiptDetail.getStudentReceiptDetailId());
                        if (curStudentReceiptDetail == null || paymentStatus.getPaymentStatusId() == curStudentReceiptDetail.getPaymentStatus().getPaymentStatusId()) continue;
                        paidReceiptAmount = paidReceiptAmount + curStudentReceiptDetail.getPaidReceiptAmount();
                        discountAmount = discountAmount + curStudentReceiptDetail.getDiscountAmount();
                    }
                }
                totalAmount = (double)Math.round(totalAmount * 100.0) / 100.0;
                paidReceiptAmount = (double)Math.round(paidReceiptAmount * 100.0) / 100.0;
                discountAmount = (double)Math.round(discountAmount * 100.0) / 100.0;
                outStandingAmount = (double)Math.round(outStandingAmount * 100.0) / 100.0;
                SixFieldReports sixFieldReport = new SixFieldReports(ledgerId, ledgerName, totalAmount, paidReceiptAmount, discountAmount, outStandingAmount);
                addSixFieldReports.add(sixFieldReport);
            }
            return addSixFieldReports;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public ArrayList<SixFieldReports> getInstitutionLedgerAccountDetailsByAcademicYear(Long academicYearId, Long institutionId, String ledgerAccountName, Long paymentStatusId) throws Exception {
        try {
            AcademicYear academicYear = this.academicYearDAO.getAcademicYearById(academicYearId);
            ArrayList<SixFieldReports> addSixFieldReports = new ArrayList<SixFieldReports>();
            PaymentStatus paymentStatus = this.paymentStatusDAO.getPaymentStatusById(paymentStatusId);
            Hibernate.initialize((Object)academicYear.getInstitution());
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            InstituteLedgerAccount instituteLedgerAccount = this.instituteLedgerAccountDAO.getInstituteLedgerAccountByInstituteLedgerAccountName(ledgerAccountName, institution);
            Hibernate.initialize(instituteLedgerAccount.getFeesItems());
            Set<FeesItem> feesItems = instituteLedgerAccount.getFeesItems();
            for (FeesItem feesItem : feesItems) {
                String ItemName = "";
                Double totalAmount = 0.0;
                Double paidReceiptAmount = 0.0;
                Double discountAmount = 0.0;
                Double outStandingAmount = 0.0;
                Hibernate.initialize((Object)feesItem);
                ItemName = feesItem.getFeesItemName();
                Long ItemId = feesItem.getFeesItemId();
                Hibernate.initialize(feesItem.getStudentInvoiceItems());
                Set<StudentInvoiceDetail> studentInvoiceDetails = feesItem.getStudentInvoiceItems();
                for (StudentInvoiceDetail studentInvoiceDetail : studentInvoiceDetails) {
                    Long invoiceElementPaymentStatus = Long.parseLong(String.valueOf(studentInvoiceDetail.getStudentInvoiceElementPaymentStatus()));
                    if (studentInvoiceDetail.getAcademicYear().getAcademicYearId() != academicYear.getAcademicYearId() || paymentStatus.getPaymentStatusId() == invoiceElementPaymentStatus) continue;
                    totalAmount = totalAmount + studentInvoiceDetail.getStudentInvoiceElementTotalAmount();
                }
                Hibernate.initialize(feesItem.getStudentReceiptsItems());
                Set<StudentReceiptDetail> studentReceiptDetails = feesItem.getStudentReceiptsItems();
                for (StudentReceiptDetail studentReceiptDetail : studentReceiptDetails) {
                    if (studentReceiptDetail.getAcademicYear().getAcademicYearId() != academicYear.getAcademicYearId() || paymentStatus.getPaymentStatusId() == studentReceiptDetail.getPaymentStatus().getPaymentStatusId()) continue;
                    paidReceiptAmount = paidReceiptAmount + studentReceiptDetail.getPaidReceiptAmount();
                    discountAmount = discountAmount + studentReceiptDetail.getDiscountAmount();
                }
                outStandingAmount = totalAmount - (paidReceiptAmount + discountAmount);
                totalAmount = (double)Math.round(totalAmount * 100.0) / 100.0;
                paidReceiptAmount = (double)Math.round(paidReceiptAmount * 100.0) / 100.0;
                discountAmount = (double)Math.round(discountAmount * 100.0) / 100.0;
                outStandingAmount = (double)Math.round(outStandingAmount * 100.0) / 100.0;
                SixFieldReports sixFieldReport = new SixFieldReports(ItemId, ItemName, totalAmount, paidReceiptAmount, discountAmount, outStandingAmount);
                addSixFieldReports.add(sixFieldReport);
            }
            return addSixFieldReports;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public ArrayList<SixFieldReports> getCurrentAcademicYearLedgerAccountDetailsByInstitution(Long institutionId, Long paymentStatusId) throws Exception {
        try {
            AcademicYear academicYear = this.academicYearDAO.getActiveAcademicYear();
            PaymentStatus paymentStatus = this.paymentStatusDAO.getPaymentStatusById(paymentStatusId);
            ArrayList<SixFieldReports> addSixFieldReports = new ArrayList<SixFieldReports>();
            if (academicYear != null) {
                Hibernate.initialize((Object)academicYear.getInstitution());
                Institution institution = this.institutionDAO.getInstitutionById(institutionId);
                Hibernate.initialize(institution.getLedgerAccounts());
                Set<InstituteLedgerAccount> instituteLedgerAccounts = institution.getLedgerAccounts();
                for (InstituteLedgerAccount instituteLedgerAccount : instituteLedgerAccounts) {
                    String ledgerName = "";
                    Double totalAmount = 0.0;
                    Double paidReceiptAmount = 0.0;
                    Double discountAmount = 0.0;
                    Double outStandingAmount = 0.0;
                    ledgerName = instituteLedgerAccount.getLedgerAccountName();
                    Long ledgerId = instituteLedgerAccount.getLedgerAccountId();
                    Hibernate.initialize(instituteLedgerAccount.getFeesItems());
                    Set<FeesItem> feesItems = instituteLedgerAccount.getFeesItems();
                    for (FeesItem feesItem : feesItems) {
                        Hibernate.initialize(feesItem.getStudentInvoiceItems());
                        Set<StudentInvoiceDetail> studentInvoiceDetails = feesItem.getStudentInvoiceItems();
                        for (StudentInvoiceDetail studentInvoiceDetail : studentInvoiceDetails) {
                            Long invoiceElementPaymentStatus = Long.parseLong(String.valueOf(studentInvoiceDetail.getStudentInvoiceElementPaymentStatus()));
                            if (studentInvoiceDetail.getAcademicYear().getAcademicYearId() != academicYear.getAcademicYearId() || paymentStatus.getPaymentStatusId() == invoiceElementPaymentStatus) continue;
                            totalAmount = totalAmount + studentInvoiceDetail.getStudentInvoiceElementTotalAmount();
                        }
                        Hibernate.initialize(feesItem.getStudentReceiptsItems());
                        Set<StudentReceiptDetail> studentReceiptDetails = feesItem.getStudentReceiptsItems();
                        for (StudentReceiptDetail studentReceiptDetail : studentReceiptDetails) {
                            if (studentReceiptDetail.getAcademicYear().getAcademicYearId() != academicYear.getAcademicYearId() || paymentStatus.getPaymentStatusId() == studentReceiptDetail.getPaymentStatus().getPaymentStatusId()) continue;
                            paidReceiptAmount = paidReceiptAmount + studentReceiptDetail.getPaidReceiptAmount();
                            discountAmount = discountAmount + studentReceiptDetail.getDiscountAmount();
                        }
                    }
                    outStandingAmount = totalAmount - (paidReceiptAmount + discountAmount);
                    totalAmount = (double)Math.round(totalAmount * 100.0) / 100.0;
                    paidReceiptAmount = (double)Math.round(paidReceiptAmount * 100.0) / 100.0;
                    discountAmount = (double)Math.round(discountAmount * 100.0) / 100.0;
                    outStandingAmount = (double)Math.round(outStandingAmount * 100.0) / 100.0;
                    SixFieldReports sixFieldReport = new SixFieldReports(ledgerId, ledgerName, totalAmount, paidReceiptAmount, discountAmount, outStandingAmount);
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
    public AcademicYear getCurrentActiveAcademicYearFineDetailsByInstitution(Long institutionId) throws Exception {
        try {
            Institution academicinstitution = this.institutionDAO.getInstitutionById(institutionId);
            AcademicYear academicYear = this.academicYearDAO.getActiveAcademicYear(academicinstitution);
            if (academicYear != null) {
                Hibernate.initialize(academicYear.getStudentReceiptFines());
            }
            return academicYear;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Set<AcademicYear> getAcademicYearFineDetailsByInstitution(Long institutionId) throws Exception {
        try {
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            Hibernate.initialize(institution.getAcademicYears());
            LinkedHashSet<AcademicYear> addAcademicYears = new LinkedHashSet<AcademicYear>();
            for (AcademicYear academicYear : institution.getAcademicYears()) {
                if (academicYear != null) {
                    Hibernate.initialize(academicYear.getStudentReceiptFines());
                }
                addAcademicYears.add(academicYear);
            }
            return addAcademicYears;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Set<AcademicYear> getCurrentAcademicYearFineDetails(Long academicYearId) throws Exception {
        try {
            AcademicYear academicYear = this.academicYearDAO.getAcademicYearById(academicYearId);
            LinkedHashSet<AcademicYear> addAcademicYears = new LinkedHashSet<AcademicYear>();
            if (academicYear != null) {
                Hibernate.initialize(academicYear.getStudentReceiptFines());
                for (StudentReceiptFine studentReceiptFine : academicYear.getStudentReceiptFines()) {
                    StudentReceipt studentReceipt = studentReceiptFine.getStudentReceipt();
                    Hibernate.initialize((Object)studentReceipt.getStudent());
                    Hibernate.initialize((Object)studentReceipt.getStudentInvoice().getFeesTerm());
                }
            }
            addAcademicYears.add(academicYear);
            return addAcademicYears;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public ArrayList<SixFieldReports> getInstitutionLedgerAccountDetails(Long institutionId, Long paymentStatusId) throws Exception {
        try {
            ArrayList<SixFieldReports> addSixFieldReports = new ArrayList<SixFieldReports>();
            PaymentStatus paymentStatus = this.paymentStatusDAO.getPaymentStatusById(paymentStatusId);
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            Hibernate.initialize(institution.getLedgerAccounts());
            Set<InstituteLedgerAccount> instituteLedgerAccounts = institution.getLedgerAccounts();
            for (InstituteLedgerAccount instituteLedgerAccount : instituteLedgerAccounts) {
                String ledgerName = "";
                Double totalAmount = 0.0;
                Double paidReceiptAmount = 0.0;
                Double discountAmount = 0.0;
                Double outStandingAmount = 0.0;
                ledgerName = instituteLedgerAccount.getLedgerAccountName();
                Long ledgerId = instituteLedgerAccount.getLedgerAccountId();
                Hibernate.initialize(instituteLedgerAccount.getFeesItems());
                Set<FeesItem> feesItems = instituteLedgerAccount.getFeesItems();
                for (FeesItem feesItem : feesItems) {
                    Hibernate.initialize(feesItem.getStudentInvoiceItems());
                    Set<StudentInvoiceDetail> studentInvoiceDetails = feesItem.getStudentInvoiceItems();
                    for (StudentInvoiceDetail studentInvoiceDetail : studentInvoiceDetails) {
                        totalAmount = totalAmount + studentInvoiceDetail.getStudentInvoiceElementTotalAmount();
                    }
                    Hibernate.initialize(feesItem.getStudentReceiptsItems());
                    Set<StudentReceiptDetail> studentReceiptDetails = feesItem.getStudentReceiptsItems();
                    for (StudentReceiptDetail studentReceiptDetail : studentReceiptDetails) {
                        if (paymentStatus.getPaymentStatusId() == studentReceiptDetail.getPaymentStatus().getPaymentStatusId()) continue;
                        paidReceiptAmount = paidReceiptAmount + studentReceiptDetail.getPaidReceiptAmount();
                        discountAmount = discountAmount + studentReceiptDetail.getDiscountAmount();
                    }
                }
                outStandingAmount = totalAmount - (paidReceiptAmount + discountAmount);
                totalAmount = (double)Math.round(totalAmount * 100.0) / 100.0;
                paidReceiptAmount = (double)Math.round(paidReceiptAmount * 100.0) / 100.0;
                discountAmount = (double)Math.round(discountAmount * 100.0) / 100.0;
                outStandingAmount = (double)Math.round(outStandingAmount * 100.0) / 100.0;
                SixFieldReports sixFieldReport = new SixFieldReports(ledgerId, ledgerName, totalAmount, paidReceiptAmount, discountAmount, outStandingAmount);
                addSixFieldReports.add(sixFieldReport);
            }
            return addSixFieldReports;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public ArrayList<SixFieldReports> getInstitutionLedgerAccountDetailsByAcademicYear(Long academicYearId, Long paymentStatusId) throws Exception {
        try {
            AcademicYear academicYear = this.academicYearDAO.getAcademicYearById(academicYearId);
            PaymentStatus paymentStatus = this.paymentStatusDAO.getPaymentStatusById(paymentStatusId);
            ArrayList<SixFieldReports> addSixFieldReports = new ArrayList<SixFieldReports>();
            Hibernate.initialize((Object)academicYear.getInstitution());
            Institution institution = academicYear.getInstitution();
            Hibernate.initialize(institution.getLedgerAccounts());
            Set<InstituteLedgerAccount> instituteLedgerAccounts = institution.getLedgerAccounts();
            for (InstituteLedgerAccount instituteLedgerAccount : instituteLedgerAccounts) {
                String ledgerName = "";
                Double totalAmount = 0.0;
                Double paidReceiptAmount = 0.0;
                Double discountAmount = 0.0;
                Double outStandingAmount = 0.0;
                ledgerName = instituteLedgerAccount.getLedgerAccountName();
                Long ledgerId = instituteLedgerAccount.getLedgerAccountId();
                Hibernate.initialize(instituteLedgerAccount.getFeesItems());
                Set<FeesItem> feesItems = instituteLedgerAccount.getFeesItems();
                for (FeesItem feesItem : feesItems) {
                    Hibernate.initialize(feesItem.getStudentInvoiceItems());
                    Set<StudentInvoiceDetail> studentInvoiceDetails = feesItem.getStudentInvoiceItems();
                    for (StudentInvoiceDetail studentInvoiceDetail : studentInvoiceDetails) {
                        Long invoiceElementPaymentStatus = Long.parseLong(String.valueOf(studentInvoiceDetail.getStudentInvoiceElementPaymentStatus()));
                        if (studentInvoiceDetail.getAcademicYear().getAcademicYearId() != academicYear.getAcademicYearId() || paymentStatus.getPaymentStatusId() == invoiceElementPaymentStatus) continue;
                        totalAmount = totalAmount + studentInvoiceDetail.getStudentInvoiceElementTotalAmount();
                    }
                    Hibernate.initialize(feesItem.getStudentReceiptsItems());
                    Set<StudentReceiptDetail> studentReceiptDetails = feesItem.getStudentReceiptsItems();
                    for (StudentReceiptDetail studentReceiptDetail : studentReceiptDetails) {
                        if (studentReceiptDetail.getAcademicYear().getAcademicYearId() != academicYear.getAcademicYearId() || paymentStatus.getPaymentStatusId() == studentReceiptDetail.getPaymentStatus().getPaymentStatusId()) continue;
                        paidReceiptAmount = paidReceiptAmount + studentReceiptDetail.getPaidReceiptAmount();
                        discountAmount = discountAmount + studentReceiptDetail.getDiscountAmount();
                    }
                }
                outStandingAmount = totalAmount - (paidReceiptAmount + discountAmount);
                totalAmount = (double)Math.round(totalAmount * 100.0) / 100.0;
                paidReceiptAmount = (double)Math.round(paidReceiptAmount * 100.0) / 100.0;
                discountAmount = (double)Math.round(discountAmount * 100.0) / 100.0;
                outStandingAmount = (double)Math.round(outStandingAmount * 100.0) / 100.0;
                SixFieldReports sixFieldReport = new SixFieldReports(ledgerId, ledgerName, totalAmount, paidReceiptAmount, discountAmount, outStandingAmount);
                addSixFieldReports.add(sixFieldReport);
            }
            return addSixFieldReports;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public ArrayList<SixFieldReports> getInstitutionLedgerAccountListByInvoice(String ledgerAccountName, Long institutionId, Date fromDate, Date toDate, Long paymentStatusId) {
        Institution institution = this.institutionDAO.getInstitutionById(institutionId);
        InstituteLedgerAccount instituteLedgerAccount = this.instituteLedgerAccountDAO.getInstituteLedgerAccountByInstituteLedgerAccountName(ledgerAccountName, institution);
        PaymentStatus paymentStatus = this.paymentStatusDAO.getPaymentStatusById(paymentStatusId);
        Hibernate.initialize(instituteLedgerAccount.getFeesItems());
        Set<FeesItem> feesItems = instituteLedgerAccount.getFeesItems();
        ArrayList<SixFieldReports> addSixFieldReports = new ArrayList<SixFieldReports>();
        for (FeesItem feesItem : feesItems) {
            String ItemName = "";
            Double totalAmount = 0.0;
            Double paidReceiptAmount = 0.0;
            Double discountAmount = 0.0;
            Double outStandingAmount = 0.0;
            Hibernate.initialize((Object)feesItem);
            Hibernate.initialize(feesItem.getStudentInvoiceItems());
            ItemName = feesItem.getFeesItemName();
            Long ItemId = feesItem.getFeesItemId();
            for (StudentInvoiceDetail studentInvoiceDetail : feesItem.getStudentInvoiceItems()) {
                StudentInvoiceDetail curStudentInvoiceDetail = this.studentInvoiceDetailDAO.getStudentInvoiceDetailByDate(studentInvoiceDetail.getStudentInvoiceDetailId(), fromDate, toDate);
                Long invoiceElementPaymentStatus = Long.parseLong(String.valueOf(curStudentInvoiceDetail.getStudentInvoiceElementPaymentStatus()));
                if (curStudentInvoiceDetail == null || paymentStatus.getPaymentStatusId() == invoiceElementPaymentStatus) continue;
                totalAmount = totalAmount + curStudentInvoiceDetail.getStudentInvoiceElementTotalAmount();
            }
            totalAmount = (double)Math.round(totalAmount * 100.0) / 100.0;
            paidReceiptAmount = (double)Math.round(paidReceiptAmount * 100.0) / 100.0;
            discountAmount = (double)Math.round(discountAmount * 100.0) / 100.0;
            outStandingAmount = (double)Math.round(outStandingAmount * 100.0) / 100.0;
            SixFieldReports sixFieldReport = new SixFieldReports(ItemId, ItemName, totalAmount, paidReceiptAmount, discountAmount, outStandingAmount);
            addSixFieldReports.add(sixFieldReport);
        }
        return addSixFieldReports;
    }

    @Override
    public ArrayList<SixFieldReports> getInstitutionLedgerAccountListByReceipt(String ledgerAccountName, Long institutionId, Date fromDate, Date toDate, Long paymentStatusId) {
        Institution institution = this.institutionDAO.getInstitutionById(institutionId);
        InstituteLedgerAccount instituteLedgerAccount = this.instituteLedgerAccountDAO.getInstituteLedgerAccountByInstituteLedgerAccountName(ledgerAccountName, institution);
        PaymentStatus paymentStatus = this.paymentStatusDAO.getPaymentStatusById(paymentStatusId);
        Hibernate.initialize(instituteLedgerAccount.getFeesItems());
        Set<FeesItem> feesItems = instituteLedgerAccount.getFeesItems();
        ArrayList<SixFieldReports> addSixFieldReports = new ArrayList<SixFieldReports>();
        for (FeesItem feesItem : feesItems) {
            Hibernate.initialize((Object)feesItem);
            Hibernate.initialize(feesItem.getStudentReceiptsItems());
            String ItemName = "";
            Double totalAmount = 0.0;
            Double paidReceiptAmount = 0.0;
            Double discountAmount = 0.0;
            Double outStandingAmount = 0.0;
            Hibernate.initialize((Object)feesItem);
            ItemName = feesItem.getFeesItemName();
            Long ItemId = feesItem.getFeesItemId();
            for (StudentReceiptDetail studentReceiptDetail : feesItem.getStudentReceiptsItems()) {
                StudentReceiptDetail curStudentReceiptDetail = this.studentReceiptDetailDAO.getStudentReceiptDetailByDate(fromDate, toDate, studentReceiptDetail.getStudentReceiptDetailId());
                if (curStudentReceiptDetail == null || paymentStatus.getPaymentStatusId() == curStudentReceiptDetail.getPaymentStatus().getPaymentStatusId()) continue;
                paidReceiptAmount = paidReceiptAmount + curStudentReceiptDetail.getPaidReceiptAmount();
                discountAmount = discountAmount + curStudentReceiptDetail.getDiscountAmount();
            }
            totalAmount = (double)Math.round(totalAmount * 100.0) / 100.0;
            paidReceiptAmount = (double)Math.round(paidReceiptAmount * 100.0) / 100.0;
            discountAmount = (double)Math.round(discountAmount * 100.0) / 100.0;
            outStandingAmount = (double)Math.round(outStandingAmount * 100.0) / 100.0;
            SixFieldReports sixFieldReport = new SixFieldReports(ItemId, ItemName, totalAmount, paidReceiptAmount, discountAmount, outStandingAmount);
            addSixFieldReports.add(sixFieldReport);
        }
        return addSixFieldReports;
    }

    @Override
    public ArrayList<SixFieldReports> getInstitutionLedgerAccountListByNameEager(String ledgerAccountName, Long institutionId, Long paymentStatusId) {
        try {
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            InstituteLedgerAccount instituteLedgerAccount = this.instituteLedgerAccountDAO.getInstituteLedgerAccountByInstituteLedgerAccountName(ledgerAccountName, institution);
            PaymentStatus paymentStatus = this.paymentStatusDAO.getPaymentStatusById(paymentStatusId);
            Hibernate.initialize(instituteLedgerAccount.getFeesItems());
            Set<FeesItem> feesItems = instituteLedgerAccount.getFeesItems();
            ArrayList<SixFieldReports> addSixFieldReports = new ArrayList<SixFieldReports>();
            for (FeesItem feesItem : feesItems) {
                String ItemName = "";
                Double totalAmount = 0.0;
                Double paidReceiptAmount = 0.0;
                Double discountAmount = 0.0;
                Double outStandingAmount = 0.0;
                Hibernate.initialize((Object)feesItem);
                ItemName = feesItem.getFeesItemName();
                Long ItemId = feesItem.getFeesItemId();
                Hibernate.initialize(feesItem.getStudentInvoiceItems());
                Set<StudentInvoiceDetail> studentInvoiceDetails = feesItem.getStudentInvoiceItems();
                for (StudentInvoiceDetail studentInvoiceDetail : studentInvoiceDetails) {
                    Long invoiceElementPaymentStatus = Long.parseLong(String.valueOf(studentInvoiceDetail.getStudentInvoiceElementPaymentStatus()));
                    if (invoiceElementPaymentStatus == paymentStatus.getPaymentStatusId()) continue;
                    totalAmount = totalAmount + studentInvoiceDetail.getStudentInvoiceElementTotalAmount();
                }
                Hibernate.initialize(feesItem.getStudentReceiptsItems());
                Set<StudentReceiptDetail> studentReceiptDetails = feesItem.getStudentReceiptsItems();
                for (StudentReceiptDetail studentReceiptDetail : studentReceiptDetails) {
                    if (studentReceiptDetail.getPaymentStatus().getPaymentStatusId() == paymentStatus.getPaymentStatusId()) continue;
                    paidReceiptAmount = paidReceiptAmount + studentReceiptDetail.getPaidReceiptAmount();
                    discountAmount = discountAmount + studentReceiptDetail.getDiscountAmount();
                }
                outStandingAmount = totalAmount - (paidReceiptAmount + discountAmount);
                totalAmount = (double)Math.round(totalAmount * 100.0) / 100.0;
                paidReceiptAmount = (double)Math.round(paidReceiptAmount * 100.0) / 100.0;
                discountAmount = (double)Math.round(discountAmount * 100.0) / 100.0;
                outStandingAmount = (double)Math.round(outStandingAmount * 100.0) / 100.0;
                SixFieldReports sixFieldReport = new SixFieldReports(ItemId, ItemName, totalAmount, paidReceiptAmount, discountAmount, outStandingAmount);
                addSixFieldReports.add(sixFieldReport);
            }
            return addSixFieldReports;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public ArrayList<SixFieldReports> getCurrentAcademicYearLedgerAccountDetailsByInstitution(Long institutionId, String ledgerAccountName, Long paymentStatusId) throws Exception {
        try {
            Institution curinstitution = this.institutionDAO.getInstitutionById(institutionId);
            AcademicYear academicYear = this.academicYearDAO.getActiveAcademicYear(curinstitution);
            PaymentStatus paymentStatus = this.paymentStatusDAO.getPaymentStatusById(paymentStatusId);
            ArrayList<SixFieldReports> addSixFieldReports = new ArrayList<SixFieldReports>();
            if (academicYear != null) {
                Hibernate.initialize((Object)academicYear.getInstitution());
                Institution institution = this.institutionDAO.getInstitutionById(institutionId);
                InstituteLedgerAccount instituteLedgerAccount = this.instituteLedgerAccountDAO.getInstituteLedgerAccountByInstituteLedgerAccountName(ledgerAccountName, institution);
                Hibernate.initialize(instituteLedgerAccount.getFeesItems());
                Set<FeesItem> feesTemplateItems = instituteLedgerAccount.getFeesItems();
                for (FeesItem feesTemplateItem : feesTemplateItems) {
                    String templateItemName = "";
                    Double totalAmount = 0.0;
                    Double paidReceiptAmount = 0.0;
                    Double discountAmount = 0.0;
                    Double outStandingAmount = 0.0;
                    Hibernate.initialize((Object)feesTemplateItem);
                    templateItemName = feesTemplateItem.getFeesItemName();
                    Long templateItemId = feesTemplateItem.getFeesItemId();
                    Hibernate.initialize(feesTemplateItem.getStudentInvoiceItems());
                    Set<StudentInvoiceDetail> studentInvoiceDetails = feesTemplateItem.getStudentInvoiceItems();
                    for (StudentInvoiceDetail studentInvoiceDetail : studentInvoiceDetails) {
                        Long invoiceElementPaymentStatus = Long.parseLong(String.valueOf(studentInvoiceDetail.getStudentInvoiceElementPaymentStatus()));
                        if (studentInvoiceDetail.getAcademicYear().getAcademicYearId() != academicYear.getAcademicYearId() || paymentStatus.getPaymentStatusId() == invoiceElementPaymentStatus) continue;
                        totalAmount = totalAmount + studentInvoiceDetail.getStudentInvoiceElementTotalAmount();
                    }
                    Hibernate.initialize(feesTemplateItem.getStudentReceiptsItems());
                    Set<StudentReceiptDetail> studentReceiptDetails = feesTemplateItem.getStudentReceiptsItems();
                    for (StudentReceiptDetail studentReceiptDetail : studentReceiptDetails) {
                        if (studentReceiptDetail.getAcademicYear().getAcademicYearId() != academicYear.getAcademicYearId() || paymentStatus.getPaymentStatusId() == studentReceiptDetail.getPaymentStatus().getPaymentStatusId()) continue;
                        paidReceiptAmount = paidReceiptAmount + studentReceiptDetail.getPaidReceiptAmount();
                        discountAmount = discountAmount + studentReceiptDetail.getDiscountAmount();
                    }
                    outStandingAmount = totalAmount - (paidReceiptAmount + discountAmount);
                    totalAmount = (double)Math.round(totalAmount * 100.0) / 100.0;
                    paidReceiptAmount = (double)Math.round(paidReceiptAmount * 100.0) / 100.0;
                    discountAmount = (double)Math.round(discountAmount * 100.0) / 100.0;
                    outStandingAmount = (double)Math.round(outStandingAmount * 100.0) / 100.0;
                    SixFieldReports sixFieldReport = new SixFieldReports(templateItemId, templateItemName, totalAmount, paidReceiptAmount, discountAmount, outStandingAmount);
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
    public void institutionWithAdmin(Institution institution, Staff staff, Set<StaffExperienceDetail> staffExperiences, StaffBankDetail staffBankDetail) throws InstitutionException {
        block8: {
            try {
                List<Institution> institutions = this.institutionList();
                System.out.println(institutions.size());
                if (institutions.size() <= 4) {
                    Long institutionId = this.institutionDAO.save(institution).getInstitutionId();
                    Institution persistedinstitution = this.institutionDAO.getInstitutionById(institutionId);
                    UserRole adminRole = this.userRoleDAO.save(new UserRole("Administrator", persistedinstitution, new LinkedHashSet<Privilege>(this.PrivilegeDAO.privilegesByTargetType("admin")), "admin", true));
                    this.userRoleDAO.save(new UserRole("Principal", persistedinstitution, new LinkedHashSet<Privilege>(this.PrivilegeDAO.privilegesByTargetType("principal")), "principal", true));
                    this.userRoleDAO.save(new UserRole("Staff", persistedinstitution, new LinkedHashSet<Privilege>(this.PrivilegeDAO.privilegesByTargetType("staff")), "staff", true));
                    this.userRoleDAO.save(new UserRole("Student", persistedinstitution, new LinkedHashSet<Privilege>(this.PrivilegeDAO.privilegesByTargetType("student")), "student", true));
                    this.userRoleDAO.save(new UserRole("Parent", persistedinstitution, new LinkedHashSet<Privilege>(this.PrivilegeDAO.privilegesByTargetType("parent")), "parent", true));
                    this.userRoleDAO.save(new UserRole("AdmissionCandidate", persistedinstitution, new LinkedHashSet<Privilege>(this.PrivilegeDAO.privilegesByTargetType("admissioncandidate")), "admissioncandidate", true));
                    InstitutionConfigDetails institutionConfigDetail = this.institutionConfigDetailsDAO.getInstitutionConfigDetailsById(1L);
                    if (institutionConfigDetail.getFeeCollectionAdminType() == 0) {
                        this.userRoleDAO.save(new UserRole("FeesAdmin", persistedinstitution, new LinkedHashSet<Privilege>(this.PrivilegeDAO.privilegesByTargetType("feesadmin")), "feesadmin", true));
                    }
                    if (institutionConfigDetail.getInventoryAndAssetAdminType() == 0) {
                        this.userRoleDAO.save(new UserRole("InventoryandAssetAdmin", persistedinstitution, new LinkedHashSet<Privilege>(this.PrivilegeDAO.privilegesByTargetType("inventoryandassetadmin")), "inventoryandassetadmin", true));
                    }
                    if (institutionConfigDetail.getVisitorAdminType() == 0) {
                        this.userRoleDAO.save(new UserRole("VisitorAdmin", persistedinstitution, new LinkedHashSet<Privilege>(this.PrivilegeDAO.privilegesByTargetType("visitoradmin")), "visitoradmin", true));
                    }
                    if (institutionConfigDetail.getLibraryAdminType() == 0) {
                        this.userRoleDAO.save(new UserRole("LibraryAdmin", persistedinstitution, new LinkedHashSet<Privilege>(this.PrivilegeDAO.privilegesByTargetType("libraryadmin")), "libraryadmin", true));
                    }
                    StaffDesignation staffDesignation = this.staffDesignationDAO.save(staff.getStaffDesignation());
                    staff.setStaffDesignation(staffDesignation);
                    LinkedHashSet<UserRole> roles = new LinkedHashSet<UserRole>();
                    roles.add(adminRole);
                    staff.getUser().setUserRoles(roles);
                    User persistedUser = this.usersDAO.save(staff.getUser());
                    for (StaffExperienceDetail staffExperienceDetail : staffExperiences) {
                        staffExperienceDetail.setStaff(staff);
                    }
                    staffBankDetail.setStaff(staff);
                    staff.setUser(persistedUser);
                    staff.setApprover(persistedUser);
                    staff.setStaffExperienceDetails(staffExperiences);
                    staff.setStaffBankDetail(staffBankDetail);
                    this.staffDAO.persist(staff);
                    break block8;
                }
                throw new InstitutionException(new Message("failure", "Cannot create more than 3 Institutions "));
            }
            catch (Exception e) {
                e.printStackTrace();
                throw e;
            }
        }
    }

    @Override
    public ArrayList<NineFieldReports> getCurrentAcademicYearLedgerAccountDetailsWithoutTAXByInstitution(Long institutionId, Long paymentStatusId) throws Exception {
        try {
            AcademicYear academicYear = this.academicYearDAO.getActiveAcademicYear();
            PaymentStatus paymentStatus = this.paymentStatusDAO.getPaymentStatusById(paymentStatusId);
            ArrayList<NineFieldReports> addNineFieldReports = new ArrayList<NineFieldReports>();
            if (academicYear != null) {
                Hibernate.initialize((Object)academicYear.getInstitution());
                Institution institution = this.institutionDAO.getInstitutionById(institutionId);
                Hibernate.initialize(institution.getLedgerAccounts());
                Set<InstituteLedgerAccount> instituteLedgerAccounts = institution.getLedgerAccounts();
                for (InstituteLedgerAccount instituteLedgerAccount : instituteLedgerAccounts) {
                    String ledgerName = "";
                    Double totalAmount = 0.0;
                    Double totalOriginalAmount = 0.0;
                    Double totalTaxAmount = 0.0;
                    Double totalTaxPercentage = 0.0;
                    Double paidReceiptAmount = 0.0;
                    Double discountAmount = 0.0;
                    Double outStandingAmount = 0.0;
                    ledgerName = instituteLedgerAccount.getLedgerAccountName();
                    Long ledgerId = instituteLedgerAccount.getLedgerAccountId();
                    Hibernate.initialize(instituteLedgerAccount.getFeesItems());
                    Set<FeesItem> feesItems = instituteLedgerAccount.getFeesItems();
                    for (FeesItem feesItem : feesItems) {
                        Hibernate.initialize(feesItem.getStudentInvoiceItems());
                        Set<StudentInvoiceDetail> studentInvoiceDetails = feesItem.getStudentInvoiceItems();
                        for (StudentInvoiceDetail studentInvoiceDetail : studentInvoiceDetails) {
                            Long invoiceElementPaymentStatus = Long.parseLong(String.valueOf(studentInvoiceDetail.getStudentInvoiceElementPaymentStatus()));
                            if (studentInvoiceDetail.getAcademicYear().getAcademicYearId() != academicYear.getAcademicYearId() || paymentStatus.getPaymentStatusId() == invoiceElementPaymentStatus) continue;
                            totalAmount = totalAmount + studentInvoiceDetail.getStudentInvoiceElementTotalAmount();
                            totalOriginalAmount = totalOriginalAmount + feesItem.getOriginalFeesItemPrice();
                            totalTaxPercentage = totalTaxPercentage + feesItem.getTotalGSTPercentage();
                        }
                        Hibernate.initialize(feesItem.getStudentReceiptsItems());
                        Set<StudentReceiptDetail> studentReceiptDetails = feesItem.getStudentReceiptsItems();
                        for (StudentReceiptDetail studentReceiptDetail : studentReceiptDetails) {
                            if (studentReceiptDetail.getAcademicYear().getAcademicYearId() != academicYear.getAcademicYearId() || paymentStatus.getPaymentStatusId() == studentReceiptDetail.getPaymentStatus().getPaymentStatusId()) continue;
                            paidReceiptAmount = paidReceiptAmount + studentReceiptDetail.getPaidReceiptAmount();
                            discountAmount = discountAmount + studentReceiptDetail.getDiscountAmount();
                        }
                    }
                    totalTaxAmount = totalAmount - totalOriginalAmount;
                    outStandingAmount = totalAmount - (paidReceiptAmount + discountAmount);
                    totalAmount = (double)Math.round(totalAmount * 100.0) / 100.0;
                    paidReceiptAmount = (double)Math.round(paidReceiptAmount * 100.0) / 100.0;
                    discountAmount = (double)Math.round(discountAmount * 100.0) / 100.0;
                    outStandingAmount = (double)Math.round(outStandingAmount * 100.0) / 100.0;
                    NineFieldReports nineFieldReport = new NineFieldReports(ledgerId, ledgerName, totalAmount, paidReceiptAmount, discountAmount, outStandingAmount, totalOriginalAmount, totalTaxAmount, totalTaxPercentage);
                    addNineFieldReports.add(nineFieldReport);
                }
            }
            return addNineFieldReports;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public ArrayList<NineFieldReports> getInstitutionLedgerAccountDetailsWithoutTAX(Long institutionId, Long paymentStatusId) throws Exception {
        try {
            ArrayList<NineFieldReports> addNineFieldReports = new ArrayList<NineFieldReports>();
            PaymentStatus paymentStatus = this.paymentStatusDAO.getPaymentStatusById(paymentStatusId);
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            Hibernate.initialize(institution.getLedgerAccounts());
            Set<InstituteLedgerAccount> instituteLedgerAccounts = institution.getLedgerAccounts();
            for (InstituteLedgerAccount instituteLedgerAccount : instituteLedgerAccounts) {
                String ledgerName = "";
                Double totalAmount = 0.0;
                Double paidReceiptAmount = 0.0;
                Double discountAmount = 0.0;
                Double outStandingAmount = 0.0;
                Double totalOriginalAmount = 0.0;
                Double totalTaxAmount = 0.0;
                Double totalTaxPercentage = 0.0;
                ledgerName = instituteLedgerAccount.getLedgerAccountName();
                Long ledgerId = instituteLedgerAccount.getLedgerAccountId();
                Hibernate.initialize(instituteLedgerAccount.getFeesItems());
                Set<FeesItem> feesItems = instituteLedgerAccount.getFeesItems();
                for (FeesItem feesItem : feesItems) {
                    Hibernate.initialize(feesItem.getStudentInvoiceItems());
                    Set<StudentInvoiceDetail> studentInvoiceDetails = feesItem.getStudentInvoiceItems();
                    for (StudentInvoiceDetail studentInvoiceDetail : studentInvoiceDetails) {
                        totalAmount = totalAmount + studentInvoiceDetail.getStudentInvoiceElementTotalAmount();
                        totalOriginalAmount = totalOriginalAmount + feesItem.getOriginalFeesItemPrice();
                        totalTaxPercentage = totalTaxPercentage + feesItem.getTotalGSTPercentage();
                    }
                    Hibernate.initialize(feesItem.getStudentReceiptsItems());
                    Set<StudentReceiptDetail> studentReceiptDetails = feesItem.getStudentReceiptsItems();
                    for (StudentReceiptDetail studentReceiptDetail : studentReceiptDetails) {
                        if (paymentStatus.getPaymentStatusId() == studentReceiptDetail.getPaymentStatus().getPaymentStatusId()) continue;
                        paidReceiptAmount = paidReceiptAmount + studentReceiptDetail.getPaidReceiptAmount();
                        discountAmount = discountAmount + studentReceiptDetail.getDiscountAmount();
                    }
                }
                totalTaxAmount = totalAmount - totalOriginalAmount;
                outStandingAmount = totalAmount - (paidReceiptAmount + discountAmount);
                totalAmount = (double)Math.round(totalAmount * 100.0) / 100.0;
                paidReceiptAmount = (double)Math.round(paidReceiptAmount * 100.0) / 100.0;
                discountAmount = (double)Math.round(discountAmount * 100.0) / 100.0;
                outStandingAmount = (double)Math.round(outStandingAmount * 100.0) / 100.0;
                NineFieldReports nineFieldReport = new NineFieldReports(ledgerId, ledgerName, totalAmount, paidReceiptAmount, discountAmount, outStandingAmount, totalOriginalAmount, totalTaxAmount, totalTaxPercentage);
                addNineFieldReports.add(nineFieldReport);
            }
            return addNineFieldReports;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public ArrayList<NineFieldReports> getInstitutionLedgerAccountDetailsByAcademicYearWithoutTAX(Long academicYearId, Long paymentStatusId) throws Exception {
        try {
            AcademicYear academicYear = this.academicYearDAO.getAcademicYearById(academicYearId);
            PaymentStatus paymentStatus = this.paymentStatusDAO.getPaymentStatusById(paymentStatusId);
            ArrayList<NineFieldReports> addNineFieldReports = new ArrayList<NineFieldReports>();
            Hibernate.initialize((Object)academicYear.getInstitution());
            Institution institution = academicYear.getInstitution();
            Hibernate.initialize(institution.getLedgerAccounts());
            Set<InstituteLedgerAccount> instituteLedgerAccounts = institution.getLedgerAccounts();
            for (InstituteLedgerAccount instituteLedgerAccount : instituteLedgerAccounts) {
                String ledgerName = "";
                Double totalAmount = 0.0;
                Double paidReceiptAmount = 0.0;
                Double discountAmount = 0.0;
                Double outStandingAmount = 0.0;
                Double totalOriginalAmount = 0.0;
                Double totalTaxAmount = 0.0;
                Double totalTaxPercentage = 0.0;
                ledgerName = instituteLedgerAccount.getLedgerAccountName();
                Long ledgerId = instituteLedgerAccount.getLedgerAccountId();
                Hibernate.initialize(instituteLedgerAccount.getFeesItems());
                Set<FeesItem> feesItems = instituteLedgerAccount.getFeesItems();
                for (FeesItem feesItem : feesItems) {
                    Hibernate.initialize(feesItem.getStudentInvoiceItems());
                    Set<StudentInvoiceDetail> studentInvoiceDetails = feesItem.getStudentInvoiceItems();
                    for (StudentInvoiceDetail studentInvoiceDetail : studentInvoiceDetails) {
                        Long invoiceElementPaymentStatus = Long.parseLong(String.valueOf(studentInvoiceDetail.getStudentInvoiceElementPaymentStatus()));
                        if (studentInvoiceDetail.getAcademicYear().getAcademicYearId() != academicYear.getAcademicYearId() || paymentStatus.getPaymentStatusId() == invoiceElementPaymentStatus) continue;
                        totalAmount = totalAmount + studentInvoiceDetail.getStudentInvoiceElementTotalAmount();
                        totalOriginalAmount = totalOriginalAmount + feesItem.getOriginalFeesItemPrice();
                        totalTaxPercentage = totalTaxPercentage + feesItem.getTotalGSTPercentage();
                    }
                    Hibernate.initialize(feesItem.getStudentReceiptsItems());
                    Set<StudentReceiptDetail> studentReceiptDetails = feesItem.getStudentReceiptsItems();
                    for (StudentReceiptDetail studentReceiptDetail : studentReceiptDetails) {
                        if (studentReceiptDetail.getAcademicYear().getAcademicYearId() != academicYear.getAcademicYearId() || paymentStatus.getPaymentStatusId() == studentReceiptDetail.getPaymentStatus().getPaymentStatusId()) continue;
                        paidReceiptAmount = paidReceiptAmount + studentReceiptDetail.getPaidReceiptAmount();
                        discountAmount = discountAmount + studentReceiptDetail.getDiscountAmount();
                    }
                }
                totalTaxAmount = totalAmount - totalOriginalAmount;
                outStandingAmount = totalAmount - (paidReceiptAmount + discountAmount);
                totalAmount = (double)Math.round(totalAmount * 100.0) / 100.0;
                paidReceiptAmount = (double)Math.round(paidReceiptAmount * 100.0) / 100.0;
                discountAmount = (double)Math.round(discountAmount * 100.0) / 100.0;
                outStandingAmount = (double)Math.round(outStandingAmount * 100.0) / 100.0;
                NineFieldReports nineFieldReport = new NineFieldReports(ledgerId, ledgerName, totalAmount, paidReceiptAmount, discountAmount, outStandingAmount, totalOriginalAmount, totalTaxAmount, totalTaxPercentage);
                addNineFieldReports.add(nineFieldReport);
            }
            return addNineFieldReports;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public ArrayList<NineFieldReports> getInstitutionLedgerAccountDetailsByAcademicYearWithoutTAX(Long academicYearId, Long institutionId, String ledgerAccountName, Long paymentStatusId) throws Exception {
        try {
            AcademicYear academicYear = this.academicYearDAO.getAcademicYearById(academicYearId);
            ArrayList<NineFieldReports> addNineFieldReports = new ArrayList<NineFieldReports>();
            PaymentStatus paymentStatus = this.paymentStatusDAO.getPaymentStatusById(paymentStatusId);
            Hibernate.initialize((Object)academicYear.getInstitution());
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            InstituteLedgerAccount instituteLedgerAccount = this.instituteLedgerAccountDAO.getInstituteLedgerAccountByInstituteLedgerAccountName(ledgerAccountName, institution);
            Hibernate.initialize(instituteLedgerAccount.getFeesItems());
            Set<FeesItem> feesItems = instituteLedgerAccount.getFeesItems();
            for (FeesItem feesItem : feesItems) {
                String ItemName = "";
                Double totalAmount = 0.0;
                Double paidReceiptAmount = 0.0;
                Double discountAmount = 0.0;
                Double outStandingAmount = 0.0;
                Double totalOriginalAmount = 0.0;
                Double totalTaxAmount = 0.0;
                Double totalTaxPercentage = 0.0;
                Hibernate.initialize((Object)feesItem);
                ItemName = feesItem.getFeesItemName();
                Long ItemId = feesItem.getFeesItemId();
                Hibernate.initialize(feesItem.getStudentInvoiceItems());
                Set<StudentInvoiceDetail> studentInvoiceDetails = feesItem.getStudentInvoiceItems();
                for (StudentInvoiceDetail studentInvoiceDetail : studentInvoiceDetails) {
                    Long invoiceElementPaymentStatus = Long.parseLong(String.valueOf(studentInvoiceDetail.getStudentInvoiceElementPaymentStatus()));
                    if (studentInvoiceDetail.getAcademicYear().getAcademicYearId() != academicYear.getAcademicYearId() || paymentStatus.getPaymentStatusId() == invoiceElementPaymentStatus) continue;
                    totalAmount = totalAmount + studentInvoiceDetail.getStudentInvoiceElementTotalAmount();
                    totalOriginalAmount = totalOriginalAmount + feesItem.getOriginalFeesItemPrice();
                    totalTaxPercentage = totalTaxPercentage + feesItem.getTotalGSTPercentage();
                }
                Hibernate.initialize(feesItem.getStudentReceiptsItems());
                Set<StudentReceiptDetail> studentReceiptDetails = feesItem.getStudentReceiptsItems();
                for (StudentReceiptDetail studentReceiptDetail : studentReceiptDetails) {
                    if (studentReceiptDetail.getAcademicYear().getAcademicYearId() != academicYear.getAcademicYearId() || paymentStatus.getPaymentStatusId() == studentReceiptDetail.getPaymentStatus().getPaymentStatusId()) continue;
                    paidReceiptAmount = paidReceiptAmount + studentReceiptDetail.getPaidReceiptAmount();
                    discountAmount = discountAmount + studentReceiptDetail.getDiscountAmount();
                }
                totalTaxAmount = totalAmount - totalOriginalAmount;
                outStandingAmount = totalAmount - (paidReceiptAmount + discountAmount);
                totalAmount = (double)Math.round(totalAmount * 100.0) / 100.0;
                paidReceiptAmount = (double)Math.round(paidReceiptAmount * 100.0) / 100.0;
                discountAmount = (double)Math.round(discountAmount * 100.0) / 100.0;
                outStandingAmount = (double)Math.round(outStandingAmount * 100.0) / 100.0;
                NineFieldReports nineFieldReport = new NineFieldReports(ItemId, ItemName, totalAmount, paidReceiptAmount, discountAmount, outStandingAmount, totalOriginalAmount, totalTaxAmount, totalTaxPercentage);
                addNineFieldReports.add(nineFieldReport);
            }
            return addNineFieldReports;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public ArrayList<NineFieldReports> getInstitutionLedgerAccountListByNameEagerWithoutTAX(String ledgerAccountName, Long institutionId, Long paymentStatusId) {
        try {
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            InstituteLedgerAccount instituteLedgerAccount = this.instituteLedgerAccountDAO.getInstituteLedgerAccountByInstituteLedgerAccountName(ledgerAccountName, institution);
            PaymentStatus paymentStatus = this.paymentStatusDAO.getPaymentStatusById(paymentStatusId);
            Hibernate.initialize(instituteLedgerAccount.getFeesItems());
            Set<FeesItem> feesItems = instituteLedgerAccount.getFeesItems();
            ArrayList<NineFieldReports> addNineFieldReports = new ArrayList<NineFieldReports>();
            for (FeesItem feesItem : feesItems) {
                String ItemName = "";
                Double totalAmount = 0.0;
                Double paidReceiptAmount = 0.0;
                Double discountAmount = 0.0;
                Double outStandingAmount = 0.0;
                Double totalOriginalAmount = 0.0;
                Double totalTaxAmount = 0.0;
                Double totalTaxPercentage = 0.0;
                Hibernate.initialize((Object)feesItem);
                ItemName = feesItem.getFeesItemName();
                Long ItemId = feesItem.getFeesItemId();
                Hibernate.initialize(feesItem.getStudentInvoiceItems());
                Set<StudentInvoiceDetail> studentInvoiceDetails = feesItem.getStudentInvoiceItems();
                for (StudentInvoiceDetail studentInvoiceDetail : studentInvoiceDetails) {
                    Long invoiceElementPaymentStatus = Long.parseLong(String.valueOf(studentInvoiceDetail.getStudentInvoiceElementPaymentStatus()));
                    if (invoiceElementPaymentStatus == paymentStatus.getPaymentStatusId()) continue;
                    totalAmount = totalAmount + studentInvoiceDetail.getStudentInvoiceElementTotalAmount();
                    totalOriginalAmount = totalOriginalAmount + feesItem.getOriginalFeesItemPrice();
                    totalTaxPercentage = totalTaxPercentage + feesItem.getTotalGSTPercentage();
                }
                Hibernate.initialize(feesItem.getStudentReceiptsItems());
                Set<StudentReceiptDetail> studentReceiptDetails = feesItem.getStudentReceiptsItems();
                for (StudentReceiptDetail studentReceiptDetail : studentReceiptDetails) {
                    if (studentReceiptDetail.getPaymentStatus().getPaymentStatusId() == paymentStatus.getPaymentStatusId()) continue;
                    paidReceiptAmount = paidReceiptAmount + studentReceiptDetail.getPaidReceiptAmount();
                    discountAmount = discountAmount + studentReceiptDetail.getDiscountAmount();
                }
                totalTaxAmount = totalAmount - totalOriginalAmount;
                outStandingAmount = totalAmount - (paidReceiptAmount + discountAmount);
                totalAmount = (double)Math.round(totalAmount * 100.0) / 100.0;
                paidReceiptAmount = (double)Math.round(paidReceiptAmount * 100.0) / 100.0;
                discountAmount = (double)Math.round(discountAmount * 100.0) / 100.0;
                outStandingAmount = (double)Math.round(outStandingAmount * 100.0) / 100.0;
                NineFieldReports nineFieldReport = new NineFieldReports(ItemId, ItemName, totalAmount, paidReceiptAmount, discountAmount, outStandingAmount, totalOriginalAmount, totalTaxAmount, totalTaxPercentage);
                addNineFieldReports.add(nineFieldReport);
            }
            return addNineFieldReports;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public ArrayList<NineFieldReports> getCurrentAcademicYearLedgerAccountDetailsByInstitutionWithoutTAX(Long institutionId, String ledgerAccountName, Long paymentStatusId) throws Exception {
        try {
            Institution curinstitution = this.institutionDAO.getInstitutionById(institutionId);
            AcademicYear academicYear = this.academicYearDAO.getActiveAcademicYear(curinstitution);
            PaymentStatus paymentStatus = this.paymentStatusDAO.getPaymentStatusById(paymentStatusId);
            ArrayList<NineFieldReports> addNineFieldReports = new ArrayList<NineFieldReports>();
            if (academicYear != null) {
                Hibernate.initialize((Object)academicYear.getInstitution());
                Institution institution = this.institutionDAO.getInstitutionById(institutionId);
                InstituteLedgerAccount instituteLedgerAccount = this.instituteLedgerAccountDAO.getInstituteLedgerAccountByInstituteLedgerAccountName(ledgerAccountName, institution);
                Hibernate.initialize(instituteLedgerAccount.getFeesItems());
                Set<FeesItem> feesTemplateItems = instituteLedgerAccount.getFeesItems();
                for (FeesItem feesTemplateItem : feesTemplateItems) {
                    String templateItemName = "";
                    Double totalAmount = 0.0;
                    Double paidReceiptAmount = 0.0;
                    Double discountAmount = 0.0;
                    Double outStandingAmount = 0.0;
                    Double totalOriginalAmount = 0.0;
                    Double totalTaxAmount = 0.0;
                    Double totalTaxPercentage = 0.0;
                    Hibernate.initialize((Object)feesTemplateItem);
                    templateItemName = feesTemplateItem.getFeesItemName();
                    Long templateItemId = feesTemplateItem.getFeesItemId();
                    Hibernate.initialize(feesTemplateItem.getStudentInvoiceItems());
                    Set<StudentInvoiceDetail> studentInvoiceDetails = feesTemplateItem.getStudentInvoiceItems();
                    for (StudentInvoiceDetail studentInvoiceDetail : studentInvoiceDetails) {
                        Long invoiceElementPaymentStatus = Long.parseLong(String.valueOf(studentInvoiceDetail.getStudentInvoiceElementPaymentStatus()));
                        if (studentInvoiceDetail.getAcademicYear().getAcademicYearId() != academicYear.getAcademicYearId() || paymentStatus.getPaymentStatusId() == invoiceElementPaymentStatus) continue;
                        totalAmount = totalAmount + studentInvoiceDetail.getStudentInvoiceElementTotalAmount();
                        totalOriginalAmount = totalOriginalAmount + feesTemplateItem.getOriginalFeesItemPrice();
                        totalTaxPercentage = totalTaxPercentage + feesTemplateItem.getTotalGSTPercentage();
                    }
                    Hibernate.initialize(feesTemplateItem.getStudentReceiptsItems());
                    Set<StudentReceiptDetail> studentReceiptDetails = feesTemplateItem.getStudentReceiptsItems();
                    for (StudentReceiptDetail studentReceiptDetail : studentReceiptDetails) {
                        if (studentReceiptDetail.getAcademicYear().getAcademicYearId() != academicYear.getAcademicYearId() || paymentStatus.getPaymentStatusId() == studentReceiptDetail.getPaymentStatus().getPaymentStatusId()) continue;
                        paidReceiptAmount = paidReceiptAmount + studentReceiptDetail.getPaidReceiptAmount();
                        discountAmount = discountAmount + studentReceiptDetail.getDiscountAmount();
                    }
                    totalTaxAmount = totalAmount - totalOriginalAmount;
                    outStandingAmount = totalAmount - (paidReceiptAmount + discountAmount);
                    totalAmount = (double)Math.round(totalAmount * 100.0) / 100.0;
                    paidReceiptAmount = (double)Math.round(paidReceiptAmount * 100.0) / 100.0;
                    discountAmount = (double)Math.round(discountAmount * 100.0) / 100.0;
                    outStandingAmount = (double)Math.round(outStandingAmount * 100.0) / 100.0;
                    NineFieldReports nineFieldReport = new NineFieldReports(templateItemId, templateItemName, totalAmount, paidReceiptAmount, discountAmount, outStandingAmount, totalOriginalAmount, totalTaxAmount, totalTaxPercentage);
                    addNineFieldReports.add(nineFieldReport);
                }
            }
            return addNineFieldReports;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public ArrayList<NineFieldReports> getInstitutionLedgerByInvoiceDateWithoutTAX(Long institutionId, Date fromDate, Date toDate, Long paymentStatusId) throws Exception {
        try {
            ArrayList<NineFieldReports> addNineFieldReports = new ArrayList<NineFieldReports>();
            PaymentStatus paymentStatus = this.paymentStatusDAO.getPaymentStatusById(paymentStatusId);
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            Hibernate.initialize(institution.getLedgerAccounts());
            Set<InstituteLedgerAccount> instituteLedgerAccounts = institution.getLedgerAccounts();
            for (InstituteLedgerAccount instituteLedgerAccount : instituteLedgerAccounts) {
                String ledgerName = "";
                Double totalAmount = 0.0;
                Double paidReceiptAmount = 0.0;
                Double discountAmount = 0.0;
                Double outStandingAmount = 0.0;
                Double totalOriginalAmount = 0.0;
                Double totalTaxAmount = 0.0;
                Double totalTaxPercentage = 0.0;
                ledgerName = instituteLedgerAccount.getLedgerAccountName();
                Long ledgerId = instituteLedgerAccount.getLedgerAccountId();
                Hibernate.initialize(instituteLedgerAccount.getFeesItems());
                Set<FeesItem> feesItems = instituteLedgerAccount.getFeesItems();
                for (FeesItem feesItem : feesItems) {
                    Hibernate.initialize(feesItem.getStudentInvoiceItems());
                    Set<StudentInvoiceDetail> studentInvoiceDetails = feesItem.getStudentInvoiceItems();
                    for (StudentInvoiceDetail studentInvoiceDetail : studentInvoiceDetails) {
                        StudentInvoiceDetail curStudentInvoiceDetail = this.studentInvoiceDetailDAO.getStudentInvoiceDetailByDate(studentInvoiceDetail.getStudentInvoiceDetailId(), fromDate, toDate);
                        Long curElementPaymentStatus = Long.parseLong(String.valueOf(curStudentInvoiceDetail.getStudentInvoiceElementPaymentStatus()));
                        if (curStudentInvoiceDetail == null || paymentStatus.getPaymentStatusId() == curElementPaymentStatus) continue;
                        totalAmount = totalAmount + curStudentInvoiceDetail.getStudentInvoiceElementTotalAmount();
                        totalOriginalAmount = totalOriginalAmount + feesItem.getOriginalFeesItemPrice();
                        totalTaxPercentage = totalTaxPercentage + feesItem.getTotalGSTPercentage();
                    }
                }
                totalTaxAmount = totalAmount - totalOriginalAmount;
                totalAmount = (double)Math.round(totalAmount * 100.0) / 100.0;
                paidReceiptAmount = (double)Math.round(paidReceiptAmount * 100.0) / 100.0;
                discountAmount = (double)Math.round(discountAmount * 100.0) / 100.0;
                outStandingAmount = (double)Math.round(outStandingAmount * 100.0) / 100.0;
                NineFieldReports nineFieldReport = new NineFieldReports(ledgerId, ledgerName, totalAmount, paidReceiptAmount, discountAmount, outStandingAmount, totalOriginalAmount, totalTaxAmount, totalTaxPercentage);
                addNineFieldReports.add(nineFieldReport);
            }
            return addNineFieldReports;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public ArrayList<NineFieldReports> getInstitutionLedgerByReceiptDateWithoutTAX(Long institutionId, Date fromDate, Date toDate, Long paymentStatusId) throws Exception {
        try {
            ArrayList<NineFieldReports> addNineFieldReports = new ArrayList<NineFieldReports>();
            PaymentStatus paymentStatus = this.paymentStatusDAO.getPaymentStatusById(paymentStatusId);
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            Hibernate.initialize(institution.getLedgerAccounts());
            Set<InstituteLedgerAccount> instituteLedgerAccounts = institution.getLedgerAccounts();
            for (InstituteLedgerAccount instituteLedgerAccount : instituteLedgerAccounts) {
                String ledgerName = "";
                Double totalAmount = 0.0;
                Double paidReceiptAmount = 0.0;
                Double discountAmount = 0.0;
                Double outStandingAmount = 0.0;
                Double totalOriginalAmount = 0.0;
                Double totalTaxAmount = 0.0;
                Double totalTaxPercentage = 0.0;
                ledgerName = instituteLedgerAccount.getLedgerAccountName();
                Long ledgerId = instituteLedgerAccount.getLedgerAccountId();
                Hibernate.initialize(instituteLedgerAccount.getFeesItems());
                Set<FeesItem> feesItems = instituteLedgerAccount.getFeesItems();
                for (FeesItem feesItem : feesItems) {
                    Hibernate.initialize(feesItem.getStudentReceiptsItems());
                    Set<StudentReceiptDetail> studentReceiptDetails = feesItem.getStudentReceiptsItems();
                    for (StudentReceiptDetail studentReceiptDetail : studentReceiptDetails) {
                        StudentReceiptDetail curStudentReceiptDetail = this.studentReceiptDetailDAO.getStudentReceiptDetailByDate(fromDate, toDate, studentReceiptDetail.getStudentReceiptDetailId());
                        if (curStudentReceiptDetail == null || paymentStatus.getPaymentStatusId() == curStudentReceiptDetail.getPaymentStatus().getPaymentStatusId()) continue;
                        paidReceiptAmount = paidReceiptAmount + curStudentReceiptDetail.getPaidReceiptAmount();
                        discountAmount = discountAmount + curStudentReceiptDetail.getDiscountAmount();
                        totalTaxAmount = totalTaxAmount + (feesItem.getFeesItemPrice() - feesItem.getOriginalFeesItemPrice());
                        totalOriginalAmount = totalOriginalAmount + feesItem.getOriginalFeesItemPrice();
                        totalTaxPercentage = totalTaxPercentage + feesItem.getTotalGSTPercentage();
                    }
                }
                totalAmount = (double)Math.round(totalAmount * 100.0) / 100.0;
                paidReceiptAmount = (double)Math.round(paidReceiptAmount * 100.0) / 100.0;
                discountAmount = (double)Math.round(discountAmount * 100.0) / 100.0;
                outStandingAmount = (double)Math.round(outStandingAmount * 100.0) / 100.0;
                NineFieldReports nineFieldReport = new NineFieldReports(ledgerId, ledgerName, totalAmount, paidReceiptAmount, discountAmount, outStandingAmount, totalOriginalAmount, totalTaxAmount, totalTaxPercentage);
                addNineFieldReports.add(nineFieldReport);
            }
            return addNineFieldReports;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public ArrayList<NineFieldReports> getInstitutionLedgerAccountListByReceiptWithoutTAX(String ledgerAccountName, Long institutionId, Date fromDate, Date toDate, Long paymentStatusId) {
        Institution institution = this.institutionDAO.getInstitutionById(institutionId);
        InstituteLedgerAccount instituteLedgerAccount = this.instituteLedgerAccountDAO.getInstituteLedgerAccountByInstituteLedgerAccountName(ledgerAccountName, institution);
        PaymentStatus paymentStatus = this.paymentStatusDAO.getPaymentStatusById(paymentStatusId);
        Hibernate.initialize(instituteLedgerAccount.getFeesItems());
        Set<FeesItem> feesItems = instituteLedgerAccount.getFeesItems();
        ArrayList<NineFieldReports> addNineFieldReports = new ArrayList<NineFieldReports>();
        for (FeesItem feesItem : feesItems) {
            Hibernate.initialize((Object)feesItem);
            Hibernate.initialize(feesItem.getStudentReceiptsItems());
            String ItemName = "";
            Double totalAmount = 0.0;
            Double paidReceiptAmount = 0.0;
            Double discountAmount = 0.0;
            Double outStandingAmount = 0.0;
            Double totalOriginalAmount = 0.0;
            Double totalTaxAmount = 0.0;
            Double totalTaxPercentage = 0.0;
            Hibernate.initialize((Object)feesItem);
            ItemName = feesItem.getFeesItemName();
            Long ItemId = feesItem.getFeesItemId();
            for (StudentReceiptDetail studentReceiptDetail : feesItem.getStudentReceiptsItems()) {
                StudentReceiptDetail curStudentReceiptDetail = this.studentReceiptDetailDAO.getStudentReceiptDetailByDate(fromDate, toDate, studentReceiptDetail.getStudentReceiptDetailId());
                if (curStudentReceiptDetail == null || paymentStatus.getPaymentStatusId() == curStudentReceiptDetail.getPaymentStatus().getPaymentStatusId()) continue;
                paidReceiptAmount = paidReceiptAmount + curStudentReceiptDetail.getPaidReceiptAmount();
                discountAmount = discountAmount + curStudentReceiptDetail.getDiscountAmount();
                totalTaxAmount = totalTaxAmount + (feesItem.getFeesItemPrice() - feesItem.getOriginalFeesItemPrice());
                totalOriginalAmount = totalOriginalAmount + feesItem.getOriginalFeesItemPrice();
                totalTaxPercentage = totalTaxPercentage + feesItem.getTotalGSTPercentage();
            }
            totalAmount = (double)Math.round(totalAmount * 100.0) / 100.0;
            paidReceiptAmount = (double)Math.round(paidReceiptAmount * 100.0) / 100.0;
            discountAmount = (double)Math.round(discountAmount * 100.0) / 100.0;
            outStandingAmount = (double)Math.round(outStandingAmount * 100.0) / 100.0;
            NineFieldReports nineFieldReport = new NineFieldReports(ItemId, ItemName, totalAmount, paidReceiptAmount, discountAmount, outStandingAmount, totalOriginalAmount, totalTaxAmount, totalTaxPercentage);
            addNineFieldReports.add(nineFieldReport);
        }
        return addNineFieldReports;
    }

    @Override
    public ArrayList<NineFieldReports> getInstitutionLedgerAccountListByInvoiceWithoutTAX(String ledgerAccountName, Long institutionId, Date fromDate, Date toDate, Long paymentStatusId) {
        Institution institution = this.institutionDAO.getInstitutionById(institutionId);
        InstituteLedgerAccount instituteLedgerAccount = this.instituteLedgerAccountDAO.getInstituteLedgerAccountByInstituteLedgerAccountName(ledgerAccountName, institution);
        PaymentStatus paymentStatus = this.paymentStatusDAO.getPaymentStatusById(paymentStatusId);
        Hibernate.initialize(instituteLedgerAccount.getFeesItems());
        Set<FeesItem> feesItems = instituteLedgerAccount.getFeesItems();
        ArrayList<NineFieldReports> addNineFieldReports = new ArrayList<NineFieldReports>();
        for (FeesItem feesItem : feesItems) {
            String ItemName = "";
            Double totalAmount = 0.0;
            Double paidReceiptAmount = 0.0;
            Double discountAmount = 0.0;
            Double outStandingAmount = 0.0;
            Double totalOriginalAmount = 0.0;
            Double totalTaxAmount = 0.0;
            Double totalTaxPercentage = 0.0;
            Hibernate.initialize((Object)feesItem);
            Hibernate.initialize(feesItem.getStudentInvoiceItems());
            ItemName = feesItem.getFeesItemName();
            Long ItemId = feesItem.getFeesItemId();
            for (StudentInvoiceDetail studentInvoiceDetail : feesItem.getStudentInvoiceItems()) {
                StudentInvoiceDetail curStudentInvoiceDetail = this.studentInvoiceDetailDAO.getStudentInvoiceDetailByDate(studentInvoiceDetail.getStudentInvoiceDetailId(), fromDate, toDate);
                Long invoiceElementPaymentStatus = Long.parseLong(String.valueOf(curStudentInvoiceDetail.getStudentInvoiceElementPaymentStatus()));
                if (curStudentInvoiceDetail == null || paymentStatus.getPaymentStatusId() == invoiceElementPaymentStatus) continue;
                totalAmount = totalAmount + curStudentInvoiceDetail.getStudentInvoiceElementTotalAmount();
                totalOriginalAmount = totalOriginalAmount + feesItem.getOriginalFeesItemPrice();
                totalTaxPercentage = totalTaxPercentage + feesItem.getTotalGSTPercentage();
            }
            totalTaxAmount = totalAmount - totalOriginalAmount;
            totalAmount = (double)Math.round(totalAmount * 100.0) / 100.0;
            paidReceiptAmount = (double)Math.round(paidReceiptAmount * 100.0) / 100.0;
            discountAmount = (double)Math.round(discountAmount * 100.0) / 100.0;
            outStandingAmount = (double)Math.round(outStandingAmount * 100.0) / 100.0;
            NineFieldReports nineFieldReport = new NineFieldReports(ItemId, ItemName, totalAmount, paidReceiptAmount, discountAmount, outStandingAmount, totalOriginalAmount, totalTaxAmount, totalTaxPercentage);
            addNineFieldReports.add(nineFieldReport);
        }
        return addNineFieldReports;
    }
}
