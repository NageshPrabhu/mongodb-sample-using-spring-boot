package com.example.mongodb.exception;

import com.example.mongodb.dto.ResultInfo;
import org.springframework.http.HttpStatus;

public class UserServiceException extends CustomException {

    public UserServiceException(String errorMessage, Integer errorCode, HttpStatus httpStatus) {
        this.resultInfo = new ResultInfo(errorCode, errorMessage);
        this.httpStatus = httpStatus;
    }
}
