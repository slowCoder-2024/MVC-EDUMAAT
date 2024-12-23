/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.exceptions.StaffException;
import in.jdsoft.educationmanagement.school.model.Document;
import in.jdsoft.educationmanagement.school.model.Staff;
import in.jdsoft.educationmanagement.school.model.StaffBankDetail;
import in.jdsoft.educationmanagement.school.model.StaffExperienceDetail;
import in.jdsoft.educationmanagement.school.model.StaffLeaveRequisition;
import in.jdsoft.educationmanagement.school.model.StaffMovementRequisition;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface StaffService {
    public static final Logger log = LogManager.getLogger((String)StaffService.class.getName());

    public Long createStaff(Staff var1, Set<StaffExperienceDetail> var2, StaffBankDetail var3);

    public void deleteStaff(Long var1);

    public List<Staff> staffList();

    public List<Staff> staffListEager();

    public List<Staff> staffList(Long var1) throws StaffException;

    public List<Staff> staffListEager(Long var1) throws StaffException;

    public Staff staffById(Long var1);

    public Staff staffByStaffCodeAndDate(String var1, Date var2);

    public Staff staffByIdEager(Long var1);

    public void updateStaff(Staff var1, Set<StaffExperienceDetail> var2, StaffBankDetail var3);

    public void updateStaff(Staff var1);

    public Staff staffByEmailEager(String var1);

    public Staff staffByEmail(String var1);

    public List<Staff> staffByStaffDesignationEager(Long var1) throws StaffException;

    public Set<StaffLeaveRequisition> staffLeaveRequests(String var1) throws StaffException;

    public Set<StaffLeaveRequisition> staffLeaveRequestApprovedAndRejectedLists(String var1) throws StaffException;

    public Set<StaffLeaveRequisition> staffLeaveApprovals(String var1) throws StaffException;

    public Staff staffAttendanceByStaffEmailAndAttendanceMonthEager(String var1, Date var2) throws StaffException;

    public Set<StaffMovementRequisition> staffMovementRequests(String var1) throws StaffException;

    public Set<StaffMovementRequisition> staffMovementRequestApprovedAndRejectedLists(String var1) throws StaffException;

    public Staff staffByStaffCode(String var1) throws StaffException;

    public Long createStaffAndDocuments(Staff var1, Set<StaffExperienceDetail> var2, StaffBankDetail var3, Set<Document> var4) throws Exception;

    public void updateStaff(Staff var1, Set<StaffExperienceDetail> var2, StaffBankDetail var3, Set<Document> var4) throws Exception;

    public void updateStaffAndDocuments(Staff var1, Set<StaffExperienceDetail> var2, StaffBankDetail var3, Set<Document> var4) throws Exception;
}
