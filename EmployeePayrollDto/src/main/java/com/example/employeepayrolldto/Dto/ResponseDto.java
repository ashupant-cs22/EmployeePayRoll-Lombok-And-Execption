package com.example.employeepayrolldto.Dto;

import lombok.Data;

@Data
public class ResponseDto {

    private String message;
    private Object data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ResponseDto(String message, Object data) {
        this.message = message;
        this.data = data;
    }

}

