package com.proyectoFinal.ForoHUB.domain.usuarios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface usuarioRepository extends JpaRepository<Usuarios,Long> {
    UserDetails findByLogin(String username);
}
