package com.manitaggarwal.store.log.repository;

import com.manitaggarwal.store.log.document.LogFile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LoggingRepository extends MongoRepository<LogFile<?>, String> {
}
