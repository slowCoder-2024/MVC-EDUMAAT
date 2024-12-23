/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonBackReference
 *  com.fasterxml.jackson.annotation.JsonIgnoreProperties
 *  javax.persistence.Column
 *  javax.persistence.Entity
 *  javax.persistence.FetchType
 *  javax.persistence.GeneratedValue
 *  javax.persistence.GenerationType
 *  javax.persistence.Id
 *  javax.persistence.JoinColumn
 *  javax.persistence.ManyToOne
 *  javax.persistence.Table
 *  javax.persistence.UniqueConstraint
 *  org.apache.commons.lang.WordUtils
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import in.jdsoft.educationmanagement.school.model.EducationLevel;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.apache.commons.lang.WordUtils;

@Entity
@Table(name="tbl_education_level_subject", uniqueConstraints={@UniqueConstraint(columnNames={"education_level_id", "education_level_subject_title"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
public class EducationLevelSubject
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long educationLevelSubjectId;
    private EducationLevel educationLevel;
    private String educationLevelSubjectTitle;

    public EducationLevelSubject() {
    }

    public EducationLevelSubject(EducationLevel educationLevel, String educationLevelSubjectTitle) {
        this.educationLevel = educationLevel;
        this.educationLevelSubjectTitle = WordUtils.capitalize((String)educationLevelSubjectTitle);
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="education_level_subject_id", nullable=false)
    public Long getEducationLevelSubjectId() {
        return this.educationLevelSubjectId;
    }

    public void setEducationLevelSubjectId(Long educationLevelSubjectId) {
        this.educationLevelSubjectId = educationLevelSubjectId;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="education_level_id", nullable=false)
    @JsonBackReference
    public EducationLevel getEducationLevel() {
        return this.educationLevel;
    }

    public void setEducationLevel(EducationLevel educationLevel) {
        this.educationLevel = educationLevel;
    }

    @Column(name="education_level_subject_title", nullable=false, length=100)
    public String getEducationLevelSubjectTitle() {
        return this.educationLevelSubjectTitle;
    }

    public void setEducationLevelSubjectTitle(String educationLevelSubjectTitle) {
        this.educationLevelSubjectTitle = WordUtils.capitalize((String)educationLevelSubjectTitle);
    }
}
