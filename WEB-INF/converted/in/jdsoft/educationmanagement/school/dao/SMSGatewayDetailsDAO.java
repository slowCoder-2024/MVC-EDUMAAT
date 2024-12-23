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
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.SMSGatewayDetails;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class SMSGatewayDetailsDAO
extends GenericDAO<SMSGatewayDetails> {
    public SMSGatewayDetailsDAO() {
        super(SMSGatewayDetails.class);
    }

    public SMSGatewayDetails getSMSGatewayDetailsById(Long id) {
        SMSGatewayDetails instance = (SMSGatewayDetails)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.SMSGatewayDetails", (Serializable)id);
        return instance;
    }

    public List<SMSGatewayDetails> getSMSGatewayDetailsByInstitution(Institution institution) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(SMSGatewayDetails.class);
        criteria.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        List sMSGatewayDetails = criteria.list();
        return sMSGatewayDetails;
    }

    public SMSGatewayDetails getSMSGatewayDetailByInstitution(Institution institution) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(SMSGatewayDetails.class);
        criteria.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        SMSGatewayDetails sMSGatewayDetails = (SMSGatewayDetails)criteria.uniqueResult();
        return sMSGatewayDetails;
    }
}
