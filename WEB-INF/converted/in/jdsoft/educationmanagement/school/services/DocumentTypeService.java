/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.model.DocumentType;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface DocumentTypeService {
    public static final Logger log = LogManager.getLogger((String)DocumentTypeService.class.getName());

    public List<DocumentType> documentTypeList();

    public DocumentType documentTypeById(Long var1);

    public void createDocumentType(DocumentType var1);

    public void updateDocumentType(DocumentType var1);

    public void deleteDocumentType(Long var1);

    public List<DocumentType> documentTypeList(Long var1);
}
