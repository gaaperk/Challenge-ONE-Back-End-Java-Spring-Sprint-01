package com.alura.foro.controller;

import java.net.URI;
// import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.alura.foro.domain.topico.DatosActualizarTopico;
import com.alura.foro.domain.topico.DatosListadoTopico;
import com.alura.foro.domain.topico.DatosRegistroTopico;
import com.alura.foro.domain.topico.DatosRespuestaTopico;
import com.alura.foro.domain.topico.Topico;
import com.alura.foro.domain.topico.TopicoRepository;
// import com.alura.foro.domain.usuario.DatosUsuario;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired  
    private TopicoRepository topicoRepository;
    
    @PostMapping
    public ResponseEntity <DatosRespuestaTopico> registraMedico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico, UriComponentsBuilder uriComponentsBuilder){
        
        Topico topico = topicoRepository.save(new Topico(datosRegistroTopico));

        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFecha(), topico.getStatus().toString(), topico.getAutor(), topico.getCurso().toString());

        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(url).body(datosRespuestaTopico);
    }

    @GetMapping
    public ResponseEntity<Page<Object>> listadoTopicos(@PageableDefault(size=10) Pageable paginacion){
        return ResponseEntity.ok(topicoRepository.findAll(paginacion).map(DatosListadoTopico::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico){
        Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());

        topico.actualizarTopico(datosActualizarTopico);

        return ResponseEntity.ok(new DatosRespuestaTopico(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFecha(), topico.getStatus().toString(), topico.getAutor(), topico.getCurso().toString()));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarTopico(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        topicoRepository.delete(topico);
    }

    @GetMapping("{id}")
    public ResponseEntity<DatosRespuestaTopico> retornarTopico(@PathVariable Long id){

        Topico topico = topicoRepository.getReferenceById(id);
        
        var datosTopico = new DatosRespuestaTopico(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFecha(), topico.getStatus().toString(), topico.getAutor(), topico.getCurso().toString());

        return ResponseEntity.ok(datosTopico);
    }


}
