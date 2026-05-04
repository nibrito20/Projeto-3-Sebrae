package br.edu.cs.projetos3.sebrae.feedback;

public class Main {
    public static void main(String[] args) {
        SinaisImplicitos analisador = new SinaisImplicitos();
        
        Usuario roberto = new Usuario(4, "Roberto Alves", 155, 0);
        Servico gestao = new Servico(201, "Curso de Gestão Financeira", 500, 280, 45);

        String resultadoUsuario = analisador.analisarEngajamentoUsuario(roberto);
        String resultadoServico = analisador.analisarEficienciaServico(gestao);
        

        System.out.println(resultadoUsuario);
        System.out.println(resultadoServico);
        
    }
}