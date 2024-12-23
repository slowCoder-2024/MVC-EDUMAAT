/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.StudentDAO;
import in.jdsoft.educationmanagement.school.dao.TaxClassDAO;
import in.jdsoft.educationmanagement.school.model.TaxClass;
import in.jdsoft.educationmanagement.school.services.TaxClassService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="taxClassService")
public class TaxClassServiceImpl
implements TaxClassService {
    @Autowired
    TaxClassDAO taxClassDAO;
    @Autowired
    StudentDAO studentDAO;

    @Override
    public List<TaxClass> taxClassList() {
        try {
            List<TaxClass> taxClass = this.taxClassDAO.getList();
            Integer taxClassSize = taxClass.size();
            if (taxClassSize > 0) {
                log.info((Object)(taxClassSize + " TaxClass records where reterived"));
            } else {
                log.info((Object)"No TaxClass available");
            }
            return taxClass;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving TaxClass list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public TaxClass taxClassById(Long taxClassId) {
        try {
            TaxClass taxClass = this.taxClassDAO.getTaxClassById(taxClassId);
            if (taxClassId != null) {
                log.info((Object)("TaxClass with id=" + taxClassId + " has been reterived"));
                return taxClass;
            }
            log.info((Object)("No TaxClass with  id=" + taxClassId + " is available"));
            return taxClass;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving TaxClass by id=" + taxClassId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void createTaxClass(TaxClass taxClass) {
        try {
            this.taxClassDAO.save(taxClass);
        }
        catch (Exception e) {
            log.error((Object)("Exception in creating TaxClass " + e.getCause()));
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateTaxClass(TaxClass taxClass) {
        try {
            this.taxClassDAO.saveOrUpdate(taxClass);
        }
        catch (Exception e) {
            log.error((Object)("Exception in updating TaxClass " + e.getCause()));
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteTaxClass(Long taxClassId) {
        try {
            this.taxClassDAO.delete(this.taxClassDAO.getTaxClassById(taxClassId));
        }
        catch (Exception e) {
            log.error((Object)("Exception in deleting TaxClass " + e.getCause()));
            e.printStackTrace();
            throw e;
        }
    }
}
