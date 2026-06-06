package br.edu.cs.projetos3.sebrae.feedback.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.cs.projetos3.sebrae.feedback.controller.EstatisticasUtil;
import br.edu.cs.projetos3.sebrae.feedback.entidades.Alerta;

@Service
public class MonitoramentoService {

    public Optional<Alerta> analisar(
            double valorAtual,
            List<Double> historico) {

        double media = EstatisticasUtil.calcularMedia(historico);
        double desvio = EstatisticasUtil.calcularDesvioPadrao(historico);

        boolean anomalia =
                EstatisticasUtil.detectarAnomalia(valorAtual, media, desvio);

        if (!anomalia) {
            return Optional.empty();
        }

        Alerta alerta = new Alerta();

        alerta.setDataHora(LocalDateTime.now());
        alerta.setValorDetectado(valorAtual);
        alerta.setMediaHistorica(media);
        alerta.setDesvioPadrao(desvio);

        if (valorAtual < media) {
            alerta.setTipo("QUEDA");
        } else {
            alerta.setTipo("PICO");
        }

        alerta.setDescricao(
                "Comportamento atípico detectado.");

        return Optional.of(alerta);
    }
    
    
    
}