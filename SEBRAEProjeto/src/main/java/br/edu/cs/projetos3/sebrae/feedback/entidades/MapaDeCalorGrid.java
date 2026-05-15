package br.edu.cs.projetos3.sebrae.feedback.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class MapaDeCalorGrid {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	private String page;
	private Integer gridX;
	private Integer gridY;
	private Long totalClicks;
	private Long totalMoves;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public Integer getGridX() {
		return gridX;
	}
	public void setGridX(Integer gridX) {
		this.gridX = gridX;
	}
	public Integer getGridY() {
		return gridY;
	}
	public void setGridY(Integer gridY) {
		this.gridY = gridY;
	}
	public Long getTotalClicks() {
		return totalClicks;
	}
	public void setTotalClicks(Long totalClicks) {
		this.totalClicks = totalClicks;
	}
	public Long getTotalMoves() {
		return totalMoves;
	}
	public void setTotalMoves(Long totalMoves) {
		this.totalMoves = totalMoves;
	}
	
	
	

	
}
