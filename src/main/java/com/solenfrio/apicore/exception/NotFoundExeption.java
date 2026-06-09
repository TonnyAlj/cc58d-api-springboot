package com.solenfrio.apicore.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NotFoundExeption extends RuntimeException {

    private String message;
    private String detail;

    public NotFoundExeption(String message) {
        this.message = message;
    }

}
