package com.aula.Estudo.Controller;

import com.aula.Estudo.Entity.Contrato;
import com.aula.Estudo.Service.ContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/contrato")
public class ContratoController {

    @Autowired
    private ContratoService contratoService;

    @PostMapping
    public ResponseEntity<Contrato> criarContrato(@RequestBody Contrato contrato){
        Contrato request = contratoService.criarContrato(contrato);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(contrato.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Contrato> atualizarContrato(@PathVariable Long id, @RequestBody Contrato contrato){
        Contrato request = contratoService.atualizarContrato(id, contrato);
        return ResponseEntity.ok().body(request);
    }

    @GetMapping
    public ResponseEntity<List<Contrato>> listarContratos(){
        List<Contrato> request = contratoService.listarContratos();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Contrato>> buscarContratoPorId(@PathVariable Long id){
        Optional<Contrato> request = contratoService.buscarContratoPorId(id);
        return ResponseEntity.ok().body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarContrato(@PathVariable Long id){
        contratoService.deletarContrato(id);
        return ResponseEntity.noContent().build();
    }
}
