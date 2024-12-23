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

public class StudentExcelDownloadFormat
extends AbstractExcelView {
    protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/xls");
        response.setHeader("Content-Disposition", "attachment; filename=\"studentExcelFormat.xls\"");
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
        header.createCell(0).setCellValue("Admission No *");
        header.getCell(0).setCellStyle((CellStyle)style);
        header.createCell(1).setCellValue("First Name *");
        header.getCell(1).setCellStyle((CellStyle)style);
        header.createCell(2).setCellValue("Last Name");
        header.getCell(2).setCellStyle((CellStyle)style);
        header.createCell(3).setCellValue("Current Class *");
        header.getCell(3).setCellStyle((CellStyle)style);
        header.createCell(4).setCellValue("Current Section *");
        header.getCell(4).setCellStyle((CellStyle)style);
        header.createCell(5).setCellValue("Special Category *");
        header.getCell(5).setCellStyle((CellStyle)style);
        header.createCell(6).setCellValue("Status *");
        header.getCell(6).setCellStyle((CellStyle)style);
        header.createCell(7).setCellValue("Roll No");
        header.getCell(7).setCellStyle((CellStyle)style);
        header.createCell(8).setCellValue("Gender *");
        header.getCell(8).setCellStyle((CellStyle)style);
        header.createCell(9).setCellValue("DOB *");
        header.getCell(9).setCellStyle((CellStyle)style);
        header.createCell(10).setCellValue("Category *");
        header.getCell(10).setCellStyle((CellStyle)style);
        header.createCell(11).setCellValue("Blood Group");
        header.getCell(11).setCellStyle((CellStyle)style);
        header.createCell(12).setCellValue("Joined Academic Year *");
        header.getCell(12).setCellStyle((CellStyle)style);
        header.createCell(13).setCellValue("Student Joined Class *");
        header.getCell(13).setCellStyle((CellStyle)style);
        header.createCell(14).setCellValue("Parent Or Guardian First Name *");
        header.getCell(14).setCellStyle((CellStyle)style);
        header.createCell(15).setCellValue("Parent Or Guardian Last Name");
        header.getCell(15).setCellStyle((CellStyle)style);
        header.createCell(16).setCellValue("Parent Or Guardian Email *");
        header.getCell(16).setCellStyle((CellStyle)style);
        header.createCell(17).setCellValue("Address Line 1 *");
        header.getCell(17).setCellStyle((CellStyle)style);
        header.createCell(18).setCellValue("Address Line 2 *");
        header.getCell(18).setCellStyle((CellStyle)style);
        header.createCell(19).setCellValue("Country *");
        header.getCell(19).setCellStyle((CellStyle)style);
        header.createCell(20).setCellValue("State *");
        header.getCell(20).setCellStyle((CellStyle)style);
        header.createCell(21).setCellValue("City *");
        header.getCell(21).setCellStyle((CellStyle)style);
        header.createCell(22).setCellValue("Postcode *");
        header.getCell(22).setCellStyle((CellStyle)style);
        header.createCell(23).setCellValue("Student Email *");
        header.getCell(23).setCellStyle((CellStyle)style);
        header.createCell(24).setCellValue("Student Contact No *");
        header.getCell(24).setCellStyle((CellStyle)style);
        header.createCell(25).setCellValue("Parent Contact No *");
        header.getCell(25).setCellStyle((CellStyle)style);
        header.createCell(26).setCellValue("Joined Date *");
        header.getCell(26).setCellStyle((CellStyle)style);
        header.createCell(27).setCellValue("Fathers Income");
        header.getCell(27).setCellStyle((CellStyle)style);
        header.createCell(28).setCellValue("Mothers Income");
        header.getCell(28).setCellStyle((CellStyle)style);
        header.createCell(29).setCellValue("Biometric Access No");
        header.getCell(29).setCellStyle((CellStyle)style);
        header.createCell(30).setCellValue("Passport No");
        header.getCell(30).setCellStyle((CellStyle)style);
        header.createCell(31).setCellValue("House Name*");
        header.getCell(31).setCellStyle((CellStyle)style);
        header.createCell(32).setCellValue("Aadhar Card Number");
        header.getCell(32).setCellStyle((CellStyle)style);
    }
}
