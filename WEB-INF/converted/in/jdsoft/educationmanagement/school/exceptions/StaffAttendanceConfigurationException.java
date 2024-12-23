/*
 * Decompiled with CFR 0.152.
 */
package in.jdsoft.educationmanagement.school.exceptions;

import in.jdsoft.educationmanagement.school.exceptions.EdumaatException;
import in.jdsoft.educationmanagement.school.model.Message;

public class StaffAttendanceConfigurationException
extends EdumaatException {
    private static final long serialVersionUID = 1L;

    public StaffAttendanceConfigurationException(Message message) {
        super(message);
    }

    public StaffAttendanceConfigurationException(Exception e, Message message) {
        super(e, message);
    }
}
