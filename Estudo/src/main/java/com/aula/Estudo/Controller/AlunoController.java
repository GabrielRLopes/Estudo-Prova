package com.aula.Estudo.Controller;

import com.aula.Estudo.Entity.Aluno;
import com.aula.Estudo.Service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public ResponseEntity<Aluno> criarAluno(@RequestBody Aluno aluno){
        Aluno request = alunoService.criarAluno(aluno);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(aluno.getId()).toUri();
        return ResponseEntity.ok().body(request);
    }

    @PutMapping
    public ResponseEntity<Aluno> atualizarAluno(@PathVariable Long id, @RequestBody Aluno aluno){
        Aluno request = alunoService.atualizarAluno(id, aluno);
        return ResponseEntity.ok().body(request);
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> buscarAlunos(){
        List<Aluno> request = alunoService.listarAlunos();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Aluno>> buscarAlunoPorId(@PathVariable Long id){
        Optional<Aluno> request = alunoService.buscarAlunoPorId(id);
        return ResponseEntity.ok().body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarAluno(@PathVariable Long id){
        alunoService.deletarAluno(id);
        return ResponseEntity.noContent().build();
    }
}
