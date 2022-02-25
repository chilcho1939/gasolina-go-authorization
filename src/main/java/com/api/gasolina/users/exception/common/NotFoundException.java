package com.api.gasolina.users.exception.common;

import com.api.gasolina.users.exception.GasolinaGoException;

public class NotFoundException extends GasolinaGoException {

    public NotFoundException() {}

    public NotFoundException(String mensaje) {
        super(mensaje);
    }

    public NotFoundException(String mensaje, Throwable cause) {
        super(mensaje, cause);
    }

    public NotFoundException(Throwable cause) {
        super(cause);
    }
}
