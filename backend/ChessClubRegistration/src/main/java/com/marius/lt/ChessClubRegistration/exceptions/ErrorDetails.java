package com.marius.lt.ChessClubRegistration.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class ErrorDetails {

    private LocalDateTime timestamp;
    private String message;
    private int status;
    private List<String> details;

    public ErrorDetails(String message, int status) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.message = message;
    }

    public ErrorDetails(String message, List<String> details, int status) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.message = message;
        this.details = details;
    }
}
