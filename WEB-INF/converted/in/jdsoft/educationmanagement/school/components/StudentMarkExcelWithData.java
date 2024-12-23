/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  org.apache.poi.hssf.usermodel.HSSFCellStyle
 *  org.apache.poi.hssf.usermodel.HSSFFont
 *  org.apache.poi.hssf.usermodel.HSSFRow
 *  org.apache.poi.hssf.usermodel.HSSFSheet
 *  org.apache.poi.hssf.usermodel.HSSFWorkbook
 *  org.apache.poi.ss.usermodel.CellStyle
 *  org.apache.poi.ss.usermodel.Font
 *  org.springframework.web.servlet.view.document.AbstractExcelView
 */
package in.jdsoft.educationmanagement.school.components;

import in.jdsoft.educationmanagement.school.model.SpecialCategory;
import in.jdsoft.educationmanagement.school.model.Student;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.springframework.web.servlet.view.document.AbstractExcelView;

public class StudentMarkExcelWithData
extends AbstractExcelView {
    protected void buildExcelDocument(Map<String, Object> models, HSSFWorkbook workbook, HttpServletRequest arg2, HttpServletResponse arg3) throws Exception {
        arg3.setContentType("text/xls");
        arg3.setHeader("Content-Disposition", "attachment; filename=\"excelDownload.xls\"");
        ArrayList students = (ArrayList)models.get("studentList");
        HSSFSheet sheet = workbook.createSheet("students");
        sheet.setDefaultColumnWidth(30);
        HSSFCellStyle style = workbook.createCellStyle();
        HSSFFont font = workbook.createFont();
        font.setFontName("Arial");
        style.setFillForegroundColor((short)12);
        style.setFillPattern((short)1);
        font.setBoldweight((short)700);
        font.setColor((short)9);
        style.setFont((Font)font);
        HSSFRow header = sheet.createRow(0);
        header.createCell(0).setCellValue("Student Id");
        header.getCell(0).setCellStyle((CellStyle)style);
        header.createCell(1).setCellValue("Admission No *");
        header.getCell(1).setCellStyle((CellStyle)style);
        header.createCell(2).setCellValue("First Name *");
        header.getCell(2).setCellStyle((CellStyle)style);
        header.createCell(3).setCellValue("Last Name");
        header.getCell(3).setCellStyle((CellStyle)style);
        header.createCell(4).setCellValue("Current Class *");
        header.getCell(4).setCellStyle((CellStyle)style);
        header.createCell(5).setCellValue("Current Section *");
        header.getCell(5).setCellStyle((CellStyle)style);
        header.createCell(6).setCellValue("Special Category *");
        header.getCell(6).setCellStyle((CellStyle)style);
        header.createCell(7).setCellValue("Status *");
        header.getCell(7).setCellStyle((CellStyle)style);
        header.createCell(8).setCellValue("Roll No");
        header.getCell(8).setCellStyle((CellStyle)style);
        header.createCell(9).setCellValue("Gender *");
        header.getCell(9).setCellStyle((CellStyle)style);
        header.createCell(10).setCellValue("DOB *");
        header.getCell(10).setCellStyle((CellStyle)style);
        header.createCell(11).setCellValue("Category *");
        header.getCell(11).setCellStyle((CellStyle)style);
        header.createCell(12).setCellValue("Blood Group");
        header.getCell(12).setCellStyle((CellStyle)style);
        header.createCell(13).setCellValue("Joined Academic Year *");
        header.getCell(13).setCellStyle((CellStyle)style);
        header.createCell(14).setCellValue("Student Joined Class *");
        header.getCell(14).setCellStyle((CellStyle)style);
        header.createCell(15).setCellValue("Parent Or Guardian First Name *");
        header.getCell(15).setCellStyle((CellStyle)style);
        header.createCell(16).setCellValue("Parent Or Guardian Last Name");
        header.getCell(16).setCellStyle((CellStyle)style);
        header.createCell(17).setCellValue("Parent Or Guardian Email *");
        header.getCell(17).setCellStyle((CellStyle)style);
        header.createCell(18).setCellValue("Address Line 1 *");
        header.getCell(18).setCellStyle((CellStyle)style);
        header.createCell(19).setCellValue("Address Line 2 *");
        header.getCell(19).setCellStyle((CellStyle)style);
        header.createCell(20).setCellValue("Postcode *");
        header.getCell(20).setCellStyle((CellStyle)style);
        header.createCell(21).setCellValue("Email *");
        header.getCell(21).setCellStyle((CellStyle)style);
        header.createCell(22).setCellValue("Student Contact No *");
        header.getCell(22).setCellStyle((CellStyle)style);
        header.createCell(23).setCellValue("Parent Contact No *");
        header.getCell(23).setCellStyle((CellStyle)style);
        header.createCell(24).setCellValue("Joined Date *");
        header.getCell(24).setCellStyle((CellStyle)style);
        header.createCell(25).setCellValue("Fathers Income");
        header.getCell(25).setCellStyle((CellStyle)style);
        header.createCell(26).setCellValue("Mothers Income");
        header.getCell(26).setCellStyle((CellStyle)style);
        header.createCell(27).setCellValue("Biometric Access No");
        header.getCell(27).setCellStyle((CellStyle)style);
        header.createCell(28).setCellValue("Passport No");
        header.getCell(28).setCellStyle((CellStyle)style);
        int rowCount = 1;
        SimpleDateFormat dateformatter = new SimpleDateFormat("MM/dd/yyyy");
        for (Student student : students) {
            HSSFRow aRow = sheet.createRow(rowCount++);
            aRow.createCell(0).setCellValue((double)student.getStudentId().longValue());
            aRow.createCell(1).setCellValue(student.getAdmissionNo());
            aRow.createCell(2).setCellValue(student.getFirstName());
            aRow.createCell(3).setCellValue(student.getLastName());
            aRow.createCell(8).setCellValue(student.getRollNo());
            aRow.createCell(9).setCellValue(student.getSex());
            if (student.getBirthDate() != null) {
                aRow.createCell(10).setCellValue(dateformatter.format(student.getBirthDate()));
            }
            aRow.createCell(15).setCellValue(student.getParentGuardianFirstName());
            aRow.createCell(16).setCellValue(student.getParentGuardianLastName());
            aRow.createCell(17).setCellValue(student.getParentGuardianEmail());
            aRow.createCell(18).setCellValue(student.getAddressLine1());
            aRow.createCell(19).setCellValue(student.getAddressLine2());
            aRow.createCell(20).setCellValue(student.getPostcode());
            aRow.createCell(21).setCellValue(student.getEmail());
            aRow.createCell(22).setCellValue(student.getContact());
            aRow.createCell(23).setCellValue(student.getParentContact());
            if (student.getJoinedDate() != null) {
                aRow.createCell(24).setCellValue(dateformatter.format(student.getJoinedDate()));
            }
            if (student.getFathersIncome() != null) {
                aRow.createCell(25).setCellValue(student.getFathersIncome().doubleValue());
            }
            if (student.getMothersIncome() != null) {
                aRow.createCell(26).setCellValue(student.getMothersIncome().doubleValue());
            }
            aRow.createCell(27).setCellValue(student.getAccessNo());
            aRow.createCell(28).setCellValue(student.getPassportNumber());
            if (student.getStudentClass() != null) {
                aRow.createCell(4).setCellValue(student.getStudentClass().getClassName());
            }
            if (student.getSection() != null) {
                aRow.createCell(5).setCellValue(student.getSection().getSectionName());
            }
            if (student.getBloodGroup() != null) {
                aRow.createCell(12).setCellValue(student.getBloodGroup().getBloodGroupName());
            }
            if (student.getCategory() != null) {
                aRow.createCell(11).setCellValue(student.getCategory().getCategoryName());
            }
            if (student.getSpecialCategories() != null) {
                String specialCategories = "";
                for (SpecialCategory specialCategory : student.getSpecialCategories()) {
                    specialCategories = String.valueOf(specialCategories) + specialCategory.getSpecialCategoryName() + ",";
                }
                specialCategories = specialCategories.substring(0, specialCategories.length() - 1);
                aRow.createCell(6).setCellValue(specialCategories);
            }
            if (student.getStudentStatus() != null) {
                aRow.createCell(7).setCellValue(student.getStudentStatus().getStatusTitle());
            }
            if (student.getJoinedAcademicYear() != null) {
                aRow.createCell(13).setCellValue(student.getJoinedAcademicYear().getAcademicYearTitle());
            }
            if (student.getJoinedClass() == null) continue;
            aRow.createCell(14).setCellValue(student.getJoinedClass().getClassName());
        }
    }
}
