/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.exceptions.SMSGatewayDetailsException;
import in.jdsoft.educationmanagement.school.model.SMSGatewayDetails;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface SMSGatewayDetailsService {
    public static final Logger log = LogManager.getLogger((String)SMSGatewayDetailsService.class.getName());

    public void createSMSGatewayDetails(SMSGatewayDetails var1) throws SMSGatewayDetailsException;

    public void updateSMSGatewayDetails(SMSGatewayDetails var1) throws SMSGatewayDetailsException;

    public void deleteSMSGatewayDetails(Long var1) throws SMSGatewayDetailsException;

    public SMSGatewayDetails sMSGatewayDetailsById(Long var1);

    public SMSGatewayDetails sMSGatewayDetailsIdByEager(Long var1);

    public List<SMSGatewayDetails> sMSGatewayDetailsList();

    public List<SMSGatewayDetails> sMSGatewayDetailsListByInstitution(Long var1);

    public SMSGatewayDetails sMSGatewayDetailsByInstitution(Long var1);
}
