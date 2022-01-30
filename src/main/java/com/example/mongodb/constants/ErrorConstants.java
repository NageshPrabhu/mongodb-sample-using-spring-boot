package com.example.mongodb.constants;

import com.example.mongodb.dto.ResultInfo;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorConstants {


    public static final String GENERAL_ERROR_MESSAGE = "Something is went wrong. Please try after sometime";
    public static final ResultInfo GENERAL_EXCEPTION = new ResultInfo(ErrorCodes.GENERAL_ERROR_CODE, GENERAL_ERROR_MESSAGE);
}
