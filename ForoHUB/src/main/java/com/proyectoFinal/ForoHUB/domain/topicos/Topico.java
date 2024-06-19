package com.proyectoFinal.ForoHUB.domain.topicos;

import com.proyectoFinal.ForoHUB.domain.usuarios.Usuarios;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fecha;
    @Enumerated(EnumType.STRING)
    private Estado status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="autorx_id")
    private Usuarios autorx;

    private String nombreCurso;

    public Topico(
            String titulo,
            String mensaje,
            Estado status,
            Usuarios autorx,
            String nombreCurso
    ){
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.status = status;
        this.autorx = autorx;
        this.nombreCurso = nombreCurso;
        this.fecha=LocalDateTime.now();

    }

    public Long getId() {
        return id;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getMensaje() {
        return mensaje;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }
    public Estado getStatus() {
        return status;
    }

    public Usuarios getAutorx() {
        return autorx;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void actualizarDatos(datosActualizar datosActualizarTopico) {
        if(datosActualizarTopico.titulo()!=null){
            this.titulo = datosActualizarTopico.titulo();
        }
        if(datosActualizarTopico.mensaje()!=null){
            this.mensaje = datosActualizarTopico.mensaje();
        }
        if(datosActualizarTopico.nombreCurso()!=null){
            this.nombreCurso = datosActualizarTopico.nombreCurso();
        }
    }
}

