package com.aula.Estudo.Repository;

import com.aula.Estudo.Entity.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<Carro, Long> {
}
