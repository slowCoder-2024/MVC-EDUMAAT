/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Repository
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.AdmissionDocumentTypes;
import java.io.Serializable;
import org.springframework.stereotype.Repository;

@Repository
public class AdmissionDocumentTypeDAO
extends GenericDAO<AdmissionDocumentTypes> {
    public AdmissionDocumentTypeDAO() {
        super(AdmissionDocumentTypes.class);
    }

    public AdmissionDocumentTypes getAdmissionDocumentTypesById(Long id) {
        AdmissionDocumentTypes instance = (AdmissionDocumentTypes)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.AdmissionDocumentTypes", (Serializable)id);
        return instance;
    }
}
