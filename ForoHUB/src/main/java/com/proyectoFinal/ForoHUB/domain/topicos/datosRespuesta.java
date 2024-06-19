package com.proyectoFinal.ForoHUB.domain.topicos;

import java.time.LocalDateTime;

public record datosRespuesta(Long id,
                             String titulo,
                             String mensaje,
                             Estado status,
                             String autorx,
                             String nombreCurso,
                             LocalDateTime fecha
) {
}
