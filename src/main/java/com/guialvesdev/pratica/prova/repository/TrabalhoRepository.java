package com.guialvesdev.pratica.prova.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.guialvesdev.pratica.prova.model.Trabalho;

import java.util.List;


@Repository
public interface TrabalhoRepository extends JpaRepository<Trabalho,Long> {

    @Query("SELECT t FROM Trabalho t WHERE t.titulo LIKE %:titulo% AND t.nota >= :notaMinima")
    List<Trabalho> findBytituloContainingAndNotaGreaterThan(String titulo, Integer notaMinima);



}
