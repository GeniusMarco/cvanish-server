package com.gm.cvanishserver.pdf;

import com.gm.cvanishserver.dto.IncomingDTO;
import com.itextpdf.html2pdf.HtmlConverter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class PdfGenerationService {

    final HtmlTemplateService htmlTemplateService;

    public PdfGenerationService(HtmlTemplateService htmlTemplateService) {
        this.htmlTemplateService = htmlTemplateService;
    }

    public byte[] transformToPdf(IncomingDTO incomingDTO) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        HtmlConverter.convertToPdf(htmlTemplateService.fillTemplate(incomingDTO), byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

}
