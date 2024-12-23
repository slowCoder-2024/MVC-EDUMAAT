/*
 * Decompiled with CFR 0.152.
 */
package in.jdsoft.educationmanagement.school.exceptions;

import in.jdsoft.educationmanagement.school.exceptions.EdumaatException;
import in.jdsoft.educationmanagement.school.model.Message;

public class SMSGatewayDetailsException
extends EdumaatException {
    private static final long serialVersionUID = 1L;

    public SMSGatewayDetailsException(Message message) {
        super(message);
    }

    public SMSGatewayDetailsException(Exception e, Message message) {
        super(e, message);
    }
}
