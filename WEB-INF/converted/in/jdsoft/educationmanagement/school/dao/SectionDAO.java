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
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Section;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class SectionDAO
extends GenericDAO<Section> {
    public SectionDAO() {
        super(Section.class);
    }

    public Section getSectionById(Long id) {
        Section instance = (Section)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.Section", (Serializable)id);
        return instance;
    }

    public List<Section> getSectionsByInstitution(Institution institution) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Section.class);
        criteria.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        List sections = criteria.list();
        return sections;
    }

    public Section getSectionBySectionName(String sectionName) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Section.class);
        criteria.add((Criterion)Restrictions.eq((String)"sectionName", (Object)sectionName));
        Section section = (Section)criteria.uniqueResult();
        return section;
    }

    public Section getSectionBySectionNameAndInstitution(String sectionName, Institution institution) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Section.class);
        criteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"sectionName", (Object)sectionName)).add((Criterion)Restrictions.eq((String)"institution", (Object)institution)));
        Section section = (Section)criteria.uniqueResult();
        return section;
    }
}
