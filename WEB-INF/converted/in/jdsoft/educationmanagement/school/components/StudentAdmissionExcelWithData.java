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

import java.util.Date;
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

public class StudentAdmissionExcelWithData
extends AbstractExcelView {
    protected void buildExcelDocument(Map<String, Object> models, HSSFWorkbook workbook, HttpServletRequest arg2, HttpServletResponse arg3) throws Exception {
        Date date = new Date();
        arg3.setContentType("text/xls");
        arg3.setHeader("Content-Disposition", "attachment; filename=\"studentAdmissionDataExcelFormat-" + date + ".xls\"");
        HSSFSheet sheet = workbook.createSheet("studentAdmissionDetails");
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
        header.createCell(0).setCellValue("Applicant First Name *");
        header.getCell(0).setCellStyle((CellStyle)style);
        header.createCell(1).setCellValue("Applicant Last Name");
        header.getCell(1).setCellStyle((CellStyle)style);
        header.createCell(2).setCellValue("Gender *");
        header.getCell(2).setCellStyle((CellStyle)style);
        header.createCell(3).setCellValue("DOB *");
        header.getCell(3).setCellStyle((CellStyle)style);
        header.createCell(4).setCellValue("Applicant Religion *");
        header.getCell(4).setCellStyle((CellStyle)style);
        header.createCell(5).setCellValue("Category *");
        header.getCell(5).setCellStyle((CellStyle)style);
        header.createCell(6).setCellValue("Special Category *");
        header.getCell(6).setCellStyle((CellStyle)style);
        header.createCell(7).setCellValue("Passport or ID Number");
        header.getCell(7).setCellStyle((CellStyle)style);
        header.createCell(8).setCellValue("Country ID issued");
        header.getCell(8).setCellStyle((CellStyle)style);
        header.createCell(9).setCellValue("Studied here before");
        header.getCell(9).setCellStyle((CellStyle)style);
        header.createCell(10).setCellValue("Previous Student ID of this institute");
        header.getCell(10).setCellStyle((CellStyle)style);
        header.createCell(11).setCellValue("Who will sponsor your studies here");
        header.getCell(11).setCellStyle((CellStyle)style);
        header.createCell(12).setCellValue("Do you have any disability *");
        header.getCell(12).setCellStyle((CellStyle)style);
        header.createCell(13).setCellValue("Father's First Name *");
        header.getCell(13).setCellStyle((CellStyle)style);
        header.createCell(14).setCellValue("Father's Last Name");
        header.getCell(14).setCellStyle((CellStyle)style);
        header.createCell(15).setCellValue("Father's Occupation");
        header.getCell(15).setCellStyle((CellStyle)style);
        header.createCell(16).setCellValue("Mother's First Name *");
        header.getCell(16).setCellStyle((CellStyle)style);
        header.createCell(17).setCellValue("Mother's Last Name");
        header.getCell(17).setCellStyle((CellStyle)style);
        header.createCell(18).setCellValue("Mother's Occupation");
        header.getCell(18).setCellStyle((CellStyle)style);
        header.createCell(19).setCellValue("Father Income");
        header.getCell(19).setCellStyle((CellStyle)style);
        header.createCell(20).setCellValue("Mother Income");
        header.getCell(20).setCellStyle((CellStyle)style);
        header.createCell(21).setCellValue("Guardian's First Name *");
        header.getCell(21).setCellStyle((CellStyle)style);
        header.createCell(22).setCellValue("Guardian's Last Name");
        header.getCell(22).setCellStyle((CellStyle)style);
        header.createCell(23).setCellValue("Reference1 First Name");
        header.getCell(23).setCellStyle((CellStyle)style);
        header.createCell(24).setCellValue("Reference1 Last Name");
        header.getCell(24).setCellStyle((CellStyle)style);
        header.createCell(25).setCellValue("Reference1 E-Mail");
        header.getCell(25).setCellStyle((CellStyle)style);
        header.createCell(26).setCellValue("Reference1 Mobile No");
        header.getCell(26).setCellStyle((CellStyle)style);
        header.createCell(27).setCellValue("Reference1 Address Line 1");
        header.getCell(27).setCellStyle((CellStyle)style);
        header.createCell(28).setCellValue("Reference1 Address Line 2");
        header.getCell(28).setCellStyle((CellStyle)style);
        header.createCell(29).setCellValue("Reference1 Country");
        header.getCell(29).setCellStyle((CellStyle)style);
        header.createCell(30).setCellValue("Reference1 PIN (ZIP) code");
        header.getCell(30).setCellStyle((CellStyle)style);
        header.createCell(31).setCellValue("Reference2 First Name");
        header.getCell(31).setCellStyle((CellStyle)style);
        header.createCell(32).setCellValue("Reference2 Last Name");
        header.getCell(32).setCellStyle((CellStyle)style);
        header.createCell(33).setCellValue("Reference2 E-Mail");
        header.getCell(33).setCellStyle((CellStyle)style);
        header.createCell(34).setCellValue("Reference2 Mobile No");
        header.getCell(34).setCellStyle((CellStyle)style);
        header.createCell(35).setCellValue("Reference2 Address Line 1");
        header.getCell(35).setCellStyle((CellStyle)style);
        header.createCell(36).setCellValue("Reference2 Address Line 2");
        header.getCell(36).setCellStyle((CellStyle)style);
        header.createCell(37).setCellValue("Reference2 Country");
        header.getCell(37).setCellStyle((CellStyle)style);
        header.createCell(38).setCellValue("Reference2 PIN (ZIP) code");
        header.getCell(38).setCellStyle((CellStyle)style);
        header.createCell(39).setCellValue("How did you hear about us");
        header.getCell(39).setCellStyle((CellStyle)style);
        header.createCell(40).setCellValue("Applicant Address Line 1 *");
        header.getCell(40).setCellStyle((CellStyle)style);
        header.createCell(41).setCellValue("Applicant Address Line 2 *");
        header.getCell(41).setCellStyle((CellStyle)style);
        header.createCell(42).setCellValue("Applicant Mobile Number *");
        header.getCell(42).setCellStyle((CellStyle)style);
        header.createCell(43).setCellValue("Applicant E-Mail *");
        header.getCell(43).setCellStyle((CellStyle)style);
        header.createCell(44).setCellValue("Applicant Country *");
        header.getCell(44).setCellStyle((CellStyle)style);
        header.createCell(45).setCellValue("Applicant State *");
        header.getCell(45).setCellStyle((CellStyle)style);
        header.createCell(46).setCellValue("Applicant City *");
        header.getCell(46).setCellStyle((CellStyle)style);
        header.createCell(47).setCellValue("Applicant Post Code *");
        header.getCell(47).setCellStyle((CellStyle)style);
        header.createCell(48).setCellValue("Education Level *");
        header.getCell(48).setCellStyle((CellStyle)style);
        header.createCell(49).setCellValue("Name of Degree/Course *");
        header.getCell(49).setCellStyle((CellStyle)style);
        header.createCell(50).setCellValue("Board And University Name *");
        header.getCell(50).setCellStyle((CellStyle)style);
        header.createCell(51).setCellValue("Institution Name *");
        header.getCell(51).setCellStyle((CellStyle)style);
        header.createCell(52).setCellValue("Country *");
        header.getCell(52).setCellStyle((CellStyle)style);
        header.createCell(53).setCellValue("State *");
        header.getCell(53).setCellStyle((CellStyle)style);
        header.createCell(54).setCellValue("City *");
        header.getCell(54).setCellStyle((CellStyle)style);
        header.createCell(55).setCellValue("Academic Start Date *");
        header.getCell(55).setCellStyle((CellStyle)style);
        header.createCell(56).setCellValue("Academic End Date *");
        header.getCell(56).setCellStyle((CellStyle)style);
        header.createCell(57).setCellValue("Year Of Passing *");
        header.getCell(57).setCellStyle((CellStyle)style);
        header.createCell(58).setCellValue("Marks Type *");
        header.getCell(58).setCellStyle((CellStyle)style);
        header.createCell(59).setCellValue("(OverAll) Marks Obtained *");
        header.getCell(59).setCellStyle((CellStyle)style);
        header.createCell(60).setCellValue("Subject1 * (Optional for LKG and UKG)");
        header.getCell(60).setCellStyle((CellStyle)style);
        header.createCell(61).setCellValue("Subject2 * (Optional for LKG and UKG)");
        header.getCell(61).setCellStyle((CellStyle)style);
        header.createCell(62).setCellValue("Subject3 * (Optional for LKG and UKG)");
        header.getCell(62).setCellStyle((CellStyle)style);
        header.createCell(63).setCellValue("Subject4 * (Optional for LKG and UKG)");
        header.getCell(63).setCellStyle((CellStyle)style);
        header.createCell(64).setCellValue("Registration Number *");
        header.getCell(64).setCellStyle((CellStyle)style);
        header.createCell(65).setCellValue("Certificate Number");
        header.getCell(65).setCellStyle((CellStyle)style);
        header.createCell(66).setCellValue("Applying For Class *");
        header.getCell(66).setCellStyle((CellStyle)style);
        header.createCell(67).setCellValue("Enter Admission Code  *");
        header.getCell(67).setCellStyle((CellStyle)style);
    }
}
