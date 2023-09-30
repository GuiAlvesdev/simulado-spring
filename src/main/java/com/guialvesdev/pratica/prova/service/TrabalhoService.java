package com.guialvesdev.pratica.prova.service;


import com.guialvesdev.pratica.prova.exceptions.ObjectNotFoundException;
import com.guialvesdev.pratica.prova.repository.TrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.guialvesdev.pratica.prova.model.Trabalho;

import java.util.List;
import java.util.Optional;


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



//        diminuir utilizando a classe mapper terceira ou mapear objeto e atributo
//        @Transactional
//        public Trabalho create(Trabalho obj) {
//            ModelMapper modelMapper = new ModelMapper();
//            Trabalho entity = modelMapper.map(obj, Trabalho.class);
//            return trabalhoRepository.save(entity);
//        }
//
//        ou
//
//        List<Trabalho> trabalhos = objList.stream()
//                .map(obj -> new Trabalho(obj.getTitulo(), obj.getDescricao(), /* Outros valores */))
//                .collect(Collectors.toList());
//        trabalhoRepository.saveAll(trabalhos);



    }



    public List<Trabalho> buscarTrabalhosPorPalavraChaveENota(String titulo, Integer notaMinima) {
        return trabalhoRepository.findBytituloContainingAndNotaGreaterThan(titulo, notaMinima);
    }




    // Get all users

    public List<Trabalho> findall() {

        return trabalhoRepository.findAll();
    }


    public Trabalho findById(Long id) {
        Optional<Trabalho> obj = trabalhoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto com ID " + id + " não encontrado."));
    }





}
