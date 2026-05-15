package br.edu.cs.projetos3.sebrae.feedback.repository;

import br.edu.cs.projetos3.sebrae.feedback.entidades.MapaDeCalorGrid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MapaDeCalorInterfaceRepo extends JpaRepository<MapaDeCalorGrid, Long> {

	Optional<MapaDeCalorGrid> acharPagEGridXEGridY(String page, Integer gridX, Integer gridY);
	
	List<MapaDeCalorGrid> acharPag(String page);
	
}
