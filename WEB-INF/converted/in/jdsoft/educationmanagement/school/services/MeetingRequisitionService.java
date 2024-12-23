/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.exceptions.MeetingRequisitionException;
import in.jdsoft.educationmanagement.school.model.MeetingRequisition;
import in.jdsoft.educationmanagement.school.model.PortalTask;
import java.util.List;
import java.util.Set;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface MeetingRequisitionService {
    public static final Logger log = LogManager.getLogger((String)MeetingRequisitionService.class.getName());

    public Long createMeetingRequisition(MeetingRequisition var1, PortalTask var2) throws MeetingRequisitionException;

    public void deleteMeetingRequisition(Long var1) throws MeetingRequisitionException;

    public List<MeetingRequisition> meetingRequisitionList() throws MeetingRequisitionException;

    public Set<MeetingRequisition> meetingRequisitionListByRequesterEmail(String var1) throws MeetingRequisitionException;

    public MeetingRequisition meetingRequisitionById(Long var1) throws MeetingRequisitionException;

    public MeetingRequisition meetingRequisitionByIdEager(Long var1) throws MeetingRequisitionException;

    public void updateMeetingRequisition(MeetingRequisition var1, PortalTask var2) throws MeetingRequisitionException;

    public void cancelMeetingRequisition(MeetingRequisition var1) throws MeetingRequisitionException;

    public Set<MeetingRequisition> meetingRequisitionListByApprover(String var1) throws MeetingRequisitionException;

    public Set<MeetingRequisition> meetingRequestApprovedAndRejectedLists(String var1) throws MeetingRequisitionException;

    public Set<MeetingRequisition> meetingRequisitionListByAcademicYearAndAllClass(Long var1) throws MeetingRequisitionException;

    public Set<MeetingRequisition> meetingRequisitionListByAcademicYearAndClassAndSection(Long var1, Long var2, Long var3) throws MeetingRequisitionException;
}
