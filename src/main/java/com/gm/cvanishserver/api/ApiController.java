package com.gm.cvanishserver.api;

import com.gm.cvanishserver.dto.FormDTO;
import com.gm.cvanishserver.pdf.PdfGenerationService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/api")
public class ApiController {
    private static final Logger logger = LoggerFactory.getLogger(ApiController.class);

    private final PdfGenerationService pdfGenerationService;

    public ApiController(PdfGenerationService pdfGenerationService) {
        this.pdfGenerationService = pdfGenerationService;
    }

    @PostMapping(value = "/data", consumes = "application/json", produces = "application/pdf")
    public byte[] receiveData(@RequestBody FormDTO formDTO) throws IOException {
        logger.info("Received: " + formDTO);
        byte[] result = pdfGenerationService.transformToPdf(formDTO);
        logger.info("Produced PDF of size: " + result.length);
        return result;
    }
}
