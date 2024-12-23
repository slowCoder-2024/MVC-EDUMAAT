/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.zxing.BarcodeFormat
 *  com.google.zxing.client.j2se.MatrixToImageWriter
 *  com.google.zxing.common.BitMatrix
 *  com.google.zxing.qrcode.QRCodeWriter
 *  org.hibernate.Hibernate
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import in.jdsoft.educationmanagement.school.components.FileUploadHandler;
import in.jdsoft.educationmanagement.school.dao.InstitutionDAO;
import in.jdsoft.educationmanagement.school.dao.VisitorIDCardGenerationDAO;
import in.jdsoft.educationmanagement.school.dao.VisitorManagementDAO;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.VisitorIDCardGeneration;
import in.jdsoft.educationmanagement.school.model.VisitorManagement;
import in.jdsoft.educationmanagement.school.services.VisitorManagementService;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="visitorManagementService")
public class VisitorManagementServiceImpl
implements VisitorManagementService {
    @Autowired
    VisitorManagementDAO visitorManagementDAO;
    @Autowired
    InstitutionDAO institutionDAO;
    @Autowired
    VisitorIDCardGenerationDAO visitorIDCardGenerationDAO;
    @Autowired
    FileUploadHandler fileUploadHandler;

    @Override
    public Long createVisitorManagement(VisitorManagement visitorManagement) throws Exception {
        QRCodeWriter writer = new QRCodeWriter();
        try {
            VisitorManagement persistedvisitorManagement = this.visitorManagementDAO.save(visitorManagement);
            Long visitorManagementId = persistedvisitorManagement.getVisitorManagmentId();
            VisitorIDCardGeneration visitorIDCardGeneration = visitorManagement.getVisitorIDCardGeneration();
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
            log.info((Object)(" visitorManagement created with the id=" + visitorManagementId));
            return visitorManagementId;
        }
        catch (Exception e) {
            log.error((Object)"Exception in Creating  visitorManagement", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteVisitorManagement(Long visitorManagementId) {
        try {
            VisitorManagement visitorManagement = this.visitorManagementDAO.getVisitorManagementById(visitorManagementId);
            if (visitorManagement != null) {
                this.visitorManagementDAO.delete(visitorManagement);
                log.info((Object)(" visitorManagement with id=" + visitorManagementId + " has been deleted successfully"));
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in deleting  visitorManagement", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<VisitorManagement> visitorManagementList() {
        try {
            List<VisitorManagement> visitorManagementList = this.visitorManagementDAO.getList();
            Integer visitorManagementListSize = visitorManagementList.size();
            if (visitorManagementListSize > 0) {
                log.info((Object)(visitorManagementListSize + "  visitorManagement records where reterived"));
            } else {
                log.info((Object)"No  visitorManagement list available");
            }
            return visitorManagementList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving  visitorManagement list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public VisitorManagement visitorManagementById(Long visitorManagementId) {
        try {
            VisitorManagement visitorManagement = this.visitorManagementDAO.getVisitorManagementById(visitorManagementId);
            if (visitorManagement != null) {
                log.info((Object)(" visitorManagement with id=" + visitorManagementId + " has been reterived"));
                return visitorManagement;
            }
            log.info((Object)("No  visitorManagement with  id=" + visitorManagementId + " is available"));
            return visitorManagement;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving  visitorManagement by id=" + visitorManagementId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateVisitorManagement(VisitorManagement visitorManagement) {
        try {
            this.visitorManagementDAO.saveOrUpdate(visitorManagement);
            log.info((Object)"New  visitorManagement has been added, because no  visitorManagement found for update");
        }
        catch (Exception e) {
            log.error((Object)"Exception in updating  visitorManagement", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public VisitorManagement visitorManagementByIdEager(Long visitorManagementId) {
        try {
            VisitorManagement visitorManagement = this.visitorManagementDAO.getVisitorManagementById(visitorManagementId);
            if (visitorManagement != null) {
                log.info((Object)(" visitorManagement with id=" + visitorManagementId + " has been reterived"));
                Hibernate.initialize((Object)visitorManagement.getVisitorType());
                Hibernate.initialize((Object)visitorManagement.getVisitorIDCardGeneration());
                Hibernate.initialize((Object)visitorManagement.getInstitution());
                return visitorManagement;
            }
            log.info((Object)("No  visitorManagement with  id=" + visitorManagementId + " is available"));
            return visitorManagement;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving  visitorManagement by id=" + visitorManagementId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<VisitorManagement> visitorManagementListByInsitution(Long institutionId) {
        try {
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            List<VisitorManagement> visitorManagements = this.visitorManagementDAO.getVisitorManagementByInstitution(institution);
            for (VisitorManagement visitorManagement : visitorManagements) {
                Hibernate.initialize((Object)visitorManagement.getVisitorType());
                Hibernate.initialize((Object)visitorManagement.getVisitorIDCardGeneration());
                Hibernate.initialize((Object)visitorManagement.getInstitution());
            }
            return visitorManagements;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving  visitorManagement by id=" + institutionId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }
}
