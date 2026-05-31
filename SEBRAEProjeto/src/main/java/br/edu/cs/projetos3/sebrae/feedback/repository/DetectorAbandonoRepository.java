package br.edu.cs.projetos3.sebrae.feedback.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

@Repository
public class DetectorAbandonoRepository {

    public List<Map<String, Object>> lerDadosAbandono() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = getClass().getResourceAsStream("/data/abandono_dados.json");
            return mapper.readValue(inputStream, new TypeReference<List<Map<String, Object>>>() {});
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}