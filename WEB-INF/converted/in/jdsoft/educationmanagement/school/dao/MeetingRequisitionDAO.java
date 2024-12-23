/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.Criteria
 *  org.hibernate.criterion.Criterion
 *  org.hibernate.criterion.Restrictions
 *  org.springframework.stereotype.Repository
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.Class;
import in.jdsoft.educationmanagement.school.model.MeetingRequisition;
import in.jdsoft.educationmanagement.school.model.Section;
import in.jdsoft.educationmanagement.school.model.User;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class MeetingRequisitionDAO
extends GenericDAO<MeetingRequisition> {
    public MeetingRequisitionDAO() {
        super(MeetingRequisition.class);
    }

    public MeetingRequisition getMeetingRequisitionById(Long id) {
        MeetingRequisition instance = (MeetingRequisition)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.MeetingRequisition", (Serializable)id);
        return instance;
    }

    public List<MeetingRequisition> getMeetingRequisitionListAndApproveUserAndStatus(User user, String status) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(MeetingRequisition.class);
        criteria.add((Criterion)Restrictions.eq((String)"meetingApprover", (Object)user));
        criteria.add((Criterion)Restrictions.eq((String)"approvalStatus", (Object)status));
        List MeetingRequisitions = criteria.list();
        return MeetingRequisitions;
    }

    public List<MeetingRequisition> getMeetingRequisitionListAndRequestUserAndStatus(User user, String status) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(MeetingRequisition.class);
        criteria.add((Criterion)Restrictions.eq((String)"meetingRequester", (Object)user));
        criteria.add((Criterion)Restrictions.eq((String)"approvalStatus", (Object)status));
        List MeetingRequisitions = criteria.list();
        return MeetingRequisitions;
    }

    public List<MeetingRequisition> getMeetingRequisitionListByStatus(String status) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(MeetingRequisition.class);
        criteria.add((Criterion)Restrictions.eq((String)"approvalStatus", (Object)status));
        List MeetingRequisitions = criteria.list();
        return MeetingRequisitions;
    }

    public List<MeetingRequisition> getMeetingRequisitionListAndApproveUser(User user) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(MeetingRequisition.class);
        criteria.add((Criterion)Restrictions.eq((String)"meetingApprover", (Object)user));
        List MeetingRequisitions = criteria.list();
        return MeetingRequisitions;
    }

    public List<MeetingRequisition> getMeetingRequisitionListAndRequestUser(User user) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(MeetingRequisition.class);
        criteria.add((Criterion)Restrictions.eq((String)"meetingRequester", (Object)user));
        List MeetingRequisitions = criteria.list();
        return MeetingRequisitions;
    }

    public List<MeetingRequisition> getMeetingRequisitionListAndAcademicYear(AcademicYear academicYear) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(MeetingRequisition.class);
        criteria.add((Criterion)Restrictions.eq((String)"academicYear", (Object)academicYear));
        List MeetingRequisitions = criteria.list();
        return MeetingRequisitions;
    }

    public List<MeetingRequisition> getMeetingRequisitionListAndAcademicYearAndClassAndSection(AcademicYear academicYear, Class classs, Section section) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(MeetingRequisition.class);
        criteria.add((Criterion)Restrictions.eq((String)"academicYear", (Object)academicYear));
        criteria.add((Criterion)Restrictions.eq((String)"studentClass", (Object)classs));
        criteria.add((Criterion)Restrictions.eq((String)"section", (Object)section));
        List MeetingRequisitions = criteria.list();
        return MeetingRequisitions;
    }
}
