package br.edu.cs.projetos3.sebrae.feedback.entidades;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Metricas {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime dataHora;

    private Long acessos;

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

	public Long getAcessos() {
		return acessos;
	}

	public void setAcessos(Long acessos) {
		this.acessos = acessos;
	}
    
    
    
}
