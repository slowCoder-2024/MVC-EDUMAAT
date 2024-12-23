/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Repository
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.PaymentStatus;
import java.io.Serializable;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentStatusDAO
extends GenericDAO<PaymentStatus> {
    public PaymentStatusDAO() {
        super(PaymentStatus.class);
    }

    public PaymentStatus getPaymentStatusById(Long id) {
        PaymentStatus instance = (PaymentStatus)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.PaymentStatus", (Serializable)id);
        return instance;
    }
}
