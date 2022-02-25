package com.api.gasolina.users.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UsuarioLoginDTO implements Serializable {

    private String email;
    private String password;
}
