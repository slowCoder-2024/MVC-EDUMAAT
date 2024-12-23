/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.ClassSectionTermExamActivityDAO;
import in.jdsoft.educationmanagement.school.dao.ClassSectionTermExamDAO;
import in.jdsoft.educationmanagement.school.model.ClassSectionTermExam;
import in.jdsoft.educationmanagement.school.model.ClassSectionTermExamActivity;
import in.jdsoft.educationmanagement.school.services.ClassSectionTermExamActivityService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="classSectionTermExamActivityService")
public class ClassSectionTermExamActivityServiceImpl
implements ClassSectionTermExamActivityService {
    @Autowired
    private ClassSectionTermExamActivityDAO classSectionTermExamActivityDAO;
    @Autowired
    private ClassSectionTermExamDAO classSectionTermExamDAO;

    @Override
    public List<ClassSectionTermExamActivity> classSectionTermExamActivityByclassSectionTermExamIdId(Long classSectionTermExamId) {
        try {
            ClassSectionTermExam classSectionTermExam = this.classSectionTermExamDAO.getClassSectionTermExamById(classSectionTermExamId);
            List<ClassSectionTermExamActivity> classSectionTermExamActivitys = this.classSectionTermExamActivityDAO.getClassSectionTermExamActivityByClassSectionTermExam(classSectionTermExam);
            return classSectionTermExamActivitys;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public ClassSectionTermExamActivity classSectionTermExamActivityById(Long classSectionTermExamActivityById) {
        try {
            ClassSectionTermExamActivity classSectionTermExamActivity = this.classSectionTermExamActivityDAO.getClassSectionTermExamActivityById(classSectionTermExamActivityById);
            if (classSectionTermExamActivity != null) {
                log.info((Object)("ClassSectionTermExamActivity with id=" + classSectionTermExamActivityById + " has been reterived"));
                return classSectionTermExamActivity;
            }
            log.info((Object)("No ClassSectionTermExamActivity with  id=" + classSectionTermExamActivityById + " is available"));
            return classSectionTermExamActivity;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
