package br.edu.cs.projetos3.sebrae.feedback.entidades;

public class Usuario {
	private int id;
    private String nome;
    private int diasDesdeUltimoAcesso;
    private int tempoMedioSessaoMinutos;
    
    public Usuario(int id, String nome, int diasDesdeUltimoAcesso, int tempoMedioSessaoMinutos) {
        this.id = id;
        this.nome = nome;
        this.diasDesdeUltimoAcesso = diasDesdeUltimoAcesso;
        this.tempoMedioSessaoMinutos = tempoMedioSessaoMinutos;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public int getDiasDesdeUltimoAcesso() { return diasDesdeUltimoAcesso; }
    public int getTempoMedioSessaoMinutos() { return tempoMedioSessaoMinutos; }
}
