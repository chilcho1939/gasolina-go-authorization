package com.api.gasolina.users.exception.common;

import com.api.gasolina.users.exception.GasolinaGoException;

public class BadRequestException extends GasolinaGoException {

    public BadRequestException() {}

    public BadRequestException(String mensaje) {
        super(mensaje);
    }

    public BadRequestException(String mensaje, Throwable cause) {
        super(mensaje, cause);
    }

    public BadRequestException(Throwable cause) {
        super(cause);
    }
}
