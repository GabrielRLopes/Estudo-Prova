package com.aula.Estudo.Repository;

import com.aula.Estudo.Entity.Apartamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApartamentoRepository extends JpaRepository<Apartamento, Long> {
}
