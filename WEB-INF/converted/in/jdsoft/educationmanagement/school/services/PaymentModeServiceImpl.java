/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.PaymentModeDAO;
import in.jdsoft.educationmanagement.school.model.PaymentMode;
import in.jdsoft.educationmanagement.school.model.PaymentStatus;
import in.jdsoft.educationmanagement.school.services.PaymentModeService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="paymentModeService")
public class PaymentModeServiceImpl
implements PaymentModeService {
    @Autowired
    private PaymentModeDAO paymentModeDAO;

    @Override
    public PaymentMode paymentModeById(Long paymentModeId) {
        PaymentMode paymentMode = null;
        try {
            paymentMode = this.paymentModeDAO.getPaymentModeById(paymentModeId);
            if (paymentMode != null) {
                log.info((Object)("Payement Mode has been reterived from the given payment mode id=" + paymentModeId));
            } else {
                log.info((Object)("No Payement Mode for the given payment mode id=" + paymentModeId));
            }
            return paymentMode;
        }
        catch (Exception e) {
            log.error((Object)"Exception in Reteriving Payment mode By Id", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<PaymentMode> paymentModeList() {
        ArrayList<PaymentMode> paymentModes = new ArrayList();
        try {
            paymentModes = this.paymentModeDAO.getList();
            log.info((Object)"Payement Mode list has been reterived");
            return paymentModes;
        }
        catch (Exception e) {
            log.error((Object)"Exception in Reteriving Payment Mode List", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public ArrayList<PaymentStatus> getPaymentStatusOfPaymentMode(Long paymentModeId) {
        ArrayList<PaymentStatus> paymentStatusList = new ArrayList<PaymentStatus>();
        PaymentMode paymentMode = this.paymentModeDAO.getPaymentModeById(paymentModeId);
        paymentStatusList.addAll(paymentMode.getPaymentStatusType());
        return paymentStatusList;
    }

    @Override
    public ArrayList<PaymentMode> getActivePaymentModes() {
        return (ArrayList)this.paymentModeDAO.getActivePaymentModes();
    }
}
