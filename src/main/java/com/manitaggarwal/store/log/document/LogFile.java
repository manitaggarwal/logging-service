package com.manitaggarwal.store.log.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("logfile")
@Data
public class LogFile<T> {

    @Id
    private String id;

    private Date time;

    private T data;

    public LogFile(Date time, T data) {
        this.time = time;
        this.data = data;
    }
}
