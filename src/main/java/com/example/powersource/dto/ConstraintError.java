package com.example.powersource.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ConstraintError {
    String error;
    int status;
    String message;
}
