package br.edu.cs.projetos3.sebrae.analiseconclusao;

public class UXScoreService {

    // fórmula final: UX Score = (score de conclusão × 0.25)
    public double calcularUXScore(ServiceFunnel funnel) {
        double scoreConclusao = funnel.calcularScoreConclusao();
        return scoreConclusao * 0.25; 
    }

    // método Main feito aqui apenas para apresentar essa funcionalidade de forma isolada
    public static void main(String[] args) {
        UXScoreService uxService = new UXScoreService();
        
        // dados de exemplo (mock-"teste") baseados na descrição
        ServiceFunnel inscricaoCurso = new ServiceFunnel("Inscrição em Curso", 1000, 730);
        ServiceFunnel solicitacaoConsultoria = new ServiceFunnel("Solicitação de Consultoria", 500, 455);
        
        System.out.println("=== VISÃO GERAL: ANÁLISE DE CONCLUSÃO DE SERVIÇOS ===\n");
        
        // simulação 1: inscrição em curso (73% -> Nota 7.3)
        exibirDemonstracao(inscricaoCurso, uxService);
        
        System.out.println("-----------------------------------------------------");
        
        // simulação 2: consultoria (91% -> Nota 9.1)
        exibirDemonstracao(solicitacaoConsultoria, uxService);
    }

    // método auxiliar apenas para imprimir no console de forma bonita na hora de apresentar, mas pode estar na Main depois
    private static void exibirDemonstracao(ServiceFunnel funnel, UXScoreService uxService) {
        System.out.println("Funil do Serviço: " + funnel.getNomeServico());
        System.out.printf("Taxa de Conclusão: %.1f%%\n", funnel.calcularTaxaConclusao());
        System.out.printf("Score de Conclusão (0-10): %.2f\n", funnel.calcularScoreConclusao());
        
        double uxScoreContribution = uxService.calcularUXScore(funnel);
        System.out.printf("Peso aplicado para o UX Score Geral (25%%): %.2f\n", uxScoreContribution);
    }
}