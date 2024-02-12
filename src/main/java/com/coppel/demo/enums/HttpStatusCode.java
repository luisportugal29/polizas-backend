package com.coppel.demo.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum HttpStatusCode {

    OK(200, "OK"),
    CREATED(201, "Created"),
    BAD_REQUEST(400, "Bad Request"),
    NOT_FOUND(404, "Not Found"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error");

    private final Integer value;
    private final String reason;

    public String getReason() {
        return this.reason;
    }

    public int getValue() {
       return this.value;
    }


}
