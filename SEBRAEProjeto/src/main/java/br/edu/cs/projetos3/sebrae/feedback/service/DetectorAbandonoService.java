package br.edu.cs.projetos3.sebrae.feedback.service;

import br.edu.cs.projetos3.sebrae.feedback.entidades.FluxoAbandonoDTO;
import br.edu.cs.projetos3.sebrae.feedback.repository.DetectorAbandonoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DetectorAbandonoService {

    @Autowired
    private DetectorAbandonoRepository repository;

    public List<FluxoAbandonoDTO> gerarRankingAbandono() {
        List<Map<String, Object>> dadosBrutos = repository.lerDadosAbandono();
        List<FluxoAbandonoDTO> listaProcessada = new ArrayList<>();

        if (dadosBrutos != null) {
            for (Map<String, Object> dado : dadosBrutos) {
                String pagina = (String) dado.get("paginaFluxo");
                int entradas = ((Number) dado.get("totalEntradas")).intValue();
                int abandonos = ((Number) dado.get("totalAbandonos")).intValue();
                String periodo = (String) dado.get("periodo");
                String tipoUsuario = (String) dado.get("tipoUsuario");
                String canal = (String) dado.get("canal");

                FluxoAbandonoDTO dto = new FluxoAbandonoDTO(pagina, entradas, abandonos, periodo, tipoUsuario, canal);

                double taxa = ((double) abandonos / entradas) * 100;
                
                taxa = Math.round(taxa * 100.0) / 100.0;
                dto.setTaxaAbandonoPercentual(taxa);

                if (taxa >= 50.0) {
                    dto.setIndicadorVisual("VERMELHO"); 
                } else if (taxa >= 20.0) {
                    dto.setIndicadorVisual("AMARELO"); 
                } else {
                    dto.setIndicadorVisual("VERDE");
                }

                listaProcessada.add(dto);
            }
        }

        return listaProcessada.stream()
                .sorted(Comparator.comparingDouble(FluxoAbandonoDTO::getTaxaAbandonoPercentual).reversed())
                .collect(Collectors.toList());
    }
}