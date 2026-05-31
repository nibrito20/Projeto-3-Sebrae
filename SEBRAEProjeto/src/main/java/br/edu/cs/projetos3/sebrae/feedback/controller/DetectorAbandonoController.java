package br.edu.cs.projetos3.sebrae.feedback.controller;

import br.edu.cs.projetos3.sebrae.feedback.entidades.FluxoAbandonoDTO;
import br.edu.cs.projetos3.sebrae.feedback.service.DetectorAbandonoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/detector-abandono")
@CrossOrigin(originPatterns = "*")
public class DetectorAbandonoController {

    @Autowired
    private DetectorAbandonoService service;

    @GetMapping
    public List<FluxoAbandonoDTO> obterRankingAbandono() {
        return service.gerarRankingAbandono();
    }
}