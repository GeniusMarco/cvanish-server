package com.gm.cvanishserver.api;

import com.gm.cvanishserver.dto.FormDTO;
import com.gm.cvanishserver.pdf.PdfGenerationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.IOException;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_PDF_VALUE;

@Slf4j
@RestController
public class ApiController {
    private final PdfGenerationService pdfGenerationService;

    public ApiController(PdfGenerationService pdfGenerationService) {
        this.pdfGenerationService = pdfGenerationService;
    }

    @PostMapping(value = "/generate", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_PDF_VALUE)
    public byte[] receiveData(@RequestBody @Valid FormDTO formDTO) throws IOException {
        log.info("Received: " + formDTO);
        byte[] result = pdfGenerationService.transformToPdf(formDTO);
        log.info("Produced PDF of size: " + result.length);
        return result;
    }
}
