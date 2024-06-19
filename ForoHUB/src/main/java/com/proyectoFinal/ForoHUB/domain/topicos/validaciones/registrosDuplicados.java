package com.proyectoFinal.ForoHUB.domain.topicos.validaciones;

import com.proyectoFinal.ForoHUB.domain.topicos.datosCrear;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.proyectoFinal.ForoHUB.domain.topicos.topicoRepository;

@Component
public class registrosDuplicados {
    @Autowired
    private topicoRepository topicoRepository;

    public void validar(datosCrear datos){
        var titulo = datos.titulo();
        var mensaje = datos.mensaje();

        var registroDuplicado = topicoRepository.existsByTituloAndMensaje(titulo, mensaje);

        if(registroDuplicado){
            throw new ValidationException("Mensaje duplicado en este título");
        }
    }


}
