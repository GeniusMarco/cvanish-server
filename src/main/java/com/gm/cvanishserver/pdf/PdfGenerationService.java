package com.gm.cvanishserver.pdf;

import com.gm.cvanishserver.model.DataFields;
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.font.PdfSimpleFont;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

@Service
public class PdfGenerationService {
    public byte[] generate(Map<String, Object> data) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PdfDocument pdfDocument = new PdfDocument(new PdfWriter(byteArrayOutputStream));
        Document document = new Document(pdfDocument);
        fillWithName(data.get(DataFields.FIRST_NAME).toString(), data.get(DataFields.LAST_NAME).toString(), document);
        for (String key : data.keySet()) {
            if (key.equals(DataFields.FIRST_NAME) || key.equals(DataFields.LAST_NAME)) {
                continue;
            }
            document.add(new Paragraph(key));
            document.add(new Paragraph(data.get(key).toString()));
        }
        document.close();
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    private void fillWithName(String firstName, String lastName, Document document) throws IOException {
        document.setFontSize(16);
        document.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA));
        document.setBold();
        document.add(new Paragraph(firstName + " " + lastName));
    }
}
