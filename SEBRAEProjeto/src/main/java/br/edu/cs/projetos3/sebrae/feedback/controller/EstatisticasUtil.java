package br.edu.cs.projetos3.sebrae.feedback.controller;

import java.util.List;

public class EstatisticasUtil {

	public static double calcularMedia(List<Double> valores) {
        return valores.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);
    }

    public static double calcularDesvioPadrao(List<Double> valores) {
        double media = calcularMedia(valores);

        double somaQuadrados = valores.stream()
                .mapToDouble(v -> Math.pow(v - media, 2))
                .sum();

        return Math.sqrt(somaQuadrados / valores.size());
    }
	
	
    public static boolean detectarAnomalia(
	        double valorAtual,
	        double media,
	        double desvioPadrao) {

	    double limiteSuperior = media + (2 * desvioPadrao);
	    double limiteInferior = media - (2 * desvioPadrao);

	    return valorAtual > limiteSuperior ||
	           valorAtual < limiteInferior;
	}
    
    
}
