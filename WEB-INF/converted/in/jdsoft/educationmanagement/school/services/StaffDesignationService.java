/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.exceptions.StaffDesignationException;
import in.jdsoft.educationmanagement.school.model.StaffDesignation;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface StaffDesignationService {
    public static final Logger log = LogManager.getLogger((String)StaffDesignationService.class.getName());

    public Long createStaffDesignation(StaffDesignation var1);

    public void deleteStaffDesignation(Long var1);

    public List<StaffDesignation> staffDesignationList();

    public List<StaffDesignation> staffDesignationListEager(Long var1) throws StaffDesignationException;

    public List<StaffDesignation> staffDesignationList(Long var1) throws StaffDesignationException;

    public List<StaffDesignation> staffDesignationList(Long var1, Long var2) throws StaffDesignationException;

    public StaffDesignation staffDesignationById(Long var1);

    public StaffDesignation staffDesignationByIdEager(Long var1);

    public void updateStaffDesignation(StaffDesignation var1);
}
