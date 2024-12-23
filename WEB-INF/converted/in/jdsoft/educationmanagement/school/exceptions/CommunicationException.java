/*
 * Decompiled with CFR 0.152.
 */
package in.jdsoft.educationmanagement.school.exceptions;

import in.jdsoft.educationmanagement.school.exceptions.EdumaatException;
import in.jdsoft.educationmanagement.school.model.Message;

public class CommunicationException
extends EdumaatException {
    private static final long serialVersionUID = 1L;

    public CommunicationException(Exception e, Message message) {
        super(e, message);
    }

    public CommunicationException(Message message) {
        super(message);
    }
}
