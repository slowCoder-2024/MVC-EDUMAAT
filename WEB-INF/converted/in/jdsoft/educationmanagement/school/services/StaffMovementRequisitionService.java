/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.exceptions.StaffMovementRequisitionException;
import in.jdsoft.educationmanagement.school.model.StaffMovementRequisition;
import java.util.List;
import java.util.Set;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface StaffMovementRequisitionService {
    public static final Logger log = LogManager.getLogger((String)StaffMovementRequisitionService.class.getName());

    public Long createStaffMovementRequisition(StaffMovementRequisition var1) throws StaffMovementRequisitionException;

    public void deleteStaffMovementRequisition(Long var1) throws StaffMovementRequisitionException;

    public List<StaffMovementRequisition> staffMovementRequisitionList() throws StaffMovementRequisitionException;

    public Set<StaffMovementRequisition> staffMovementRequisitionListByStudentEmail(String var1) throws StaffMovementRequisitionException;

    public StaffMovementRequisition staffMovementRequisitionById(Long var1) throws StaffMovementRequisitionException;

    public StaffMovementRequisition staffMovementRequisitionByIdEager(Long var1) throws StaffMovementRequisitionException;

    public void updateStaffMovementRequisition(StaffMovementRequisition var1) throws StaffMovementRequisitionException;

    public void cancelStaffMovementRequisition(StaffMovementRequisition var1) throws StaffMovementRequisitionException;

    public Set<StaffMovementRequisition> staffMovementRequisitionListByMovementApprover(String var1) throws StaffMovementRequisitionException;

    public Set<StaffMovementRequisition> staffMovementRequestApprovedAndRejectedLists(String var1) throws StaffMovementRequisitionException;
}
