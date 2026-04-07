package com.aula.Estudo.Service;

import com.aula.Estudo.Entity.Paciente;
import com.aula.Estudo.Repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public Paciente criarPaciente(Paciente paciente){
        return pacienteRepository.save(paciente);
    }

    public Paciente atualizarPaciente(Long id, Paciente paciente){
        Paciente pacienteAtualizado = pacienteRepository.findById(id).get();
        pacienteAtualizado.setNome(paciente.getNome());
        pacienteAtualizado.setDoenca(paciente.getDoenca());
        return pacienteRepository.save(pacienteAtualizado);
    }

    public List<Paciente> listarPacientes(){
        return pacienteRepository.findAll();
    }

    public Optional<Paciente> buscarPacientePorId(Long id){
        return pacienteRepository.findById(id);
    }

    public void deletarPaciente(Long id){
        pacienteRepository.deleteById(id);
    }
}
