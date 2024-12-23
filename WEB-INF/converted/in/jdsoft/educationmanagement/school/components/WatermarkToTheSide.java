/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.lowagie.text.DocumentException
 *  com.lowagie.text.Phrase
 *  com.lowagie.text.Rectangle
 *  com.lowagie.text.pdf.ColumnText
 *  com.lowagie.text.pdf.PdfContentByte
 *  com.lowagie.text.pdf.PdfReader
 *  com.lowagie.text.pdf.PdfStamper
 */
package in.jdsoft.educationmanagement.school.components;

import com.lowagie.text.DocumentException;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.ColumnText;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WatermarkToTheSide {
    public static final String SRC = "F:/blank.pdf";
    public static final String DEST = "F:/side_watermark.pdf";

    public static void main(String[] args) throws IOException, DocumentException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new WatermarkToTheSide().manipulatePdf(SRC, DEST);
    }

    public void manipulatePdf(String src, String dest) throws IOException, DocumentException {
        PdfReader reader = new PdfReader(src);
        PdfStamper stamper = new PdfStamper(reader, (OutputStream)new FileOutputStream(dest));
        int n = reader.getNumberOfPages();
        int p = 1;
        while (p <= n) {
            Rectangle pageSize = reader.getPageSizeWithRotation(p);
            float x = pageSize.getLeft();
            float y = (pageSize.getTop() + pageSize.getBottom()) / 2.0f;
            PdfContentByte canvas = stamper.getOverContent(p);
            ColumnText.showTextAligned((PdfContentByte)canvas, (int)4, (Phrase)new Phrase("Arun Balaji"), (float)(x + 18.0f), (float)y, (float)90.0f);
            ColumnText.showTextAligned((PdfContentByte)canvas, (int)4, (Phrase)new Phrase("Aru Balaji"), (float)(x + 34.0f), (float)y, (float)90.0f);
            ++p;
        }
        stamper.close();
    }
}
