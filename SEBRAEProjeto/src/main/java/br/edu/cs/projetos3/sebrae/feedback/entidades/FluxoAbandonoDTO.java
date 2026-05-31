package br.edu.cs.projetos3.sebrae.feedback.entidades;

public class FluxoAbandonoDTO {
    
    private String paginaFluxo;
    private int totalEntradas;
    private int totalAbandonos;
    private String periodo;
    private String tipoUsuario;
    private String canal;
    
    private double taxaAbandonoPercentual;
    private String indicadorVisual; 

    public FluxoAbandonoDTO(String paginaFluxo, int totalEntradas, int totalAbandonos, String periodo, String tipoUsuario, String canal) {
        this.paginaFluxo = paginaFluxo;
        this.totalEntradas = totalEntradas;
        this.totalAbandonos = totalAbandonos;
        this.periodo = periodo;
        this.tipoUsuario = tipoUsuario;
        this.canal = canal;
    }

    public void setTaxaAbandonoPercentual(double taxaAbandonoPercentual) {
        this.taxaAbandonoPercentual = taxaAbandonoPercentual;
    }

    public void setIndicadorVisual(String indicadorVisual) {
        this.indicadorVisual = indicadorVisual;
    }

    public String getPaginaFluxo() { return paginaFluxo; }
    public int getTotalEntradas() { return totalEntradas; }
    public int getTotalAbandonos() { return totalAbandonos; }
    public String getPeriodo() { return periodo; }
    public String getTipoUsuario() { return tipoUsuario; }
    public String getCanal() { return canal; }
    public double getTaxaAbandonoPercentual() { return taxaAbandonoPercentual; }
    public String getIndicadorVisual() { return indicadorVisual; }
}