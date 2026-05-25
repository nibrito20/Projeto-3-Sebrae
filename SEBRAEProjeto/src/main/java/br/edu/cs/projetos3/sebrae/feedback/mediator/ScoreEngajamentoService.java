package br.edu.cs.projetos3.sebrae.feedback.mediator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.cs.projetos3.sebrae.feedback.entidades.EngajamentoDTO;
import br.edu.cs.projetos3.sebrae.feedback.repository.ScoreEngajamentoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ScoreEngajamentoService {

    @Autowired
    private ScoreEngajamentoRepository repository;

    public List<EngajamentoDTO> obterRankingEngajamento() {
        List<Map<String, Object>> dadosBrutos = repository.obterDadosSimulados();
        List<EngajamentoDTO> listaCustomizada = new ArrayList<>();

        for (Map<String, Object> dado : dadosBrutos) {
            String clienteId = dado.get("clienteId") != null ? dado.get("clienteId").toString() : "";
            double frequencia = ((Number) dado.get("frequencia")).doubleValue();
            double profundidade = ((Number) dado.get("profundidade")).doubleValue();
            double reuso = ((Number) dado.get("reuso")).doubleValue();

            double scoreFinal = (frequencia * 0.40) + (profundidade * 0.30) + (reuso * 0.30);
            
            String nivel = classificarNivel(scoreFinal);

            listaCustomizada.add(new EngajamentoDTO(clienteId, scoreFinal, nivel, frequencia, profundidade, reuso));
        }

        return listaCustomizada.stream()
                .sorted((d1, d2) -> Double.compare(d2.getScoreFinal(), d1.getScoreFinal()))
                .collect(Collectors.toList());
    }

    private String classificarNivel(double scoreFinal) {
        if (scoreFinal >= 8.0) return "ALTO";
        if (scoreFinal >= 5.0) return "MEDIO";
        return "BAIXO";
    }
}