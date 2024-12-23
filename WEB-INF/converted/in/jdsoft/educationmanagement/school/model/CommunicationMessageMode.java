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
 *  javax.persistence.OneToMany
 *  javax.persistence.Table
 *  javax.persistence.UniqueConstraint
 *  org.hibernate.annotations.ForeignKey
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import in.jdsoft.educationmanagement.school.model.CommunicationFeedBackAndOthers;
import in.jdsoft.educationmanagement.school.model.CommunicationFeedBackAndOthersArchive;
import in.jdsoft.educationmanagement.school.model.CommunicationNotification;
import in.jdsoft.educationmanagement.school.model.CommunicationNotificationArchive;
import java.io.Serializable;
import java.util.LinkedHashSet;
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
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tbl_communication_message_mode", uniqueConstraints={@UniqueConstraint(columnNames={"communication_message_mode_title"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class CommunicationMessageMode
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long communicationMessageModeId;
    private String communicationMessageModeTitle;
    private Set<CommunicationNotification> communicationNotifications = new LinkedHashSet<CommunicationNotification>();
    private Set<CommunicationFeedBackAndOthers> communicationFeedBackAndOthers = new LinkedHashSet<CommunicationFeedBackAndOthers>();
    private Set<CommunicationNotificationArchive> communicationNotificationArchives = new LinkedHashSet<CommunicationNotificationArchive>();
    private Set<CommunicationFeedBackAndOthersArchive> communicationFeedBackAndOthersArchives = new LinkedHashSet<CommunicationFeedBackAndOthersArchive>();

    public CommunicationMessageMode(String communicationMessageModeTitle) {
        this.communicationMessageModeTitle = communicationMessageModeTitle;
    }

    CommunicationMessageMode() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="communication_message_mode_id", unique=true, nullable=false)
    public Long getCommunicationMessageModeId() {
        return this.communicationMessageModeId;
    }

    public void setCommunicationMessageModeId(Long communicationMessageModeId) {
        this.communicationMessageModeId = communicationMessageModeId;
    }

    @Column(name="communication_message_mode_title", nullable=true, length=255)
    public String getCommunicationMessageModeTitle() {
        return this.communicationMessageModeTitle;
    }

    public void setCommunicationMessageModeTitle(String communicationMessageModeTitle) {
        this.communicationMessageModeTitle = communicationMessageModeTitle;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="communicationMessageMode")
    @ForeignKey(name="communicationMessageModeInCommunicationNotifications")
    public Set<CommunicationNotification> getCommunicationNotifications() {
        return this.communicationNotifications;
    }

    public void setCommunicationNotifications(Set<CommunicationNotification> communicationNotifications) {
        this.communicationNotifications = communicationNotifications;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="communicationMessageMode")
    @ForeignKey(name="communicationMessageModeInCommunicationNotificationArchives")
    public Set<CommunicationNotificationArchive> getCommunicationNotificationArchives() {
        return this.communicationNotificationArchives;
    }

    public void setCommunicationNotificationArchives(Set<CommunicationNotificationArchive> communicationNotificationArchives) {
        this.communicationNotificationArchives = communicationNotificationArchives;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="communicationMessageMode")
    @ForeignKey(name="communicationMessageModeInCommunicationFeedBackAndOthers")
    public Set<CommunicationFeedBackAndOthers> getCommunicationFeedBackAndOthers() {
        return this.communicationFeedBackAndOthers;
    }

    public void setCommunicationFeedBackAndOthers(Set<CommunicationFeedBackAndOthers> communicationFeedBackAndOthers) {
        this.communicationFeedBackAndOthers = communicationFeedBackAndOthers;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="communicationMessageMode")
    @ForeignKey(name="communicationMessageModeInCommunicationFeedBackAndOthersArchives")
    public Set<CommunicationFeedBackAndOthersArchive> getCommunicationFeedBackAndOthersArchives() {
        return this.communicationFeedBackAndOthersArchives;
    }

    public void setCommunicationFeedBackAndOthersArchives(Set<CommunicationFeedBackAndOthersArchive> communicationFeedBackAndOthersArchives) {
        this.communicationFeedBackAndOthersArchives = communicationFeedBackAndOthersArchives;
    }
}
