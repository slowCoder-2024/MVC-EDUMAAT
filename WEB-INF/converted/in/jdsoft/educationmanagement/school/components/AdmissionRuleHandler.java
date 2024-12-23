/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.Hibernate
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Component
 */
package in.jdsoft.educationmanagement.school.components;

import in.jdsoft.educationmanagement.school.model.Admission;
import in.jdsoft.educationmanagement.school.model.AdmissionConfig;
import in.jdsoft.educationmanagement.school.model.AdmissionEducationLevelSubjects;
import in.jdsoft.educationmanagement.school.model.Class;
import in.jdsoft.educationmanagement.school.services.AdmissionService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdmissionRuleHandler {
    @Autowired
    private AdmissionService admissionServices;
    private int courseId;
    private int courseCategoryId;
    private int ruleId;
    private int maxSelect = 1;

    public ArrayList<Admission> executeRule1(Class classz, AdmissionConfig admissionConfig, int ruleId, Long maxSelect) throws Exception {
        this.ruleId = ruleId;
        this.maxSelect = (int)maxSelect.longValue();
        ArrayList<Admission> selectedApplicants = null;
        switch (ruleId) {
            case 1: {
                ArrayList<Admission> admissions = this.admissionServices.getApplicantsDetailsByClassAndAdmissionConfig(classz, admissionConfig);
                for (Admission admission : admissions) {
                    Hibernate.initialize((Object)admission.getClassz());
                    Hibernate.initialize((Object)admission.getAdmissionStatus());
                    Hibernate.initialize((Object)admission.getReligion());
                    Hibernate.initialize((Object)admission.getSponser());
                    Hibernate.initialize((Object)admission.getCategory());
                    Hibernate.initialize((Object)admission.getSpecialCategory());
                    Hibernate.initialize((Object)admission.getHearedUs());
                    Hibernate.initialize((Object)admission.getUser());
                    Hibernate.initialize(admission.getAdmissionAcademicsDetails());
                    Hibernate.initialize(admission.getAdmissionDocuments());
                    Hibernate.initialize(admission.getAdmissionEducationLevelSubjects());
                    Hibernate.initialize((Object)admission.getAdmissionFeesPaymentDetails());
                    Hibernate.initialize((Object)admission.getAdmissionConfig());
                    Hibernate.initialize((Object)admission.getStudent());
                    Hibernate.initialize((Object)admission.getEducationLevel());
                    admission.setTotal(this.total(admission));
                    this.admissionServices.updateAdmission(admission);
                }
                selectedApplicants = this.sortApplicantsForSeats1(this.admissionServices.getApplicantsDetailsByClassAndAdmissionConfig(classz, admissionConfig), this.maxSelect);
                Double i = selectedApplicants.size();
                for (Admission admission : selectedApplicants) {
                    admission.setAdmissionRank(i);
                    this.admissionServices.updateAdmission(admission);
                    i = i - 1.0;
                }
                selectedApplicants = this.sortApplicantsForRank1(this.admissionServices.getApplicantsDetailsByClassAndAdmissionConfig(classz, admissionConfig), this.maxSelect);
                break;
            }
            case 2: {
                ArrayList<Admission> admissions1 = this.admissionServices.getApplicantsDetailsByClassAndAdmissionConfig(classz, admissionConfig);
                for (Admission admission1 : admissions1) {
                    admission1.setTotal(AdmissionRuleHandler.getRandomNumberInDecimal());
                    this.admissionServices.updateAdmission(admission1);
                }
                selectedApplicants = this.sortApplicantsForSeats1(this.admissionServices.getApplicantsDetailsByClassAndAdmissionConfig(classz, admissionConfig), this.maxSelect);
                Double j = 1.0;
                for (Admission admission : selectedApplicants) {
                    admission.setAdmissionRank(j);
                    this.admissionServices.updateAdmission(admission);
                    j = j + 1.0;
                }
                selectedApplicants = this.sortApplicantsForRank1(this.admissionServices.getApplicantsDetailsByClassAndAdmissionConfig(classz, admissionConfig), this.maxSelect);
            }
        }
        return selectedApplicants;
    }

    public int getCourseId() {
        return this.courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getCourseCategoryId() {
        return this.courseCategoryId;
    }

    public void setCourseCategoryId(int courseCategoryId) {
        this.courseCategoryId = courseCategoryId;
    }

    public int getRuleId() {
        return this.ruleId;
    }

    public void setRuleId(int ruleId) {
        this.ruleId = ruleId;
    }

    public int getMaxSelect() {
        return this.maxSelect;
    }

    public void setMaxSelect(int maxSelect) {
        this.maxSelect = maxSelect;
    }

    private static double getRandomNumberInDecimal() {
        Random r = new Random();
        return r.nextDouble();
    }

    private double total(Admission admission) throws Exception {
        double total = 0.0;
        double category = 0.0;
        double disability = 0.0;
        double subtotal = 0.0;
        Admission currentadmission = this.admissionServices.getAdmissionDetailsLazyById(admission.getAdmissionId());
        if (currentadmission.getCategory().getCategoryId() == 1L) {
            category = 1.7;
        } else if (currentadmission.getCategory().getCategoryId() == 2L) {
            category = 1.6;
        } else if (currentadmission.getCategory().getCategoryId() == 3L) {
            category = 1.5;
        } else if (currentadmission.getCategory().getCategoryId() == 4L) {
            category = 1.4;
        } else if (currentadmission.getCategory().getCategoryId() == 5L) {
            category = 1.3;
        } else if (currentadmission.getCategory().getCategoryId() == 6L) {
            category = 1.2;
        } else if (currentadmission.getCategory().getCategoryId() == 7L) {
            category = 1.1;
        }
        disability = currentadmission.getDisability().equals("Yes") ? 0.3 : 0.1;
        if (currentadmission.getEducationLevel().getEducationLevelId() != 1L && currentadmission.getEducationLevel().getEducationLevelId() != 2L) {
            int count = currentadmission.getAdmissionEducationLevelSubjects().size();
            for (AdmissionEducationLevelSubjects admissionEducationLevelSubjects : currentadmission.getAdmissionEducationLevelSubjects()) {
                subtotal += admissionEducationLevelSubjects.getSubjectMarks();
            }
            subtotal /= (double)count;
        } else {
            subtotal = 0.1;
        }
        total = subtotal * disability * category;
        return total;
    }

    private ArrayList<Admission> sortApplicantsForSeats1(ArrayList<Admission> admissions, int maxSelect) {
        ArrayList<Admission> sortedAdmission = new ArrayList<Admission>();
        Collections.sort(admissions, new Comparator<Admission>(){

            @Override
            public int compare(Admission o1, Admission o2) {
                return o1.getTotal().compareTo(o2.getTotal());
            }
        });
        int i = 0;
        for (Admission admission : admissions) {
            if (i >= maxSelect) continue;
            sortedAdmission.add(admission);
            ++i;
        }
        return sortedAdmission;
    }

    private ArrayList<Admission> sortApplicantsForRank1(ArrayList<Admission> admissions, int maxSelect) {
        ArrayList<Admission> sortedAdmission = new ArrayList<Admission>();
        Collections.sort(admissions, new Comparator<Admission>(){

            @Override
            public int compare(Admission o1, Admission o2) {
                return o1.getAdmissionRank().compareTo(o2.getAdmissionRank());
            }
        });
        int i = 0;
        for (Admission admission : admissions) {
            if (i >= maxSelect) continue;
            sortedAdmission.add(admission);
            ++i;
        }
        return sortedAdmission;
    }
}
