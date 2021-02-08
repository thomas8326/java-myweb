package com.MyWebsite.Entities;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseContent<T> {
    private T data;
    private String message;

    public ResponseContent() { this(null, null); }

    public ResponseContent(String message) {
        this(message, null);
    }

    public ResponseContent(T data) {
        this(null, data);
    }


    public ResponseContent(String message, T data) {
        this.message = message;
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
