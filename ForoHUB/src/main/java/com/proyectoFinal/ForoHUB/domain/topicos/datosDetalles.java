package com.proyectoFinal.ForoHUB.domain.topicos;

import java.time.LocalDateTime;

public record datosDetalles(Long id,
                            Long idUsuario,
                            String titulo,
                            String mensaje,
                            String nombreCurso,
                            LocalDateTime fecha
){
    public datosDetalles(Topico topico){
        this(topico.getId(), topico.getAutorx().getId(), topico.getTitulo(), topico.getMensaje(), topico.getNombreCurso(),topico.getFecha());
    }
}
