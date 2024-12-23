/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.model.StaffExperienceDetail;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface StaffExperienceDetailService {
    public static final Logger log = LogManager.getLogger((String)StaffExperienceDetailService.class.getName());

    public List<StaffExperienceDetail> staffExperienceDetailList();

    public StaffExperienceDetail staffExperienceDetailById(Long var1);

    public void deleteStaffExperienceDetail(Long var1);
}
