package br.edu.cs.projetos3.sebrae.feedback.controller;

import org.springframework.web.bind.annotation.*;

import br.edu.cs.projetos3.sebrae.feedback.service.MonitoramentoService;

@RestController
@RequestMapping("/monitoramento")
public class MonitoramentoController {

    private final MonitoramentoService monitoramentoService;

    public MonitoramentoController(MonitoramentoService monitoramentoService) {
        this.monitoramentoService = monitoramentoService;
    }

    @PostMapping("/analisar")
    public Object analisar(@RequestBody AnaliseRequest request) {

        return monitoramentoService.analisar(
                request.getValorAtual(),
                request.getHistorico()
        );
    }
}
