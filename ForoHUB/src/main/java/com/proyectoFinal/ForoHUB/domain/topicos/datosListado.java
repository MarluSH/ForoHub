package com.proyectoFinal.ForoHUB.domain.topicos;

import java.time.LocalDateTime;

public record datosListado(Long id,
                           String titulo,
                           String mensaje,
                           Estado status,
                           String autorx,
                           String nombreCurso,
                           LocalDateTime fecha){
    public datosListado(Topico topico){
        this(topico.getId(),topico.getTitulo(),topico.getMensaje(),topico.getStatus(),topico.getAutorx().getUsername(),topico.getNombreCurso(),topico.getFecha());
    }
}
