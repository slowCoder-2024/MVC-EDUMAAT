/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Repository
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.CoScholasticActivity;
import java.io.Serializable;
import org.springframework.stereotype.Repository;

@Repository
public class CoScholasticActivityDAO
extends GenericDAO<CoScholasticActivity> {
    public CoScholasticActivityDAO() {
        super(CoScholasticActivity.class);
    }

    public CoScholasticActivity getCoScholasticActivityById(Long id) {
        CoScholasticActivity instance = (CoScholasticActivity)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.CoScholasticActivity", (Serializable)id);
        return instance;
    }
}
