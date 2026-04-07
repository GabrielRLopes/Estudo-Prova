package com.aula.Estudo.Service;

import com.aula.Estudo.Entity.Evento;
import com.aula.Estudo.Repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    public Evento criarEvento(Evento evento){
        return eventoRepository.save(evento);
    }

    public Evento atualizarEvento(Long id, Evento evento){
        Evento eventoAtualizado = eventoRepository.findById(id).get();
        eventoAtualizado.setNome(evento.getNome());
        eventoAtualizado.setQndParticipantes(evento.getQndParticipantes());
        eventoAtualizado.setData(evento.getData());
        return eventoRepository.save(eventoAtualizado);
    }

    public List<Evento> listarEventos(){
        return eventoRepository.findAll();
    }

    public Optional<Evento> buscarEventoPorId(Long id){
        return eventoRepository.findById(id);
    }

    public void deletarEvento(Long id){
        eventoRepository.deleteById(id);
    }
}
