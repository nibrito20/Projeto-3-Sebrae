package br.edu.cs.projetos3.sebrae.feedback.controller;

import java.util.List;

public class AnaliseRequest {

    private Double valorAtual;
    private List<Double> historico;

    public Double getValorAtual() {
        return valorAtual;
    }

    public void setValorAtual(Double valorAtual) {
        this.valorAtual = valorAtual;
    }

    public List<Double> getHistorico() {
        return historico;
    }

    public void setHistorico(List<Double> historico) {
        this.historico = historico;
    }
}