package com.example.first.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseMessageDto<T> {
    private final String message;
    private final T data;
    public ResponseMessageDto(String message, T data){
        this.message = message;
        this.data = data;
    }
}
