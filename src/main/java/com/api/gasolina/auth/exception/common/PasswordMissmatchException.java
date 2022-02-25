package com.api.gasolina.auth.exception.common;

import com.api.gasolina.auth.exception.GasolinaGoException;

public class PasswordMissmatchException extends GasolinaGoException {

    public PasswordMissmatchException() {}

    public PasswordMissmatchException(String mensaje) {
        super(mensaje);
    }

    public PasswordMissmatchException(String mensaje, Throwable cause) {
        super(mensaje, cause);
    }

    public PasswordMissmatchException(Throwable cause) {
        super(cause);
    }
}
