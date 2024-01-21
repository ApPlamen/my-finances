package com.myfinances.apigateway.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.server.ServerWebExchange;

import java.time.OffsetDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice
public class DomainExceptionHandler {
    private final Logger LOGGER = LoggerFactory.getLogger(DomainExceptionHandler.class);

    @ExceptionHandler(WebExchangeBindException.class)
    public ResponseEntity<GenericErrorResponse> handleBindingExceptions(WebExchangeBindException exc, ServerWebExchange exchange) {
        LOGGER.error(exc.getMessage());

        HttpStatus status = HttpStatus.BAD_REQUEST;

        GenericErrorResponse errorResponse = GenericErrorResponse.builder()
                .message(getValidationErrorMessages(exc))
                .status(status)
                .path(exchange.getRequest().getPath().value())
                .timestamp(OffsetDateTime.now())
                .build();

        return ResponseEntity
                .status(status)
                .body(errorResponse);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<GenericErrorResponse> handleBindingExceptions(RuntimeException ex) {
        LOGGER.error(ex.getMessage());

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        GenericErrorResponse errorResponse = GenericErrorResponse.builder()
                .message(ex.getMessage())
                .status(status)
                .timestamp(OffsetDateTime.now())
                .build();

        return ResponseEntity
                .status(status)
                .body(errorResponse);
    }

    private String getValidationErrorMessages(WebExchangeBindException exc) {
        return exc.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining(" "));
    }
}