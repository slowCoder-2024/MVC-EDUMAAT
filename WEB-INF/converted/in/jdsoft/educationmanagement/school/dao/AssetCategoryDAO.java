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
import in.jdsoft.educationmanagement.school.model.AssetCategory;
import java.io.Serializable;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class AssetCategoryDAO
extends GenericDAO<AssetCategory> {
    public AssetCategoryDAO() {
        super(AssetCategory.class);
    }

    public AssetCategory getAssetCategoryById(Long id) {
        AssetCategory instance = (AssetCategory)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.AssetCategory", (Serializable)id);
        return instance;
    }

    public AssetCategory getAssetCategoryByAssetCategoryName(String AssetCategoryName) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(AssetCategory.class);
        criteria.add((Criterion)Restrictions.eq((String)"assetCategoryName", (Object)AssetCategoryName));
        AssetCategory AssetCategory2 = (AssetCategory)criteria.uniqueResult();
        return AssetCategory2;
    }
}
