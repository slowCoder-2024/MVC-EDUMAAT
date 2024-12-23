/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.exceptions.ExamTemplateException;
import in.jdsoft.educationmanagement.school.model.Term;
import java.util.List;
import java.util.Set;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface TermService {
    public static final Logger log = LogManager.getLogger((String)TermService.class.getName());

    public List<Term> termList();

    public Term termById(Long var1);

    public void deleteTerm(Long var1) throws ExamTemplateException;

    public void deleteAllTerm(Set<Term> var1) throws ExamTemplateException;
}
