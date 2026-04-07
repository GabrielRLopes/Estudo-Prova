package com.aula.Estudo.Controller;

import com.aula.Estudo.Entity.Livro;
import com.aula.Estudo.Service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping
    public ResponseEntity<Livro> criarLivro(@RequestBody Livro livro){
        Livro request = livroService.criarLivro(livro);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(livro.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @PutMapping
    public ResponseEntity<Livro> atualizarLivro(@PathVariable Long id, @RequestBody Livro livro){
        Livro request = livroService.atualizarLivro(id, livro);
        return ResponseEntity.ok().body(request);
    }

    @GetMapping
    public ResponseEntity<List<Livro>> listarLivros(){
        List<Livro> request = livroService.listarLivros();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Livro>> buscarLivroPorId(@PathVariable Long id){
        Optional<Livro> request = livroService.buscarLivroPorId(id);
        return ResponseEntity.ok().body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarLivro(@PathVariable Long id){
        livroService.deletarLivro(id);
        return ResponseEntity.noContent().build();
    }
}
