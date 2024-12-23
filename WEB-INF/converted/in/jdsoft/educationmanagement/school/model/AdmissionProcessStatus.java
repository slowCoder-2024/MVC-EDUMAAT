/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonIgnoreProperties
 *  javax.persistence.Column
 *  javax.persistence.Entity
 *  javax.persistence.FetchType
 *  javax.persistence.GeneratedValue
 *  javax.persistence.GenerationType
 *  javax.persistence.Id
 *  javax.persistence.OneToMany
 *  javax.persistence.Table
 *  javax.persistence.UniqueConstraint
 *  org.apache.commons.lang.WordUtils
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import in.jdsoft.educationmanagement.school.model.AdmissionConfig;
import java.io.Serializable;
import java.util.HashSet;
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
import org.apache.commons.lang.WordUtils;

@Entity
@Table(name="tbl_admission_process_status", uniqueConstraints={@UniqueConstraint(columnNames={"admission_process_status_title"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
public class AdmissionProcessStatus
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long admissionProcessStatusId;
    private String admissionProcessStatusTitle;
    private Set<AdmissionConfig> admissionConfigs = new HashSet<AdmissionConfig>(0);

    public AdmissionProcessStatus() {
    }

    public AdmissionProcessStatus(String admissionProcessStatusTitle) {
        this.admissionProcessStatusTitle = WordUtils.capitalize((String)admissionProcessStatusTitle);
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="admission_process_status_id", unique=true, nullable=false)
    public Long getAdmissionProcessStatusId() {
        return this.admissionProcessStatusId;
    }

    public void setAdmissionProcessStatusId(Long admissionProcessStatusId) {
        this.admissionProcessStatusId = admissionProcessStatusId;
    }

    @Column(name="admission_process_status_title", unique=true, nullable=false, length=50)
    public String getAdmissionProcessStatusTitle() {
        return this.admissionProcessStatusTitle;
    }

    public void setAdmissionProcessStatusTitle(String admissionProcessStatusTitle) {
        this.admissionProcessStatusTitle = WordUtils.capitalize((String)admissionProcessStatusTitle);
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="admissionProcessStatus")
    public Set<AdmissionConfig> getAdmissionConfigs() {
        return this.admissionConfigs;
    }

    public void setAdmissionConfigs(Set<AdmissionConfig> admissionConfigs) {
        this.admissionConfigs = admissionConfigs;
    }
}
