package com.guialvesdev.pratica.prova.controller;


import com.guialvesdev.pratica.prova.service.TrabalhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.guialvesdev.pratica.prova.model.Trabalho;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/trabalho")
public class TrabalhoController {



    @Autowired
    private TrabalhoService trabalhoService;


    // Create a new user
    @PostMapping("/create")
    public ResponseEntity<Trabalho> create(@RequestBody Trabalho obj){
        obj = trabalhoService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }


    @GetMapping("/getAll")
    public List<Trabalho> getAllUsers() {
        return trabalhoService.findall();
    }


    @GetMapping
    public List<Trabalho> buscarTrabalhosPorPalavraChaveENota(
            @RequestParam String titulo,
            @RequestParam Integer notaMinima) {
        return trabalhoService.buscarTrabalhosPorPalavraChaveENota(titulo, notaMinima);
    }



    @GetMapping(value = "/{id}")
    public ResponseEntity<Trabalho> buscarporid(@PathVariable Long id){
        Trabalho obj = trabalhoService.findById(id);
        return ResponseEntity.ok().body(obj);

    }



}
