/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonIgnoreProperties
 *  com.fasterxml.jackson.annotation.JsonInclude
 *  com.fasterxml.jackson.annotation.JsonInclude$Include
 *  javax.persistence.Column
 *  javax.persistence.Entity
 *  javax.persistence.GeneratedValue
 *  javax.persistence.GenerationType
 *  javax.persistence.Id
 *  javax.persistence.Table
 *  javax.persistence.UniqueConstraint
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="tbl_assesment_type", uniqueConstraints={@UniqueConstraint(columnNames={"assesment_type_name"}), @UniqueConstraint(columnNames={"assesment_type_code"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class AssesmentType
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long assesmentTypeId;
    private String assesmentTypeName;
    private boolean assesmentTypeEnable;
    private String assesmentTypeCode;

    AssesmentType() {
    }

    public AssesmentType(String assesmentTypeName, boolean assesmentTypeEnable, String assesmentTypeCode) {
        this.assesmentTypeName = assesmentTypeName;
        this.assesmentTypeEnable = assesmentTypeEnable;
        this.assesmentTypeCode = assesmentTypeCode;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="assesment_type_id", nullable=false)
    public Long getAssesmentTypeId() {
        return this.assesmentTypeId;
    }

    public void setAssesmentTypeId(Long assesmentTypeId) {
        this.assesmentTypeId = assesmentTypeId;
    }

    @Column(name="assesment_type_name", nullable=false, length=100)
    public String getAssesmentTypeName() {
        return this.assesmentTypeName;
    }

    public void setAssesmentTypeName(String assesmentTypeName) {
        this.assesmentTypeName = assesmentTypeName;
    }

    @Column(name="assesment_type_enable", nullable=false)
    public boolean isAssesmentTypeEnable() {
        return this.assesmentTypeEnable;
    }

    public void setAssesmentTypeEnable(boolean assesmentTypeEnable) {
        this.assesmentTypeEnable = assesmentTypeEnable;
    }

    @Column(name="assesment_type_code", nullable=false, length=100)
    public String getAssesmentTypeCode() {
        return this.assesmentTypeCode;
    }

    public void setAssesmentTypeCode(String assesmentTypeCode) {
        this.assesmentTypeCode = assesmentTypeCode;
    }
}
