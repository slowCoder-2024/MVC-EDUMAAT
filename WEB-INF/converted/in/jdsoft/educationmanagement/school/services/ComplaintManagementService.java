/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.exceptions.ComplaintManagementException;
import in.jdsoft.educationmanagement.school.model.ComplaintManagement;
import in.jdsoft.educationmanagement.school.model.PortalTask;
import java.util.List;
import java.util.Set;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ComplaintManagementService {
    public static final Logger log = LogManager.getLogger((String)ComplaintManagementService.class.getName());

    public Long createComplaintManagement(ComplaintManagement var1, PortalTask var2) throws ComplaintManagementException;

    public void deleteComplaintManagement(Long var1) throws ComplaintManagementException;

    public List<ComplaintManagement> complaintManagementList() throws ComplaintManagementException;

    public Set<ComplaintManagement> complaintManagementListByRequesterEmail(String var1) throws ComplaintManagementException;

    public ComplaintManagement complaintManagementById(Long var1) throws ComplaintManagementException;

    public ComplaintManagement complaintManagementByIdEager(Long var1) throws ComplaintManagementException;

    public void updateComplaintManagement(ComplaintManagement var1, PortalTask var2) throws ComplaintManagementException;

    public void cancelComplaintManagement(ComplaintManagement var1) throws ComplaintManagementException;

    public Set<ComplaintManagement> complaintManagementListByApprover(String var1) throws ComplaintManagementException;

    public Set<ComplaintManagement> complaintManagementApprovedAndRejectedLists(String var1) throws ComplaintManagementException;
}
