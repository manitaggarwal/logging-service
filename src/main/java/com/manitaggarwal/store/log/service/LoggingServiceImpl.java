package com.manitaggarwal.store.log.service;

import com.manitaggarwal.store.log.controller.request.LoggingRequest;
import com.manitaggarwal.store.log.document.LogFile;
import com.manitaggarwal.store.log.repository.LoggingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class LoggingServiceImpl implements LoggingService {

    private final LoggingRepository loggingRepository;

    @Override
    public void saveLogs(LoggingRequest<?> request) {
        try {
            loggingRepository.save(new LogFile<>(new Date(), request));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
