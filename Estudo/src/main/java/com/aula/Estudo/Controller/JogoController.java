package com.aula.Estudo.Controller;

import com.aula.Estudo.Entity.Jogo;
import com.aula.Estudo.Service.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/jogo")
public class JogoController {

    @Autowired
    private JogoService jogoService;

    @PostMapping
    public ResponseEntity<Jogo> criarJogo(@RequestBody Jogo jogo){
        Jogo request = jogoService.criarJogo(jogo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(request.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jogo> atualizarJogo(@PathVariable Long id, @RequestBody Jogo jogo){
        Jogo request = jogoService.atualizarJogo(id, jogo);
        return ResponseEntity.ok().body(request);
    }

    @GetMapping
    public ResponseEntity<List<Jogo>> listarJogos(){
        List<Jogo> request = jogoService.listarJogos();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Jogo>> buscarJogoPorId(@PathVariable Long id){
        Optional<Jogo> request = jogoService.buscarJogoPorId(id);
        return ResponseEntity.ok().body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarJogo(@PathVariable Long id){
        jogoService.deletarJogo(id);
        return ResponseEntity.noContent().build();
    }
}
