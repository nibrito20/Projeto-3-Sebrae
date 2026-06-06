package br.edu.cs.projetos3.sebrae.feedback.entidades;

import java.time.LocalDateTime;

public class MetricaAlerta {

    private LocalDateTime dataHora;
    private Double valor;
    
	public LocalDateTime getDataHora() {
		return dataHora;
	}
	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
    
    
	
}
