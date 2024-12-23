/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Repository
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.CoScholasticAreaIndicator;
import java.io.Serializable;
import org.springframework.stereotype.Repository;

@Repository
public class CoScholasticAreaIndicatorDAO
extends GenericDAO<CoScholasticAreaIndicator> {
    public CoScholasticAreaIndicatorDAO() {
        super(CoScholasticAreaIndicator.class);
    }

    public CoScholasticAreaIndicator getCoScholasticAreaIndicatorById(Long id) {
        CoScholasticAreaIndicator instance = (CoScholasticAreaIndicator)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.CoScholasticAreaIndicator", (Serializable)id);
        return instance;
    }
}
