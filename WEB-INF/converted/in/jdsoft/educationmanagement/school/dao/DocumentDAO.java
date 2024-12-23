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
import in.jdsoft.educationmanagement.school.model.Document;
import in.jdsoft.educationmanagement.school.model.DocumentType;
import in.jdsoft.educationmanagement.school.model.Staff;
import in.jdsoft.educationmanagement.school.model.Student;
import java.io.Serializable;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class DocumentDAO
extends GenericDAO<Document> {
    public DocumentDAO() {
        super(Document.class);
    }

    public Document getDocumentById(Long id) {
        Document instance = (Document)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.Document", (Serializable)id);
        return instance;
    }

    public Document getDocumentByDocumentTypeAndStudent(DocumentType documentType, Student student) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Document.class);
        criteria.add((Criterion)Restrictions.eq((String)"documentType", (Object)documentType));
        criteria.add((Criterion)Restrictions.eq((String)"student", (Object)student));
        Document document = (Document)criteria.uniqueResult();
        return document;
    }

    public Document getDocumentByDocumentTypeAndStaff(DocumentType documentType, Staff staff) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Document.class);
        criteria.add((Criterion)Restrictions.eq((String)"documentType", (Object)documentType));
        criteria.add((Criterion)Restrictions.eq((String)"staff", (Object)staff));
        Document document = (Document)criteria.uniqueResult();
        return document;
    }
}
