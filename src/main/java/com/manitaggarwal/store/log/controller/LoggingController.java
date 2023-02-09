package com.manitaggarwal.store.log.controller;

import com.manitaggarwal.store.log.controller.request.LoggingRequest;
import com.manitaggarwal.store.log.document.LogFile;
import com.manitaggarwal.store.log.repository.LoggingRepository;
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

    private final LoggingRepository loggingRepository;

    @PostMapping(value = "/logs", consumes = "application/json", produces = "text/plain")
    public String addLogs(@RequestBody LoggingRequest<?> request) {
        try {
            loggingRepository.save(new LogFile<>(new Date(), request));
            return "Saved logs.";
        } catch (Exception e) {
            return "Unable to save logs.";
        }
    }

    @KafkaListener(topics = "logging", groupId = "logging")
    public void saveLogs(LoggingRequest<?> request) {
        loggingRepository.save(new LogFile<>(new Date(), request));
    }
}