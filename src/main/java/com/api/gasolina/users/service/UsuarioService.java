package com.api.gasolina.users.service;

import com.api.gasolina.users.dto.UsuarioDTO;
import com.api.gasolina.users.dto.UsuarioLoginDTO;

import java.util.List;

public interface UsuarioService {

    /**
     *
     * @param token
     */
    UsuarioDTO validateToken(String token);

    /**
     *
     * @param user
     * @return UsuarioDTO
     */
    UsuarioDTO login(UsuarioLoginDTO user);

}
