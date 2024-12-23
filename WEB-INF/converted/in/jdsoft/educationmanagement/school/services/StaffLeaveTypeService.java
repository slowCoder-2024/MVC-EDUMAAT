/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.model.StaffLeaveType;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface StaffLeaveTypeService {
    public static final Logger log = LogManager.getLogger((String)StaffLeaveTypeService.class.getName());

    public Long createStaffLeaveType(StaffLeaveType var1);

    public void deleteStaffLeaveType(Long var1);

    public List<StaffLeaveType> staffLeaveTypeList();

    public StaffLeaveType staffLeaveTypeById(Long var1);

    public StaffLeaveType staffLeaveTypeByIdEager(Long var1);

    public void updateStaffLeaveType(StaffLeaveType var1);
}
