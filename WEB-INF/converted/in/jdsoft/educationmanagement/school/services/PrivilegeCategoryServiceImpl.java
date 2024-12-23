/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.InstitutionConfigDetailsDAO;
import in.jdsoft.educationmanagement.school.dao.PrivilegeCategoryDAO;
import in.jdsoft.educationmanagement.school.dao.PrivilegeDAO;
import in.jdsoft.educationmanagement.school.dao.UserDAO;
import in.jdsoft.educationmanagement.school.model.PrivilegeCategory;
import in.jdsoft.educationmanagement.school.services.PrivilegeCategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="privilegeCategoryService")
public class PrivilegeCategoryServiceImpl
implements PrivilegeCategoryService {
    @Autowired
    PrivilegeCategoryDAO privilegeCategoryDAO;
    @Autowired
    UserDAO userDAO;
    @Autowired
    InstitutionConfigDetailsDAO institutionConfigDetailsDAO;
    @Autowired
    PrivilegeDAO privilegeDAO;

    @Override
    public List<PrivilegeCategory> privilegeCategoryList() {
        try {
            List<PrivilegeCategory> privilegeCategoryList = this.privilegeCategoryDAO.getList();
            Integer privilegeCategorySize = privilegeCategoryList.size();
            if (privilegeCategorySize > 0) {
                log.info((Object)(privilegeCategorySize + " privilegeCategory records where reterived"));
            } else {
                log.info((Object)"No privilegeCategory(s) available");
            }
            return privilegeCategoryList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving privilegeCategory list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public PrivilegeCategory privilegeCategoryById(Long privilegeCategoryId) {
        try {
            PrivilegeCategory privilegeCategory = this.privilegeCategoryDAO.getPrivilegeCategoryById(privilegeCategoryId);
            if (privilegeCategory != null) {
                log.info((Object)("privilegeCategory with id=" + privilegeCategoryId + " has been reterived"));
                return privilegeCategory;
            }
            log.info((Object)("No privilegeCategory with  id=" + privilegeCategoryId + " is available"));
            return privilegeCategory;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving privilegeCategory by id=" + privilegeCategoryId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }
}
