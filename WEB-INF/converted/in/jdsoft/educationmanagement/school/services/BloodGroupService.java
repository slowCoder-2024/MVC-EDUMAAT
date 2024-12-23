/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.model.BloodGroup;
import in.jdsoft.educationmanagement.school.reports.model.TwoFieldReport;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface BloodGroupService {
    public static final Logger log = LogManager.getLogger((String)BloodGroupService.class.getName());

    public List<BloodGroup> bloodGroupList();

    public BloodGroup bloodGroupById(Long var1);

    public ArrayList<TwoFieldReport> getBloodGroupWiseStudentCount();

    public ArrayList<TwoFieldReport> getBloodGroupWiseStudentCountByInstitution(Long var1);
}
