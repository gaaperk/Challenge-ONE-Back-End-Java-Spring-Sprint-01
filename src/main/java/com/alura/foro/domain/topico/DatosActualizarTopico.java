package com.alura.foro.domain.topico;

// import com.alura.foro.domain.usuario.DatosUsuario;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(
    @NotNull Long id,
    String titulo,
    String mensaje,
    StatusTopico statusTopico,
    String autor,
    Curso curso
) {

}
