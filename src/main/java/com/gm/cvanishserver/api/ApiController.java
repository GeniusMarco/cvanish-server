package com.gm.cvanishserver.api;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api")
public class ApiController {
    private static Logger logger = LoggerFactory.getLogger(ApiController.class);

    @GetMapping()
    public void ping() {
    }

    @PostMapping(value = "/data", consumes = "application/json")
    public void receiveData(@RequestBody Map<String, String> data) {
        logger.info("Received: " + data);
    }
}
