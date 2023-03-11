package com.marius.lt.ChessClubRegistration.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
public class ErrorDetails {

    private LocalDateTime timestamp;
    private String message;
    private Map<String, String> details;

    public ErrorDetails(String message) {
        this.timestamp = LocalDateTime.now();
        this.message = message;
    }

    public ErrorDetails(String message, Map<String, String> details) {
        this.timestamp = LocalDateTime.now();
        this.message = message;
        this.details = details;
    }
}
