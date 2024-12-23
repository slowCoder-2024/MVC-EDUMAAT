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
import in.jdsoft.educationmanagement.school.model.CommunicationNotification;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.User;
import java.io.Serializable;
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
@Table(name="tbl_portal_notification")
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class PortalNotification
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long portalNotificationId;
    private String portalNotificationSubject;
    private String portalNotificationMessage;
    private Set<User> targetUsers = new LinkedHashSet<User>();
    private Integer portalNotificationStatus;
    private String portalNotificationLink;
    private Date createdDate;
    private String createdBy;
    private Institution institution;
    private CommunicationNotification communicationNotification;

    public PortalNotification() {
    }

    public PortalNotification(String notificationSubject, String notificationMessage, Set<User> targetUsers, Integer notificationStatus, String notificationLink, String createdBy, Institution institution) {
        this.portalNotificationSubject = notificationSubject;
        this.portalNotificationMessage = notificationMessage;
        this.targetUsers = targetUsers;
        this.portalNotificationStatus = notificationStatus;
        this.portalNotificationLink = notificationLink;
        this.createdDate = new Date(Calendar.getInstance().getTime().getTime());
        this.setCreatedBy(createdBy);
        this.institution = institution;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="portal_notification_id", nullable=false)
    public Long getPortalNotificationId() {
        return this.portalNotificationId;
    }

    public void setPortalNotificationId(Long portalNotificationId) {
        this.portalNotificationId = portalNotificationId;
    }

    @Column(name="portal_notification_message", nullable=false, length=255)
    public String getPortalNotificationMessage() {
        return this.portalNotificationMessage;
    }

    public void setPortalNotificationMessage(String portalNotificationMessage) {
        this.portalNotificationMessage = portalNotificationMessage;
    }

    @Column(name="portal_notification_status", nullable=false)
    public Integer getPortalNotificationStatus() {
        return this.portalNotificationStatus;
    }

    public void setPortalNotificationStatus(Integer portalNotificationStatus) {
        this.portalNotificationStatus = portalNotificationStatus;
    }

    @Column(name="portal_notification_link", nullable=false, length=255)
    public String getPortalNotificationLink() {
        return this.portalNotificationLink;
    }

    public void setPortalNotificationLink(String portalNotificationLink) {
        this.portalNotificationLink = portalNotificationLink;
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

    @Column(name="portal_notification_subject", nullable=false, length=100)
    public String getPortalNotificationSubject() {
        return this.portalNotificationSubject;
    }

    public void setPortalNotificationSubject(String portalNotificationSubject) {
        this.portalNotificationSubject = portalNotificationSubject;
    }

    @ManyToMany(fetch=FetchType.LAZY, cascade={CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.ALL})
    @JoinTable(name="tbl_portal_notification_users", joinColumns={@JoinColumn(name="portal_notification_id", updatable=true, nullable=true)}, inverseJoinColumns={@JoinColumn(name="target_user_id", referencedColumnName="user_id", updatable=true, nullable=true)})
    @ForeignKey(name="PortalNotificationInUser")
    public Set<User> getTargetUsers() {
        return this.targetUsers;
    }

    public void setTargetUsers(Set<User> targetUsers) {
        this.targetUsers = targetUsers;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="institution_id", nullable=false)
    @ForeignKey(name="portalNotificationInInstitution")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@portalNotifications")
    @JsonIdentityReference(alwaysAsId=true)
    public Institution getInstitution() {
        return this.institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    @OneToOne(fetch=FetchType.LAZY, mappedBy="portalNotification")
    @ForeignKey(name="portalNotificationInCommunicationNotification")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@portalNotification")
    @JsonIdentityReference(alwaysAsId=true)
    public CommunicationNotification getCommunicationNotification() {
        return this.communicationNotification;
    }

    public void setCommunicationNotification(CommunicationNotification communicationNotification) {
        this.communicationNotification = communicationNotification;
    }
}
