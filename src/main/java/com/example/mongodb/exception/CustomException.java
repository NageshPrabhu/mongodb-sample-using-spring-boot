package com.example.mongodb.exception;

import com.example.mongodb.constants.ErrorConstants;
import com.example.mongodb.dto.ResultInfo;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;


@Data
@NoArgsConstructor
public class CustomException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    protected ResultInfo resultInfo = ErrorConstants.GENERAL_EXCEPTION;
    protected HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

    public CustomException(ResultInfo resultInfo, HttpStatus httpStatus) {
        super(resultInfo.getMessage());
        this.resultInfo = resultInfo;
        this.httpStatus = httpStatus;
    }
}
