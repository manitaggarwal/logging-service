package com.manitaggarwal.store.log.service;

import com.manitaggarwal.store.log.controller.request.LoggingRequest;

public interface LoggingService {
    void saveLogs(LoggingRequest<?> request);
}
