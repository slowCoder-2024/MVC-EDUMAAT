/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.model.TaxClass;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface TaxClassService {
    public static final Logger log = LogManager.getLogger((String)TaxClassService.class.getName());

    public List<TaxClass> taxClassList();

    public TaxClass taxClassById(Long var1);

    public void createTaxClass(TaxClass var1);

    public void updateTaxClass(TaxClass var1);

    public void deleteTaxClass(Long var1);
}
