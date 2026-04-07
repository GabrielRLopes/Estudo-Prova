package com.aula.Estudo.Service;

import com.aula.Estudo.Entity.Aluno;
import com.aula.Estudo.Repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno criarAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public Aluno atualizarAluno(Long id, Aluno aluno) {
        Aluno alunoAtualizado = alunoRepository.findById(id).get();
        alunoAtualizado.setName(aluno.getName());
        return alunoRepository.save(alunoAtualizado);
    }

    public List<Aluno> listarAlunos() {
        return alunoRepository.findAll();
    }

    public Optional<Aluno> buscarAlunoPorId(Long id) {
        return alunoRepository.findById(id);
    }

    public void deletarAluno(Long id) {
        alunoRepository.deleteById(id);
    }


}
