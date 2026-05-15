package br.edu.cs.projetos3.sebrae.feedback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.cs.projetos3.sebrae.feedback.entidades.MapaDeCalorGrid;
import br.edu.cs.projetos3.sebrae.feedback.mediator.MapaDeCalorDao;
import br.edu.cs.projetos3.sebrae.feedback.service.ServicoMapaDeCalor;

@RestController
@RequestMapping("/api/heatmap")
public class MapaDeCalorController {

	@Autowired
	
	private ServicoMapaDeCalor service;
	
	@PostMapping("/click")
	public ResponseEntity<Void> registerClick(
			@RequestBody MapaDeCalorDao dao
			) {
		service.registerClick(dao.getPage(), dao.getX(), dao.getY());
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public List<MapaDeCalorGrid> getMapaDeCalor(
			@RequestParam String page
			){
		return service.getMapaDeCalor(page);
	}
	
	
}
