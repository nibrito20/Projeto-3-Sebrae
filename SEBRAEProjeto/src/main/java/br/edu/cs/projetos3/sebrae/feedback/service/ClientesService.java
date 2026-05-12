package br.edu.cs.projetos3.sebrae.feedback.service;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
public class ClientesService {

    public ResponseEntity<String> getClientes() {
        try {
            ClassPathResource resource = new ClassPathResource("data/clients.json");
            String content = new String(resource.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(content);
        } catch (IOException e) {
            return ResponseEntity.internalServerError()
                    .body("{\"erro\": \"Erro ao carregar clientes.\"}");
        }
    }
    
 
    public ResponseEntity<String> getDadosSimulados() {
        try {
            // Lógica correta para ler da pasta resources
            ClassPathResource resource = new ClassPathResource("data/dados_simulados.json");
            String content = new String(resource.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(content);
        } catch (IOException e) {
            // Retorna um JSON de erro para o React não quebrar
            return ResponseEntity.internalServerError()
                    .body("{\"error\": \"Erro ao ler dados_simulados.json\"}");
        }
    }
}