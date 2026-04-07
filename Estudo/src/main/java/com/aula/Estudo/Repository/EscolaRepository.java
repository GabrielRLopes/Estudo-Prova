package com.aula.Estudo.Repository;

import com.aula.Estudo.Entity.Escola;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EscolaRepository extends JpaRepository<Escola, Long> {
}
