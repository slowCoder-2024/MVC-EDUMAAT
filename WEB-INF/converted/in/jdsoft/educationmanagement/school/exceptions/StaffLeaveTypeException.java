/*
 * Decompiled with CFR 0.152.
 */
package in.jdsoft.educationmanagement.school.exceptions;

import in.jdsoft.educationmanagement.school.exceptions.EdumaatException;
import in.jdsoft.educationmanagement.school.model.Message;

public class StaffLeaveTypeException
extends EdumaatException {
    private static final long serialVersionUID = 1L;

    public StaffLeaveTypeException(Exception e, Message message) {
        super(e, message);
    }

    public StaffLeaveTypeException(Message message) {
        super(message);
    }
}
