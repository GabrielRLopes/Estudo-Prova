package com.aula.Estudo.Service;

import com.aula.Estudo.Entity.Carro;
import com.aula.Estudo.Repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public Carro criarCarro(Carro carro){
        return carroRepository.save(carro);
    }

    public Carro atualizarCarro(Long id, Carro carro){
        Carro carroAtualizado = carroRepository.findById(id).get();
        carroAtualizado.setMarca(carro.getMarca());
        carroAtualizado.setModelo(carro.getModelo());
        carroAtualizado.setAno(carro.getAno());
        return carroRepository.save(carroAtualizado);
    }

    public List<Carro> listarCarros(){
        return carroRepository.findAll();
    }

    public Optional<Carro> buscarCarroPorId(Long id){
        return carroRepository.findById(id);
    }

    public void deletarCarro(Long id){
        carroRepository.deleteById(id);
    }
}
