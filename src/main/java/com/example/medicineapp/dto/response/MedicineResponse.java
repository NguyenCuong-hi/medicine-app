package com.example.medicineapp.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Objects;

@Getter
@Setter
public class MedicineResponse<T> {
    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private final LocalDate timeStamp = LocalDate.now();
    private int code;
    private String message;
    private T data;
    private int total;

    public MedicineResponse() {
    }

    public static <T> MedicineResponse<T> build(int code, String urlMessage, Objects arg) {
        MedicineResponse<T> response = new MedicineResponse<>();
        response.code = code;
        response.message = urlMessage;
        return response;
    }

    public static <T> MedicineResponse<T> build(T data) {
        MedicineResponse<T> medicineResponse = new MedicineResponse<>();
        medicineResponse.data = data;
        medicineResponse.code = HttpStatus.OK.value();
        medicineResponse.message = HttpStatus.OK.name();
        if (data instanceof Collection) {
            medicineResponse.total = ((Collection) data).size();
        }
        return medicineResponse;
    }

    public static <T> MedicineResponse<T> buildMsg (int code, String message){
        MedicineResponse<T> medicineResponse = new MedicineResponse<>();
        medicineResponse.code = code;
        medicineResponse.message = message;
        return medicineResponse;
    }
}
