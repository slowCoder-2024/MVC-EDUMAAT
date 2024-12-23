/*
 * Decompiled with CFR 0.152.
 */
package in.jdsoft.educationmanagement.school.exceptions;

import in.jdsoft.educationmanagement.school.exceptions.EdumaatException;
import in.jdsoft.educationmanagement.school.model.Message;

public class AcademicYearFeesTermException
extends EdumaatException {
    private static final long serialVersionUID = 1L;

    public AcademicYearFeesTermException(Message message) {
        super(message);
    }

    public AcademicYearFeesTermException(Exception e, Message message) {
        super(e, message);
    }
}
