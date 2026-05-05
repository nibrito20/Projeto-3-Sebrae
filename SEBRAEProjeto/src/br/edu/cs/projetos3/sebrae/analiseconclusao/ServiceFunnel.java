package br.edu.cs.projetos3.sebrae.analiseconclusao;

public class ServiceFunnel {
    private String nomeServico;
    private int usuariosIniciaram;
    private int usuariosConcluiram;

    public ServiceFunnel(String nomeServico, int usuariosIniciaram, int usuariosConcluiram) {
        this.nomeServico = nomeServico;
        this.usuariosIniciaram = usuariosIniciaram;
        this.usuariosConcluiram = usuariosConcluiram;
    }

    // métrica: taxa de conclusão = (concluíram / iniciaram) * 100
    public double calcularTaxaConclusao() {
        if (usuariosIniciaram == 0) return 0.0;
        return ((double) usuariosConcluiram / usuariosIniciaram) * 100.0;
    }

    // conversão: score de conclusão = taxa / 10
    public double calcularScoreConclusao() {
        return calcularTaxaConclusao() / 10.0;
    }

    public String getNomeServico() {
        return nomeServico;
    }
}