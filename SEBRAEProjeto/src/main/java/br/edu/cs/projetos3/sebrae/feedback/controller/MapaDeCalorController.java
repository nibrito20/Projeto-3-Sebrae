package br.edu.cs.projetos3.sebrae.feedback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.cs.projetos3.sebrae.feedback.entidades.MapaDeCalorGrid;
import br.edu.cs.projetos3.sebrae.feedback.service.ServicoMapaDeCalor;

@RestController
@RequestMapping("/api/heatmap")
public class MapaDeCalorController {

    @Autowired
    private ServicoMapaDeCalor service;

    @GetMapping
    public ResponseEntity<List<MapaDeCalorGrid>> getMapaDeCalor(
            @RequestParam String page
    ) {
        return ResponseEntity.ok(service.getMapaDeCalor(page));
    }
}