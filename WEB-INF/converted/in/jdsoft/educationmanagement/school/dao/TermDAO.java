/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Repository
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.Term;
import java.io.Serializable;
import org.springframework.stereotype.Repository;

@Repository
public class TermDAO
extends GenericDAO<Term> {
    public TermDAO() {
        super(Term.class);
    }

    public Term getTermById(Long id) {
        Term instance = (Term)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.Term", (Serializable)id);
        return instance;
    }
}