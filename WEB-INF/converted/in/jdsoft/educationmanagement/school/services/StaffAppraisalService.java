/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.model.StaffAppraisal;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface StaffAppraisalService {
    public static final Logger log = LogManager.getLogger((String)StaffAppraisalService.class.getName());

    public List<StaffAppraisal> staffAppraisalList();

    public StaffAppraisal staffAppraisalById(Long var1);

    public void createStaffAppraisal(StaffAppraisal var1) throws Exception;

    public void updateStaffAppraisal(StaffAppraisal var1);

    public void deleteStaffAppraisal(Long var1);

    public List<StaffAppraisal> staffAppraisalListByStaffCode(String var1);

    public List<StaffAppraisal> staffAppraisalListByAcademicYear(Long var1);

    public List<StaffAppraisal> staffAppraisalListByAcademicYearAndEmail(Long var1, String var2);
}
