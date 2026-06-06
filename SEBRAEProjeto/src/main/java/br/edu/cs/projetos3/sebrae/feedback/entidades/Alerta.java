package br.edu.cs.projetos3.sebrae.feedback.entidades;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Alerta {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    private LocalDateTime dataHora;
    private String tipo;
    private Double valorDetectado;
    private Double mediaHistorica;
    private Double desvioPadrao;
    private String descricao;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDateTime getDataHora() {
		return dataHora;
	}
	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Double getValorDetectado() {
		return valorDetectado;
	}
	public void setValorDetectado(Double valorDetectado) {
		this.valorDetectado = valorDetectado;
	}
	public Double getMediaHistorica() {
		return mediaHistorica;
	}
	public void setMediaHistorica(Double mediaHistorica) {
		this.mediaHistorica = mediaHistorica;
	}
	public Double getDesvioPadrao() {
		return desvioPadrao;
	}
	public void setDesvioPadrao(Double desvioPadrao) {
		this.desvioPadrao = desvioPadrao;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
    
	

    
	
	
	
	
}
