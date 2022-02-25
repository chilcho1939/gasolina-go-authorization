package com.api.gasolina.auth.service;

import com.api.gasolina.auth.dto.UsuarioDTO;
import com.api.gasolina.auth.dto.UsuarioLoginDTO;

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
