package br.edu.cs.projetos3.sebrae.feedback.entidades;

public class Servico {
    private int id;
    private String nome;
    private int totalIniciados;
    private int totalConcluidos;
    private int totalAbandonados;
    private int tempoMedioMinutos;
    private double taxaConclusao;

    public Servico() {}

    public Servico(int id, String nome, int totalIniciados, int totalConcluidos, int totalAbandonados, int tempoMedioMinutos) {
        this.id = id;
        this.nome = nome;
        this.totalIniciados = totalIniciados;
        this.totalConcluidos = totalConcluidos;
        this.totalAbandonados = totalAbandonados;
        this.tempoMedioMinutos = tempoMedioMinutos;
        this.taxaConclusao = calcularTaxa();
    }
    
    public double calcularTaxa() {
        if (this.totalIniciados == 0) return 0.0;
        return ((double) this.totalConcluidos / this.totalIniciados) * 100;
    }
    
    public int getId() { return id; }
    public String getNome() { return nome; }
    public int getTotalIniciados() { return totalIniciados; }
    public int getTotalConcluidos() { return totalConcluidos; }
    public int getTotalAbandonados() { return totalAbandonados; }
    public int getTempoMedioMinutos() { return tempoMedioMinutos; }
    
    public double getTaxaConclusao() {
        if (this.totalIniciados == 0) return 0.0;
        return (double) this.totalConcluidos / this.totalIniciados * 100;
    }

    public void setId(int id) { this.id = id; }
    public void setNome(String nome) { this.nome = nome; }
    public void setTotalIniciados(int totalIniciados) { this.totalIniciados = totalIniciados; }
    public void setTotalConcluidos(int totalConcluidos) { this.totalConcluidos = totalConcluidos; }
    public void setTotalAbandonados(int totalAbandonados) { this.totalAbandonados = totalAbandonados; }
    public void setTempoMedioMinutos(int tempoMedioMinutos) { this.tempoMedioMinutos = tempoMedioMinutos; }

}