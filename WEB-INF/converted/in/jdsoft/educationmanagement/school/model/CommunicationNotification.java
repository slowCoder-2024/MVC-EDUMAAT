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
import in.jdsoft.educationmanagement.school.model.CommunicationMessageMode;
import in.jdsoft.educationmanagement.school.model.CommunicationNotificationArchive;
import in.jdsoft.educationmanagement.school.model.CommunicationTargetGroup;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.PortalNotification;
import in.jdsoft.educationmanagement.school.model.User;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.CascadeType;
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
@Table(name="tbl_communication_notification")
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class CommunicationNotification
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long communicationNotificationId;
    private String communicationNotificationSubject;
    private String communicationNotificationMessage;
    private String createdBy;
    private Date createdDate;
    private Integer status;
    private CommunicationTargetGroup communicationTargetGroup;
    private CommunicationMessageMode communicationMessageMode;
    private Set<User> targetUsers = new LinkedHashSet<User>();
    private CommunicationNotificationArchive communicationNotificationArchive;
    private Institution institution;
    private PortalNotification portalNotification;

    public CommunicationNotification(String communicationNotificationSubject, String communicationNotificationMessage, String createdBy, Integer status, CommunicationTargetGroup communicationTargetGroup, CommunicationMessageMode communicationMessageMode, Set<User> targetUsers, Institution institution) {
        this.communicationNotificationSubject = communicationNotificationSubject;
        this.communicationNotificationMessage = communicationNotificationMessage;
        this.createdBy = createdBy;
        this.createdDate = new Timestamp(Calendar.getInstance().getTime().getTime());
        this.status = status;
        this.communicationTargetGroup = communicationTargetGroup;
        this.communicationMessageMode = communicationMessageMode;
        this.targetUsers = targetUsers;
        this.institution = institution;
    }

    CommunicationNotification() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="communication_notification_id", unique=true, nullable=false)
    public Long getCommunicationNotificationId() {
        return this.communicationNotificationId;
    }

    public void setCommunicationNotificationId(Long communicationNotificationId) {
        this.communicationNotificationId = communicationNotificationId;
    }

    @Column(name="communication_notification_subject", nullable=true, length=255)
    public String getCommunicationNotificationSubject() {
        return this.communicationNotificationSubject;
    }

    public void setCommunicationNotificationSubject(String communicationNotificationSubject) {
        this.communicationNotificationSubject = communicationNotificationSubject;
    }

    @Column(name="communication_notification_message", nullable=true, length=255)
    public String getCommunicationNotificationMessage() {
        return this.communicationNotificationMessage;
    }

    public void setCommunicationNotificationMessage(String communicationNotificationMessage) {
        this.communicationNotificationMessage = communicationNotificationMessage;
    }

    @Column(name="created_by", nullable=true, length=100)
    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Temporal(value=TemporalType.TIMESTAMP)
    @Column(name="created_date", nullable=true, length=19)
    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @ManyToMany(fetch=FetchType.LAZY, cascade={CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.ALL})
    @JoinTable(name="tbl_communication_notification_users", joinColumns={@JoinColumn(name="communication_notification_id", updatable=true, nullable=true)}, inverseJoinColumns={@JoinColumn(name="target_user_id", referencedColumnName="user_id", updatable=true, nullable=true)})
    @ForeignKey(name="communicationNotificationsInUser")
    public Set<User> getTargetUsers() {
        return this.targetUsers;
    }

    public void setTargetUsers(Set<User> targetUsers) {
        this.targetUsers = targetUsers;
    }

    @Column(name="communication_notification_status", nullable=false, length=10)
    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="communication_target_group_id", nullable=false)
    @ForeignKey(name="communicationNotificationInCommunicationTargetGroup")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@communicationNotifications")
    @JsonIdentityReference(alwaysAsId=true)
    public CommunicationTargetGroup getCommunicationTargetGroup() {
        return this.communicationTargetGroup;
    }

    public void setCommunicationTargetGroup(CommunicationTargetGroup communicationTargetGroup) {
        this.communicationTargetGroup = communicationTargetGroup;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="communication_message_mode_id", nullable=false)
    @ForeignKey(name="communicationNotificationInCommunicationMessageMode")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@communicationNotifications")
    @JsonIdentityReference(alwaysAsId=true)
    public CommunicationMessageMode getCommunicationMessageMode() {
        return this.communicationMessageMode;
    }

    public void setCommunicationMessageMode(CommunicationMessageMode communicationMessageMode) {
        this.communicationMessageMode = communicationMessageMode;
    }

    @OneToOne(fetch=FetchType.LAZY, mappedBy="communicationNotification", cascade={CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.ALL})
    @ForeignKey(name="communicationNotificationInCommunicationNotificationArchive")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@communicationNotification")
    @JsonIdentityReference(alwaysAsId=true)
    public CommunicationNotificationArchive getCommunicationNotificationArchive() {
        return this.communicationNotificationArchive;
    }

    public void setCommunicationNotificationArchive(CommunicationNotificationArchive communicationNotificationArchive) {
        this.communicationNotificationArchive = communicationNotificationArchive;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="institution_id", nullable=false)
    @ForeignKey(name="communicationNotificationInInstitution")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@communicationNotifications")
    @JsonIdentityReference(alwaysAsId=true)
    public Institution getInstitution() {
        return this.institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    @OneToOne(fetch=FetchType.LAZY, cascade={CascadeType.ALL})
    @ForeignKey(name="communicationNotificationInPotalNotification")
    @JoinColumn(name="portal_notification_id", nullable=false)
    public PortalNotification getPortalNotification() {
        return this.portalNotification;
    }

    public void setPortalNotification(PortalNotification portalNotification) {
        this.portalNotification = portalNotification;
    }
}
