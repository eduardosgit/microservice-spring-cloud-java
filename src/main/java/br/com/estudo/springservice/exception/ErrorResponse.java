package br.com.estudo.springservice.exception;

import java.util.Date;

public record ErrorResponse(Date timestamp, String message, String details) {
}
