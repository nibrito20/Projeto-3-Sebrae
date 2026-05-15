package br.edu.cs.projetos3.sebrae.feedback.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.cs.projetos3.sebrae.feedback.entidades.MapaDeCalorGrid;
import br.edu.cs.projetos3.sebrae.feedback.repository.MapaDeCalorInterfaceRepo;

@Service
public class ServicoMapaDeCalor {

	private static final int CELL_SIZE = 50;
	
	@Autowired
	
	private MapaDeCalorInterfaceRepo repo;
	
	public void registerClick(
            String page,
            Integer x,
            Integer y
    ) {

        int gridX = x / CELL_SIZE;
        int gridY = y / CELL_SIZE;

        MapaDeCalorGrid cell = repo.acharPagEGridXEGridY(page, gridX, gridY).orElseGet(() -> { 
                	
                	MapaDeCalorGrid g = new MapaDeCalorGrid();
                    g.setPage(page);
                    g.setGridX(gridX);
                    g.setGridY(gridY);
                    g.setTotalClicks(0L);
                    g.setTotalMoves(0L);

                    return g;
         });

        cell.setTotalClicks(
                cell.getTotalClicks() + 1
        );

        repo.save(cell);
	
	}
	
	public List<MapaDeCalorGrid> getMapaDeCalor(String page){
		return repo.acharPag(page);
	}
	
	
	
	
}
