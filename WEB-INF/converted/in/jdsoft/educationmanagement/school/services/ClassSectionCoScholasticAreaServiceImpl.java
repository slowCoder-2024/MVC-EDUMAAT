/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.ClassSectionCoScholasticAreaDAO;
import in.jdsoft.educationmanagement.school.model.ClassSectionCoScholasticArea;
import in.jdsoft.educationmanagement.school.services.ClassSectionCoScholasticAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="classSectionCoScholasticAreaService")
public class ClassSectionCoScholasticAreaServiceImpl
implements ClassSectionCoScholasticAreaService {
    @Autowired
    ClassSectionCoScholasticAreaDAO classSectionCoScholasticAreaDAO;

    @Override
    public ClassSectionCoScholasticArea classSectionCoScholasticAreaById(Long classSectionCoScholasticAreaId) {
        try {
            ClassSectionCoScholasticArea classSectionCoScholasticArea = this.classSectionCoScholasticAreaDAO.getClassSectionCoScholasticAreaById(classSectionCoScholasticAreaId);
            if (classSectionCoScholasticArea != null) {
                log.info((Object)("Class Section CoScholasticArea with id=" + classSectionCoScholasticAreaId + " has been reterived"));
                return classSectionCoScholasticArea;
            }
            log.info((Object)("No Class Section CoScholasticArea with  id=" + classSectionCoScholasticAreaId + " is available"));
            return classSectionCoScholasticArea;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving Class Section CoScholasticArea by id=" + classSectionCoScholasticAreaId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }
}
