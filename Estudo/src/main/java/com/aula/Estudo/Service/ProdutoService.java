package com.aula.Estudo.Service;

import com.aula.Estudo.Entity.Produto;
import com.aula.Estudo.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto criarProduto(Produto produto){
        return produtoRepository.save(produto);
    }

    public Produto atualizarProduto(Long id, Produto produto){
        Produto produtoAtualizado = produtoRepository.findById(id).get();
        produtoAtualizado.setNome(produto.getNome());
        produtoAtualizado.setValor(produto.getValor());
        produtoAtualizado.setStatus(produto.getStatus());
        return produtoRepository.save(produtoAtualizado);
    }

    public List<Produto> listarProdutos(){
        return produtoRepository.findAll();
    }

    public Optional<Produto> buscarProdutoPorId(Long id){
        return produtoRepository.findById(id);
    }

    public void deletarProduto(Long id){
        produtoRepository.deleteById(id);
    }
}

