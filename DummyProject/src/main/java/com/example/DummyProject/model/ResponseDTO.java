package com.example.DummyProject.model;

import lombok.Data;

@Data
public class ResponseDTO {

    private int responseCode;
    private Object responseObject;
    private String message;
}
