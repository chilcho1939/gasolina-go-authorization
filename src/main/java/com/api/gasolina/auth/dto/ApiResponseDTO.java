package com.api.gasolina.auth.dto;

public class ApiResponseDTO<T> {

    private Integer code;
    private String message;
    private T result;

    public ApiResponseDTO(Integer codigo, String mensaje) {
        super();
        this.code = codigo;
        this.message = mensaje;
    }

    public ApiResponseDTO(Integer codigo, String mensaje, T resultado) {
        super();
        this.code = codigo;
        this.message = mensaje;
        this.result = resultado;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
