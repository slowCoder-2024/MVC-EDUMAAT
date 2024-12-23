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
import in.jdsoft.educationmanagement.school.model.CommunicationMessageMode;
import in.jdsoft.educationmanagement.school.model.CommunicationNotification;
import in.jdsoft.educationmanagement.school.model.CommunicationTargetGroup;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.User;
import java.io.Serializable;
import java.sql.Timestamp;
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
@Table(name="tbl_communication_notification_archive")
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class CommunicationNotificationArchive
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long communicationNotificationArchiveId;
    private String communicationNotificationArchiveSubject;
    private String communicationNotificationArchiveMessage;
    private String createdBy;
    private Date createdDate;
    private Integer status;
    private CommunicationTargetGroup communicationTargetGroup;
    private CommunicationMessageMode communicationMessageMode;
    private Set<User> targetUsers = new LinkedHashSet<User>();
    private CommunicationNotification communicationNotification;
    private Institution institution;

    public CommunicationNotificationArchive(String communicationNotificationArchiveSubject, String communicationNotificationArchiveMessage, String createdBy, Integer status, CommunicationTargetGroup communicationTargetGroup, CommunicationMessageMode communicationMessageMode, Set<User> targetUsers, Institution institution) {
        this.communicationNotificationArchiveSubject = communicationNotificationArchiveSubject;
        this.communicationNotificationArchiveMessage = communicationNotificationArchiveMessage;
        this.createdBy = createdBy;
        this.createdDate = new Timestamp(Calendar.getInstance().getTime().getTime());
        this.status = status;
        this.communicationTargetGroup = communicationTargetGroup;
        this.communicationMessageMode = communicationMessageMode;
        this.targetUsers = targetUsers;
        this.institution = institution;
    }

    CommunicationNotificationArchive() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="communication_notification_archive_id", unique=true, nullable=false)
    public Long getCommunicationNotificationArchiveId() {
        return this.communicationNotificationArchiveId;
    }

    public void setCommunicationNotificationArchiveId(Long communicationNotificationArchiveId) {
        this.communicationNotificationArchiveId = communicationNotificationArchiveId;
    }

    @Column(name="communication_notification_archive_subject", nullable=true, length=255)
    public String getCommunicationNotificationArchiveSubject() {
        return this.communicationNotificationArchiveSubject;
    }

    public void setCommunicationNotificationArchiveSubject(String communicationNotificationArchiveSubject) {
        this.communicationNotificationArchiveSubject = communicationNotificationArchiveSubject;
    }

    @Column(name="communication_notification_archive_message", nullable=true, length=255)
    public String getCommunicationNotificationArchiveMessage() {
        return this.communicationNotificationArchiveMessage;
    }

    public void setCommunicationNotificationArchiveMessage(String communicationNotificationArchiveMessage) {
        this.communicationNotificationArchiveMessage = communicationNotificationArchiveMessage;
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

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="tbl_communication_notification_archive_users", joinColumns={@JoinColumn(name="communication_notification_archive_id", updatable=true)}, inverseJoinColumns={@JoinColumn(name="target_user_id", referencedColumnName="user_id", updatable=true)})
    @ForeignKey(name="communicationNotificationArchiveInUser")
    public Set<User> getTargetUsers() {
        return this.targetUsers;
    }

    public void setTargetUsers(Set<User> targetUsers) {
        this.targetUsers = targetUsers;
    }

    @Column(name="communication_notification_archive_status", nullable=false, length=10)
    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="communication_target_group_id", nullable=false)
    @ForeignKey(name="communicationNotificationArchiveInCommunicationTargetGroup")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@communicationNotificationArchives")
    @JsonIdentityReference(alwaysAsId=true)
    public CommunicationTargetGroup getCommunicationTargetGroup() {
        return this.communicationTargetGroup;
    }

    public void setCommunicationTargetGroup(CommunicationTargetGroup communicationTargetGroup) {
        this.communicationTargetGroup = communicationTargetGroup;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="communication_message_mode_id", nullable=false)
    @ForeignKey(name="communicationNotificationArchiveInCommunicationMessageMode")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@communicationNotificationArchives")
    @JsonIdentityReference(alwaysAsId=true)
    public CommunicationMessageMode getCommunicationMessageMode() {
        return this.communicationMessageMode;
    }

    public void setCommunicationMessageMode(CommunicationMessageMode communicationMessageMode) {
        this.communicationMessageMode = communicationMessageMode;
    }

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="communication_notification_id", nullable=true)
    @ForeignKey(name="communicationNotificationArchiveInCommunicationNotification")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@communicationNotificationArchive")
    @JsonIdentityReference(alwaysAsId=true)
    public CommunicationNotification getCommunicationNotification() {
        return this.communicationNotification;
    }

    public void setCommunicationNotification(CommunicationNotification communicationNotification) {
        this.communicationNotification = communicationNotification;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="institution_id", nullable=false)
    @ForeignKey(name="communicationNotificationArchiveInInstitution")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@communicationNotificationArchives")
    @JsonIdentityReference(alwaysAsId=true)
    public Institution getInstitution() {
        return this.institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }
}
