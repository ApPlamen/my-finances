package com.myfinances.users.exceptions;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.OffsetDateTime;

@Getter
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class GenericErrorResponse {
    private final HttpStatus status;
    private final String message;
    private final String path;
    private final OffsetDateTime timestamp;
}
