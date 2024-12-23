/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Repository
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.AdmissionFeesPaymentDetails;
import java.io.Serializable;
import org.springframework.stereotype.Repository;

@Repository
public class AdmissionFeesPaymentDetailsDAO
extends GenericDAO<AdmissionFeesPaymentDetails> {
    public AdmissionFeesPaymentDetailsDAO() {
        super(AdmissionFeesPaymentDetails.class);
    }

    public AdmissionFeesPaymentDetails getAdmissionFeesPaymentDetailsById(Long id) {
        AdmissionFeesPaymentDetails instance = (AdmissionFeesPaymentDetails)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.AdmissionFeesPaymentDetails", (Serializable)id);
        return instance;
    }
}
