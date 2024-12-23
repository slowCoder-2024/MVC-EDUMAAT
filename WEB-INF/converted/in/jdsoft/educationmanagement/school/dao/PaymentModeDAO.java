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
import in.jdsoft.educationmanagement.school.model.PaymentMode;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentModeDAO
extends GenericDAO<PaymentMode> {
    public PaymentModeDAO() {
        super(PaymentMode.class);
    }

    public PaymentMode getPaymentModeById(Long id) {
        PaymentMode instance = (PaymentMode)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.PaymentMode", (Serializable)id);
        return instance;
    }

    public List<PaymentMode> getActivePaymentModes() {
        Criteria paymentcriteria = this.sessionFactory.getCurrentSession().createCriteria(PaymentMode.class);
        paymentcriteria.add((Criterion)Restrictions.eq((String)"visibility", (Object)1));
        List paymentModes = paymentcriteria.list();
        return paymentModes;
    }
}
