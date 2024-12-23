/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.DocumentDAO;
import in.jdsoft.educationmanagement.school.dao.DocumentTypeDAO;
import in.jdsoft.educationmanagement.school.dao.StaffDAO;
import in.jdsoft.educationmanagement.school.dao.StudentDAO;
import in.jdsoft.educationmanagement.school.model.Document;
import in.jdsoft.educationmanagement.school.model.DocumentType;
import in.jdsoft.educationmanagement.school.model.Staff;
import in.jdsoft.educationmanagement.school.model.Student;
import in.jdsoft.educationmanagement.school.services.DocumentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="documentService")
public class DocumentServiceImpl
implements DocumentService {
    @Autowired
    DocumentDAO documentDAO;
    @Autowired
    StudentDAO studentDAO;
    @Autowired
    DocumentTypeDAO documentTypeDAO;
    @Autowired
    StaffDAO staffDAO;

    @Override
    public List<Document> documentList() {
        try {
            List<Document> document = this.documentDAO.getList();
            Integer documentSize = document.size();
            if (documentSize > 0) {
                log.info((Object)(documentSize + " Document records where reterived"));
            } else {
                log.info((Object)"No Document available");
            }
            return document;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving Document list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Document documentById(Long documentId) {
        try {
            Document document = this.documentDAO.getDocumentById(documentId);
            if (documentId != null) {
                log.info((Object)("Document with id=" + documentId + " has been reterived"));
                return document;
            }
            log.info((Object)("No Document with  id=" + documentId + " is available"));
            return document;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving Document by id=" + documentId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void createDocument(Document document) {
        try {
            this.documentDAO.save(document);
        }
        catch (Exception e) {
            log.error((Object)("Exception in creating Document " + e.getCause()));
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateDocument(Document document) {
        try {
            this.documentDAO.saveOrUpdate(document);
        }
        catch (Exception e) {
            log.error((Object)("Exception in updating Document " + e.getCause()));
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteDocument(Long documentId) {
        try {
            this.documentDAO.delete(this.documentDAO.getDocumentById(documentId));
        }
        catch (Exception e) {
            log.error((Object)("Exception in deleting Document " + e.getCause()));
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Document documentByDocumentTypeAndStudent(Long documentTypeId, Long studentId) {
        try {
            Student student = this.studentDAO.getStudentById(studentId);
            DocumentType documentType = this.documentTypeDAO.getDocumentTypeById(documentTypeId);
            Document document = this.documentDAO.getDocumentByDocumentTypeAndStudent(documentType, student);
            return document;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Document documentByDocumentTypeAndStudentAdmissionNo(Long documentTypeId, String admissionNo) {
        try {
            Student student = this.studentDAO.getStudentByAdmissionNo(admissionNo);
            DocumentType documentType = this.documentTypeDAO.getDocumentTypeById(documentTypeId);
            Document document = this.documentDAO.getDocumentByDocumentTypeAndStudent(documentType, student);
            return document;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Document documentByDocumentTypeAndStaff(Long documentTypeId, Long staffId) {
        try {
            Staff staff = this.staffDAO.getStaffById(staffId);
            DocumentType documentType = this.documentTypeDAO.getDocumentTypeById(documentTypeId);
            Document document = this.documentDAO.getDocumentByDocumentTypeAndStaff(documentType, staff);
            return document;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
