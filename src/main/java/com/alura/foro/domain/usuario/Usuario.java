package com.alura.foro.domain.usuario;

// import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

	private String nombre;
	private String email;

	public Usuario(DatosUsuario datosUsuario){
		this.nombre = datosUsuario.nombre();
		this.email = datosUsuario.email();
	}

	public Usuario actualizUsuario(DatosUsuario datosUsuario){
		this.nombre = datosUsuario.nombre();
		this.email = datosUsuario.email();
		return this;
	}
}
