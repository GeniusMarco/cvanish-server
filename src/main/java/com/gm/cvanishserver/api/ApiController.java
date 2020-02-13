package com.gm.cvanishserver.api;

import com.gm.cvanishserver.dto.IncomingDTO;
import com.gm.cvanishserver.pdf.PdfGenerationService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/api")
public class ApiController {
    private static Logger logger = LoggerFactory.getLogger(ApiController.class);

    private final PdfGenerationService pdfGenerationService;

    public ApiController(PdfGenerationService pdfGenerationService) {
        this.pdfGenerationService = pdfGenerationService;
    }

    @GetMapping()
    public void ping() {
    }

    @PostMapping(value = "/data", consumes = "application/json", produces = "application/pdf")
    public byte[] receiveData(@RequestBody IncomingDTO incomingDto) throws IOException {
        logger.info("Received: " + incomingDto);
        byte[] result = pdfGenerationService.generate(incomingDto);
        logger.info("Producing data of size: " + result.length);
        return result;
    }
}
