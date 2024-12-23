/*
 * Decompiled with CFR 0.152.
 */
package in.jdsoft.educationmanagement.school.exceptions;

import in.jdsoft.educationmanagement.school.exceptions.ComplaintManagementException;
import in.jdsoft.educationmanagement.school.exceptions.EdumaatException;
import in.jdsoft.educationmanagement.school.model.Message;

public class MeetingRequisitionException
extends EdumaatException {
    private static final long serialVersionUID = 1L;

    public MeetingRequisitionException(Message message) {
        super(message);
    }

    public MeetingRequisitionException(ComplaintManagementException e, Message message) {
        super(e, message);
    }
}
