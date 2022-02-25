package com.api.gasolina.users.controller;

import com.api.gasolina.users.controller.dto.GenericResponse;
import com.api.gasolina.users.dto.ApiResponseDTO;
import com.api.gasolina.users.dto.UsuarioLoginDTO;
import com.api.gasolina.users.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UsuarioController extends GenericResponse {

    private UsuarioService usuarioService;

    @GetMapping("/validate-token")
    public ApiResponseDTO<?> validateToken(@RequestParam(name = "token") String token){
        return createSuccessResponse(usuarioService.validateToken(token));
    }

    @GetMapping("/login")
    public ApiResponseDTO<?> login(@RequestBody UsuarioLoginDTO usuario){
        return createSuccessResponse(usuarioService.login(usuario));
    }
}
