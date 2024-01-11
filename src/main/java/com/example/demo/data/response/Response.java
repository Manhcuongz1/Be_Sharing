package com.example.demo.data.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class Response<T> {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean success;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String folder;

    public Response(T data) {
        this.data = data;
    }
    public Response(T data, String message, Boolean success, String folder) {
        this.data = data;
        this.message = message;
        this.success = success;
        this.folder = folder;
    }
    public Response(){}
}
