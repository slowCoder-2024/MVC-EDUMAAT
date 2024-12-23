/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.TermDAO;
import in.jdsoft.educationmanagement.school.dao.TimeTableTemplateDAO;
import in.jdsoft.educationmanagement.school.exceptions.ExamTemplateException;
import in.jdsoft.educationmanagement.school.model.Term;
import in.jdsoft.educationmanagement.school.services.TermService;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="TermService")
public class TermServiceImpl
implements TermService {
    @Autowired
    TermDAO termDAO;
    @Autowired
    TimeTableTemplateDAO timeTableTemplateDAO;

    @Override
    public List<Term> termList() {
        try {
            List<Term> termList = this.termDAO.getList();
            Integer termSize = termList.size();
            if (termSize > 0) {
                log.info((Object)(termSize + " Term records where reterived"));
            } else {
                log.info((Object)"No Term(s) available");
            }
            return termList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving Term list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Term termById(Long termId) {
        try {
            Term term = this.termDAO.getTermById(termId);
            if (term != null) {
                log.info((Object)("Term with id=" + termId + " has been reterived"));
                return term;
            }
            log.info((Object)("No Term with  id=" + termId + " is available"));
            return term;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving Term by id=" + termId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteTerm(Long termId) throws ExamTemplateException {
        try {
            this.termDAO.delete(this.termDAO.getTermById(termId));
            log.info((Object)"Term is deleted");
        }
        catch (Exception e) {
            log.error((Object)"Exception in Deleting Term", e.getCause());
            throw e;
        }
    }

    @Override
    public void deleteAllTerm(Set<Term> term) throws ExamTemplateException {
        try {
            for (Term term2 : term) {
                this.termDAO.delete(term2);
            }
            log.info((Object)"Term is deleted");
        }
        catch (Exception e) {
            log.error((Object)"Exception in Deleting Term", e.getCause());
            throw e;
        }
    }
}
