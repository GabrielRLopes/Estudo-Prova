package com.aula.Estudo.Controller;

import com.aula.Estudo.Entity.Paciente;
import com.aula.Estudo.Service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<Paciente> criarPaciente(@RequestBody Paciente paciente){
        Paciente request = pacienteService.criarPaciente(paciente);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(request.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> atualizarPaciente(@PathVariable Long id, @RequestBody Paciente paciente){
        Paciente request = pacienteService.atualizarPaciente(id, paciente);
        return ResponseEntity.ok().body(request);
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> listarPacientes(){
        List<Paciente> request = pacienteService.listarPacientes();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Paciente>> buscarPacientePorId(@PathVariable Long id){
        Optional<Paciente> request = pacienteService.buscarPacientePorId(id);
        return ResponseEntity.ok().body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarPaciente(@PathVariable Long id){
        pacienteService.deletarPaciente(id);
        return ResponseEntity.noContent().build();
    }
}
