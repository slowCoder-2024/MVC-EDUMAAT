/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Repository
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.AdmissionDocument;
import java.io.Serializable;
import org.springframework.stereotype.Repository;

@Repository
public class AdmissionDocumentDAO
extends GenericDAO<AdmissionDocument> {
    public AdmissionDocumentDAO() {
        super(AdmissionDocument.class);
    }

    public AdmissionDocument getAdmissionDocumentById(Long id) {
        AdmissionDocument instance = (AdmissionDocument)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.AdmissionDocument", (Serializable)id);
        return instance;
    }
}
