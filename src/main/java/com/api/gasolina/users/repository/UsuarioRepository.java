package com.api.gasolina.users.repository;

import com.api.gasolina.users.domain.Usuario;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Long, Usuario> {

    Optional<Usuario> getByEmail(String email);
}
