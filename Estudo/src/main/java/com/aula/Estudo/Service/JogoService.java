package com.aula.Estudo.Service;

import com.aula.Estudo.Entity.Jogo;
import com.aula.Estudo.Repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JogoService {

    @Autowired
    private JogoRepository jogoRepository;

    public Jogo criarJogo(Jogo jogo){
        return jogoRepository.save(jogo);
    }

    public Jogo atualizarJogo(Long id, Jogo jogo){
        Jogo jogoAtualizado = jogoRepository.findById(id).get();
        jogoAtualizado.setTitulo(jogo.getTitulo());
        jogoAtualizado.setDataLancamento(jogo.getDataLancamento());;
        return jogoRepository.save(jogoAtualizado);
    }

    public List<Jogo> listarJogos(){
        return jogoRepository.findAll();
    }

    public Optional<Jogo> buscarJogoPorId(Long id){
        return jogoRepository.findById(id);
    }

    public void deletarJogo(Long id){
        jogoRepository.deleteById(id);
    }
}
