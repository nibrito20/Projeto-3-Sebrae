package br.edu.cs.projetos3.sebrae.feedback.repository;

import br.edu.cs.projetos3.sebrae.feedback.entidades.MapaDeCalorGrid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MapaDeCalorInterfaceRepo extends JpaRepository<MapaDeCalorGrid, Long> {

    @Query("SELECT m FROM MapaDeCalorGrid m WHERE m.page = :page AND m.gridX = :gridX AND m.gridY = :gridY")
    Optional<MapaDeCalorGrid> acharPagEGridXEGridY(@Param("page") String page, @Param("gridX") Integer gridX, @Param("gridY") Integer gridY);

    @Query("SELECT m FROM MapaDeCalorGrid m WHERE m.page = :page")
    List<MapaDeCalorGrid> acharPag(@Param("page") String page);

}
