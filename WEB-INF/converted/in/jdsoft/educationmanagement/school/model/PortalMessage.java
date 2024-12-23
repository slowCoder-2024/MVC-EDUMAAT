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
 *  javax.persistence.Column
 *  javax.persistence.Entity
 *  javax.persistence.FetchType
 *  javax.persistence.GeneratedValue
 *  javax.persistence.GenerationType
 *  javax.persistence.Id
 *  javax.persistence.JoinColumn
 *  javax.persistence.JoinTable
 *  javax.persistence.ManyToMany
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
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.User;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tbl_portal_message")
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class PortalMessage
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long portalMessageId;
    private String portalMessageSubject;
    private String portalMessage;
    private Set<User> targetUsers = new LinkedHashSet<User>();
    private Integer portalMessageStatus;
    private String portalMessageLink;
    private Date createdDate;
    private String createdBy;
    private Institution institution;
    private CommunicationFeedBackAndOthers communicationFeedBackAndOthers;

    public PortalMessage() {
    }

    public PortalMessage(String subject, String message, Set<User> targetUsers, Integer messageStatus, String messageLink, String createdBy, Institution institution) {
        this.portalMessageSubject = subject;
        this.portalMessage = message;
        this.targetUsers = targetUsers;
        this.portalMessageStatus = messageStatus;
        this.portalMessageLink = messageLink;
        this.createdDate = new Date(Calendar.getInstance().getTime().getTime());
        this.setCreatedBy(createdBy);
        this.institution = institution;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="portal_message_id", nullable=false)
    public Long getPortalMessageId() {
        return this.portalMessageId;
    }

    public void setPortalMessageId(Long portalMessageId) {
        this.portalMessageId = portalMessageId;
    }

    @Column(name="portal_message", nullable=false, length=255)
    public String getPortalMessage() {
        return this.portalMessage;
    }

    public void setPortalMessage(String portalMessage) {
        this.portalMessage = portalMessage;
    }

    @Column(name="portal_message_status", nullable=false)
    public Integer getPortalMessageStatus() {
        return this.portalMessageStatus;
    }

    public void setPortalMessageStatus(Integer portalMessageStatus) {
        this.portalMessageStatus = portalMessageStatus;
    }

    @Column(name="portal_message_link", nullable=false, length=255)
    public String getPortalMessageLink() {
        return this.portalMessageLink;
    }

    public void setPortalMessageLink(String portalMessageLink) {
        this.portalMessageLink = portalMessageLink;
    }

    @Temporal(value=TemporalType.TIMESTAMP)
    @Column(name="created_date", nullable=false)
    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Column(name="created_by", nullable=false, length=100)
    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Column(name="portal_message_subject", nullable=false, length=100)
    public String getPortalMessageSubject() {
        return this.portalMessageSubject;
    }

    public void setPortalMessageSubject(String portalMessageSubject) {
        this.portalMessageSubject = portalMessageSubject;
    }

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="tbl_portal_message_users", joinColumns={@JoinColumn(name="portal_message_id", updatable=true, nullable=true)}, inverseJoinColumns={@JoinColumn(name="target_user_id", referencedColumnName="user_id", updatable=true, nullable=true)})
    @ForeignKey(name="PortalMessageInUser")
    public Set<User> getTargetUsers() {
        return this.targetUsers;
    }

    public void setTargetUsers(Set<User> targetUsers) {
        this.targetUsers = targetUsers;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="institution_id", nullable=false)
    @ForeignKey(name="portalMessageInInstitution")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@portalMessages")
    @JsonIdentityReference(alwaysAsId=true)
    public Institution getInstitution() {
        return this.institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    @OneToOne(fetch=FetchType.LAZY, mappedBy="portalMessage")
    @ForeignKey(name="portalMessageInCommunicationFeedBackAndOthers")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@portalMessage")
    @JsonIdentityReference(alwaysAsId=true)
    public CommunicationFeedBackAndOthers getCommunicationFeedBackAndOthers() {
        return this.communicationFeedBackAndOthers;
    }

    public void setCommunicationFeedBackAndOthers(CommunicationFeedBackAndOthers communicationFeedBackAndOthers) {
        this.communicationFeedBackAndOthers = communicationFeedBackAndOthers;
    }
}
