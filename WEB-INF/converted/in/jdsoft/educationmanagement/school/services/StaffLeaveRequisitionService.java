/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.model.StaffLeaveRequisition;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface StaffLeaveRequisitionService {
    public static final Logger log = LogManager.getLogger((String)StaffLeaveRequisitionService.class.getName());

    public Long createStaffLeaveRequisition(StaffLeaveRequisition var1);

    public void deleteStaffLeaveRequisition(Long var1);

    public List<StaffLeaveRequisition> staffLeaveRequisitionList();

    public List<StaffLeaveRequisition> staffLeaveRequisitionListByStaffEmail(String var1);

    public StaffLeaveRequisition staffLeaveRequisitionById(Long var1);

    public StaffLeaveRequisition staffLeaveRequisitionByIdEager(Long var1);

    public void updateStaffLeaveRequisition(StaffLeaveRequisition var1);

    public void cancelStaffLeaveRequisition(StaffLeaveRequisition var1);
}
