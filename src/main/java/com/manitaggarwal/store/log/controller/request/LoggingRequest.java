package com.manitaggarwal.store.log.controller.request;

import lombok.Data;

@Data
public class LoggingRequest<T> {
    String applicationName;
    T logs;
}
