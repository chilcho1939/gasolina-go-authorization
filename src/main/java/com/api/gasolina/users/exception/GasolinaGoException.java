package com.api.gasolina.users.exception;

public class GasolinaGoException extends RuntimeException {

    public GasolinaGoException() {}

    public GasolinaGoException(String mensaje) {
        super(mensaje);
    }

    public GasolinaGoException(String mensaje, Throwable cause) {
        super(mensaje, cause);
    }

    public GasolinaGoException(Throwable cause) {
        super(cause);
    }
}
