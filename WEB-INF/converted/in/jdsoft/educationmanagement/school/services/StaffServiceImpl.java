/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.Hibernate
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.DocumentDAO;
import in.jdsoft.educationmanagement.school.dao.InstitutionDAO;
import in.jdsoft.educationmanagement.school.dao.StaffAttendanceDAO;
import in.jdsoft.educationmanagement.school.dao.StaffBankDetailDAO;
import in.jdsoft.educationmanagement.school.dao.StaffDAO;
import in.jdsoft.educationmanagement.school.dao.StaffDesignationDAO;
import in.jdsoft.educationmanagement.school.dao.StaffExperienceDetailDAO;
import in.jdsoft.educationmanagement.school.dao.StaffLeaveRequisitionDAO;
import in.jdsoft.educationmanagement.school.dao.StudentDAO;
import in.jdsoft.educationmanagement.school.dao.UserDAO;
import in.jdsoft.educationmanagement.school.exceptions.StaffException;
import in.jdsoft.educationmanagement.school.model.ClassSection;
import in.jdsoft.educationmanagement.school.model.ClassSectionModuleStaff;
import in.jdsoft.educationmanagement.school.model.Document;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.Staff;
import in.jdsoft.educationmanagement.school.model.StaffAttendance;
import in.jdsoft.educationmanagement.school.model.StaffAttendancePunch;
import in.jdsoft.educationmanagement.school.model.StaffBankDetail;
import in.jdsoft.educationmanagement.school.model.StaffDesignation;
import in.jdsoft.educationmanagement.school.model.StaffExperienceDetail;
import in.jdsoft.educationmanagement.school.model.StaffLeaveRequisition;
import in.jdsoft.educationmanagement.school.model.StaffMovementRequisition;
import in.jdsoft.educationmanagement.school.model.TimeTableGeneratorHours;
import in.jdsoft.educationmanagement.school.model.User;
import in.jdsoft.educationmanagement.school.services.StaffService;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="staffService")
public class StaffServiceImpl
implements StaffService {
    @Autowired
    private StaffDAO staffDAO;
    @Autowired
    private InstitutionDAO institutionDAO;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private StaffBankDetailDAO staffBankDetailDAO;
    @Autowired
    private StaffExperienceDetailDAO staffExperienceDetailDAO;
    @Autowired
    private StaffDesignationDAO staffDesignationDAO;
    @Autowired
    StudentDAO studentDAO;
    @Autowired
    StaffAttendanceDAO staffAttendanceDAO;
    @Autowired
    StaffLeaveRequisitionDAO staffLeaveRequisitionDAO;
    @Autowired
    private DocumentDAO documentDAO;

    @Override
    public Long createStaff(Staff staff, Set<StaffExperienceDetail> staffExperiences, StaffBankDetail staffBankDetail) {
        try {
            User persisteduser = this.userDAO.save(staff.getUser());
            staff.setUser(persisteduser);
            Staff persistedstaff = this.staffDAO.save(staff);
            Long staffId = persistedstaff.getStaffId();
            staffBankDetail.setStaff(persistedstaff);
            this.staffBankDetailDAO.save(staffBankDetail);
            for (StaffExperienceDetail staffExperienceDetail : staffExperiences) {
                staffExperienceDetail.setStaff(persistedstaff);
                this.staffExperienceDetailDAO.persist(staffExperienceDetail);
            }
            log.info((Object)("Staff is created with the id=" + staffId));
            return staffId;
        }
        catch (Exception e) {
            log.error((Object)"Exception in Creating Staff", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteStaff(Long staffId) {
        try {
            Staff staff = this.staffDAO.getStaffById(staffId);
            if (staff != null) {
                this.staffDAO.delete(staff);
                log.info((Object)("Staff with id=" + staffId + " has been deleted successfully"));
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in deleting Staff", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Staff> staffList() {
        try {
            List<Staff> staffList = this.staffDAO.getList();
            Integer staffListSize = staffList.size();
            if (staffListSize > 0) {
                log.info((Object)(staffListSize + "staff records where reterived"));
            } else {
                log.info((Object)"No staff(s) available");
            }
            return staffList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving staff list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Staff> staffList(Long institutionId) throws StaffException {
        try {
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            if (institution != null) {
                List<Staff> staffs = this.staffDAO.getStaffsByInstitution(institution);
                Integer staffRecordSize = staffs.size();
                if (staffRecordSize > 0) {
                    log.info((Object)(staffRecordSize + " staff records of institution " + institution.getInstitutionAliasName() + " where reterived"));
                } else {
                    log.info((Object)("No staff Records found for institution " + institution.getInstitutionAliasName()));
                }
                return staffs;
            }
            throw new NullPointerException("Invalid Institution Id");
        }
        catch (Exception e) {
            if (e.getClass().equals(NullPointerException.class)) {
                log.error((Object)"NullPointerException", e.getCause());
                throw new StaffException(new Message("nullpointer", e.getMessage()));
            }
            log.error((Object)"Exception in reteriving staffs of Institution", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Staff> staffListEager(Long institutionId) throws StaffException {
        try {
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            if (institution != null) {
                List<Staff> staffs = this.staffDAO.getStaffsByInstitution(institution);
                Integer staffRecordSize = staffs.size();
                if (staffRecordSize > 0) {
                    for (Staff staff : staffs) {
                        Hibernate.initialize((Object)staff.getBloodGroup());
                        Hibernate.initialize((Object)staff.getStaffType());
                        Hibernate.initialize((Object)staff.getStaffDesignation());
                        Hibernate.initialize((Object)staff.getApprover());
                        Hibernate.initialize((Object)staff.getUser());
                        Hibernate.initialize(staff.getUser().getUserRoles());
                        Hibernate.initialize((Object)staff.getInstitution());
                        Hibernate.initialize((Object)staff.getCategory());
                        Hibernate.initialize((Object)staff.getStaffBankDetail());
                        Hibernate.initialize(staff.getStaffExperienceDetails());
                        Hibernate.initialize(staff.getStaffClassSectionModules());
                    }
                    log.info((Object)(staffRecordSize + " staff records of institution " + institution.getInstitutionAliasName() + " with childs  where reterived"));
                } else {
                    log.info((Object)("No staff Records found for institution " + institution.getInstitutionAliasName()));
                }
                return staffs;
            }
            throw new NullPointerException("Invalid Institution Id");
        }
        catch (Exception e) {
            if (e.getClass().equals(NullPointerException.class)) {
                log.error((Object)"NullPointerException", e.getCause());
                throw new StaffException(new Message("nullpointer", e.getMessage()));
            }
            log.error((Object)"Exception in reteriving staffs with childs of Institution", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Staff staffById(Long staffId) {
        try {
            Staff staff = this.staffDAO.getStaffById(staffId);
            if (staff != null) {
                log.info((Object)("staff with id=" + staffId + " has been reterived"));
                return staff;
            }
            log.info((Object)("No staff with  id=" + staffId + " is available"));
            return staff;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving staff by id=" + staffId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateStaff(Staff staff, Set<StaffExperienceDetail> staffExperiences, StaffBankDetail staffBankDetail) {
        try {
            Set<StaffExperienceDetail> staffExperienceDetails = staff.getStaffExperienceDetails();
            for (StaffExperienceDetail staffExperienceDetail : staffExperienceDetails) {
                this.staffExperienceDetailDAO.delete(staffExperienceDetail);
            }
            for (StaffExperienceDetail staffExperienceDetailObj : staffExperiences) {
                this.staffExperienceDetailDAO.save(staffExperienceDetailObj);
            }
            this.staffBankDetailDAO.saveOrUpdate(staffBankDetail);
            staff.setStaffExperienceDetails(null);
            staff.setStaffBankDetail(null);
            this.staffDAO.saveOrUpdate(staff);
            Long staffId = staff.getStaffId();
            if (staffId != null) {
                log.info((Object)("staff with id=" + staffId + " has been updated"));
            } else {
                log.info((Object)"New staff has been added, because no staff found for update");
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in updating staff", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Staff staffByEmailEager(String staffEmail) {
        try {
            Staff staff = this.staffDAO.getStaffByStaffEmail(staffEmail);
            if (staff != null) {
                Hibernate.initialize((Object)staff.getBloodGroup());
                Hibernate.initialize((Object)staff.getStaffType());
                Hibernate.initialize((Object)staff.getStaffDesignation());
                Hibernate.initialize((Object)staff.getApprover());
                Hibernate.initialize((Object)staff.getUser());
                Hibernate.initialize(staff.getUser().getUserRoles());
                Hibernate.initialize((Object)staff.getInstitution());
                Hibernate.initialize((Object)staff.getCategory());
                Hibernate.initialize((Object)staff.getStaffBankDetail());
                Hibernate.initialize(staff.getStaffExperienceDetails());
                Hibernate.initialize(staff.getStaffClassSectionModules());
                Hibernate.initialize(staff.getClassSections());
                for (ClassSection classSection : staff.getClassSections()) {
                    Hibernate.initialize((Object)classSection.getClassSection());
                    Hibernate.initialize((Object)classSection.getSectionClass());
                }
                Set<ClassSectionModuleStaff> classSectionModuleStaffs = staff.getStaffClassSectionModules();
                for (ClassSectionModuleStaff csm : classSectionModuleStaffs) {
                    Hibernate.initialize((Object)csm.getClassSectionModule().getClassSection());
                    Hibernate.initialize((Object)csm.getClassSectionModule().getModule());
                    Hibernate.initialize(csm.getClassSectionModule().getModule().getTimeTableGeneratorHours());
                    for (TimeTableGeneratorHours timeTableGeneratorHours : csm.getClassSectionModule().getModule().getTimeTableGeneratorHours()) {
                        Hibernate.initialize((Object)timeTableGeneratorHours.getTimeTableGeneratorDays());
                        Hibernate.initialize((Object)timeTableGeneratorHours.getTimeTableGeneratorDays().getTimeTableGenerator());
                    }
                }
                log.info((Object)("staff with email id=" + staffEmail + " has been reterived"));
                return staff;
            }
            log.info((Object)("No staff with email id=" + staffEmail + " is available"));
            return staff;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving staff by email id=" + staffEmail), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Staff staffByIdEager(Long staffId) {
        try {
            Staff staff = this.staffDAO.getStaffById(staffId);
            if (staff != null) {
                Hibernate.initialize((Object)staff.getBloodGroup());
                Hibernate.initialize((Object)staff.getStaffType());
                Hibernate.initialize((Object)staff.getStaffDesignation());
                Hibernate.initialize((Object)staff.getApprover());
                Hibernate.initialize((Object)staff.getUser());
                Hibernate.initialize(staff.getUser().getUserRoles());
                Hibernate.initialize((Object)staff.getInstitution());
                Hibernate.initialize((Object)staff.getCategory());
                Hibernate.initialize((Object)staff.getStaffBankDetail());
                Hibernate.initialize(staff.getStaffExperienceDetails());
                for (StaffExperienceDetail staffExperienceDetail : staff.getStaffExperienceDetails()) {
                    Hibernate.initialize((Object)staffExperienceDetail);
                }
                Hibernate.initialize(staff.getStaffClassSectionModules());
                Set<ClassSectionModuleStaff> classSectionModuleStaffs = staff.getStaffClassSectionModules();
                for (ClassSectionModuleStaff csm : classSectionModuleStaffs) {
                    Hibernate.initialize((Object)csm.getClassSectionModule().getModule());
                }
                for (Document document : staff.getDocuments()) {
                    Hibernate.initialize((Object)document.getDocumentType());
                }
                log.info((Object)("staff with id=" + staffId + " has been reterived"));
                return staff;
            }
            log.info((Object)("No staff with  id=" + staffId + " is available"));
            return staff;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving staff by id=" + staffId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Staff> staffByStaffDesignationEager(Long staffDesignationId) throws StaffException {
        try {
            StaffDesignation staffDesignation = this.staffDesignationDAO.getStaffDesignationById(staffDesignationId);
            if (staffDesignation != null) {
                List<Staff> staffs = this.staffDAO.getStaffsByStaffDesignation(staffDesignation);
                Integer staffRecordSize = staffs.size();
                if (staffRecordSize > 0) {
                    for (Staff staff : staffs) {
                        Hibernate.initialize((Object)staff.getBloodGroup());
                        Hibernate.initialize((Object)staff.getStaffType());
                        Hibernate.initialize((Object)staff.getStaffDesignation());
                        Hibernate.initialize((Object)staff.getApprover());
                        Hibernate.initialize((Object)staff.getUser());
                        Hibernate.initialize(staff.getUser().getUserRoles());
                        Hibernate.initialize((Object)staff.getInstitution());
                        Hibernate.initialize((Object)staff.getCategory());
                        Hibernate.initialize((Object)staff.getStaffBankDetail());
                        Hibernate.initialize(staff.getStaffExperienceDetails());
                        Hibernate.initialize(staff.getStaffClassSectionModules());
                        Set<ClassSectionModuleStaff> classSectionModuleStaffs = staff.getStaffClassSectionModules();
                        for (ClassSectionModuleStaff csm : classSectionModuleStaffs) {
                            Hibernate.initialize((Object)csm.getClassSectionModule().getModule());
                        }
                    }
                    log.info((Object)(staffRecordSize + " staff records of StaffDesignation " + staffDesignation.getStaffDesignationName() + " with childs  where reterived"));
                } else {
                    log.info((Object)("No staff Records found for StaffDesignation " + staffDesignation.getStaffDesignationName()));
                }
                return staffs;
            }
            throw new NullPointerException("Invalid staffDesignation Id");
        }
        catch (Exception e) {
            if (e.getClass().equals(NullPointerException.class)) {
                log.error((Object)"NullPointerException", e.getCause());
                throw new StaffException(new Message("nullpointer", e.getMessage()));
            }
            log.error((Object)"Exception in reteriving staffs with childs of StaffDesignation", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Staff> staffListEager() {
        try {
            List<Staff> staffList = this.staffDAO.getList();
            Integer staffListSize = staffList.size();
            if (staffListSize > 0) {
                for (Staff staff : staffList) {
                    Hibernate.initialize((Object)staff.getBloodGroup());
                    Hibernate.initialize((Object)staff.getStaffType());
                    Hibernate.initialize((Object)staff.getStaffDesignation());
                    Hibernate.initialize((Object)staff.getApprover());
                    Hibernate.initialize((Object)staff.getUser());
                    Hibernate.initialize(staff.getUser().getUserRoles());
                    Hibernate.initialize((Object)staff.getInstitution());
                    Hibernate.initialize((Object)staff.getCategory());
                    Hibernate.initialize((Object)staff.getStaffBankDetail());
                    Hibernate.initialize(staff.getStaffExperienceDetails());
                    Hibernate.initialize(staff.getStaffClassSectionModules());
                    Set<ClassSectionModuleStaff> classSectionModuleStaffs = staff.getStaffClassSectionModules();
                    for (ClassSectionModuleStaff csm : classSectionModuleStaffs) {
                        Hibernate.initialize((Object)csm.getClassSectionModule().getModule());
                    }
                }
                log.info((Object)(staffListSize + "staff records where reterived"));
            } else {
                log.info((Object)"No staff(s) available");
            }
            return staffList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving staff list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateStaff(Staff staff) {
        try {
            this.staffDAO.saveOrUpdate(staff);
            Long staffId = staff.getStaffId();
            if (staffId != null) {
                log.info((Object)("staff with id=" + staffId + " has been updated"));
            } else {
                log.info((Object)"New staff has been added, because no staff found for update");
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in updating staff", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Set<StaffLeaveRequisition> staffLeaveRequests(String staffEMail) throws StaffException {
        User user = this.userDAO.getUserByEmail(staffEMail);
        Hibernate.initialize(user.getStaff().getStaffLeaveRequisitions());
        Set<StaffLeaveRequisition> staffLeaveRequests = user.getStaff().getStaffLeaveRequisitions();
        Iterator<StaffLeaveRequisition> staffLeaveRequisitions = staffLeaveRequests.iterator();
        while (staffLeaveRequisitions.hasNext()) {
            StaffLeaveRequisition staffLeaveRequisition = staffLeaveRequisitions.next();
            if (staffLeaveRequisition.getApprovalStatus().equals("Pending")) {
                Hibernate.initialize((Object)staffLeaveRequisition.getStaffLeaveType());
                Hibernate.initialize((Object)staffLeaveRequisition.getRequisitionType());
                continue;
            }
            staffLeaveRequisitions.remove();
        }
        return staffLeaveRequests;
    }

    @Override
    public Set<StaffLeaveRequisition> staffLeaveRequestApprovedAndRejectedLists(String staffEMail) throws StaffException {
        User user = this.userDAO.getUserByEmail(staffEMail);
        Hibernate.initialize(user.getStaff().getStaffLeaveRequisitions());
        Set<StaffLeaveRequisition> staffLeaveRequests = user.getStaff().getStaffLeaveRequisitions();
        LinkedHashSet<StaffLeaveRequisition> addstaffLeaveRequests = new LinkedHashSet<StaffLeaveRequisition>();
        for (StaffLeaveRequisition staffLeaveRequisition : staffLeaveRequests) {
            if (!staffLeaveRequisition.getApprovalStatus().equals("Approved") && !staffLeaveRequisition.getApprovalStatus().equals("Rejected")) continue;
            Hibernate.initialize((Object)staffLeaveRequisition.getStaffLeaveType());
            addstaffLeaveRequests.add(staffLeaveRequisition);
            Hibernate.initialize((Object)staffLeaveRequisition.getRequisitionType());
        }
        return addstaffLeaveRequests;
    }

    @Override
    public Set<StaffLeaveRequisition> staffLeaveApprovals(String staffEMail) throws StaffException {
        try {
            User user = this.userDAO.getUserByEmail(staffEMail);
            Hibernate.initialize(user.getStaffLeaveRequistions());
            Set<StaffLeaveRequisition> staffLeaveRequisitions = user.getStaffLeaveRequistions();
            Iterator<StaffLeaveRequisition> approvals = staffLeaveRequisitions.iterator();
            while (approvals.hasNext()) {
                StaffLeaveRequisition staffLeaveRequisition = approvals.next();
                if (staffLeaveRequisition.getApprovalStatus().equals("Pending")) {
                    Hibernate.initialize((Object)staffLeaveRequisition.getStaffLeaveType());
                    Hibernate.initialize((Object)staffLeaveRequisition.getStaff());
                    Hibernate.initialize((Object)staffLeaveRequisition.getRequisitionType());
                    continue;
                }
                approvals.remove();
            }
            return staffLeaveRequisitions;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Staff staffAttendanceByStaffEmailAndAttendanceMonthEager(String staffEMail, Date attendanceMonthDate) throws StaffException {
        try {
            Staff staff = this.staffDAO.getStaffByStaffEmail(staffEMail);
            Hibernate.initialize((Object)staff.getInstitution());
            Hibernate.initialize((Object)staff.getInstitution().getStaffAttendanceConfiguration());
            LinkedHashSet<StaffAttendance> addStaffAttendance = new LinkedHashSet<StaffAttendance>();
            LinkedHashSet<StaffLeaveRequisition> addStaffLeaveRequisition = new LinkedHashSet<StaffLeaveRequisition>();
            List<StaffAttendance> staffAttendances = this.staffAttendanceDAO.getStaffAttendanceByStaffEmailAndAttendanceMonth(staff, attendanceMonthDate);
            for (StaffAttendance staffAttendance : staffAttendances) {
                addStaffAttendance.add(staffAttendance);
            }
            staff.setStaffAttendance(addStaffAttendance);
            List<StaffLeaveRequisition> staffLeaveRequisitions = this.staffLeaveRequisitionDAO.getStaffLeaveRequisitionByStaffEmailAndAttendanceMonth(staff, attendanceMonthDate, "Approved");
            for (StaffLeaveRequisition staffLeaveRequisition : staffLeaveRequisitions) {
                addStaffLeaveRequisition.add(staffLeaveRequisition);
                Hibernate.initialize((Object)staffLeaveRequisition.getStaffLeaveType());
            }
            staff.setStaffLeaveRequisitions(addStaffLeaveRequisition);
            return staff;
        }
        catch (Exception e) {
            if (e.getClass().equals(NullPointerException.class)) {
                log.error((Object)"NullPointerException", e.getCause());
                throw new StaffException(new Message("nullpointer", e.getMessage()));
            }
            log.error((Object)("Exception in reteriving AtaffAttendance given EmailId=" + staffEMail + ",AttendanceMonth=" + attendanceMonthDate), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Staff staffByStaffCodeAndDate(String staffCode, Date date) {
        Staff staff = this.staffDAO.getStaffByStaffCode(staffCode);
        Hibernate.initialize(staff.getStaffAttendance());
        LinkedHashSet<StaffAttendancePunch> addStaffAttendancePunch = new LinkedHashSet<StaffAttendancePunch>();
        LinkedHashSet<StaffAttendance> addStaffAttendance = new LinkedHashSet<StaffAttendance>();
        for (StaffAttendance staffAttendance : this.staffAttendanceDAO.getStaffAttendance(date)) {
            Hibernate.initialize((Object)staffAttendance.getStaff());
            if (!staffAttendance.getStaff().getStaffCode().equals(staff.getStaffCode())) continue;
            addStaffAttendance.add(staffAttendance);
            Hibernate.initialize(staffAttendance.getStaffAttendancePunches());
            for (StaffAttendancePunch staffAttendancePunch : staffAttendance.getStaffAttendancePunches()) {
                Hibernate.initialize((Object)staffAttendancePunch);
                addStaffAttendancePunch.add(staffAttendancePunch);
            }
            staffAttendance.setStaffAttendancePunches(addStaffAttendancePunch);
        }
        staff.setStaffAttendance(addStaffAttendance);
        return staff;
    }

    @Override
    public Set<StaffMovementRequisition> staffMovementRequests(String staffEMail) throws StaffException {
        User user = this.userDAO.getUserByEmail(staffEMail);
        Hibernate.initialize(user.getStaff().getStaffMovementRequisitions());
        Set<StaffMovementRequisition> staffMovementRequests = user.getStaff().getStaffMovementRequisitions();
        Iterator<StaffMovementRequisition> staffMovementRequisitions = staffMovementRequests.iterator();
        while (staffMovementRequisitions.hasNext()) {
            StaffMovementRequisition staffMovementRequisition = staffMovementRequisitions.next();
            if (staffMovementRequisition.getApprovalStatus().equals("Pending")) {
                Hibernate.initialize((Object)staffMovementRequisition.getRequisitionType());
                continue;
            }
            staffMovementRequisitions.remove();
        }
        return staffMovementRequests;
    }

    @Override
    public Set<StaffMovementRequisition> staffMovementRequestApprovedAndRejectedLists(String staffEMail) throws StaffException {
        User user = this.userDAO.getUserByEmail(staffEMail);
        Hibernate.initialize(user.getStaff().getStaffMovementRequisitions());
        Set<StaffMovementRequisition> staffMovementRequests = user.getStaff().getStaffMovementRequisitions();
        LinkedHashSet<StaffMovementRequisition> addstaffMovementRequests = new LinkedHashSet<StaffMovementRequisition>();
        for (StaffMovementRequisition staffMovementRequisition : staffMovementRequests) {
            if (!staffMovementRequisition.getApprovalStatus().equals("Approved") && !staffMovementRequisition.getApprovalStatus().equals("Rejected")) continue;
            addstaffMovementRequests.add(staffMovementRequisition);
            Hibernate.initialize((Object)staffMovementRequisition.getRequisitionType());
        }
        return addstaffMovementRequests;
    }

    @Override
    public Staff staffByStaffCode(String staffCode) throws StaffException {
        try {
            Staff staff = this.staffDAO.getStaffByStaffCode(staffCode);
            if (staff != null) {
                Hibernate.initialize((Object)staff.getBloodGroup());
                Hibernate.initialize((Object)staff.getStaffType());
                Hibernate.initialize((Object)staff.getStaffDesignation());
                Hibernate.initialize((Object)staff.getApprover());
                Hibernate.initialize((Object)staff.getUser());
                Hibernate.initialize(staff.getUser().getUserRoles());
                Hibernate.initialize((Object)staff.getInstitution());
                Hibernate.initialize((Object)staff.getCategory());
                Hibernate.initialize((Object)staff.getStaffBankDetail());
                Hibernate.initialize(staff.getStaffExperienceDetails());
                Hibernate.initialize(staff.getStaffClassSectionModules());
                Set<ClassSectionModuleStaff> classSectionModuleStaffs = staff.getStaffClassSectionModules();
                for (ClassSectionModuleStaff csm : classSectionModuleStaffs) {
                    Hibernate.initialize((Object)csm.getClassSectionModule().getClassSection());
                    Hibernate.initialize((Object)csm.getClassSectionModule().getModule());
                    Hibernate.initialize(csm.getClassSectionModule().getModule().getTimeTableGeneratorHours());
                    for (TimeTableGeneratorHours timeTableGeneratorHours : csm.getClassSectionModule().getModule().getTimeTableGeneratorHours()) {
                        Hibernate.initialize((Object)timeTableGeneratorHours.getTimeTableGeneratorDays());
                        Hibernate.initialize((Object)timeTableGeneratorHours.getTimeTableGeneratorDays().getTimeTableGenerator());
                    }
                }
                log.info((Object)("staff with staffcode=" + staffCode + " has been reterived"));
                return staff;
            }
            log.info((Object)("No staff with staffcode=" + staffCode + " is available"));
            return staff;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving staff by staffcode=" + staffCode), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Long createStaffAndDocuments(Staff staff, Set<StaffExperienceDetail> staffExperiences, StaffBankDetail staffBankDetail, Set<Document> documents) throws Exception {
        try {
            User persisteduser = this.userDAO.save(staff.getUser());
            staff.setUser(persisteduser);
            Staff persistedstaff = this.staffDAO.save(staff);
            Long staffId = persistedstaff.getStaffId();
            staffBankDetail.setStaff(persistedstaff);
            this.staffBankDetailDAO.save(staffBankDetail);
            for (StaffExperienceDetail staffExperienceDetail : staffExperiences) {
                staffExperienceDetail.setStaff(persistedstaff);
                this.staffExperienceDetailDAO.persist(staffExperienceDetail);
            }
            for (Document document : documents) {
                if (this.documentDAO.getDocumentByDocumentTypeAndStaff(document.getDocumentType(), staff) == null) {
                    document.setStaff(staff);
                    this.documentDAO.save(document);
                    continue;
                }
                throw new StaffException(new Message("failure", "Cannot Upload Duplicate Document Type"));
            }
            log.info((Object)("Staff is created with the id=" + staffId));
            return staffId;
        }
        catch (Exception e) {
            log.error((Object)"Exception in Creating Staff", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateStaffAndDocuments(Staff staff, Set<StaffExperienceDetail> staffExperiences, StaffBankDetail staffBankDetail, Set<Document> documents) throws Exception {
        try {
            Set<StaffExperienceDetail> staffExperienceDetails = staff.getStaffExperienceDetails();
            for (StaffExperienceDetail staffExperienceDetail : staffExperienceDetails) {
                this.staffExperienceDetailDAO.delete(staffExperienceDetail);
            }
            for (StaffExperienceDetail staffExperienceDetailObj : staffExperiences) {
                this.staffExperienceDetailDAO.save(staffExperienceDetailObj);
            }
            this.staffBankDetailDAO.saveOrUpdate(staffBankDetail);
            staff.setStaffExperienceDetails(null);
            staff.setStaffBankDetail(null);
            this.staffDAO.saveOrUpdate(staff);
            for (Document document : staff.getDocuments()) {
                this.documentDAO.delete(document);
            }
            staff.setDocuments(null);
            this.staffDAO.saveOrUpdate(staff);
            for (Document document : documents) {
                if (this.documentDAO.getDocumentByDocumentTypeAndStaff(document.getDocumentType(), staff) == null) {
                    document.setStaff(staff);
                    this.documentDAO.save(document);
                    continue;
                }
                throw new StaffException(new Message("failure", "Cannot Upload Duplicate Document Type"));
            }
            Long staffId = staff.getStaffId();
            if (staffId != null) {
                log.info((Object)("staff with id=" + staffId + " has been updated"));
            } else {
                log.info((Object)"New staff has been added, because no staff found for update");
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in updating staff", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Staff staffByEmail(String staffEmail) {
        try {
            Staff staff = this.staffDAO.getStaffByStaffEmail(staffEmail);
            if (staff != null) {
                Hibernate.initialize((Object)staff.getBloodGroup());
                Hibernate.initialize((Object)staff.getStaffType());
                Hibernate.initialize((Object)staff.getStaffDesignation());
                Hibernate.initialize((Object)staff.getApprover());
                Hibernate.initialize((Object)staff.getUser());
                Hibernate.initialize(staff.getUser().getUserRoles());
                Hibernate.initialize((Object)staff.getInstitution());
                Hibernate.initialize((Object)staff.getCategory());
                Hibernate.initialize((Object)staff.getStaffBankDetail());
                Hibernate.initialize(staff.getStaffExperienceDetails());
                log.info((Object)("staff with email id=" + staffEmail + " has been reterived"));
                return staff;
            }
            log.info((Object)("No staff with email id=" + staffEmail + " is available"));
            return staff;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving staff by email id=" + staffEmail), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateStaff(Staff staff, Set<StaffExperienceDetail> staffExperiences, StaffBankDetail staffBankDetail, Set<Document> documents) throws Exception {
        try {
            Set<StaffExperienceDetail> staffExperienceDetails = staff.getStaffExperienceDetails();
            for (StaffExperienceDetail staffExperienceDetail : staffExperienceDetails) {
                this.staffExperienceDetailDAO.delete(staffExperienceDetail);
            }
            for (StaffExperienceDetail staffExperienceDetailObj : staffExperiences) {
                this.staffExperienceDetailDAO.save(staffExperienceDetailObj);
            }
            this.staffBankDetailDAO.saveOrUpdate(staffBankDetail);
            staff.setStaffExperienceDetails(null);
            staff.setStaffBankDetail(null);
            for (Document document : staff.getDocuments()) {
                this.documentDAO.delete(document);
            }
            staff.setDocuments(null);
            this.staffDAO.saveOrUpdate(staff);
            for (Document document : documents) {
                if (this.documentDAO.getDocumentByDocumentTypeAndStaff(document.getDocumentType(), staff) == null) {
                    document.setStaff(staff);
                    this.documentDAO.save(document);
                    continue;
                }
                throw new StaffException(new Message("failure", "Cannot Upload Duplicate Document Type"));
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in updating staff", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }
}
