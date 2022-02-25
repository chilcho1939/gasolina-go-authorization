package com.api.gasolina.users.exception.common;

import com.api.gasolina.users.exception.GasolinaGoException;

public class EmptyResultsException extends GasolinaGoException {

    public EmptyResultsException() {}

    public EmptyResultsException(String mensaje) {
        super(mensaje);
    }

    public EmptyResultsException(String mensaje, Throwable cause) {
        super(mensaje, cause);
    }

    public EmptyResultsException(Throwable cause) {
        super(cause);
    }
}
