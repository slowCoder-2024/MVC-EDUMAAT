/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.model.InstitutionConfigDetails;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface InstitutionConfigDetailsService {
    public static final Logger log = LogManager.getLogger((String)InstitutionConfigDetailsService.class.getName());

    public Long createInstitutionConfigDetails(InstitutionConfigDetails var1);

    public List<InstitutionConfigDetails> institutionConfigDetailsList();

    public InstitutionConfigDetails institutionConfigDetailsById(Long var1);

    public InstitutionConfigDetails institutionConfigDetail();
}
