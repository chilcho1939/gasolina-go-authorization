package com.api.gasolina.auth.controller;

import com.api.gasolina.auth.controller.dto.GenericResponse;
import com.api.gasolina.auth.dto.ApiResponseDTO;
import com.api.gasolina.auth.dto.UsuarioLoginDTO;
import com.api.gasolina.auth.service.UsuarioService;
import com.api.gasolina.auth.service.impl.UsuarioServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UsuarioController extends GenericResponse {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @PostMapping("/validate-token")
    public ApiResponseDTO<?> validateToken(@RequestParam(name = "token") String token){
        return createSuccessResponse(usuarioService.validateToken(token));
    }

    @PostMapping("/login")
    public ApiResponseDTO<?> login(@RequestBody UsuarioLoginDTO usuario){
        return createSuccessResponse(usuarioService.login(usuario));
    }
}
