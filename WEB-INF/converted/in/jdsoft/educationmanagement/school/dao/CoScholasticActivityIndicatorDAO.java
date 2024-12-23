/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Repository
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.CoScholasticActivityIndicator;
import java.io.Serializable;
import org.springframework.stereotype.Repository;

@Repository
public class CoScholasticActivityIndicatorDAO
extends GenericDAO<CoScholasticActivityIndicator> {
    public CoScholasticActivityIndicatorDAO() {
        super(CoScholasticActivityIndicator.class);
    }

    public CoScholasticActivityIndicator getCoScholasticActivityIndicatorById(Long id) {
        CoScholasticActivityIndicator instance = (CoScholasticActivityIndicator)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.CoScholasticActivityIndicator", (Serializable)id);
        return instance;
    }
}
