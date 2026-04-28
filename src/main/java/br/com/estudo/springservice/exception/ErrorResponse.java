package br.com.estudo.springservice.exception;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.Map;

public record ErrorResponse(
        int status,
        String errors,
        String message,
        String path,
        LocalDateTime timestamp,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        Map<String, String>fieldErrors
) {}
