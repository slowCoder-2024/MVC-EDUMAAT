/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Repository
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.StaffBankDetail;
import java.io.Serializable;
import org.springframework.stereotype.Repository;

@Repository
public class StaffBankDetailDAO
extends GenericDAO<StaffBankDetail> {
    public StaffBankDetailDAO() {
        super(StaffBankDetail.class);
    }

    public StaffBankDetail getStaffBankDetailById(Long id) {
        StaffBankDetail instance = (StaffBankDetail)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.StaffBankDetail", (Serializable)id);
        return instance;
    }
}
