/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.exceptions.VisitorIDCardGenerationException;
import in.jdsoft.educationmanagement.school.model.VisitorIDCardGeneration;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor={VisitorIDCardGenerationException.class})
public interface VisitorIDCardGenerationService {
    public static final Logger log = LogManager.getLogger((String)VisitorIDCardGenerationService.class.getName());

    public void createQRCodeAndQRCodeImage(VisitorIDCardGeneration var1) throws VisitorIDCardGenerationException, Exception;

    public VisitorIDCardGeneration visitorIDCardGenerationByVisitorManagement(Long var1) throws Exception;
}
