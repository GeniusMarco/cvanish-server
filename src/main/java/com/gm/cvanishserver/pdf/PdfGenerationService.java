package com.gm.cvanishserver.pdf;

import com.gm.cvanishserver.model.DataField;
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class PdfGenerationService {
    private static  PdfFont HELVETICA;
    private static  PdfFont HELVETICA_BOLD;
    private static final int REGULAR_FONT_SIZE = 12;
    private static final int HEADER_FONT_SIZE = 16;

    private void setFonts(){
        try {
            HELVETICA = PdfFontFactory.createFont(StandardFonts.HELVETICA);
            HELVETICA_BOLD = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
        } catch (IOException e) {
            throw new IORuntimeException(e);
        }
    }

    public byte[] generate(Map<String, Object> data) throws IOException {
        setFonts();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PdfDocument pdfDocument = new PdfDocument(new PdfWriter(byteArrayOutputStream));
        Document document = new Document(pdfDocument);
        addHeader(data.get(DataField.FIRST_NAME.getKey()) + " " + data.get(DataField.LAST_NAME.getKey()), document);
        addHeader(DataField.EXPERIENCE.getHeader(), document);
        addExperiences((List<Map<String, String>>) data.get(DataField.EXPERIENCE.getKey()), document);
        for (String key : data.keySet()) {
            if (key.equals(DataField.EXPERIENCE.getKey()) || key.equals(DataField.FIRST_NAME.getKey()) || key.equals(DataField.LAST_NAME.getKey())) {
                continue;
            }
            document.add(new Paragraph(key));
            document.add(new Paragraph(data.get(key).toString()));
        }
        document.close();
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    private void addExperiences(List<Map<String, String>> experiences, Document document) {
        for (Map<String, String> experience : experiences) {
            document.add(new Paragraph(experience.get("role") + ", " + experience.get("company") + ", " + experience.get("city") + ", " + experience.get("country") + ", " + experience.get("sinceDate") + ", " + experience.get("toDate")));
        }
    }

    private void addHeader(String header, Document document) {
        document.setFont(HELVETICA_BOLD);
        document.setFontSize(HEADER_FONT_SIZE);
        document.add(new Paragraph(header));
        document.setFont(HELVETICA);
        document.setFontSize(REGULAR_FONT_SIZE);
    }
}
