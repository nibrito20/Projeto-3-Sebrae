package br.edu.cs.projetos3.sebrae.feedback;

public class SinaisImplicitos {

    public String analisarEngajamentoUsuario(Usuario usuario) {
        if (usuario.getDiasDesdeUltimoAcesso() > 90) {
            return "ALERTA DE CHURN (Baixo Valor Percebido): O usuário " + usuario.getNome() + 
                   " não retorna há " + usuario.getDiasDesdeUltimoAcesso() + 
                   " dias. Ação sugerida: Enviar e-mail de reengajamento.";
        } else {
            return "Usuário " + usuario.getNome() + " está com engajamento saudável.";
        }
    }

    public String analisarEficienciaServico(Servico servico) {
        double taxaAbandono = ((double) servico.getTotalAbandonados() / servico.getTotalIniciados()) * 100;
        
        boolean demoraExacerbada = servico.getTempoMedioMinutos() > 40;
        boolean altoAbandono = taxaAbandono > 30.0;

        if (demoraExacerbada && altoAbandono) {
            return "FEEDBACK IMPLÍCITO NEGATIVO: Serviço '" + servico.getNome() + 
                   "'. Motivo: Demora exacerbada (" + servico.getTempoMedioMinutos() + 
                   " min) e alta taxa de abandono (" + String.format("%.1f", taxaAbandono) + "%).";
        }
        
        return "Serviço '" + servico.getNome() + "' está com métricas saudáveis.";
    }
}