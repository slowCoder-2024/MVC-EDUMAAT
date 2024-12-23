/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Repository
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.Message;
import java.io.Serializable;
import org.springframework.stereotype.Repository;

@Repository
public class MessageDAO
extends GenericDAO<Message> {
    public MessageDAO() {
        super(Message.class);
    }

    public Message getMessageById(Long id) {
        Message instance = (Message)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.Message", (Serializable)id);
        return instance;
    }
}
