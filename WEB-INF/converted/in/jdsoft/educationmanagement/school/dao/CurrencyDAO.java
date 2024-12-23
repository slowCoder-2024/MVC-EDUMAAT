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
import in.jdsoft.educationmanagement.school.model.Currency;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class CurrencyDAO
extends GenericDAO<Currency> {
    public CurrencyDAO() {
        super(Currency.class);
    }

    public Currency getCurrencyByIsoCode(String currencyCode) {
        Criteria currencycriteria = this.sessionFactory.getCurrentSession().createCriteria(Currency.class);
        currencycriteria.add((Criterion)Restrictions.eq((String)"isoCode", (Object)currencyCode));
        Currency currency = (Currency)currencycriteria.uniqueResult();
        return currency;
    }
}
