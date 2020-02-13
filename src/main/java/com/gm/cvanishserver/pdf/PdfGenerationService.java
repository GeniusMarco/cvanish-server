package com.gm.cvanishserver.pdf;

import com.gm.cvanishserver.dto.IncomingDTO;
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.action.PdfAction;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Link;
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

    public byte[] generate(IncomingDTO incomingDTO) throws IOException {
        setFonts();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PdfDocument pdfDocument = new PdfDocument(new PdfWriter(byteArrayOutputStream));
        Document document = new Document(pdfDocument);

        addHeader(incomingDTO.getFirstName() + " " + incomingDTO.getLastName(), document);

        addHeader("Phone number:", document);
        document.add(new Paragraph(incomingDTO.getPhone()));

        addHeader("Email address:", document);
        document.add(new Paragraph(incomingDTO.getEmail()));

        addHeader("Summary:", document);
        document.add(new Paragraph(incomingDTO.getSummary()));

        addHeader("Experience:", document);
        addExperiences(incomingDTO.getExperiences(), document);

        addHeader("Education:", document);
        addEducations(incomingDTO.getEducations(), document);

        addHeader("Skills:", document);
        document.add(new Paragraph(incomingDTO.getSkills()));

        addHeader("Links:", document);
        addLinks(incomingDTO.getLinks(), document);

        document.close();
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    private void addExperiences(List<Map<String, String>> experiences, Document document) {
        for (Map<String, String> experience : experiences) {
            document.add(new Paragraph(experience.get("role") + ", " + experience.get("company") + ", " + experience.get("city") + ", " + experience.get("country") + ", " + experience.get("sinceDate") + ", " + experience.get("toDate")));
        }
    }

    private void addEducations(List<Map<String, String>> educations, Document document) {
        for (Map<String, String> education : educations) {
            document.add(new Paragraph(education.get("fieldOfStudy") + ", " + education.get("level") + ", " + education.get("university") + ", " + education.get("city") + ", " + education.get("country") + ", " + education.get("sinceDate") + ", " + education.get("toDate")));
        }
    }

    private void addLinks(List<String> links, Document document) {
        for (String link : links) {
            document.add(new Paragraph(new Link(link, PdfAction.createURI(link))).setFontColor(ColorConstants.BLUE));
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
