package com.gm.cvanishserver.api;

import com.gm.cvanishserver.pdf.PdfGenerationService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

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
    public byte[] receiveData(@RequestBody Map<String, Object> data) throws IOException {
        logger.info("Received: " + data);
        byte[] result = pdfGenerationService.generate(data);
        logger.info("Producing data of size: " + result.length);
        return result;
    }
}
