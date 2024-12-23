/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.zxing.BarcodeFormat
 *  com.google.zxing.client.j2se.MatrixToImageWriter
 *  com.google.zxing.common.BitMatrix
 *  com.google.zxing.qrcode.QRCodeWriter
 *  org.hibernate.Hibernate
 *  org.hibernate.exception.ConstraintViolationException
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import in.jdsoft.educationmanagement.school.components.FileUploadHandler;
import in.jdsoft.educationmanagement.school.dao.VisitorIDCardGenerationDAO;
import in.jdsoft.educationmanagement.school.dao.VisitorManagementDAO;
import in.jdsoft.educationmanagement.school.exceptions.VisitorIDCardGenerationException;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.VisitorIDCardGeneration;
import in.jdsoft.educationmanagement.school.model.VisitorManagement;
import in.jdsoft.educationmanagement.school.services.VisitorIDCardGenerationService;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import org.hibernate.Hibernate;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="visitorIDCardGenerationService")
public class VisitorIDCardGenerationServiceImpl
implements VisitorIDCardGenerationService {
    @Autowired
    VisitorIDCardGenerationDAO visitorIDCardGenerationDAO;
    @Autowired
    FileUploadHandler fileUploadHandler;
    @Autowired
    VisitorManagementDAO visitorManagementDAO;

    @Override
    public void createQRCodeAndQRCodeImage(VisitorIDCardGeneration visitorIDCardGeneration) throws VisitorIDCardGenerationException, Exception {
        QRCodeWriter writer = new QRCodeWriter();
        try {
            String millisecond = Long.toString(System.currentTimeMillis());
            String code = "Visitor" + millisecond;
            String[] args = visitorIDCardGeneration.getQrImage().split("@");
            String location = args[0];
            String path = args[1];
            location = String.valueOf(location) + path;
            this.fileUploadHandler.createFolderIfNotExist(location);
            String name = String.valueOf(visitorIDCardGeneration.getVisitorManagement().getVisitorName()) + Long.toString(System.currentTimeMillis()) + ".jpg";
            try {
                BitMatrix bitMatrix = writer.encode(code, BarcodeFormat.QR_CODE, 200, 200);
                MatrixToImageWriter.writeToStream((BitMatrix)bitMatrix, (String)"jpg", (OutputStream)new FileOutputStream(new File(String.valueOf(location) + name)));
            }
            catch (Exception e) {
                e.printStackTrace();
                throw e;
            }
            visitorIDCardGeneration.setQrCode(code);
            visitorIDCardGeneration.setQrImage(String.valueOf(path) + name);
            this.visitorIDCardGenerationDAO.persist(visitorIDCardGeneration);
        }
        catch (Exception e) {
            e.printStackTrace();
            if (e.getClass().equals(ConstraintViolationException.class)) {
                throw new VisitorIDCardGenerationException(new Message("failure", "VisitorID Card Cannot Be Generated!! Already ID Card Generated for this Class And Section"));
            }
            log.error((Object)"Exception in Creating Visitor id card generation", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public VisitorIDCardGeneration visitorIDCardGenerationByVisitorManagement(Long visitorManagementId) throws Exception {
        try {
            VisitorManagement visitorManagement = this.visitorManagementDAO.getVisitorManagementById(visitorManagementId);
            Hibernate.initialize((Object)visitorManagement.getVisitorIDCardGeneration());
            return visitorManagement.getVisitorIDCardGeneration();
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
