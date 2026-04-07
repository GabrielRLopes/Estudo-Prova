package com.aula.Estudo.Controller;

import com.aula.Estudo.Entity.Evento;
import com.aula.Estudo.Service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/evento")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @PostMapping
    public ResponseEntity<Evento> criarEvento(@RequestBody Evento evento){
        Evento request = eventoService.criarEvento(evento);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(request.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evento> atualizarEvento(@PathVariable long id, @RequestBody Evento evento){
        Evento request = eventoService.atualizarEvento(id, evento);
        return ResponseEntity.ok().body(request);
    }

    @GetMapping
    public ResponseEntity<List<Evento>> listarEventos(){
        List<Evento> request = eventoService.listarEventos();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Evento>> buscarEventoPorId(@PathVariable Long id){
        Optional<Evento> request = eventoService.buscarEventoPorId(id);
        return ResponseEntity.ok().body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarEvento(@PathVariable Long id){
        eventoService.deletarEvento(id);
        return ResponseEntity.noContent().build();
    }
}
