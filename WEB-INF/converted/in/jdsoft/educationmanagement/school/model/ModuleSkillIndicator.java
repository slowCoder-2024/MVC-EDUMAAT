/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonBackReference
 *  com.fasterxml.jackson.annotation.JsonIgnoreProperties
 *  com.fasterxml.jackson.annotation.JsonInclude
 *  com.fasterxml.jackson.annotation.JsonInclude$Include
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
 *  org.hibernate.annotations.ForeignKey
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import in.jdsoft.educationmanagement.school.model.ModuleSkill;
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
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tbl_module_skill_indicator", uniqueConstraints={@UniqueConstraint(columnNames={"module_skill_id", "module_skill_indicator_name"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class ModuleSkillIndicator
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long moduleSkillIndicatorId;
    private String moduleSkillIndicatorName;
    private ModuleSkill moduleSkill;

    ModuleSkillIndicator() {
    }

    public ModuleSkillIndicator(String moduleSkillIndicatorName, ModuleSkill moduleSkill) {
        this.moduleSkillIndicatorName = moduleSkillIndicatorName;
        this.moduleSkill = moduleSkill;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="module_skill_indicator_id", nullable=false)
    public Long getModuleSkillIndicatorId() {
        return this.moduleSkillIndicatorId;
    }

    public void setModuleSkillIndicatorId(Long moduleSkillIndicatorId) {
        this.moduleSkillIndicatorId = moduleSkillIndicatorId;
    }

    @Column(name="module_skill_indicator_name", nullable=false, length=100)
    public String getModuleSkillIndicatorName() {
        return this.moduleSkillIndicatorName;
    }

    public void setModuleSkillIndicatorName(String moduleSkillIndicatorName) {
        this.moduleSkillIndicatorName = moduleSkillIndicatorName;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="module_skill_id", nullable=true)
    @ForeignKey(name="moduleSkillIndicatorInModuleSkill")
    @JsonBackReference
    public ModuleSkill getModuleSkill() {
        return this.moduleSkill;
    }

    public void setModuleSkill(ModuleSkill moduleSkill) {
        this.moduleSkill = moduleSkill;
    }
}
