/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.dao.DataIntegrityViolationException
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.exceptions.InstitutionException;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.InstituteLedgerAccount;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.InstitutionConfigDetails;
import in.jdsoft.educationmanagement.school.model.License;
import in.jdsoft.educationmanagement.school.model.Staff;
import in.jdsoft.educationmanagement.school.model.StaffBankDetail;
import in.jdsoft.educationmanagement.school.model.StaffExperienceDetail;
import in.jdsoft.educationmanagement.school.reports.model.NineFieldReports;
import in.jdsoft.educationmanagement.school.reports.model.SixFieldReports;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface InstitutionService {
    public static final Logger log = LogManager.getLogger((String)InstitutionService.class.getName());

    public void setUpInstitutionWithAdmin(Institution var1, Staff var2, Set<StaffExperienceDetail> var3, StaffBankDetail var4, License var5, String var6, InstitutionConfigDetails var7);

    public List<Institution> institutionList();

    public Institution institutionById(Long var1);

    public void deleteInstitution(Long var1) throws DataIntegrityViolationException;

    public void updateInstitution(Institution var1);

    public Institution institutionByUserRoleAdmin(Long var1);

    public void updateInstitutionWithAdmin(Institution var1, Staff var2, Set<StaffExperienceDetail> var3);

    public void addInstituteLedgerAccount(InstituteLedgerAccount var1) throws InstitutionException;

    public void updateLedgerAccount(InstituteLedgerAccount var1) throws DataIntegrityViolationException;

    public void deleteLedgerAccount(Long var1) throws DataIntegrityViolationException;

    public ArrayList<InstituteLedgerAccount> ledgerAccountList();

    public ArrayList<InstituteLedgerAccount> ledgerAccountListByInstitution(Long var1);

    public InstituteLedgerAccount ledgerAccountById(Long var1);

    public ArrayList<SixFieldReports> getInstitutionLedgerByInvoiceDate(Long var1, Date var2, Date var3, Long var4) throws Exception;

    public ArrayList<NineFieldReports> getInstitutionLedgerByInvoiceDateWithoutTAX(Long var1, Date var2, Date var3, Long var4) throws Exception;

    public ArrayList<SixFieldReports> getInstitutionLedgerByReceiptDate(Long var1, Date var2, Date var3, Long var4) throws Exception;

    public ArrayList<NineFieldReports> getInstitutionLedgerByReceiptDateWithoutTAX(Long var1, Date var2, Date var3, Long var4) throws Exception;

    public ArrayList<SixFieldReports> getInstitutionLedgerAccountDetailsByAcademicYear(Long var1, Long var2, String var3, Long var4) throws Exception;

    public ArrayList<NineFieldReports> getInstitutionLedgerAccountDetailsByAcademicYearWithoutTAX(Long var1, Long var2, String var3, Long var4) throws Exception;

    public ArrayList<SixFieldReports> getCurrentAcademicYearLedgerAccountDetailsByInstitution(Long var1, Long var2) throws Exception;

    public ArrayList<NineFieldReports> getCurrentAcademicYearLedgerAccountDetailsWithoutTAXByInstitution(Long var1, Long var2) throws Exception;

    public AcademicYear getCurrentActiveAcademicYearFineDetailsByInstitution(Long var1) throws Exception;

    public Set<AcademicYear> getAcademicYearFineDetailsByInstitution(Long var1) throws Exception;

    public Set<AcademicYear> getCurrentAcademicYearFineDetails(Long var1) throws Exception;

    public ArrayList<SixFieldReports> getInstitutionLedgerAccountDetails(Long var1, Long var2) throws Exception;

    public ArrayList<NineFieldReports> getInstitutionLedgerAccountDetailsWithoutTAX(Long var1, Long var2) throws Exception;

    public ArrayList<SixFieldReports> getInstitutionLedgerAccountDetailsByAcademicYear(Long var1, Long var2) throws Exception;

    public ArrayList<NineFieldReports> getInstitutionLedgerAccountDetailsByAcademicYearWithoutTAX(Long var1, Long var2) throws Exception;

    public ArrayList<SixFieldReports> getInstitutionLedgerAccountListByInvoice(String var1, Long var2, Date var3, Date var4, Long var5);

    public ArrayList<NineFieldReports> getInstitutionLedgerAccountListByInvoiceWithoutTAX(String var1, Long var2, Date var3, Date var4, Long var5);

    public ArrayList<SixFieldReports> getInstitutionLedgerAccountListByReceipt(String var1, Long var2, Date var3, Date var4, Long var5);

    public ArrayList<NineFieldReports> getInstitutionLedgerAccountListByReceiptWithoutTAX(String var1, Long var2, Date var3, Date var4, Long var5);

    public ArrayList<SixFieldReports> getInstitutionLedgerAccountListByNameEager(String var1, Long var2, Long var3);

    public ArrayList<NineFieldReports> getInstitutionLedgerAccountListByNameEagerWithoutTAX(String var1, Long var2, Long var3);

    public ArrayList<SixFieldReports> getCurrentAcademicYearLedgerAccountDetailsByInstitution(Long var1, String var2, Long var3) throws Exception;

    public ArrayList<NineFieldReports> getCurrentAcademicYearLedgerAccountDetailsByInstitutionWithoutTAX(Long var1, String var2, Long var3) throws Exception;

    public void institutionWithAdmin(Institution var1, Staff var2, Set<StaffExperienceDetail> var3, StaffBankDetail var4) throws InstitutionException;
}
