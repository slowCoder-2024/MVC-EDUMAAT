/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.LicenseDAO;
import in.jdsoft.educationmanagement.school.model.License;
import in.jdsoft.educationmanagement.school.services.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="licenseService")
public class LicenseServiceImpl
implements LicenseService {
    @Autowired
    LicenseDAO licenseDAO;

    @Override
    public License license(String status) {
        try {
            License license = this.licenseDAO.getLicenseByStatus(status);
            return license;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
