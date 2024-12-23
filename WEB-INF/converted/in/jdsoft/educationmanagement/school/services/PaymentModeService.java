/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.model.PaymentMode;
import in.jdsoft.educationmanagement.school.model.PaymentStatus;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface PaymentModeService {
    public static final Logger log = LogManager.getLogger((String)PaymentModeService.class.getName());

    public PaymentMode paymentModeById(Long var1);

    public List<PaymentMode> paymentModeList();

    public ArrayList<PaymentStatus> getPaymentStatusOfPaymentMode(Long var1);

    public ArrayList<PaymentMode> getActivePaymentModes();
}
