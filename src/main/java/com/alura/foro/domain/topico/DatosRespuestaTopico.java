package com.alura.foro.domain.topico;

import java.time.LocalDateTime;

// import com.alura.foro.domain.usuario.DatosUsuario;
// import com.alura.foro.domain.usuario.Usuario;

public record DatosRespuestaTopico(
    Long id,
    String titulo,
    String mensaje,
    LocalDateTime fecha,
    String status,
    String autor,
    String curso
) {

    // public DatosRespuestaTopico(Topico topico) {
    //     this(topico.getId(),
    //         topico.getTitulo(),
    //         topico.getMensaje(),
    //         topico.getFecha(),
    //         topico.getStatus().toString(),
    //         topico.getAutor(),
    //         topico.getCurso().toString()
    //     );
    // }
    
}
