/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Repository
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.CoScholasticArea;
import java.io.Serializable;
import org.springframework.stereotype.Repository;

@Repository
public class CoScholasticAreaDAO
extends GenericDAO<CoScholasticArea> {
    public CoScholasticAreaDAO() {
        super(CoScholasticArea.class);
    }

    public CoScholasticArea getCoScholasticAreaById(Long id) {
        CoScholasticArea instance = (CoScholasticArea)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.CoScholasticArea", (Serializable)id);
        return instance;
    }
}
