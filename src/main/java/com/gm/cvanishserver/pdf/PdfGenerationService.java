package com.gm.cvanishserver.pdf;

import com.gm.cvanishserver.dto.IncomingDTO;
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.action.PdfAction;
import com.itextpdf.kernel.pdf.canvas.draw.SolidLine;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.LineSeparator;
import com.itextpdf.layout.element.Link;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PdfGenerationService {
    private static PdfFont HELVETICA;
    private static PdfFont HELVETICA_BOLD;
    private static final int REGULAR_FONT_SIZE = 12;
    private static final int HEADER_FONT_SIZE = 16;
    private static final int NAME_FONT_SIZE = 32;

    private void setFonts() {
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
        document.add(new Paragraph("Phone number: " + incomingDTO.getPhone() + " | Email: " + incomingDTO.getEmail())
                .setTextAlignment(TextAlignment.CENTER));

        addName(incomingDTO.getFirstName(), incomingDTO.getLastName(), document);

        document.add(new Paragraph(incomingDTO.getSummary()).setTextAlignment(TextAlignment.JUSTIFIED));

        addHeader("Experience:", document);
        addExperiences(incomingDTO.getExperiences(), document);

        addHeader("Projects:", document);
        addProjects(incomingDTO.getProjects(), document);

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

    private void addName(String firstName, String lastName, Document document) throws IOException {
        document.setFont(PdfFontFactory.createFont(StandardFonts.TIMES_BOLD));
        document.setFontSize(NAME_FONT_SIZE);
        document.add(new Paragraph(firstName + " " + lastName).setTextAlignment(TextAlignment.CENTER));
        SolidLine line = new SolidLine(1f);
        LineSeparator ls = new LineSeparator(line);
        document.add(ls);
        document.add(new Paragraph().setMarginBottom(20));
        document.setFont(HELVETICA);
        document.setFontSize(REGULAR_FONT_SIZE);
    }

    private void addHeader(String header, Document document) {
        document.setFont(HELVETICA_BOLD);
        document.setFontSize(HEADER_FONT_SIZE);
        document.add(new Paragraph(header));
        document.setFont(HELVETICA);
        document.setFontSize(REGULAR_FONT_SIZE);
    }

    private void addProjects(List<Map<String, Object>> projects, Document document) {
        for (Map<String, Object> project : projects) {
            List<Map<String, String>> projectLinks = (List<Map<String, String>>) project.get("links");
            List<Paragraph> linkParagraphs = new ArrayList<>();
            for (Map<String, String> projectLink : projectLinks) {
                linkParagraphs.add(new Paragraph(projectLink.get("name")));
                linkParagraphs.add(new Paragraph(new Link(projectLink.get("url"), PdfAction.createURI(projectLink.get("url"))).setFontColor(ColorConstants.BLUE)));
            }

            document.add(new Paragraph(project.get("title") + ", " + project.get("sinceYear") + ", " + project.get("toYear")));
            document.add(new Paragraph((String) project.get("description")).setTextAlignment(TextAlignment.JUSTIFIED));
            for (Paragraph linkParagraph : linkParagraphs) {
                document.add(linkParagraph);
            }
        }
    }

    private void addExperiences(List<Map<String, String>> experiences, Document document) {
        for (Map<String, String> experience : experiences) {
            Text companyText = new Text("\n" + experience.get("company") + ", " + experience.get("city") + ", " + experience.get("country") + " (" + experience.get("sinceDate") + " – " + (StringUtils.isEmpty(experience.get("toDate")) ? "Present" : experience.get("toDate")) + ")").setFont(HELVETICA);
            document.add(new Paragraph(experience.get("role")).setFont(HELVETICA_BOLD).add(companyText));
        }
    }

    private void addEducations(List<Map<String, String>> educations, Document document) {
        for (Map<String, String> education : educations) {
            Text universityText = new Text("\n" + education.get("university") + ", " + education.get("city") + ", " + education.get("country") + " (" + education.get("sinceDate") + " – " + (StringUtils.isEmpty(education.get("toDate")) ? "Present" : education.get("toDate")) + ")").setFont(HELVETICA);
            document.add(new Paragraph(education.get("fieldOfStudy") + ", " + education.get("level")).setFont(HELVETICA_BOLD).add(universityText));
        }
    }

    private void addLinks(List<String> links, Document document) {
        for (String link : links) {
            document.add(new Paragraph(new Link(link, PdfAction.createURI(link))).setFontColor(ColorConstants.BLUE));
        }
    }
}
