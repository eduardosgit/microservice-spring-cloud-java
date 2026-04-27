package br.com.estudo.springservice.exception;

import java.time.LocalDateTime;

public record ErrorResponse(
        int status,
        String errors,
        String message,
        String path,
        LocalDateTime timestamp
) {}
