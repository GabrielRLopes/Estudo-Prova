package com.aula.Estudo.Controller;

import com.aula.Estudo.Entity.Escola;
import com.aula.Estudo.Service.EscolaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/escola")
public class EscolaController {
    
    @Autowired
    private EscolaService escolaService;

    @PostMapping
    public ResponseEntity<Escola> criarEscola(@RequestBody Escola escola){
        Escola request = escolaService.criarEscola(escola);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(escola.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Escola> atualizarEscola(@PathVariable Long id, @RequestBody Escola escola){
        Escola request = escolaService.atualizarEscola(id, escola);
        return ResponseEntity.ok().body(request);
    }

    @GetMapping
    public ResponseEntity<List<Escola>> listarEscolas(){
        List<Escola> request = escolaService.listarEscolas();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Escola>> buscarEscolaPorId(@PathVariable Long id){
        Optional<Escola> request = escolaService.buscarEscolaPorId(id);
        return ResponseEntity.ok().body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarEscola(@PathVariable Long id){
        escolaService.deletarEscola(id);
        return ResponseEntity.noContent().build();
    }
}
