package com.example.mongodb.exception.handler;


import com.example.mongodb.constants.ErrorCodes;
import com.example.mongodb.constants.ErrorConstants;
import com.example.mongodb.dto.GenericServerResponse;
import com.example.mongodb.exception.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;


@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Generic Exception Handler
     * @param response
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<GenericServerResponse> generalException(final HttpServletResponse response, Exception ex) {
        GenericServerResponse genericServerResponse = GenericServerResponse.builder()
                .code(ErrorCodes.GENERAL_ERROR_CODE).message(ErrorConstants.GENERAL_ERROR_MESSAGE)
                .build();
        return new ResponseEntity<>(genericServerResponse, null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Exception Handler for Custom exception
     * @param response
     * @param ex
     * @return
     */
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<GenericServerResponse> customException(final HttpServletResponse response, CustomException ex) {
        GenericServerResponse genericServerResponse = GenericServerResponse.builder()
                .code(ex.getResultInfo().getCode()).message(ex.getResultInfo().getMessage())
                .build();
        return new ResponseEntity<>(genericServerResponse, null, ex.getHttpStatus());
    }

    /**
     * Exception handler for Invalid, empty or null values in Request fields.
     * @param response
     * @param ex
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<GenericServerResponse> handleMethodArgumentNotValidException(
            final HttpServletResponse response, MethodArgumentNotValidException ex) {
        List<String> errorMsg =
                ex.getBindingResult().getFieldErrors().stream().map(FieldError::getField).collect(Collectors.toList());
        String message = String.join(",", errorMsg) + " must Not be null";
        GenericServerResponse serverResponse =
                new GenericServerResponse(ErrorCodes.MISSING_REQUEST_BODY_FIELD, message, null);
        return new ResponseEntity<>(serverResponse, HttpStatus.BAD_REQUEST);
    }

}
