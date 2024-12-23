/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonIgnoreProperties
 *  com.fasterxml.jackson.annotation.JsonInclude
 *  com.fasterxml.jackson.annotation.JsonInclude$Include
 *  com.fasterxml.jackson.annotation.JsonManagedReference
 *  javax.persistence.Column
 *  javax.persistence.Entity
 *  javax.persistence.FetchType
 *  javax.persistence.GeneratedValue
 *  javax.persistence.GenerationType
 *  javax.persistence.Id
 *  javax.persistence.OneToMany
 *  javax.persistence.Table
 *  javax.persistence.UniqueConstraint
 *  org.hibernate.annotations.ForeignKey
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import in.jdsoft.educationmanagement.school.model.ClassSectionModuleSkill;
import in.jdsoft.educationmanagement.school.model.ModuleSkillIndicator;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tbl_module_skill", uniqueConstraints={@UniqueConstraint(columnNames={"module_skill_name"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class ModuleSkill
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long moduleSkillId;
    private String moduleSkillName;
    private Set<ModuleSkillIndicator> moduleSkillIndicators = new LinkedHashSet<ModuleSkillIndicator>();
    private Set<ClassSectionModuleSkill> classSectionModuleSkills = new LinkedHashSet<ClassSectionModuleSkill>();

    ModuleSkill() {
    }

    public ModuleSkill(String moduleSkillName) {
        this.moduleSkillName = moduleSkillName;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="module_skill_id", nullable=false)
    public Long getModuleSkillId() {
        return this.moduleSkillId;
    }

    public void setModuleSkillId(Long moduleSkillId) {
        this.moduleSkillId = moduleSkillId;
    }

    @Column(name="module_skill_name", nullable=false, length=100)
    public String getModuleSkillName() {
        return this.moduleSkillName;
    }

    public void setModuleSkillName(String moduleSkillName) {
        this.moduleSkillName = moduleSkillName;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="moduleSkill")
    @ForeignKey(name="classSectionModuleSkillInModuleSkill")
    public Set<ClassSectionModuleSkill> getClassSectionModuleSkills() {
        return this.classSectionModuleSkills;
    }

    public void setClassSectionModuleSkills(Set<ClassSectionModuleSkill> classSectionModuleSkills) {
        this.classSectionModuleSkills = classSectionModuleSkills;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="moduleSkill")
    @ForeignKey(name="moduleSkillIndicatorInModuleSkill")
    @JsonManagedReference
    public Set<ModuleSkillIndicator> getModuleSkillIndicators() {
        return this.moduleSkillIndicators;
    }

    public void setModuleSkillIndicators(Set<ModuleSkillIndicator> moduleSkillIndicators) {
        this.moduleSkillIndicators = moduleSkillIndicators;
    }
}
