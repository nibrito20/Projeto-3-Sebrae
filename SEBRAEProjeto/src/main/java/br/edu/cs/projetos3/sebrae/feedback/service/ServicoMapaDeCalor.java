package br.edu.cs.projetos3.sebrae.feedback.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Service;
import br.edu.cs.projetos3.sebrae.feedback.entidades.MapaDeCalorGrid;

@Service
public class ServicoMapaDeCalor {

    public List<MapaDeCalorGrid> getMapaDeCalor(String page) {
        Map<String, MapaDeCalorGrid> mapaPontos = new HashMap<>();
        long proximoId = 1;

        long semente = (page != null) ? page.hashCode() : 12345L;
        Random rand = new Random(semente);

        int qtdEpicentros = 55 + rand.nextInt(20); 

        for (int i = 0; i < qtdEpicentros; i++) {
            
            int centroX = 8 + rand.nextInt(22);   
            int centroY = rand.nextInt(220);  

            int intensidadeBase = 50 + rand.nextInt(45); 

            for (int dx = -3; dx <= 3; dx++) {
                for (int dy = -3; dy <= 3; dy++) {
                    int x = centroX + dx;
                    int y = centroY + dy;

                    if (x < 0 || x > 50 || y < 0 || y > 220) continue; 

                    int distancia = Math.abs(dx) + Math.abs(dy);
                    long cliquesDestePonto = 0;

                    if (distancia == 0) {
                        cliquesDestePonto = intensidadeBase;                
                    } else if (distancia == 1) {
                        cliquesDestePonto = (long) (intensidadeBase * 0.5); 
                    } else {
                        cliquesDestePonto = (long) (intensidadeBase * 0.15); 
                    }

                    if (cliquesDestePonto < 4) continue;

                    String chave = x + "-" + y;
                    MapaDeCalorGrid pontoAtual = mapaPontos.get(chave);

                    if (pontoAtual == null) {
                        pontoAtual = new MapaDeCalorGrid();
                        pontoAtual.setId(proximoId++);
                        pontoAtual.setPage(page);
                        pontoAtual.setGridX(x);
                        pontoAtual.setGridY(y);
                        pontoAtual.setTotalClicks(cliquesDestePonto);
                        pontoAtual.setTotalMoves(cliquesDestePonto * 3);
                        mapaPontos.put(chave, pontoAtual);
                    } else {
                        pontoAtual.setTotalClicks(pontoAtual.getTotalClicks() + cliquesDestePonto);
                    }
                }
            }
        }

        return new ArrayList<>(mapaPontos.values());
    }
}