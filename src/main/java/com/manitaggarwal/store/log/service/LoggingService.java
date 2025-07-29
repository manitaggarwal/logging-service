package com.manitaggarwal.store.log.service;

import com.manitaggarwal.store.log.controller.request.LoggingRequest;
import org.springframework.http.ResponseEntity;

public interface LoggingService {
    ResponseEntity<?> saveLogs(LoggingRequest<?> request);
}
