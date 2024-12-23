/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.Criteria
 *  org.hibernate.criterion.Conjunction
 *  org.hibernate.criterion.Criterion
 *  org.hibernate.criterion.Restrictions
 *  org.springframework.stereotype.Repository
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.Staff;
import in.jdsoft.educationmanagement.school.model.StaffLeaveRequisition;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class StaffLeaveRequisitionDAO
extends GenericDAO<StaffLeaveRequisition> {
    public StaffLeaveRequisitionDAO() {
        super(StaffLeaveRequisition.class);
    }

    public StaffLeaveRequisition getStaffLeaveRequisitionById(Long id) {
        StaffLeaveRequisition instance = (StaffLeaveRequisition)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.StaffLeaveRequisition", (Serializable)id);
        return instance;
    }

    public List<StaffLeaveRequisition> getStaffLeaveRequisitionList(Staff staff) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(StaffLeaveRequisition.class);
        criteria.add((Criterion)Restrictions.eq((String)"staff", (Object)staff));
        List staffLeaveRequisitions = criteria.list();
        return staffLeaveRequisitions;
    }

    public List<StaffLeaveRequisition> getStaffLeaveRequisitionByStaffEmailAndAttendanceMonth(Staff staff, Date attendanceMonth, String approvalStatus) {
        Date monthStartDate = new Date(attendanceMonth.getYear(), attendanceMonth.getMonth(), 1);
        Date monthEndDate = new Date(attendanceMonth.getYear(), attendanceMonth.getMonth() + 1, 0);
        Criteria staffModuleAttendanceCriteria = this.sessionFactory.getCurrentSession().createCriteria(StaffLeaveRequisition.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"staff", (Object)staff));
        and.add((Criterion)Restrictions.eq((String)"approvalStatus", (Object)approvalStatus));
        and.add(Restrictions.between((String)"staffLeaveStartDate", (Object)monthStartDate, (Object)monthEndDate));
        and.add(Restrictions.between((String)"staffLeaveEndDate", (Object)monthStartDate, (Object)monthEndDate));
        staffModuleAttendanceCriteria.add((Criterion)and);
        return staffModuleAttendanceCriteria.list();
    }
}
