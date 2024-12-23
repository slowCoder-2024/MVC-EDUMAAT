/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.hibernate.Hibernate
 *  org.hibernate.exception.ConstraintViolationException
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.components.ExceptionComparator;
import in.jdsoft.educationmanagement.school.dao.ExamTemplateDAO;
import in.jdsoft.educationmanagement.school.dao.InstitutionDAO;
import in.jdsoft.educationmanagement.school.dao.TermDAO;
import in.jdsoft.educationmanagement.school.dao.TermExamDAO;
import in.jdsoft.educationmanagement.school.exceptions.ExamTemplateException;
import in.jdsoft.educationmanagement.school.model.ExamTemplate;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.Term;
import in.jdsoft.educationmanagement.school.model.TermExam;
import in.jdsoft.educationmanagement.school.services.ExamTemplateService;
import java.util.List;
import java.util.Set;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value="examTemplateService")
public class ExamTemplateServiceImpl
implements ExamTemplateService {
    @Autowired
    ExamTemplateDAO examTemplateDAO;
    @Autowired
    TermDAO termDAO;
    @Autowired
    TermExamDAO termExamDAO;
    @Autowired
    private InstitutionDAO institutionDAO;
    @Autowired
    ExceptionComparator exceptionComparator;
    private Logger log = LogManager.getLogger((String)ExamTemplateServiceImpl.class.getName());

    @Override
    @Transactional(rollbackFor={ExamTemplateException.class})
    public void createExamTemplate(ExamTemplate examTemplate, Set<Term> terms, Set<TermExam> termExams) throws ExamTemplateException {
        try {
            this.examTemplateDAO.persist(examTemplate);
            for (Term term : terms) {
                this.termDAO.persist(term);
            }
            for (TermExam termExam : termExams) {
                this.termExamDAO.persist(termExam);
            }
            this.log.info((Object)"ExamTemplate,Term,TermExam is created");
        }
        catch (Exception e) {
            if (e.getClass().equals(ConstraintViolationException.class)) {
                String valid = this.exceptionComparator.containsWord(e.getMessage());
                if (valid != null) {
                    throw new ExamTemplateException(new Message("duplicate", "Cannot Create Duplicate " + valid));
                }
                throw e;
            }
            throw e;
        }
    }

    @Override
    public void updateExamTemplate(ExamTemplate examTemplate, Set<Term> terms, Set<TermExam> termExams) throws ExamTemplateException {
        try {
            this.examTemplateDAO.update(examTemplate);
            for (Term term : terms) {
                System.out.println(term.getTermName());
                this.termDAO.persist(term);
            }
            for (TermExam termExam : termExams) {
                System.out.println(termExam.getTermExamName());
                this.termExamDAO.persist(termExam);
            }
            this.log.info((Object)"ExamTemplate,Term,TermExam is updated");
        }
        catch (Exception e) {
            this.log.error((Object)"Exception in Updating ExamTemplate,Term,TermExam", e.getCause());
            throw e;
        }
    }

    @Override
    public void deleteExamTemplate(Long examTemplateId) throws ExamTemplateException {
        try {
            this.examTemplateDAO.delete(this.examTemplateDAO.getExamTemplateById(examTemplateId));
            this.log.info((Object)"ExamTemplate,Term,TermExam is deleted");
        }
        catch (Exception e) {
            this.log.error((Object)"Exception in Deleting ExamTemplate,Term,TermExam", e.getCause());
            throw e;
        }
    }

    @Override
    public ExamTemplate examTemplateById(Long examTemplateId) {
        try {
            ExamTemplate examTemplate = this.examTemplateDAO.getExamTemplateById(examTemplateId);
            if (examTemplate != null) {
                this.log.info((Object)("ExamTemplate with id=" + examTemplateId + " has been reterived"));
                return examTemplate;
            }
            this.log.info((Object)("No ExamTemplate with  id=" + examTemplateId + " is available"));
            return examTemplate;
        }
        catch (Exception e) {
            this.log.error((Object)("Exception in retrieving ExamTemplate by id=" + examTemplateId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<ExamTemplate> examTemplateListEager(Long institutionId) throws ExamTemplateException {
        try {
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            if (institution != null) {
                List<ExamTemplate> examTemplates = this.examTemplateDAO.getExamTemplatesByInstitution(institution);
                for (ExamTemplate examTemplate : examTemplates) {
                    Hibernate.initialize(examTemplate.getTerms());
                    for (Term term : examTemplate.getTerms()) {
                        Hibernate.initialize(term.getTermExams());
                    }
                }
                Integer examTemplateRecordSize = examTemplates.size();
                if (examTemplateRecordSize > 0) {
                    this.log.info((Object)(examTemplateRecordSize + " ExamTemplate records of institution " + institution.getInstitutionAliasName() + " where retrieved"));
                } else {
                    this.log.info((Object)("No ExamTemplate Records found for institution " + institution.getInstitutionAliasName()));
                }
                return examTemplates;
            }
            throw new NullPointerException("Invalid Institution Id");
        }
        catch (Exception e) {
            if (e.getClass().equals(NullPointerException.class)) {
                this.log.error((Object)"NullPointerException", e.getCause());
                throw new ExamTemplateException(new Message("nullpointer", e.getMessage()));
            }
            this.log.error((Object)"Exception in retrieving ExamTemplates of Institution", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public ExamTemplate examTemplateIdByEager(Long examTemplateId) {
        try {
            ExamTemplate examTemplate = this.examTemplateDAO.getExamTemplateById(examTemplateId);
            if (examTemplate != null) {
                Hibernate.initialize(examTemplate.getTerms());
                for (Term term : examTemplate.getTerms()) {
                    Hibernate.initialize(term.getTermExams());
                    for (TermExam termExam : term.getTermExams()) {
                        Hibernate.initialize((Object)termExam);
                    }
                }
                Hibernate.initialize((Object)examTemplate.getInstitution());
                this.log.info((Object)("ExamTemplate with id=" + examTemplateId + " has been retrieved"));
                return examTemplate;
            }
            this.log.info((Object)("No ExamTemplate with  id=" + examTemplateId + " is available"));
            return examTemplate;
        }
        catch (Exception e) {
            this.log.error((Object)("Exception in retrieving ExamTemplate by id=" + examTemplateId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<ExamTemplate> examTemplateList() {
        try {
            List<ExamTemplate> examTemplateList = this.examTemplateDAO.getList();
            Integer examTemplateListSize = examTemplateList.size();
            if (examTemplateListSize > 0) {
                this.log.info((Object)(examTemplateListSize + " ExamTemplate records where retrieved"));
            } else {
                this.log.info((Object)"No ExamTemplate list available");
            }
            return examTemplateList;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception in retrieving ExamTemplate list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<ExamTemplate> examTemplateList(Long institutionId) throws ExamTemplateException {
        try {
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            if (institution != null) {
                List<ExamTemplate> examTemplates = this.examTemplateDAO.getExamTemplatesByInstitution(institution);
                Integer examTemplateRecordSize = examTemplates.size();
                if (examTemplateRecordSize > 0) {
                    this.log.info((Object)(examTemplateRecordSize + " ExamTemplate records of institution " + institution.getInstitutionAliasName() + " where retrieved"));
                } else {
                    this.log.info((Object)("No ExamTemplate Records found for institution " + institution.getInstitutionAliasName()));
                }
                return examTemplates;
            }
            throw new NullPointerException("Invalid Institution Id");
        }
        catch (Exception e) {
            if (e.getClass().equals(NullPointerException.class)) {
                this.log.error((Object)"NullPointerException", e.getCause());
                throw new ExamTemplateException(new Message("nullpointer", e.getMessage()));
            }
            this.log.error((Object)"Exception in retrieving ExamTemplates of Institution", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }
}
