package com.example.mongodb.util;

import com.example.mongodb.constants.ApplicationConstants;
import com.example.mongodb.dto.GenericServerResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CommonUtils {

    /**
     * Common Method to generate success server response
     *
     * @param responseObject
     * @param headers
     * @param <T>
     * @return
     */
    public <T> ResponseEntity<GenericServerResponse> getGenericSuccessResponse(T responseObject, HttpHeaders headers) {
        GenericServerResponse genericServerResponse = GenericServerResponse.builder()
                .code(ApplicationConstants.SUCCESS_CODE)
                .message(ApplicationConstants.SUCCESS_MESSAGE).data(responseObject)
                .build();
        return new ResponseEntity<>(genericServerResponse, headers, HttpStatus.OK);
    }
}
