/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.DocumentTypeDAO;
import in.jdsoft.educationmanagement.school.dao.InstitutionDAO;
import in.jdsoft.educationmanagement.school.dao.StudentDAO;
import in.jdsoft.educationmanagement.school.model.DocumentType;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.services.DocumentTypeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="documentTypeService")
public class DocumentTypeServiceImpl
implements DocumentTypeService {
    @Autowired
    DocumentTypeDAO documentTypeDAO;
    @Autowired
    StudentDAO studentDAO;
    @Autowired
    InstitutionDAO institutionDAO;

    @Override
    public List<DocumentType> documentTypeList() {
        try {
            List<DocumentType> documentType = this.documentTypeDAO.getList();
            Integer documentSize = documentType.size();
            if (documentSize > 0) {
                log.info((Object)(documentSize + " DocumentType records where reterived"));
            } else {
                log.info((Object)"No DocumentType available");
            }
            return documentType;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving DocumentType list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public DocumentType documentTypeById(Long documentTypeId) {
        try {
            DocumentType documentType = this.documentTypeDAO.getDocumentTypeById(documentTypeId);
            if (documentTypeId != null) {
                log.info((Object)("DocumentType with id=" + documentTypeId + " has been reterived"));
                return documentType;
            }
            log.info((Object)("No DocumentType with  id=" + documentTypeId + " is available"));
            return documentType;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving DocumentType by id=" + documentTypeId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void createDocumentType(DocumentType documentType) {
        try {
            this.documentTypeDAO.save(documentType);
        }
        catch (Exception e) {
            log.error((Object)("Exception in creating DocumentType " + e.getCause()));
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateDocumentType(DocumentType documentType) {
        try {
            this.documentTypeDAO.saveOrUpdate(documentType);
        }
        catch (Exception e) {
            log.error((Object)("Exception in updating DocumentType " + e.getCause()));
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteDocumentType(Long documentTypeId) {
        try {
            this.documentTypeDAO.delete(this.documentTypeDAO.getDocumentTypeById(documentTypeId));
        }
        catch (Exception e) {
            log.error((Object)("Exception in deleting DocumentType " + e.getCause()));
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<DocumentType> documentTypeList(Long institutionId) {
        try {
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            List<DocumentType> documentType = this.documentTypeDAO.getDocumentTypeByInstitution(institution);
            Integer documentSize = documentType.size();
            if (documentSize > 0) {
                log.info((Object)(documentSize + " DocumentType records where reterived"));
            } else {
                log.info((Object)"No DocumentType available");
            }
            return documentType;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving DocumentType list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }
}
