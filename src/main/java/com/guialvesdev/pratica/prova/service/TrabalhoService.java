package com.guialvesdev.pratica.prova.service;


import com.guialvesdev.pratica.prova.repository.TrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.guialvesdev.pratica.prova.model.Trabalho;

import java.util.List;


@Service
public class TrabalhoService {



    @Autowired
    private TrabalhoRepository trabalhoRepository;



    @Transactional
    public Trabalho create(Trabalho obj) {
        Trabalho entity = new Trabalho();
        entity.setTitulo(obj.getTitulo());
        entity.setDescricao(obj.getDescricao());
        entity.setGrupo(obj.getGrupo());
        entity.setNota(obj.getNota());
        entity.setDataHoraEntrega(obj.getDataHoraEntrega());
        entity.setJustificativa(obj.getJustificativa());
        return trabalhoRepository.save(entity);





    }



    public List<Trabalho> buscarTrabalhosPorPalavraChaveENota(String titulo, Integer notaMinima) {
        return trabalhoRepository.findBytituloContainingAndNotaGreaterThan(titulo, notaMinima);
    }




    // Get all users

    public List<Trabalho> findall() {

        return trabalhoRepository.findAll();
    }






}
