package com.aula.Estudo.Controller;

import com.aula.Estudo.Entity.Apartamento;
import com.aula.Estudo.Service.ApartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/apartamento")
public class ApartamentoController {

    @Autowired
    private ApartamentoService apartamentoService;

    @PostMapping
    public ResponseEntity<Apartamento> criarApartamento(@RequestBody Apartamento apartamento){
        Apartamento request = apartamentoService.criarApartamento(apartamento);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(apartamento.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @PutMapping
    public ResponseEntity<Apartamento> atualizarApartamento(@PathVariable Long id, @RequestBody Apartamento apartamento){
        Apartamento request = apartamentoService.atualizarApartamento(id, apartamento);
        return ResponseEntity.ok().body(request);
    }

    @GetMapping
    public ResponseEntity<List<Apartamento>> buscarApartamento(){
        List<Apartamento> request = apartamentoService.listarApartamentos();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Apartamento>> buscarApartamentoPorId(@PathVariable Long id){
        Optional<Apartamento> request = apartamentoService.buscarApartamentoPorID(id);
        return ResponseEntity.ok().body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarApartamento(@PathVariable Long id){
        apartamentoService.deletarApartamento(id);
        return ResponseEntity.noContent().build();
    }
}
