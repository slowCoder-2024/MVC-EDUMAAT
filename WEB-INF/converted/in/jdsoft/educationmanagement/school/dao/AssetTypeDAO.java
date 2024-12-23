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
import in.jdsoft.educationmanagement.school.model.AssetType;
import java.io.Serializable;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class AssetTypeDAO
extends GenericDAO<AssetType> {
    public AssetTypeDAO() {
        super(AssetType.class);
    }

    public AssetType getAssetTypeById(Long id) {
        AssetType instance = (AssetType)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.AssetType", (Serializable)id);
        return instance;
    }

    public AssetType getAssetTypeByAssetTypeName(String AssetTypeName) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(AssetType.class);
        criteria.add((Criterion)Restrictions.eq((String)"assetType", (Object)AssetTypeName));
        AssetType AssetType2 = (AssetType)criteria.uniqueResult();
        return AssetType2;
    }
}
