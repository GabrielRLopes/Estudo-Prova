package com.aula.Estudo.Service;

import com.aula.Estudo.Entity.Contrato;
import com.aula.Estudo.Repository.ContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContratoService {

    @Autowired
    private ContratoRepository contratoRepository;

    public Contrato criarContrato(Contrato contrato){
        return contratoRepository.save(contrato);
    }

    public Contrato atualizarContrato(Long id, Contrato contrato){
        Contrato contratoAtualizado = contratoRepository.findById(id).get();
        contratoAtualizado.setNumeroContrato(contrato.getNumeroContrato());
        contratoAtualizado.setNumeroParticipantes(contrato.getNumeroParticipantes());
        return contratoRepository.save(contratoAtualizado);
    }

    public List<Contrato> listarContratos(){
        return contratoRepository.findAll();
    }

    public Optional<Contrato> buscarContratoPorId(Long id){
        return contratoRepository.findById(id);
    }

    public void deletarContrato(Long id){
        contratoRepository.deleteById(id);
    }
}
