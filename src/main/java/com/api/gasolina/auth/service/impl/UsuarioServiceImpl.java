package com.api.gasolina.auth.service.impl;

import com.api.gasolina.auth.domain.Usuario;
import com.api.gasolina.auth.dto.UsuarioDTO;
import com.api.gasolina.auth.dto.UsuarioLoginDTO;
import com.api.gasolina.auth.exception.common.NotFoundException;
import com.api.gasolina.auth.exception.common.PasswordMissmatchException;
import com.api.gasolina.auth.repository.UsuarioRepository;
import com.api.gasolina.auth.service.UsuarioService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.nio.CharBuffer;
import java.util.Base64;
import java.util.Date;

@Slf4j
@Service
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepository usuarioRepository;
    private PasswordEncoder passwordEncoder;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Value("${security.jwt.token.secret-key:secret-key}")
    private String secretKey;

    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    @Override
    public UsuarioDTO validateToken(String token) {
        String user = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
        Usuario usuario = usuarioRepository.getByEmail(user)
                .orElseThrow(() -> new NotFoundException("Usuario no encontrado"));
        UsuarioDTO dto = toDto(usuario);
        dto.setToken(createToken(dto));
        return dto;
    }

    @Override
    public UsuarioDTO login(UsuarioLoginDTO user) {
        Usuario entity = usuarioRepository.getByEmail(user.getEmail())
                .orElseThrow(() -> new NotFoundException("Usuario no encontrado"));

        if(passwordEncoder.matches(CharBuffer.wrap(user.getPassword()), entity.getPassword())) {
            UsuarioDTO dto = toDto(entity);
            dto.setToken(createToken(dto));
            return dto;
        }
        else throw new PasswordMissmatchException("Contrasena incorrecta");

    }

    private String createToken(UsuarioDTO user) {
        Claims claims = Jwts.claims().setSubject(user.getEmail());

        Date now = new Date();
        Date validity = new Date(now.getTime() + 3600000); // 1 hour

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    private UsuarioDTO toDto(Usuario usuario) {
        return new ModelMapper().map(usuario, UsuarioDTO.class);
    }
}
