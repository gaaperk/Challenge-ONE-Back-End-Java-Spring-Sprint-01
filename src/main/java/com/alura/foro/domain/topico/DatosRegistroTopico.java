package com.alura.foro.domain.topico;

import java.time.LocalDateTime;

// import com.alura.foro.domain.usuario.DatosUsuario;

// import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(
    @NotBlank String titulo,
    @NotBlank String mensaje,
    @NotBlank LocalDateTime fecha,
    @NotNull StatusTopico status,
    @NotNull String autor,
    @NotNull Curso curso
    ) {
}
