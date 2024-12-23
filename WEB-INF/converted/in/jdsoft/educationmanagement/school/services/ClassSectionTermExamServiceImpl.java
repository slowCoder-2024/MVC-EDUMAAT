/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.ClassSectionTermExamDAO;
import in.jdsoft.educationmanagement.school.model.ClassSectionTermExam;
import in.jdsoft.educationmanagement.school.services.ClassSectionTermExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="classSectionTermExamService")
public class ClassSectionTermExamServiceImpl
implements ClassSectionTermExamService {
    @Autowired
    private ClassSectionTermExamDAO classSectionTermExamDAO;

    @Override
    public ClassSectionTermExam classSectionTermExamById(Long classSectionTermExamId) {
        try {
            ClassSectionTermExam classSectionTermExam = this.classSectionTermExamDAO.getClassSectionTermExamById(classSectionTermExamId);
            if (classSectionTermExam != null) {
                log.info((Object)("ClassSectionTermExam with id=" + classSectionTermExamId + " has been reterived"));
                return classSectionTermExam;
            }
            log.info((Object)("No ClassSectionTermExam with  id=" + classSectionTermExamId + " is available"));
            return classSectionTermExam;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving class by id=" + classSectionTermExamId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }
}
