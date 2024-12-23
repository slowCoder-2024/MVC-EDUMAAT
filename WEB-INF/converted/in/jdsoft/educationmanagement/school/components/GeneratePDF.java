/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.xhtmlrenderer.pdf.ITextRenderer
 */
package in.jdsoft.educationmanagement.school.components;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.xhtmlrenderer.pdf.ITextRenderer;

public class GeneratePDF {
    public static void generatePDF(String inputHtmlPath, String outputPdfPath) throws Exception {
        try {
            String url = new File(inputHtmlPath).toURI().toURL().toString();
            System.out.println("URL: " + url);
            FileOutputStream out = new FileOutputStream(outputPdfPath);
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocument(url);
            renderer.layout();
            renderer.getDocument();
            ((OutputStream)out).close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        String inputFile = "F:/JD-0039/Template/selected/janux/form.html";
        String outputFile = "F:/JD-0039/Template/selected/janux/form.pdf";
        GeneratePDF.generatePDF(inputFile, outputFile);
        System.out.println("Done!");
    }
}
