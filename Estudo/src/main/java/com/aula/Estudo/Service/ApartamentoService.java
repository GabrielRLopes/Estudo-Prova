package com.aula.Estudo.Service;

import com.aula.Estudo.Entity.Apartamento;
import com.aula.Estudo.Repository.ApartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApartamentoService {

    @Autowired
    private ApartamentoRepository apartamentoRepository;

    public Apartamento criarApartamento(Apartamento apartamento){
        return apartamentoRepository.save(apartamento);
    }

    public Apartamento atualizarApartamento(Long id, Apartamento apartamento){
        Apartamento apartamentoAtualizado = apartamentoRepository.findById(id).get();
        apartamentoAtualizado.setInquilino(apartamento.getInquilino());
        return apartamentoRepository.save(apartamentoAtualizado);
    }

    public List<Apartamento> listarApartamentos(){
        return apartamentoRepository.findAll();
    }

    public Optional<Apartamento> buscarApartamentoPorID(Long id){
        return apartamentoRepository.findById(id);
    }

    public void deletarApartamento(Long id){
        apartamentoRepository.deleteById(id);
    }
}
