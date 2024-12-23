/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Component
 */
package in.jdsoft.educationmanagement.school.components;

import in.jdsoft.educationmanagement.school.exceptions.SMSGatewayDetailsException;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.SMSGatewayDetails;
import in.jdsoft.educationmanagement.school.services.SMSGatewayDetailsService;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SMSHandler {
    @Autowired
    private SMSGatewayDetailsService sMSGatewayDetailsService;

    public void sentSMS(String mobileNumber, String message, Long institutionId) throws Exception {
        block4: {
            try {
                SMSGatewayDetails sMSGatewayDetails = this.sMSGatewayDetailsService.sMSGatewayDetailsByInstitution(institutionId);
                if (sMSGatewayDetails != null) {
                    String line;
                    String data = "";
                    data = String.valueOf(data) + "mobile=" + URLEncoder.encode(sMSGatewayDetails.getSmsGatewayUserName().trim(), "ISO-8859-1");
                    data = String.valueOf(data) + "&pass=" + URLEncoder.encode(sMSGatewayDetails.getSmsGatewayPassword().trim(), "ISO-8859-1");
                    data = String.valueOf(data) + "&msg=" + URLEncoder.encode(message, "ISO-8859-1");
                    data = String.valueOf(data) + "&senderid=" + sMSGatewayDetails.getSmsGatewaySenderId().trim();
                    data = String.valueOf(data) + "&to=" + mobileNumber;
                    URL url = new URL("http://sms.edumaat.com/sendsms.aspx");
                    URLConnection conn = url.openConnection();
                    conn.setDoOutput(true);
                    OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
                    wr.write(data);
                    wr.flush();
                    BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    while ((line = rd.readLine()) != null) {
                        System.out.println(line);
                    }
                    wr.close();
                    rd.close();
                    break block4;
                }
                throw new SMSGatewayDetailsException(new Message("failure", "Please Check UserId,Password,SenderId...!"));
            }
            catch (Exception e) {
                e.printStackTrace();
                throw e;
            }
        }
    }

    public String checkSMSBalance(Long institutionId) throws Exception {
        try {
            SMSGatewayDetails sMSGatewayDetails = this.sMSGatewayDetailsService.sMSGatewayDetailsByInstitution(institutionId);
            if (sMSGatewayDetails != null) {
                String line;
                URL url = new URL(" http://sms.edumaat.com/getBalance.aspx?mobile=" + sMSGatewayDetails.getSmsGatewayUserName().trim() + "&pass=" + sMSGatewayDetails.getSmsGatewayPassword().trim());
                URLConnection conn = url.openConnection();
                conn.setDoOutput(true);
                BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String str = "";
                while ((line = rd.readLine()) != null) {
                    System.out.println(line);
                    str = String.valueOf(str) + line;
                }
                rd.close();
                return str;
            }
            throw new SMSGatewayDetailsException(new Message("failure", "Please Check UserId,Password,SenderId...!"));
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
