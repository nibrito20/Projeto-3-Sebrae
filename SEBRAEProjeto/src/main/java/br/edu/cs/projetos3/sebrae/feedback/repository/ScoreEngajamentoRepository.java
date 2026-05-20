package br.edu.cs.projetos3.sebrae.feedback.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class ScoreEngajamentoRepository {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<Map<String, Object>> obterDadosSimulados() {
        try {
            InputStream inputStream = getClass().getResourceAsStream("/data/engajamento_dados.json");
            if (inputStream == null) {
                return new ArrayList<>();
            }
            return objectMapper.readValue(inputStream, new TypeReference<List<Map<String, Object>>>() {});
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}