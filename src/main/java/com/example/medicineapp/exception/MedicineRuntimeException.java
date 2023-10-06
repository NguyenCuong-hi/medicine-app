package com.example.medicineapp.exception;

import com.example.medicineapp.utilities.I18n;
import org.springframework.http.HttpStatus;

public class MedicineRuntimeException extends RuntimeException {

    protected final int code;
    protected final String message;

    public MedicineRuntimeException(int code, String messageUrl, Object... arg) {
        this.code = code;
        this.message = I18n.get(messageUrl, arg);
    }

    public MedicineRuntimeException(HttpStatus httpStatus, String messageUrl, Object... arg) {
        this.code = httpStatus.value();
        this.message = I18n.get(messageUrl, arg);
    }

    public MedicineRuntimeException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

}
