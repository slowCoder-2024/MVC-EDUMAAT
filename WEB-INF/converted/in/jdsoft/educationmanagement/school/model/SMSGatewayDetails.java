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
 *  javax.persistence.OneToOne
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tbl_sms_gateway_details", uniqueConstraints={@UniqueConstraint(columnNames={"sms_gateway_user_name", "sms_gateway_sender_id", "institution_id"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class SMSGatewayDetails
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long smsGatewayDetailId;
    private String smsGatewayUserName;
    private String smsGatewayPassword;
    private String smsGatewaySenderId;
    private Institution institution;

    public SMSGatewayDetails(String smsGatewayUserName, String smsGatewayPassword, String smsGatewaySenderId, Institution institution) {
        this.smsGatewayUserName = smsGatewayUserName;
        this.smsGatewayPassword = smsGatewayPassword;
        this.smsGatewaySenderId = smsGatewaySenderId;
        this.institution = institution;
    }

    SMSGatewayDetails() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="sms_gateway_detail_id", nullable=false)
    public Long getSmsGatewayDetailId() {
        return this.smsGatewayDetailId;
    }

    public void setSmsGatewayDetailId(Long smsGatewayDetailId) {
        this.smsGatewayDetailId = smsGatewayDetailId;
    }

    @Column(name="sms_gateway_user_name", nullable=false, length=100)
    public String getSmsGatewayUserName() {
        return this.smsGatewayUserName;
    }

    public void setSmsGatewayUserName(String smsGatewayUserName) {
        this.smsGatewayUserName = smsGatewayUserName;
    }

    @Column(name="sms_gateway_password", nullable=false, length=100)
    public String getSmsGatewayPassword() {
        return this.smsGatewayPassword;
    }

    public void setSmsGatewayPassword(String smsGatewayPassword) {
        this.smsGatewayPassword = smsGatewayPassword;
    }

    @Column(name="sms_gateway_sender_id", nullable=false, length=50)
    public String getSmsGatewaySenderId() {
        return this.smsGatewaySenderId;
    }

    public void setSmsGatewaySenderId(String smsGatewaySenderId) {
        this.smsGatewaySenderId = smsGatewaySenderId;
    }

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="institution_id", nullable=false)
    @ForeignKey(name="institutionInSMSGatewayDetails")
    public Institution getInstitution() {
        return this.institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }
}
