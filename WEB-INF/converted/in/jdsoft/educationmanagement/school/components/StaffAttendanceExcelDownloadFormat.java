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

public class StaffAttendanceExcelDownloadFormat
extends AbstractExcelView {
    protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/xls");
        response.setHeader("Content-Disposition", "attachment; filename=\"staffAttendanceExcelFormat.xls\"");
        HSSFSheet sheet = workbook.createSheet("staffattendanceexcelsheet");
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
        header.createCell(0).setCellValue("Staff Code*");
        header.getCell(0).setCellStyle((CellStyle)style);
        header.createCell(1).setCellValue("In Time(HH:mm)*");
        header.getCell(1).setCellStyle((CellStyle)style);
        header.createCell(2).setCellValue("Out Time(HH:mm)*");
        header.getCell(2).setCellStyle((CellStyle)style);
        header.createCell(3).setCellValue("Attendance Date(MM/dd/yyyy)*");
        header.getCell(3).setCellStyle((CellStyle)style);
    }
}
