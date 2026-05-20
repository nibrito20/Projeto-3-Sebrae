package br.edu.cs.projetos3.sebrae.feedback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.edu.cs.projetos3.sebrae.feedback.entidades.EngajamentoDTO;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ScoreEngajamentoController {

    @Autowired
    private br.edu.cs.projetos3.sebrae.feedback.mediator.ScoreEngajamentoService service;

    @GetMapping("/engajamento")
    public List<EngajamentoDTO> getRanking() {
        return service.obterRankingEngajamento();
    }
}