package com.alura.foro.domain.topico;

public record DatosListadoTopico (
    Long id,
    String titulo,
    String mensaje,
    String fecha,
    String status,
    String autor,
    String curso
) {
    
    public DatosListadoTopico (Topico topico){
        this(
            topico.getId(),
            topico.getTitulo(),
            topico.getMensaje(),
            topico.getFecha().toString(),
            topico.getStatus().toString(),
            topico.getAutor(),
            topico.getCurso().toString()
            );
    }
    
}
