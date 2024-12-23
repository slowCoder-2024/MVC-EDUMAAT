/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.TermExamDAO;
import in.jdsoft.educationmanagement.school.dao.TimeTableTemplateDAO;
import in.jdsoft.educationmanagement.school.exceptions.ExamTemplateException;
import in.jdsoft.educationmanagement.school.model.TermExam;
import in.jdsoft.educationmanagement.school.services.TermExamService;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="TermExamService")
public class TermExamServiceImpl
implements TermExamService {
    @Autowired
    TermExamDAO termExamDAO;
    @Autowired
    TimeTableTemplateDAO timeTableTemplateDAO;

    @Override
    public List<TermExam> termExamList() {
        try {
            List<TermExam> TermExamList = this.termExamDAO.getList();
            Integer TermExamSize = TermExamList.size();
            if (TermExamSize > 0) {
                log.info((Object)(TermExamSize + " TermExam records where reterived"));
            } else {
                log.info((Object)"No TermExam(s) available");
            }
            return TermExamList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving TermExam list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public TermExam termExamById(Long termExamId) {
        try {
            TermExam TermExam2 = this.termExamDAO.getTermExamById(termExamId);
            if (TermExam2 != null) {
                log.info((Object)("TermExam with id=" + termExamId + " has been reterived"));
                return TermExam2;
            }
            log.info((Object)("No TermExam with  id=" + termExamId + " is available"));
            return TermExam2;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving TermExam by id=" + termExamId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteTermExam(Long termExamId) throws ExamTemplateException {
        try {
            this.termExamDAO.delete(this.termExamDAO.getTermExamById(termExamId));
            log.info((Object)"TermExam is deleted");
        }
        catch (Exception e) {
            log.error((Object)"Exception in Deleting TermExam", e.getCause());
            throw e;
        }
    }

    @Override
    public void deleteAllTermExam(Set<TermExam> termExam) throws ExamTemplateException {
        try {
            for (TermExam termExam2 : termExam) {
                this.termExamDAO.delete(termExam2);
            }
            log.info((Object)"TermExam is deleted");
        }
        catch (Exception e) {
            log.error((Object)"Exception in Deleting TermExam", e.getCause());
            throw e;
        }
    }
}
