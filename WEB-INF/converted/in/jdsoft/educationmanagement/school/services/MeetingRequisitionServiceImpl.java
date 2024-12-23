/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.Hibernate
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.AcademicYearDAO;
import in.jdsoft.educationmanagement.school.dao.ClassDAO;
import in.jdsoft.educationmanagement.school.dao.InstitutionDAO;
import in.jdsoft.educationmanagement.school.dao.MeetingRequisitionDAO;
import in.jdsoft.educationmanagement.school.dao.PortalTaskDAO;
import in.jdsoft.educationmanagement.school.dao.SectionDAO;
import in.jdsoft.educationmanagement.school.dao.StudentDAO;
import in.jdsoft.educationmanagement.school.dao.UserDAO;
import in.jdsoft.educationmanagement.school.exceptions.MeetingRequisitionException;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.Class;
import in.jdsoft.educationmanagement.school.model.MeetingRequisition;
import in.jdsoft.educationmanagement.school.model.PortalTask;
import in.jdsoft.educationmanagement.school.model.Section;
import in.jdsoft.educationmanagement.school.model.User;
import in.jdsoft.educationmanagement.school.services.MeetingRequisitionService;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="meetingRequisitionService")
public class MeetingRequisitionServiceImpl
implements MeetingRequisitionService {
    @Autowired
    MeetingRequisitionDAO MeetingRequisitionDAO;
    @Autowired
    InstitutionDAO institutionDAO;
    @Autowired
    StudentDAO studentDAO;
    @Autowired
    PortalTaskDAO portalTaskDAO;
    @Autowired
    UserDAO userDAO;
    @Autowired
    AcademicYearDAO academicYearDAO;
    @Autowired
    ClassDAO classDAO;
    @Autowired
    SectionDAO sectionDAO;

    @Override
    public Long createMeetingRequisition(MeetingRequisition MeetingRequisition2, PortalTask portalTask) throws MeetingRequisitionException {
        try {
            PortalTask persistedPortalTask = this.portalTaskDAO.save(portalTask);
            MeetingRequisition2.setPortalTask(persistedPortalTask);
            MeetingRequisition persistedMeetingRequisition = this.MeetingRequisitionDAO.save(MeetingRequisition2);
            Long MeetingRequisitionId = persistedMeetingRequisition.getMeetingRequisitionId();
            log.info((Object)("MeetingRequisition created with the id=" + MeetingRequisitionId));
            return MeetingRequisitionId;
        }
        catch (Exception e) {
            log.error((Object)"Exception in Creating MeetingRequisition", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteMeetingRequisition(Long MeetingRequisitionId) throws MeetingRequisitionException {
        try {
            MeetingRequisition MeetingRequisition2 = this.MeetingRequisitionDAO.getMeetingRequisitionById(MeetingRequisitionId);
            if (MeetingRequisition2 != null) {
                this.MeetingRequisitionDAO.delete(MeetingRequisition2);
                log.info((Object)("MeetingRequisition with id=" + MeetingRequisitionId + " has been deleted successfully"));
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in deleting MeetingRequisition", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<MeetingRequisition> meetingRequisitionList() throws MeetingRequisitionException {
        try {
            List<MeetingRequisition> MeetingRequisitionList = this.MeetingRequisitionDAO.getList();
            Integer MeetingRequisitionListSize = MeetingRequisitionList.size();
            if (MeetingRequisitionListSize > 0) {
                log.info((Object)(MeetingRequisitionListSize + " MeetingRequisition records where reterived"));
            } else {
                log.info((Object)"No MeetingRequisition list available");
            }
            return MeetingRequisitionList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving MeetingRequisition list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public MeetingRequisition meetingRequisitionById(Long MeetingRequisitionId) throws MeetingRequisitionException {
        try {
            MeetingRequisition MeetingRequisition2 = this.MeetingRequisitionDAO.getMeetingRequisitionById(MeetingRequisitionId);
            if (MeetingRequisition2 != null) {
                log.info((Object)("MeetingRequisition with id=" + MeetingRequisitionId + " has been reterived"));
                return MeetingRequisition2;
            }
            log.info((Object)("No MeetingRequisition with  id=" + MeetingRequisitionId + " is available"));
            return MeetingRequisition2;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving MeetingRequisition by id=" + MeetingRequisitionId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateMeetingRequisition(MeetingRequisition MeetingRequisition2, PortalTask portalTask) throws MeetingRequisitionException {
        try {
            this.MeetingRequisitionDAO.saveOrUpdate(MeetingRequisition2);
            this.portalTaskDAO.save(portalTask);
            Long MeetingRequisitionId = MeetingRequisition2.getMeetingRequisitionId();
            if (MeetingRequisitionId != null) {
                log.info((Object)("MeetingRequisition with id=" + MeetingRequisitionId + " has been updated"));
            } else {
                log.info((Object)"New MeetingRequisition has been added, because no MeetingRequisition found for update");
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in updating MeetingRequisition", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public MeetingRequisition meetingRequisitionByIdEager(Long MeetingRequisitionId) throws MeetingRequisitionException {
        try {
            MeetingRequisition MeetingRequisition2 = this.MeetingRequisitionDAO.getMeetingRequisitionById(MeetingRequisitionId);
            if (MeetingRequisition2 != null) {
                log.info((Object)("MeetingRequisition with id=" + MeetingRequisitionId + " has been reterived"));
                Hibernate.initialize((Object)MeetingRequisition2.getPortalTask());
                Hibernate.initialize((Object)MeetingRequisition2.getStudentClass());
                Hibernate.initialize((Object)MeetingRequisition2.getSection());
                Hibernate.initialize((Object)MeetingRequisition2.getAcademicYear());
                Hibernate.initialize((Object)MeetingRequisition2.getInstitution());
                Hibernate.initialize((Object)MeetingRequisition2.getMeetingApprover().getStaff());
                Hibernate.initialize((Object)MeetingRequisition2.getMeetingApprover().getStudent());
                Hibernate.initialize((Object)MeetingRequisition2.getMeetingRequester().getStaff());
                Hibernate.initialize((Object)MeetingRequisition2.getMeetingRequester().getStudent());
                return MeetingRequisition2;
            }
            log.info((Object)("No MeetingRequisition with  id=" + MeetingRequisitionId + " is available"));
            return MeetingRequisition2;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving MeetingRequisition by id=" + MeetingRequisitionId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Set<MeetingRequisition> meetingRequisitionListByRequesterEmail(String email) throws MeetingRequisitionException {
        LinkedHashSet<MeetingRequisition> tcRequests = new LinkedHashSet<MeetingRequisition>();
        User user = this.userDAO.getUserByEmail(email);
        tcRequests.addAll(this.MeetingRequisitionDAO.getMeetingRequisitionListAndRequestUserAndStatus(user, "Pending"));
        return tcRequests;
    }

    @Override
    public Set<MeetingRequisition> meetingRequisitionListByApprover(String email) throws MeetingRequisitionException {
        LinkedHashSet<MeetingRequisition> tcRequests = new LinkedHashSet<MeetingRequisition>();
        User user = this.userDAO.getUserByEmail(email);
        tcRequests.addAll(this.MeetingRequisitionDAO.getMeetingRequisitionListAndApproveUserAndStatus(user, "Pending"));
        for (MeetingRequisition MeetingRequisition2 : tcRequests) {
            Hibernate.initialize((Object)MeetingRequisition2.getStudentClass());
            Hibernate.initialize((Object)MeetingRequisition2.getSection());
            Hibernate.initialize((Object)MeetingRequisition2.getInstitution());
            Hibernate.initialize((Object)MeetingRequisition2.getAcademicYear());
            Hibernate.initialize((Object)MeetingRequisition2.getMeetingApprover().getStaff());
            Hibernate.initialize((Object)MeetingRequisition2.getMeetingApprover().getStudent());
            Hibernate.initialize((Object)MeetingRequisition2.getMeetingRequester().getStaff());
            Hibernate.initialize((Object)MeetingRequisition2.getMeetingRequester().getStudent());
        }
        return tcRequests;
    }

    @Override
    public void cancelMeetingRequisition(MeetingRequisition MeetingRequisition2) throws MeetingRequisitionException {
        try {
            log.info((Object)("MeetingRequisition with id=" + MeetingRequisition2.getMeetingRequisitionId() + " has been cancelled"));
            PortalTask portalTask = MeetingRequisition2.getPortalTask();
            LinkedHashSet<User> addUser = new LinkedHashSet<User>();
            portalTask.setTargetUsers(addUser);
            this.portalTaskDAO.update(portalTask);
            this.MeetingRequisitionDAO.update(MeetingRequisition2);
        }
        catch (Exception e) {
            log.error((Object)"Exception in cancel MeetingRequisition", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Set<MeetingRequisition> meetingRequestApprovedAndRejectedLists(String email) throws MeetingRequisitionException {
        LinkedHashSet<MeetingRequisition> tcRequests = new LinkedHashSet<MeetingRequisition>();
        User user = this.userDAO.getUserByEmail(email);
        tcRequests.addAll(this.MeetingRequisitionDAO.getMeetingRequisitionListAndRequestUserAndStatus(user, "Approved"));
        tcRequests.addAll(this.MeetingRequisitionDAO.getMeetingRequisitionListAndRequestUserAndStatus(user, "Rejected"));
        for (MeetingRequisition MeetingRequisition2 : tcRequests) {
            Hibernate.initialize((Object)MeetingRequisition2.getStudentClass());
            Hibernate.initialize((Object)MeetingRequisition2.getSection());
            Hibernate.initialize((Object)MeetingRequisition2.getInstitution());
            Hibernate.initialize((Object)MeetingRequisition2.getAcademicYear());
            Hibernate.initialize((Object)MeetingRequisition2.getMeetingApprover().getStaff());
            Hibernate.initialize((Object)MeetingRequisition2.getMeetingApprover().getStudent());
            Hibernate.initialize((Object)MeetingRequisition2.getMeetingRequester().getStaff());
            Hibernate.initialize((Object)MeetingRequisition2.getMeetingRequester().getStudent());
        }
        return tcRequests;
    }

    @Override
    public Set<MeetingRequisition> meetingRequisitionListByAcademicYearAndAllClass(Long academicYearId) throws MeetingRequisitionException {
        LinkedHashSet<MeetingRequisition> tcRequests = new LinkedHashSet<MeetingRequisition>();
        AcademicYear academicYear = this.academicYearDAO.getAcademicYearById(academicYearId);
        if (this.MeetingRequisitionDAO.getMeetingRequisitionListAndAcademicYear(academicYear) != null) {
            for (MeetingRequisition MeetingRequisition2 : this.MeetingRequisitionDAO.getMeetingRequisitionListAndAcademicYear(academicYear)) {
                if (MeetingRequisition2.getApprovalStatus().equals("Cancelled")) continue;
                Hibernate.initialize((Object)MeetingRequisition2.getStudentClass());
                Hibernate.initialize((Object)MeetingRequisition2.getSection());
                Hibernate.initialize((Object)MeetingRequisition2.getInstitution());
                Hibernate.initialize((Object)MeetingRequisition2.getAcademicYear());
                Hibernate.initialize((Object)MeetingRequisition2.getMeetingApprover().getStaff());
                Hibernate.initialize((Object)MeetingRequisition2.getMeetingApprover().getStudent());
                Hibernate.initialize((Object)MeetingRequisition2.getMeetingRequester().getStaff());
                Hibernate.initialize((Object)MeetingRequisition2.getMeetingRequester().getStudent());
                tcRequests.add(MeetingRequisition2);
            }
        }
        return tcRequests;
    }

    @Override
    public Set<MeetingRequisition> meetingRequisitionListByAcademicYearAndClassAndSection(Long academicYearId, Long classId, Long sectionId) throws MeetingRequisitionException {
        LinkedHashSet<MeetingRequisition> tcRequests = new LinkedHashSet<MeetingRequisition>();
        AcademicYear academicYear = this.academicYearDAO.getAcademicYearById(academicYearId);
        Class classs = this.classDAO.getClassById(classId);
        Section section = this.sectionDAO.getSectionById(sectionId);
        if (this.MeetingRequisitionDAO.getMeetingRequisitionListAndAcademicYearAndClassAndSection(academicYear, classs, section) != null) {
            for (MeetingRequisition MeetingRequisition2 : this.MeetingRequisitionDAO.getMeetingRequisitionListAndAcademicYearAndClassAndSection(academicYear, classs, section)) {
                if (MeetingRequisition2.getApprovalStatus().equals("Cancelled")) continue;
                Hibernate.initialize((Object)MeetingRequisition2.getStudentClass());
                Hibernate.initialize((Object)MeetingRequisition2.getMeetingApprover().getStaff());
                Hibernate.initialize((Object)MeetingRequisition2.getMeetingApprover().getStudent());
                Hibernate.initialize((Object)MeetingRequisition2.getMeetingRequester().getStaff());
                Hibernate.initialize((Object)MeetingRequisition2.getMeetingRequester().getStudent());
                Hibernate.initialize((Object)MeetingRequisition2.getSection());
                Hibernate.initialize((Object)MeetingRequisition2.getInstitution());
                Hibernate.initialize((Object)MeetingRequisition2.getAcademicYear());
                tcRequests.add(MeetingRequisition2);
            }
        }
        return tcRequests;
    }
}
