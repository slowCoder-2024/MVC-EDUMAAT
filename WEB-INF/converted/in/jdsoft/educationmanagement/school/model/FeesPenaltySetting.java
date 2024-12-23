/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import in.jdsoft.educationmanagement.school.model.Institution;
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
@Table(name="tbl_fees_penalty_setting", uniqueConstraints={@UniqueConstraint(columnNames={"fees_penalty_setting_type", "institution_id"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class FeesPenaltySetting
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long feesPenaltySettingId;
    private Long dueDays;
    private String penaltyCategory;
    private String penaltyType;
    private Double percentage;
    private Double amount;
    private String feesPenaltySettingType;
    private Institution institution;

    public FeesPenaltySetting(Long dueDays, String penaltyCategory, String penaltyType, Double percentage, Double amount, String feesPenaltySettingType, Institution institution) {
        this.dueDays = dueDays;
        this.penaltyCategory = penaltyCategory;
        this.penaltyType = penaltyType;
        this.percentage = percentage;
        this.amount = amount;
        this.feesPenaltySettingType = feesPenaltySettingType;
        this.institution = institution;
    }

    FeesPenaltySetting() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="fees_penalty_setting_id", unique=true, nullable=false)
    public Long getFeesPenaltySettingId() {
        return this.feesPenaltySettingId;
    }

    public void setFeesPenaltySettingId(Long feesPenaltySettingId) {
        this.feesPenaltySettingId = feesPenaltySettingId;
    }

    @Column(name="due_days", nullable=false, length=100)
    public Long getDueDays() {
        return this.dueDays;
    }

    public void setDueDays(Long dueDays) {
        this.dueDays = dueDays;
    }

    @Column(name="penalty_category", nullable=false, length=100)
    public String getPenaltyCategory() {
        return this.penaltyCategory;
    }

    public void setPenaltyCategory(String penaltyCategory) {
        this.penaltyCategory = penaltyCategory;
    }

    @Column(name="penalty_type", nullable=false, length=100)
    public String getPenaltyType() {
        return this.penaltyType;
    }

    public void setPenaltyType(String penaltyType) {
        this.penaltyType = penaltyType;
    }

    @Column(name="penalty_percentage", nullable=true, length=100)
    public Double getPercentage() {
        return this.percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    @Column(name="penalty_amount", nullable=true, length=100)
    public Double getAmount() {
        return this.amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="institution_id", nullable=false)
    @ForeignKey(name="feesPenaltySettingInInstitution")
    public Institution getInstitution() {
        return this.institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    @Column(name="fees_penalty_setting_type", nullable=false, length=100)
    public String getFeesPenaltySettingType() {
        return this.feesPenaltySettingType;
    }

    public void setFeesPenaltySettingType(String feesPenaltySettingType) {
        this.feesPenaltySettingType = feesPenaltySettingType;
    }
}
