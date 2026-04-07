package com.aula.Estudo.Controller;

import com.aula.Estudo.Entity.Carro;
import com.aula.Estudo.Service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/carro")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @PostMapping
    public ResponseEntity<Carro> criarCarro(@RequestBody Carro carro){
        Carro request = carroService.criarCarro(carro);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(carro.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @PutMapping
    public ResponseEntity<Carro> AtualizarCarro(@PathVariable Long id, @RequestBody Carro carro){
        Carro request = carroService.atualizarCarro(id, carro);
        return ResponseEntity.ok().body(request);
    }

    @GetMapping
    public ResponseEntity<List<Carro>> listarCarros(){
        List<Carro> request = carroService.listarCarros();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Carro>> buscarCarroPorId(@PathVariable Long id){
        Optional<Carro> request = carroService.buscarCarroPorId(id);
        return ResponseEntity.ok().body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarCarro(@PathVariable Long id){
        carroService.deletarCarro(id);
        return ResponseEntity.noContent().build();
    }
}
