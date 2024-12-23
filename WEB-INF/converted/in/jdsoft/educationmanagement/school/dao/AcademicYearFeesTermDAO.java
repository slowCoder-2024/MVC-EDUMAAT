/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Repository
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.AcademicYearFeesTerm;
import java.io.Serializable;
import org.springframework.stereotype.Repository;

@Repository
public class AcademicYearFeesTermDAO
extends GenericDAO<AcademicYearFeesTerm> {
    public AcademicYearFeesTermDAO() {
        super(AcademicYearFeesTerm.class);
    }

    public AcademicYearFeesTerm getAcademicYearFeesTermById(Long id) {
        AcademicYearFeesTerm instance = (AcademicYearFeesTerm)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.AcademicYearFeesTerm", (Serializable)id);
        return instance;
    }
}
