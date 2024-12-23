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
import in.jdsoft.educationmanagement.school.model.GeographicalLocation;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class GeographicalLocationDAO
extends GenericDAO<GeographicalLocation> {
    public GeographicalLocationDAO() {
        super(GeographicalLocation.class);
    }

    public GeographicalLocation getGeographicalLocationById(Long id) {
        GeographicalLocation instance = (GeographicalLocation)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.GeographicalLocation", (Serializable)id);
        return instance;
    }

    public List<GeographicalLocation> getGeographicalLocationCountryList() {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(GeographicalLocation.class);
        criteria.add((Criterion)Restrictions.eq((String)"geographicalLocationType", (Object)0));
        criteria.add((Criterion)Restrictions.eq((String)"isVisible", (Object)0));
        ArrayList location = (ArrayList)criteria.list();
        return location;
    }

    public List<GeographicalLocation> getAllGeographicalLocationCountryList() {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(GeographicalLocation.class);
        criteria.add((Criterion)Restrictions.eq((String)"geographicalLocationType", (Object)0));
        ArrayList location = (ArrayList)criteria.list();
        return location;
    }

    public List<GeographicalLocation> getGeographicalLocationStateList() {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(GeographicalLocation.class);
        criteria.add((Criterion)Restrictions.eq((String)"geographicalLocationType", (Object)1));
        criteria.add((Criterion)Restrictions.eq((String)"isVisible", (Object)0));
        ArrayList location = (ArrayList)criteria.list();
        return location;
    }

    public List<GeographicalLocation> getAllGeographicalLocationStateList() {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(GeographicalLocation.class);
        criteria.add((Criterion)Restrictions.eq((String)"geographicalLocationType", (Object)1));
        ArrayList location = (ArrayList)criteria.list();
        return location;
    }

    public List<GeographicalLocation> getGeographicalLocationCityList() {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(GeographicalLocation.class);
        criteria.add((Criterion)Restrictions.eq((String)"geographicalLocationType", (Object)2));
        criteria.add((Criterion)Restrictions.eq((String)"isVisible", (Object)0));
        ArrayList location = (ArrayList)criteria.list();
        return location;
    }

    public List<GeographicalLocation> getAllGeographicalLocationCityList() {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(GeographicalLocation.class);
        criteria.add((Criterion)Restrictions.eq((String)"geographicalLocationType", (Object)2));
        ArrayList location = (ArrayList)criteria.list();
        return location;
    }

    public List<GeographicalLocation> getStateListByCountry(Long countryId) {
        Integer parentId = (int)countryId.longValue();
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(GeographicalLocation.class);
        criteria.add((Criterion)Restrictions.eq((String)"parentId", (Object)parentId));
        criteria.add((Criterion)Restrictions.eq((String)"geographicalLocationType", (Object)1));
        criteria.add((Criterion)Restrictions.eq((String)"isVisible", (Object)0));
        ArrayList location = (ArrayList)criteria.list();
        return location;
    }

    public List<GeographicalLocation> getAllStateListByCountry(Integer CountryId) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(GeographicalLocation.class);
        criteria.add((Criterion)Restrictions.eq((String)"parentId", (Object)CountryId));
        criteria.add((Criterion)Restrictions.eq((String)"geographicalLocationType", (Object)1));
        ArrayList location = (ArrayList)criteria.list();
        return location;
    }

    public List<GeographicalLocation> getCityListByState(Long stateId) {
        Integer parentId = (int)stateId.longValue();
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(GeographicalLocation.class);
        criteria.add((Criterion)Restrictions.eq((String)"parentId", (Object)parentId));
        criteria.add((Criterion)Restrictions.eq((String)"geographicalLocationType", (Object)2));
        criteria.add((Criterion)Restrictions.eq((String)"isVisible", (Object)0));
        ArrayList location = (ArrayList)criteria.list();
        return location;
    }

    public List<GeographicalLocation> getAllCityListByState(Integer StateId) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(GeographicalLocation.class);
        criteria.add((Criterion)Restrictions.eq((String)"parentId", (Object)StateId));
        criteria.add((Criterion)Restrictions.eq((String)"geographicalLocationType", (Object)2));
        ArrayList location = (ArrayList)criteria.list();
        return location;
    }

    public GeographicalLocation getGeographicalLocationByName(String geographicalLocationName) {
        try {
            Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(GeographicalLocation.class);
            criteria.add((Criterion)Restrictions.eq((String)"name", (Object)geographicalLocationName));
            GeographicalLocation geographicalLocation = (GeographicalLocation)criteria.uniqueResult();
            return geographicalLocation;
        }
        catch (RuntimeException re) {
            System.out.println(re.getMessage());
            throw re;
        }
    }
}
