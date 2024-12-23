/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.exceptions.StaffException;
import in.jdsoft.educationmanagement.school.exceptions.UserException;
import in.jdsoft.educationmanagement.school.exceptions.UserServiceExceptions;
import in.jdsoft.educationmanagement.school.model.Admission;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.User;
import java.util.List;
import java.util.Set;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserService {
    public static final Logger log = LogManager.getLogger((String)UserService.class.getName());

    public User userByEmailEager(String var1);

    public User userCommunicationNotificationByEmail(String var1);

    public User userCommunicationFeedBackAndOthersByEmail(String var1);

    public User userReceivedCommunicationFeedBackAndOthersByEmail(String var1);

    public User userByIdEager(Long var1);

    public User userByEmail(String var1);

    public User userWithRolesAndPrivileges(String var1);

    public Long createUser(User var1);

    public void deleteUser(Long var1);

    public List<User> userList();

    public List<User> userList(Long var1) throws UserException;

    public User userById(Long var1);

    public void updateUser(User var1);

    public List<User> allStaffApproversList(Long var1);

    public Set<User> staffLeaveApprovar(String var1, Long var2) throws StaffException;

    public Message emailAvailablityCheck(String var1);

    public void resetPasswordByEmail(String var1) throws UserServiceExceptions, Exception;

    public Boolean validateEmail(String var1);

    public Set<Admission> getUsersAdmissionApplication(String var1);

    public User studentLeaveApprover(String var1, Long var2) throws UserServiceExceptions;

    public User tcApprover(Long var1);

    public List<User> allStaffApproversLists();

    public User principalRoleApproverByInstitution(Long var1) throws UserServiceExceptions;

    public List<User> inventoryRequest() throws UserServiceExceptions;
}
