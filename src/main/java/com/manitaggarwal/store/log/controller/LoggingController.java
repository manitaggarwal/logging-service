package com.manitaggarwal.store.log.controller;

import com.manitaggarwal.store.log.controller.request.LoggingRequest;
import com.manitaggarwal.store.log.document.LogFile;
import com.manitaggarwal.store.log.service.LoggingService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping(path = "/v1/api")
@RequiredArgsConstructor
public class LoggingController {

    private final LoggingService loggingService;

    @PostMapping(value = "/logs", consumes = "application/json", produces = "text/plain")
    public void addLogs(@RequestBody LoggingRequest<?> request) {
        loggingService.saveLogs(request);
    }

    @KafkaListener(topics = "logging", groupId = "logging")
    public void saveLogs(LoggingRequest<?> request) {
        loggingService.saveLogs(request);
    }
}