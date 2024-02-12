package com.coppel.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDto {

    private Object data;

    private Meta meta;

    @Data
    @AllArgsConstructor
    public static class Meta {
        private String status;
    }
    
}

