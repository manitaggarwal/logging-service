package com.manitaggarwal.store.log.service;

import com.manitaggarwal.store.log.controller.request.LoggingRequest;
import com.manitaggarwal.store.log.document.LogFile;
import com.manitaggarwal.store.log.repository.LoggingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class LoggingServiceImpl implements LoggingService {

    private final LoggingRepository loggingRepository;
    private final MongoTemplate mongoTemplate;

    @Override
    public ResponseEntity<?> saveLogs(LoggingRequest<?> request) {
        try {
            mongoTemplate.save(new LogFile<>(new Date(), request), request.getApplicationName());
            return ResponseEntity.ok("Success");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok("Failure");
        }
    }
}
