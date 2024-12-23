/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonIdentityInfo
 *  com.fasterxml.jackson.annotation.JsonIdentityReference
 *  com.fasterxml.jackson.annotation.JsonIgnoreProperties
 *  com.fasterxml.jackson.annotation.JsonInclude
 *  com.fasterxml.jackson.annotation.JsonInclude$Include
 *  com.fasterxml.jackson.annotation.ObjectIdGenerators$IntSequenceGenerator
 *  javax.persistence.CascadeType
 *  javax.persistence.Column
 *  javax.persistence.Entity
 *  javax.persistence.FetchType
 *  javax.persistence.GeneratedValue
 *  javax.persistence.GenerationType
 *  javax.persistence.Id
 *  javax.persistence.JoinColumn
 *  javax.persistence.ManyToOne
 *  javax.persistence.OneToOne
 *  javax.persistence.Table
 *  javax.persistence.Temporal
 *  javax.persistence.TemporalType
 *  org.hibernate.annotations.ForeignKey
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import in.jdsoft.educationmanagement.school.model.CommunicationFeedBackAndOthers;
import in.jdsoft.educationmanagement.school.model.PortalReplyMessage;
import in.jdsoft.educationmanagement.school.model.User;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tbl_communication_feedback_and_others_history")
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class CommunicationFeedBackAndOthersHistory
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long communicationFeedBackAndOthersHistoryId;
    private String communicationFeedBackAndOthersHistorySubject;
    private String communicationFeedBackAndOthersHistoryMessage;
    private String createdBy;
    private Date createdDate;
    private Integer status;
    private String messageLink;
    private User targetUser;
    private CommunicationFeedBackAndOthers communicationFeedBackAndOthers;
    private PortalReplyMessage portalReplyMessage;

    public CommunicationFeedBackAndOthersHistory(String communicationFeedBackAndOthersHistorySubject, String communicationFeedBackAndOthersHistoryMessage, String createdBy, Integer status, User targetUser, CommunicationFeedBackAndOthers communicationFeedBackAndOthers) {
        this.communicationFeedBackAndOthersHistorySubject = communicationFeedBackAndOthersHistorySubject;
        this.communicationFeedBackAndOthersHistoryMessage = communicationFeedBackAndOthersHistoryMessage;
        this.createdBy = createdBy;
        this.status = status;
        this.targetUser = targetUser;
        this.communicationFeedBackAndOthers = communicationFeedBackAndOthers;
        this.createdDate = new Timestamp(Calendar.getInstance().getTime().getTime());
    }

    CommunicationFeedBackAndOthersHistory() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="communication_feedback_and_others_history_id", unique=true, nullable=false)
    public Long getCommunicationFeedBackAndOthersHistoryId() {
        return this.communicationFeedBackAndOthersHistoryId;
    }

    public void setCommunicationFeedBackAndOthersHistoryId(Long communicationFeedBackAndOthersHistoryId) {
        this.communicationFeedBackAndOthersHistoryId = communicationFeedBackAndOthersHistoryId;
    }

    @Column(name="communication_feedback_and_others_history_subject", nullable=true, length=255)
    public String getCommunicationFeedBackAndOthersHistorySubject() {
        return this.communicationFeedBackAndOthersHistorySubject;
    }

    public void setCommunicationFeedBackAndOthersHistorySubject(String communicationFeedBackAndOthersHistorySubject) {
        this.communicationFeedBackAndOthersHistorySubject = communicationFeedBackAndOthersHistorySubject;
    }

    @Column(name="communication_feedback_and_others_history_message", nullable=true, length=255)
    public String getCommunicationFeedBackAndOthersHistoryMessage() {
        return this.communicationFeedBackAndOthersHistoryMessage;
    }

    public void setCommunicationFeedBackAndOthersHistoryMessage(String communicationFeedBackAndOthersHistoryMessage) {
        this.communicationFeedBackAndOthersHistoryMessage = communicationFeedBackAndOthersHistoryMessage;
    }

    @Column(name="created_by", nullable=true, length=100)
    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Column(name="message_link", nullable=false, length=255)
    public String getMessageLink() {
        return this.messageLink;
    }

    public void setMessageLink(String messageLink) {
        this.messageLink = messageLink;
    }

    @Temporal(value=TemporalType.TIMESTAMP)
    @Column(name="created_date", nullable=true, length=19)
    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="target_user_id", nullable=true, referencedColumnName="user_id")
    @ForeignKey(name="communicationFeedBackAndOthersHistoryInUser")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@communicationFeedBackAndOthersHistory")
    @JsonIdentityReference(alwaysAsId=true)
    public User getTargetUser() {
        return this.targetUser;
    }

    public void setTargetUser(User targetUser) {
        this.targetUser = targetUser;
    }

    @Column(name="communication_feedback_and_others_history_status", nullable=false, length=10)
    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="communication_feedback_and_others_id", nullable=true)
    @ForeignKey(name="communicationFeedBackAndOthersHistoryInCommunicationFeedBackAndOthers")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@communicationFeedBackAndOthersHistory")
    @JsonIdentityReference(alwaysAsId=true)
    public CommunicationFeedBackAndOthers getCommunicationFeedBackAndOthers() {
        return this.communicationFeedBackAndOthers;
    }

    public void setCommunicationFeedBackAndOthers(CommunicationFeedBackAndOthers communicationFeedBackAndOthers) {
        this.communicationFeedBackAndOthers = communicationFeedBackAndOthers;
    }

    @OneToOne(fetch=FetchType.LAZY, cascade={CascadeType.ALL})
    @ForeignKey(name="communicationFeedBackAndOthersHistoryInPotalMessage")
    @JoinColumn(name="portal_reply_message_id", nullable=true)
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@communicationFeedBackAndOthersHistory")
    @JsonIdentityReference(alwaysAsId=true)
    public PortalReplyMessage getPortalReplyMessage() {
        return this.portalReplyMessage;
    }

    public void setPortalReplyMessage(PortalReplyMessage portalReplyMessage) {
        this.portalReplyMessage = portalReplyMessage;
    }
}
