package br.edu.cs.projetos3.sebrae.feedback.entidades;

public class Servico {
	private int id;
    private String nome;
    private int totalIniciados;
    private int totalAbandonados;
    private int tempoMedioMinutos;

    public Servico(int id, String nome, int totalIniciados, int totalAbandonados, int tempoMedioMinutos) {
        this.id = id;
        this.nome = nome;
        this.totalIniciados = totalIniciados;
        this.totalAbandonados = totalAbandonados;
        this.tempoMedioMinutos = tempoMedioMinutos;
    }
    
    public int getId() { return id; }
    public String getNome() { return nome; }
    public int getTotalIniciados() { return totalIniciados; }
    public int getTotalAbandonados() { return totalAbandonados; }
    public int getTempoMedioMinutos() { return tempoMedioMinutos; }
}
