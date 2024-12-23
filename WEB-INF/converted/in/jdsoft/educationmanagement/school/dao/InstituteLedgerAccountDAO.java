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
import in.jdsoft.educationmanagement.school.model.InstituteLedgerAccount;
import in.jdsoft.educationmanagement.school.model.Institution;
import java.io.Serializable;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class InstituteLedgerAccountDAO
extends GenericDAO<InstituteLedgerAccount> {
    public InstituteLedgerAccountDAO() {
        super(InstituteLedgerAccount.class);
    }

    public InstituteLedgerAccount getInstituteLedgerAccountById(Long id) {
        InstituteLedgerAccount instance = (InstituteLedgerAccount)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.InstituteLedgerAccount", (Serializable)id);
        return instance;
    }

    public InstituteLedgerAccount getInstituteLedgerAccountByInstituteLedgerAccountName(String instituteLedgerAccountName, Institution institution) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(InstituteLedgerAccount.class);
        criteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"ledgerAccountName", (Object)instituteLedgerAccountName)).add((Criterion)Restrictions.eq((String)"institution", (Object)institution)));
        InstituteLedgerAccount instituteLedgerAccount = (InstituteLedgerAccount)criteria.uniqueResult();
        return instituteLedgerAccount;
    }
}
