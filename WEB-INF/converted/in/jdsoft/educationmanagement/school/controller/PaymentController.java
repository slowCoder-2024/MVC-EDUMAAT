/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Controller
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RequestMethod
 *  org.springframework.web.bind.annotation.ResponseBody
 */
package in.jdsoft.educationmanagement.school.controller;

import in.jdsoft.educationmanagement.school.model.PaymentStatus;
import in.jdsoft.educationmanagement.school.services.PaymentModeService;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value={"/payment"})
public class PaymentController {
    @Autowired
    PaymentModeService paymentServices;

    @RequestMapping(value={"paymentmode/status"}, method={RequestMethod.GET})
    @ResponseBody
    public ArrayList<PaymentStatus> studentReceiptsByPaymentMode(HttpServletRequest request) {
        try {
            Long paymentModeId = Long.parseLong(request.getParameter("paymentModeId"));
            return this.paymentServices.getPaymentStatusOfPaymentMode(paymentModeId);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
