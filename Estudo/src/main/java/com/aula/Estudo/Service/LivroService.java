package com.aula.Estudo.Service;

import com.aula.Estudo.Entity.Livro;
import com.aula.Estudo.Repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public Livro criarLivro(Livro livro){
        return livroRepository.save(livro);
    }

    public Livro atualizarLivro(Long id, Livro livro){
        Livro livroAtualizado = livroRepository.findById(id).get();
        livroAtualizado.setAutor(livro.getAutor());
        livroAtualizado.setDataPub(livro.getDataPub());
        return livroRepository.save(livroAtualizado);
    }

    public List<Livro> listarLivros(){
        return livroRepository.findAll();
    }

    public Optional<Livro> buscarLivroPorId(Long id){
        return livroRepository.findById(id);
    }

    public void deletarLivro(Long id){
        livroRepository.deleteById(id);
    }
}
