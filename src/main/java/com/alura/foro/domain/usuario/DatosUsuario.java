package com.alura.foro.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DatosUsuario(
    @NotBlank String nombre,
    @Email @NotBlank String email
) {
    
}
