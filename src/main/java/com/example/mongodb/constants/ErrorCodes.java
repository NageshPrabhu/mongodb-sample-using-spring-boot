package com.example.mongodb.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorCodes {

    public static final Integer GENERAL_ERROR_CODE = -1001;
    public static final Integer MISSING_REQUEST_BODY_FIELD = -1002;
}
