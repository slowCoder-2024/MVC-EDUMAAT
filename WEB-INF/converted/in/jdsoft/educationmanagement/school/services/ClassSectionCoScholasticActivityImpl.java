/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.ClassSectionCoScholasticActivityDAO;
import in.jdsoft.educationmanagement.school.model.ClassSectionCoScholasticActivity;
import in.jdsoft.educationmanagement.school.services.ClassSectionCoScholasticActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="classSectionCoScholasticActivityService")
public class ClassSectionCoScholasticActivityImpl
implements ClassSectionCoScholasticActivityService {
    @Autowired
    ClassSectionCoScholasticActivityDAO classSectionCoScholasticActivityDAO;

    @Override
    public ClassSectionCoScholasticActivity classSectionCoScholasticActivityById(Long classSectionCoScholasticActivityId) {
        try {
            ClassSectionCoScholasticActivity classSectionCoScholasticActivity = this.classSectionCoScholasticActivityDAO.getClassSectionCoScholasticActivityById(classSectionCoScholasticActivityId);
            if (classSectionCoScholasticActivity != null) {
                log.info((Object)("Class Section CoScholasticActivity with id=" + classSectionCoScholasticActivityId + " has been reterived"));
                return classSectionCoScholasticActivity;
            }
            log.info((Object)("No Class Section CoScholasticActivity with  id=" + classSectionCoScholasticActivityId + " is available"));
            return classSectionCoScholasticActivity;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving Class Section CoScholasticActivity by id=" + classSectionCoScholasticActivityId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }
}
