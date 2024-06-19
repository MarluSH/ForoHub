package com.proyectoFinal.ForoHUB.domain.topicos;

import com.proyectoFinal.ForoHUB.infra.errores.validacionDeIntegridad;
import com.proyectoFinal.ForoHUB.domain.topicos.validaciones.validadorTopicos;

import com.proyectoFinal.ForoHUB.domain.usuarios.usuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class topicoService {
    @Autowired
    private topicoRepository topicoRepository;
    @Autowired
    private usuarioRepository usuarioRepository;

    List<validadorTopicos> validadores;

    public datosDetalles crear(datosCrear datos){
        if(datos.idUsuario()!=null&&!usuarioRepository.existsById(datos.idUsuario())){
            throw new validacionDeIntegridad("Id de usuario no encontrado");
        }
        validadores.forEach(v->v.validar(datos));
        var usuario = usuarioRepository.findById(datos.idUsuario()).get();
        var topico = new Topico(
                datos.titulo(),
                datos.mensaje(),
                datos.status(),
                usuario,
                datos.nombreCurso()
        );
        topicoRepository.save(topico);
        return new datosDetalles(topico);
    }

}
