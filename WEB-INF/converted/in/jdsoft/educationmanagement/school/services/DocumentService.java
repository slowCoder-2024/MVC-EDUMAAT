/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.model.Document;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface DocumentService {
    public static final Logger log = LogManager.getLogger((String)DocumentService.class.getName());

    public List<Document> documentList();

    public Document documentById(Long var1);

    public void createDocument(Document var1);

    public void updateDocument(Document var1);

    public void deleteDocument(Long var1);

    public Document documentByDocumentTypeAndStudent(Long var1, Long var2);

    public Document documentByDocumentTypeAndStaff(Long var1, Long var2);

    public Document documentByDocumentTypeAndStudentAdmissionNo(Long var1, String var2);
}
