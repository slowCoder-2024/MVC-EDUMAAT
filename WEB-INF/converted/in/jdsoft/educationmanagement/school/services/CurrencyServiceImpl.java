/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.CurrencyDAO;
import in.jdsoft.educationmanagement.school.model.Currency;
import in.jdsoft.educationmanagement.school.services.CurrencyService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="currencyService")
public class CurrencyServiceImpl
implements CurrencyService {
    @Autowired
    CurrencyDAO currencyDAO;

    @Override
    public List<Currency> currencyList() {
        try {
            List<Currency> currencies = this.currencyDAO.getList();
            Integer currencySize = currencies.size();
            if (currencySize > 0) {
                log.info((Object)(currencySize + " currency records where reterived"));
            } else {
                log.info((Object)"No currency available");
            }
            return currencies;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving currency list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }
}
