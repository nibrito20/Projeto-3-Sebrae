package br.edu.cs.projetos3.sebrae.feedback.entidades;

public class EngajamentoDTO {
    
    private String clienteId;
    private double scoreFinal;
    private String nivel;
    private double frequencia;
    private double profundidade;
    private double reuso;

    public EngajamentoDTO(String clienteId, double scoreFinal, String nivel, double frequencia, double profundidade, double reuso) {
        this.clienteId = clienteId;
        this.scoreFinal = scoreFinal;
        this.nivel = nivel;
        this.frequencia = frequencia;
        this.profundidade = profundidade;
        this.reuso = reuso;
    }

    public String getClienteId() { return clienteId; }
    public double getScoreFinal() { return scoreFinal; }
    public String getNivel() { return nivel; }
    public double getFrequencia() { return frequencia; }
    public double getProfundidade() { return profundidade; }
    public double getReuso() { return reuso; }
}