/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.Criteria
 *  org.hibernate.criterion.Criterion
 *  org.hibernate.criterion.Restrictions
 *  org.springframework.stereotype.Repository
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.DocumentType;
import in.jdsoft.educationmanagement.school.model.Institution;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class DocumentTypeDAO
extends GenericDAO<DocumentType> {
    public DocumentTypeDAO() {
        super(DocumentType.class);
    }

    public DocumentType getDocumentTypeById(Long id) {
        DocumentType instance = (DocumentType)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.DocumentType", (Serializable)id);
        return instance;
    }

    public DocumentType getDocumentTypeByNameAndInstitution(String documentTypeName, Institution institution) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(DocumentType.class);
        criteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"documentTypeName", (Object)documentTypeName)).add((Criterion)Restrictions.eq((String)"institution", (Object)institution)));
        DocumentType documentType = (DocumentType)criteria.uniqueResult();
        return documentType;
    }

    public List<DocumentType> getDocumentTypeByInstitution(Institution institution) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(DocumentType.class);
        criteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"institution", (Object)institution)));
        List documentTypes = criteria.list();
        return documentTypes;
    }
}
