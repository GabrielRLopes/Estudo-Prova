package com.aula.Estudo.Service;

import com.aula.Estudo.Entity.Escola;
import com.aula.Estudo.Repository.EscolaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EscolaService {

    @Autowired
    private EscolaRepository escolaRepository;

    public Escola criarEscola(Escola escola){
        return escolaRepository.save(escola);
    }

    public Escola atualizarEscola(Long id, Escola escola){
        Escola escolaAtualizada = escolaRepository.findById(id).get();
        escolaAtualizada.setNome(escola.getNome());
        escolaAtualizada.setCidade(escola.getCidade());
        escolaAtualizada.setNumero(escola.getNumero());
        return escolaRepository.save(escolaAtualizada);
    }

    public List<Escola> listarEscolas(){
        return escolaRepository.findAll();
    }

    public Optional<Escola> buscarEscolaPorId(Long id){
        return escolaRepository.findById(id);
    }

    public void deletarEscola(Long id){
        escolaRepository.deleteById(id);
    }


}
